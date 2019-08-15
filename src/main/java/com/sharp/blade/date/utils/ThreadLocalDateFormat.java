package com.sharp.blade.date.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDateFormat {

    private final ThreadLocal<SimpleDateFormat> THREAD_LOCAL;

    public ThreadLocalDateFormat(final String format) {
        THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat(format);
            }
        };
    }

    public String format(Date date) {
        return THREAD_LOCAL.get().format(date);
    }

    public Date parse(String date) throws ParseException {
        return THREAD_LOCAL.get().parse(date);
    }

    public void remove() {
        THREAD_LOCAL.remove();
    }
}
