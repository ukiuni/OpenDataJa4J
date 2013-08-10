package test.org.ukiuni.opendateja4j;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ukiuni.lighthttpserver.HttpServer;
import org.ukiuni.lighthttpserver.request.Handler;
import org.ukiuni.lighthttpserver.request.Request;
import org.ukiuni.lighthttpserver.response.Response;
import org.ukiuni.lighthttpserver.response.ResponseStaticContentHandler;
import org.ukiuni.opendataja4j.GetStatsDataRequestParameter;
import org.ukiuni.opendataja4j.OpenData;
import org.ukiuni.opendataja4j.PostDatasetRequestParameter;
import org.ukiuni.opendataja4j.RequestException;
import org.ukiuni.opendataja4j.Result;
import org.ukiuni.opendataja4j.entity.DatasetInformation;
import org.ukiuni.opendataja4j.entity.NarrowingCondition;
import org.ukiuni.opendataja4j.entity.Stat;
import org.ukiuni.opendataja4j.entity.StatisticalData;

public class TestOpenData {
	private int testPort = 10090;
	private HttpServer server;

	@Before
	public void initServer() throws IOException {
		server = new HttpServer(testPort);
		server.setHandler(new ResponseStaticContentHandler("../dumpDataDir"));
		server.start();
	}

	@After
	public void tearDown() throws Exception {
		if (null != server) {
			server.stop();
		}
	}

	public OpenData createOpenData() {
		OpenData openData = new OpenData();
		openData.setProtocol("http");
		openData.setHost("localhost:" + testPort);
		return openData;
	}

	@Test
	public void testPostDatset() throws Exception {
		PostDatasetRequestParameter parameter = new PostDatasetRequestParameter();
		parameter.setStatsDataId("0003006590");
		parameter.setDataSetId("00200572-20130803194122");
		parameter.setLvTab("-5");
		Result<NarrowingCondition> result = createOpenData().postDatset(parameter);
		Assert.assertEquals("0", result.getStatus());
		Assert.assertEquals("-5", result.getValue().getLevelTabCondition());
	}

	// @Test //refDataset api has bug.
	public void testRefDatasetOne() throws Exception {
		Result<NarrowingCondition> result = createOpenData().refDataset("0003006590");
		Assert.assertEquals("0", result.getStatus());
		Assert.assertEquals("-5", result.getValue().getLevelTabCondition());
	}

	// @Test //refDataset api has bug.
	public void testRefDatasetList() throws Exception {
		Result<List<DatasetInformation>> result = createOpenData().refDataset();
		Assert.assertEquals("0", result.getStatus());
		Assert.assertEquals("1", result.getValue());
	}

	@Test
	public void testPostDatsetException() throws Exception {
		server.setHandler(new Handler() {
			@Override
			public Response onRequest(Request request) {
				return new Response() {
					@Override
					public void onResponse(OutputStream responseOutputStream) throws Throwable {
						write(responseOutputStream, 402, "application/xml", "<POST_DATASET xsi:noNamespaceSchemaLocation=\"http://statdb.nstac.go.jp/api/1.0b/schema/PostDataSet.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><RESULT><STATUS>500</STATUS><ERROR_MSG>正常に終了しました。</ERROR_MSG><DATE>2013-08-03T19:41:22.520+09:00</DATE></RESULT></POST_DATASET>", "UTF-8");
					}
				};
			}

			@Override
			public void onException(Throwable e) {
				e.printStackTrace();
			}
		});
		PostDatasetRequestParameter parameter = new PostDatasetRequestParameter();
		parameter.setStatsDataId("0003006590");
		try {
			createOpenData().postDatset(parameter);
			throw new AssertionError("exception is not throwed");
		} catch (RequestException e) {
			Assert.assertEquals(402, e.getResponseCode());
			Assert.assertEquals("500", e.getResult().getStatus());
			Assert.assertEquals("正常に終了しました。", e.getResult().getErrorMessage());
		}
	}

	@Test
	public void testStatsData() throws Exception {
		GetStatsDataRequestParameter getStatsDataRequestParameter = new GetStatsDataRequestParameter();
		getStatsDataRequestParameter.setStartPosition(100001);
		getStatsDataRequestParameter.setLimit(100);
		StatisticalData statisticalData = createOpenData().getStatsData("0003006590", getStatsDataRequestParameter).getValue();
		Assert.assertEquals(1, statisticalData.getFromNumber());
		Assert.assertEquals(100000, statisticalData.getToNumber());
		Assert.assertEquals(100001, statisticalData.getNextKey());
		Assert.assertEquals(7, statisticalData.getMetaData().getInformationHeaderMap().size());
		Assert.assertEquals(100000, statisticalData.getDataInf().getValues().size());
	}

	@Test
	public void testMetaInfo() throws Exception {
		Assert.assertEquals("99%点", createOpenData().getMetaInfo("0003006590").getValue().getInformationHeaderMap().get("cat01").getInformationMap().get("011").getName());
		if (true) {
			return;
		}
		for (Stat stat : createOpenData().getStatsList().getValue()) {
			System.out.println("*********************");
			System.out.println("code = " + stat.getCode());
			System.out.println("sycle = " + stat.getCycle());
			System.out.println("id = " + stat.getId());
			System.out.println("name = " + stat.getName());
			System.out.println("small area = " + stat.getSmallArea());
			System.out.println("statistics = " + stat.getStatisticsName());
			System.out.println("g code = " + stat.getGovernment().getCode());
			System.out.println("g name = " + stat.getGovernment().getName());
			System.out.println("opendate = " + stat.getOpenDate());
			System.out.println("survey from = " + stat.getSurveyDateFrom());
			System.out.println("survey to = " + stat.getSurveyDateTo());
			System.out.println("title no = " + stat.getTitle().getNo());
			System.out.println("title name = " + stat.getTitle().getName());
			System.out.println("*********************");
		}
	}
}
