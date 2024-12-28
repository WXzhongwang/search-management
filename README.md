# search-management

**search-management** 是一个基于 SpringBoot + gRpc 的服务端应用, 提供es集群的管理能力。

1. springboot 2.2.6.RELEASE
2. elasticsearch 7.16.3
3. grpc+netty

**特性:**

- [x] **netty**  : netty通信协议
- [x] **gRpc+protobuf**  : 以grpc的方式服务，性能更佳
- [x] **elasticsearch-high-level-client/elasticsearch-rest-client**  : 检测es连接状态,自动重连，检测服务状态
- [x] **索引管理**  : 按策略（自动创建索引+定时删除过期索引）
- [x] **索引模版**  : 支持索引模版
- [x] **管理维度**  : 以集群+项目+模板+索引的维度统一管理索引元数据
- [x] **统计概览**  : 提供索引统计能力（集群+项目+模板+索引）
- [ ] **交互式CLI**  : 支持交互式CLI完成集群统一管理能力

## 快速使用

```
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

    @Test
    public void refreshIndex() {
        IndexRefreshRequest refreshIndexRequest = new IndexRefreshRequest();
        refreshIndexRequest.setName("test_index_create");
        refreshIndexRequest.setProject("big_data_test");
        refreshIndexRequest.setTemplate("media_resource");
        client.refreshIndex(refreshIndexRequest);
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
```

## CLI

```text
Usage: java SearchManagementConsole ipAddress port

		For example: java SearchManagementConsole localhost 8080
```

支持指令包括：

```java
package com.rany.service.console;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/8/22 21:39
 * @email 18668485565163.com
 */
public class CommandConstants {

    private CommandConstants() {
    }

    public static final String ADD_CLUSTER_CMD = "add_cluster";
    public static final String GET_CLUSTER_CMD = "get_cluster";
    public static final String UPDATE_CLUSTER_CMD = "update_cluster";
    public static final String LIST_CLUSTER_CMD = "list_cluster";
    public static final String LIST_CLUSTER_DETAILS_CMD = "list_cluster_details";
    public static final String CREATE_PROJECT_CMD = "create_project";
    public static final String GET_PROJECT_CMD = "get_project";
    public static final String UPDATE_PROJECT_CMD = "update_project";
    public static final String DELETE_PROJECT_CMD = "delete_project";
    public static final String LIST_PROJECT_CMD = "list_project";
    public static final String LIST_PROJECT_DETAILS_CMD = "list_project_details";
    public static final String CREATE_INDEX_TEMPLATE_CMD = "create_index_template";
    public static final String GET_INDEX_TEMPLATE_CMD = "get_index_template";
    public static final String UPDATE_INDEX_TEMPLATE_CMD = "update_index_template";
    public static final String UPDATE_INDEX_TEMPLATE_MAPPINGS_CMD = "update_index_template_mappings";
    public static final String UPDATE_INDEX_TEMPLATE_SETTINGS_CMD = "update_index_template_settings";
    public static final String DELETE_INDEX_TEMPLATE_CMD = "delete_index_template";
    public static final String LIST_INDEX_TEMPLATE_CMD = "list_index_template";
    public static final String LIST_INDEX_TEMPLATE_DETAILS_CMD = "list_index_template_details";
    public static final String CREATE_INDEX_CMD = "create_index";
    public static final String ATTACH_ES_INDEX_CMD = "attach_es_index";
    public static final String DETACH_ES_INDEX_CMD = "detach_es_index";
    public static final String GET_INDEX_CMD = "get_index";
    public static final String REFRESH_INDEX_CMD = "refresh_index";
    public static final String UPDATE_INDEX_CMD = "update_index";
    public static final String UPDATE_INDEX_MAPPINGS_CMD = "update_index_mappings";
    public static final String UPDATE_INDEX_SETTINGS_CMD = "update_index_settings";
    public static final String DELETE_INDEX_CMD = "delete_index";
    public static final String LIST_INDEX_CMD = "list_index";
    public static final String LIST_INDEX_DETAILS_CMD = "list_index_details";
    public static final String LIST_INDEX_NAME = "list_index_names";
    public static final String SET_SERVICE_READONLY = "set_readonly";
    public static final String SET_SERVICE_NORMAL = "set_normal";
    public static final String SET_SERVICE_SUSPEND = "set_suspend";
    public static final String GET_SERVICE_MODE = "get_mode";
    public static final String SUSPEND_BACKGROUND_EXECUTORS = "suspend_background_executors";
    public static final String RESUME_BACKGROUND_EXECUTORS = "resume_background_executors";
    public static final String GET_BACKGROUND_EXECUTORS_STATUS = "get_background_executors_status";
}

```

升级项目版本:
> mvn versions:set -DnewVersion=1.0.1-SNAPSHOT