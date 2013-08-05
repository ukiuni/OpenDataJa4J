package org.ukiuni.opendataja4j.xml;

import java.util.ArrayList;
import java.util.List;

import org.ukiuni.opendataja4j.entity.DatasetInformation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class RefDatasetInfomationHandler extends ResultDataHandler<List<DatasetInformation>> {
	List<DatasetInformation> datasetInformations;

	private DatasetInformation currentDatasetInformation;

	@Override
	public void startDocument() throws SAXException {
		this.datasetInformations = new ArrayList<DatasetInformation>();
	}

	public void endDocument() {
		getResult().setValue(datasetInformations);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("LIST_INF")) {
			currentDatasetInformation = new DatasetInformation();
			currentDatasetInformation.setId(attributes.getValue("id"));
			outFlg = true;
		} else if (qName.equals("DATASET_NAME")) {
			outFlg = true;
		} else if (qName.equals("STATS_DATA_ID")) {
			outFlg = true;
		} else if (qName.equals("STAT_NAME")) {
			currentDatasetInformation.setStatCode(attributes.getValue("code"));
			outFlg = true;
		} else if (qName.equals("GOV_ORG")) {
			currentDatasetInformation.setGovernmentCode(attributes.getValue("code"));
			outFlg = true;
		} else if (qName.equals("STATISTICS_NAME")) {
			outFlg = true;
		} else if (qName.equals("TITLE")) {
			currentDatasetInformation.setTitleNo(attributes.getValue("no"));
			outFlg = true;
		} else if (qName.equals("PUBLIC_STATE")) {
			outFlg = true;
		} else if (qName.equals("CELLS_NUM")) {
			outFlg = true;
		}

	}

	public void endElement(String uri, String localName, String qName) {
		super.endElement(uri, localName, qName);
		if (qName.equals("LIST_INF")) {
			datasetInformations.add(currentDatasetInformation);
			outFlg = false;
		} else if (qName.equals("DATASET_NAME")) {
			currentDatasetInformation.setDatasetName(currentValue);
			outFlg = false;
		} else if (qName.equals("STATS_DATA_ID")) {
			currentDatasetInformation.setStatsDataId(currentValue);
			outFlg = false;
		} else if (qName.equals("STAT_NAME")) {
			currentDatasetInformation.setStatName(currentValue);
			outFlg = false;
		} else if (qName.equals("GOV_ORG")) {
			currentDatasetInformation.setGovernmentName(currentValue);
			outFlg = false;
		} else if (qName.equals("STATISTICS_NAME")) {
			currentDatasetInformation.setStatisticsName(currentValue);
			outFlg = false;
		} else if (qName.equals("TITLE")) {
			currentDatasetInformation.setTitle(currentValue);
			outFlg = false;
		} else if (qName.equals("PUBLIC_STATE")) {
			currentDatasetInformation.setPublicState(currentValue);
			outFlg = false;
		} else if (qName.equals("CELLS_NUM")) {
			currentDatasetInformation.setCellsNumber(currentValue);
			outFlg = false;
		}
	}
}
