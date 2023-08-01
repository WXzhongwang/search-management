package com.rany.service.component.meta;

import java.sql.Timestamp;

/**
 * 项目信息
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/29 11:26 下午
 * @email 18668485565@163.com
 */
public class ProjectMeta {

    public String projectName;
    public String clusterName;
    public String projectDesc;
    public Timestamp gmtCreate;
    public Timestamp gmtModified;

    /**
     * 项目配置
     */
    public String projectSetting;
}
