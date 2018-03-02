package com.sjdlogistics.cdds.util;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
    /**
     * bean转换成XML
     */
    public String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头声明信息
            StringWriter message = new StringWriter();
            OutputFormat format = new OutputFormat();
            format.setIndent(true);
            format.setNewlines(true);
            format.setNewLineAfterDeclaration(false);
            XMLWriter writer = new XMLWriter(message, format);
            marshaller.marshal(obj, writer);
            return message.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * bean转换成XML
     */
    public Map<String, String> toXML(String key, Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头声明信息
            StringWriter message = new StringWriter();
            OutputFormat format = new OutputFormat();
            format.setIndent(true);
            format.setNewlines(true);
            format.setNewLineAfterDeclaration(false);
            XMLWriter writer = new XMLWriter(message, format);
            marshaller.marshal(obj, writer);
            Map<String, String> map = new HashMap<String, String>();
            map.put(key, message.toString());
            return map;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



