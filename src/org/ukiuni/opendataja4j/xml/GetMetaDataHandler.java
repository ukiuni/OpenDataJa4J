package org.ukiuni.opendataja4j.xml;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.ukiuni.opendataja4j.entity.Government;
import org.ukiuni.opendataja4j.entity.Information;
import org.ukiuni.opendataja4j.entity.InformationHeader;
import org.ukiuni.opendataja4j.entity.MetaData;
import org.ukiuni.opendataja4j.entity.Title;
import org.xml.sax.Attributes;

public class GetMetaDataHandler extends ResultDataHandler<MetaData> {

	private MetaData metaData;
	private InformationHeader currentInformationHeader;
	private Information currentInformation;

	public MetaData getMetaData() {
		return metaData;
	}

	public void endDocument() {
		getResult().setValue(metaData);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("TABLE_INF")) {
			metaData = new MetaData();
			metaData.setInformationHeaderMap(new HashMap<String, InformationHeader>());
			metaData.setId(attributes.getValue("id"));
			outFlg = true;
		}
		if (qName.equals("STAT_NAME")) {
			metaData.setStatCode(attributes.getValue("code"));
			outFlg = true;
		}
		if (qName.equals("GOV_ORG")) {
			metaData.setGovernment(new Government());
			metaData.getGovernment().setCode(attributes.getValue("code"));
			outFlg = true;
		}
		if (qName.equals("STATISTICS_NAME")) {
			outFlg = true;
		}
		if (qName.equals("TITLE")) {
			metaData.setTitle(new Title());
			metaData.getTitle().setNo(attributes.getValue("no"));
			outFlg = true;
		}
		if (qName.equals("CYCLE")) {
			outFlg = true;
		}
		if (qName.equals("SURVEY_DATE")) {
			outFlg = true;
		}
		if (qName.equals("CLASS_OBJ")) {
			currentInformationHeader = new InformationHeader();
			currentInformationHeader.setId(attributes.getValue("id"));
			currentInformationHeader.setName(attributes.getValue("name"));
			currentInformationHeader.setInformationMap(new HashMap<String, Information>());
			outFlg = true;
		}
		if (qName.equals("CLASS")) {
			currentInformation = new Information();
			currentInformation.setCode(attributes.getValue("code"));
			currentInformation.setName(attributes.getValue("name"));
			currentInformation.setLevel(Integer.valueOf(attributes.getValue("level")));
			outFlg = true;
		}
	}

	public void endElement(String uri, String localName, String qName) {
		super.endElement(uri, localName, qName);
		if (qName.equals("STAT_NAME")) {
			metaData.setStatName(currentValue);
			outFlg = false;
		} else if (qName.equals("GOV_ORG")) {
			metaData.getGovernment().setName(currentValue);
			outFlg = false;
		} else if (qName.equals("STATISTICS_NAME")) {
			metaData.setStatisticsName(currentValue);
			outFlg = false;
		} else if (qName.equals("TITLE")) {
			metaData.getTitle().setName(currentValue);
			outFlg = false;
		} else if (qName.equals("SURVEY_DATE")) {
			if (!"0".equals(currentValue)) {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				try {
					if (currentValue.contains("-")) {
						String[] dates = currentValue.split("-");
						metaData.setSurveyDateFrom(format.parse(dates[0]));
						metaData.setSurveyDateTo(format.parse(dates[1]));
					} else {
						metaData.setSurveyDateFrom(format.parse(currentValue));
					}
				} catch (Exception e) {
					// Do nothing
				}
			}
			outFlg = false;
		} else if (qName.equals("CLASS_OBJ")) {
			metaData.getInformationHeaderMap().put(currentInformationHeader.getId(), currentInformationHeader);
			outFlg = false;
		} else if (qName.equals("CLASS")) {
			currentInformationHeader.getInformationMap().put(currentInformation.getCode(), currentInformation);
			outFlg = false;
		}
	}
}
