package com.zzp.phone.stage.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 手机工具
 * <p>
 *  //TODO
 *  PhoneUtil.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/5/25 21:41
 * @see  PhoneUtil
 **/
public class PhoneUtil {
    /**
     * 根据tag字符创建tag信息
     * @param tag tag字符串
     * @return {@link List<Map<String,String>>}
     */
    public static List<Map<String,String>> createTag(String tag){
        String[] tags = tag.split("&");
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map;
        for (String s : tags) {
            map = new HashMap<>(16);
            map.put("name",s);
            list.add(map);
        }
        return list;
    }
}

