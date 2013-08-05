package org.ukiuni.opendataja4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GetStatsListRequestParameter {
	public static final String ENCODE = "UTF-8";
	private Lang lang;

	public static enum Lang {
		Japanese, English;
	}

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

	public Lang getLang() {
		return lang;
	}

	public void setLang(Lang lang) {
		this.lang = lang;
	}

	protected String toParamString() {
		String parameters = "";
		if (Lang.English != lang) {
			parameters += "&lang=E";
		}
		if (null != surveyYears) {
			parameters += "&surveyYears=" + urlEncode(surveyYears);
		}
		if (null != openYears) {
			parameters += "&openYears=" + urlEncode(openYears);
		}
		if (null != statsField) {
			parameters += "&statsField=" + urlEncode(statsField);
		}
		if (null != statsCode) {
			parameters += "&statsCode=" + urlEncode(statsCode);
		}
		if (null != searchWord) {
			parameters += "&searchWord=" + urlEncode(searchWord);
		}
		if (null != searchKind) {
			parameters += "&searchKind=" + urlEncode(searchKind);
		}
		if (null != statsNameList) {
			parameters += "&statsNameList=" + urlEncode(statsNameList);
		}
		return parameters;
	}

	protected String urlEncode(String src) {
		try {
			return URLEncoder.encode(src, ENCODE);
		} catch (UnsupportedEncodingException e) {
			// never happen;
			throw new RuntimeException(e);
		}
	}
}
