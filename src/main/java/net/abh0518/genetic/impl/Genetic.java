package net.abh0518.genetic.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import net.abh0518.genetic.ICrossover;
import net.abh0518.genetic.IGenetic;
import net.abh0518.genetic.IMutation;
import net.abh0518.genetic.ISampler;
import net.abh0518.genetic.IEvaluator;


public class Genetic<T> implements IGenetic<T> {
	Random rand = new Random(System.currentTimeMillis() + this.hashCode());
	
	ICrossover<T> crossover;
	IMutation<T> mutation;
	IEvaluator<T> evaluator;
	ISampler<T> sampler;
	
	public Genetic(ISampler<T> sampler, IEvaluator<T> evaluator, IMutation<T> mutation, ICrossover<T> crossover){
		this.evaluator = evaluator;
		this.sampler = sampler;
		this.mutation = mutation;
		this.crossover = crossover;
	}
	
	private List<T> evolveGeneration(List<T> generation, double eliteRate, double mutationProb){
		this.sortByScore(generation);
		int genSize = generation.size();
		
		//엘리트 세대는 남겨둔다 (뭔가 슬프다)
		int eliteCount = (int)(genSize * eliteRate);
		
		rand.nextDouble();
		
		int prob = (int)(mutationProb*100);
		for(int i = eliteCount ; i < genSize; i++){
			boolean isMutation = rand.nextInt(101) < prob? true : false;
			if(isMutation){
				//돌연변이 생성
				int mutationIndex = rand.nextInt(eliteCount);
				T mutation = this.mutation.mutate(generation.get(mutationIndex));
				generation.set(i, mutation);
			}
			else{
				//교배
				int parentA = rand.nextInt(eliteCount);
				int parentB = rand.nextInt(eliteCount);
				T child = this.crossover.corssever(generation.get(parentA), generation.get(parentB));
				generation.set(i, child);
			}
		}
		return generation;
	}
	
	public List<T> geneticOptimize(int genSize, int maxLoop, double eliteRate, double mutationProb){
		List<T> generation = new ArrayList<T>();
		for(int i = 0 ; i < genSize ; i++){
			generation.add(sampler.getSample());
		}
		
		for(int i = 0 ; i < maxLoop; i++){
			generation = evolveGeneration(generation, eliteRate, mutationProb);
		}
		
		sortByScore(generation);
		return generation;
	}
	
	private void sortByScore(List<T> generation){
		Collections.sort(generation, new Comparator<T>(){
			@Override
			public int compare(T memberA, T memberB) {
				double result = evaluator.evaludate(memberA) - evaluator.evaludate(memberB); 
				if(result > 0 ) return 1;
				if(result < 0 ) return -1;
				return 0;
			}
		});
	}

	public ICrossover<T> getCrossover() {
		return crossover;
	}

	public void setCrossover(ICrossover<T> crossover) {
		this.crossover = crossover;
	}

	public IMutation<T> getMutation() {
		return mutation;
	}

	public void setMutation(IMutation<T> mutation) {
		this.mutation = mutation;
	}

	public IEvaluator<T> getScore() {
		return evaluator;
	}

	public void setEvaluator(IEvaluator<T> evaluator) {
		this.evaluator = evaluator;
	}
}
