package com.rany.service.component.meta.dto;

import com.rany.service.component.meta.IndexMeta;

import java.util.List;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public class IndexMetaData extends IndexMeta {
    public List<String> aliases;
    public String health;
    public Integer primaryShards;
    public Integer replicaShards;
    public Integer docs;
    public Integer totalData;
    public String domain;
    public String group;
}
