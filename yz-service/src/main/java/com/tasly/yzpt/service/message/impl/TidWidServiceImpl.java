package com.tasly.yzpt.service.message.impl;

import com.tasly.yzpt.repository.message.TidWidRepository;
import com.tasly.yzpt.repository.message.entity.TidWid;
import com.tasly.yzpt.repository.message.entity.TidWidExample;
import com.tasly.yzpt.service.message.TidWidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Talsy_xiashengxin on 2018/10/31.
 */
public class TidWidServiceImpl implements TidWidService {

    @Autowired
    TidWidRepository tidWidRepository;

    @Override
    public TidWid selectTidWid(Integer wid) {
        TidWidExample tidWidExample = new TidWidExample();
        tidWidExample.or().andWidEqualTo(wid);
        List<TidWid> tidWidList = tidWidRepository.selectByExample(tidWidExample);
        if (!CollectionUtils.isEmpty(tidWidList)) {
            return tidWidList.get(0);
        }
        return null;
    }
}
