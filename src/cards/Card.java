package cards;

import java.awt.Image;

public abstract class Card {
	private Image displayImage; //shown on board
	private Image cardImage; // what is shown in hand/Hover (magnified)
	private String title;
	private char IDmod; //P for spell etc.
	private int ID; //number
	private String text = "";
	private String flavorText = "";
	public Card(Image displayImage, Image cardImage, String title, char IDmod, int ID) {
		this.displayImage = displayImage;
		this.cardImage = cardImage;
		this.title = title;
		this.IDmod = IDmod;
		this.ID = ID;
	}
	public Card(Image displayImage, Image cardImage, String title, char IDmod, int ID, String text) {
		this(displayImage, cardImage, title, IDmod, ID);
		this.text = text;
	}
	public Card(Image displayImage, Image cardImage, String title, char IDmod, int ID, String text, String flavorText) {
		this(displayImage, cardImage, title, IDmod, ID, text);
		this.flavorText = flavorText;
	}
	
	public Image displayImage() {
		return displayImage;
	}
	public Image cardImage() {
		return cardImage;
	}
	public String text() {
		return text;
	}
	public String flavorText() {
		return text;
	}
	public String title() {
		return title;
	}
	public String fullID() {
		return Character.toString(IDmod) + Integer.toString(ID);
	}
	public char idMod() {
		return IDmod;
	}
	public int numericID() {
		return ID;
	}
	public String toString() {
		return title + ":\n " + text;
	}
}
