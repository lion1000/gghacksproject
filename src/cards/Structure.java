package cards;

import java.awt.Image;

public class Structure extends Card {
	private int defense;
	private int cost;
	public Structure(Image displayImage, Image cardImage, String title, char IDmod, int ID, int defense, int cost) {
		super(displayImage, cardImage, title, IDmod, ID);
		this.defense = defense;
		this.cost = cost;
	}
	public static boolean IsStructure(Card c) {
		return (c instanceof Structure);
	}
	public int getDefense() {
		return defense;
	}
}
