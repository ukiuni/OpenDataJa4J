package org.ukiuni.opendataja4j.xml;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.ukiuni.opendataja4j.entity.DataInf;
import org.ukiuni.opendataja4j.entity.Government;
import org.ukiuni.opendataja4j.entity.Note;
import org.ukiuni.opendataja4j.entity.StatisticalData;
import org.ukiuni.opendataja4j.entity.Title;
import org.ukiuni.opendataja4j.entity.Value;
import org.xml.sax.Attributes;

public class GetStatsDataHandler extends ResultDataHandler<StatisticalData> {
	private GetMetaDataHandler metaDataHandler = new GetMetaDataHandler();
	private StatisticalData statisticalData;

	private DataInf currentDataInf;
	private Note currentNote;
	private Value currentValueObj;

	public void startDocument() {
		statisticalData = new StatisticalData();
	}

	public void endDocument() {
		statisticalData.setMetaData(metaDataHandler.getMetaData());
		getResult().setValue(statisticalData);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		super.startElement(uri, localName, qName, attributes);
		metaDataHandler.startElement(uri, localName, qName, attributes);
		if (qName.equals("TABLE_INF")) {
			statisticalData.setId(attributes.getValue("id"));
			outFlg = true;
		} else if (qName.equals("STAT_NAME")) {
			statisticalData.setStatCode(attributes.getValue("code"));
			outFlg = true;
		} else if (qName.equals("GOV_ORG")) {
			statisticalData.setGovernment(new Government());
			statisticalData.getGovernment().setCode(attributes.getValue("code"));
			outFlg = true;
		} else if (qName.equals("STATISTICS_NAME")) {
			outFlg = true;
		} else if (qName.equals("TITLE")) {
			statisticalData.setTitle(new Title());
			statisticalData.getTitle().setNo(attributes.getValue("no"));
			outFlg = true;
		} else if (qName.equals("CYCLE")) {
			outFlg = true;
		} else if (qName.equals("SURVEY_DATE")) {
			outFlg = true;
		} else if (qName.equals("TOTAL_NUMBER")) {
			outFlg = true;
		} else if (qName.equals("FROM_NUMBER")) {
			outFlg = true;
		} else if (qName.equals("TO_NUMBER")) {
			outFlg = true;
		} else if (qName.equals("NEXT_KEY")) {
			outFlg = true;
		} else if (qName.equals("DATA_INF")) {
			currentDataInf = new DataInf();
			currentDataInf.setNotes(new ArrayList<Note>());
			currentDataInf.setValues(new HashMap<String, Value>());
			outFlg = true;
		} else if (qName.equals("NOTE")) {
			currentNote = new Note();
			currentNote.setCharactor(attributes.getValue("no"));
			outFlg = true;
		} else if (qName.equals("VALUE")) {
			currentValueObj = new Value();
			Map<String, String> attributeMap = new TreeMap<String, String>();
			for (int i = 0; i < attributes.getLength(); i++) {
				attributeMap.put(attributes.getQName(i), attributes.getValue(i));
			}
			currentValueObj.setKeyMap(attributeMap);
			outFlg = true;
		}
	}
	@Override
	public void characters(char[] ch, int offset, int length) {
		super.characters(ch, offset, length);
		metaDataHandler.characters(ch, offset, length);
	}

	public void endElement(String uri, String localName, String qName) {
		super.endElement(uri, localName, qName);
		metaDataHandler.endElement(uri, localName, qName);
		if (qName.equals("STAT_NAME")) {
			statisticalData.setStatName(currentValue);
			outFlg = false;
		} else if (qName.equals("GOV_ORG")) {
			statisticalData.getGovernment().setName(currentValue);
			outFlg = false;
		} else if (qName.equals("STATISTICS_NAME")) {
			statisticalData.setStatisticsName(currentValue);
			outFlg = false;
		} else if (qName.equals("TITLE")) {
			statisticalData.getTitle().setName(currentValue);
			outFlg = false;
		} else if (qName.equals("SURVEY_DATE")) {
			if (!"0".equals(currentValue)) {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				try {
					if (currentValue.contains("-")) {
						String[] dates = currentValue.split("-");
						statisticalData.setSurveyDateFrom(format.parse(dates[0]));
						statisticalData.setSurveyDateTo(format.parse(dates[1]));
					} else {
						statisticalData.setSurveyDateFrom(format.parse(currentValue));
					}
				} catch (Exception e) {
					// Do nothing
				}
			}
			outFlg = false;
		} else if (qName.equals("TOTAL_NUMBER")) {
			statisticalData.setTotalNumber(Long.valueOf(currentValue));
			outFlg = false;
		} else if (qName.equals("FROM_NUMBER")) {
			statisticalData.setFromNumber(Long.valueOf(currentValue));
			outFlg = false;
		} else if (qName.equals("TO_NUMBER")) {
			statisticalData.setToNumber(Long.valueOf(currentValue));
			outFlg = false;
		} else if (qName.equals("NEXT_KEY")) {
			statisticalData.setNextKey(Long.valueOf(currentValue));
			outFlg = false;
		} else if (qName.equals("FROM_NUMBER")) {
			statisticalData.setTotalNumber(Long.valueOf(currentValue));
			outFlg = false;
		} else if (qName.equals("DATA_INF")) {
			statisticalData.setDataInf(currentDataInf);
			currentDataInf = null;
			outFlg = false;
		} else if (qName.equals("NOTE")) {
			currentNote.setValue(currentValue);
			currentDataInf.getNotes().add(currentNote);
			currentNote = null;
		} else if (qName.equals("VALUE")) {
			currentValueObj.setValue(currentValue);
			currentDataInf.getValues().put(currentValueObj.getKey(), currentValueObj);
			currentValueObj = null;
		}
	}
}
