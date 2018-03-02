package com.sjdlogistics.cdds.dao;

import com.sjdlogistics.cdds.entity.ExpInventoryList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpInventoryListDao {
    int insert(ExpInventoryList record);

    int insertSelective(ExpInventoryList record);

    int inserts(List<ExpInventoryList> records);
}