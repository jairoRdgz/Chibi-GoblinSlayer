package exceptions;

public class NoPlayerFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoPlayerFoundException() {
		System.out.println("You havent added a player to the game");
	}

}
