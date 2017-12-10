package cards;

import java.awt.Image;

public class Creature extends Card {
	private String subType;
	private int power;
	private int cost;
	
	public Creature(Image displayImage, Image cardImage, String title, char IDmod, int ID, String subType, int power, int cost) {
		super(displayImage, cardImage, title, IDmod, ID);
		this.subType = subType;
		this.power = power;
		this.cost = cost;
	}
	public String getSubType() {
		return subType;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int p) {
		power = p;
	}
	public void addToPower(int modifier) {
		power += modifier;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int c) {
		cost = c;
	}
	public void addToCost(int modifier) {
		cost+= modifier;
	}
}

