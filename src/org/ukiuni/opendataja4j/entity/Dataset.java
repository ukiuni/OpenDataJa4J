package org.ukiuni.opendataja4j.entity;

public class Dataset {
	private String lang;
	private String datasetId;
	private String datasetName;
	private String statusDataId;
	private NarrowingCondition narrowingCondition;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	public String getStatusDataId() {
		return statusDataId;
	}

	public void setStatusDataId(String statusDataId) {
		this.statusDataId = statusDataId;
	}

	public NarrowingCondition getNarrowingCondition() {
		return narrowingCondition;
	}

	public void setNarrowingCondition(NarrowingCondition narrowingCondition) {
		this.narrowingCondition = narrowingCondition;
	}
}
