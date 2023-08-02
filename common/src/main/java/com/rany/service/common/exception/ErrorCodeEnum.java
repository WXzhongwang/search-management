package com.rany.service.common.exception;

/**
 * 错误代码
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/26 10:26 下午
 * @email 18668485565@163.com
 */

public enum ErrorCodeEnum {


    UNKNOWN(40000, "未知异常类型"),

    PROTECTED_STATUS(40000, "无法服务状态"),

    NETWORK_EXCEPTION(40001, "网络问题"),
    NO_MASTER_IP_EXCEPTION(40002, "master ip 配置异常"),
    CLIENT_SHUTDOWN_EXCEPTION(40002, "客户端shutdown异常, 异常原因: %s"),
    NO_HEARTBEAT_EXCEPTION(40003, "客户端丢失心跳"),
    MYSQL_INTERNAL_ERROR(40004, "MySQL查询异常"),
    CLUSTER_STATUS_ERROR(40005, "获取集群状态异常"),
    INDEX_STATUS_ERROR(40006, "获取索引状态异常"),
    CREATE_INDEX_ERROR(40007, "创建索引异常"),
    UPDATE_INDEX_ERROR(40008, "创建索引异常"),
    DELETE_INDEX_ERROR(40008, "删除索引异常"),
    CHECK_STATUS_ERROR(40009, "检查健康状态异常"),
    PARAM_CHECK_ERROR(40010, "参数校验失败"),

    INTERNAL_ERROR(40010, "内部异常"),
    OBJECT_ALREADY_EXIST(40010, "数据已存在"),
    OBJECT_NOT_EXIST(40010, "数据不存在"),
    INVALID_INPUT_PARAMETER(40010, "参数不正常"),
    CLUSTER_NOT_EMPTY(40010, "集群不为空"),
    PROJECT_NOT_EMPTY(40011, "项目模板不为空"),
    TEMPLATE_NOT_EMPTY(40011, "模板不为空"),

    ;

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
