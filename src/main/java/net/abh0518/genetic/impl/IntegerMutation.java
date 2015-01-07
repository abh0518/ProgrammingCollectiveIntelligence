package net.abh0518.genetic.impl;

import java.util.Random;

import net.abh0518.genetic.IMutation;

public class IntegerMutation implements IMutation<Integer>{

	Random rand = new Random(System.currentTimeMillis() + IntegerMutation.class.hashCode());
	
	@Override
	public Integer mutate(Integer original) {
		int origin = original;
		int catalyst = rand.nextInt();
		int result = origin ^ catalyst;
		return result;
	}

}
