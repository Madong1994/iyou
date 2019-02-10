package com.md.iyou.service;

import com.github.pagehelper.PageInfo;
import com.md.iyou.entity.Information;

import java.util.List;

/**
 * Created by 马东 on 2018/10/16.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 20:23 2018/10/16
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public interface InformationService {
    /**
     * 保存发布的信息
     * @param information
     */
    void save(Information information);

    /**
     * 查询发布的信息
     * @param weId 微信id
     * @return 信息列表
     */
    List<Information> findByWeId(String weId);

    /**
     * 通过地址分页查询发布的信息
     * @param page
     * @param pageSize
     * @param address
     * @return
     */
    PageInfo allRecordInfo(int page,int pageSize, String address);
}
