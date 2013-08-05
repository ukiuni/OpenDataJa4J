package org.ukiuni.opendataja4j;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.ukiuni.opendataja4j.xml.ResultDataHandler;

@SuppressWarnings("serial")
public class RequestException extends IOException {

	private int responseCode;
	private Result<Void> result;

	public RequestException() {
		super();
	}

	public RequestException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RequestException(String arg0) {
		super(arg0);
	}

	public RequestException(Throwable arg0) {
		super(arg0);
	}

	public RequestException(int responseCode, InputStream in) throws IOException {
		this.responseCode = responseCode;
		this.parseError(in);
	}

	public void parseError(InputStream in) throws IOException {
		SAXParserFactory spfactory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = spfactory.newSAXParser();
			ResultDataHandler<Void> handler = new ResultDataHandler<Void>();
			parser.parse(in, handler);
			in.close();
			this.result = handler.getResult();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Result<Void> getResult() {
		return result;
	}
}
