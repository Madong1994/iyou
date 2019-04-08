package com.md.iyou.common;


import cn.hutool.core.util.StrUtil;

/**
 * Created by 马东 on 2018/10/16.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 20:51 2018/10/16
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class StringUtil {
    /**
     * 判断是否有空
     * @param args 参数
     * @return boolean
     */
    public static boolean hasEmpty(String... args) {
        if (StrUtil.hasEmpty(args)) {
            return true;
        }
        return false;
    }
}
