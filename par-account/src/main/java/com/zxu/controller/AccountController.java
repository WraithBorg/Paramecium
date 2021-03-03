package com.zxu.controller;

import com.zxu.constant.AccessAccount;
import com.zxu.constant.CConstant;
import com.zxu.domain.AccountDo;
import com.zxu.result.DockResult;
import com.zxu.service.usb.AccountService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

@Controller
public class AccountController {
    @Resource
    private AccountService accountService;

    /**
     * 查询余额
     */
    @ResponseBody
    @RequestMapping(AccessAccount.GET_INFO)
    public DockResult<AccountDo> getAccountInfo(@RequestBody Map map) {
        Object reqBody = map.get(CConstant.USER_ID);
        if (reqBody == null || CustomUtils.isBlank((String) reqBody)) {
            return DockResult.fail("ID无法识别");
        }
        String userId = (String) reqBody;
        AccountDo account = accountService.getAccount(userId);
        return DockResult.done(account);
    }

    /**
     * 扣款
     */
    @ResponseBody
    @RequestMapping(AccessAccount.DEDUCT)
    public DockResult deduct(@RequestBody Map map) {
        String userId = (String) map.get(CConstant.USER_ID);
        BigDecimal amount = new BigDecimal(String.valueOf(map.get(CConstant.AMOUNT)));
        accountService.deduct(userId, amount);
        return DockResult.done();
    }

    /**
     * 充值
     */
    @ResponseBody
    @RequestMapping(AccessAccount.CHARGE)
    public DockResult charge(@RequestBody Map map) {
        String userId = (String) map.get(CConstant.USER_ID);
        BigDecimal amount = new BigDecimal(String.valueOf(map.get(CConstant.AMOUNT)));
        accountService.charge(userId, amount);
        return DockResult.done();
    }
}
