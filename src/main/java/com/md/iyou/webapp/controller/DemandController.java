package com.md.iyou.webapp.controller;

import com.github.pagehelper.PageInfo;
import com.md.iyou.common.ConCode;
import com.md.iyou.entity.ConciseInfo;
import com.md.iyou.entity.Information;
import com.md.iyou.entity.ResponseMsg;
import com.md.iyou.webapp.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 马东 on 2018/10/16.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 20:09 2018/10/16
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@RestController
@RequestMapping("/iyou")
public class DemandController extends BaseController {

    /**
     * 发布信息
     */
    @RequestMapping("/info")
    public ResponseMsg releaseInformation(Information information) {
        if (information.isEmpty()) {
            //数据输入不能为空
            ResponseMsg responseMsg = new ResponseMsg();
            responseMsg.setCode(ConCode.FAIL_CODE);
            responseMsg.setMsg("输入数据不能为空！");
            return responseMsg;
        }
        informationService.save(information);
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg.setCode(ConCode.SUCCESS_CODE);
        return responseMsg;
    }

    /**
     * 查询发布信息
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/byLocation")
    public PageInfo<ConciseInfo> allRecordInfo(int page,int pageSize, String location) {
        if (pageSize > 15) {
            pageSize = 15;
        }
        PageInfo<ConciseInfo> conciseInfoPageInfo = informationService.allRecordInfo(page, pageSize, location);
        return conciseInfoPageInfo;
    }
    @RequestMapping("/get/token")
    @ResponseBody
    public String token() {
        return qiNiuYunService.creatUploadToken("demo.jpg");
    }
    /**
     * 查询发布的记录 by微信id
     * @return Information列表
     */
    public List<Information> recordInfo(String weId) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
