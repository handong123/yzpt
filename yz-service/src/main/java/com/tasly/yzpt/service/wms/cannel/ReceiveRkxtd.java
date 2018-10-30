
package com.tasly.yzpt.service.wms.cannel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="I_REQUEST" type="{http://wservice.rkxtd/}INFDATA" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "irequest"
})
@XmlRootElement(name = "ReceiveRkxtd")
public class ReceiveRkxtd {

    @XmlElement(name = "I_REQUEST")
    protected INFDATA irequest;

    /**
     * 获取irequest属性的值。
     * 
     * @return
     *     possible object is
     *     {@link INFDATA }
     *     
     */
    public INFDATA getIREQUEST() {
        return irequest;
    }

    /**
     * 设置irequest属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link INFDATA }
     *     
     */
    public void setIREQUEST(INFDATA value) {
        this.irequest = value;
    }

}
