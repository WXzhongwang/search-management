package com.rany.service.component.meta.dto;

import com.rany.service.component.meta.ClusterMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public class ClusterMetaData extends ClusterMeta {

    /**
     * es版本
     */
    public String esVersion;
    /**
     * 健康状态
     */
    public String clusterHealth;
    /**
     * 节点列表
     */
    public List<NodeMeta> nodeMetaList = new ArrayList<>();

    /**
     * 项目信息
     */
    public HashMap<String, ProjectMetaData> projectMetaMap;
}
