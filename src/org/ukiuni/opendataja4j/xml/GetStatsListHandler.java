package org.ukiuni.opendataja4j.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.ukiuni.opendataja4j.entity.Government;
import org.ukiuni.opendataja4j.entity.Stat;
import org.ukiuni.opendataja4j.entity.Title;
import org.xml.sax.Attributes;

public class GetStatsListHandler extends ResultDataHandler<List<Stat>> {
	private List<Stat> stats;

	private Stat currentStat;

	public List<Stat> getStats() {
		return stats;
	}

	public void startDocument() {
		stats = new ArrayList<Stat>();
	}

	public void endDocument() {
		getResult().setValue(stats);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("LIST_INF")) {
			currentStat = new Stat();
			currentStat.setId(attributes.getValue("id"));
			outFlg = true;
		} else if (qName.equals("STAT_NAME")) {
			currentStat.setCode(attributes.getValue("code"));
			outFlg = true;
		} else if (qName.equals("GOV_ORG")) {
			currentStat.setGovernment(new Government());
			currentStat.getGovernment().setCode(attributes.getValue("code"));
			outFlg = true;
		} else if (qName.equals("STATISTICS_NAME")) {
			outFlg = true;
		} else if (qName.equals("TITLE")) {
			currentStat.setTitle(new Title());
			currentStat.getTitle().setNo(attributes.getValue("no"));
			outFlg = true;
		} else if (qName.equals("CYCLE")) {
			outFlg = true;
		} else if (qName.equals("SURVEY_DATE")) {
			outFlg = true;
		} else if (qName.equals("OPEN_DATE")) {
			outFlg = true;
		} else if (qName.equals("SMALL_AREA")) {
			outFlg = true;
		}
	}

	public void endElement(String uri, String localName, String qName) {
		super.endElement(uri, localName, qName);
		if (qName.equals("STAT_NAME")) {
			currentStat.setName(currentValue);
			outFlg = false;
		} else if (qName.equals("GOV_ORG")) {
			currentStat.getGovernment().setName(currentValue);
			outFlg = false;
		} else if (qName.equals("STATISTICS_NAME")) {
			currentStat.setStatisticsName(currentValue);
			outFlg = false;
		} else if (qName.equals("TITLE")) {
			currentStat.getTitle().setName(currentValue);
			outFlg = false;
		} else if (qName.equals("CYCLE")) {
			currentStat.setCycle(currentValue);
			outFlg = false;
		} else if (qName.equals("SURVEY_DATE")) {
			if (!"0".equals(currentValue)) {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				try {
					if (currentValue.contains("-")) {
						String[] dates = currentValue.split("-");
						currentStat.setSurveyDateFrom(format.parse(dates[0]));
						currentStat.setSurveyDateTo(format.parse(dates[1]));
					} else {
						currentStat.setSurveyDateFrom(format.parse(currentValue));
					}
				} catch (Exception e) {
					// Do nothing
				}
			}
			outFlg = false;
		} else if (qName.equals("OPEN_DATE")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				currentStat.setOpenDate(format.parse(currentValue));
			} catch (ParseException e) {
				// Do nothing
			}
			outFlg = false;
		} else if (qName.equals("SMALL_AREA")) {
			currentStat.setSmallArea(currentValue);
			outFlg = false;
		} else if (qName.equals("LIST_INF")) {
			stats.add(currentStat);
			outFlg = false;
		}
	}
}
