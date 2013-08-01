package org.ukiuni.opendataja4j.entity;

import java.util.List;
import java.util.Map;

public class DataInf {
	private List<Note> notes;
	private Map<String, Value> values;

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Map<String, Value> getValues() {
		return values;
	}

	public void setValues(Map<String, Value> values) {
		this.values = values;
	}
}
