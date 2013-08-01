package org.ukiuni.opendataja4j.entity;

import java.util.Date;
import java.util.Map;

public class MetaData {
	private String id;
	private String statCode;
	private String statName;
	private Government government;
	private String statisticsName;
	private Title title;
	private Date surveyDateFrom;
	private Date surveyDateTo;
	private Map<String, InformationHeader> informationHeaderMap;

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

	public Map<String, InformationHeader> getInformationHeaderMap() {
		return informationHeaderMap;
	}

	public void setInformationHeaderMap(Map<String, InformationHeader> informationHeaderMap) {
		this.informationHeaderMap = informationHeaderMap;
	}

	public String getStatisticsName() {
		return statisticsName;
	}

	public void setStatisticsName(String statisticsName) {
		this.statisticsName = statisticsName;
	}
}
