package net.abh0518.genetic;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import net.abh0518.genetic.impl.Genetic;
import net.abh0518.genetic.impl.IntegerCrossover;
import net.abh0518.genetic.impl.IntegerMutation;
import net.abh0518.genetic.impl.IntegerSampler;
import net.abh0518.genetic.impl.IntegerEvaluator;

import org.junit.Before;
import org.junit.Test;

public class GeneticTest {

	Genetic<Integer> genetic;
	IntegerEvaluator score = new IntegerEvaluator();
	IntegerMutation mutation = new IntegerMutation();
	IntegerCrossover crossover = new IntegerCrossover();
	IntegerSampler sampler = new IntegerSampler();
	@Before
	public void init() throws IOException{
		genetic = new Genetic<Integer>( sampler
		, score
		, mutation
		, crossover);
	}
	
	@Test
	public void samplerTest(){
		//난수 잘 나오는 지나 확인
		System.out.println("*** sampling ***");
		System.out.println(sampler.getSample());
		System.out.println(sampler.getSample());
		System.out.println(sampler.getSample());
		System.out.println(sampler.getSample());
	}

	@Test
	public void evaluatorTest(){
		System.out.println("*** evaluating ***");
		int sample = sampler.getSample();
		System.out.println(sample);
		System.out.println(score.evaludate(sample));
		sample = sampler.getSample();
		System.out.println(sample);
		System.out.println(score.evaludate(sample));
		sample = sampler.getSample();
		System.out.println(sample);
		System.out.println(score.evaludate(sample));
		sample = sampler.getSample();
		System.out.println(sample);
		System.out.println(score.evaludate(sample));
		sample = sampler.getSample();
		System.out.println(sample);
		System.out.println(score.evaludate(sample));
	}
	
	@Test 
	public void mutationTest(){
		System.out.println("*** mutation ***");
		int sample = sampler.getSample();
		System.out.println(Integer.toBinaryString(sample));
		System.out.println(Integer.toBinaryString(mutation.mutate(sample)));
		sample = sampler.getSample();
		System.out.println(Integer.toBinaryString(sample));
		System.out.println(Integer.toBinaryString(mutation.mutate(sample)));
		sample = sampler.getSample();
		System.out.println(Integer.toBinaryString(sample));
		System.out.println(Integer.toBinaryString(mutation.mutate(sample)));
		sample = sampler.getSample();
		System.out.println(Integer.toBinaryString(sample));
		System.out.println(Integer.toBinaryString(mutation.mutate(sample)));
		sample = sampler.getSample();
		System.out.println(Integer.toBinaryString(sample));
		System.out.println(Integer.toBinaryString(mutation.mutate(sample)));
	}
	
	@Test
	public void crossoverTest(){
		int a = 1;
		int b = (int) Math.pow(2, 19);
		int result = crossover.corssever(b, a);
		Assert.assertEquals(a+b, result);
	}
	
	
	@Test 
	public void geneticOptimizeTest(){
		System.out.println("*** genericOptimize ***");
		List<Integer> result = genetic.geneticOptimize(2000, 1000, 0.2f, 0.2f);
		System.out.println();
		System.out.println(result);
	}
	
}
