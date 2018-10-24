
package com.tasly.yzpt.service.wms.send;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>INFDATA complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="INFDATA">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BASEINFO" type="{http://wservice.ckkpd/}GERP_BASEINFO" minOccurs="0"/>
 *         &lt;element name="MESSAGE" type="{http://wservice.ckkpd/}GERP_MESSAGE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INFDATA", propOrder = {
    "baseinfo",
    "message"
})
public class INFDATA {

    @XmlElement(name = "BASEINFO")
    protected GERPBASEINFO baseinfo;
    @XmlElement(name = "MESSAGE")
    protected GERPMESSAGE message;

    /**
     * 获取baseinfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GERPBASEINFO }
     *     
     */
    public GERPBASEINFO getBASEINFO() {
        return baseinfo;
    }

    /**
     * 设置baseinfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GERPBASEINFO }
     *     
     */
    public void setBASEINFO(GERPBASEINFO value) {
        this.baseinfo = value;
    }

    /**
     * 获取message属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GERPMESSAGE }
     *     
     */
    public GERPMESSAGE getMESSAGE() {
        return message;
    }

    /**
     * 设置message属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GERPMESSAGE }
     *     
     */
    public void setMESSAGE(GERPMESSAGE value) {
        this.message = value;
    }

}
