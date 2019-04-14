package com.md.iyou.service.run.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.md.iyou.common.CurrenthashMapUtil;
import com.md.iyou.common.HttpClient;
import com.md.iyou.common.SmartDateUtil;
import com.md.iyou.common.StringUtil;
import com.md.iyou.common.wei.WXCore;
import com.md.iyou.entity.*;
import com.md.iyou.mapper.RunDuanMapeer;
import com.md.iyou.mapper.RunMapper;
import com.md.iyou.mapper.UserMapper;
import com.md.iyou.service.run.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 马东 on 2019/3/17.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:02 2019/3/17
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Service
public class RunServiceImpl implements RunService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RunMapper runMapper;
    @Autowired
    private RunDuanMapeer runDuanMapeer;

    private String appid = "wxd661e8966984f99f";
    private String secret = "9fca968dc9039b943ffa102cb25e11ad";
    @Override
    public String login(String code) {
        String strObj = "";
        try {
            strObj = HttpClient.httpGet("https://api.weixin.qq.com/sns/jscode2session?appid="
                    + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strObj;
    }

    @Override
    public String decrypt(String encryptedData, String iv, String sessionKey) {
        String str = WXCore.decrypt(appid, encryptedData, sessionKey, iv);
        return str;
    }

    @Override
    public String addPk(String type, String dor, String loginSession) {
        if (StringUtil.hasEmpty(type, dor, loginSession)) {
            return "FAIL";
        }
        JSONObject jsonObject = CurrenthashMapUtil.get(loginSession);
        String oppenid = (String) jsonObject.get("openid");
        //验证明天是否已经可以比赛
        boolean exitBool = checkExistence(oppenid);
        if (exitBool) {
            return "EXIT";
        }
        String unionid = (String) jsonObject.get("unionid");
        String time = SmartDateUtil.creatNowTime();
        String tomorrowStartTime = SmartDateUtil.tomorrowStartTime();

        /*创建此种类型的活动*/
        String timeTomorrowDate = SmartDateUtil.tomorrowDate();
        RunActivity runActivityArgs = runMapper.queryByTimeAndGrade(timeTomorrowDate, type);
        if (null == runActivityArgs) {
            RunActivity runActivity = new RunActivity();
            runActivity.setGrade(type);
            runActivity.setTime(timeTomorrowDate);
            runActivity.setTotalmoney(0);
            runActivity.setTotalnum(0);
            runMapper.addActivity(runActivity);
        }

        int i = runMapper.addPk(oppenid, unionid, type, dor, time, tomorrowStartTime);
        if (i == 0) {
            return "FAIL";
        }
        return "SUCCESS";
    }

    @Override
    public String addStep(RunStep runStep) {
        RunPk runPk = runMapper.queryByOpenid(runStep.getOpenid(), runStep.getBegintime());
        if (null == runPk) {
            return "NOEXIT";
        }
        RunStep runStepObj = runMapper.selectByOpenidAndTime(runStep.getOpenid(), runStep.getBegintime());
        int i = 0;
        if (null == runStepObj || runStepObj.isEmpty()) {
            //插入数据
            runStep.setType(runPk.getType());
            i = runMapper.insertRunStep(runStep);
        } else {
            //更新数据
            i = runMapper.updateRunStep(runStep.getStep(), runStep.getUpdatetime(), runStep.getOpenid(), runStep.getBegintime());
        }
        if (i == 0) {
            return "FALL";
        }
        return "SUCCESS";
    }

    @Override
    public boolean checkAddTomorrow(String openid) {
        boolean exitBool = checkExistence(openid);
        return exitBool;
    }

    @Override
    public RunRank queryRunRank(String loginSession) {
        String nowTime = SmartDateUtil.todayDate();
        JSONObject jsonObject = CurrenthashMapUtil.get(loginSession);
        if (null == jsonObject) {
            return null;
        }
        String openId = (String) jsonObject.get("openid");
        RunRank runRank = runDuanMapeer.queryByOpenidAndTime(openId, nowTime);
        return runRank;
    }

    @Override
    public List<RunType> queryAllRunType() {
        List<RunType> runTypes = runMapper.queryAllRunType();
        String newDate = SmartDateUtil.tomorrowDate();
        for (RunType runType: runTypes) {
            runType.setDateStr(newDate);
        }
        return runTypes;
    }

    @Override
    public Map<String, Object> rank(int page, String loginSession) {
        JSONObject jsonObject = CurrenthashMapUtil.get(loginSession);
        String oppenid = (String) jsonObject.get("openid");
        String stratTime = SmartDateUtil.todayStartTime();
        RunPk runPk = runMapper.queryByOpenid(oppenid, stratTime);
        String type = runPk.getType();
        String begintime = SmartDateUtil.todayDate();
        RunRankUser runRankUser = userMapper.queryByOpenidAndType(type, oppenid, begintime);

        PageHelper.startPage(page,7);

        List<RunRankUser> runRankUsers = userMapper.queryByType(type, begintime);
//        PageInfo<RunRankUser> pageInfo = new PageInfo<>(runRankUsers);
        Map<String, Object> reMap = new HashMap<>();
        reMap.put("userRank", runRankUser);
        reMap.put("userRunks", runRankUsers);
        return reMap;
    }

    /**
     * 检查当前用户是否已经参加过
     * @param openid
     * @return
     */
    private boolean checkExistence(String openid) {
        String todayStartTime = SmartDateUtil.tomorrowStartTime();
        RunPk pk = runMapper.queryByOpenid(openid, todayStartTime);
        if (null == pk) {
            return false;
        }
        return true;
    }
}
