package net.abh0518.recommandations;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import net.abh0518.recommadations.Recommendations;
import net.abh0518.recommadations.Score;
import net.abh0518.recommadations.similarity.EuclideanDistanceScore;
import net.abh0518.recommadations.similarity.PearsonCorrelationScore;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Before;
import org.junit.Test;

public class RecommendationTest {
	
	JSONObject data;
	
	@Before
	public void init() throws IOException{
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("SimilarityTestData.txt");
		String jsonData = IOUtils.toString(is, "utf-8");
		data = (JSONObject)JSONValue.parse(jsonData);
		assertTrue(data != null);
	}
	
	@Test
	public void getTopMatchesByPearsonTest(){
		Recommendations recommendations = new Recommendations(new PearsonCorrelationScore());
		Map<String,Map<String,Double>> mapData = (Map<String,Map<String,Double>>)data;
		List<Score> scores = recommendations.getTopMatches(data, "Toby", 3);
		assertTrue("[Lisa Rose : 0.9912407071619299, Mick LaSalle : 0.9244734516419049, Claudia Puig : 0.8934051474415647]".equals(scores.toString()));
		scores = recommendations.getTopMatches(data, "Toby", 100000000);
	}

	@Test
	public void getTopMatchesByEuclideanTest(){
		Recommendations recommendations = new Recommendations(new EuclideanDistanceScore());
		Map<String,Map<String,Double>> mapData = (Map<String,Map<String,Double>>)data;
		List<Score> scores = recommendations.getTopMatches(data, "Toby", 3);
		assertTrue("[Mick LaSalle : 0.4, Michael Phillips : 0.38742588672279304, Claudia Puig : 0.3567891723253309]".equals(scores.toString()));
		scores = recommendations.getTopMatches(data, "Toby", 100000000);
	}
	
}
