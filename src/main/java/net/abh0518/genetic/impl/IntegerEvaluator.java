package net.abh0518.genetic.impl;

import net.abh0518.genetic.IEvaluator;

public class IntegerEvaluator implements IEvaluator<Integer>{
	@Override
	public double evaludate(Integer data) {
//		return -new Double(data); // 최대수를 찾기 위한 스코어
		return new Double(Math.abs(data)); // 0 근접한 수를 찾기 위한 스코어
		//return data; // 최소값을 찾기 위한 스코어
	}
}
