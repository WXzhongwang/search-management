package com.rany.service.component.meta;

import com.rany.service.platform.meta.AutoIndexRollingPolicy;

import java.sql.Timestamp;
import java.util.List;

/**
 * 索引模板
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/29 11:26 下午
 * @email 18668485565@163.com
 */
public class IndexTemplateMeta {
    public String templateName;
    public String projectName;
    public String settings;
    public String mappings;
    public AutoIndexRollingPolicy autoIndexRollingPolicy;
    public Integer autoIndexRollingWindow;
    public String autoIndexNamePrefix;
    public List<String> aliasList;
    public Timestamp gmtCreate;
    public Timestamp gmtModified;
}
