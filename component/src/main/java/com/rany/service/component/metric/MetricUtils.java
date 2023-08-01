package com.rany.service.component.metric;

import com.rany.service.component.meta.dto.ClusterMetaData;
import com.rany.service.component.meta.dto.IndexMetaData;
import com.rany.service.component.meta.dto.IndexTemplateMetaData;
import com.rany.service.component.meta.dto.ProjectMetaData;

import java.util.List;

/**
 * MetricUtils
 *
 * @author zhongshengwang
 * @description MetricUtils
 * @date
 * @email 18668485565@163.com
 */
public final class MetricUtils {

    private MetricUtils() {
    }

    public static SystemMetricCounter calculateSystemMetric(List<ClusterMetaData> clusters) {
        SystemMetricCounter counter = new SystemMetricCounter();
        for (ClusterMetaData clusterMetaData : clusters) {
            for (ProjectMetaData projectMeta : clusterMetaData.projectMetaMap.values()) {
                for (IndexTemplateMetaData indexGroupMeta : projectMeta.indexTemplateMetaData.values()) {
                    for (IndexMetaData indexMeta : indexGroupMeta.indexMetas.values()) {
                        counter.totalIndex++;
                        counter.totalDocs += indexMeta.docs;
                        counter.totalDataSize += indexMeta.totalData;
                    }
                    counter.totalTemplate++;
                }
                counter.totalProject++;
            }
            counter.totalCluster++;
        }
        return counter;
    }

    public static ClusterMetricCounter calculateClusterMetric(ClusterMetaData clusterMetaData) {
        ClusterMetricCounter counter = new ClusterMetricCounter();
        for (ProjectMetaData projectMeta : clusterMetaData.projectMetaMap.values()) {
            for (IndexTemplateMetaData indexGroupMeta : projectMeta.indexTemplateMetaData.values()) {
                for (IndexMetaData indexMeta : indexGroupMeta.indexMetas.values()) {
                    counter.totalIndex++;
                    counter.totalDocs += indexMeta.docs;
                    counter.totalDataSize += indexMeta.totalData;
                }
                counter.totalTemplate++;
            }
            counter.totalProject++;
        }
        return counter;
    }

    public static ProjectMetricCounter calculateProjectMetric(ProjectMetaData projectMeta) {
        ProjectMetricCounter counter = new ProjectMetricCounter();
        for (IndexTemplateMetaData indexGroupMeta : projectMeta.indexTemplateMetaData.values()) {
            for (IndexMetaData indexMeta : indexGroupMeta.indexMetas.values()) {
                counter.totalIndex++;
                counter.totalDocs += indexMeta.docs;
                counter.totalDataSize += indexMeta.totalData;
            }
            counter.totalTemplate++;
        }
        return counter;
    }

    public static TemplateMetricCounter calculateTemplateMetric(IndexTemplateMetaData templateMeta) {
        TemplateMetricCounter counter = new TemplateMetricCounter();
        for (IndexMetaData indexMeta : templateMeta.indexMetas.values()) {
            counter.totalIndex++;
            counter.totalDocs += indexMeta.docs;
            counter.totalDataSize += indexMeta.totalData;
        }
        return counter;
    }
}
