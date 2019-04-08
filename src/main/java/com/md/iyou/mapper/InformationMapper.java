package com.md.iyou.mapper;

import com.md.iyou.entity.ConciseInfo;
import com.md.iyou.entity.Information;
import com.md.iyou.entity.RunStep;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 马东 on 2018/10/16.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 20:24 2018/10/16
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Mapper
public interface InformationMapper {
    /**
     * 插入发布的数据
     * @param information 发布的数据对象
     */
    @Insert("insert into iyou_infomation (describeStr, appointTime, address, photo1, photo2," +
            " photo3, blackCode, creTime, phoneNum, infoType, infoState, bidAddress, weId, weicon, location) " +
            "values (#{describeStr}, #{appointTime}, #{address}, #{photo1}, #{photo2}, #{photo3}," +
            "#{blackCode}, #{creTime}, #{phoneNum}, #{infoType}, #{infoState}, #{bidAddress}, #{weId}, #{weicon}, #{location})")
    void insertInfo(Information information);

    @Select("select creTime, infoType, describeStr from iyou_infomation")
    List<Information> findByWeId(String weId);

    @Select("select weicon, creTime, infoType, describeStr from iyou_infomation where location = #{location}")
    List<ConciseInfo> findByAdress(String location);
}
