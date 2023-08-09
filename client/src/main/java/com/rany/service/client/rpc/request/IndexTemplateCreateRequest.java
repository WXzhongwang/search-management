package com.rany.service.client.rpc.request;

import com.rany.service.client.rpc.BaseRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public class IndexTemplateCreateRequest extends BaseRequest implements Serializable {

    @NotBlank(message = "项目名称不能为空")
    private String projectName;
    @NotBlank(message = "模板名称不能为空")
    private String name;
    @NotBlank(message = "mapping不能为空")
    private String mapping;
    @NotBlank(message = "setting不能为空")
    private String setting;

    @NotBlank(message = "autoIndexNamePrefix不能为空")
    private String autoIndexNamePrefix;
    @NotNull(message = "autoIndexRollingWindow不能为空")
    private Integer autoIndexRollingWindow;
    @NotBlank(message = "autoIndexRollingPolicy不能为空")
    private String autoIndexRollingPolicy;
    @NotEmpty(message = "aliases不能为空")
    private List<String> aliases;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public String getAutoIndexNamePrefix() {
        return autoIndexNamePrefix;
    }

    public void setAutoIndexNamePrefix(String autoIndexNamePrefix) {
        this.autoIndexNamePrefix = autoIndexNamePrefix;
    }

    public Integer getAutoIndexRollingWindow() {
        return autoIndexRollingWindow;
    }

    public void setAutoIndexRollingWindow(Integer autoIndexRollingWindow) {
        this.autoIndexRollingWindow = autoIndexRollingWindow;
    }

    public String getAutoIndexRollingPolicy() {
        return autoIndexRollingPolicy;
    }

    public void setAutoIndexRollingPolicy(String autoIndexRollingPolicy) {
        this.autoIndexRollingPolicy = autoIndexRollingPolicy;
    }
}
