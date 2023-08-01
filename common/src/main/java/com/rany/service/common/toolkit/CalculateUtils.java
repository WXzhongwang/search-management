package com.rany.service.common.toolkit;

/**
 * @author zhongshengwang
 * @description TODO
 * @date
 * @email 18668485565@163.com
 */
public final class CalculateUtils {

    private CalculateUtils() {
    }

    public static int getDataSizeBytes(String sizeString) {
        double size;
        if (sizeString.contains("pb")) {
            size = Double.parseDouble(sizeString.substring(0, sizeString.length() - 2)) * 1000 * 1000 * 1000 * 1000 * 1000;
        } else if (sizeString.contains("tb")) {
            size = Double.parseDouble(sizeString.substring(0, sizeString.length() - 2)) * 1000 * 1000 * 1000 * 1000;
        } else if (sizeString.contains("gb")) {
            size = Double.parseDouble(sizeString.substring(0, sizeString.length() - 2)) * 1000 * 1000 * 1000;
        } else if (sizeString.contains("mb")) {
            size = Double.parseDouble(sizeString.substring(0, sizeString.length() - 2)) * 1000 * 1000;
        } else if (sizeString.contains("kb")) {
            size = Double.parseDouble(sizeString.substring(0, sizeString.length() - 2)) * 1000;
        } else if (sizeString.contains("b")) {
            size = Double.parseDouble(sizeString.substring(0, sizeString.length() - 1));
        } else {
            size = 0;
        }
        return (int) size;
    }


}
