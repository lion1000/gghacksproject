package event;

import gameBasics.Player;

public class LifeGainEvent extends Event<Player> {

    int amount;

    public LifeGainEvent(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(Player t) {

        super.execute(t);
    }
}
