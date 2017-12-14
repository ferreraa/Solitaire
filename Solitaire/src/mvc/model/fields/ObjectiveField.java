package mvc.model.fields;

import java.util.EmptyStackException;

import mvc.model.Card;
import mvc.model.Pile;

public class ObjectiveField extends AbstractField{

	
	public ObjectiveField() {
		super(0);
	}

	@Override
	public void checkPushingRules(Pile cardList) throws BrokenFieldRuleException {
		if(cardList.size() != 1)
			throw new BrokenFieldRuleException("0 or more than 1 card are being pushed to the Objective field. This is not allowed.");
		
		Card newCard = cardList.peek();
		
		Card currentTopCard;
		try {
			currentTopCard = this.pile.peek();
		}
		catch(EmptyStackException e) {
			if(newCard.value > 1)
				throw new BrokenFieldRuleException("Can't add a card of value > 1 to a blank ObjectiveField");
			
			return; //We don't care about the current top card's color or value if the Stack is currently empty
		}
		
		if(currentTopCard.color != newCard.color)
			throw new BrokenFieldRuleException("Only cards of same colored can be pushed to ObjectiveField pile of card");
		
		if(currentTopCard.value+1 != newCard.value)
			throw new BrokenFieldRuleException("The value of the card to push must be the current+1 in an ObjectiveField");
		
	}
	


	@Override
	protected void checkPopRules(int beginning) throws BrokenFieldRuleException {
		if(beginning != 0)
			throw new BrokenFieldRuleException("Cards from an objective field should be poped one by one.");			
	}

	@Override
	public void init(Pile cardsToDeal) {
		//At the beginning, this field should be empty.
		
		System.out.println("Objective field initialized");
		return;
	}
	
	@Override
	public String toString() {
		String res = "ObjectiveField: " + "\n    visible: \n" + pile.toString();
		
		return res;
	}

}
