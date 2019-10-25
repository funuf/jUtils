package fun.hellofun.jUtils;

import fun.hellofun.jUtils.creater.Uuid;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月17日 星期四 16时44分51秒 创建；<br>
 * 作用是：<b>代理包内所有工具类，调用方使用该类，既方便，又不会受到依赖内部优化的影响</b>；<br>
 */
public class JUtils {

    public static String getUuid() {
        return Uuid.get();
    }


}
