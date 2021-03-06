package com.zxu.convert;

import com.zxu.domain.KeFuLogDo;
import com.zxu.util.DDateUtil;
import com.zxu.vo.KeFuLogVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class KeFuLogConvert {

    public KeFuLogVO getKeFuLogVO(KeFuLogDo info) {
        KeFuLogVO vo = new KeFuLogVO();
        vo.setId(info.getId());
        vo.setUserid(info.getUserId());
        vo.setStatus(info.getStatus());
        vo.setCreatetime(DDateUtil.format(info.getCreateTime()));
        vo.setContent(info.getContent());
        vo.setTablename("user");//聊天记录所属对象
        return vo;
    }

    public List<KeFuLogVO> getKeFuLogVOS(List<KeFuLogDo> infos) {
        List<KeFuLogVO> collect = infos.stream().map(m -> getKeFuLogVO(m)).collect(Collectors.toList());
        return collect;
    }
}
