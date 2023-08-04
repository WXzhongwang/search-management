package com.rany.service.component.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import com.rany.service.common.constants.Constants;
import com.rany.service.common.exception.ErrorCodeEnum;
import com.rany.service.common.exception.SearchManagementException;
import com.rany.service.common.toolkit.CalculateUtils;
import com.rany.service.component.meta.dto.ClusterMetaData;
import com.rany.service.component.meta.dto.IndexMetaData;
import com.rany.service.component.meta.dto.NodeMeta;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.cluster.metadata.AliasMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

/**
 * AdvancedEsClient
 *
 * @author zhongshengwang
 * @description AdvancedEsClient
 * @date
 * @email 18668485565@163.com
 */
public class AdvancedEsClient {

    private static final Logger logger = LoggerFactory.getLogger(AdvancedEsClient.class);

    private final String endpoint;
    private final RestClient lowLevelClient;
    private final RestHighLevelClient highLevelClient;
    public static final String ES_DOMAIN_SETTINGS_FIELD = "index.routing.allocation.require.domain";
    public static final String ES_GROUP_SETTINGS_FIELD = "index.routing.allocation.require.group";
    private static final int ES_OPERATION_RETRY_TIME = 3;

    public AdvancedEsClient(String endpoint) {
        this.endpoint = endpoint;
        RestClientBuilder builder = RestClient.builder(HttpHost.create(this.endpoint));
        this.lowLevelClient = builder.build();
        this.highLevelClient = new RestHighLevelClient(builder);
    }


    public void close() {
        try {
            if (lowLevelClient != null) {
                lowLevelClient.close();
            }
        } catch (Exception e) {
            logger.error("Fail to close ElasticSearchClient with message: {}.", e.getMessage());
        }
    }

    public ClusterMetaData getClusterMeta() {
        ClusterMetaData metaData = new ClusterMetaData();
        Response response = null;
        try {
            // health
            response = lowLevelClient.performRequest(new Request("GET", "/_cluster/health"));
            HttpEntity outputEntity = response.getEntity();
            String result = EntityUtils.toString(outputEntity);
            metaData.clusterHealth = JSON.parseObject(result).getString("status");

            // version
            response = lowLevelClient.performRequest(new Request("GET", "/"));
            outputEntity = response.getEntity();
            result = EntityUtils.toString(outputEntity);
            metaData.esVersion = JSON.parseObject(result).getString("version");

            // node attribute
            HashMap<String, String> nodeGroupMap = new HashMap<>();
            response = lowLevelClient.performRequest(new Request("GET", "/_cat/nodeattrs?h=name,attr,value"));
            outputEntity = response.getEntity();
            result = EntityUtils.toString(outputEntity);
            String[] lines = result.split("\n");
            for (String line : lines) {
                String[] columns = line.split(" ");
                int columnIndex = 0;
                String nodeName = null;
                String attrName = null;
                String attrValue = null;
                for (String column : columns) {
                    if (column.equalsIgnoreCase("")) {
                        continue;
                    }
                    switch (columnIndex) {
                        case 0:
                            nodeName = column;
                            break;
                        case 1:
                            attrName = column;
                            break;
                        case 2:
                            attrValue = column;
                            break;
                        default:
                            break;
                    }
                    columnIndex++;
                }
                if (attrName != null && attrValue != null && attrName.equals("group")) {
                    nodeGroupMap.put(nodeName, attrValue);
                }
            }

            Request request = new Request(
                    "GET",
                    "/_cat/nodes?h=name,ip,master,cpu,ram.max,ram.current,heap.max,heap.current,disk.avail,disk.used_percent");
            request.setOptions(RequestOptions.DEFAULT.toBuilder().addHeader("connection", "keep-alive"));
            response = lowLevelClient.performRequest(request);
            outputEntity = response.getEntity();
            result = EntityUtils.toString(outputEntity);
            lines = result.split("\n");
            if (lines.length != 0) {
                metaData.nodeMetaList.clear();
            }

            for (String line : lines) {
                String[] columns = line.split(" ");
                int columnIndex = 0;
                NodeMeta nodeMeta = new NodeMeta();
                for (String column : columns) {
                    if (column.equalsIgnoreCase("")) {
                        continue;
                    }
                    switch (columnIndex) {
                        case 0:
                            nodeMeta.name = column;
                            break;
                        case 1:
                            nodeMeta.ipAddress = column;
                            break;
                        case 2:
                            nodeMeta.isMaster = "*".equalsIgnoreCase(column);
                            break;
                        case 3:
                            nodeMeta.cpuUsage = Double.parseDouble(column);
                            break;
                        case 4:
                            nodeMeta.ramMax = column;
                            break;
                        case 5:
                            nodeMeta.ramCurrent = column;
                            break;
                        case 6:
                            nodeMeta.heapMax = column;
                            break;
                        case 7:
                            nodeMeta.heapCurrent = column;
                            break;
                        case 8:
                            nodeMeta.diskAvail = column;
                            break;
                        case 9:
                            nodeMeta.diskUsage = Double.parseDouble(column);
                            break;
                        default:
                            break;
                    }
                    columnIndex++;
                }
                nodeMeta.group = nodeGroupMap.getOrDefault(nodeMeta.name, "");
                metaData.nodeMetaList.add(nodeMeta);
            }

        } catch (IOException e) {
            throw new SearchManagementException(ErrorCodeEnum.CLUSTER_STATUS_ERROR.getCode(), e.getMessage(), e);
        }
        return metaData;
    }

    public IndexMetaData acquireIndexSchema(String fullIndexName) {
        IndexMetaData tmpMeta = new IndexMetaData();
        try {
            Response response = lowLevelClient.performRequest(new Request(
                    "GET",
                    "/" + fullIndexName));
            HttpEntity outputEntity = response.getEntity();
            JSONObject outputJson = JSON.parseObject(EntityUtils.toString(outputEntity));
            JSONObject indexJson = outputJson.getJSONObject(fullIndexName);
            tmpMeta.aliases = new ArrayList<>();
            String aliasesJson = indexJson.getString(Constants.ALIASES);
            if (aliasesJson != null && !aliasesJson.isEmpty()) {
                JSONObject aliasesObj = JSON.parseObject(aliasesJson);
                for (Map.Entry<String, Object> entry : aliasesObj.entrySet()) {
                    tmpMeta.aliases.add(entry.getKey());
                }
            }
            tmpMeta.mapping = indexJson.getString(Constants.MAPPING);
            tmpMeta.setting = indexJson.getString(Constants.SETTING);
        } catch (Exception e) {
            logger.error("Fail to call acquire index schema from es cluster {}.", endpoint, e);
            throw new SearchManagementException(ErrorCodeEnum.CLUSTER_STATUS_ERROR.getCode(), e.getMessage(), e);
        }
        return tmpMeta;
    }

    public List<IndexMetaData> acquireIndexInfo() {
        List<IndexMetaData> metaList = new ArrayList<>();
        try {
            Response response = lowLevelClient.performRequest(new Request(
                    "GET",
                    "/_cat/indices/?h=index,health,pri,rep,docs.count,store.size"));
            HttpEntity outputEntity = response.getEntity();
            String result = EntityUtils.toString(outputEntity);
            String[] lines = result.split("\n");
            for (String line : lines) {
                IndexMetaData tmpMeta = new IndexMetaData();
                String[] columns = line.split(" ");
                int columnIndex = 0;
                for (String column : columns) {
                    if (column.equalsIgnoreCase("")) {
                        continue;
                    }
                    switch (columnIndex) {
                        case 0:
                            tmpMeta.fullName = column;
                            break;
                        case 1:
                            tmpMeta.health = column;
                            break;
                        case 2:
                            tmpMeta.primaryShards = Integer.parseInt(column);
                            break;
                        case 3:
                            tmpMeta.replicaShards = Integer.parseInt(column);
                            break;
                        case 4:
                            tmpMeta.docs = Integer.parseInt(column);
                            break;
                        case 5:
                            tmpMeta.totalData = CalculateUtils.getDataSizeBytes(column);
                            break;
                    }
                    columnIndex++;
                }
                if (columnIndex > 5) {
                    // Fix the bug when index is closed or deleted from es cluster directly which bypass meta service;
                    // In that case tmpMeta is not valid;
                    metaList.add(tmpMeta);
                }
            }
        } catch (Exception e) {
            logger.error("Fail to call acquire index info from es cluster: {}.", endpoint, e);
        }
        return metaList;
    }

    public IndexMetaData acquireIndexInfo(String fullIndexName) {
        IndexMetaData tmpMeta = new IndexMetaData();

        try {
            Response response = lowLevelClient.performRequest(new Request(
                    "GET",
                    "/_cat/indices/" + fullIndexName + "?h=health,pri,rep,docs.count,store.size"));
            HttpEntity outputEntity = response.getEntity();
            String result = EntityUtils.toString(outputEntity);
            String[] lines = result.split("\n");
            if (lines.length != 1) {
                throw new SearchManagementException(ErrorCodeEnum.INDEX_STATUS_ERROR.getCode(), ErrorCodeEnum.INDEX_STATUS_ERROR.getMessage());
            }
            String[] columns = lines[0].split(" ");
            int columnIndex = 0;
            for (String column : columns) {
                if (column.equalsIgnoreCase("")) {
                    continue;
                }
                switch (columnIndex) {
                    case 0:
                        tmpMeta.health = column;
                        break;
                    case 1:
                        tmpMeta.primaryShards = Integer.parseInt(column);
                        break;
                    case 2:
                        tmpMeta.replicaShards = Integer.parseInt(column);
                        break;
                    case 3:
                        tmpMeta.docs = Integer.parseInt(column);
                        break;
                    case 4:
                        tmpMeta.totalData = CalculateUtils.getDataSizeBytes(column);
                        break;
                }
                columnIndex++;
            }
        } catch (Exception e) {
            logger.error("Fail to call acquire index info from es cluster {}.", endpoint, e);
            throw new SearchManagementException(ErrorCodeEnum.INDEX_STATUS_ERROR.getCode(), ErrorCodeEnum.INDEX_STATUS_ERROR.getMessage());
        }
        return tmpMeta;
    }

    public boolean checkIndexExist(String fullIndexName) {
        boolean result = false;
        try {
            Response response = lowLevelClient.performRequest(new Request(
                    "GET",
                    "/" + fullIndexName));
            HttpEntity outputEntity = response.getEntity();
            JSONObject outputJson = JSON.parseObject(EntityUtils.toString(outputEntity));
            String outputString = outputJson.toJSONString();
            if (outputString.contains(fullIndexName)) {
                result = true;
            }
        } catch (Exception e) {
            if (e.getMessage().contains("error") &&
                    e.getMessage().contains("index_not_found_exception")) {
                result = false;
            }
        }
        return result;
    }

    public void createIndex(String fullIndexName, List<String> aliases, String mappings, String settings) {
        try {
            JSONObject aliasesNode = new JSONObject();
            for (String alias : aliases) {
                aliasesNode.put(alias, new JSONObject());
            }
            JSONObject indexJson = new JSONObject();
            if (aliasesNode.size() > 0) {
                indexJson.put(Constants.ALIASES, aliasesNode);
            }
            indexJson.put(Constants.SETTING, JSON.parseObject(settings));
            indexJson.put(Constants.MAPPING, JSON.parseObject(mappings));
            HttpEntity inputEntity = new NStringEntity(indexJson.toJSONString(), ContentType.APPLICATION_JSON);
            Request request = new Request("PUT", "/" + fullIndexName);
            request.setEntity(inputEntity);
            request.addParameter("pretty", "true");
            lowLevelClient.performRequest(request);
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.CREATE_INDEX_ERROR.getCode(), e.getMessage());
        }
    }

    public void updateIndex(String fullIndexName, String mappings, String settings, List<String> aliases) {
        try {
            if (mappings != null) {
                HttpEntity inputEntity = new NStringEntity(mappings, ContentType.APPLICATION_JSON);
                Request request = new Request("PUT", "/" + fullIndexName + "/_mapping");
                request.setEntity(inputEntity);
                request.addParameter("pretty", "true");
                Response response = lowLevelClient.performRequest(request);
                HttpEntity outputEntity = response.getEntity();
            }

            if (settings != null) {
                HttpEntity inputEntity = new NStringEntity(settings, ContentType.APPLICATION_JSON);
                Request request = new Request("PUT", "/" + fullIndexName + "/_settings");
                request.setEntity(inputEntity);
                request.addParameter("pretty", "true");
                Response response = lowLevelClient.performRequest(request);
                HttpEntity outputEntity = response.getEntity();
            }

            // update index alias
            if(aliases.size() != 0){
                GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
                getAliasesRequest.indices(fullIndexName);
                Set<String> preAliasSet = Sets.newHashSet();
                Collection<Set<AliasMetadata>> metaSets = highLevelClient.indices().getAlias(getAliasesRequest,RequestOptions.DEFAULT)
                        .getAliases().values();
                if(metaSets.size() == 1) {
                    metaSets.forEach(multiMetaSet -> {
                        multiMetaSet.stream().forEach(aliasMetaData -> {
                            preAliasSet.add(aliasMetaData.alias());
                        });
                    });

                    IndicesAliasesRequest aliasesRequest = new IndicesAliasesRequest();
                    // add alias if pre alias not exists
                    aliases.stream().forEach(alias -> {
                        if (!preAliasSet.contains(alias)) {
                            IndicesAliasesRequest.AliasActions addActions = IndicesAliasesRequest.AliasActions
                                    .add().index(fullIndexName).alias(alias);
                            aliasesRequest.addAliasAction(addActions);
                        }
                    });
                    //remove alias if new alias not exists
                    preAliasSet.stream().forEach(alias -> {
                        if (!aliases.contains(alias)) {
                            IndicesAliasesRequest.AliasActions deleteActions = IndicesAliasesRequest.AliasActions
                                    .remove().index(fullIndexName).alias(alias);
                            aliasesRequest.addAliasAction(deleteActions);
                        }
                    });
                    if(aliasesRequest.getAliasActions().size() > 0){
                        highLevelClient.indices().updateAliases(aliasesRequest, RequestOptions.DEFAULT);
                    }
                }
            }

        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UPDATE_INDEX_ERROR.getCode(), e.getMessage());
        }
    }

    public void deleteIndex(String fullIndexName) {
        try {
            Request request = new Request("DELETE", "/" + fullIndexName);
            request.addParameter("pretty", "true");
            Response response = lowLevelClient.performRequest(request);
            HttpEntity outputEntity = response.getEntity();
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.DELETE_INDEX_ERROR.getCode(), e.getMessage());
        }
    }

    public void checkHealth() {
        try {
            lowLevelClient.performRequest(new Request("GET", "/"));
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.CHECK_STATUS_ERROR.getCode(), e.getMessage(), e);
        }
    }

    public GetSettingsResponse acquireIndexSettings() {
        int retryTime = 0;
        String errMessage = "";
        GetSettingsResponse response = null;
        while (retryTime < ES_OPERATION_RETRY_TIME) {
            try {
                if (retryTime > 0) {
                    Thread.sleep(10 * retryTime);
                    // Sleep before retry;
                }
                GetSettingsRequest getSettingsRequest = new GetSettingsRequest();
                getSettingsRequest.indices("*");
                response = highLevelClient.indices().getSettings(getSettingsRequest, RequestOptions.DEFAULT);
                break;
            } catch (Exception e) {
                errMessage = String.format("Fail to call acquireIndexSettings from es cluster [%s] with message [%s].", endpoint, e.getMessage());
                logger.error("Fail to call acquireIndexSettings from es cluster {} with message {} and exception {}. Retry time: {}.", endpoint, e.getMessage(), e.toString(), retryTime);
                retryTime ++;
            }
        }
        if (retryTime == ES_OPERATION_RETRY_TIME) {
            throw new SearchManagementException(ErrorCodeEnum.INTERNAL_ERROR.getCode(), errMessage);
        }
        return response;
    }
}
