package org.tc.appsvr.entity;

/**
 * The interface Rest.
 *
 * @param <T> the type parameter
 * @author tc
 * @since 2019-11-14
 */
public interface Rest<T> {
    /**
     * 状态码 .
     *
     * @param httpStatus the http status
     */
    void setHttpStatus(int httpStatus);

    /**
     * 数据载体.
     *
     * @param data the data
     */
    void setData(T data);

    /**
     * 提示信息.
     *
     * @param msg the msg
     */
    void setMsg(String msg);

    /**
     * Sets identifier.
     *
     * @param identifier 标识
     */
    void setIdentifier(String identifier);
}
