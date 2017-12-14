package mvc.model;

public class Card {
	
	public int value;
	public char color;

	/**
	 * 
	 * @param value of the card. Ace = 1, J = 11, Q = 12, K = 13
	 * @param color Spades = 'S', Club = 'T', Hearts = 'H', Diamonds = 'D'
	 */
	public Card(int value, char color) {
		this.value = value;
		this.color = color;
	}
	
	public boolean isRed() {
		return color == 'D' || color == 'H';
	}

	public boolean isBlack() {
		return color == 'S' || color == 'T';
	}

	/**
	 * Compare an otherCard with this one. Return true if one is black and the other red
	 * @param otherCard card compared to this one
	 * @return true if this one is black and otherCard is red, or the opposit. false otherwise
	 */
	public boolean isOppositColor(Card otherCard) {
		//every Card is either black or red. Which means that they have different colors if this.isRed xor other.isRed
		return this.isRed() ^ otherCard.isRed();
	}
	
	@Override
	public String toString() {
		return "value = " + value + " & color = " + color;
	}

}
