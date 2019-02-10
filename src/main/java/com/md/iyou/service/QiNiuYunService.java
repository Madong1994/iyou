package com.md.iyou.service;

/**
 * Created by 马东 on 2018/11/5.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 22:32 2018/11/5
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public interface QiNiuYunService {

    /**
     * 创建上传文件token
     * @param imgName 文件名称
     * @return token
     */
    String creatUploadToken(String imgName);

    String downLoadUrl();
}
