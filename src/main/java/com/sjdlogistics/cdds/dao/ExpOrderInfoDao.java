package com.sjdlogistics.cdds.dao;

import com.sjdlogistics.cdds.entity.ExpOrderInfo;
import org.springframework.stereotype.Component;

@Component
public interface ExpOrderInfoDao {
    int insert(ExpOrderInfo record);

    int insertSelective(ExpOrderInfo record);
}