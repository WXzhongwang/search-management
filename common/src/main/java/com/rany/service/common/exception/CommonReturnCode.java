package com.rany.service.common.exception;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public enum CommonReturnCode {

    SUCCEED(200, "处理成功"),

    FAIL(500, "处理失败"),
    ;

    private final int code;
    private final String message;

    CommonReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
