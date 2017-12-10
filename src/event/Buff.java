package event;

import gameBasics.Player;

public abstract class Buff<T extends BuffTarget> extends Event<T> {

    public void stop(T t) {
        t.removeBuff(this);
        onStop(t);
    }

    public abstract void onStop(T t);

    @Override
    public void execute(T t) {
        t.addBuff(this);
        super.execute(t);
    }
}
