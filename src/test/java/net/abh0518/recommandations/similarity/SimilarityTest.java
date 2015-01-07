package net.abh0518.recommandations.similarity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import net.abh0518.recommadations.similarity.EuclideanDistanceScore;
import net.abh0518.recommadations.similarity.PearsonCorrelationScore;
import net.abh0518.recommadations.similarity.SimilarityFinder;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Before;
import org.junit.Test;

public class SimilarityTest {
	
	JSONObject data;
	SimilarityFinder sc;
	
	@Before
	public void init() throws IOException{
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("SimilarityTestData.txt");
		String jsonData = IOUtils.toString(is, "utf-8");
		data = (JSONObject)JSONValue.parse(jsonData);
		assertTrue(data != null);
	}
	
	@Test
	public void similarityTest(){
		Map<String, Double> dataA = (Map<String, Double>)data.get("Lisa Rose");
		Map<String, Double> dataB = (Map<String, Double>)data.get("Gene Seymour");
		
		sc = new EuclideanDistanceScore();
		double result = sc.findSimilarity(dataA, dataB);
		assertEquals(0.29429805508554946, result, Double.NaN);
		
		sc = new PearsonCorrelationScore();
		result = sc.findSimilarity(dataA, dataB);
		assertEquals(0.39605901719066977, result, Double.NaN);
	}
	
}
