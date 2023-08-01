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
public class ClusterCreateRequest extends BaseRequest implements Serializable {

    @NotBlank(message = "集群名称不能为空")
    private String name;
    @NotBlank(message = "集群状态不能为空")
    private String status;
    @NotBlank(message = "集群类型不能为空")
    private String type;
    @NotBlank(message = "集群描述不能为空")
    private String desc;
    @NotBlank(message = "集群内部地址不能为空")
    private String internalAddress;
    @NotBlank(message = "集群地址不能为空")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setInternalAddress(String internalAddress) {
        this.internalAddress = internalAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getInternalAddress() {
        return internalAddress;
    }

    public String getAddress() {
        return address;
    }
}
