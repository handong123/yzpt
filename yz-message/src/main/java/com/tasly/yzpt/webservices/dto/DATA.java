package com.tasly.yzpt.webservices.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "DATA")
@XmlType(name="DATA")
public class DATA {
	List<RETDATA> RETDATA;

	public DATA() {
		super();
	}
	public DATA(List<RETDATA> retdata) {
		super();
		this.RETDATA = retdata;
	}
	@XmlElement(name = "RETDATA")
	public List<RETDATA> getRetdata() {
		return RETDATA;
	}
	public void setRetdata(List<RETDATA> retdata) {
		this.RETDATA = retdata;
	}

}
