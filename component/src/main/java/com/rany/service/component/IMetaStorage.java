package com.rany.service.component;

import com.rany.service.common.exception.SearchManagementException;
import com.rany.service.component.meta.dto.ClusterMetaData;
import com.rany.service.component.meta.dto.IndexMetaData;
import com.rany.service.component.meta.dto.IndexTemplateMetaData;
import com.rany.service.component.meta.dto.ProjectMetaData;

import java.util.List;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2022/4/2 11:38 下午
 * @email 18668485565@163.com
 */

public interface IMetaStorage {

    /**
     * 获取元数据存储地址
     *
     * @return
     */
    String getMetaStoreAddress();

    /**
     * 检查健康状态
     *
     * @throws SearchManagementException
     */
    void checkHealth();

    /**
     * 建表
     *
     * @throws SearchManagementException
     */
    void setupTables();


    /**
     * 拉取所有的元数据信息
     *
     * @return
     */
    List<ClusterMetaData> loadAllMeta();


    /**
     * 写入索引
     *
     * @param indexMetaData
     */
    void insertIndex(IndexMetaData indexMetaData);


    /**
     * 删除索引
     *
     * @param projectName
     * @param indexGroupName
     * @param indexName
     */
    void deleteIndex(String projectName, String indexGroupName, String indexName);


    /**
     * 更新索引
     *
     * @param indexMetaData
     */
    void updateIndex(IndexMetaData indexMetaData);


    /**
     * 添加集群
     *
     * @param clusterMetaData
     */
    void insertCluster(ClusterMetaData clusterMetaData);

    /**
     * 更新集群信息
     *
     * @param clusterMetaData
     */
    void updateCluster(ClusterMetaData clusterMetaData);


    /**
     * 删除集群
     *
     * @param clusterName
     */
    void deleteCluster(String clusterName);


    /**
     * 新建项目
     *
     * @param projectMetaData
     */
    void insertProject(ProjectMetaData projectMetaData);

    /**
     * 更新项目
     *
     * @param projectMetaData
     */
    void updateProject(ProjectMetaData projectMetaData);


    /**
     * 删除项目
     *
     * @param clusterName
     * @param projectName
     */
    void deleteProject(String clusterName, String projectName);


    /**
     * 新建模板
     *
     * @param indexTemplateMetaData
     */
    void insertIndexTemplate(IndexTemplateMetaData indexTemplateMetaData);


    /**
     * 更新模板
     *
     * @param indexTemplateMetaData
     */
    void updateIndexTemplate(IndexTemplateMetaData indexTemplateMetaData);


    /**
     * 删除模版
     *
     * @param projectName
     * @param templateName
     */
    void deleteIndexTemplate(String projectName, String templateName);
}
