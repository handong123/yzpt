package com.tasly.yzpt.webservices.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="SENDRETDATA")
public class SENDRETDATA {

	String DANJ_NO;
	//承运商名称
	String CARRIER_NAME;
	//承运商ID
	String CARRIER_ID;
	//物流中心编码
	String WLZX_CODE;

	public SENDRETDATA(String dANJ_NO, String cARRIER_NAME, String cARRIER_ID, String wLZX_CODE) {
		super();
		DANJ_NO = dANJ_NO;
		CARRIER_NAME = cARRIER_NAME;
		CARRIER_ID = cARRIER_ID;
		WLZX_CODE = wLZX_CODE;
	}

	public SENDRETDATA() {
		super();
	}
	public String getDANJ_NO() {
		return DANJ_NO;
	}
	public void setDANJ_NO(String dANJ_NO) {
		DANJ_NO = dANJ_NO;
	}
	public String getCARRIER_NAME() {return CARRIER_NAME;}
	public void setCARRIER_NAME(String CARRIER_NAME) {this.CARRIER_NAME = CARRIER_NAME;}
	public String getCARRIER_ID() {return CARRIER_ID;}
	public void setCARRIER_ID(String CARRIER_ID) {this.CARRIER_ID = CARRIER_ID;}
	public String getWLZX_CODE() {return WLZX_CODE;}
	public void setWLZX_CODE(String WLZX_CODE) {this.WLZX_CODE = WLZX_CODE;}
}
