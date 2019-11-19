package org.tc.appsvr.cache;


/**
 * Redis 工具类
 * 系统-模块-方法-参数 这样的规则定义，可以很清晰的了解redis key存储的值是做了什么事情
 * 1.系统：基础数据系统
 * 2.模块：数据字典
 * 3.方法：根据数据字典类型查询
 * 4.参数：字典类型
 */
public class RedisKeyValue {


    /**
     * 主数据系统标识
     */
    public static final String KEY_PREFIX = "shop";
    /**
     * 分割字符，默认[:]，使用:可用于rdm分组查看
     */
    public static final String KEY_SPLIT_CHAR = ":";

    /**
     * redis的key键规则定义
     *
     * @param module 模块名称
     * @param func   方法名称
     * @param args   参数..
     * @return key
     */
    public static String keyBuilder(String module, String func, String... args) {
        return keyBuilder(null, module, func, args);
    }

    /**
     * redis的key键规则定义
     *
     * @param module 模块名称
     * @param func   方法名称
     * @param objStr 对象.toString()
     * @return key
     */
    public static String keyBuilder(String module, String func, String objStr) {
        return keyBuilder(null, module, func, new String[]{objStr});
    }

    /**
     * redis的key键规则定义
     *
     * @param prefix 项目前缀
     * @param module 模块名称
     * @param func   方法名称
     * @param objStr 对象.toString()
     * @return key
     */
    public static String keyBuilder(String prefix, String module, String func, String objStr) {
        return keyBuilder(prefix, module, func, new String[]{objStr});
    }

    /**
     * redis的key键规则定义
     *
     * @param prefix 项目前缀
     * @param module 模块名称
     * @param func   方法名称
     * @param args   参数..  参数个数不固定  String... args
     * @return key
     */
    public static String keyBuilder(String prefix, String module, String func, String... args) {
        // 项目前缀
        if (prefix == null) {
            prefix = KEY_PREFIX;
        }
        StringBuilder key = new StringBuilder(prefix);
        // KEY_SPLIT_CHAR 为分割字符
        key.append(KEY_SPLIT_CHAR).append(module).append(KEY_SPLIT_CHAR).append(func);
        for (String arg : args) {
            key.append(KEY_SPLIT_CHAR).append(arg);
        }
        return key.toString();
    }


    /**
     * redis的key键规则定义
     *
     * @param redisEnum  枚举对象
     * @param moduleName 模块名称
     * @param objStr     对象.toString()
     * @return key
     */
    public static String keyBuilder(RedisEnum redisEnum, String moduleName, String objStr) {
        return keyBuilder(redisEnum.getKeyPrefix(), moduleName, redisEnum.getFunc(), objStr);
    }


}

