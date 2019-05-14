package model;

import java.io.Serializable;

public class Score implements Comparable<Score>, Serializable{
	//---------------------------------------------------------------------
	//ATRIBUTES, RELATIONS
	//---------------------------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long score;
	private String nick;
	private Score left;
	private Score rigth;
	
	//---------------------------------------------------------------------
	//METHODS
	//---------------------------------------------------------------------
	
	/**
	 * 
	 */
	public Score(long s, String n ){
		this.score = s;
		this.nick = n;
	}

	/**
	 * 
	 */
	public long getScore() {
		return score;
	}

	/**
	 * 
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * 
	 */
	public Score getLeft() {
		return left;
	}

	/**
	 * 
	 */
	public Score getRigth() {
		return rigth;
	}

	/**
	 * 
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/**
	 * 
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**
	 * 
	 */
	public void setLeft(Score left) {
		this.left = left;
	}
	
	/**
	 * 
	 */
	public void setRigth(Score rigth) {
		this.rigth = rigth;
	}

	/**
	 * This method is in charge of setting the parameters which this object is going to be comparated
	 * @param o is going to be the object to compare with
	 */
	@Override
	public int compareTo(Score o) {
		int comparator ;
		if(score<o.score) {
			comparator = -1;
		}else if(score>o.score) {
			comparator = 1;
		}else {
			comparator = 0;
		}
		return comparator;
	}
	
	public String toString() {
		String scores = "";
		
		scores = nick+"\t\t"+score+"\n";
		
		return scores;
	}
	
}
