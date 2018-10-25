package com.tasly.yzpt.repository.message;

import com.tasly.yzpt.common.repository.MybatisBaseRepository;
import com.tasly.yzpt.repository.message.entity.TradeWms;
import com.tasly.yzpt.repository.message.entity.TradeWmsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeWmsRepository extends
        MybatisBaseRepository<TradeWms, String, TradeWmsExample> {

}