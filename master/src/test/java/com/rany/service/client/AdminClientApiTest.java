package com.rany.service.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.rany.service.client.rpc.request.*;
import com.rany.service.platform.meta.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

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
        clusterCreateRequest.setType("HDD");
        client.createCluster(clusterCreateRequest);
    }


    @Test
    public void deleteCluster() {
        ClusterCreateRequest clusterCreateRequest = new ClusterCreateRequest();
        clusterCreateRequest.setName("dev-copy");
        clusterCreateRequest.setDesc("本地开发环境");
        clusterCreateRequest.setAddress("127.0.0.1:9200");
        clusterCreateRequest.setInternalAddress("127.0.0.1:9200");
        clusterCreateRequest.setStatus("IN_SERVICE");
        clusterCreateRequest.setType("HDD");
        client.createCluster(clusterCreateRequest);


        ClusterDeleteRequest clusterDeleteRequest = new ClusterDeleteRequest();
        clusterDeleteRequest.setName("dev-copy");
        client.deleteCluster(clusterDeleteRequest);

    }


    @Test
    public void updateCluster() {
        ClusterUpdateRequest clusterUpdateRequest = new ClusterUpdateRequest();
        clusterUpdateRequest.setName("dev");
        clusterUpdateRequest.setDesc("本地开发环境01");
        clusterUpdateRequest.setAddress("127.0.0.1:9200");
        clusterUpdateRequest.setInternalAddress("127.0.0.1:9200");
        clusterUpdateRequest.setStatus("IN_SERVICE");
        clusterUpdateRequest.setType("HDD");
        client.updateCluster(clusterUpdateRequest);
    }


    @Test
    public void listCluster() {
        ClusterListRequest clusterListRequest = new ClusterListRequest();
        List<String> strings = client.listCluster(clusterListRequest);
        Assert.assertTrue(strings.contains("localhost"));
    }

    @Test
    public void listClusterDetails() {
        ClusterListRequest clusterListRequest = new ClusterListRequest();
        List<ClusterInfo> clusters = client.listClusterDetails(clusterListRequest);
        Assert.assertFalse(clusters.isEmpty());
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
    public void getProject() {
        ProjectGetRequest projectGetRequest = new ProjectGetRequest();
        projectGetRequest.setName("graph");
        ProjectInfo project = client.getProject(projectGetRequest);
        Assert.assertEquals("graph", project.getName());
    }


    @Test
    public void updateProject() {
        ProjectUpdateRequest projectUpdateRequest = new ProjectUpdateRequest();
        projectUpdateRequest.setName("graph");
        projectUpdateRequest.setCluster("localhost");
        projectUpdateRequest.setDesc("kg graph desc");
        client.updateProject(projectUpdateRequest);

        ProjectGetRequest projectGetRequest = new ProjectGetRequest();
        projectGetRequest.setName("graph");
        ProjectInfo project = client.getProject(projectGetRequest);

        Assert.assertEquals("kg graph desc", project.getDescription());
    }

    @Test
    public void listProject() {
        ProjectListRequest projectListRequest = new ProjectListRequest();
        projectListRequest.setCluster("localhost");
        List<String> projects = client.listProject(projectListRequest);
        Assert.assertTrue(projects.contains("graph"));
    }

    @Test
    public void listProjectDetails() {
        ProjectListRequest projectListRequest = new ProjectListRequest();
        projectListRequest.setCluster("localhost");
        List<ProjectInfo> projects = client.listProjectDetails(projectListRequest);
        Assert.assertFalse(projects.isEmpty());
        List<String> collect = projects.stream().map(ProjectInfo::getName).collect(Collectors.toList());
        Assert.assertTrue(collect.contains("graph"));
    }

    @Test
    public void deleteProject() {
        ProjectCreateRequest projectCreateRequest = new ProjectCreateRequest();
        projectCreateRequest.setCluster("localhost");
        projectCreateRequest.setName("graph-copy");
        projectCreateRequest.setDesc("knowledge graph copy");
        client.createProject(projectCreateRequest);
        ProjectDeleteRequest projectDeleteRequest = new ProjectDeleteRequest();
        projectDeleteRequest.setName("graph-copy");
        client.deleteProject(projectDeleteRequest);
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
    public void updateIndexTemplate() {
        IndexTemplateUpdateRequest templateUpdateRequest = new IndexTemplateUpdateRequest();
        templateUpdateRequest.setName("test_template");
        templateUpdateRequest.setProjectName("graph");
        templateUpdateRequest.setMapping("{}");
        templateUpdateRequest.setSetting("{}");
        templateUpdateRequest.setAutoIndexNamePrefix("test_template");
        templateUpdateRequest.setAutoIndexRollingPolicy(AutoIndexRollingPolicy.DAY.name());
        templateUpdateRequest.setAutoIndexRollingWindow(1);
        templateUpdateRequest.setAliases(Lists.newArrayList("mock_template_index1", "mock_template_2"));
        client.updateIndexTemplate(templateUpdateRequest);
    }


    @Test
    public void getIndexTemplate() {
        IndexTemplateGetRequest indexTemplateGetRequest = new IndexTemplateGetRequest();
        indexTemplateGetRequest.setName("test_template");
        indexTemplateGetRequest.setProjectName("graph");
        IndexTemplateInfo indexTemplate = client.getIndexTemplate(indexTemplateGetRequest);
        Assert.assertEquals("test_template", indexTemplate.getName());
    }


    @Test
    public void deleteIndexTemplate() {
        IndexTemplateCreateRequest indexTemplateCreateRequest = new IndexTemplateCreateRequest();
        indexTemplateCreateRequest.setName("test_template_testing");
        indexTemplateCreateRequest.setProjectName("graph");
        indexTemplateCreateRequest.setMapping("{}");
        indexTemplateCreateRequest.setSetting("{}");
        indexTemplateCreateRequest.setAutoIndexNamePrefix("delete_template_for_test");
        indexTemplateCreateRequest.setAutoIndexRollingPolicy(AutoIndexRollingPolicy.NONE.name());
        indexTemplateCreateRequest.setAutoIndexRollingWindow(1);
        indexTemplateCreateRequest.setAliases(Lists.newArrayList("deleted"));
        client.createIndexTemplate(indexTemplateCreateRequest);


        IndexTemplateDeleteRequest indexTemplateDeleteRequest = new IndexTemplateDeleteRequest();
        indexTemplateDeleteRequest.setName("test_template_testing");
        indexTemplateDeleteRequest.setProjectName("graph");
        client.deleteIndexTemplate(indexTemplateDeleteRequest);
    }


    @Test
    public void listIndexTemplate() {
        IndexTemplateListRequest indexTemplateListRequest = new IndexTemplateListRequest();
        indexTemplateListRequest.setProjectName("graph");
        List<String> templateNames = client.listIndexTemplate(indexTemplateListRequest);
        Assert.assertFalse(templateNames.isEmpty());
        Assert.assertEquals(templateNames.size(), 5);

        IndexTemplateListRequest indexTemplateListDetailsRequest = new IndexTemplateListRequest();
        indexTemplateListDetailsRequest.setProjectName("graph");
        List<IndexTemplateInfo> templates = client.listIndexTemplateDetails(indexTemplateListDetailsRequest);
        Assert.assertFalse(templates.isEmpty());
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


    @Test
    public void getIndex() {
        IndexGetRequest indexGetRequest = new IndexGetRequest();
        indexGetRequest.setProject("graph");
        indexGetRequest.setTemplate("test_template");
        indexGetRequest.setName("test_template-20230811");
        IndexInfo index = client.getIndex(indexGetRequest);
        Assert.assertEquals(index.getName(), "test_template-20230811");
    }

    @Test
    public void deleteIndex() {
        IndexCreateRequest indexCreateRequest = new IndexCreateRequest();
        indexCreateRequest.setProject("graph");
        indexCreateRequest.setTemplate("test_template_testing");
        indexCreateRequest.setName("index_xyz");
        indexCreateRequest.setMapping(mappings().toJSONString());
        indexCreateRequest.setSetting(settings().toJSONString());
        client.createIndex(indexCreateRequest);


        IndexDeleteRequest indexDeleteRequest = new IndexDeleteRequest();
        indexDeleteRequest.setProject("graph");
        indexDeleteRequest.setTemplate("test_template_testing");
        indexDeleteRequest.setName("index_xyz");

        client.deleteIndex(indexDeleteRequest);
    }


    @Test
    public void updateIndex() {
        IndexUpdateRequest indexUpdateRequest = new IndexUpdateRequest();
        indexUpdateRequest.setProject("graph");
        indexUpdateRequest.setTemplate("test_template_for_delete");
        indexUpdateRequest.setName("test_template_for_delete-20230815");
        indexUpdateRequest.setMapping(newMapping().toJSONString());
        client.updateIndex(indexUpdateRequest);
    }

    @Test
    public void listIndex() {
        IndexListRequest indexUpdateRequest = new IndexListRequest();
        indexUpdateRequest.setCluster("localhost");
        indexUpdateRequest.setProject("graph");
        indexUpdateRequest.setTemplate("test_template_for_delete");
        List<String> indexNames = client.listIndex(indexUpdateRequest);
        Assert.assertFalse(indexNames.isEmpty());
    }

    @Test
    public void listIndexDetails() {
        IndexListDetailsRequest indexUpdateRequest = new IndexListDetailsRequest();
        indexUpdateRequest.setCluster("localhost");
        indexUpdateRequest.setProject("graph");
        indexUpdateRequest.setTemplate("test_template_for_delete");
        List<IndexInfo> indexNames = client.listIndexDetails(indexUpdateRequest);
        Assert.assertFalse(indexNames.isEmpty());
    }

    @Test
    public void listIndexName() {
        IndexListNameRequest indexUpdateRequest = new IndexListNameRequest();
        indexUpdateRequest.setCluster("localhost");
        List<IndexNameEntry> indexNames = client.listIndexName(indexUpdateRequest);
        Assert.assertFalse(indexNames.isEmpty());
    }

    @Test
    public void listIndexAlias() {
        IndexListAliasRequest indexListAliasRequest = new IndexListAliasRequest();
        indexListAliasRequest.setCluster("localhost");
        List<IndexNameEntry> indexNames = client.listIndexAlias(indexListAliasRequest);
        Assert.assertFalse(indexNames.isEmpty());
    }


    @Test
    public void attachIndex() {
        IndexAttachRequest attachIndexRequest = new IndexAttachRequest();
        attachIndexRequest.setName("test_index_create");
        attachIndexRequest.setProject("big_data_test");
        attachIndexRequest.setTemplate("media_resource");
        client.attachIndex(attachIndexRequest);
    }

    @Test
    public void detachIndex() {
        IndexDetachRequest detachIndexRequest = new IndexDetachRequest();
        detachIndexRequest.setName("test_index_create");
        detachIndexRequest.setProject("big_data_test");
        detachIndexRequest.setTemplate("media_resource");
        client.detachIndex(detachIndexRequest);
    }

    public JSONObject settings() {
        String mappings = "{\n" +
                "        \"number_of_shards\": 2,\n" +
                "        \"number_of_replicas\": 1\n" +
                "    }";
        return JSON.parseObject(mappings);
    }

    public JSONObject newMapping() {
        String mappings = "{\n" +
                "\t\"dynamic\": \"false\",\n" +
                "\t\"properties\": {\n" +
                "\t\t\"add_new_field_time\": {\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd HH:mm:ss\",\n" +
                "\t\t\t\"type\": \"date\"\n" +
                "\t\t},\n" +
                "\t\t\"last_event_time\": {\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd HH:mm:ss\",\n" +
                "\t\t\t\"type\": \"date\"\n" +
                "\t\t},\n" +
                "\t\t\"storage_date\": {\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd\",\n" +
                "\t\t\t\"type\": \"date\"\n" +
                "\t\t},\n" +
                "\t\t\"create_time\": {\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd HH:mm:ss\",\n" +
                "\t\t\t\"type\": \"date\"\n" +
                "\t\t},\n" +
                "\t\t\"pid\": {\n" +
                "\t\t\t\"type\": \"keyword\"\n" +
                "\t\t},\n" +
                "\t\t\"appear_num\": {\n" +
                "\t\t\t\"type\": \"integer\"\n" +
                "\t\t},\n" +
                "\t\t\"id\": {\n" +
                "\t\t\t\"type\": \"long\"\n" +
                "\t\t},\n" +
                "\t\t\"ape_id\": {\n" +
                "\t\t\t\"type\": \"keyword\"\n" +
                "\t\t},\n" +
                "\t\t\"event_time\": {\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd\",\n" +
                "\t\t\t\"type\": \"date\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        return JSON.parseObject(mappings);
    }

    public JSONObject mappings() {
        String mappings = "{\n" +
                "\t\"dynamic\": \"false\",\n" +
                "\t\"properties\": {\n" +
                "\t\t\"id\": {\n" +
                "\t\t\t\"type\": \"long\"\n" +
                "\t\t},\n" +
                "\t\t\"pid\": {\n" +
                "\t\t\t\"type\": \"keyword\"\n" +
                "\t\t},\n" +
                "\t\t\"appear_num\": {\n" +
                "\t\t\t\"type\": \"integer\"\n" +
                "\t\t},\n" +
                "\t\t\"ape_id\": {\n" +
                "\t\t\t\"type\": \"keyword\"\n" +
                "\t\t},\n" +
                "\t\t\"last_event_time\": {\n" +
                "\t\t\t\"type\": \"date\",\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
                "\t\t},\n" +
                "\t\t\"storage_date\": {\n" +
                "\t\t\t\"type\": \"date\",\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd\"\n" +
                "\t\t},\n" +
                "\t\t\"event_time\": {\n" +
                "\t\t\t\"type\": \"date\",\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd\"\n" +
                "\t\t},\n" +
                "\t\t\"create_time\": {\n" +
                "\t\t\t\"type\": \"date\",\n" +
                "\t\t\t\"format\": \"yyyy-MM-dd HH:mm:ss\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        return JSON.parseObject(mappings);
    }
}