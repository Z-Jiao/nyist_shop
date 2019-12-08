package com.nyist_shop.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取系统当前时间进行类型转换
 */
public class Time {
    public String getTime() {
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createTime = sdf.format(date);
        return createTime;
    }
}
