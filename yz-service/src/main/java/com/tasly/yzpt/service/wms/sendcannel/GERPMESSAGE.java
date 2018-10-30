
package com.tasly.yzpt.service.wms.sendcannel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GERP_MESSAGE complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GERP_MESSAGE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ARRAYSTRING" type="{http://wservice.rkxtd/}GERP_ARRAYSTRING" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GERP_MESSAGE", propOrder = {
    "arraystring"
})
public class GERPMESSAGE {

    @XmlElement(name = "ARRAYSTRING")
    protected GERPARRAYSTRING arraystring;

    /**
     * 获取arraystring属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GERPARRAYSTRING }
     *     
     */
    public GERPARRAYSTRING getARRAYSTRING() {
        return arraystring;
    }

    /**
     * 设置arraystring属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GERPARRAYSTRING }
     *     
     */
    public void setARRAYSTRING(GERPARRAYSTRING value) {
        this.arraystring = value;
    }

}
