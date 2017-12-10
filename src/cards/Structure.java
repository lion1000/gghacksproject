package cards;

import event.Buff;
import event.BuffTarget;
import event.Event;

import java.awt.Image;

public class Structure extends Card implements BuffTarget {
    private int defense;
    private int cost;

    public Structure(Image displayImage, Image cardImage, String title, String text, String flavor, char IDmod, int ID, int defense, int cost) {
        super(displayImage, cardImage, title, IDmod, ID, text, flavor);
        this.defense = defense;
        this.cost = cost;
    }

    public static boolean isStructure(Card c) {
        return c.idMod() == 'S';
    }

    public int getDefense() {
        return defense;
    }

    public void addDefense(int a) {
        defense += a;
        if(defense < 0) {

        }
    }

    @Override
    public void addBuff(Buff b) {

    }

    @Override
    public void removeBuff(Buff b) {

    }

    @Override
    public void onEventApplied(Event e) {

    }
}
