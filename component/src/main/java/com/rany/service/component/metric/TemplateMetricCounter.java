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
public class TemplateMetricCounter {

    public Integer totalIndex;
    public Integer totalDocs;
    public Integer totalDataSize;

    public TemplateMetricCounter() {
        this.totalIndex = 0;
        this.totalDocs = 0;
        this.totalDataSize = 0;
    }
}
