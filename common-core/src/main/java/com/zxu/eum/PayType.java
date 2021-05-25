package com.zxu.eum;

public enum PayType {
    ALIPAY(100, "alipay","支付宝");
    private Integer id;
    private String ttpye;
    private String text;

    PayType(Integer id, String ttpye,String text) {
        this.id = id;
        this.ttpye = ttpye;
        this.text = text;
    }
    public static Integer getId(String text) {
        for (PayType p : values()) {
            if (p.text.equals(text)) {
                return p.id;
            }
        }
        return null;
    }
    public static String getTtype(Integer i) {
        for (PayType p : values()) {
            if (p.id.equals(i)) {
                return p.ttpye;
            }
        }
        return null;
    }
}
