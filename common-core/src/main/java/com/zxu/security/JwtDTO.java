package com.zxu.security;

public class JwtDTO {
    private String id;
    private String nickName;
    private String telePhone;
    private String password;

    public static JwtDTO builder(String id, String nickName, String password, String telePhone) {
        JwtDTO dto = new JwtDTO();
        dto.setId(id);
        dto.setNickName(nickName);
        dto.setTelePhone(telePhone);
        dto.setPassword(password);
        return dto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
