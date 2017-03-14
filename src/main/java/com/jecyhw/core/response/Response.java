
package com.jecyhw.core.response;

import java.io.Serializable;

/**
 * Created by jecyhw on 16-8-27.
 */
final public class Response<T> implements Serializable{
    private Integer code;
    private T message;

    private Response(Integer code, T message) {
        this.code = code;
        this.message = message;
    }

    private Response() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    static public <T> Response<T> success(T message) {
        return create(Code.SUCCESS, message);
    }

    static public <T> Response<T> fail(T message) {
        return create(Code.FAIL, message);
    }

    static public <T> Response<T> notFound(T message) {
        return create(Code.NOT_FOUND, message);
    }

    static public <T> Response<T> createFail(T message) {
        return create(Code.CREATE_FAIL, message);
    }

    static private  <T> Response<T> create(Code code, T message) {
        return new Response<>(code.getCode(), message);
    }
}
