package com.md.iyou.entity;

/**
 * Created by 马东 on 2019/3/25.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 14:03 2019/3/25
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class RunRank {
    private int id;
    private int totalnum;
    private int step;
    private String openid;
    private String begintime;
    private int ranking;
    private String grade;
    private String money;
    private String type;//活动类型

    public int getId() {
        return id;
    }

    public int getStep() {
        return step;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
