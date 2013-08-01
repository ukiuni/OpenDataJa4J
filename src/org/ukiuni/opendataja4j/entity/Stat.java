package org.ukiuni.opendataja4j.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Stat implements Serializable{
	private String id;
	private String code;
	private String name;
	private Government government;
	private String statisticsName;
	private Title title;
	private String cycle;
	private Date surveyDateFrom;
	private Date surveyDateTo;
	private Date openDate;
	private String smallArea;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
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

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getSmallArea() {
		return smallArea;
	}

	public void setSmallArea(String smallArea) {
		this.smallArea = smallArea;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Government getGovernment() {
		return government;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}
}
