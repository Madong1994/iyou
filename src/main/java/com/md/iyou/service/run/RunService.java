package com.md.iyou.service.run;

import com.md.iyou.entity.RunRank;
import com.md.iyou.entity.RunStep;
import com.md.iyou.entity.RunType;

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
public interface RunService {
    String login(String code);

    String decrypt(String encryptedData, String iv, String sessionKey);

    String addPk(String type, String dor, String loginSession);

    String addStep(RunStep runStep);

    boolean checkAddTomorrow(String openid);

    RunRank queryRunRank(String loginSession);

    List<RunType> queryAllRunType();

    Map<String, Object> rank(int page, String loginSession);
}
