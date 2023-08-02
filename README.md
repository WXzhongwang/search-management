# search-management

**search-management** 是一个基于 SpringBoot + gRpc 的服务端应用, 提供es集群的管理能力。

1. springboot 2.2.6.RELEASE
2. elasticsearch 7.16.3
3. 

**特性:**

- [x] **netty**  : netty通信协议
- [x] **gRpc+protobuf**  : 以grpc的方式服务，性能更佳
- [x] **elasticsearch-high-level-client/elasticsearch-rest-client**  : 检测es连接状态,自动重连，检测服务状态
- [x] **索引管理**  : 自动创建索引+定时删除过期索引
- [x] **索引模版**  : 支持索引模版
- [x] **管理维度**  : 以集群+项目+索引的维度统一管理索引元数据
- [x] **管理维度**  : 提供索引统计能力（集群+项目+索引）
