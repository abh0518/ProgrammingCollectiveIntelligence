package net.abh0518.genetic.impl;

import java.util.Random;

import net.abh0518.genetic.ISampler;

/**
 * 하나의 정수를 랜덤으로 채집한다.
 * @author abh0518
 *
 */
public class IntegerSampler implements ISampler<Integer>{
	
	Random rand = new Random(System.currentTimeMillis() + IntegerSampler.class.hashCode());
	
	@Override
	public Integer getSample() {
		return rand.nextInt();
	}
}
