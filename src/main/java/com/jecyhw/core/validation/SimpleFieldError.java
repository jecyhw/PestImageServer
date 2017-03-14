package com.jecyhw.core.validation;

/**
 * Created by jecyhw on 16-11-2.
 */
public class SimpleFieldError {
    public SimpleFieldError() {
    }

    public SimpleFieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    /**
     * 字段名
     */
    private String field;

    /**
     * 错误消息
     */
    private String message;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
