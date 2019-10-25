package fun.hellofun.jUtils.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月8日 星期二 11时49分43秒 创建；<br>
 * 作用是：<b>单位工具类</b>；<br>
 */
public class UnitUtils {

    public static double byte2Kb(long bytes) {
        return new BigDecimal((bytes + 0.0) / 1024).setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public static double byte2Mb(long bytes) {
        return new BigDecimal((bytes + 0.0) / Math.pow(1024, 2)).setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public static double byte2Gb(long bytes) {
        return new BigDecimal((bytes + 0.0) / Math.pow(1024, 3)).setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
