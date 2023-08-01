package com.rany.service.common.toolkit;

import com.rany.service.platform.meta.AutoIndexRollingPolicy;
import com.rany.service.platform.meta.ClusterStatus;

import java.time.LocalDate;

/**
 * @author zhongshengwang
 */
public final class DateUtility {

    private DateUtility() {
    }

    public static String getIndexDayName(LocalDate today) {
        return String.format("%04d%02d%02d", today.getYear(), today.getMonthValue(), today.getDayOfMonth());
    }

    public static String getIndexDayName(LocalDate today, int offset) {
        LocalDate targetDate = null;
        if (offset == 0) {
            targetDate = today;
        } else if (offset > 0) {
            targetDate = today.plusDays(offset);
        } else {
            offset = -offset;
            targetDate = today.minusDays(offset);
        }
        return getIndexDayName(targetDate);
    }

    public static String getIndexMonthName(LocalDate today) {
        return String.format("%04d%02d", today.getYear(), today.getMonthValue());
    }

    public static String getIndexMonthName(LocalDate today, int offset) {
        LocalDate targetDate = null;
        if (offset == 0) {
            targetDate = today;
        } else if (offset > 0) {
            targetDate = today.plusMonths(offset);
        } else {
            offset = -offset;
            targetDate = today.minusMonths(offset);
        }
        return getIndexMonthName(targetDate);
    }

    public static String getIndexQuarterName(LocalDate today) {
        return String.format("%04dq%d", today.getYear(), (today.getMonthValue() - 1) / 3 + 1);
    }

    public static String getIndexQuarterName(LocalDate today, int offset) {
        LocalDate targetDate = null;
        if (offset == 0) {
            targetDate = today;
        } else if (offset > 0) {
            targetDate = today.plusMonths(offset * 3L);
        } else {
            offset = -offset;
            targetDate = today.minusMonths(offset * 3L);
        }
        return getIndexQuarterName(targetDate);
    }

    public static String getIndexHalfYear(LocalDate today) {
        return String.format("%04ds%d", today.getYear(), (today.getMonthValue() - 1) / 6 + 1);
    }

    public static String getIndexHalfYear(LocalDate today, int offset) {
        LocalDate targetDate = null;
        if (offset == 0) {
            targetDate = today;
        } else if (offset > 0) {
            targetDate = today.plusMonths(offset * 6L);
        } else {
            offset = 0 - offset;
            targetDate = today.minusMonths(offset * 6L);
        }
        return getIndexHalfYear(targetDate);
    }

    public static String getIndexYearName(LocalDate today) {
        return String.format("%04d", today.getYear());
    }

    public static String getIndexYearName(LocalDate today, int offset) {
        LocalDate targetDate = null;
        if (offset == 0) {
            targetDate = today;
        } else if (offset > 0) {
            targetDate = today.plusYears(offset);
        } else {
            offset = -offset;
            targetDate = today.minusYears(offset);
        }
        return getIndexYearName(targetDate);
    }


    public static ClusterStatus stringToClusterStatus(String status) {
        ClusterStatus result = null;
        if (status == null) {
            return ClusterStatus.NULL;
        } else if (status.equalsIgnoreCase("CREATING")) {
            result = ClusterStatus.CREATING;
        } else if (status.equalsIgnoreCase("DELETING")) {
            result = ClusterStatus.DELETING;
        } else if (status.equalsIgnoreCase("IN_SERVICE")) {
            result = ClusterStatus.IN_SERVICE;
        }
        return result;
    }

    public static AutoIndexRollingPolicy stringToAutoIndexRollingPolicy(String policy) {
        AutoIndexRollingPolicy result = null;
        if (policy == null) {
            result = null;
        } else if (policy.equalsIgnoreCase("NONE")) {
            result = AutoIndexRollingPolicy.NONE;
        } else if (policy.equalsIgnoreCase("DAY")) {
            result = AutoIndexRollingPolicy.DAY;
        } else if (policy.equalsIgnoreCase("YEAR")) {
            result = AutoIndexRollingPolicy.YEAR;
        } else if (policy.equalsIgnoreCase("MONTH")) {
            result = AutoIndexRollingPolicy.MONTH;
        } else if (policy.equalsIgnoreCase("QUARTER")) {
            result = AutoIndexRollingPolicy.QUARTER;
        } else if (policy.equalsIgnoreCase("HALF_YEAR")) {
            result = AutoIndexRollingPolicy.HALF_YEAR;
        }
        return result;
    }
}
