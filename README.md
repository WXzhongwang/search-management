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

## 快速使用

```
package com.rany.service.client;

import com.google.common.collect.Lists;
import com.rany.service.client.rpc.request.*;
import com.rany.service.platform.meta.AutoIndexRollingPolicy;
import com.rany.service.platform.meta.ClusterInfo;
import com.rany.service.platform.meta.ProjectInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void createProject() {
        ProjectCreateRequest projectCreateRequest = new ProjectCreateRequest();
        projectCreateRequest.setCluster("localhost");
        projectCreateRequest.setName("graph");
        projectCreateRequest.setDesc("knowledge graph");
        client.createProject(projectCreateRequest);
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
```