package com.rany.service.common.exception;

/**
 * 客户端异常统一包装
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/26 10:24 下午
 * @email 18668485565@163.com
 */

public class SearchClientException extends RuntimeException {

    private int code;

    private String message;

    public SearchClientException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMessage();
    }

    public SearchClientException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public SearchClientException(int code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }
}
