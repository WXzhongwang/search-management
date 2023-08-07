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
public class IndexCreateRequest extends BaseRequest implements Serializable {

    @NotBlank(message = "索引名称不能为空")
    private String name;
    @NotBlank(message = "项目不能为空")
    private String project;
    @NotBlank(message = "集群不能为空")
    private String template;

    @NotBlank(message = "mapping不能为空")
    private String mapping;
    @NotBlank(message = "setting不能为空")
    private String setting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }
}
