package com.tasly.yzpt.common.util;

/**
 * Created by Talsy_xiashengxin on 2018/10/31.
 */
public class WidUtil {
    public static String get(Long id) {
        return "YZ" + GeneratorUtil.getFormatted(id.longValue(), 10, "", "");
    }
}
