package com.md.iyou.entity;

/**
 * Created by 马东 on 2019/3/28.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:33 2019/3/28
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class RunUser {
    private int id;
    private String openid;
    private String unionid;
    private String money;
    private String nickname;
    private String avatarurl;

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

    public int getId() {
        return id;
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

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
