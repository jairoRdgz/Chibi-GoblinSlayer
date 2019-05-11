package model;

public class Game {
	private Level[] levels;
	private Score root;
	
	public Game() {
		
	}
	
	public Level[] getLevel() {
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
}
