package com.zxu.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 跳转页面地址常量
 */
@Component
@PropertySource("classpath:webpage.properties")
public class PageConst {

    public static String WEB_HOST;
    public static String CATEGORY_INDEX;//商品类别首页
    public static String ABOUT_US;//关于页面
    public static String PRODUCT_SHOW;//显示商品
    public static String PRODUCT_LIST_4CATEGORY;//根据品项类别显示商品列表
    public static String KEFU_INDEX;//客服页面
    public static String INDEX_LOGIN;//登录页面
    public static String INDEX_PAGE;//首页
    public static String USER_INDEX;//登录后进入首页
    public static String MY_NOTICE;//我的消息页面
    public static String MY_PAY_LOG;//消费记录
    public static String RECHARGE_LOG;//充值记录

    public static String ORDER_CONFIRM;//订单确认页面
    public static String ORDER_LIST;//订单列表页面
    public static String ORDER_DETAIL_SHOW;//订单详情页面

    public static String ADDRESS_ADD;//添加收货地址页面

    public static String CART_SHOW;//查询购物车信息

    public static String USER_PWD_SHOW;//修改用户(密码)页面
    public static String USER_PAY_PWD_SHOW;//修改支付密码页面
    public static String USER_INFO_SHOW;//用户信息页面
    public static String USER_SET_SHOW;//用户设置页面
    public static String INDEX;//首页
    public static String IMG_PATH;//静态图片访问地址

    @Value("${webpage.web_host}")
    public void setWebHost(String web_host) {
        WEB_HOST = web_host;
    }
    @Value("${webpage.category_index}")
    public void setCategoryIndex(String categoryIndex) {
        CATEGORY_INDEX = categoryIndex;
    }
    @Value("${webpage.about_us}")
    public void setAboutUs(String aboutUs) {
        ABOUT_US = aboutUs;
    }
    @Value("${webpage.product_show}")
    public void setProductShow(String productShow) {
        PRODUCT_SHOW = productShow;
    }
    @Value("${webpage.product_list_4category}")
    public void setProductList4category(String productList4category) {
        PRODUCT_LIST_4CATEGORY = productList4category;
    }
    @Value("${webpage.kefu_index}")
    public void setKefuIndex(String kefuIndex) {
        KEFU_INDEX = kefuIndex;
    }
    @Value("${webpage.index_login}")
    public void setIndexLogin(String indexLogin) {
        INDEX_LOGIN = indexLogin;
    }
    @Value("${webpage.index_page}")
    public void setIndexPage(String indexPage) {
        INDEX_PAGE = indexPage;
    }
    @Value("${webpage.user_index}")
    public void setUserIndex(String userIndex) {
        USER_INDEX = userIndex;
    }
    @Value("${webpage.my_notice}")
    public void setMyNotice(String myNotice) {
        MY_NOTICE = myNotice;
    }
    @Value("${webpage.my_pay_log}")
    public void setMyPayLog(String myPayLog) {
        MY_PAY_LOG = myPayLog;
    }
    @Value("${webpage.recharge_log}")
    public void setRechargeLog(String rechargeLog) {
        RECHARGE_LOG = rechargeLog;
    }
    @Value("${webpage.order_confirm}")
    public void setOrderConfirm(String orderConfirm) {
        ORDER_CONFIRM = orderConfirm;
    }
    @Value("${webpage.order_list}")
    public void setOrderList(String orderList) {
        ORDER_LIST = orderList;
    }
    @Value("${webpage.order_detail_show}")
    public void setOrderDetailShow(String orderDetailShow) {
        ORDER_DETAIL_SHOW = orderDetailShow;
    }
    @Value("${webpage.address_add}")
    public void setAddressAdd(String addressAdd) {
        ADDRESS_ADD = addressAdd;
    }
    @Value("${webpage.cart_show}")
    public void setCartShow(String cartShow) {
        CART_SHOW = cartShow;
    }
    @Value("${webpage.user_pwd_show}")
    public void setUserPwdShow(String userPwdShow) {
        USER_PWD_SHOW = userPwdShow;
    }
    @Value("${webpage.user_pay_pwd_show}")
    public void setUserPayPwdShow(String userPayPwdShow) {
        USER_PAY_PWD_SHOW = userPayPwdShow;
    }
    @Value("${webpage.user_info_show}")
    public void setUserInfoShow(String userInfoShow) {
        USER_INFO_SHOW = userInfoShow;
    }
    @Value("${webpage.user_set_show}")
    public void setUserSetShow(String userSetShow) {
        USER_SET_SHOW = userSetShow;
    }
    @Value("${webpage.index}")
    public void setINDEX(String index) {
        PageConst.INDEX = index;
    }
    @Value("${webpage.img_path}")
    public void setImgPath(String imgPath) {
        IMG_PATH = imgPath;
    }
}
