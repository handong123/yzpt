package com.tasly.yzpt.repository.message;

import com.tasly.yzpt.common.repository.MybatisBaseRepository;
import com.tasly.yzpt.repository.message.entity.TradeLogistics;
import com.tasly.yzpt.repository.message.entity.TradeLogisticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeLogisticsRepository extends
        MybatisBaseRepository<TradeLogistics, String, TradeLogisticsExample> {

}