package net.abh0518.genetic.impl;

import java.util.Random;

import net.abh0518.genetic.IMutation;

/**
 * 하나의 정수를 변이 시킨다. 
 * @author abh0518
 *
 */
public class IntegerMutation implements IMutation<Integer>{

	Random rand = new Random(System.currentTimeMillis() + IntegerMutation.class.hashCode());
	
	@Override
	public Integer mutate(Integer original) {
		int mutationCount = rand.nextInt(Integer.SIZE/2);
		for(int i = 0 ; i < mutationCount ; i++){
			int catalyst = (int)Math.pow(2, rand.nextInt(31));
			original = original^catalyst; 
		}
		return original;
	}
}
