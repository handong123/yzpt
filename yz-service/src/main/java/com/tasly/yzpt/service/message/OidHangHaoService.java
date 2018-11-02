package com.tasly.yzpt.service.message;

import com.tasly.yzpt.repository.message.entity.OidHanghao;

/**
 * Created by Talsy_xiashengxin on 2018/11/2.
 */
public interface OidHangHaoService {

    OidHanghao SelectOidHanghaoByTidAndHanghao(String tid,String hanghao);
}
