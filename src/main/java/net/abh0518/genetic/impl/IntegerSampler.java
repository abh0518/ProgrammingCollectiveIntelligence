package net.abh0518.genetic.impl;

import java.util.Random;

import net.abh0518.genetic.ISampler;

public class IntegerSampler implements ISampler<Integer>{
	
	Random rand = new Random(System.currentTimeMillis() + IntegerSampler.class.hashCode());
	
	@Override
	public Integer getSample() {
		return rand.nextInt();
	}
}
