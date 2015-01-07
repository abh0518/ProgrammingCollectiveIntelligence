package net.abh0518.recommadations.similarity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 유클리디안 거리점수를 사용하여 두 데이터간의 유사도를 구하는 클래스
 * @author abh0518
 *
 */
public class EuclideanDistanceScore implements SimilarityFinder {
	
	/**
	 * 두 타겟간의 유클리디안 거리점수를 구한다.결과는 0~1 사이 값을 가지며 유사할수록 1에 가까워 진다.
	 * @param dataA
	 * @param dataB
	 * @return
	 */
	private double getDistance(Map<String, Double> dataA, Map<String, Double> dataB) {
		//공통 항목 추출
		Map<String, Integer> si = new HashMap<String, Integer>();
		Set<String> keys = dataA.keySet();
		for (String key : keys) {
			if(dataB.containsKey(key)){
				si.put(key, 1);
			}
		}
		
		//공통항목이 없으면 0 (유사점 없음) 
		if(si.size() == 0 ) { return 0;}
		
		//유사 거리를 구한다. 
		double sumOfSquares = 0;
		keys = si.keySet();
		for(String key : keys){
			sumOfSquares += Math.pow( dataA.get(key) - dataB.get(key) , 2);
		}
		
		return 1/(1+Math.sqrt(sumOfSquares));
	}
	
	@Override
	public double findSimilarity(Map<String, Double> dataA, Map<String, Double> dataB) {
		return this.getDistance(dataA, dataB);
	}
	
	
}
