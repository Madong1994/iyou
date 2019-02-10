package com.md.iyou.service.impl;

import com.md.iyou.common.ConQiNiu;
import com.md.iyou.service.QiNiuYunService;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Service;
/**
 * Created by 马东 on 2018/11/5.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 22:33 2018/11/5
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
@Service
public class QiNiuYunServiceImpl implements QiNiuYunService {
    @Override
    public String creatUploadToken(String imgName) {
        String accessKey = "zihQw7zlwkzQQ_bnbyYpDhqDAtTi2xZzgKcC14n2";
        String secretKey = "6fjy2UiOWzuQEYS489AgWQtlZ4Bt7PSiRxgwFpRX";
        String bucket = "hot1";
        Auth auth = Auth.create(accessKey, secretKey);
//        StringMap putPolicy = new StringMap();
//        putPolicy.put("callbackUrl", "http://api.example.com/qiniu/upload/callback");
//        putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
//        putPolicy.put("callbackBodyType", "application/json");
//        long expireSeconds = 3600;
//        String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
//        System.out.println(upToken);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }

    @Override
    public String downLoadUrl() {
        String accessKey = "zihQw7zlwkzQQ_bnbyYpDhqDAtTi2xZzgKcC14n2";
        String secretKey = "6fjy2UiOWzuQEYS489AgWQtlZ4Bt7PSiRxgwFpRX";
        String bucket = "hot1";
        Auth auth = Auth.create(accessKey, secretKey);
        auth.privateDownloadUrl("http://plseoieh0.bkt.clouddn.com/demo.jpg", 36000);
        return null;
    }

    public static void main(String[] args) {
        String accessKey = "zihQw7zlwkzQQ_bnbyYpDhqDAtTi2xZzgKcC14n2";
        String secretKey = "6fjy2UiOWzuQEYS489AgWQtlZ4Bt7PSiRxgwFpRX";
//        String bucket = "hot1";
        Auth auth = Auth.create(accessKey, secretKey);
        String tokenUrl = auth.privateDownloadUrl("http://plseoieh0.bkt.clouddn.com/d1.jpg");
        System.out.println(tokenUrl);
    }
}
