package com.jecyhw.core.response;

/**
 * Created by jecyhw on 16-8-28.
 */
public enum Code {
    SUCCESS(200),
    FAIL(0),
    CREATE_FAIL(400),
    NOT_FOUND(404);

    Integer code;

    Code(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code=" + code +
                '}';
    }
}
