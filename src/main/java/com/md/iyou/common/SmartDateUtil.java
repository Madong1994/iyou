package com.md.iyou.common;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 马东 on 2018/10/16.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 21:03 2018/10/16
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class SmartDateUtil {
    /**
     * 创建当前时间
     * @return string yyyy-MM-dd HH:mm:ss
     */
    public static String creatNowTime() {
        String now = DateUtil.now();
        return now;
    }
/**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param
     * @return
      */
     public static String timeStamp2Date(String seconds,String format) {
         if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
             return "";
         }
         if(format == null || format.isEmpty()){
             format = "yyyy-MM-dd HH:mm:ss";
         }
          SimpleDateFormat sdf = new SimpleDateFormat(format);
          return sdf.format(new Date(Long.valueOf(seconds+"000")));
      }

    /**
     * 判断当前时间是否大于传入的时间
     * @param time
     * @return
     */
    public static boolean betweenTime(String time) {
        Date date1 = DateUtil.parse(time);

        String dateStr2 = creatNowTime();
        Date date2 = DateUtil.parse(dateStr2);

        int res = date2.compareTo(date1);
        if (res > 0) {
            return true;
        }
        return false;
    }

    /**
     * 当前开始时间
     * @return
     */
    public static String todayStartTime() {
        return DateUtil.beginOfDay(new Date()).toString();
    }

    /**
     * 昨天日期
     * @return
     */
    public static String tomorrowDate() {
        String date = DateUtil.offset(DateUtil.beginOfDay(new Date()), DateField.DAY_OF_MONTH, 1).toString();
        String[] dates = date.split(" ");
        return dates[0];
    }

    /**
     * 当前日期
     * @return
     */
    public static String todayDate() {
        String date = DateUtil.beginOfDay(new Date()).toString();
        String[] dates = date.split(" ");
        return dates[0];
    }
    /**
     * 明天开始时间
     * @return
     */
    public static String tomorrowStartTime() {
        return DateUtil.offset(DateUtil.beginOfDay(new Date()), DateField.DAY_OF_MONTH, 1).toString();
    }
    public static void main(String[] args) {
//        float ar = 1;
//        float i = (ar / 33)*100;
//        float a = 3.9999f;
//        int j = (int) i;
//        System.out.println((j));
        SmartDateUtil.betweenTime("2019-04-02 22:33:23");
//        String str = SmartDateUtil.timeStamp2Date("1550419200", null);
//        DateUtil.offset(DateUtil.beginOfDay(new Date()), DateField.DAY_OF_MONTH, 1);
//        System.out.println(DateUtil.offset(DateUtil.beginOfDay(new Date()), DateField.DAY_OF_MONTH, 1).toString());
    }
}
