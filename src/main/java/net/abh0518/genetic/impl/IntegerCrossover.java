package net.abh0518.genetic.impl;

import net.abh0518.genetic.ICrossover;

/**
 * 두 정수를 교차(교배) 한다.
 * @author abh0518
 *
 */
public class IntegerCrossover implements ICrossover<Integer> {
	@Override
	public Integer corssever(Integer parentA, Integer parentB) {
		int shiftSize = Integer.SIZE/2;
		int childHead = parentA >>> shiftSize;
		childHead = childHead << shiftSize;
		int childBody = parentB << shiftSize;
		childBody = childBody >>> shiftSize;
		return childHead | childBody;
	}
}
