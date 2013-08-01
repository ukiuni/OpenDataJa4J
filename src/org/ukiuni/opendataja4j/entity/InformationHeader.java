package org.ukiuni.opendataja4j.entity;

import java.util.Map;

public class InformationHeader {
	private String id;
	private String name;
	private Map<String, Information> informationMap;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Information> getInformationMap() {
		return informationMap;
	}

	public void setInformationMap(Map<String, Information> informationMap) {
		this.informationMap = informationMap;
	}
}
