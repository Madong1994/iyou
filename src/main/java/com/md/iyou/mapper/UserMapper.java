package com.md.iyou.mapper;

import com.md.iyou.entity.RunRankUser;
import com.md.iyou.entity.RunUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 马东 on 2019/3/28.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:33 2019/3/28
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Mapper
public interface UserMapper {
    @Select("select id, money from run_user where openid = #{openid}")
    RunUser queryRunUser(@Param("openid") String openid);

    @Select("select unionid, nickname, avatarurl from run_user where openid = #{openid}")
    RunUser queryRunUserByOpenId(@Param("openid") String openid);

    @Insert("insert into run_user (openid, unionid, money,nickname,avatarurl) values (#{runUser.openid}, #{runUser.unionid}, #{runUser.money}, #{runUser.nickname}, #{runUser.avatarurl})")
    int insertUser(@Param("runUser") RunUser runUser);

    @Select("select nickname, avatarurl, step, grade, ranking FROM run_user ru JOIN run_ranking rr ON ru.openid = rr.openid  WHERE rr.type = #{type} AND rr.openid = #{openid} AND rr.begintime= #{begintime}")
    RunRankUser queryByOpenidAndType(@Param("type") String type, @Param("openid") String openid, @Param("begintime") String begintime);

    @Select("select nickname, avatarurl, step, grade, ranking FROM run_user ru JOIN run_ranking rr ON ru.openid = rr.openid  WHERE rr.type = #{type} AND rr.begintime = #{begintime} order by ranking asc")
    List<RunRankUser> queryByType(@Param("type") String type, @Param("begintime") String begintime);

    @Update("update run_user set money = #{moeny} where openid = #{openid}")
    int updateUserMoneyByOpenid(@Param("moeny") String money, @Param("openid") String openid);

    @Update("UPDATE run_user SET nickname =#{nickName}, avatarurl = #{avatarUrl} where openid = #{openid}")
    int updateUser(@Param("nickName") String nickName, @Param("avatarUrl") String avatarUrl, @Param("openid") String openid);
}
