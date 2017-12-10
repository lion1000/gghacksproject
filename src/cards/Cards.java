package cards;

public enum Cards {

    DO_U_EVER_MOVE("P1", () -> {

    });

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
