package net.abh0518.recommadations.similarity;

import java.util.Map;

/**
 * 두 데이터 집단간 유사도를 구하는 인터페이스
 * @author abh0518
 *
 */
public interface SimilarityFinder {
	double findSimilarity(Map<String, Double> dataA, Map<String, Double> dataB);
}
