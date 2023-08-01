package com.rany.service.component.utils;


import com.rany.service.component.meta.dto.ClusterMetaData;
import com.rany.service.component.meta.dto.NodeMeta;
import com.rany.service.component.meta.dto.ProjectMetaData;
import com.rany.service.component.metric.ClusterMetricCounter;
import com.rany.service.component.metric.ProjectMetricCounter;
import com.rany.service.platform.meta.ClusterInfo;
import com.rany.service.platform.meta.NodeInfo;
import com.rany.service.platform.meta.ProjectInfo;

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

}
