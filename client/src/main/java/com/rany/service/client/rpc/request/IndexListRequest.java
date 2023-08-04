package com.rany.service.client.rpc.request;

import com.rany.service.client.rpc.BaseRequest;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public class IndexListRequest extends BaseRequest implements Serializable {

    @NotBlank(message = "项目名称不能为空")
    private String cluster;
    @NotBlank(message = "项目状态不能为空")
    private String project;
    @NotBlank(message = "集群不能为空")
    private String template;

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
