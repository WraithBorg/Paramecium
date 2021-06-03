package com.zxu.dto;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SpushNoticeExtend {
    private SpushNoticeDto notice = new SpushNoticeDto();

    public SpushNoticeExtend () {
        this.notice.setId(UUID.randomUUID().toString());
    }

    /************************************* Other *************************************/
    public void title (String val) {
        notice.getTitle().put("text", val);
        notice.getTitle().put("color", "#000000");
    }

    public void subtitle (String val) {
        notice.getSubtitle().put("text", val);
        notice.getSubtitle().put("color", "#999999");
    }

    public void bottom (String val) {
        if (val == null){
            notice.setBottom(null);
            return;
        }
        notice.getBottom().put("text", val);
        notice.getBottom().put("color", "#000aaa");
    }

    public void mainlistAdd (String left, String right) {
        Map<String, String> leftMap = new HashMap<>();
        leftMap.put("text", left);
        leftMap.put("color", "#999999");

        Map<String, String> rightMap = new HashMap<>();
        rightMap.put("text", right);
        rightMap.put("color", "#384D92");

        Map<String, Map> out = new HashMap<>();
        out.put("left", leftMap);
        out.put("right", rightMap);

        notice.getMainlist().add(out);
    }


    public String getJson () {
        return JSON.toJSONString(notice);
    }
    public String getJson4Array () {
        List<SpushNoticeDto> list = new ArrayList<>();
        list.add(notice);
        return JSON.toJSONString(list);
    }
}
