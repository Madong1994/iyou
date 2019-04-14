package com.md.iyou.service.run.impl;

import cn.hutool.json.JSONObject;
import com.md.iyou.common.CurrenthashMapUtil;
import com.md.iyou.common.StringUtil;
import com.md.iyou.entity.Bonus;
import com.md.iyou.mapper.BonusMapper;
import com.md.iyou.mapper.UserMapper;
import com.md.iyou.service.run.KefuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KefuServiceImpl implements KefuService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BonusMapper bonusMapper;
    @Override
    public boolean updateUserData(String nickName, String avatarUrl, String loginSession) {
        if (StringUtil.hasEmpty(nickName, avatarUrl, loginSession)) {
            return false;
        }
        JSONObject jsonObject = CurrenthashMapUtil.get(loginSession);
        String openid = (String) jsonObject.get("openid");
        Bonus bonus = bonusMapper.selectByOpenid(openid);
        if (bonus.getUpd() == 1) {
            return true;
        }
        userMapper.updateUser(nickName, avatarUrl, openid);
        bonusMapper.updateUpd(1, openid);
        return true;
    }
}
