package guiElements;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

import gameBasics.CardSet;

public class CardHolderSet extends JComponent{
	CardHolder[] cardHolders;
	CardSet cardset;
	Image overlay;
	int overlayPosX;
	int overlayPosY;
	int overlayWidth;
	int overlayHeight;
	boolean toggle; //will determine if overlay is displayed
	boolean backwardsDisplay = false;
	public CardHolderSet(CardSet c, int positionX, int positionY, int width, int height, int offset, boolean adjustInX) {
		this.cardset = c;
		int x = c.getMaxNumCards();
		int currOffset = 0;
		for (int i =0; i < x; i++) {
			if (adjustInX)
				cardHolders[i] = new CardHolder(c.getCard(i), positionX+currOffset, positionY, width, height); //will account even if card is null
			else
				cardHolders[i] = new CardHolder(c.getCard(i), positionX, positionY+currOffset, width, height); 
			currOffset+= offset;
		}
		
	}
	public CardHolderSet(CardSet c, int positionX, int positionY, int width, int height, int offset, boolean adjustInX, boolean backWardsDisplay) {
		this.cardset = c;
		this.backwardsDisplay = backWardsDisplay;
		int x = c.getMaxNumCards();
		int currOffset = 0;
		if (!backWardsDisplay) {
		for (int i =0; i < x; i++) {
			if (adjustInX)
				cardHolders[i] = new CardHolder(c.getCard(i), positionX+currOffset, positionY, width, height); //will account even if card is null
			else
				cardHolders[i] = new CardHolder(c.getCard(i), positionX, positionY+currOffset, width, height); 
			currOffset+= offset;
		}
		}
		else {
			for (int i =x-1; i >= 0; i--) {
				if (adjustInX)
					cardHolders[i] = new CardHolder(c.getCard(i), positionX+currOffset, positionY, width, height); //will account even if card is null
				else
					cardHolders[i] = new CardHolder(c.getCard(i), positionX, positionY+currOffset, width, height); 
				currOffset+= offset;
			}
		}
		
	}
	public CardHolderSet(CardSet c, int positionX, int positionY, int width, int height, int[] offset, boolean adjustInX) {
		this.cardset = c;
		int x = c.getMaxNumCards();
		int currOffset = 0;
		for (int i =0; i < x; i++) {
			if (adjustInX)
				cardHolders[i] = new CardHolder(c.getCard(i), positionX+currOffset, positionY, width, height); //will account even if card is null
			else
				cardHolders[i] = new CardHolder(c.getCard(i), positionX, positionY+currOffset, width, height); 
			currOffset+= offset[i];
		}
		
	}
	public CardHolderSet(CardSet c, int positionX, int positionY, int width, int height, int[] offset, boolean adjustInX, boolean backwardsDisplay) {
		this.cardset = c;
		int x = c.getMaxNumCards();
		this.backwardsDisplay = backwardsDisplay;
		int currOffset = 0;
		if (!backwardsDisplay) {
		for (int i =0; i < x; i++) {
			if (adjustInX)
				cardHolders[i] = new CardHolder(c.getCard(i), positionX+currOffset, positionY, width, height); //will account even if card is null
			else
				cardHolders[i] = new CardHolder(c.getCard(i), positionX, positionY+currOffset, width, height); 
			currOffset+= offset[i];
		}
		}
		else {
			for (int i =x-1; i > 0; i--) {
				if (adjustInX)
					cardHolders[i] = new CardHolder(c.getCard(i), positionX+currOffset, positionY, width, height); //will account even if card is null
				else
					cardHolders[i] = new CardHolder(c.getCard(i), positionX, positionY+currOffset, width, height); 
				currOffset+= offset[i];
			}
		}
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i =0; i < cardHolders.length; i++) {
			cardHolders[i].paint(g);
		}
		if (toggle && overlay !=null) {
			g.drawImage(overlay, overlayPosX, overlayPosY, overlayWidth, overlayHeight, null);
		}
			

	}
	public void updateCards() {
		
		for (int i =0; i < cardHolders.length; i++) {
			cardHolders[i].setCard(cardset.getCard(i));
		}
		
		
	}
	
	
}
