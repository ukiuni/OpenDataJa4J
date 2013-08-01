package org.ukiuni.opendataja4j;

public class GetStatsDataRequestParameter {
	private String lang;
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
	private long startPosition;
	private long limit;
	private String metaGetFlg;
	private String cntGetFlg;
	private String callback;

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

	public long getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(long startPosition) {
		this.startPosition = startPosition;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public String getMetaGetFlg() {
		return metaGetFlg;
	}

	public void setMetaGetFlg(String metaGetFlg) {
		this.metaGetFlg = metaGetFlg;
	}

	public String getCntGetFlg() {
		return cntGetFlg;
	}

	public void setCntGetFlg(String cntGetFlg) {
		this.cntGetFlg = cntGetFlg;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String toParamString() {
		String parameters = "";
		if (null != lang) {
			parameters += "&lang=" + lang;
		}
		if (null != dataSetId) {
			parameters += "&dataSetId=" + dataSetId;
		}
		if (null != statsDataId) {
			parameters += "&statsDataId=" + statsDataId;
		}
		if (null != lvTab) {
			parameters += "&lvTab=" + lvTab;
		}
		if (null != cdTab) {
			parameters += "&cdTab=" + cdTab;
		}
		if (null != cdTabFrom) {
			parameters += "&cdTabFrom=" + cdTabFrom;
		}
		if (null != cdTabTo) {
			parameters += "&cdTabTo=" + cdTabTo;
		}
		if (null != lvTime) {
			parameters += "&lvTime=" + lvTime;
		}
		if (null != cdTime) {
			parameters += "&cdTime=" + cdTime;
		}
		if (null != cdTimeFrom) {
			parameters += "&cdTimeFrom=" + cdTimeFrom;
		}
		if (null != cdTimeTo) {
			parameters += "&cdTimeTo=" + cdTimeTo;
		}
		if (null != lvArea) {
			parameters += "&lvArea=" + lvArea;
		}
		if (null != cdArea) {
			parameters += "&cdArea=" + cdArea;
		}
		if (null != cdAreaFrom) {
			parameters += "&cdAreaFrom=" + cdAreaFrom;
		}
		if (null != cdAreaTo) {
			parameters += "&cdAreaTo=" + cdAreaTo;
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
				parameters += "&lvCat" + keyString + "=" + lvCat[i];
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
				parameters += "&cdCat" + keyString + "=" + cdCat[i];
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
				parameters += "&cdCat" + keyString + "From=" + cdCatFrom[i];
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
				parameters += "&cdCat" + keyString + "To=" + cdCatTo[i];
			}
		}
		if (0 < startPosition) {
			parameters += "&startPosition=" + startPosition;
		}
		if (0 < limit) {
			parameters += "&limit=" + limit;
		}
		if (null != metaGetFlg) {
			parameters += "&metaGetFlg=" + metaGetFlg;
		}
		if (null != cntGetFlg) {
			parameters += "&cntGetFlg=" + cntGetFlg;
		}
		if (null != callback) {
			parameters += "&callback=" + callback;
		}
		return parameters;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
}
