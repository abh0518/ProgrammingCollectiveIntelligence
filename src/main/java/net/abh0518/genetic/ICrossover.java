package net.abh0518.genetic;

/**
 * 교배 인터페이스
 * @author abh0518
 *
 * @param <T>
 */
public interface ICrossover<T> {
	/**
	 * 두 구성원을 교배하여 새로운 자손을 만든다.
	 * @param parentA
	 * @param parentB
	 * @return
	 */
	T corssever(T parentA, T parentB);
}
