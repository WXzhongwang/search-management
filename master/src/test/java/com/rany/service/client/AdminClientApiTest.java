package com.rany.service.client;

import com.google.common.collect.Lists;
import com.rany.service.client.rpc.request.*;
import com.rany.service.platform.meta.AutoIndexRollingPolicy;
import com.rany.service.platform.meta.ClusterInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringBootTest(classes = MasterServiceApplication.class)
public class AdminClientApiTest {

    private static final String master = "localhost";
    private static AdminClient client;

    @Before
    public void setUp() throws Exception {
        client = new AdminClient(master, 8080, 40000);
        client.init();
    }


    @After
    public void tearDown() throws Exception {
        client.shutdown();
    }

    @Test
    public void getCluster() {
        ClusterGetRequest clusterGetRequest = new ClusterGetRequest();
        clusterGetRequest.setName("localhost");
        ClusterInfo cluster = client.getCluster(clusterGetRequest);
        Assert.assertEquals("localhost", cluster.getName());
    }


    @Test
    public void createCluster() {
        ClusterCreateRequest clusterCreateRequest = new ClusterCreateRequest();
        clusterCreateRequest.setName("dev");
        clusterCreateRequest.setDesc("本地开发环境");
        clusterCreateRequest.setAddress("127.0.0.1:9200");
        clusterCreateRequest.setInternalAddress("127.0.0.1:9200");
        clusterCreateRequest.setStatus("IN_SERVICE");
        clusterCreateRequest.setType("HHD");
        client.createCluster(clusterCreateRequest);
    }


    @Test
    public void createProject() {
        ProjectCreateRequest projectCreateRequest = new ProjectCreateRequest();
        projectCreateRequest.setCluster("localhost");
        projectCreateRequest.setName("graph");
        projectCreateRequest.setDesc("knowledge graph");
        client.createProject(projectCreateRequest);
    }

    @Test
    public void createIndexTemplate() {
        IndexTemplateCreateRequest indexTemplateCreateRequest = new IndexTemplateCreateRequest();
        indexTemplateCreateRequest.setName("test_template");
        indexTemplateCreateRequest.setProjectName("graph");
        indexTemplateCreateRequest.setMapping("{}");
        indexTemplateCreateRequest.setSetting("{}");
        indexTemplateCreateRequest.setAutoIndexNamePrefix("test_template");
        indexTemplateCreateRequest.setAutoIndexRollingPolicy(AutoIndexRollingPolicy.DAY.name());
        indexTemplateCreateRequest.setAutoIndexRollingWindow(1);
        indexTemplateCreateRequest.setAliases(Lists.newArrayList("mock_template_index"));
        client.createIndexTemplate(indexTemplateCreateRequest);
    }


    @Test
    public void createIndex() {
        IndexCreateRequest indexTemplateCreateRequest = new IndexCreateRequest();
        indexTemplateCreateRequest.setName("test_template_index");
        indexTemplateCreateRequest.setProject("graph");
        indexTemplateCreateRequest.setTemplate("test_template");
        indexTemplateCreateRequest.setMapping("{}");
        indexTemplateCreateRequest.setSetting("{}");
        client.createIndex(indexTemplateCreateRequest);
    }
}