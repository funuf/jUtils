package fun.hellofun.jUtils.creater;

import java.util.UUID;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月17日 星期四 16时41分13秒 创建；<br>
 * 作用是：<b>获取uuid</b>；<br>
 */
public class Uuid {

    public static String get() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
