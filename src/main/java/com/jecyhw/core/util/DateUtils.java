package com.jecyhw.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jecyhw on 16-11-16.
 */
final public class DateUtils {
    static final private SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
    static public String now() {
        return SIMPLE_DATE_FORMAT.format(new Date());
    }
}
