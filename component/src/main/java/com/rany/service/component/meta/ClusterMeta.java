package com.rany.service.component.meta;

import com.rany.service.platform.meta.ClusterStatus;
import com.rany.service.platform.meta.ClusterType;

import java.sql.Timestamp;

/**
 * 集群信息
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/29 11:26 下午
 * @email 18668485565@163.com
 */
public class ClusterMeta {

    public String clusterName;
    public String clusterDesc;
    public ClusterStatus clusterStatus;
    public ClusterType clusterType;

    public String clusterAddress;

    public String clusterInternalAddress;

    public Timestamp gmtCreate;

    public Timestamp gmtModified;
}
