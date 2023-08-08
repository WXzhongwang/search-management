package com.rany.service.component.metric;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public class ProjectMetricCounter {

    public Integer totalTemplate;
    public Integer totalIndex;
    public Integer totalDocs;
    public Integer totalDataSize;

    public ProjectMetricCounter() {
        this.totalTemplate = 0;
        this.totalIndex = 0;
        this.totalDocs = 0;
        this.totalDataSize = 0;
    }
}
