package cards;

import java.awt.Image;

public abstract class Card {
	@LocalVariableDocumentation("Shown on board")
	private Image displayImage; //shown on board
	@LocalVariableDocumentation("Shown on hover")
	private Image cardImage; // what is shown in hand/Hover (magnified)
	private String title;
	private char IDmod; //P for spell etc.
	private int ID; //number
	private String text = "";
	private String flavorText = "";
	
	public Card(char IDmod, int ID) {
		this.IDmod = IDmod;
		this.ID = ID;
	}
	public Card(String title, char IDmod, int ID) {
		this(IDmod,ID);
		this.title = title;
		
	}
	public Card(Image displayImage, Image cardImage, String title, char IDmod, int ID) {
		this(title, IDmod, ID);
		this.displayImage = displayImage;
		this.cardImage = cardImage;
		
	}
	public Card(Image displayImage, Image cardImage, String title, char IDmod, int ID, String text) {
		this(displayImage, cardImage, title, IDmod, ID);
		this.text = text;
	}
	public Card(Image displayImage, Image cardImage, String title, char IDmod, int ID, String text, String flavorText) {
		this(displayImage, cardImage, title, IDmod, ID, text);
		this.flavorText = flavorText;
	}
	
	public Image boardImage() {
		return displayImage;
	}
	public Image hoverImage() {
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
@interface LocalVariableDocumentation {
    String value();
}