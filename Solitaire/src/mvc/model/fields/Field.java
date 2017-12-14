package mvc.model.fields;

import mvc.model.Pile;

public interface Field {
	
	/**
	 * Push the given Stack of cards
	 * @param cardList
	 * @throws BrokenFieldRuleException raised if the pushing rules aren't respected. In this case, nothing is pushed
	 */	
	public void push(Pile cardList) throws BrokenFieldRuleException; 
	
	/**
	 * 
	 * create a list of cards going from the index beginning to the first element of the Stack.
	 * We destack the pile of cards, creating another stack (the result) in reversed order.
	 * This way when we will use the push method on another field,
	 * it will destack this result and thus put them back in the good order
	 * @param beginning index of the first element of t
	 * @return Stack which first element is the one we could previously find at the index beginnig
	 * and the last is the previous first element.
	 * @throws BrokenFieldRuleException raised if the poping rules aren't respected. In this case, nothing is poped
	 * this exception should be the result of a bug.
	 */
	public Pile pop(int beginning) throws BrokenFieldRuleException;
	
}
