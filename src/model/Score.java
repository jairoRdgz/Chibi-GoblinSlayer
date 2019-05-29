package model;

import java.io.Serializable;
/**
 * This class contains the attributes of the score
 * This class implements the interface Comparable and Serializable.
 * This class is organized as a binary tree.
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class Score implements Comparable<Score>, Serializable{
	//---------------------------------------------------------------------
	//ATRIBUTES, RELATIONS
	//---------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private long score;
	private String nick;
	private Score left;
	private Score rigth;
	
	//---------------------------------------------------------------------
	//METHODS
	//---------------------------------------------------------------------
	
	/**
	 * Constructor
	 */
	public Score(long s, String n ){
		this.score = s;
		this.nick = n;
	}

	/**
	 * gets the score
	 */
	public long getScore() {
		return score;
	}

	/**
	 * gets the nickname
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * gets the left part of the binary tree
	 */
	public Score getLeft() {
		return left;
	}

	/**
	 * gets the right part of the binary tree
	 */
	public Score getRigth() {
		return rigth;
	}

	/**
	 * sets the score
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/**
	 * sets the nickname
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**
	 * sets the left part of the binary tree
	 */
	public void setLeft(Score left) {
		this.left = left;
	}
	
	/**
	 * sets the right part of the binary tree
	 */
	public void setRigth(Score rigth) {
		this.rigth = rigth;
	}

	/**
	 * This method is in charge of setting the parameters which this object is going to be compared
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
	
	/**
	 * toString method to get the attributes from the class as a String
	 */
	public String toString() {
		String scores = "";
		
		scores = nick+"\t\t"+score+"\n";
		
		return scores;
	}
	
}
