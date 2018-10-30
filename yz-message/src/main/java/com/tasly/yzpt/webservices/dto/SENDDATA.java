package com.tasly.yzpt.webservices.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "SENDDATA")
@XmlType(name="SENDDATA")
public class SENDDATA {
	List<SENDRETDATA> SENDRETDATA;

	public SENDDATA() {
		super();
	}
	public SENDDATA(List<SENDRETDATA> sendRetdata) {
		super();
		this.SENDRETDATA = sendRetdata;
	}
	@XmlElement(name = "SENDRETDATA")
	public List<SENDRETDATA> getSendRetdata() {
		return SENDRETDATA;
	}
	public void setSendRetdata(List<SENDRETDATA> sendRetdata) {
		this.SENDRETDATA = sendRetdata;
	}

}
