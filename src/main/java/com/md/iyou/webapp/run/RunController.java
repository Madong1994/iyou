package com.md.iyou.webapp.run;

import cn.hutool.bloomfilter.filter.ELFFilter;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.md.iyou.common.CurrenthashMapUtil;
import com.md.iyou.common.SmartDateUtil;
import com.md.iyou.common.StringUtil;
import com.md.iyou.entity.RunRank;
import com.md.iyou.entity.RunStep;
import com.md.iyou.entity.RunType;
import com.md.iyou.entity.RunUser;
import com.md.iyou.service.run.RunService;
import com.md.iyou.service.run.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 马东 on 2019/3/17.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 8:48 2019/3/17
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@RestController
public class RunController {
    @Autowired
    private RunService runService;
    @Autowired
    private UserService userService;
    @RequestMapping("/run/add")
    public String add(String type, String dor, String loginSession) {
        String res = runService.addPk(type, dor, loginSession);
        return res;
    }
    @RequestMapping("/run/login")
    public String login(String code, String nickname, String avatarurl) {
        String str = runService.login(code);
        String simpleUUID = IdUtil.simpleUUID();
        JSONObject jsonObject = new JSONObject(str);
        userService.register(jsonObject, nickname, avatarurl);
        CurrenthashMapUtil.put(simpleUUID, jsonObject);
        return simpleUUID;
    }
    @RequestMapping("/run/base")
    public Map<String, String> baseData(String loginSession) {
        RunRank runRank = runService.queryRunRank(loginSession);
        Map<String, String> map = new HashMap<>();
        if (null == runRank) {
            map.put("res","fail");
            return map;
        }
        map.put("totalnum",runRank.getTotalnum() + "");
        map.put("res", "secuss");
        map.put("ranking", runRank.getRanking() + "");
        map.put("grade", runRank.getGrade());
        map.put("money", runRank.getMoney());
        return map;
    }
    @RequestMapping("/run/decrypt")
    public Map<String, Object> decrypt(String encryptedData, String iv, String loginSession) {
        JSONObject jsonObject = CurrenthashMapUtil.get(loginSession);
        String openid = (String) jsonObject.get("openid");
        String startTime = SmartDateUtil.todayStartTime();
        /*验证明天是否已经报名*/
        boolean checkBool = runService.checkAddTomorrow(openid);
        /*解密数据*/
        String str = runService.decrypt(encryptedData, iv, jsonObject.getStr("session_key"));
        JSONObject stepObj = new JSONObject(str);
        JSONArray jsonArray = (JSONArray) stepObj.get("stepInfoList");

        RunStep runStep = new RunStep();
        runStep.setOpenid(openid);
        JSONObject stepJsonObj = new JSONObject(jsonArray.get(jsonArray.size() - 1));
        runStep.setStep((Integer) stepJsonObj.get("step"));
        runStep.setUpdatetime(SmartDateUtil.creatNowTime());
        runStep.setBegintime(startTime);
        String res = runService.addStep(runStep);

        Map<String, Object> resMap = new HashMap<>();
        String stepStr = String.valueOf(stepJsonObj.get("step"));
        resMap.put("step", stepStr);
        resMap.put("res", res);
        resMap.put("addBool", checkBool);
        return resMap;
    }
    @RequestMapping("/run/type")
    public Map<String, Object> queryAllRunType() {
        List<RunType> runTypes = runService.queryAllRunType();
        Map<String, Object> map = new HashMap<>();
        if (null == runTypes || runTypes.isEmpty()) {
            map.put("res", "NOEXIT");
        } else {
            map.put("res", "SECUSS");
        }
        map.put("runTypes", runTypes);
        return map;
    }
    @RequestMapping("/run/user")
    public Map<String, String> userData(String loginSession) {
        RunUser runUser = userService.queryRunUser(loginSession);
        Map<String, String> map = new HashMap<>();
        if (null == runUser) {
            map.put("res", "NOTEXIT");
        } else {
            map.put("res", "SECUSS");
            map.put("money", runUser.getMoney());
        }
        return map;
    }
    @RequestMapping("/run/record")
    public List<RunRank> reord(String loginSession) {
        return userService.queryListByOpenid(loginSession);
    }
    @RequestMapping("/run/ranks")
    public Map<String, Object> rank(int page, String loginSession) {
        if (StringUtil.hasEmpty(loginSession)) {
            return null;
        }
        Map<String, Object> mmap = runService.rank(page, loginSession);
        return mmap;
    }
}
