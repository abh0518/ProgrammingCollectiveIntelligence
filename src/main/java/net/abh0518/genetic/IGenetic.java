package net.abh0518.genetic;

import java.util.List;

/**
 * 유전자 알고리즘 인터페이스 
 * @author abh0518
 *
 * @param <T>
 */
public interface IGenetic<T> {
	/**
	 * 유전자 알고리즘으로 근사 최적값을 구한다
	 * @param genSize 한 세대의 총 구성원 수, genSize만큼 한 세대의 구성원을 샘플링 한다. 
	 * @param maxLoop 세대 교체를 반복할 횟수
	 * @param eliteRate 한 세대에서 추출할 엘리트의 비율, 0.1이나 0.2 등으로 백분율을 소수로 표현 한다.
	 * @param mutationProb 돌연변이가 발생할 확률, 0.1이나 0.2 등으로 백분율 소수로 표현 한다.
	 * @return
	 */
	List<T> geneticOptimize(int genSize, int maxLoop, double eliteRate, double mutationProb);
}
