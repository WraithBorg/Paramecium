package com.zxu.convert;

import com.zxu.domain.ReceiptInfo;
import com.zxu.dto.ReceiptInfoDTO;
import com.zxu.vo.ReceiptInfoVO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceiptInfoConvert {

    public List<ReceiptInfoVO> getReceiptVOS(List<ReceiptInfo> receiptInfos) {
        List<ReceiptInfoVO> receiptInfoVOS = receiptInfos.stream().map(m -> getReceiptVO(m)).collect(Collectors.toList());
        return receiptInfoVOS;
    }

    public ReceiptInfoVO getReceiptVO(ReceiptInfo receiptInfo) {
        String id = receiptInfo.getId();
        String userId = receiptInfo.getUserId();
        String address = receiptInfo.getAddress();
        String telephone = receiptInfo.getTelephone();
        String trueName = receiptInfo.getTrueName();
        String zipCode = receiptInfo.getZipCode();
        Integer defaultFlag = receiptInfo.getDefaultFlag();
        Integer provinceId = receiptInfo.getProvinceId();
        Integer cityId = receiptInfo.getCityId();
        Integer townId = receiptInfo.getTownId();

        ReceiptInfoVO receiptInfoVO = new ReceiptInfoVO();
        receiptInfoVO.setId(id);
        receiptInfoVO.setUserid(userId);
        receiptInfoVO.setAddress(address);
        receiptInfoVO.setTelephone(telephone);
        receiptInfoVO.setTruename(trueName);
        receiptInfoVO.setStatus(2);
        receiptInfoVO.setZip_code(zipCode);
        receiptInfoVO.setLastid(0);
        receiptInfoVO.setProvince_id(provinceId);
        receiptInfoVO.setCity_id(cityId);
        receiptInfoVO.setTown_id(townId);
        receiptInfoVO.setIsdefault(defaultFlag);
        receiptInfoVO.setDateline(new Date());
        receiptInfoVO.setPct_address("北京市东城区东华门街道11号楼");
        receiptInfoVO.setLat(null);
        receiptInfoVO.setLng(null);
        return receiptInfoVO;
    }

    public ReceiptInfo getReceiptInfo(ReceiptInfoDTO dto) {
        String id = dto.getId();
        String address = dto.getAddress();
        String provinceId = dto.getProvince_id();
        String cityId = dto.getCity_id();
        String townId = dto.getTown_id();
        String telephone = dto.getTelephone();
        String trueName = dto.getTruename();
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setId(id);
        receiptInfo.setAddress(address);
        receiptInfo.setProvinceId(Integer.parseInt(provinceId));
        receiptInfo.setCityId(Integer.parseInt(cityId));
        receiptInfo.setTownId(Integer.parseInt(townId));
        receiptInfo.setTelephone(telephone);
        receiptInfo.setTrueName(trueName);
        return receiptInfo;
    }
}
