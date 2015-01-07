package net.abh0518.genetic;

/**
 * 최적값을 평가하는 인터페이스
 * @author abh0518
 *
 * @param <T>
 */
public interface IEvaluator<T> {
	/**
	 * 한 구성원이 최적값에 가까운지 평가한다. 유전자 알고리즘은 평가 결과를 기준으로 엘리트를 선발한다. 평가 점수가 작을수록 최적값에 가깝다.
	 * @param data
	 * @return
	 */
	double evaludate(T data);
}
