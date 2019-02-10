package com.md.iyou.webapp;

import com.md.iyou.service.InformationService;
import com.md.iyou.service.QiNiuYunService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 马东 on 2018/10/16.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 20:07 2018/10/16
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class BaseController {
    @Autowired
    protected InformationService informationService;
    @Autowired
    protected QiNiuYunService qiNiuYunService;
}
