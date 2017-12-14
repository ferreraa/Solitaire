package mvc.model.fields;


import mvc.model.Pile;

public abstract class AbstractField implements Field {

	
	protected Pile pile;
	protected int initialSize; //number of cards that must be received at the beginning
	
	public AbstractField(int initialSize) {
		this.initialSize = initialSize;
		pile = new Pile();
	}
	

	/**
	 * Deal cards to this field according to the initialSize of the field.
	 * @param cardsToDeal pile of remaining cards to deal.
	 */
	public abstract void init(Pile cardsToDeal);
	
	
	/**
	 * Check the rules allowing or not to push a cardList to this field.
	 * These rules depend on the type of field.
	 * @param cardList stack we want to add to the current pile of cards
	 * @throws BrokenFieldRuleException when the rules aren't respected
	 */
	protected abstract void checkPushingRules(Pile cardList) throws BrokenFieldRuleException;

	
	/**
	 * Check the rules allowing or not to pop a cardList beginning with the given index.
	 * These rules depend on the type of field.
	 * @param beginning index of the cards to pop.
	 * @throws BrokenFieldRuleException when the rules aren't respected
	 */
	protected abstract void checkPopRules(int beginning) throws BrokenFieldRuleException;

	
	
	@Override
	public void push(Pile cardList) throws BrokenFieldRuleException {
		checkPushingRules(cardList);
	

		for(int i = cardList.size() ; i>0 ; i--) {
			this.pile.push(cardList.pop());
		}
	}

	
	@Override
	public Pile pop(int beginning) throws BrokenFieldRuleException {
		checkPopRules(beginning);
			
		
		Pile toPop = new Pile();
		for(int i = beginning ; i>0 ; i--) 
			toPop.push(this.pile.pop());
		
		return toPop;

	}


}
