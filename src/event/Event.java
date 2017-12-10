package event;

public abstract class Event<T extends EventTarget> {

    public abstract void onExecute(T t);

    public void execute(T t) {
        t.onEventApplied(this);
    }
}
