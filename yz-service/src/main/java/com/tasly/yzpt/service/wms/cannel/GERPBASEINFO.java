
package com.tasly.yzpt.service.wms.cannel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GERP_BASEINFO complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GERP_BASEINFO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PMSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SENDTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S_PROVINCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="S_SYSYEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_PROVINCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="T_SYSTEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GERP_BASEINFO", propOrder = {
    "msgid",
    "pmsgid",
    "sendtime",
    "sprovince",
    "ssysyem",
    "servicename",
    "tprovince",
    "tsystem"
})
public class GERPBASEINFO {

    @XmlElement(name = "MSGID")
    protected String msgid;
    @XmlElement(name = "PMSGID")
    protected String pmsgid;
    @XmlElement(name = "SENDTIME")
    protected String sendtime;
    @XmlElement(name = "S_PROVINCE")
    protected String sprovince;
    @XmlElement(name = "S_SYSYEM")
    protected String ssysyem;
    @XmlElement(name = "SERVICENAME")
    protected String servicename;
    @XmlElement(name = "T_PROVINCE")
    protected String tprovince;
    @XmlElement(name = "T_SYSTEM")
    protected String tsystem;

    /**
     * 获取msgid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGID() {
        return msgid;
    }

    /**
     * 设置msgid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGID(String value) {
        this.msgid = value;
    }

    /**
     * 获取pmsgid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMSGID() {
        return pmsgid;
    }

    /**
     * 设置pmsgid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMSGID(String value) {
        this.pmsgid = value;
    }

    /**
     * 获取sendtime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDTIME() {
        return sendtime;
    }

    /**
     * 设置sendtime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDTIME(String value) {
        this.sendtime = value;
    }

    /**
     * 获取sprovince属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPROVINCE() {
        return sprovince;
    }

    /**
     * 设置sprovince属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPROVINCE(String value) {
        this.sprovince = value;
    }

    /**
     * 获取ssysyem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSYSYEM() {
        return ssysyem;
    }

    /**
     * 设置ssysyem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSYSYEM(String value) {
        this.ssysyem = value;
    }

    /**
     * 获取servicename属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICENAME() {
        return servicename;
    }

    /**
     * 设置servicename属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICENAME(String value) {
        this.servicename = value;
    }

    /**
     * 获取tprovince属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPROVINCE() {
        return tprovince;
    }

    /**
     * 设置tprovince属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPROVINCE(String value) {
        this.tprovince = value;
    }

    /**
     * 获取tsystem属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTSYSTEM() {
        return tsystem;
    }

    /**
     * 设置tsystem属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTSYSTEM(String value) {
        this.tsystem = value;
    }

}
