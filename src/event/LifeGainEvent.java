package event;

import gameBasics.Player;

public class LifeGainEvent extends Event<Player> {

    int amount;

    public LifeGainEvent(int amount) {
        this.amount = amount;
    }

    @Override
    public void onExecute(Player player) {
        player. add life (amount)
    }
}
