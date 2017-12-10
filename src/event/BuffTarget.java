package event;

public interface BuffTarget extends EventTarget {
    void addBuff(Buff b);
    void removeBuff(Buff b);
}
