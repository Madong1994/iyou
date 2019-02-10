package com.md.iyou.entity;

import com.md.iyou.common.StringUtil;

/**
 * Created by 马东 on 2018/10/16.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 20:12 2018/10/16
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class Information {
    private Integer id;
    /**
     * 描述
     */
    private String describeStr;
    /**
     * 约定时间
     */
    private String appointTime;
    /**
     * 大地点
     */
    private String bidAddress;
    /**
     * 约定地址
     */
    private String address;
    /**
     * 照片1
     */
    private String photo1;
    /**
     * 照片2
     */
    private String photo2;
    /**
     * 照片3
     */
    private String photo3;
    /**
     * 见面暗号
     */
    private String blackCode;
    /**
     * 电话号码
     */
    private String phoneNum;
    /**
     * 创建时间
     */
    private String creTime;
    /**
     * 类型
     */
    private String infoType;
    /**
     * 状态，默认0；结束为1
     */
    private String infoState;
    /**
     * 微信id
     */
    private String weId;
    private String weicon;
    private String location;

    public String getWeicon() {
        return weicon;
    }

    public void setWeicon(String weicon) {
        this.weicon = weicon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeId() {
        return weId;
    }

    public void setWeId(String weId) {
        this.weId = weId;
    }

    public String getBidAddress() {
        return bidAddress;
    }

    public void setBidAddress(String bidAddress) {
        this.bidAddress = bidAddress;
    }

    public String getInfoState() {
        return infoState;
    }

    public void setInfoState(String infoState) {
        this.infoState = infoState;
    }

    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescribeStr() {
        return describeStr;
    }

    public void setDescribeStr(String describeStr) {
        this.describeStr = describeStr;
    }

    public String getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(String appointTime) {
        this.appointTime = appointTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getBlackCode() {
        return blackCode;
    }

    public void setBlackCode(String blackCode) {
        this.blackCode = blackCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * 判断是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        if (StringUtil.hasEmpty(describeStr, address, appointTime, infoType)) {
            return true;
        }
        return false;
    }
}
