package com.zxu.eum;

public enum  OrderState {

    UN_PAY(0, "unpay","待付款"),
    CANCELLED(10, "cancelled","已取消"),
    UN_PIN(20, "unpin","待成团"),
    UN_SEND(30, "unsend","待发货"),
    UN_RECEIVE(40, "unreceive","待收货"),
    UN_RATY(50, "unraty","待评价"),
    ;
    public  Integer id;
    public String val;
    public String text;

    OrderState(Integer id,String val, String text) {
        this.id = id;
        this.text = text;
        this.val = val;
    }
    public static Integer getId(String val){
        for (OrderState s : values()){
            if (s.val.equals(val)){
                return s.id;
            }
        }
        return null;
    }
    public  static String getText(Integer s) {
        for (OrderState val : values()) {
            if (val.id.equals(s)){
                return val.text;
            }
        }
        return "";
    }
}
