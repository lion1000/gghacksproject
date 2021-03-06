package gameBasics;
import cards.*;
//represents the board in memory, will be owned by PlayerGUI who will access it's elements and display them, taking input from user.
public class Board {
	private Player player1; //has columns, and champion cards (and player attributes obv)
	private Player player2;
	private CardSet specialCards = new CardSet(3);
	private CardSet shopCards = new CardSet(6);
	private Deck deck;
	private Deck championCards;
	private ChampionCard currentChampion;
	boolean deckEmpty = false;
	boolean noMoreChampions = false;
	public Board(Player player1, Player player2, Deck d, Deck championDeck) {
		this.player1 = player1;
		this.player2 = player2;
		this.deck = d;
		this.championCards = championDeck;
	}
	//returns two arrays, the first is array of total defense of col of first player, second for second player
	public int[][] getTotalDefense() {
		int[][] FF = new int[][]{player1.getTotalDefense(), player2.getTotalDefense()};
		return FF;
	}
	public void drawCards() {
		if (!deckEmpty) {
			for (int i : shopCards.getEmptyIndices()) {
				if (!deck.isEmpty())
					shopCards.setCard(deck.drawCard(), i);
				else
					deckEmpty = true;
			}
		}
	}
	public ChampionCard getChampionCard() {
		if (currentChampion == null) {
			if (!noMoreChampions) {
				if (!championCards.isEmpty())
					currentChampion = (ChampionCard) championCards.drawCard();
				else
					noMoreChampions = true;
			}
		}
		return currentChampion;
	}
	public void setChampionCard(Player p, int clm ) {
		p.setChampionCard(currentChampion, clm);
		currentChampion = null;
	}
	public void setSpecialCard(Card c, int i) {
		this.specialCards.setCard(c, i);
	}
	public Player getPlayer1() {
		return player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public boolean removeCard(Card c) {
		return player1.removeCard(c) && player2.removeCard(c);
	}


}
