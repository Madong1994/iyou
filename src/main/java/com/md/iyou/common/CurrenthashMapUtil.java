package com.md.iyou.common;

import cn.hutool.json.JSONObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 马东 on 2019/3/20.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 20:51 2019/3/20
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class CurrenthashMapUtil {
    private static ConcurrentHashMap<String, JSONObject> currentHashMap = new ConcurrentHashMap();

    public static void put(String key, JSONObject value) {
        String openidValue = (String) value.get("openid");
        boolean cun = false;
        for (Map.Entry<String, JSONObject> entry: currentHashMap.entrySet()) {
            JSONObject jsonObject = entry.getValue();
            String keyStr = entry.getKey();
            String openid = (String) jsonObject.get("openid");
            if (openid.equals(openidValue)) {
                currentHashMap.remove(keyStr);
                break;
            }
        }
        currentHashMap.put(key, value);
    }
    public static JSONObject get(String key) {
        return currentHashMap.get(key);
    }
}
