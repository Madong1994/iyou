package com.md.iyou.service.run.impl;

import cn.hutool.json.JSONObject;
import com.md.iyou.common.CurrenthashMapUtil;
import com.md.iyou.entity.RunRank;
import com.md.iyou.entity.RunUser;
import com.md.iyou.mapper.RunDuanMapeer;
import com.md.iyou.mapper.UserMapper;
import com.md.iyou.service.run.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 马东 on 2019/3/28.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:37 2019/3/28
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    protected UserMapper userMapper;
    @Autowired
    private RunDuanMapeer runDuanMapeer;
    @Override
    public void register(JSONObject jsonObject, String nickName, String avatarurl) {
        String openid = (String) jsonObject.get("openid");
        RunUser runUserBool = userMapper.queryRunUser(openid);
        if (null == runUserBool) {
            //注册
            String unionid = (String) jsonObject.get("unionid");
            RunUser runUser = new RunUser();
            runUser.setOpenid(openid);
            runUser.setUnionid(unionid);
            runUser.setMoney("0.00");
            runUser.setAvatarurl(avatarurl);
            runUser.setNickname(nickName);
            userMapper.insertUser(runUser);
        }
    }

    @Override
    public RunUser queryRunUser(String loginSession) {
        JSONObject jsonObject = CurrenthashMapUtil.get(loginSession);
        String openid = (String) jsonObject.get("openid");
        RunUser runUser = userMapper.queryRunUser(openid);
        return runUser;
    }

    /**
     * 查询前10条记录
     * @param loginSession
     * @return
     */
    @Override
    public List<RunRank> queryListByOpenid(String loginSession) {
        JSONObject jsonObject = CurrenthashMapUtil.get(loginSession);
        if (null == jsonObject) {
            return null;
        }
        String openid = (String) jsonObject.get("openid");
        return runDuanMapeer.queryListByOpenid(openid);
    }
}
