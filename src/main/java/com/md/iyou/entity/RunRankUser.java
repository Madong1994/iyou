package com.md.iyou.entity;

/**
 * Created by 马东 on 2019/4/3.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:37 2019/4/3
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class RunRankUser {
    private int ranking;
    private int step;
    private String nickname;
    private String avatarurl;
    private String grade;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
