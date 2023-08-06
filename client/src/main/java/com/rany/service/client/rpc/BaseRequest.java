package com.rany.service.client.rpc;

import com.rany.service.common.exception.ErrorCodeEnum;
import com.rany.service.common.exception.SearchClientException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public abstract class BaseRequest {

    protected String reqId;

    public void check() {
        Map<String, StringBuffer> validate = ValidatorUtil.validate(this);
        if (validate != null && !validate.isEmpty()) {
            String message = StringUtils.join(validate.values(), ",");
            throw new SearchClientException(ErrorCodeEnum.PARAM_CHECK_ERROR.getCode(), message);
        }
    }
}
