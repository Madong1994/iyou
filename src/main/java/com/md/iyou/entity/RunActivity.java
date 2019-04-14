package com.md.iyou.entity;

/**
 * Created by 马东 on 2019/3/25.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 13:11 2019/3/25
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class RunActivity {
    private int id;
    private int totalnum;
    private int totalmoney;//此活动总金额
    private String  time;//活动时间
    private String grade;//等级

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public int getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
