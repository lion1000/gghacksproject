package gameBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cards.Card;

public class CardSet {
	private Card[] cards;
	
	boolean canBeModified = false;
	int numCards = 0;
	public CardSet(Card...cards) {
		this.cards = cards;
		countCards();
		
	}
	
	public CardSet(int numCards) {
		cards = new Card[numCards];
		countCards();
		
	}
	
	public Card getCard(int i) {
		return cards[i];
	}
	public Card setCard(Card c, int i) {
		Card cardAtSpot = cards[i];
		cards[i] = c;
		countCards();
		return cardAtSpot;
		
		
	}
	
	public Card removeCard(int i) {
		Card cardAtSpot = cards[i];
		cards[i] = null;
		countCards();
		return cardAtSpot;
	}
	public boolean removeCard(Card c) {
		for (int i = 0; i < cards.length;i++) {
			Card card = cards[i];
			if (card == c) {
				cards[i] = null;
				countCards();
				return true;
			}
		}
		return false;
	}
	public int getMaxNumCards() {
		return cards.length;
	}
	public int getNumCards() {
		return countCards();
	}
	private int countCards() {
		int total = 0;
		for (Card c : cards)
			if (c != null)
				total++;
		return total;
	}
	public String toString() {
		StringBuilder output = new StringBuilder("[");
		for (Card c: cards) {
			output.append((c == null ? "null" : c.toString()) + ", ");
		}
		output.delete(output.length()-2, output.length());
		output.append("]");
		return output.toString();
	}
	public boolean containsCardAt(int i ) {
		return cards[i] !=null;
	}
	public List<Integer> getValidIndices() {
		List<Integer> nums = new LinkedList<Integer>();
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] !=null)
				nums.add(i);
		}
		return nums;
	}
	
	
	
}
