package com.zxu.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:access-hosts.properties")
public class Hosts4Access {
    public static String accountHosts;
    public static String storageHosts;
    public static String orderHosts;
    public static String fileStorageHosts;

    /************************************ Setter ************************************/
    @Value("${account.host}")
    public void setAccountHosts (String accountHosts) {
        Hosts4Access.accountHosts = accountHosts;
    }
    @Value("${storage.host}")
    public void setStorageHosts (String storageHosts) {
        Hosts4Access.storageHosts = storageHosts;
    }
    @Value("${order.host}")
    public void setOrderHosts (String orderHosts) {
        Hosts4Access.orderHosts = orderHosts;
    }
    @Value("${fileStorage.host}")
    public void setFileStorageHosts (String fileStorageHosts) {
        Hosts4Access.fileStorageHosts = fileStorageHosts;
    }

    /************************************ Getter ************************************/
    public String getAccountHosts () {
        return accountHosts;
    }

    public String getStorageHosts () {
        return storageHosts;
    }

    public String getOrderHosts () {
        return orderHosts;
    }

    public String getFileStorageHosts () {
        return fileStorageHosts;
    }
}
