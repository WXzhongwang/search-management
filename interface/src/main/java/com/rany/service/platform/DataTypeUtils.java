package com.rany.service.platform;

import com.rany.service.platform.meta.ClusterStatus;
import com.rany.service.platform.meta.ClusterType;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public final class DataTypeUtils {

    private static final String HHD = "HHD";
    private static final String SSD = "SSD";

    private DataTypeUtils() {
    }


    public static ClusterType convertClusterType(String type) {
        ClusterType result = null;
        if (type.equalsIgnoreCase(HHD)) {
            result = ClusterType.HDD;
        } else if (type.equalsIgnoreCase(SSD)) {
            result = ClusterType.SSD;
        }
        return result;
    }

    public static ClusterStatus convertClusterStatus(String status) {
        ClusterStatus result = null;
        if (status == null) {
            return ClusterStatus.NULL;
        } else if (status.equalsIgnoreCase(ClusterStatus.CREATING.name())) {
            result = ClusterStatus.CREATING;
        } else if (status.equalsIgnoreCase(ClusterStatus.DELETING.name())) {
            result = ClusterStatus.DELETING;
        } else if (status.equalsIgnoreCase(ClusterStatus.IN_SERVICE.name())) {
            result = ClusterStatus.IN_SERVICE;
        } else if (status.equalsIgnoreCase(ClusterStatus.DISABLED.name())) {
            result = ClusterStatus.DISABLED;
        }
        return result;
    }

    public static String combineFullIndexName(String projectName, String templateName, String indexName) {
        return projectName + "." + templateName + "." + indexName;
    }

    public static String combineFullAliasName(String projectName, String templateName, String aliasName) {
        return projectName + "." + templateName + "." + aliasName;
    }

    public static String getAliasName(String fullAliasName) {
        String[] parts = fullAliasName.split("\\.");
        if (parts.length == 3) {
            return parts[2];
        } else {
            return "";
        }
    }

    public static boolean isInternalIndex(String indexName) {
        return indexName.startsWith(".");
    }

    public static boolean isLegacy(String fullIndexName) {
        String[] parts = fullIndexName.split("\\.");
        if (parts.length == 3) {
            return false;
        }
        return true;
    }
}
