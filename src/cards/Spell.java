package cards;

import java.awt.*;

public class Spell extends Card {
    int cost;
    public Spell(Image displayImage, Image cardImage, String title, String text, String flavor, char IDmod, int ID, int cost) {
        super(displayImage, cardImage, title, IDmod, ID, text, flavor);
        this.cost = cost;
    }
}
