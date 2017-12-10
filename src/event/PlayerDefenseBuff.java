package event;

import gameBasics.Player;

public class PlayerDefenseBuff extends Buff<Player> {

    int amount;

    public PlayerDefenseBuff(int amount) {
        this.amount = amount;
    }

    @Override
    public void onStop(Player t) {
        player.add defense ( - amount)
    }

    @Override
    public void onExecute(Player player) {
        player.add defense (amount)
    }
}
