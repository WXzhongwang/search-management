package com.rany.service.component.utils;


import com.rany.service.component.meta.dto.*;
import com.rany.service.component.metric.ClusterMetricCounter;
import com.rany.service.component.metric.ProjectMetricCounter;
import com.rany.service.component.metric.TemplateMetricCounter;
import com.rany.service.platform.meta.*;

import java.util.ArrayList;

/**
 * 类型转换
 *
 * @author tutu
 */
public class MetaUtility {

    private MetaUtility() {
    }

    public static ClusterInfo build(ClusterMetaData meta, ClusterMetricCounter counter) {
        if (meta == null) {
            return null;
        }
        ArrayList<NodeInfo> nodes = new ArrayList<NodeInfo>();
        for (NodeMeta node : meta.nodeMetaList) {
            nodes.add(NodeInfo.newBuilder()
                    .setName(node.name)
                    .setIpAddress(node.ipAddress)
                    .setIsMaster(node.isMaster)
                    .setCpuPercent(node.cpuUsage)
                    .setRamMax(node.ramMax)
                    .setRamCurrent(node.ramCurrent)
                    .setHeapMax(node.heapMax)
                    .setHeapCurrent(node.heapCurrent)
                    .setDiskAvail(node.diskAvail)
                    .setDiskPercent(node.diskUsage)
                    .setGroup(node.group)
                    .build());
        }
        return ClusterInfo.newBuilder()
                .setName(meta.clusterName)
                .setEndpoint(meta.clusterAddress)
                .setInternalEndpoint(meta.clusterInternalAddress)
                .setType(meta.clusterType)
                .setDescription(meta.clusterDesc)
                .setCreateTime(meta.gmtCreate.getTime())
                .setLastUpdateTime(meta.gmtModified.getTime())
                .setStatus(meta.clusterStatus)
                .setTotalProjectNumber(meta.projectMetaMap.size())
                .setClusterHealth(meta.clusterHealth)
                .setEsVersion(meta.esVersion)
                .setTotalTemplateNumber(counter.totalTemplate)
                .setTotalIndexNumber(counter.totalIndex)
                .setTotalDocNumber(counter.totalDocs)
                .setTotalDataSize(counter.totalDataSize)
                .addAllNodes(nodes).build();
    }

    public static ProjectInfo build(ProjectMetaData meta, ProjectMetricCounter counter) {
        if (meta == null) {
            return null;
        }
        return ProjectInfo.newBuilder()
                .setName(meta.projectName)
                .setClusterName(meta.clusterName)
                .setDescription(meta.projectDesc)
                .setTotalTemplateNumber(counter.totalTemplate)
                .setTotalIndexNumber(counter.totalIndex)
                .setTotalDocNumber(counter.totalDocs)
                .setTotalDataSize(counter.totalDataSize)
                .build();
    }


    public static IndexTemplateInfo build(String clusterName, String projectName, IndexTemplateMetaData meta,  TemplateMetricCounter counter) {
        if (meta == null) {
            return null;
        }
        return IndexTemplateInfo.newBuilder()
                .setName(meta.templateName)
                .setCluster(clusterName)
                .setProject(projectName)
                .setMapping(meta.mappings)
                .setSetting(meta.settings)
                .addAllAliases(meta.aliasList)
                .setAutoIndexRollingPolicy(meta.autoIndexRollingPolicy)
                .setAutoIndexRollingWindow(meta.autoIndexRollingWindow)
                .setAutoIndexNamePrefix(meta.autoIndexNamePrefix)
                .setTotalIndexNumber(counter.totalIndex)
                .setTotalDocNumber(counter.totalDocs)
                .setTotalDataSize(counter.totalDataSize)
                .build();
    }

    public static IndexInfo build(String clusterName, String projectName, String templateName, IndexMetaData meta) {
        if (meta == null) {
            return null;
        }
        return IndexInfo.newBuilder()
                .setName(meta.name)
                .setClusterName(clusterName)
                .setMapping(meta.mapping)
                .setSetting(meta.setting)
                .addAllAliases(meta.aliases)
                .setProjectName(projectName)
                .setTemplate(templateName)
                .setTotalDocNumber(meta.docs)
                .setTotalDataSize(meta.totalData)
                .setPrimaryShardNumber(meta.primaryShards)
                .setReplicaShardNumber(meta.replicaShards)
                .setIndexHealth(meta.health)
                .build();
    }




    public static String combineFullIndexName(String projectName, String indexGroupName, String indexName) {
        return projectName + "." + indexGroupName + "." + indexName;
    }

    public static String combineFullAliasName(String projectName, String indexGroupName, String aliasName) {
        return projectName + "." + indexGroupName + "." + aliasName;
    }

    public static String getAliasName(String fullAliasName) {
        String[] parts = fullAliasName.split("\\.");
        if (parts.length == 3) {
            return parts[2];
        } else {
            return "";
        }
    }

}
