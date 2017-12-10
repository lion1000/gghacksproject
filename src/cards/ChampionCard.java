package cards;

import java.awt.Image;

import gameBasics.Board;

public class ChampionCard extends Card {
	private Condition condition;
	public ChampionCard(Image DisplayImage, Image CardImage, String title, char IDmod, int ID, Condition condition) {
		super(DisplayImage, CardImage, title, IDmod, ID);
		this.condition = condition;
	}
	public boolean checkCondition(Board b) {
		return condition.checkCondition(b);
	}
	

}
