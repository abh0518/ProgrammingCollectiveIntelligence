package net.abh0518.genetic.impl;

import net.abh0518.genetic.IEvaluator;

/**
 * 주어진 정수의 최적상태를 평가한다.
 * @author abh0518
 *
 */
public class IntegerEvaluator implements IEvaluator<Integer>{
	@Override
	public double evaludate(Integer data) {
//		return -new Double(data); // 최대수를 찾기 위한 스코어
		return Math.abs(data); // 0 근접한 수를 찾기 위한 스코어
		//return data; // 최소값을 찾기 위한 스코어
	}
}
