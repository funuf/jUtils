package fun.hellofun.jUtils.predicate.empty;

import java.util.Collection;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月9日 星期三 9时05分06秒 创建；<br>
 * 作用是：<b>空值判断</b>；<br>
 */
public class Empty {

    /**
     * 该方法由 <b>张东冬</b> 于 2019年10月9日 星期三 10时19分36秒 创建；<br>
     * 作用是：<b>【存在为空的】对任意个参数进行判空</b>；<br>
     *
     * @param os 任意个参数，
     *           字符串类型为空的情况：null、length==0、字面量为{@link EmptyString#registerSpecialEmptyValues(String...)}注册过的值
     *           集合类型为空的情况：no element
     * @return true：存在为空的参数，  false：全部不为空
     */
    public static boolean yes(Object... os) {
        if (os == null) {
            return true;
        }
        for (Object o : os) {
            if (yes(o, null)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 该方法由 <b>张东冬</b> 于 2019年10月9日 星期三 11时22分11秒 创建；<br>
     * 作用是：<b>【都不为空】判断是否所有参数都不为空</b>；<br>
     *
     * @param os 任意个参数，
     * @return true：都不为空  false：存在为空的参数
     */
    public static boolean no(Object... os) {
        return !yes(os);
    }

    /**
     * 该方法由 <b>张东冬</b> 于 2019年10月18日 星期五 12时03分15秒 创建；<br>
     * 作用是：<b>【存在不为空的】判断包含不为空的参数</b>；<br>
     *
     * @return true： 包含不为空的参数  false：都为空
     */
    public static boolean anyNo(Object... os) {
        for (Object o : os) {
            if (no(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 该方法由 <b>张东冬</b> 于 2019年10月9日 星期三 10时23分08秒 创建；<br>
     * 作用是：<b>对任意个参数进行判空，同时指定本次有效的特殊"空值"</b>；<br>
     *
     * @param otherSpecifyEmptyValues 本次有效的特殊"空值"
     * @param os                      任意个参数，
     *                                字符串类型为空的情况：null、length==0、字面量为{@link EmptyString#registerSpecialEmptyValues(String...)}注册过的值、本次指定的特殊空值
     *                                集合类型为空的情况：no element
     * @return true：存在为空的参数，  false：全部不为空
     */
    public static boolean yes(String[] otherSpecifyEmptyValues, Object... os) {
        if (otherSpecifyEmptyValues == null) {
            return yes(os);
        }
        for (Object o : os) {
            if (yes(o, otherSpecifyEmptyValues)) {
                return true;
            }
        }
        return false;
    }


    private static boolean yes(Object o, String[] otherSpecifyEmptyValues) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            return EmptyString.y(((String) o), otherSpecifyEmptyValues);
        }
        if (o instanceof Collection) {
            Collection oc = (Collection) o;
            return oc.isEmpty();
        }
        return false;
    }

}
