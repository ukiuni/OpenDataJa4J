package org.ukiuni.opendataja4j.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Title implements Serializable{
	private String no;
	private String name;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
