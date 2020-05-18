package fun.hellofun.jUtils.classes;

import fun.hellofun.jUtils.classes.map.R;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月11日 星期五 15时04分56秒 创建；<br>
 * 作用是：<b>对接口结果的映射(R map)，参考{@link R}</b>；<br>
 * 供客户端接收结果使用
 */
public class RM<T> {
    private int code;
    private String tip;
    private String reason;
    private T data;
    private long time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
