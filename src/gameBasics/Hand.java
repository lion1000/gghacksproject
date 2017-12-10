package gameBasics;

import java.util.*;

import cards.*;

public class Hand extends CardSet {
	public final static int HAND_SIZE = 4;
	Boolean[] toggled = new Boolean[HAND_SIZE]; //defaulted to NULL
	public Hand() {
		super(HAND_SIZE);
	}
	public void flipAllCards() {
		List<Integer> cards = this.getValidIndices();
		Iterator<Integer> it  = cards.iterator();
		while (it.hasNext()) {
			int i = it.next();
			toggled[i] = !toggled[i];
		}
	}
	@Override
	public Card setCard(Card c, int i) {
		Card returnVal = super.setCard(c, i);
		if (c!=null)
			toggled[i] = false;
		return returnVal;
	}
	public Card setCard(Card c, int i, boolean toggled) {
		Card returnVal = this.setCard(c, i);
		if (c!= null)
			this.toggled[i] = toggled;
		return returnVal;
	}
	
} 
