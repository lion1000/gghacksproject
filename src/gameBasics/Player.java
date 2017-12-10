package gameBasics;

import cards.ChampionCard;
import cards.Structure;
import event.Buff;
import event.BuffTarget;
import event.Event;
import event.EventTarget;

import java.util.ArrayList;
import java.util.List;

public class Player implements BuffTarget {

    public final static int NUM_COLS = 3;
    public final static int NUM_ROWS = 4;
    private final static int DEFAULT_STARTING_BANK_AMOUNT = 0;
    private final static int DEFAULT_MAX_BANK_AMOUNT = 5;
    private final static int DEFAULT_STARTING_RESERVE_AMOUNT = 0;
    private final static int DEFAULT_STARTING_INCOME = 1;
    private final static int DEFAULT_STARTING_AP = 3;
    private final static int DEFAULT_MAX_AP = 3;
    private static final int DEFAULT_STARTING_LIFE = 20;

    int lifeTotal = DEFAULT_STARTING_LIFE;
    int bankAmount = DEFAULT_STARTING_BANK_AMOUNT;
    int maxBankAmount = DEFAULT_MAX_BANK_AMOUNT;
    int reserveAmount = DEFAULT_STARTING_RESERVE_AMOUNT;
    int income = DEFAULT_STARTING_INCOME;
    int currentActionPoints = DEFAULT_STARTING_AP;
    int maxActionPoints = DEFAULT_MAX_AP;

    List<Buff> buffs = new ArrayList<>();

    Hand hand = new Hand();

    CardSet[] columns;

    CardSet championCards = new CardSet(NUM_COLS);

    public Player() {
        for (int i = 0; i < NUM_COLS; i++) {
            columns[i] = new CardSet(NUM_ROWS);
        }
    }

    public CardSet[] getColumns() {
        return columns;
    }

    public CardSet getColumn(int i) {
        return columns[i];
    }

    public CardSet getChampionCards() {
        return championCards;
    }

    public ChampionCard getChampionCard(int i) {
        return (ChampionCard) championCards.getCard(i);
    }

    public void addBuff(Buff b) {
        buffs.add(b);
    }

    public void removeBuff(Buff b) {
        buffs.remove(b);
    }

    public void setChampionCard(ChampionCard c, int clm) {
        championCards.setCard(c, clm);
    }

    private int getTotalDefenseVal(int clm) {
        CardSet column = columns[clm];
        int totalDefense = 0;
        for (int i : column.getValidIndices()) {
            if (Structure.IsStructure(column.getCard(i)))
                totalDefense += ((Structure) column.getCard(i)).getDefense();
        }
        return totalDefense;
    }

    public int[] getTotalDefense() {
        int[] FF = new int[NUM_COLS];
        for (int i = 0; i < FF.length; i++)
            FF[i] = getTotalDefenseVal(i);
        return FF;
    }

    @Override
    public void onEventApplied(Event e) {

    }
}