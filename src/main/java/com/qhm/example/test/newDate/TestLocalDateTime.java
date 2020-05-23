package com.qhm.example.test.newDate;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * Java 8 新时间
 */
public class TestLocalDateTime {
    private static DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
    private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * LocalDate LocalTime LocalDateTime
     */
    public static void main(String[] args) {
        //testLocalDateTime();
        //testInstant();
        //testIntervalCalculation();
        //testTemporalAdjuster();


        //时区获取
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        //获取指定时区的时间
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Africa/Bissau"));
        String format = formatter1.format(now);
        System.out.println(format);

        //构建一个带时区标志的时间
        LocalDateTime now1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now1.atZone(ZoneId.of("Australia/Lindeman"));
        //输出后是本地当前时间，尾部带有时区
        System.out.println(zonedDateTime);

    }


    //时间测试
    public static void testLocalDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime of = LocalDateTime.of(2020, 5, 18, 13, 22, 33);
        System.out.println(formatter.format(of));
        System.out.println(of);

        LocalDateTime localDateTime = of.plusYears(2);
        System.out.println(localDateTime);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
    }

    //Instant : 时间戳
    public static void testInstant(){

        //默认获取UTC区间
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(now.toEpochMilli());

        Instant instant = Instant.ofEpochSecond(1000l);
        System.out.println(instant);
    }

    //时间间隔计算
    public static void testIntervalCalculation(){
        //计算两个“时间”之间的间隔

        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now1 = Instant.now();

        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());


        //计算两个日期之间的间隔
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2020, 1, 1);

        Period between1 = Period.between(ld1, ld2);
        System.out.println(between1);
    }

    //时间校正器
    public static void testTemporalAdjuster(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfYear());
        System.out.println(with);
        LocalDateTime with1 = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with1.getDayOfMonth());
        System.out.println(with1.getDayOfMonth());
    }




}
