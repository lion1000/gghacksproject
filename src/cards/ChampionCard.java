package cards;

import gameBasics.Board;

public class ChampionCard extends Card {
	private Condition condition;
	public ChampionCard(String title, char IDmod, int ID, Condition condition) {
		super(title, IDmod, ID);
		this.condition = condition;
	}
	public boolean checkCondition(Board b) {
		return condition.checkCondition(b);
	}

}
