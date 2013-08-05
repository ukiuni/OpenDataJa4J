package org.ukiuni.opendataja4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class RequestParameter {
	public static final String ENCODE = "UTF-8";
	private Lang lang;

	public static enum Lang {
		Japanese, English;
	}

	private String dataSetId;
	private String statsDataId;
	private String lvTab;
	private String cdTab;
	private String cdTabFrom;
	private String cdTabTo;
	private String lvTime;
	private String cdTime;
	private String cdTimeFrom;
	private String cdTimeTo;
	private String lvArea;
	private String cdArea;
	private String cdAreaFrom;
	private String cdAreaTo;
	private String lvCat[];
	private String cdCat[];
	private String cdCatFrom[];
	private String cdCatTo[];

	public Lang getLang() {
		return lang;
	}

	public void setLang(Lang lang) {
		this.lang = lang;
	}

	public String getDataSetId() {
		return dataSetId;
	}

	public void setDataSetId(String dataSetId) {
		this.dataSetId = dataSetId;
	}

	public String getStatsDataId() {
		return statsDataId;
	}

	public void setStatsDataId(String statsDataId) {
		this.statsDataId = statsDataId;
	}

	public String getLvTab() {
		return lvTab;
	}

	public void setLvTab(String lvTab) {
		this.lvTab = lvTab;
	}

	public String getCdTab() {
		return cdTab;
	}

	public void setCdTab(String cdTab) {
		this.cdTab = cdTab;
	}

	public String getCdTabFrom() {
		return cdTabFrom;
	}

	public void setCdTabFrom(String cdTabFrom) {
		this.cdTabFrom = cdTabFrom;
	}

	public String getCdTabTo() {
		return cdTabTo;
	}

	public void setCdTabTo(String cdTabTo) {
		this.cdTabTo = cdTabTo;
	}

	public String getLvTime() {
		return lvTime;
	}

	public void setLvTime(String lvTime) {
		this.lvTime = lvTime;
	}

	public String getCdTime() {
		return cdTime;
	}

	public void setCdTime(String cdTime) {
		this.cdTime = cdTime;
	}

	public String getCdTimeFrom() {
		return cdTimeFrom;
	}

	public void setCdTimeFrom(String cdTimeFrom) {
		this.cdTimeFrom = cdTimeFrom;
	}

	public String getCdTimeTo() {
		return cdTimeTo;
	}

	public void setCdTimeTo(String cdTimeTo) {
		this.cdTimeTo = cdTimeTo;
	}

	public String getLvArea() {
		return lvArea;
	}

	public void setLvArea(String lvArea) {
		this.lvArea = lvArea;
	}

	public String getCdArea() {
		return cdArea;
	}

	public void setCdArea(String cdArea) {
		this.cdArea = cdArea;
	}

	public String getCdAreaFrom() {
		return cdAreaFrom;
	}

	public void setCdAreaFrom(String cdAreaFrom) {
		this.cdAreaFrom = cdAreaFrom;
	}

	public String getCdAreaTo() {
		return cdAreaTo;
	}

	public void setCdAreaTo(String cdAreaTo) {
		this.cdAreaTo = cdAreaTo;
	}

	public String[] getLvCat() {
		return lvCat;
	}

	public void setLvCat(String[] lvCat) {
		this.lvCat = lvCat;
	}

	public String[] getCdCat() {
		return cdCat;
	}

	public void setCdCat(String[] cdCat) {
		this.cdCat = cdCat;
	}

	public String[] getCdCatFrom() {
		return cdCatFrom;
	}

	public void setCdCatFrom(String[] cdCatFrom) {
		this.cdCatFrom = cdCatFrom;
	}

	public String[] getCdCatTo() {
		return cdCatTo;
	}

	public void setCdCatTo(String[] cdCatTo) {
		this.cdCatTo = cdCatTo;
	}

	public String toParamString() {
		String parameters = "";
		if (Lang.English == lang) {
			parameters += "&lang=E";
		}
		if (null != dataSetId) {
			parameters += "&dataSetId=" + urlEncode(dataSetId);
		}
		if (null != statsDataId) {
			parameters += "&statsDataId=" + urlEncode(statsDataId);
		}
		if (null != lvTab) {
			parameters += "&lvTab=" + urlEncode(lvTab);
		}
		if (null != cdTab) {
			parameters += "&cdTab=" + urlEncode(cdTab);
		}
		if (null != cdTabFrom) {
			parameters += "&cdTabFrom=" + urlEncode(cdTabFrom);
		}
		if (null != cdTabTo) {
			parameters += "&cdTabTo=" + urlEncode(cdTabTo);
		}
		if (null != lvTime) {
			parameters += "&lvTime=" + urlEncode(lvTime);
		}
		if (null != cdTime) {
			parameters += "&cdTime=" + urlEncode(cdTime);
		}
		if (null != cdTimeFrom) {
			parameters += "&cdTimeFrom=" + urlEncode(cdTimeFrom);
		}
		if (null != cdTimeTo) {
			parameters += "&cdTimeTo=" + urlEncode(cdTimeTo);
		}
		if (null != lvArea) {
			parameters += "&lvArea=" + urlEncode(lvArea);
		}
		if (null != cdArea) {
			parameters += "&cdArea=" + urlEncode(cdArea);
		}
		if (null != cdAreaFrom) {
			parameters += "&cdAreaFrom=" + urlEncode(cdAreaFrom);
		}
		if (null != cdAreaTo) {
			parameters += "&cdAreaTo=" + urlEncode(cdAreaTo);
		}
		if (null != lvCat) {
			for (int i = 0; i < lvCat.length; i++) {
				if (null == lvCat[i]) {
					continue;
				}
				int key = i + 1;
				String keyString = String.valueOf(key);
				if (key < 10) {
					keyString = "0" + keyString;
				}
				parameters += "&lvCat" + keyString + "=" + urlEncode(lvCat[i]);
			}
		}
		if (null != cdCat) {
			for (int i = 0; i < cdCat.length; i++) {
				if (null == cdCat[i]) {
					continue;
				}
				int key = i + 1;
				String keyString = String.valueOf(key);
				if (key < 10) {
					keyString = "0" + keyString;
				}
				parameters += "&cdCat" + keyString + "=" + urlEncode(cdCat[i]);
			}
		}
		if (null != cdCatFrom) {
			for (int i = 0; i < cdCatFrom.length; i++) {
				if (null == cdCatFrom[i]) {
					continue;
				}
				int key = i + 1;
				String keyString = String.valueOf(key);
				if (key < 10) {
					keyString = "0" + keyString;
				}
				parameters += "&cdCat" + keyString + "From=" + urlEncode(cdCatFrom[i]);
			}
		}
		if (null != cdCatTo) {
			for (int i = 0; i < cdCatTo.length; i++) {
				if (null == cdCatTo[i]) {
					continue;
				}
				int key = i + 1;
				String keyString = String.valueOf(key);
				if (key < 10) {
					keyString = "0" + keyString;
				}
				parameters += "&cdCat" + keyString + "To=" + urlEncode(cdCatTo[i]);
			}
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
