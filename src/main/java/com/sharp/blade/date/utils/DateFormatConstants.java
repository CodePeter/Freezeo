package com.sharp.blade.date.utils;

import java.util.Date;

public class DateFormatConstants {
    public static Date INITIAL_DATE = new Date(0);

    public static Date FAR_FAR_AWAY = new Date(System.currentTimeMillis() + 1000 * TimeConstants.YEAR_IN_MILLISECONDS);

    public static ThreadLocalDateFormat HH_MM = new ThreadLocalDateFormat("HH:mm");

    public static ThreadLocalDateFormat HH_MM_SS = new ThreadLocalDateFormat("HH:mm:ss");

    public static ThreadLocalDateFormat MM_DD_YYYY_SLASH = new ThreadLocalDateFormat("MM/dd/yyyy");

    public static ThreadLocalDateFormat YYYY_MM_DD = new ThreadLocalDateFormat("yyyy-MM-dd");

    public static ThreadLocalDateFormat MM_DD = new ThreadLocalDateFormat("MM-dd");

    public static ThreadLocalDateFormat YYYY_MM_DD_HH_MM = new ThreadLocalDateFormat("yyyy-MM-dd HH:mm");

    public static ThreadLocalDateFormat YYYY_MM_DD_HH_MM_SS = new ThreadLocalDateFormat("yyyy-MM-dd HH:mm:ss");

    public static ThreadLocalDateFormat MM_DD_HH_MM_SS = new ThreadLocalDateFormat("MM-dd HH:mm:ss");

    public static ThreadLocalDateFormat YYYY_NIAN_MM_YUE = new ThreadLocalDateFormat("yyyy年MM月");

    public static ThreadLocalDateFormat YYYYMM = new ThreadLocalDateFormat("yyyyMM");

    public static ThreadLocalDateFormat YYYYMMDD = new ThreadLocalDateFormat("yyyyMMdd");

    public static ThreadLocalDateFormat YYYYMMDDHH = new ThreadLocalDateFormat("yyyyMMddHH");

    public static ThreadLocalDateFormat YYYYMMDDHHMM = new ThreadLocalDateFormat("yyyyMMddHHmm");

    public static ThreadLocalDateFormat YYYYMMDDHHMMSS = new ThreadLocalDateFormat("yyyyMMddHHmmss");

    public static ThreadLocalDateFormat YYYYMMDDHHMMSSSSS = new ThreadLocalDateFormat("yyyyMMddHHmmssSSS");
}
