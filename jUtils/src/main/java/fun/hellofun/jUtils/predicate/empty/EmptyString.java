package fun.hellofun.jUtils.predicate.empty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月9日 星期三 9时36分53秒 创建；<br>
 * 作用是：<b>Strings判空</b>；<br>
 */
public class EmptyString {

    /**
     * 默认指定的空值
     */
    private static final List<String> DEFAULT_SPECIAL_EMPTY_VALUES = new ArrayList<>();

    /**
     * 注册默认的指定的空值，比如API项目可能会把"null"也认为是一个空值，但Android项目用不到
     *
     * @param specialEmptyValues 指定的特殊空值，始终有效
     */
    public static synchronized void registerSpecialEmptyValues(String... specialEmptyValues) {
        DEFAULT_SPECIAL_EMPTY_VALUES.clear();
        if (specialEmptyValues != null) {
            DEFAULT_SPECIAL_EMPTY_VALUES.addAll(Arrays.asList(specialEmptyValues));
        }
    }

    private static boolean y(String s) {
        return (s == null || s.length() == 0 || DEFAULT_SPECIAL_EMPTY_VALUES.contains(s));
    }

    /**
     * @param otherSpecifyEmptyValues 除默认指定的空值之外，只对本次调用有效的，追加的指定的空值
     */
    static boolean y(String s, String[] otherSpecifyEmptyValues) {
        if (y(s)) {
            return true;
        }
        if (otherSpecifyEmptyValues == null) {
            return false;
        }
        return y(s, s1 -> Arrays.asList(otherSpecifyEmptyValues).contains(s));
    }

    private static boolean y(String s, Predicate<String> isEmptyValue) {
        if (y(s)) {
            return true;
        }
        if (isEmptyValue == null) {
            return false;
        }
        return isEmptyValue.test(s);
    }
}
