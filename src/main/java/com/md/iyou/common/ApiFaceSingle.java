package com.md.iyou.common;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 马东 on 2019/3/5.
 * 百度人脸检测接口api
 * @Author:madong
 * @Description:
 * @Date:Create in 23:08 2019/3/5
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class ApiFaceSingle {
    public static final String APP_ID = "15690137";
    public static final String API_KEY = "3H1A5U2W4UyLMccA4pMDhi3L";
    public static final String SECRET_KEY = "rGG3ggZIA8jYIuvFb2Bal77Zcf8mMi6V";
    private static ApiFaceSingle instance = null;

    private AipFace client = null;

    private ApiFaceSingle() {}

    public static ApiFaceSingle getInstance() {
        if (instance == null) {
            synchronized (ApiFaceSingle.class) {
                if (instance == null) {
                    instance = new ApiFaceSingle();
                    instance.initApiFace();
                }
            }
        }
        return instance;
    }
    private void initApiFace() {
        client =  new AipFace(APP_ID, API_KEY, SECRET_KEY);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    /**
     * 人脸检测
     * @param imgPath 待检测图片路径
     */
    public String detect(String imgPath) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
        options.put("max_face_num", "1");
        options.put("face_type", "LIVE");
        options.put("face_field", "age,beauty,expression,faceshape,gender,glasses,landmark,race,quality,facetype");

        String image = "http://pnzcoor3o.bkt.clouddn.com/test2";
        String imageType = "URL";

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));
        return res.toString();
    }

    public static void main(String[] args) {
        ApiFaceSingle.getInstance().detect("");
    }
}
