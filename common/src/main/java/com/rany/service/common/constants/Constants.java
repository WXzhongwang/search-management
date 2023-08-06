package com.rany.service.common.constants;

/**
 * Constants
 *
 * @author zhongshengwang
 * @description Constants
 * @date 2022/3/26 10:23 下午
 * @email 18668485565@163.com
 */

public final class Constants {

    public static final String VERSION = "1.0.0.beta";
    public static final String AUTHOR = "Dick Zhong";
    public static final String SUCCESS_CODE = "200";
    public static final String PING = "ping";
    public static final String PONG = "pong";
    public static final String UNKNOWN = "UNKNOWN_STRING";
    public static final String ALIASES = "aliases";
    public static final String MAPPING = "mappings";
    public static final String SETTING = "settings";
    private Constants() {
    }

    public static final class Table {
        public static final String CLUSTER_TABLE_NAME_SUFFIX = "_cluster_meta";
        public static final String PROJECT_TABLE_NAME_SUFFIX = "_project_meta";

        public static final String INDEX_TEMPLATE_TABLE_NAME_SUFFIX = "_index_template_meta";
        public static final String INDEX_TABLE_NAME_SUFFIX = "_index_meta";
    }
}
