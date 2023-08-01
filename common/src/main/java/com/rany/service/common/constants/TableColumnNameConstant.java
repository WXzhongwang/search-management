package com.rany.service.common.constants;

/**
 * 表字段定义
 *
 * @author zhongshengwang
 */
public class TableColumnNameConstant {

    private TableColumnNameConstant() {
    }

    /**
     * 集群
     */
    public static final class Cluster {
        private Cluster() {
        }

        public static final String CLUSTER_META_TABLE_PK_NAME = "cluster_name";
        public static final String COLUMN_CLUSTER_STATUS = "cluster_status";
        public static final String COLUMN_CLUSTER_TYPE = "cluster_type";
        public static final String COLUMN_DESCRIPTION = "cluster_desc";
        public static final String COLUMN_INTERNAL_ENDPOINT = "cluster_internal_address";
        public static final String COLUMN_SERVICE_ENDPOINT = "cluster_address";
        public static final String COLUMN_CREATE_TIME = "gmt_create";
        public static final String COLUMN_LAST_UPDATE_TIME = "gmt_modified";
    }

    /**
     * 项目
     */
    public static final class Project {
        private Project() {
        }

        public static final String PROJECT_META_TABLE_PK_NAME = "project_name";
        public static final String PROJECT_META_TABLE_CLUSTER_NAME = "cluster_name";
        public static final String COLUMN_DESCRIPTION = "project_desc";
        public static final String COLUMN_SETTING = "project_setting";
        public static final String COLUMN_CREATE_TIME = "gmt_create";
        public static final String COLUMN_LAST_UPDATE_TIME = "gmt_modified";
    }


    /**
     * 模板
     */
    public static final class IndexTemplate {
        private IndexTemplate() {
        }

        public static final String INDEX_TEMPLATE_TABLE_PK_NAME = "index_template_name";
        public static final String INDEX_TEMPLATE_TABLE_PROJECT_NAME = "project_name";
        public static final String COLUMN_AUTO_INDEX_POLICY = "auto_index_rolling_policy";
        public static final String COLUMN_AUTO_INDEX_WINDOW = "auto_index_rolling_window";
        public static final String COLUMN_AUTO_INDEX_NAME_PREFIX = "auto_index_name_prefix";
        public static final String COLUMN_ALIAS = "alias";
        public static final String COLUMN_SETTINGS = "settings";
        public static final String COLUMN_MAPPINGS = "mappings";
        public static final String COLUMN_CREATE_TIME = "gmt_create";
        public static final String COLUMN_LAST_UPDATE_TIME = "gmt_modified";
    }

    /**
     * 索引
     */
    public static final class Index {
        private Index() {
        }

        public static final String INDEX_META_TABLE_PK_NAME = "full_name";
        public static final String INDEX_META_TABLE_NAME = "index_name";
        public static final String INDEX_META_TABLE_PROJECT_NAME = "project_name";
        public static final String INDEX_META_TABLE_TEMPLATE_NAME = "template_name";
        public static final String COLUMN_INDEX_LEGACY_FLAG = "legacy";
        public static final String COLUMN_INDEX_TAGS = "tags";
        public static final String COLUMN_CREATE_TIME = "gmt_create";
        public static final String COLUMN_LAST_UPDATE_TIME = "gmt_modified";
    }
}
