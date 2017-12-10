package event;

import gameBasics.Player;

public class PlayerDefenseBuff extends Buff<Player> {

    int amount;

    public PlayerDefenseBuff(int amount) {
        this.amount = amount;
    }

    public void stop(Player player) {
        player.removeBuff(this);
    }
}
