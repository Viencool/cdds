package com.sjdlogistics.cdds.controller;

import com.sjdlogistics.cdds.entity.*;
import com.sjdlogistics.cdds.util.HttpClientUtil;
import com.sjdlogistics.cdds.util.ImportExcelUtil;
import com.sjdlogistics.cdds.util.MessageUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/importExcel/*")
public class ImportExcel {

    private ImportExcelUtil importExcelUtil = null;
    /*private String url = "http://api.cdkjt.net:8888/rest/declare";//测试*/
    /*private String url = "http://118.122.120.156:8884/rest/declare";//测试*/
    private String url = "http://api.cdkjt.com.cn/cbec-gateway/rest/declare";
    private String charset = "UTF-8";
    private HttpClientUtil httpClientUtil = new HttpClientUtil();
    private MessageUtil messageUtil = new MessageUtil();
    //private CebExpInvtMessageService cebExpInvtMessageService = new CebExpInvtMessageServiceImpl();

    @ResponseBody
    @RequestMapping(value = "cebExpInvtMessage", method = {RequestMethod.POST})
    public Map<String, String> sendCebExpInvtMessage(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("upfile");
        importExcelUtil = new ImportExcelUtil("YYYYMMDDhhmmss");
        Map<Class, Map<String, String>> cebExpInvtMessageConfigs = getCebExpInvtMessageConfigs();
        List<Class> clazzList = new ArrayList<Class>();
        clazzList.add(ExpOrderInfo.class);
        clazzList.add(ExpInventoryHead.class);
        clazzList.add(ExpInventoryList.class);
        clazzList.add(BaseTransfer.class);
        Map<Class, List> maps = importExcelUtil.readExcelReList(file, cebExpInvtMessageConfigs, clazzList);
        List<ExpOrderInfo> expOrderInfoLists = maps.get(ExpOrderInfo.class);
        List<ExpInventoryHead> expInventoryHeadLists = maps.get(ExpInventoryHead.class);
        List<ExpInventoryList> expInventoryLists = maps.get(ExpInventoryList.class);
        String msg = "";
        Map<String, String> map = new HashMap<String, String>(16);
        if(!(expOrderInfoLists.size() == expInventoryHeadLists.size() && expOrderInfoLists.size() <= expInventoryLists.size())){
            msg = "EXCEL订单有误！";
            map.put("msg",msg);
            return map;
        }
        List<String> infoNo = new ArrayList<String>();
        for(ExpOrderInfo expOrderInfo : expOrderInfoLists){
            tExpOrderInfo(expOrderInfo);
            if(infoNo.contains(expOrderInfo.getOrderNo())){
                msg = "EXCEL订单有误！";
                map.put("msg",msg);
                return map;
            }
            infoNo.add(expOrderInfo.getOrderNo());
        }
        List<String> headNo = new ArrayList<String>();
        for(ExpInventoryHead expInventoryHead : expInventoryHeadLists){
            tExpInventoryHead(expInventoryHead);
            if(!infoNo.contains(expInventoryHead.getOrderNo())||headNo.contains(expInventoryHead.getOrderNo())){
                msg = "EXCEL订单有误！";
                map.put("msg",msg);
                return map;
            }
            headNo.add(expInventoryHead.getOrderNo());
        }
        List<String> listNo = new ArrayList<String>();
        for (ExpInventoryList expInventoryList : expInventoryLists) {
            tExpInventoryList(expInventoryList);
            if(headNo.contains(expInventoryList.getOrderNo()) && !listNo.contains(expInventoryList.getOrderNo())){
                listNo.add(expInventoryList.getOrderNo());
            }
        }
        if(listNo.size() != headNo.size()){
            msg = "EXCEL订单有误！";
            map.put("msg",msg);
            return map;
        }
        BaseTransfer baseTransfer = (BaseTransfer) maps.get(BaseTransfer.class).get(0);
        for(String no : infoNo){
            ExpOrderInfo info = null;
            ExpInventoryHead head = null;
            List<ExpInventoryList> lists = new ArrayList<ExpInventoryList>();
            for(ExpOrderInfo ainfo : expOrderInfoLists){
                if(no.endsWith(ainfo.getOrderNo())){
                    info = ainfo;
                    break;
                }
            }
            for(ExpInventoryHead ahead : expInventoryHeadLists){
                if(no.endsWith(ahead.getOrderNo())){
                    head = ahead;
                    break;
                }
            }
            for(ExpInventoryList list : expInventoryLists){
                if(no.endsWith(list.getOrderNo())){
                    lists.add(list);
                    continue;
                }
            }
            CebExpInvtMessage cebExpInvtMessage = new CebExpInvtMessage(new ExpInvt(info, new ExpInventory(head, lists)), baseTransfer);
            msg += "订单号："+ no + "\n" + receCebExpInvtReturnMessage(doPost(cebExpInvtMessage)) + "\n";
        }
        map.put("msg", msg);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "cebCEB621Message", method = {RequestMethod.POST})
    public Map<String, String> sendCEB621Message(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("upfile");
        file.getOriginalFilename();
        importExcelUtil = new ImportExcelUtil("YYYYMMDDhhmmss");
        Map<Class, Map<String, String>> CEB621MessageConfigs = getCEB621MessageConfigs();
        List<Class> clazzList = new ArrayList<Class>();
        clazzList.add(InventoryHead.class);
        clazzList.add(InventoryList.class);
        clazzList.add(BaseTransfer.class);
        Map<Class, List> maps = importExcelUtil.readExcelReList(file, CEB621MessageConfigs, clazzList);
        InventoryHead inventoryHead = (InventoryHead) maps.get(InventoryHead.class).get(0);
        tInventoryHead(inventoryHead);
        List<InventoryList> inventoryLists = maps.get(InventoryList.class);
        for (InventoryList inventoryList : inventoryLists) {
            tInventoryList(inventoryList);
        }
        BaseTransfer baseTransfer = (BaseTransfer) maps.get(BaseTransfer.class).get(0);
        CEB621Message cEB621Message = new CEB621Message(new Inventory(inventoryHead, inventoryLists), baseTransfer);
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", receCEB622Message(doPost(cEB621Message)));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "cebCEB511Message", method = {RequestMethod.POST})
    public Map<String, String> sendCEB511Message(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("upfile");
        file.getOriginalFilename();
        importExcelUtil = new ImportExcelUtil("YYYYMMDDhhmmss");
        Map<Class, Map<String, String>> CEB511MessageConfigs = getCEB511MessageConfigs();
        List<Class> clazzList = new ArrayList<Class>();
        clazzList.add(LogisticsHead.class);
        clazzList.add(BaseTransfer.class);
        Map<Class, List> maps = importExcelUtil.readExcelReList(file, CEB511MessageConfigs, clazzList);

        LogisticsHead logisticsHead = (LogisticsHead) maps.get(LogisticsHead.class).get(0);
        tLogisticsHead(logisticsHead);

        BaseTransfer baseTransfer = (BaseTransfer) maps.get(BaseTransfer.class).get(0);
        CEB511Message cEB511Message = new CEB511Message(new Logistics(logisticsHead), baseTransfer);
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", receCEB512Message(doPost(cEB511Message)));
        return map;
    }

    public String doPost(Object msg) {
        String requestXml = messageUtil.toXML(msg);
        System.out.println(requestXml);
        Document doc = null;
        String guid = UUID.randomUUID().toString();
        try {
            doc = DocumentHelper.parseText(requestXml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        doc.getRootElement().addAttribute("version", "1.0");
        doc.getRootElement().addAttribute("guid", guid);
        Map<String, String> map = new HashMap<String, String>();
        map.put("xml", doc.asXML());
        String returnMessage = httpClientUtil.doPost(url, map, charset);
        return returnMessage;
    }

    public String receCebExpInvtReturnMessage(String returnMessage) {
        String msg = "";
        try {
            JAXBContext cxt = JAXBContext.newInstance(CebExpInvtReturnMessage.class);
            Unmarshaller unmarshaller = cxt.createUnmarshaller();
            InputStream in_withcode = null;

            in_withcode = new ByteArrayInputStream(returnMessage.getBytes("UTF-8"));

            CebExpInvtReturnMessage cebExpInvtReturnMessage = (CebExpInvtReturnMessage) unmarshaller.unmarshal(in_withcode);
            msg = cebExpInvtReturnMessage.getExpInvtReturn().getReturnInfo();

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public String receCEB622Message(String returnMessage) {
        String msg = "";
        try {
            JAXBContext cxt = JAXBContext.newInstance(CEB622Message.class);
            Unmarshaller unmarshaller = cxt.createUnmarshaller();
            InputStream in_withcode = null;

            in_withcode = new ByteArrayInputStream(returnMessage.getBytes("UTF-8"));

            CEB622Message cEB622Message = (CEB622Message) unmarshaller.unmarshal(in_withcode);
            msg = cEB622Message.getInventoryReturn().getReturnInfo();

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public String receCEB512Message(String returnMessage) {
        String msg = "";
        try {
            JAXBContext cxt = JAXBContext.newInstance(CEB512Message.class);
            Unmarshaller unmarshaller = cxt.createUnmarshaller();
            InputStream in_withcode = null;

            in_withcode = new ByteArrayInputStream(returnMessage.getBytes("UTF-8"));

            CEB512Message cEB512Message = (CEB512Message) unmarshaller.unmarshal(in_withcode);
            msg = cEB512Message.getLogisticsReturn().getReturnInfo();

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return msg;
    }


    public void tExpOrderInfo(ExpOrderInfo expOrderInfo) {
        if (expOrderInfo.getRate() != null) {
            BigDecimal rate = expOrderInfo.getRate().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expOrderInfo.setRate(rate);
        }
        if (expOrderInfo.getOrderTotalAmount() != null) {
            BigDecimal orderTotalAmount = expOrderInfo.getOrderTotalAmount().setScale(2, BigDecimal.ROUND_HALF_DOWN);
            expOrderInfo.setOrderTotalAmount(orderTotalAmount);
        }
    }

    public void tExpInventoryHead(ExpInventoryHead expInventoryHead) {
        if (expInventoryHead.getFreight() != null) {
            BigDecimal freight = expInventoryHead.getFreight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryHead.setFreight(freight);
        }
        if (expInventoryHead.getInsuredFee() != null) {
            BigDecimal insuredFee = expInventoryHead.getInsuredFee().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryHead.setInsuredFee(insuredFee);
        }
        if (expInventoryHead.getNetWeight() != null) {
            BigDecimal netWeight = expInventoryHead.getNetWeight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryHead.setNetWeight(netWeight);
        }
        if (expInventoryHead.getGrossWeight() != null) {
            BigDecimal grossWeight = expInventoryHead.getGrossWeight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryHead.setGrossWeight(grossWeight);
        }
    }

    public void tExpInventoryList(ExpInventoryList expInventoryList) {
        if (expInventoryList.getQty() != null) {
            BigDecimal qty = expInventoryList.getQty().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryList.setQty(qty);
        }
        if (expInventoryList.getQty1() != null) {
            BigDecimal qty1 = expInventoryList.getQty1().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryList.setQty1(qty1);
        }
        if (expInventoryList.getQty2() != null) {
            BigDecimal qty2 = expInventoryList.getQty2().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryList.setQty2(qty2);
        }
        if (expInventoryList.getPrice() != null) {
            BigDecimal price = expInventoryList.getPrice().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryList.setPrice(price);
        }
        if (expInventoryList.getTotalPrice() != null) {
            BigDecimal totalPrice = expInventoryList.getTotalPrice().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            expInventoryList.setTotalPrice(totalPrice);
        }
    }

    public void tInventoryHead(InventoryHead inventoryHead) {
        if (inventoryHead.getFreight() != null) {
            BigDecimal freight = inventoryHead.getFreight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryHead.setFreight(freight);
        }
        if (inventoryHead.getInsuredFee() != null) {
            BigDecimal insuredFee = inventoryHead.getInsuredFee().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryHead.setInsuredFee(insuredFee);
        }
        if (inventoryHead.getNetWeight() != null) {
            BigDecimal netWeight = inventoryHead.getNetWeight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryHead.setNetWeight(netWeight);
        }
        if (inventoryHead.getGrossWeight() != null) {
            BigDecimal grossWeight = inventoryHead.getGrossWeight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryHead.setGrossWeight(grossWeight);
        }
    }

    public void tInventoryList(InventoryList inventoryList) {
        if (inventoryList.getQty() != null) {
            BigDecimal qty = inventoryList.getQty().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryList.setQty(qty);
        }
        if (inventoryList.getQty1() != null) {
            BigDecimal qty1 = inventoryList.getQty1().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryList.setQty1(qty1);
        }
        if (inventoryList.getQty2() != null) {
            BigDecimal qty2 = inventoryList.getQty2().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryList.setQty2(qty2);
        }
        if (inventoryList.getPrice() != null) {
            BigDecimal price = inventoryList.getPrice().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryList.setPrice(price);
        }
        if (inventoryList.getTotalPrice() != null) {
            BigDecimal totalPrice = inventoryList.getTotalPrice().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            inventoryList.setTotalPrice(totalPrice);
        }
    }

    public void tLogisticsHead(LogisticsHead logisticsHead) {
        if (logisticsHead.getFreight() != null) {
            BigDecimal freight = logisticsHead.getFreight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            logisticsHead.setFreight(freight);
        }
        if (logisticsHead.getInsuredFee() != null) {
            BigDecimal insuredFee = logisticsHead.getInsuredFee().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            logisticsHead.setInsuredFee(insuredFee);
        }
        if (logisticsHead.getWeight() != null) {
            BigDecimal netWeight = logisticsHead.getWeight().setScale(5, BigDecimal.ROUND_HALF_DOWN);
            logisticsHead.setWeight(netWeight);
        }
    }

    public Map<Class, Map<String, String>> getCebExpInvtMessageConfigs() {
        Map<Class, Map<String, String>> map = new HashMap<Class, Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("订单号", "orderNo");
        map1.put("支付时间", "payTime");
        map1.put("订单商品总数", "goodsNum");
        map1.put("币制", "currency");
        map1.put("汇率", "rate");
        map1.put("订单总金额", "orderTotalAmount");
        map1.put("收货人", "consignee");
        map1.put("收货人国家", "consigneeCountry");
        map1.put("收件人详细地址", "consigneeAddress");
        map1.put("收货人电话", "consigneeTel");
        map1.put("收货人email地址", "consigneeEmail");
        map1.put("企业海关编码", "ebpCode");
        map1.put("企业名称", "ebpName");
        map.put(ExpOrderInfo.class, map1);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("订单编号", "orderNo");
        map2.put("电商平台代码", "ebpCode");
        map2.put("电商平台名称", "ebpName");
        map2.put("收发货人代码", "ebcCode");
        map2.put("收发货人名称", "ebcName");
        map2.put("生产销售单位代码", "productCode");
        map2.put("生产销售单位名称", "productName");
        map2.put("物流企业代码", "logisticsCode");
        map2.put("物流企业名称", "logisticsName");
        map2.put("物流运单编号", "logisticsNo");
        map2.put("账册编号", "emsNo");
        map2.put("预录入编号", "preNo");
        map2.put("清单编号", "invtNo");
        map2.put("进出口标记", "ieFlag");
        map2.put("申报日期", "declTime");
        map2.put("申报海关代码", "customsCode");
        map2.put("出口口岸代码", "portCode");
        map2.put("出口日期", "ieDate");
        map2.put("报关企业代码", "agentCode");
        map2.put("报关企业名称", "agentName");
        map2.put("区内企业代码", "areaCode");
        map2.put("区内企业名称", "areaName");
        map2.put("贸易方式", "tradeMode");
        map2.put("运输方式", "trafMode");
        map2.put("运输工具编号", "trafNo");
        map2.put("航班航次号", "voyageNo");
        map2.put("提（运）单号", "billNo");
        map2.put("监管场所代码", "loctNo");
        map2.put("总包号", "packageNum");
        map2.put("许可证号", "licenseNo");
        map2.put("指运港代码", "arrivedPort");
        map2.put("运抵国（地区）", "country");
        map2.put("运费", "freight");
        map2.put("运费币制", "feeCurrency");
        map2.put("运费标志", "feeFlag");
        map2.put("保费", "insuredFee");
        map2.put("保费币制", "inrCurrency");
        map2.put("保费标志", "inrFlag");
        map2.put("包装种类代码", "wrapType");
        map2.put("件数", "packNo");
        map2.put("毛重（公斤）", "grossWeight");
        map2.put("净重（公斤）", "netWeight");
        map2.put("备注", "note");
        map.put(ExpInventoryHead.class, map2);
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("商品项号", "gnum");
        map3.put("企业商品编号", "itemNo");
        map3.put("账册备案料号", "itemRecordNo");
        map3.put("海关商品编码", "gcode");
        map3.put("商品名称", "gname");
        map3.put("规格型号", "gmodel");
        map3.put("条形码", "barCode");
        map3.put("最终目的国（地区）代码", "country");
        map3.put("币制", "currency");
        map3.put("申报数量", "qty");
        map3.put("法定数量", "qty1");
        map3.put("第二数量", "qty2");
        map3.put("申报计量单位", "unit");
        map3.put("法定计量单位", "unit1");
        map3.put("第二计量单位", "unit2");
        map3.put("单价", "price");
        map3.put("总价", "totalPrice");
        map3.put("备注", "note");
        map3.put("订单编号", "orderNo");
        map.put(ExpInventoryList.class, map3);
        Map<String, String> map4 = new HashMap<String, String>();
        map4.put("传输企业代码", "copCode");
        map4.put("传输企业名称", "copName");
        map4.put("报文传输模式", "dxpMode");
        map4.put("报文传输编号", "dxpId");
        map4.put("备注", "note");
        map.put(BaseTransfer.class, map4);
        return map;
    }

    public Map<Class, Map<String, String>> getCEB621MessageConfigs() {
        Map<Class, Map<String, String>> map = new HashMap<Class, Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("系统唯一序号", "guid");
        map1.put("报送类型", "appType");
        map1.put("报送时间", "appTime");
        map1.put("业务状态", "appStatus");
        map1.put("订单编号", "orderNo");
        map1.put("电商平台代码", "ebpCode");
        map1.put("电商平台名称", "ebpName");
        map1.put("电商企业代码", "ebcCode");
        map1.put("电商企业名称", "ebcName");
        map1.put("物流运单编号", "logisticsNo");
        map1.put("物流企业代码", "logisticsCode");
        map1.put("物流企业名称", "logisticsName");
        map1.put("企业内部编号", "copNo");
        map1.put("预录入编号", "preNo");
        map1.put("担保企业编号", "assureCode");
        map1.put("账册编号", "emsNo");
        map1.put("清单编号", "invtNo");
        map1.put("进出口标记", "ieFlag");
        map1.put("申报日期", "declTime");
        map1.put("申报海关代码", "customsCode");
        map1.put("口岸海关代码", "portCode");
        map1.put("进口日期", "ieDate");
        map1.put("订购人证件类型", "buyerIdType");
        map1.put("订购人证件号码", "buyerIdNumber");
        map1.put("订购人姓名", "buyerName");
        map1.put("订购人电话", "buyerTelephone");
        map1.put("收件地址", "consigneeAddress");
        map1.put("申报企业代码", "agentCode");
        map1.put("申报企业名称", "agentName");
        map1.put("区内企业代码", "areaCode");
        map1.put("区内企业名称", "areaName");
        map1.put("贸易方式", "tradeMode");
        map1.put("运输方式", "trafMode");
        map1.put("运输工具编号", "trafNo");
        map1.put("航班航次号", "voyageNo");
        map1.put("提运单号", "billNo");
        map1.put("监管场所代码", "loctNo");
        map1.put("许可证件号", "licenseNo");
        map1.put("起运国（地区）", "country");
        map1.put("运费", "freight");
        map1.put("保费", "insuredFee");
        map1.put("币制", "currency");
        map1.put("包装种类代码", "wrapType");
        map1.put("件数", "packNo");
        map1.put("毛重（公斤）", "grossWeight");
        map1.put("净重（公斤）", "netWeight");
        map1.put("备注", "note");
        map.put(InventoryHead.class, map1);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("序号", "gnum");
        map2.put("账册备案料号", "itemRecordNo");
        map2.put("企业商品货号", "itemNo");
        map2.put("企业商品品名", "itemName");
        map2.put("商品编码", "gcode");
        map2.put("商品名称", "gname");
        map2.put("商品规格型号", "gmodel");
        map2.put("条形码", "barCode");
        map2.put("原产国（地区）", "country");
        map2.put("币制", "currency");
        map2.put("数量", "qty");
        map2.put("法定数量", "qty1");
        map2.put("第二数量", "qty2");
        map2.put("计量单位", "unit");
        map2.put("法定计量单位", "unit1");
        map2.put("第二计量单位", "unit2");
        map2.put("单价", "price");
        map2.put("总价", "totalPrice");
        map2.put("备注", "note");
        map2.put("订单编号", "orderNo");
        map.put(InventoryList.class, map2);
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("传输企业代码", "copCode");
        map3.put("传输企业名称", "copName");
        map3.put("报文传输模式", "dxpMode");
        map3.put("报文传输编号", "dxpId");
        map3.put("备注", "note");
        map.put(BaseTransfer.class, map3);
        return map;

    }

    public Map<Class, Map<String, String>> getCEB511MessageConfigs() {
        Map<Class, Map<String, String>> map = new HashMap<Class, Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("系统唯一序号", "guid");
        map1.put("报送类型", "appType");
        map1.put("报送时间", "appTime");
        map1.put("业务状态", "appStatus");
        map1.put("物流企业代码", "logisticsCode");
        map1.put("物流企业名称", "logisticsName");
        map1.put("物流运单编号", "logisticsNo");
        map1.put("提运单号", "billNo");
        map1.put("运费", "freight");
        map1.put("保价费", "insuredFee");
        map1.put("币制", "currency");
        map1.put("毛重", "weight");
        map1.put("件数", "packNo");
        map1.put("主要货物信息", "goodsInfo");
        map1.put("收货人姓名", "consignee");
        map1.put("收货地址", "consigneeAddress");
        map1.put("收货人电话", "consigneeTelephone");
        map1.put("备注", "note");
        map.put(LogisticsHead.class, map1);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("传输企业代码", "copCode");
        map2.put("传输企业名称", "copName");
        map2.put("报文传输模式", "dxpMode");
        map2.put("报文传输编号", "dxpId");
        map2.put("备注", "note");
        map.put(BaseTransfer.class, map2);
        return map;

    }
}
