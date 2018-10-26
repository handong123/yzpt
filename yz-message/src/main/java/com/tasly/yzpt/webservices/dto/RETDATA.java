package com.tasly.yzpt.webservices.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="RETDATA")
public class RETDATA {
	String DANJ_NO;
	String HANGHAO;
	String ZFLAG;
	String ZMESSAGE;
	
	public RETDATA(String dANJ_NO, String hANGHAO, String zFLAG, String zMESSAGE) {
		super();
		DANJ_NO = dANJ_NO;
		HANGHAO = hANGHAO;
		ZFLAG = zFLAG;
		ZMESSAGE = zMESSAGE;
	}
	
	public RETDATA() {
		super();
	}

	public String getDANJ_NO() {
		return DANJ_NO;
	}
	public void setDANJ_NO(String dANJ_NO) {
		DANJ_NO = dANJ_NO;
	}
	public String getHANGHAO() {
		return HANGHAO;
	}
	public void setHANGHAO(String hANGHAO) {
		HANGHAO = hANGHAO;
	}
	public String getZFLAG() {
		return ZFLAG;
	}
	public void setZFLAG(String zFLAG) {
		ZFLAG = zFLAG;
	}
	public String getZMESSAGE() {
		return ZMESSAGE;
	}
	public void setZMESSAGE(String zMESSAGE) {
		ZMESSAGE = zMESSAGE;
	}


}
