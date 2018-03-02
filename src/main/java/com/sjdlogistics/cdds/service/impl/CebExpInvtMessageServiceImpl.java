package com.sjdlogistics.cdds.service.impl;

import com.sjdlogistics.cdds.dao.ExpInventoryHeadDao;
import com.sjdlogistics.cdds.dao.ExpInventoryListDao;
import com.sjdlogistics.cdds.dao.ExpOrderInfoDao;
import com.sjdlogistics.cdds.entity.CebExpInvtMessage;
import com.sjdlogistics.cdds.service.CebExpInvtMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("cebExpInvtMessageService")
public class CebExpInvtMessageServiceImpl implements CebExpInvtMessageService {

    @Resource
    private ExpOrderInfoDao expOrderInfoDao;
    @Resource
    private ExpInventoryHeadDao expInventoryHeadDao;
    @Resource
    private ExpInventoryListDao expInventoryListDao;

    public void saveMsg(CebExpInvtMessage cebExpInvtMessage) {
        try{
            expOrderInfoDao.insert(cebExpInvtMessage.getExpInvt().getExpOrderInfo());
            expInventoryHeadDao.insert(cebExpInvtMessage.getExpInvt().getExpInventory().getExpInventoryHead());
            expInventoryListDao.inserts(cebExpInvtMessage.getExpInvt().getExpInventory().getExpInventoryLists());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public CebExpInvtMessage getCebExpInvtMessage(String orderNo) {
        return null;
    }

}
