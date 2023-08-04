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
public class IndexListNameRequest extends BaseRequest implements Serializable {

    @NotBlank(message = "项目名称不能为空")
    private String cluster;

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
}
