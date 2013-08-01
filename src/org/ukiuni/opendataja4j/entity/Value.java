package org.ukiuni.opendataja4j.entity;

import java.util.Map;

public class Value {
	private Map<String, String> keyMap;
	private String value;

	public String getKey() {
		return keyMapToString(this.keyMap);
	}

	public Map<String, String> getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map<String, String> key) {
		this.keyMap = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static String keyMapToString(Map<String, String> keyMap) {
		StringBuilder builder = new StringBuilder();
		for (String key : keyMap.keySet()) {
			builder.append(":" + key + "=" + keyMap.get(key));
		}
		return builder.toString();
	}
}
