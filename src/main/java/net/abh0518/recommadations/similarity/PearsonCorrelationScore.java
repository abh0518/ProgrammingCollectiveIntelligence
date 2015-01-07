package net.abh0518.recommadations.similarity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 피어슨 상관점수를 사용하여 두 대상간의 유사도를 구하는 클래스 
 * @author abh0518
 *
 */
public class PearsonCorrelationScore implements SimilarityFinder {
	
	private double getPearson(Map<String, Double> dataA, Map<String, Double> dataB) {
		//공통 항목 추출
		Map<String, Integer> si = new HashMap<String, Integer>();
		Set<String> keys = dataA.keySet();
		for (String key : keys) {
			if(dataB.containsKey(key)){
				si.put(key, 1);
			}
		}
		
		//공통항목이 없으면 0 (유사점 없음) 
		double relationSize = si.size();
		if(relationSize == 0 ) { return 0;}
		
		//공통항목에대한 합들을 구한다 
		double sumA = 0 , sumB = 0;
		double sumAPow = 0 , sumBPow = 0;
		double productSum = 0;
		keys = si.keySet();
		for(String key : keys){
			double valueA = dataA.get(key);
			double valueB = dataB.get(key);
			
			//선호도 합
			sumA += valueA;
			sumB += valueB;
			//선호도 제곱의 합
			sumAPow += Math.pow(valueA,2);
			sumBPow += Math.pow(valueB, 2);
			//선호도 곱의 합 
			productSum += (valueA * valueB);
		}
		
		//피어슨 상관계수를 구한다. 
		double num = productSum - (sumA*sumB/relationSize);
		double den = Math.sqrt( (sumAPow - Math.pow(sumA,2)/relationSize) * (sumBPow - Math.pow(sumB,2)/relationSize) );
		if(den==0) { return 0; }
		
		return num/den;	
	}

	@Override
	public double findSimilarity(Map<String, Double> dataA, Map<String, Double> dataB) {
		return this.getPearson(dataA, dataB);
	}
	
	
}
