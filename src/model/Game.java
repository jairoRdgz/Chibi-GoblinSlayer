package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Level[] levels;
	private Level level;
	private Score root;
	
	
	public Game() {
		
	}
	
	public int getEnemiesNumber() {
		return level.getEnemys().length;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public Level[] getLevels() {
		return levels;
	}
	
	public void setLevel(Level[] level) {
		this.levels = level;
	}
	
	/**
	 * this method will add another score to the binaryTree of Scores
	 * @param s the score 
	 * @param n the nickName of the player 
	 */
	public void addScore(long s, String n) {
		Score newScore = new Score(s,n);
		if(root == null) {
			root = newScore;
		}else {
			Score current = root;
			while(current != null) {
				if(current.compareTo(newScore)<0) {
					if(current.getLeft()==null) {
						current.setLeft(newScore);
					}else {
						current = current.getLeft();
					}
				}else if(current.compareTo(newScore)>0) {
					if(current.getRigth()==null) {
						current.setRigth(newScore);
					}else {
						current = current.getRigth();
					}
				}else {
					current = current.getLeft();
				}
			}
		}
	}
	
	public List<Score> inOrderScores() {
		return inOrderScores(root);
	}
	
	private List<Score> inOrderScores(Score current){
		List<Score> l = new ArrayList<Score>();
		if(current!=null) {
			l.addAll(inOrderScores(current.getLeft()));
			l.add(current);
			l.addAll(inOrderScores(current.getRigth()));
		}
		
		return l;
	}
	
	public void initialize() {
		level = new Level();
	}
}
