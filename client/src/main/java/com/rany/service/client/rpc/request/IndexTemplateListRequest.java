package com.rany.service.client.rpc.request;

import com.rany.service.client.rpc.BaseRequest;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/8/2 22:24
 * @email 18668485565163.com
 */
public class IndexTemplateListRequest extends BaseRequest implements Serializable {

    @NotBlank(message = "项目名称不能为空")
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}