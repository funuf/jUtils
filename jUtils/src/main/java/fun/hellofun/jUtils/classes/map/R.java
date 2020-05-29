package fun.hellofun.jUtils.classes.map;

import java.util.HashMap;

import fun.hellofun.jUtils.predicate.empty.Empty;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月11日 星期五 10时06分02秒  创建；<br>
 * 作用是：<b>api项目的RESTful接口的返回类</b>；<br>
 * 响应码参考  https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Status
 */
public class R extends HashMap<String, Object> {

    /**
     * 业务响应码
     */
    private static final String CODE = "code";
    /**
     * 非正常原因
     */
    private static final String REASON = "reason";
    /**
     * 提示语
     */
    private static String TIP = "tip";
    /**
     * 有效载荷
     */
    private static final String DATA = "data";
    /**
     * 系统当前时间
     */
    private static String TIME = "time";

    /**
     * 业务成功码
     */
    public static int CODE_SUCCESS = 200;

    /**
     * 默认业务错误码
     */
    public static final int CODE_ERROR = 500;

    /**
     * 列表无数据
     */
    public static final int CODE_LIST_NO_CONTENT = 204;

    /**
     * 当前用户身份验证通过，但是操作的数据不是自己的数据
     */
    public static final int CODE_FORBIDDEN = 403;

    /**
     * 根据主键（或其他要素），找不到相应实体
     */
    public static final int CODE_NOT_FOUND_ENTITY = 404;

    /**
     * 内容被禁用：正在访问的资源被锁定。
     */
    public static final int CODE_LOCKED = 423;

    /**
     * 默认业务错误提示语
     */
    public static final String DEFAULT_ERROR_TIP = "锄禾日当午，服务器真辛苦...";


    /**
     * 工作使用
     */
    public static void usedByQcsd() {
        CODE_SUCCESS = 1;
        TIP = "msg";
        TIME = "responseTime";
    }


    private static final R get(int code) {
        R r = new R();
        r.put(CODE, code);
        r.put(TIME, System.currentTimeMillis());
        return r;
    }

    public static final R ok() {
        return get(CODE_SUCCESS);
    }

    public static final R ok(Object o) {
        R r = get(CODE_SUCCESS);
        r.put(DATA, o);
        return r;
    }

    public static final R error() {
        return error(DEFAULT_ERROR_TIP);
    }

    public static final R error(String tip) {
        R r = get(CODE_ERROR);
        r.put(TIP, tip);
        return r;
    }

    public static final R error(String tip, String reason) {
        R error = error(tip);
        error.put(REASON, reason);
        return error;
    }

    public static final R error(int code, String tip) {
        R r = get(code);
        r.put(TIP, tip);
        return r;
    }

    public static final R error(int code, String tip, String reason) {
        R error = error(code, tip);
        error.put(REASON, reason);
        return error;
    }

    public static final R noContent(String tip) {
        R error = error(CODE_LIST_NO_CONTENT, tip);
        return error;
    }

    public static final R forbidden() {
        R error = error(CODE_FORBIDDEN, "无权进行该操作");
        return error;
    }

    public static final R notFound() {
        R error = error(CODE_NOT_FOUND_ENTITY, "未找到相关信息");
        return error;
    }

    public static final R locked() {
        R error = error(CODE_LOCKED, "相关信息已被锁定");
        return error;
    }

    public static final boolean isSuccess(R r) {
        if (Empty.yes(r)) {
            return false;
        }
        Object code = r.get(CODE);
        if (Empty.yes(code)) {
            return false;
        }
        if (!(code instanceof Integer)) {
            return false;
        }
        if (CODE_SUCCESS != Integer.valueOf(code.toString())) {
            return false;
        }
        return true;
    }

    public static final String getTip(R r) {
        if (Empty.yes(r)) {
            return "";
        }
        Object o = r.get(TIP);
        return Empty.yes(o) ? "" : o.toString();
    }

    public static final String getReason(R r) {
        if (Empty.yes(r)) {
            return "";
        }
        Object o = r.get(REASON);
        return Empty.yes(o) ? "" : o.toString();
    }

    public static final long getTime(R r) {
        if (Empty.yes(r)) {
            return 0;
        }
        Object o = r.get(TIME);
        return Empty.yes(o) ? 0 : Long.valueOf(o.toString());
    }
}
