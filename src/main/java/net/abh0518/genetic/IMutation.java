package net.abh0518.genetic;

/**
 * 돌연변이 발생 인터페이스 
 * @author abh0518
 *
 * @param <T>
 */
public interface IMutation<T> {
	/**
	 * 구성원 하나로부터 돌연변이를 발생시킨다.
	 * @param original
	 * @return
	 */
	T mutate(T original);
}
