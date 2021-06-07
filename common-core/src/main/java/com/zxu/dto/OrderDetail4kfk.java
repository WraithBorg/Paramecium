package com.zxu.dto;

import java.math.BigDecimal;

public class OrderDetail4kfk {
    private String itemName;
    private BigDecimal amount;
    private BigDecimal money;

    /************************************ Getter Setter ************************************/
    public String getItemName () {
        return itemName;
    }

    public void setItemName (String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMoney () {
        return money;
    }

    public void setMoney (BigDecimal money) {
        this.money = money;
    }
}
