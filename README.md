# search-management

**search-management** 是一个基于 SpringBoot + gRpc 的服务端应用

**特性:**

- [x] **gRpc**  : 以grpc的方式进行通信，性能更佳
- [x] **elasticsearch-high-level-client/elasticsearch-rest-client**  : 检测es连接状态,自动重连，检测服务状态
- [x] **索引管理**  : 自动创建索引+定时删除过期索引
- [x] **索引模版**  : 支持索引模版
- [x] **管理维度**  : 以集群+项目+索引的维度统一管理索引元数据
- [x] **管理维度**  : 提供索引统计能力（集群+项目+索引）
