package mvc.model.fields;

import java.util.EmptyStackException;

import mvc.model.Card;
import mvc.model.Pile;

public class MysteryField extends AbstractField {

	private Pile hiddenPile;
	
	public MysteryField(int initialSize) {
		super(initialSize);
		hiddenPile = new Pile();
	}
	
	@Override
	public void init(Pile cardsToDeal) {
		if(hiddenPile.size() < initialSize -1)
			hiddenPile.push(cardsToDeal.pop());
		else
			this.pile.push(cardsToDeal.pop());
	}

	@Override
	protected void checkPushingRules(Pile cardList) throws BrokenFieldRuleException {
		Card newGreatestCard = cardList.peek();
		
		Card currentTopCard = null;
		
		try {
			currentTopCard = this.pile.peek();
		} catch(EmptyStackException e) {
			if( cardList.peek().value != 13 )
				throw new BrokenFieldRuleException("Only a king can be pushed to an empty MysteryField");

			return;
		}
		
		if( !currentTopCard.isOppositColor(newGreatestCard) )
			throw new BrokenFieldRuleException("To push a new Card, the colors must be different");
		
		if( currentTopCard.value -1 != newGreatestCard.value )
			throw new BrokenFieldRuleException("Only a new Card which value is lower to the current one by 1 can be pushed");

	}

	@Override
	protected void checkPopRules(int beginning) throws BrokenFieldRuleException {
		if(beginning > this.pile.size())
			throw new BrokenFieldRuleException("This shouldn't be happening. The program tries to pop more cards than the number of visible ones.");

		
	}
	
	@Override
	public String toString() {
		String res = "MysteryField:" + "\n    visible: \n" + pile.toString();
		res += "\n    hidden: \n" + hiddenPile.toString();
		
		return res;
	}


}
