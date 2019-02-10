package com.md.iyou.common;

import com.xiaoleilu.hutool.date.DateUtil;

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

    public static void main(String[] args) {
        SmartDateUtil.creatNowTime();
    }
}
