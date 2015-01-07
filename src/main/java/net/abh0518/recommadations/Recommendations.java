package net.abh0518.recommadations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.abh0518.recommadations.similarity.SimilarityFinder;

public class Recommendations {

	SimilarityFinder similarityFinder;
	
	public Recommendations(SimilarityFinder similarityFinder){
		this.similarityFinder = similarityFinder;
	}
	
	public List<Score> getTopMatches(Map<String, Map<String,Double>> data,String target, int listSize){
		Map<String, Double> targetData = data.get(target);
		
		List<Score> scoreList = new ArrayList<Score>();
		
		Set<String> keys = data.keySet();
		for(String key : keys){
			if(!key.equals(target)){
				double score = similarityFinder.findSimilarity(targetData, data.get(key));
				scoreList.add(new Score(key, score));
			}
		}
		
		Collections.sort(scoreList, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {
				if(o1.getScore() > o2.getScore()){
					return -1;
				}
				else if(o1.getScore() < o2.getScore()){
					return 1;
				}
				else{
					return 0;
				}
			}
		});
		
		listSize = Math.min(listSize, scoreList.size());
		return scoreList.subList(0, listSize);
	}
	
}
