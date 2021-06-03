package com.zxu.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpushNoticeDto {
    @JSONField(name = "id", ordinal = 1)
    private String id;
    @JSONField(name = "title", ordinal = 2)
    private Map<String, Object> title = new HashMap<>();
    @JSONField(name = "subtitle", ordinal = 3)
    private Map<String, Object> subtitle = new HashMap<>();
    @JSONField(name = "bottom", ordinal = 4)
    private Map<String, Object> bottom = new HashMap<>();
    @JSONField(name = "mainlist", ordinal = 5)
    private List<Map<String, Map>> mainlist = new ArrayList<>();

    /************************************* Constructor *************************************/
    @Override
    public String toString () {
        return "SpushNoticeDto{" +
                "id='" + id + '\'' +
                ", title=" + title +
                ", subtitle=" + subtitle +
                ", bottom=" + bottom +
                ", mainlist=" + mainlist +
                '}';
    }

    /************************************ Getter Setter ************************************/

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public Map<String, Object> getTitle () {
        return title;
    }

    public void setTitle (Map<String, Object> title) {
        this.title = title;
    }

    public Map<String, Object> getSubtitle () {
        return subtitle;
    }

    public void setSubtitle (Map<String, Object> subtitle) {
        this.subtitle = subtitle;
    }

    public Map<String, Object> getBottom () {
        return bottom;
    }

    public void setBottom (Map<String, Object> bottom) {
        this.bottom = bottom;
    }

    public List<Map<String, Map>> getMainlist () {
        return mainlist;
    }

    public void setMainlist (List<Map<String, Map>> mainlist) {
        this.mainlist = mainlist;
    }

}
