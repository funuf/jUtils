package fun.hellofun.jUtils.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 该类由 <b>张东冬</b> 于 2019年10月9日 星期三 18时52分51秒  创建；<br>
 * 作用是：<b>时间格式刷，负责时间的格式化与解析</b>；<br>
 * 同一时间，不同的地方，不同的线程可能会同时使用本类，因此变量sdf不应该静态化
 */
public class TimeBrush {

    private SimpleDateFormat sdf;

    private String pattern;

    /**
     * 使用get方法实例化
     */
    private TimeBrush() {
    }

    private TimeBrush(SimpleDateFormat sdf) {
        this.sdf = sdf;
        this.pattern = this.sdf.toPattern();
    }

    public static TimeBrush get(String pattern) {
        return new TimeBrush(new SimpleDateFormat(pattern));
    }

    public long parse(String s) {
        try {
            return sdf.parse(s).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Date parseDate(String s) {
        try {
            return sdf.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String format(long time) {
        return sdf.format(time);
    }

    public String format(long time, String format) {
        sdf.applyPattern(format);
        return sdf.format(time);
    }


    public static class Chinese {
        public static final String yyyy = yyyy("年");

        public static final String yyyy_MM = yyyy_MM("年", "月");

        public static final String HH_mm = HH_mm("时", "分");

        public static final String yyyy_MM_dd = yyyy_MM_dd("年", "月", "日");

        public static final String HH_mm_ss = HH_mm_ss("时", "分", "秒");

        public static final String yyyy_MM_dd_HH_mm_ss = yyyy_MM_dd_HH_mm_ss("年", "月", "日 ", "时", "分", "秒");
    }

    public static class English {
        public static final String yyyy = yyyy("");

        public static final String yyyy_MM = yyyy_MM("-", "");

        public static final String HH_mm = HH_mm(":", "");

        public static final String yyyy_MM_dd = yyyy_MM_dd("-", "-", "");

        public static final String HH_mm_ss = HH_mm_ss(":", ":", "");

        public static final String yyyy_MM_dd_HH_mm_ss = yyyy_MM_dd_HH_mm_ss("-", "-", " ", ":", ":", "");
    }


    private static final String PATTERN_YEAR = "yyyy%s";

    private static final String PATTERN_YEAR_MONTH = "yyyy%sMM%s";

    private static final String PTTERN_HOUR_MINUTE = "HH%smm%s";

    private static final String PATTERN_DATE = "yyyy%sMM%sdd%s";

    private static final String PATTERN_TIME = "HH%smm%sss%s";

    private static final String PATTERN_DATE_TIME = "yyyy%sMM%sdd%sHH%smm%sss%s";


    public static String yyyy(String yearJoiner) {
        return String.format(PATTERN_YEAR, yearJoiner);
    }

    public static String yyyy_MM(String yearJoiner, String monthJoiner) {
        return String.format(PATTERN_YEAR_MONTH, yearJoiner, monthJoiner);
    }

    public static String yyyy_MM_dd(String yearJoiner, String monthJoiner, String dayJoiner) {
        return String.format(PATTERN_DATE, yearJoiner, monthJoiner, dayJoiner);
    }


    public static String HH_mm(String hourJoiner, String minuteJoiner) {
        return String.format(PTTERN_HOUR_MINUTE, hourJoiner, minuteJoiner);
    }

    public static String HH_mm_ss(String hourJoiner, String minuteJoiner, String secondJoiner) {
        return String.format(PATTERN_TIME, hourJoiner, minuteJoiner, secondJoiner);
    }

    public static String yyyy_MM_dd_HH_mm_ss(String yearJoiner, String monthJoiner, String dayJoiner,
                                             String hourJoiner, String minuteJoiner, String secondJoiner) {
        return String.format(PATTERN_DATE_TIME, yearJoiner, monthJoiner, dayJoiner, hourJoiner, minuteJoiner, secondJoiner);
    }
}
