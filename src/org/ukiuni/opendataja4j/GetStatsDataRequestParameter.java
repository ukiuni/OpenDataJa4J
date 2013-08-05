package org.ukiuni.opendataja4j;

public class GetStatsDataRequestParameter extends RequestParameter {
	private long startPosition;
	private long limit;
	private boolean metaGetFlg = true;
	private boolean cntGetFlg;

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

	public boolean getMetaGetFlg() {
		return metaGetFlg;
	}

	public void setMetaGetFlg(boolean metaGetFlg) {
		this.metaGetFlg = metaGetFlg;
	}

	public boolean getCntGetFlg() {
		return cntGetFlg;
	}

	public void setCntGetFlg(boolean cntGetFlg) {
		this.cntGetFlg = cntGetFlg;
	}

	public String toParamString() {
		String parameters = super.toParamString();
		if (0 < startPosition) {
			parameters += "&startPosition=" + startPosition;
		}
		if (0 < limit) {
			parameters += "&limit=" + limit;
		}
		if (!metaGetFlg) {
			parameters += "&metaGetFlg=N";
		}
		if (cntGetFlg) {
			parameters += "&cntGetFlg=Y";
		}
		return parameters;
	}
}
