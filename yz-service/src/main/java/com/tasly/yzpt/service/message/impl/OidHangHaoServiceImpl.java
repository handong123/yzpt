package com.tasly.yzpt.service.message.impl;

import com.tasly.yzpt.repository.message.OidHanghaoRepository;
import com.tasly.yzpt.repository.message.entity.OidHanghao;
import com.tasly.yzpt.repository.message.entity.OidHanghaoExample;
import com.tasly.yzpt.service.message.OidHangHaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Talsy_xiashengxin on 2018/11/2.
 */
@Service
@Slf4j
public class OidHangHaoServiceImpl implements OidHangHaoService {

    @Autowired
    OidHanghaoRepository oidHanghaoRepository;

    @Override
    public OidHanghao SelectOidHanghaoByTidAndHanghao(String tid, String hanghao) {
        OidHanghaoExample oidHanghaoExample = new OidHanghaoExample();
        oidHanghaoExample.or().andTidEqualTo(tid).andHanghaoEqualTo(hanghao);
        List<OidHanghao> oidHanghaoList = oidHanghaoRepository.selectByExample(oidHanghaoExample);
        if (!CollectionUtils.isEmpty(oidHanghaoList)) {
            return oidHanghaoList.get(0);
        }
        return null;
    }
}
