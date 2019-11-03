package fun.hellofun.jUtils.converter;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * 该类由 <b>张东冬</b> 于 2019年11月3日 星期日 12时58分56秒 创建；<br>
 * 作用是：<b>时间工具类</b>；<br>
 */
public class TimeUtils {

    private static ZoneId zoneId = ZoneId.systemDefault();

    /**
     * 注册时区
     */
    public static void registerZoneId(ZoneId z) {
        zoneId = z;
    }

    /**
     * 时刻相关
     */
    public static class Moment {
        /**
         * @param day 一天内任意时刻
         * @return 该天的开始时刻;
         */
        public static long startOfDay(long day) {
            LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(day), zoneId).toLocalDate();
            return localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
        }

        /**
         * @param day 一天内任意时刻
         * @return 该天的结束时刻;
         */
        public static long endOfDay(long day) {
            LocalDateTime localDateTime = LocalDateTime.of(LocalDateTime.ofInstant(Instant.ofEpochMilli(day), zoneId).toLocalDate(), LocalTime.MAX);
            return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
        }

        /**
         * @param month 该月内任意时刻
         * @return 该月的开始时刻;
         */
        public static long startOfMonth(long month) {
            LocalDate localDate = LocalDateTime
                    .ofInstant(Instant.ofEpochMilli(month), zoneId)
                    .toLocalDate()
                    .with(TemporalAdjusters.firstDayOfMonth());
            return localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
        }

        /**
         * @param month 该月内任意时刻
         * @return 该月的结束时刻;
         */
        public static long endOfMonth(long month) {
            LocalDate localDate = LocalDateTime
                    .ofInstant(Instant.ofEpochMilli(month), zoneId)
                    .with(TemporalAdjusters.lastDayOfMonth())
                    .toLocalDate();
            LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MAX);
            return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
        }

        /**
         * @param year 该年内任意时刻
         * @return 该年的开始时刻;
         */
        public static long startOfYear(long year) {
            LocalDate localDate = LocalDateTime
                    .ofInstant(Instant.ofEpochMilli(year), zoneId)
                    .toLocalDate()
                    .with(TemporalAdjusters.firstDayOfYear());
            return localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();

        }

        /**
         * @param year 该年内任意时刻
         * @return 该年的结束时刻;
         */
        public static long endOfYear(long year) {
            LocalDate localDate = LocalDateTime
                    .ofInstant(Instant.ofEpochMilli(year), zoneId)
                    .with(TemporalAdjusters.lastDayOfYear())
                    .toLocalDate();
            LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MAX);
            return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
        }
    }

    /**
     * 时间段相关
     */
    public static class Duration {

    }

}
