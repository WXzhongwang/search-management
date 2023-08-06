package com.rany.service.component.metric;

/**
 * TemplateMetricCounter
 * 指标计数
 *
 * @author zhongshengwang
 * @description MetricCounter
 * @date
 * @email 18668485565@163.com
 */
public class ClusterMetricCounter {

    public Integer totalProject;
    public Integer totalTemplate;
    public Integer totalIndex;
    public Integer totalDocs;
    public Integer totalDataSize;

    public ClusterMetricCounter() {
        totalProject = 0;
        totalTemplate = 0;
        totalIndex = 0;
        totalDocs = 0;
        totalDataSize = 0;
    }
}
