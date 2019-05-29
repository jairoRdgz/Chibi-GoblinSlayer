package exceptions;
/**
 * Custom exception when a player cannot be found
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class NoPlayerFoundException extends Exception{

	
	private static final long serialVersionUID = 1L;
	/**
	 * This method shows a message when the exception jumps
	 */
	public NoPlayerFoundException() {
		System.out.println("You havent added a player to the game");
	}

}
