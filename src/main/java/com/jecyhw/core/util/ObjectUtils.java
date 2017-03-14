package com.jecyhw.core.util;

/**
 * Created by jecyhw on 16-12-5.
 */
final public class ObjectUtils {

    static public boolean isNull(Object obj) {
        return obj == null;
    }

    static public <T> T nullObj() {
        return  null;
    }
}
