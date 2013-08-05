package test.org.ukiuni.opendateja4j;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;

import org.ukiuni.lighthttpserver.util.StreamUtil;

public class RequestAndDumpFileUtil {
	static File baseDir = new File("dumpDataDir");

	public static void main(String[] args) throws Exception {
		requestAndDump("/api/1.0b/app/refDataset", "?appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId") + "&dataSetId=" + URLEncoder.encode("00200572-20130803194122"));
		requestAndDump("/api/1.0b/app/refDataset", "?appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId"));
		if (true) {
			return;
		}
		requestLocalPostAndDump("/api/1.0b/app/postDataset", "appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId") + "&dataSetId=" + URLEncoder.encode("00200572-20130803194122") + "&statsDataId=0003006590&lvTab=" + URLEncoder.encode("-5"));
		requestPostAndDump("/api/1.0b/app/postDataset", "appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId") + "&dataSetId=" + URLEncoder.encode("00200572-20130803194122") + "&statsDataId=0003006590&lvTab=" + URLEncoder.encode("-5"));
		requestAndDump("/api/1.0b/app/getStatsList", "?appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId"));
		requestAndDump("/api/1.0b/app/getMetaInfo", "?appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId") + "&statsDataId=0003006590");
		requestAndDump("/api/1.0b/app/getStatsData", "?appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId") + "&statsDataId=0003006590");
		requestAndDump("/api/1.0b/app/getStatsList", "?appId=" + ResourceBundle.getBundle("opendataja4j").getString("appId"));
	}

	public static void requestAndDump(String uri, String appendParam) throws Exception {
		String urlString = "https://statdb.nstac.go.jp" + uri + appendParam;
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		File outputData = new File(baseDir, uri);
		outputData.getParentFile().mkdirs();
		InputStream in = connection.getInputStream();
		OutputStream out = new FileOutputStream(outputData);
		StreamUtil.copy(in, out);
		StreamUtil.closeQuietry(in);
		StreamUtil.closeQuietry(out);
	}

	public static void requestPostAndDump(String uri, String appendParam) throws Exception {
		String urlString = "https://statdb.nstac.go.jp" + uri;
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		OutputStream out = connection.getOutputStream();
		out.write((appendParam + "\r\n").getBytes("UTF-8"));
		out.close();
		File outputData = new File(baseDir, uri);
		outputData.getParentFile().mkdirs();
		InputStream in = connection.getInputStream();
		OutputStream fout = new FileOutputStream(outputData);
		StreamUtil.copy(in, fout);
		StreamUtil.closeQuietry(in);
		StreamUtil.closeQuietry(fout);
	}

	public static void requestLocalPostAndDump(String uri, String appendParam) throws Exception {
		String urlString = "https://localhost:10090" + uri;
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		OutputStream out = connection.getOutputStream();
		out.write((appendParam + "\r\n").getBytes("UTF-8"));
		out.close();
		File outputData = new File(baseDir, uri);
		outputData.getParentFile().mkdirs();
		InputStream in = connection.getInputStream();
		ByteArrayOutputStream fout = new ByteArrayOutputStream();
		StreamUtil.copy(in, fout);
		StreamUtil.closeQuietry(in);
		StreamUtil.closeQuietry(fout);
		System.out.println("value = " + new String(fout.toByteArray()));
	}
}
