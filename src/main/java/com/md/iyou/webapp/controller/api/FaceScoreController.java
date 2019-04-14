package com.md.iyou.webapp.controller.api;

import com.md.iyou.common.ApiFaceSingle;
import com.md.iyou.service.QiNiuYunService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 马东 on 2019/3/6.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 23:50 2019/3/6
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@RestController
@RequestMapping("/api")
public class FaceScoreController {
    @Autowired
    private  QiNiuYunService qiNiuYunService;

    @RequestMapping("/score")
    public String score(String imgPath) {
        return ApiFaceSingle.getInstance().detect(imgPath);
    }
    @RequestMapping("/uptoken")
    @ResponseBody
    public Map<String, String> token() {
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("uptoken", qiNiuYunService.creatUploadToken(""));
        return tokenMap;
    }
}
