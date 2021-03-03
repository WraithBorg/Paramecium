package com.zxu.controller;

import com.zxu.util.SessionUtil;
import com.zxu.domain.ReceiptDo;
import com.zxu.domain.UserDo;
import com.zxu.constant.PageConst;
import com.zxu.convert.ReceiptInfoConvert;
import com.zxu.dto.ReceiptInfoDTO;
import com.zxu.result.MsgResult;
import com.zxu.service.usb.ReceiptInfoService;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CustomUtils;
import com.zxu.vo.ReceiptInfoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 收货地址
 */
@RestController
public class ReceiptInfoController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private ReceiptInfoConvert receiptConvert;
    @Resource
    private ReceiptInfoService receiptInfoService;
    @Resource
    private UserInfoService userInfoService;

    /**
     * 查询收货地址列表
     */
    @GetMapping("/user_address/my")
    public MsgResult userAddress() {
        //
        UserDo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        List<ReceiptDo> receiptInfos = receiptInfoService.selectList(defaultUser.getId());
        List<ReceiptInfoVO> receiptVOS = receiptConvert.getReceiptVOS(receiptInfos);
        Map data = CustomUtils.ofMap("list", receiptVOS,
                "pagelist", false,
                "rscount", receiptVOS.size(),
                "url", "/index.php?m=user_address&a=default",
                "dist_list", null);
        return MsgResult.doneUrl(data, PageConst.ADDRESS_ADD);
    }

    /**
     * 点击新增按钮
     */
    @GetMapping("/user_address/add")
    public MsgResult add(@RequestParam(required = false) String id) {
        if (CustomUtils.isBlank(id)) {
            Map data = CustomUtils.ofMap("data", null);
            return MsgResult.doneUrl(data, PageConst.ADDRESS_ADD);
        }
        ReceiptDo receiptInfo = receiptInfoService.selectById(id);
        ReceiptInfoVO receiptVO = receiptConvert.getReceiptVO(receiptInfo);
        Map data = CustomUtils.ofMap("data", receiptVO);
        return MsgResult.doneUrl(data, PageConst.ADDRESS_ADD);
    }

    /**
     * 保存收货地址
     */
    @PostMapping("/user_address/save")
    public MsgResult save(ReceiptInfoDTO addressDTO) {
        UserDo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        if (addressDTO.getId() == null) {
            ReceiptDo receiptInfo = receiptConvert.getReceiptInfo(addressDTO);
            receiptInfoService.insert(currentUser, receiptInfo);
            Map data = CustomUtils.ofMap("data", null);
            return MsgResult.doneUrl(data, PageConst.ADDRESS_ADD);
        }
        ReceiptDo receiptInfo = receiptConvert.getReceiptInfo(addressDTO);
        receiptInfoService.updateById(receiptInfo);
        Map data = CustomUtils.ofMap("data", null);
        return MsgResult.doneUrl(data, PageConst.ADDRESS_ADD);
    }

    /**
     * 删除收货地址
     */
    @GetMapping("/user_address/delete")
    public MsgResult delete(@RequestParam(required = false) String id) {
        receiptInfoService.deleteById(id);
        return MsgResult.doneMsg("删除成功");
    }

}
