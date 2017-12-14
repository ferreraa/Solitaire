package mvc.model.fields;

import mvc.model.Pile;

public class HelpingDeckField extends AbstractField {

	private Pile hiddenPile;
	
	public HelpingDeckField(int initialSize) {
		super(initialSize);
		hiddenPile = new Pile();
	}
	
	
	public void draw() {

		if(hiddenPile.size() > 0)
			this.pile.push(hiddenPile.pop());
		
		else {
		
			System.out.println("refill");	
			while(pile.size() > 0)
				hiddenPile.push(this.pile.pop());
		}
		
	}
	
	@Override
	public void init(Pile cardsToDeal) {
		for(int i = initialSize ; i>0 ; i--) 
			hiddenPile.push(cardsToDeal.pop());
	}
	
	
	@Override
	protected void checkPushingRules(Pile cardList) throws BrokenFieldRuleException {
		throw new BrokenFieldRuleException("No cards can be pushed to the helping deck");

	}

	@Override
	protected void checkPopRules(int beginning) throws BrokenFieldRuleException {
		if(beginning != 0)
			throw new BrokenFieldRuleException("Cards from an HelpingDeckField should be poped one by one.");			
	}

	
	@Override
	public String toString() {
		String res = "HelpingDeck:" + "\n    visible: \n" + pile.toString();
		res += "\n    hidden: \n" + hiddenPile.toString();
		
		return res;
	}
}
