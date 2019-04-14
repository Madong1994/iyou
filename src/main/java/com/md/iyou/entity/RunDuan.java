package com.md.iyou.entity;

/**
 * Created by 马东 on 2019/3/25.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 14:19 2019/3/25
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class RunDuan {
    private int id;
    private int lower;
    private int upper;
    private int roportion;
    private String name;

    public int getRoportion() {
        return roportion;
    }

    public void setRoportion(int roportion) {
        this.roportion = roportion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
