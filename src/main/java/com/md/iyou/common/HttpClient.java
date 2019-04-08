package com.md.iyou.common;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by 马东 on 2019/3/17.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 18:05 2019/3/17
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class HttpClient {
    public static final MediaType type = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
    public static final OkHttpClient httpClient = new OkHttpClient(); //Get方法调用服务
    public static String httpGet(String url) throws IOException {
        Request request = new Request.Builder() .url(url) .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();// 返回的是string 类型
    }
    //Post方法调用服务
    public static String httpPost(HttpUrl url,String content) throws IOException{
        RequestBody requestBody = RequestBody.create(type,content);
        Request request = new Request.Builder() .url(url) .post(requestBody) .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

}
