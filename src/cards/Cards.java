package cards;

public enum Cards {

    ;

    private Runnable onPlay;
    private Runnable onRemove;
    private Runnable perTurn;
    private Runnable onThisAttack;
    private Runnable onOtherAttack;
    private Runnable onThisDefend;
    private Runnable onOtherDefend;

    Cards(String id, Runnable onPlay) {
        this.onPlay = onPlay;
    }
}
