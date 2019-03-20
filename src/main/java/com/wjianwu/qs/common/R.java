package com.wjianwu.qs.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wjianwu 2019/3/1 16:39
 */
public class R extends HashMap<String, Object> {

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 构造
     */
    public R() {
        put("code", 0);
    }

    /**
     * @return code=0
     */
    public static R ok() {
        return new R();
    }

    /**
     * 返回处理后的信息
     *
     * @param msg message
     * @return code=0 msg=msg
     */
    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    /**
     * 返回数据回前台
     *
     * @param map map
     * @return code=0 putAll(map)
     */
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    /**
     * 返回错误代码和错误信息
     *
     * @return code msg
     */
    public static R error(int code, String errMsg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", errMsg);
        return r;
    }

    /**
     * 返回默认的错误代码和错误信息
     *
     * @return code=500，msg="出现未知异常，请及时处理！"
     */
    public static R error() {
        return error(500, "出现未知异常，请及时处理！");
    }

    /**
     * 自定义错误信息
     *
     * @param errMsg errMsg
     * @return code=500,msg=errorMsg
     */
    public static R error(String errMsg) {
        return error(500, errMsg);
    }
}
