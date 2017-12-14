package mvc.model;

import java.util.Random;

import mvc.model.fields.HelpingDeckField;
import mvc.model.fields.MysteryField;
import mvc.model.fields.ObjectiveField;

public class Game {
	private MysteryField[] mysteryFields;
	
	private ObjectiveField[] objectiveFields;
	
	private HelpingDeckField helpingDeck;
	
	public Game() {
		Pile initialDeck = createRandomDeck();
		
		
		/******* MYSTERY FIELDS ********/
		
		mysteryFields = new MysteryField[7];
		for(int i = 0; i<7 ; i++) 
			mysteryFields[i] = new MysteryField(i+1);
		
		for(int i = 0 ; i<7 ; i++)
			for(int j = 0 ; j<=i ; j++) 
				mysteryFields[i].init(initialDeck);

		
		/****** HELPING DECK ******/
		
		helpingDeck = new HelpingDeckField(initialDeck.size());
		helpingDeck.init(initialDeck);
		
		
		/******* OBJECTIVE FIELDS ******/
		
		objectiveFields = new ObjectiveField[4];
		for(int i = 0 ; i<4 ; i++) 
			objectiveFields[i] = new ObjectiveField();
	}

	private Pile createRandomDeck() {
		Pile orderedDeck = new Pile();
		for(int i = 1; i<=13 ;i++) {
			orderedDeck.push(new Card(i,'S'));
			orderedDeck.push(new Card(i,'C'));
			orderedDeck.push(new Card(i,'D'));
			orderedDeck.push(new Card(i,'H'));
		}

		Pile randomDeck = new Pile();
		
		
		Random random = new Random();
		while(orderedDeck.size()>0) {
			int randomIndex = random.nextInt(orderedDeck.size());
			randomDeck.push(orderedDeck.remove(randomIndex));
		}
		
		return randomDeck;
	}
	
	@Override
	public String toString() {
		String res = "  ObjectiveFields: \n";
		
		for(int i = 0 ; i<objectiveFields.length ; i++) {
			res += (i+1) + objectiveFields[i].toString() + "\n";
		}
		
		
		res += "\n\n  MysteryFields: \n";
			
		for(int i = 0 ; i<mysteryFields.length ; i++) {
			res += (i+1) + "\n" + mysteryFields[i].toString() + "\n";
		}
		
		res += "\n\n  " + helpingDeck.toString() + "\n";

		return res;
	}
}
