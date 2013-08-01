package org.ukiuni.opendataja4j;

public class GetStatsListRequestParameter {
	private String lang;
	private String surveyYears;
	private String openYears;
	private String statsField;
	private String statsCode;
	private String searchWord;
	private String searchKind;
	private String statsNameList;

	public String getSurveyYears() {
		return surveyYears;
	}

	public void setSurveyYears(String surveyYears) {
		this.surveyYears = surveyYears;
	}

	public String getOpenYears() {
		return openYears;
	}

	public void setOpenYears(String openYears) {
		this.openYears = openYears;
	}

	public String getStatsField() {
		return statsField;
	}

	public void setStatsField(String statsField) {
		this.statsField = statsField;
	}

	public String getStatsCode() {
		return statsCode;
	}

	public void setStatsCode(String statsCode) {
		this.statsCode = statsCode;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchKind() {
		return searchKind;
	}

	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}

	public String getStatsNameList() {
		return statsNameList;
	}

	public void setStatsNameList(String statsNameList) {
		this.statsNameList = statsNameList;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	protected String toParamString() {
		String parameters = "";
		if (null != lang) {
			parameters += "&lang=" + lang;
		}
		if (null != surveyYears) {
			parameters += "&surveyYears=" + surveyYears;
		}
		if (null != openYears) {
			parameters += "&openYears=" + openYears;
		}
		if (null != statsField) {
			parameters += "&statsField=" + statsField;
		}
		if (null != statsCode) {
			parameters += "&statsCode=" + statsCode;
		}
		if (null != searchWord) {
			parameters += "&searchWord=" + searchWord;
		}
		if (null != searchKind) {
			parameters += "&searchKind=" + searchKind;
		}
		if (null != statsNameList) {
			parameters += "&statsNameList=" + statsNameList;
		}
		return parameters;
	}
}
