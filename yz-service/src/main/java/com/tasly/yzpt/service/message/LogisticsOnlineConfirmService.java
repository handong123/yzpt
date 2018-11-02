package com.tasly.yzpt.service.message;

import com.tasly.yzpt.repository.message.entity.TradeLogistics;
import com.tasly.yzpt.service.message.entity.LogisticsOnlineConfirmEntity;

import java.util.List;

public interface LogisticsOnlineConfirmService {
    void confirm(LogisticsOnlineConfirmEntity params);

    void confirm(List<TradeLogistics> TradeLogisticsList);
}
