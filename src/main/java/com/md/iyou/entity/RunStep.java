package com.md.iyou.entity;

import com.md.iyou.common.StringUtil;

/**
 * Created by 马东 on 2019/3/23.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 10:02 2019/3/23
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class RunStep {
    private int id;
    private String type;
    private String openid;
    private String begintime;
    private String updatetime;
    private int step;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
    public boolean isEmpty() {
        if (StringUtil.hasEmpty(openid, begintime, updatetime)) {
            return true;
        }
        return false;
    }
}
