package com.sjdlogistics.cdds.service;

import com.sjdlogistics.cdds.entity.CebExpInvtMessage;

public interface CebExpInvtMessageService {
    CebExpInvtMessage getCebExpInvtMessage(String orderNo);

    void saveMsg(CebExpInvtMessage cebExpInvtMessage);
}
