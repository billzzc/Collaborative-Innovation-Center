package com.aiit.hexlab.system;

import cn.hutool.http.HttpUtil;
import com.aiit.hexlab.common.utils.http.HttpUtils;
import com.aiit.hexlab.system.constant.AmapConstant;
import com.alibaba.fastjson2.JSONObject;

public class LocationUtils {

    public static String getLocation(String address) {
        String s = HttpUtils.sendGet(AmapConstant.LOCATION_SEARCH_URL, "key=2aff5b5f28cbf1d06081b4f7b3a29333" +
                "&types=&city=杭州&children=1&offset=1&page=1&extensions=base" +
                "&keywords=" + address);
        try {
            JSONObject jsonObject = JSONObject.parseObject(s);
            if (jsonObject.getInteger("status") == 1) {
                JSONObject jsonObject1 = jsonObject.getJSONArray("pois").getJSONObject(0);
                return jsonObject1.getString("location");
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
