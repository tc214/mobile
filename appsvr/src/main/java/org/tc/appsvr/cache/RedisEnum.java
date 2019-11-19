package org.tc.appsvr.cache;



public enum RedisEnum {

    /**
     * 数据字典Service - 根据字典类型查询字典数据
     */
    REDIS_KEY_REST_API_QUERYLIST(RedisKeyValue.KEY_PREFIX, "queryList", "查询列表List"),
    REDIS_KEY_REST_API_QUERYBYID(RedisKeyValue.KEY_PREFIX, "queryById", "通过id查询列表getListById"),
    REDIS_KEY_REST_API_QUERYBYNAME(RedisKeyValue.KEY_PREFIX, "queryByName", "通过name查询queryByName"),
    REDIS_KEY_REST_API_LOGINTOKEN(RedisKeyValue.KEY_PREFIX, "loginToken", "通过loginName查询loginToken"),
    REDIS_KEY_REST_API_ADD(RedisKeyValue.KEY_PREFIX, "add", "添加Add"),
    REDIS_KEY_REST_API_UPDATE(RedisKeyValue.KEY_PREFIX, "update", "更新update"),
    REDIS_KEY_REST_API_DELETEBYMAP(RedisKeyValue.KEY_PREFIX, "deleteByMap", "按Map条件删除deleteByMap"),
    REDIS_KEY_REST_API_DELETEBYID(RedisKeyValue.KEY_PREFIX, "deleteById", "按id条件删除deleteById");


    /**
     * 系统标识
     */
    private String keyPrefix;

    /**
     * 方法名称
     */
    private String func;
    /**
     * 描述
     */
    private String remark;


    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    RedisEnum(String keyPrefix, String func, String remark) {
        this.keyPrefix = keyPrefix;
        this.func = func;
        this.remark = remark;
    }


}

