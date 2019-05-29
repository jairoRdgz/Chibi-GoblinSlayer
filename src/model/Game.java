package model;

import java.util.ArrayList;
import java.util.List;
/**
 * This class contains the attributes from the Game
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class Game {
	private Level[] levels;
	private Level level;
	private Score root;
	
	/**
	 * Empty constructor
	 */
	public Game() {
		
	}
	/**
	 * gets the number of enemies
	 * @return
	 */
	public int getEnemiesNumber() {
		return level.getEnemys().length;
	}
	
	/**
	 * gets the level of the game
	 * @return
	 */
	public Level getLevel() {
		return level;
	}
	
	/**
	 * gets the levels
	 * @return
	 */
	public Level[] getLevels() {
		return levels;
	}
	
	/**
	 * sets the levels of the game
	 * @param level
	 */
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
	
	/**
	 * this method sorts the binary tree inOrder
	 * @return
	 */
	public List<Score> inOrderScores() {
		return inOrderScores(root);
	}
	/**
	 * recursive method to to the sorting
	 * @param current
	 * @return
	 */
	private List<Score> inOrderScores(Score current){
		List<Score> l = new ArrayList<Score>();
		if(current!=null) {
			l.addAll(inOrderScores(current.getLeft()));
			l.add(current);
			l.addAll(inOrderScores(current.getRigth()));
		}
		
		return l;
	}
	
	/**
	 * initialize method
	 */
	public void initialize() {
		level = new Level();
	}
}
