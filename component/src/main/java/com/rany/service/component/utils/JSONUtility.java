package com.rany.service.component.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JSONUtility {

    /**
     * @param main
     * @param add
     */
    public static void merge(JSONObject main, JSONObject add) {
        if (add == null || main == null) {
            return;
        }
        for (Map.Entry<String, Object> kv : add.entrySet()) {
            if (main.get(kv.getKey()) == null) {
                main.put(kv.getKey(), kv.getValue());
                continue;
            }
            Object v = kv.getValue();
            if (v instanceof JSONObject) {
                merge(main.getJSONObject(kv.getKey()), add.getJSONObject(kv.getKey()));
            }
        }

    }
}
