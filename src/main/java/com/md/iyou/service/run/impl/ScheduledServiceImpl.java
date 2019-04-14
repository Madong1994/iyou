package com.md.iyou.service.run.impl;

import com.md.iyou.common.SmartDateUtil;
import com.md.iyou.entity.RunActivity;
import com.md.iyou.entity.RunDuan;
import com.md.iyou.entity.RunRank;
import com.md.iyou.entity.RunStep;
import com.md.iyou.mapper.RunDuanMapeer;
import com.md.iyou.mapper.RunMapper;
import com.md.iyou.mapper.UserMapper;
import com.md.iyou.service.run.RunService;
import com.md.iyou.service.run.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 马东 on 2019/3/25.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 11:03 2019/3/25
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Component
public class ScheduledServiceImpl implements ScheduledService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RunMapper runMapper;
    @Autowired
    private RunDuanMapeer runDuanMapeer;
    /**
     * 1、更新活动表中总人数，总金额
     * 2、更新每个用户的排名，段位
     * 3、计算每个人当前的段位，收益
     */
    @Scheduled(cron = "0 */1 * * * ?")
    @Override
    public void scheduled() {
        /*1、获取出所有的活动类型*/
        String todayDate = SmartDateUtil.todayDate();
        List<RunActivity> activities = runMapper.queryByTime(todayDate);
        List<RunDuan> runDuanList = runDuanMapeer.queryAllDuan();
        Map<String, RunRank> rankMap = new HashMap<>();
        List<RunRank> runRanks = runDuanMapeer.queryAll(todayDate);
        for (RunRank runRank: runRanks) {
            rankMap.put(runRank.getOpenid(), runRank);
        }
        for (RunActivity activity: activities) {
            totalType(activity, runDuanList, rankMap);
        }
    }

    /**
     * 统计不同类型活动的数据
     * 1、倒叙查询此种活动类型的所有数据，得到活动总人数和活动总金额
     * 2、倒叙查询获得每个人的排名
     * 3、保存数据，保存前检查是更新还是新增
     * @param activity 活动对象
     */
    private void totalType(RunActivity activity, List<RunDuan> runDuanList, Map<String, RunRank> rankMap) {
        String todayDate = SmartDateUtil.todayDate();
        String nowtimeStart = SmartDateUtil.todayStartTime();
        List<RunStep> runSteps = runMapper.selectByBeginTime(nowtimeStart, activity.getGrade());

        int activityTotalNum = runSteps.size();
        int totalMoney = (int) (activityTotalNum * Long.parseLong(activity.getGrade()));
        activity.setTotalmoney(totalMoney);
        activity.setTotalnum(activityTotalNum);
        runMapper.updateActivity( activityTotalNum, totalMoney, activity.getTime(), activity.getGrade());
        for (int i = 0; i < runSteps.size(); i++ ) {
            RunStep runStep = runSteps.get(i);
            RunRank runRank = new RunRank();
            runRank.setOpenid(runStep.getOpenid());
            runRank.setBegintime(todayDate);
            runRank.setTotalnum(activityTotalNum);

            RunDuan duan = duan(runDuanList, i + 1, activityTotalNum);
            String grade = duan.getName();
            String moeny = money(duan, i + 1, activityTotalNum, totalMoney);
            runRank.setGrade(grade);
            runRank.setMoney(moeny);
            runRank.setRanking(i + 1);
            runRank.setStep(runStep.getStep());
            RunRank runRank1 = rankMap.get(runStep.getOpenid());
            runRank.setType(activity.getGrade());
            if (null == runRank1) {
                //插入
                runDuanMapeer.insertRank(runRank);
            } else {
                //更新
                runDuanMapeer.updateRank(runRank);
            }
            if (SmartDateUtil.betweenTime(SmartDateUtil.todayDate() + " 23:33:23")) {
                //当天最后一次扫描数据
                userMapper.updateUserMoneyByOpenid(moeny, runStep.getOpenid());
            }
        }

    }
    /**
     * double 保留两位有效数字。
     * DecimalFormat is a concrete subclass of NumberFormat that formats decimal numbers.
     * @param d
     * @return
     */
    private String formatDouble2(double d) {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.DOWN);
        String res = df.format(d);
        if (res.equals(".00")) {
            return "0.00";
        }
        return df.format(d);
    }

    public static void main(String[] args) {
        ScheduledServiceImpl scheduledService = new ScheduledServiceImpl();
        System.out.println(scheduledService.formatDouble2(12.358));
    }
    private String money(RunDuan runDuan,int rank, int total, int totalMoney) {
        if (total < 34 && rank <= 3) {
            return formatDouble2(totalMoney / 3.0);
        }
        int peo = runDuan.getUpper() / 100 * total;
        if (peo == 0) {
            return "0.00";
        }
        String tatmoney = formatDouble2((runDuan.getRoportion() / 100.0 * totalMoney) / peo);
        return tatmoney;
    }
    private RunDuan duan( List<RunDuan> runDuanList, int rank, int total) {
        float ra = rank;
        float tota = total;
        float a = (ra / tota) * 100;
        int i = (int) a;
        if (total < 34 && rank <= 3) {
            i = 1;
        }
        for (RunDuan runDuan: runDuanList) {
            int lower = runDuan.getLower();
            int upper = runDuan.getUpper();
            if (i > lower && i <= upper) {
                return runDuan;
            }
        }
        return null;
    }
}
