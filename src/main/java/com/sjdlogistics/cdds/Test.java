package com.sjdlogistics.cdds;

import com.sjdlogistics.cdds.entity.*;
import com.sjdlogistics.cdds.util.HttpClientUtil;
import com.sjdlogistics.cdds.util.MessageUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

public class Test {

    private String url = "http://api.cdkjt.net:8888/rest/declare";
    private String charset = "UTF-8";
    private HttpClientUtil httpClientUtil = null;
    private MessageUtil messageUtil = null;

    public Test(){
        httpClientUtil = new HttpClientUtil();
        messageUtil = new MessageUtil();
    }

    public static void main(String[] args){
        Test main = new Test();
        //main.doPost();
        String ss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<CebExpInvtReturnMessage xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\"\n" +
                "                         guid=\"21a6436c-bf8d-4954-9b0a-9a82ec2ecdc5\">\n" +
                "    <ExpInvtReturn>\n" +
                "        <guid>44F02F99-A38F-45A8-93BA-EB86A8DF0512</guid>\n" +
                "        <returnStatus>2</returnStatus>\n" +
                "        <returnTime>20171112202010405</returnTime>\n" +
                "        <returnInfo>申报中</returnInfo>\n" +
                "    </ExpInvtReturn>\n" +
                "</CebExpInvtReturnMessage>";
        main.getReturn(ss);
    }

    public void doPost(){
        String requestXml = messageUtil.toXML(getCebExpInvtMessage());
        Document doc = null;
        String guid = UUID.randomUUID().toString();
        try {
            doc = DocumentHelper.parseText(requestXml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        doc.getRootElement().addAttribute("version","1.0");
        doc.getRootElement().addAttribute("guid", guid);
        Map<String,String> map = new HashMap<String, String>();
        map.put("xml",doc.asXML());
        String returnMessage = httpClientUtil.doPost(url,map,charset);

        System.out.println(doc.asXML());
        System.out.println(returnMessage);
    }

    public void getReturn(String returnMessage){

        try {
            JAXBContext cxt = JAXBContext.newInstance(CebExpInvtReturnMessage.class);
            Unmarshaller unmarshaller = cxt.createUnmarshaller();
            InputStream in_withcode   = null;

            in_withcode = new ByteArrayInputStream(returnMessage.getBytes("UTF-8"));

            CebExpInvtReturnMessage msgs = (CebExpInvtReturnMessage) unmarshaller.unmarshal(in_withcode);
            System.out.println("22");

        } catch (JAXBException e) {
            e.printStackTrace();
        }   catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public CebExpInvtMessage getCebExpInvtMessage() {

        ExpOrderInfo expOrderInfo = new ExpOrderInfo("jh0001", "20170103000000", 2, "502",
                new BigDecimal("6.7000"), new BigDecimal("50.00"), "alice", "309",
                "Amsterdam,NE", "023-25641236", "alice@hotmail.com",
                "P000000003", "电商平台测试");
        ExpInventoryHead expInventoryHead = new ExpInventoryHead("jh0001", "P000000003",
                "电商平台测试", "E000000004", "电商企业测试", "123",
                "电商企业测试", "L000000003", "物流企业测试", "jh0001",
                "235", "jh0001", "", "E", "20171103000000", "7901",
                "7901", "20161206", "A000080003", "上海报关", "J000000003",
                "上海监管场所", "1210", "a", "ww", "ee", "ww",
                "", "", "", "309", "309", new BigDecimal("6.7000"),
                "142", "3", new BigDecimal("0.00000"), "142", "3", "a",
                1, new BigDecimal("1.00000"), new BigDecimal("0.80000"), "");
        ExpInventoryList expInventoryList1 = new ExpInventoryList((short) 1, "", "123", "6114300090",
                "商品1", "商品规格", "无", "309", "142", new BigDecimal("3.00000"),
                new BigDecimal("2.00000"), new BigDecimal("2.00000"), "007", "007", "007",
                new BigDecimal("200.00000"), new BigDecimal("200.00000"), "", "jh0001");
        ExpInventoryList expInventoryList2 = new ExpInventoryList((short) 2, "", "342", "6114300090",
                "商品2", "商品规格", "无", "309", "142", new BigDecimal("3.00000"),
                new BigDecimal("2.00000"), new BigDecimal("2.00000"), "007", "007", "007",
                new BigDecimal("400.00000"), new BigDecimal("400.00000"), "", "jh0001");
        List<ExpInventoryList> expInventoryLists = new ArrayList<ExpInventoryList>();
        expInventoryLists.add(expInventoryList1);
        expInventoryLists.add(expInventoryList2);
        BaseTransfer baseTransfer = new BaseTransfer("L000000003", "物流企业测试", "DXP", "", "");

        CebExpInvtMessage cebExpInvtMessage = new CebExpInvtMessage(new ExpInvt(expOrderInfo, new ExpInventory(expInventoryHead, expInventoryLists)), baseTransfer);

        return cebExpInvtMessage;

    }
}
