package com.rany.service.common.exception;

/**
 * 服务端异常统一包装
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/26 10:24 下午
 * @email 18668485565@163.com
 */

public class SearchManagementException extends RuntimeException {

    private final int code;

    private final String message;

    public SearchManagementException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public SearchManagementException(int code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }
}
