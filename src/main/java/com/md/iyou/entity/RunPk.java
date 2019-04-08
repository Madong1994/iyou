package com.md.iyou.entity;

/**
 * Created by 马东 on 2019/3/21.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:26 2019/3/21
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class RunPk {
    private int id;
    private String openid;
    private String unionid;
    private String type;
    private String dor;
    private String time;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
