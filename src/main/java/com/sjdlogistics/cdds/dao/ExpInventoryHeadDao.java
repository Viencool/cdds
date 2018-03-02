package com.sjdlogistics.cdds.dao;

import com.sjdlogistics.cdds.entity.ExpInventoryHead;
import org.springframework.stereotype.Component;

@Component
public interface ExpInventoryHeadDao {

    int insert(ExpInventoryHead record);

    int insertSelective(ExpInventoryHead record);
}