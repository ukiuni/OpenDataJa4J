package org.ukiuni.opendataja4j;

public class PostDatasetRequestParameter extends RequestParameter {
	private boolean penSpecified;
	private ProcessMode processMode;
	private String dataSetName;

	public static enum ProcessMode {
		PUT, DELETE
	}

	public String toParamString() {
		String parameters = super.toParamString();
		if (penSpecified) {
			parameters += "&penSpecified=1";
		}
		if (null != processMode) {
			parameters += "&processMode=" + processMode;
		}
		if (null != dataSetName) {
			parameters += "&dataSetName=" + dataSetName;
		}
		return parameters;
	}
}
