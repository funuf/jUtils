package fun.hellofun.jUtils.converter;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月9日 星期三 10时40分36秒 创建；<br>
 * 作用是：<b>null转换器</b>；<br>
 */
public class Null {

    /**
     * 该方法由 <b>张东冬</b> 于 2019年10月9日 星期三 10时41分02秒 创建；<br>
     * 作用是：<b>避免字符串为null</b>；<br>
     *
     * @param s 可能为null的字符串
     * @return ""或自身
     */
    public static String avoid(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }
}
