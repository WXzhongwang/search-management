package com.rany.service.component.es;

import com.google.common.collect.Lists;
import com.rany.service.component.meta.dto.ClusterMetaData;
import com.rany.service.component.meta.dto.IndexMetaData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public class AdvancedEsClientTest {

    private AdvancedEsClient advancedEsClient;

    @Before
    public void setUp() throws Exception {
        advancedEsClient = new AdvancedEsClient("localhost:9200");
    }

    @After
    public void tearDown() throws Exception {
        if (advancedEsClient != null) {
            advancedEsClient.close();
        }
    }

    @Test
    public void getClusterInfo() {
        ClusterMetaData clusterInfo = advancedEsClient.getClusterMeta();
        Assert.assertNotNull(clusterInfo);
    }

    @Test
    public void getIndexSchema() {
        IndexMetaData indexMetaData = advancedEsClient.acquireIndexSchema("animals");
        Assert.assertNotNull(indexMetaData);
    }

    @Test
    public void getIndices() {
        List<IndexMetaData> indexMetaData = advancedEsClient.acquireIndexInfo();
        Assert.assertNotNull(indexMetaData);
    }

    @Test
    public void getIndex() {
        IndexMetaData indexMetaData = advancedEsClient.acquireIndexInfo("products");
        Assert.assertNotNull(indexMetaData);
    }

    @Test
    public void checkIndexExist() {
        boolean exist = advancedEsClient.checkIndexExist("products");
        Assert.assertTrue(exist);

        boolean notExist = advancedEsClient.checkIndexExist("not_exist_index");
        Assert.assertFalse(notExist);
    }

    @Test
    public void createIndex() {
        String indexName = "test_index_create";
        advancedEsClient.createIndex(indexName, Lists.newArrayList("tic"), null, null);
    }

    @Test
    public void updateIndex() {
        String indexName = "test_index_create";
        String mappings = "{\"properties\":{\"_class\":{\"type\":\"text\",\"fields\":{\"keyword\":{\"type\":\"keyword\",\"ignore_above\":256}}},\"description\":{\"type\":\"text\",\"fields\":{\"keyword\":{\"type\":\"keyword\",\"ignore_above\":256}}},\"id\":{\"type\":\"long\"},\"name\":{\"type\":\"text\",\"fields\":{\"keyword\":{\"type\":\"keyword\",\"ignore_above\":256}}},\"price\":{\"type\":\"float\"},\"create_timestamp\":{\"type\":\"long\"}}}";
        advancedEsClient.updateIndex(indexName, mappings, null);
    }

    @Test
    public void deleteIndex() {
        String indexName = "test_index_create";
        advancedEsClient.deleteIndex(indexName);
    }

    @Test
    public void checkHealth() {
        advancedEsClient.checkHealth();
    }
}