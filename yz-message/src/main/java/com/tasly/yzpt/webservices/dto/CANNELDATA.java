package com.tasly.yzpt.webservices.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "CANNELDATA")
@XmlType(name="CANNELDATA")
public class CANNELDATA {
	List<CANNELRETDATA> CANNELRETDATA;

	public CANNELDATA() {
		super();
	}
	public CANNELDATA(List<CANNELRETDATA> cannelRetdata) {
		super();
		this.CANNELRETDATA = cannelRetdata;
	}
	@XmlElement(name = "CANNELRETDATA")
	public List<CANNELRETDATA> getCannelRetdata() {
		return CANNELRETDATA;
	}
	public void setCannelRetdata(List<CANNELRETDATA> cannelRetdata) {
		this.CANNELRETDATA = cannelRetdata;
	}

}
