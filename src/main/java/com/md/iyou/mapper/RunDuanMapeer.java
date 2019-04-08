package com.md.iyou.mapper;

import com.md.iyou.entity.RunDuan;
import com.md.iyou.entity.RunRank;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 马东 on 2019/3/25.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 14:20 2019/3/25
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Mapper
public interface RunDuanMapeer {
    @Select("select * from run_duan")
    List<RunDuan> queryAllDuan();
    @Select("select * from run_ranking where begintime = #{time}")
    List<RunRank> queryAll(@Param("time") String time);

    @Insert("insert into run_ranking (openid, begintime, ranking, grade, money, totalnum, step, type) values (#{runRank.openid}, #{runRank.begintime}, #{runRank.ranking}, #{runRank.grade}, #{runRank.money}, #{runRank.totalnum}, #{runRank.step}, #{runRank.type})")
    void insertRank(@Param("runRank") RunRank runRank);

    @Update("update run_ranking set ranking = #{runRank.ranking}, grade = #{runRank.grade}, money = #{runRank.money}, totalnum= #{runRank.totalnum}, step = #{runRank.step} where begintime = #{runRank.begintime} and openid = #{runRank.openid}")
    void updateRank(@Param("runRank") RunRank runRank);

    @Select("select ranking, grade, money, totalnum from run_ranking where openid = #{openid} and begintime= #{begintime}")
    RunRank queryByOpenidAndTime(@Param("openid") String openid, @Param("begintime") String time);

    @Select("select ranking, grade, money, totalnum, step, begintime from run_ranking where openid = #{openid} order by begintime desc limit 10")
    List<RunRank> queryListByOpenid(@Param("openid") String openid);
}
