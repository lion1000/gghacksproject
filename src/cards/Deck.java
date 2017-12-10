package cards;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	private LinkedList<Card> cards;
	public Deck(Card...cards) {
		this.cards = new LinkedList<Card>(Arrays.asList(cards));
	}
	public Deck(LinkedList<Card> cards) {
		this.cards = cards;
	}
	public boolean hasCardLeft() {
		return cards.size() !=0;
	}
	public boolean isEmpty() {
		return cards.size() == 0;
	}
	public Card drawCard() {
		return cards.removeFirst();
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}
}
