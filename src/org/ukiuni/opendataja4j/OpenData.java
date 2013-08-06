package org.ukiuni.opendataja4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.ukiuni.opendataja4j.entity.Dataset;
import org.ukiuni.opendataja4j.entity.DatasetInformation;
import org.ukiuni.opendataja4j.entity.MetaData;
import org.ukiuni.opendataja4j.entity.NarrowingCondition;
import org.ukiuni.opendataja4j.entity.Stat;
import org.ukiuni.opendataja4j.entity.StatisticalData;
import org.ukiuni.opendataja4j.xml.GetMetaDataHandler;
import org.ukiuni.opendataja4j.xml.GetStatsDataHandler;
import org.ukiuni.opendataja4j.xml.GetStatsListHandler;
import org.ukiuni.opendataja4j.xml.PostDatasetHandler;
import org.ukiuni.opendataja4j.xml.RefDatasetInfomationHandler;

/**
 * 次世代統計利用システムにアクセスするためのAPIです。
 * 
 * @see http://statdb.nstac.go.jp/wp/wp-content/uploads/2013/06/API-spec.pdf
 * @author ukiuni
 */
public class OpenData {
	private String protocol = "https";
	private String host = "statdb.nstac.go.jp";
	private String appRoot = "/api/1.0b/app";
	private static final String USER_AGENT = "OpenDataJa4J 0.0.001";
	private String appId;
	private int READ_TIMEOUT = 60000;
	private int CONNECTION_TIMEOUT = 10000;
	{
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("opendataja4j");
			try {
				appId = bundle.getString("appId");
			} catch (Throwable e) {
			}
			try {
				READ_TIMEOUT = Integer.parseInt(bundle.getString("readTimeout"));
			} catch (Throwable e) {
			}
			try {
				CONNECTION_TIMEOUT = Integer.parseInt(bundle.getString("connectionTimeout"));
			} catch (Throwable e) {
			}
			try {
				protocol = bundle.getString("protocol");
			} catch (Throwable e) {
			}
			try {
				host = bundle.getString("host");
			} catch (Throwable e) {
			}
			try {
				appRoot = bundle.getString("appRoot");
			} catch (Throwable e) {
			}
		} catch (Throwable e) {
		}
	}

	public OpenData() {
	}

	public OpenData(String appId) {
		this.appId = appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Result<List<Stat>> getStatsList() throws IOException {
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
			attachConfig(connection);
			if (300 <= connection.getResponseCode()) {
				throw new RequestException(connection.getResponseCode(), connection.getErrorStream());
			}
			InputStream in = connection.getInputStream();
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			GetStatsListHandler handler = new GetStatsListHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (RequestException e) {
			throw e;
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public Result<MetaData> getMetaInfo(String statsDataId) throws IOException {
		try {
			String urlString = protocol + "://" + host + appRoot + "/getMetaInfo?appId=" + appId + "&statsDataId=" + statsDataId;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			attachConfig(connection);
			if (300 <= connection.getResponseCode()) {
				throw new RequestException(connection.getResponseCode(), connection.getErrorStream());
			}
			InputStream in = connection.getInputStream();

			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			GetMetaDataHandler handler = new GetMetaDataHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (RequestException e) {
			throw e;
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public Result<NarrowingCondition> postDatset(PostDatasetRequestParameter postDatasetRequestParameter) throws RequestException, IOException {
		try {
			String urlString = protocol + "://" + host + appRoot + "/postDataset";
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			attachConfig(connection);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			OutputStream out = connection.getOutputStream();
			out.write(("appId=" + appId + postDatasetRequestParameter.toParamString()).getBytes());
			out.close();
			if (300 <= connection.getResponseCode()) {
				throw new RequestException(connection.getResponseCode(), connection.getErrorStream());
			}
			InputStream in = connection.getInputStream();
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			PostDatasetHandler handler = new PostDatasetHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (RequestException e) {
			throw e;
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public Result<NarrowingCondition> refDataset(String dataSetId) throws RequestException, IOException {
		try {
			String urlString = protocol + "://" + host + appRoot + "/refDataset?appId=" + appId + "&dataSetId=" + dataSetId;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			attachConfig(connection);
			if (300 <= connection.getResponseCode()) {
				throw new RequestException(connection.getResponseCode(), connection.getErrorStream());
			}
			InputStream in = connection.getInputStream();
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			PostDatasetHandler handler = new PostDatasetHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (RequestException e) {
			throw e;
		} catch (Exception e) {
			throw new IOException(e);
		}
	}

	public Result<List<DatasetInformation>> refDataset() throws RequestException, IOException {
		try {
			String urlString = protocol + "://" + host + appRoot + "/refDataset?appId=" + appId;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			attachConfig(connection);
			if (300 <= connection.getResponseCode()) {
				throw new RequestException(connection.getResponseCode(), connection.getErrorStream());
			}
			InputStream in = connection.getInputStream();
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			SAXParser parser = spfactory.newSAXParser();
			RefDatasetInfomationHandler handler = new RefDatasetInfomationHandler();
			parser.parse(in, handler);
			in.close();
			return handler.getResult();
		} catch (RequestException e) {
			throw e;
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
			attachConfig(connection);
			if (300 <= connection.getResponseCode()) {
				throw new RequestException(connection.getResponseCode(), connection.getErrorStream());
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

	private HttpURLConnection attachConfig(HttpURLConnection connection) {
		connection.setReadTimeout(READ_TIMEOUT);
		connection.setConnectTimeout(CONNECTION_TIMEOUT);
		connection.addRequestProperty("User-Agent", USER_AGENT);
		return connection;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getAppRoot() {
		return appRoot;
	}

	public void setAppRoot(String appRoot) {
		this.appRoot = appRoot;
	}
}
