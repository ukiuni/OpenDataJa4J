package org.ukiuni.opendataja4j.xml;

import org.ukiuni.opendataja4j.entity.NarrowingCondition;
import org.xml.sax.Attributes;

public class PostDatasetHandler extends ResultDataHandler<NarrowingCondition> {

	private NarrowingCondition narrowingCondition;

	public void startDocument() {
	}

	public void endDocument() {
		getResult().setValue(narrowingCondition);
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("NARROWING_COND")) {
			narrowingCondition = new NarrowingCondition();
			outFlg = true;
		} else if (qName.equals("LEVEL_TAB_COND")) {
			outFlg = true;
		} else if (qName.equals("CODE_TAB_SELECT")) {
			outFlg = true;
		} else if (qName.equals("CODE_TAB_FROM")) {
			outFlg = true;
		} else if (qName.equals("CODE_TAB_TO")) {
			outFlg = true;
		} else if (qName.equals("LEVEL_TIME_COND")) {
			outFlg = true;
		} else if (qName.equals("CODE_TIME_SELECT")) {
			outFlg = true;
		} else if (qName.equals("CODE_TIME_FROM")) {
			outFlg = true;
		} else if (qName.equals("CODE_TIME_TO")) {
			outFlg = true;
		} else if (qName.equals("LEVEL_AREA_COND")) {
			outFlg = true;
		} else if (qName.equals("CODE_AREA_SELECT")) {
			outFlg = true;
		} else if (qName.equals("CODE_AREA_FROM")) {
			outFlg = true;
		} else if (qName.equals("CODE_AREA_TO")) {
			outFlg = true;
		} else if (qName.startsWith("LEVEL_CAT")) {
			if (null == narrowingCondition.getLevelCondition()) {
				narrowingCondition.setLevelCondition(new String[15]);
			}
			outFlg = true;
		} else if (qName.startsWith("CODE_CAT")) {
			if (qName.endsWith("_SELECT")) {
				if (null == narrowingCondition.getCodeSelect()) {
					narrowingCondition.setCodeSelect(new String[15]);
				}
			} else if (qName.endsWith("_FROM")) {
				if (null == narrowingCondition.getCodeFrom()) {
					narrowingCondition.setCodeFrom(new String[15]);
				}
			} else if (qName.endsWith("_TO")) {
				if (null == narrowingCondition.getCodeTo()) {
					narrowingCondition.setCodeTo(new String[15]);
				}
			}
			outFlg = true;
		}
	}

	public void endElement(String uri, String localName, String qName) {
		super.endElement(uri, localName, qName);
		if (qName.equals("NARROWING_COND")) {
			outFlg = false;
		} else if (qName.equals("LEVEL_TAB_COND")) {
			narrowingCondition.setLevelTabCondition(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_TAB_SELECT")) {
			narrowingCondition.setCodeTabSelect(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_TAB_FROM")) {
			narrowingCondition.setCodeTabFrom(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_TAB_TO")) {
			narrowingCondition.setCodeTabTo(currentValue);
			outFlg = false;
		} else if (qName.equals("LEVEL_TIME_COND")) {
			narrowingCondition.setLevelTimeCondition(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_TIME_SELECT")) {
			narrowingCondition.setCodeTimeSelect(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_TIME_FROM")) {
			narrowingCondition.setCodeTimeFrom(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_TIME_TO")) {
			narrowingCondition.setCodeTimeTo(currentValue);
			outFlg = false;
		} else if (qName.equals("LEVEL_AREA_COND")) {
			narrowingCondition.setLevelAreaCondition(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_AREA_SELECT")) {
			narrowingCondition.setCodeAreaSelect(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_AREA_FROM")) {
			narrowingCondition.setCodeAreaFrom(currentValue);
			outFlg = false;
		} else if (qName.equals("CODE_AREA_TO")) {
			narrowingCondition.setCodeAreaTo(currentValue);
			outFlg = false;
		} else if (qName.startsWith("LEVEL_CAT")) {
			String indexString = qName.substring("LEVEL_CAT".length(), "LEVEL_CAT".length() + 2);
			int index = Integer.parseInt(indexString);
			if (indexString.startsWith("0")) {
				indexString = indexString.substring(1, indexString.length());
			}
			narrowingCondition.getLevelCondition()[index - 1] = currentValue;
			outFlg = false;
		} else if (qName.startsWith("CODE_CAT")) {
			String indexString = qName.substring("CODE_CAT".length(), "CODE_CAT".length() + 2);
			if (indexString.startsWith("0")) {
				indexString = indexString.substring(1, indexString.length());
			}
			int index = Integer.parseInt(indexString);
			if (qName.endsWith("_SELECT")) {
				narrowingCondition.getCodeSelect()[index - 1] = currentValue;
			} else if (qName.endsWith("_FROM")) {
				narrowingCondition.getCodeFrom()[index - 1] = currentValue;
			} else if (qName.endsWith("_TO")) {
				narrowingCondition.getCodeTo()[index - 1] = currentValue;
			}
			outFlg = false;
		}
	}
}
