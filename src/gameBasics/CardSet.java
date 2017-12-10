package gameBasics;

import cards.Card;

public class CardSet {
	private Card[] cards;
	int maxCards;
	boolean canBeModified = false;
	int currIndex = 0;
	
	public CardSet(Card...cards) {
		this.cards = cards;
		maxCards = cards.length;
	}
	public CardSet(boolean canBeModified, Card...cards) {
		this(cards);
		this.canBeModified = canBeModified;
		if (canBeModified)
			maxCards = -1;
	}
	public CardSet(int numCards) {
		cards = new Card[numCards];
		maxCards = cards.length;
		
	}
	public CardSet(boolean canBeModified, int numCards) {
		this(numCards);
		this.canBeModified = canBeModified;
		if (canBeModified)
			maxCards = -1;
		
	}
	public Card getCard(int i) {
		return cards[i];
	}
	public Card setCard(Card c, int i) {
		Card x = cards[i];
		cards[i] =c;
		return x;
	}
	public void addCard(Card c) {
		if (currIndex+1 > cards.length && canBeModified){
			copyCards(currIndex+1);
			
		}
		cards[currIndex] = c;
		currIndex++;
	}
	private void copyCards(int newLength) {
		Card[] copy = new Card[newLength];
		for (int i = 0; i < cards.length; i++) {
			copy[i] = cards[i];
		}
		cards = copy;
	}
	
}
