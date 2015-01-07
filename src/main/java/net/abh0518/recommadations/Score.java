package net.abh0518.recommadations;

public class Score {
	
	double score;
	String name;
	
	public Score(String name, double score){
		this.name = name;
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return name + " : " + score;
	}
}
