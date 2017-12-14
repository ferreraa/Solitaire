package mvc.model;

import java.util.Stack;

/**
 * 
 * @author alexandre
 *	Pile of cards. FILO.
 *  Supposedly visible cards.
 */
public class Pile extends Stack<Card> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		String res = "pile: \n";
		
		for(Card c : this) {
			res += c.toString() + "\n";
		}
		
		return res;
	}
}
