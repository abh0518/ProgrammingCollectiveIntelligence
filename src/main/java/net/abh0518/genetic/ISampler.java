package net.abh0518.genetic;

/**
 * 구성원 하나를 샘플링 하는 인터페이스
 * @author abh0518
 *
 * @param <T>
 */
public interface ISampler<T> {
	/**
	 * 구성원 하나를 샘플링 한다.
	 * @return
	 */
	T getSample();
}
