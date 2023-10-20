package com.hero.mvpherodemo.student.util;

import com.hero.mvpherodemo.student.bean.StudentBean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * Json数据解析类
 */

public class ParseJsonUtil {

    public static StudentBean parseJSONData(String data) {
        StudentBean dataInfo = new StudentBean();
        try {
            JSONObject jsonObject = new JSONObject(data);
            dataInfo.setmName(jsonObject.optString("mData"));
            dataInfo.setmGender(jsonObject.optString("gender"));
            dataInfo.setmAge(jsonObject.optInt("age"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataInfo;
    }
}
