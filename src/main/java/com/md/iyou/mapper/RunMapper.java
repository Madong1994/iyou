package com.md.iyou.mapper;

import com.md.iyou.entity.RunActivity;
import com.md.iyou.entity.RunPk;
import com.md.iyou.entity.RunStep;
import com.md.iyou.entity.RunType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 马东 on 2019/3/21.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 17:45 2019/3/21
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Mapper
public interface RunMapper {
    @Update("update run_step set step = #{step}, updatetime = #{updatetime} where openid = #{openid} and begintime = #{begintime}")
    int updateRunStep(@Param("step") int step, @Param("updatetime") String updatetime, @Param("openid") String openid, @Param("begintime") String begintime);
    @Insert("insert into run_step (openid, begintime, updatetime, step, type) values (#{runStep.openid}, #{runStep.begintime}, #{runStep.updatetime}, #{runStep.step}, #{runStep.type})")
    int insertRunStep(@Param("runStep") RunStep runStep);

    @Select("select id, openid, updatetime, begintime, step from run_step where openid = #{openid} and begintime = #{begintime}")
    RunStep selectByOpenidAndTime(@Param("openid") String openid, @Param("begintime") String begintime);

    /**
     *
     * @param beginTime
     * @return
     */
    @Select("select id, openid, updatetime, begintime, step, type from run_step where begintime = #{beginTime} and type = #{type}  order by step desc")
    List<RunStep> selectByBeginTime(@Param("beginTime") String beginTime,@Param("type") String type);

    @Select("select time,type from run_pk where openid = #{openid} and begintime = #{begintime} ")
    RunPk queryByOpenid(@Param("openid") String openid, @Param("begintime") String todayStartTime);
    @Insert("INSERT INTO run_pk (openid, unionid, type, dor, time, begintime)values (#{openid}, #{unionid}, #{type}, #{dor}, #{time}, #{begintime})")
    int addPk(@Param("openid") String openid, @Param("unionid") String unionid,
              @Param("type") String type, @Param("dor") String dor,
              @Param("time") String time, @Param("begintime") String todayStartTime);


    @Insert("insert into run_activity (time, totalnum, grade, totalmoney) values (#{runActivity.time}, #{runActivity.totalnum}, #{runActivity.grade}, #{runActivity.totalmoney})")
    int addActivity(@Param("runActivity") RunActivity runActivity);

    @Select("select * from run_activity where time = #{time} and grade = #{grade}")
    RunActivity queryByTimeAndGrade(@Param("time") String time, @Param("grade") String grade);
    @Select("select * from run_activity where time = #{time}")
    List<RunActivity> queryByTime(@Param("time") String time);

    @Update("update run_activity set totalnum = #{totalnum}, totalmoney = #{totalmoney} where time = #{time} and grade = #{type}")
    void updateActivity(@Param("totalnum") int totalnum, @Param("totalmoney")int totalmoney, @Param("time")String time, @Param("type") String type);

    @Select("select * from run_type")
    List<RunType> queryAllRunType();
}
