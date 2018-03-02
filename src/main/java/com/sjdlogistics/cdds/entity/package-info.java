@XmlSchema(
        namespace="http://www.chinaport.gov.cn/ceb"
        ,xmlns={@XmlNs(prefix="xsi",namespaceURI="http://www.sdeport.gov.cn/xsd/ArrivalSchema.xsd")
        ,@XmlNs(prefix="ceb",namespaceURI="http://www.chinaport.gov.cn/ceb")},

        elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED

)
package com.sjdlogistics.cdds.entity;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;