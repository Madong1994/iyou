package com.md.iyou.service.run;

import cn.hutool.json.JSONObject;
import com.md.iyou.entity.Bonus;
import com.md.iyou.entity.RunRank;
import com.md.iyou.entity.RunUser;

import java.util.List;

/**
 * Created by 马东 on 2019/3/28.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:36 2019/3/28
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public interface UserService {
    void register(JSONObject jsonObject, String nickName, String avatarurl);

    RunUser queryRunUser(String loginSession);

    boolean hasBonus(String loginSession);

    List<RunRank> queryListByOpenid(String loginSession);
}
