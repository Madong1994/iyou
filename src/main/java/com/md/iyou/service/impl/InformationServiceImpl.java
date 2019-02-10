package com.md.iyou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.md.iyou.common.SmartDateUtil;
import com.md.iyou.entity.ConciseInfo;
import com.md.iyou.entity.Information;
import com.md.iyou.mapper.InformationMapper;
import com.md.iyou.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Override
    public void save(Information information) {
//        String time = SmartDateUtil.creatNowTime();
//        information.setCreTime(time);
        information.setInfoState("0");
        informationMapper.insertInfo(information);
    }

    @Override
    public List<Information> findByWeId(String weId) {
        return null;
    }

    @Override
    public PageInfo allRecordInfo(int page, int pageSize, String address) {
        PageHelper.startPage(page,pageSize);
        List<ConciseInfo> list = informationMapper.findByAdress(address);
        PageInfo<ConciseInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
