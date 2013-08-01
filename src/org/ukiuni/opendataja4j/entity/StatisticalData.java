package org.ukiuni.opendataja4j.entity;

import java.util.Date;

public class StatisticalData {
	private String id;
	private String statCode;
	private String statName;
	private Government government;
	private String statisticsName;
	private Title title;
	private Date surveyDateFrom;
	private Date surveyDateTo;
	private long totalNumber;
	private long fromNumber;
	private long toNumber;
	private long nextKey;
	private MetaData metaData;
	private DataInf dataInf;

	public long getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(long fromNumber) {
		this.fromNumber = fromNumber;
	}

	public long getToNumber() {
		return toNumber;
	}

	public void setToNumber(long toNumber) {
		this.toNumber = toNumber;
	}

	public long getNextKey() {
		return nextKey;
	}

	public void setNextKey(long nextKey) {
		this.nextKey = nextKey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatCode() {
		return statCode;
	}

	public void setStatCode(String statCode) {
		this.statCode = statCode;
	}

	public String getStatName() {
		return statName;
	}

	public void setStatName(String statName) {
		this.statName = statName;
	}

	public Government getGovernment() {
		return government;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}

	public String getStatisticsName() {
		return statisticsName;
	}

	public void setStatisticsName(String statisticsName) {
		this.statisticsName = statisticsName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Date getSurveyDateFrom() {
		return surveyDateFrom;
	}

	public void setSurveyDateFrom(Date surveyDateFrom) {
		this.surveyDateFrom = surveyDateFrom;
	}

	public Date getSurveyDateTo() {
		return surveyDateTo;
	}

	public void setSurveyDateTo(Date surveyDateTo) {
		this.surveyDateTo = surveyDateTo;
	}

	public long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public DataInf getDataInf() {
		return dataInf;
	}

	public void setDataInf(DataInf dataInf) {
		this.dataInf = dataInf;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

}
