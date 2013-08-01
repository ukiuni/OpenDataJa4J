package test.org.ukiuni.opendateja4j;

import java.io.IOException;

import org.ukiuni.opendataja4j.GetStatsDataRequestParameter;
import org.ukiuni.opendataja4j.OpenData;
import org.ukiuni.opendataja4j.entity.Stat;
import org.ukiuni.opendataja4j.entity.StatisticalData;

public class TestOpenData {
	public static void main(String[] args) throws IOException {
		GetStatsDataRequestParameter getStatsDataRequestParameter = new GetStatsDataRequestParameter();
		getStatsDataRequestParameter.setStartPosition(100001);
		getStatsDataRequestParameter.setLimit(100);
		StatisticalData statisticalData = new OpenData().getStatsData("0003006590", getStatsDataRequestParameter).getValue();
		System.out.println("from = " + statisticalData.getFromNumber());
		System.out.println("to = " + statisticalData.getToNumber());
		System.out.println("Next = " + statisticalData.getNextKey());
		System.out.println("MetaData = " + statisticalData.getMetaData().getInformationHeaderMap().size());
		System.out.println("DataInf = " + statisticalData.getDataInf().getValues().size());

		System.out.println(new OpenData().getMetaInfo("0003006590").getValue().getInformationHeaderMap().get("cat01").getInformationMap().get("011").getName());
		System.out.println(new OpenData().getMetaInfo("0000100051"));
		for (Stat stat : new OpenData().getStatsList().getValue()) {
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
