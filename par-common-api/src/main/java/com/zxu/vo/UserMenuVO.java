package com.zxu.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户菜单
 */
public class UserMenuVO {
    private String a;
    private List<UserMenuChildVO> child;
    private Integer group_id;
    private String icon;
    private Long id;
    private String link_url;
    private String logo;
    private String m;
    private Integer orderindex;
    private Integer pid;
    private Integer status;
    private String target;
    private String title;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public List<UserMenuChildVO> getChild() {
        return child;
    }

    public void setChild(List<UserMenuChildVO> child) {
        this.child = child;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private static UserMenuVO get栏目二() {
        UserMenuVO navDTO = new UserMenuVO();
        navDTO.setA("");
        navDTO.setChild(UserMenuChildVO.getNavList());
        navDTO.setGroup_id(7);
        navDTO.setIcon("");
        navDTO.setId(297L);
        navDTO.setLink_url("");
        navDTO.setLogo("");
        navDTO.setM("");
        navDTO.setOrderindex(0);
        navDTO.setPid(0);
        navDTO.setStatus(1);
        navDTO.setTarget("_self");
        navDTO.setTitle("栏目二");
        return navDTO;
    }

    public static  List<UserMenuVO> getNavList() {
        List<UserMenuVO> navDTOS = new ArrayList<>();
        navDTOS.add(get栏目二());
        return navDTOS;


    }
}
