package com.tasly.yzpt.repository.message;

import com.tasly.yzpt.common.repository.MybatisBaseRepository;
import com.tasly.yzpt.repository.message.entity.OidHanghao;
import com.tasly.yzpt.repository.message.entity.OidHanghaoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OidHanghaoRepository  extends MybatisBaseRepository<OidHanghao, String, OidHanghaoExample> {

}