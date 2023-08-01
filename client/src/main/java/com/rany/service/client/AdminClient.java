package com.rany.service.client;

import com.rany.service.client.rpc.request.*;
import com.rany.service.platform.meta.ClusterInfo;
import com.rany.service.platform.meta.ProjectInfo;

import java.util.List;
import java.util.Set;

/**
 * AdminClient
 *
 * @author zhongshengwang
 * @description AdminClient
 * @date 2022/3/26 11:25 下午
 * @email 18668485565@163.com
 */

public class AdminClient {

    private final Proxy adminProxy;
    private static final long DEFAULT_TIMEOUT_MILLISECONDS = 5000;

    public AdminClient(String inprocServerName) {
        adminProxy = new Proxy(inprocServerName, DEFAULT_TIMEOUT_MILLISECONDS);
    }

    public AdminClient(String masterHost, int masterPort) {
        adminProxy = new Proxy(masterHost, masterPort, DEFAULT_TIMEOUT_MILLISECONDS);
    }

    public AdminClient(String masterHost, int masterPort, int timeout) {
        adminProxy = new Proxy(masterHost, masterPort, timeout);
    }

    public AdminClient(Set<String> masterHosts, int masterPort) {
        adminProxy = new Proxy(masterHosts, masterPort, DEFAULT_TIMEOUT_MILLISECONDS);
    }

    public AdminClient(Set<String> masterHosts, int masterPort, int timeout) {
        adminProxy = new Proxy(masterHosts, masterPort, timeout);
    }

    public void init() {
        this.adminProxy.start();
    }

    public void shutdown() {
        this.adminProxy.shutdown();
    }

    public void createCluster(ClusterCreateRequest clusterCreateRequest) {
        clusterCreateRequest.check();
        adminProxy.createCluster(clusterCreateRequest);
    }

    public ClusterInfo getCluster(ClusterGetRequest clusterGetRequest) {
        clusterGetRequest.check();
        return adminProxy.getCluster(clusterGetRequest);
    }

    public void updateCluster(ClusterUpdateRequest clusterUpdateRequest) {
        clusterUpdateRequest.check();
        adminProxy.updateCluster(clusterUpdateRequest);
    }

    public void deleteCluster(ClusterDeleteRequest clusterDeleteRequest) {
        clusterDeleteRequest.check();
        adminProxy.deleteCluster(clusterDeleteRequest);
    }

    public List<String> listCluster(ClusterListRequest clusterListRequest) {
        clusterListRequest.check();
        return adminProxy.listCluster(clusterListRequest);
    }

    public List<ClusterInfo> listClusterDetails(ClusterListRequest clusterListRequest) {
        clusterListRequest.check();
        return adminProxy.listClusterDetails(clusterListRequest);
    }

    public void createProject(ProjectCreateRequest clusterCreateRequest) {
        clusterCreateRequest.check();
        adminProxy.createProject(clusterCreateRequest);
    }

    public void updateProject(ProjectUpdateRequest projectUpdateRequest) {
        projectUpdateRequest.check();
        adminProxy.updateProject(projectUpdateRequest);
    }

    public ProjectInfo getProject(ProjectGetRequest projectGetRequest) {
        projectGetRequest.check();
        return adminProxy.getProject(projectGetRequest);
    }

    public void updateProject(ProjectDeleteRequest projectDeleteRequest) {
        projectDeleteRequest.check();
        adminProxy.deleteProject(projectDeleteRequest);
    }

    public List<String> listProject(ProjectListRequest projectListRequest) {
        projectListRequest.check();
        return adminProxy.listProject(projectListRequest);
    }

    public List<ProjectInfo> listProjectDetails(ProjectListRequest projectListRequest) {
        projectListRequest.check();
        return adminProxy.listProjectDetails(projectListRequest);
    }


    public void createIndexTemplate(IndexTemplateCreateRequest indexTemplateCreateRequest) {
        indexTemplateCreateRequest.check();
        adminProxy.createIndexTemplate(indexTemplateCreateRequest);
    }
}


