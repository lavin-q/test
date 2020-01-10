package com.qhm.example.test.annotation;

import com.qhm.example.test.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
public class TestMain {
    private static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {

        // @Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        //ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration1.class);

        // 如果加载spring-context.xml文件：
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("spring-context.xml");

        //TestBean tb = (TestBean) context.getBean("testBean");
        //tb.sayHello();
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Long s = 1576829532000l;
        String format = sdf.format(s);
        System.out.println(format);*/
        String test = "aaaa:bbbb";
        String tt = "ccc";
        String[] testSplit = test.split(":");
        String[] ttSplit = tt.split(":");
        log.info("含冒号数组:{}",testSplit.toString());
        log.info("不含冒号数组:{}",ttSplit);

        String time = "1577116800000";
        String formatTime = sdfTime.format(Long.parseLong(time));
        String formatDate = sdfDate.format(Long.parseLong(time));
        log.info("时间:{}",formatTime);
        log.info("日期:{}",formatDate);

        String s = "aaasdjaskdlasjd";
        String substring = StringUtils.substring(s, s.length() - 1);
        log.info("截取后字符串:{}",substring);

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        Date d =c.getTime();


        //Date fetureDate = DateUtil.getPastDate(new Date(), 2);

        String corn = "0 0/1 * * * ?";
        TestMain ds = new TestMain();
        List<Date> dates = ds.getRecentTriggerTime(corn);
        System.out.println(dates);

        ds.dateFormat("2019-11-09T09:47:24.000+0800");

        System.out.println(DateUtil.getTimeStampAsSecond());

    }
    /**
     * 根据cron表达式，获取最近的两次执行时间
     * @param cron
     * @return
     */
    public List<Date> getRecentTriggerTime(String cron) {
        try {
            CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
            cronTriggerImpl.setCronExpression(cron);
            // 获取下两次执行的时间，用于计算调度间隔
            List<Date> dates = TriggerUtils.computeFireTimes(cronTriggerImpl, null, 2);

            long betweenTime = betweenDateTime(dates.get(0),dates.get(1));

            List<Date> date2 = TriggerUtils.computeFireTimesBetween(cronTriggerImpl, null, new Date(System.currentTimeMillis()-betweenTime*2),new Date());

            return date2;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private long betweenDateTime(Date start, Date end) {
        return end.getTime()-start.getTime();
    }

    //protected abstract int getDeviceType();
    /*public static void main(String[] args){
        String corn = "0 0/1 * * * ?";
        WorkCycleDataSource ds = new WorkCycleDataSource();
        List<Date> dates = ds.getRecentTriggerTime(corn);
        System.out.println(dates);
    }*/


    public static String timeFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }

    public static String dateFormat(String oldDate) {
        Date date1 = null;
        DateFormat df2 = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = df.parse(oldDate);
            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
            date1 = df1.parse(date.toString());
            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return df2.format(date1);
    }
}