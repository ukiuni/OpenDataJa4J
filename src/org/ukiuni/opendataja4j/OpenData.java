package org.ukiuni.opendataja4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.ukiuni.opendataja4j.entity.MetaData;
import org.ukiuni.opendataja4j.entity.Stat;
import org.ukiuni.opendataja4j.entity.StatisticalData;
import org.ukiuni.opendataja4j.xml.GetMetaDataHandler;
import org.ukiuni.opendataja4j.xml.GetStatsDataHandler;
import org.ukiuni.opendataja4j.xml.GetStatsListHandler;

public class OpenData {
	private String protocol = "https";
	private String host = "statdb.nstac.go.jp";
	private String appRoot = "/api/1.0b/app";
	private String appId;
	{
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("opendataja4j");
			appId = bundle.getString("appId");
		} catch (Throwable e) {
		}

	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public  Result<List<Stat>> getStatsList() throws IOException {
		return getStatsList(null);
	}

	public Result<List<Stat>> getStatsList(GetStatsListRequestParameter parameters) throws IOException {
		try {
			String parameterString = "";
			if (null != parameters) {
				parameterString = parameters.toParamString();
			}
			String urlString = protocol + "://" + host + appRoot + "/getStatsList?appId=" + appId + parameterString;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			if (300 <= connection.getResponseCode()) {
				throw new IOException("status is " + connection.getResponseCode());
			}
			InputStream in = connection.getInputStream();
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			GetStatsListHandler handler = new GetStatsListHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public Result<MetaData> getMetaInfo(String statsDataId) throws IOException {
		try {
			String urlString = protocol + "://" + host + appRoot + "/getMetaInfo?appId=" + appId + "&statsDataId=" + statsDataId;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			if (300 <= connection.getResponseCode()) {
				throw new IOException("status is " + connection.getResponseCode());
			}
			InputStream in = connection.getInputStream();

			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			GetMetaDataHandler handler = new GetMetaDataHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public Result<StatisticalData> getStatsData(String statsDataId) throws IOException {
		return getStatsData(statsDataId, null);
	}

	public Result<StatisticalData> getStatsData(String statsDataId, GetStatsDataRequestParameter parameters) throws IOException {
		try {
			String parameterString = "";
			if (null != parameters) {
				parameterString = parameters.toParamString();
			}
			String urlString = protocol + "://" + host + appRoot + "/getStatsData?appId=" + appId + "&statsDataId=" + statsDataId + parameterString;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			if (300 <= connection.getResponseCode()) {
				throw new IOException("status is " + connection.getResponseCode());
			}
			InputStream in = connection.getInputStream();

			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			GetStatsDataHandler handler = new GetStatsDataHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
}
