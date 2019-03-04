package com.wjianwu.qs.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wjianwu 2019/3/1 16:39
 */
public class Result extends HashMap<String, Object> {

    /**
     * 构造
     */
    public Result() {
        put("code", 0);
    }

    /**
     * @return code=0
     */
    public static Result ok() {
        return new Result();
    }

    /**
     * 返回处理后的信息
     *
     * @param msg message
     * @return code=0 msg=msg
     */
    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    /**
     * 返回数据回前台
     *
     * @param map map
     * @return code=0 putAll(map)
     */
    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    /**
     * 返回错误代码和错误信息
     *
     * @return code msg
     */
    public static Result error(int code, String errMsg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", errMsg);
        return result;
    }

    /**
     * 返回默认的错误代码和错误信息
     *
     * @return code=500，msg="出现未知异常，请及时处理！"
     */
    public static Result error() {
        return error(500, "出现未知异常，请及时处理！");
    }

    /**
     * 自定义错误信息
     *
     * @param errMsg errMsg
     * @return code=500,msg=errorMsg
     */
    public static Result error(String errMsg) {
        return error(500, errMsg);
    }
}
