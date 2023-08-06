package com.rany.service.client.rpc.request;

import com.rany.service.client.rpc.BaseRequest;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 查询集群项目列表
 *
 * @author zhongshengwang
 * @description 查询集群项目列表
 * @date
 * @email 18668485565@163.com
 */
public class ProjectListRequest extends BaseRequest implements Serializable {

    @NotBlank(message = "集群名称不能为空")
    private String cluster;

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
}
