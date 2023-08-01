package com.rany.service.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class ProjectSettingTests {


    private static JSONObject getGroupSettingJSONObject(String group) {
        String jsonStr = new StringBuilder()
                .append("{\"index\":{\"routing\":{\"allocation\":{\"require\":{\"group\":\"")
                .append(group)
                .append("\"}}}}}").toString();
        return JSONObject.parseObject(jsonStr);
    }


    @Test
    public void testProjectSetting() {
        JSONObject hot = getGroupSettingJSONObject("hot");
        Assert.assertTrue(StringUtils.equals((String)hot.get("index.routing.allocation.require.group"), "hot"));
    }
}
