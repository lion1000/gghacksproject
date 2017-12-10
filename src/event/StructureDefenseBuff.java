package event;

import cards.Structure;

public class StructureDefenseBuff extends Buff<Structure> {

    int amount;

    public StructureDefenseBuff(int amount) {
        this.amount = amount;
    }

    @Override
    public void onStop(Structure t) {
        t.addDefense(-amount);
    }

    @Override
    public void onExecute(Structure structure) {
        structure.addDefense(amount);
    }
}
