package org.ukiuni.opendataja4j.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ukiuni.opendataja4j.Result;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ResultDataHandler<T> extends DefaultHandler {
	protected boolean outFlg = false;

	protected Result<T> result;

	public Result<T> getResult() {
		return result;
	}

	protected String currentValue;

	public void endDocument() {
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if (qName.equals("RESULT")) {
			result = new Result<T>();
			outFlg = true;
		}
		if (qName.equals("STATUS")) {
			outFlg = true;
		}
		if (qName.equals("ERROR_MSG")) {
			outFlg = true;
		}
		if (qName.equals("DATE")) {
			outFlg = true;
		}
	}

	public void characters(char[] ch, int offset, int length) {
		if (outFlg) {
			currentValue = new String(ch, offset, length);
		}
	}

	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("STATUS")) {
			result.setStatus(currentValue);
			outFlg = false;
		} else if (qName.equals("ERROR_MSG")) {
			result.setErrorMessage(currentValue);
			outFlg = false;
		} else if (qName.equals("DATE")) {
			try {
				result.setDate(toCalendar(currentValue));
			} catch (ParseException e) {
				// Do nothing
			}
			outFlg = false;
		}
	}

	public static Date toCalendar(final String iso8601string) throws ParseException {
		String s = iso8601string.replace("Z", "+00:00");
		try {
			s = s.substring(0, 22) + s.substring(23);
		} catch (IndexOutOfBoundsException e) {
			throw new ParseException("invalid Format" + iso8601string, 0);
		}
		Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(s);
		return date;
	}
}
