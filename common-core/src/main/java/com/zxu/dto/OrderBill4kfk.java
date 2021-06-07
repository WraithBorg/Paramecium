package com.zxu.dto;

import java.util.Date;
import java.util.Set;

public class OrderBill4kfk {
    private String billNo;
    private String note;
    private Date createDate;
    private Date money;
    private Set<OrderDetail4kfk> details;
    /************************************ Getter Setter ************************************/
    public String getBillNo () {
        return billNo;
    }

    public void setBillNo (String billNo) {
        this.billNo = billNo;
    }

    public String getNote () {
        return note;
    }

    public void setNote (String note) {
        this.note = note;
    }

    public Date getCreateDate () {
        return createDate;
    }

    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }

    public Date getMoney () {
        return money;
    }

    public void setMoney (Date money) {
        this.money = money;
    }

    public Set<OrderDetail4kfk> getDetails () {
        return details;
    }

    public void setDetails (Set<OrderDetail4kfk> details) {
        this.details = details;
    }
}
