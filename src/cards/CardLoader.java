package cards;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CardLoader {

    public static Deck loadDeck(String csvPath) {
        LinkedList<Card> cards = new LinkedList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(CardLoader.class.getResource(csvPath).getFile()))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] split = line.split(",");
                for(int i = 0; i < split.length; i++)
                    split[i] = split[i].replace(",", "");
                String name = split[0];
                String type = split[1];
                String subType = split[2];
                String id = split[3];
                String text = split[4];
                String att = split[5]; // power or defense or 0 if N/A
                String flavor = split[6];
                String cost = split[7];
                if (type.equalsIgnoreCase("structure"))
                    cards.add(new Structure(ImageIO.read(CardLoader.class.getResource("/textures/display/" + id + ".png")),
                            ImageIO.read(CardLoader.class.getResource("/textures/card/" + id + ".png")),
                            name,
                            text,
                            flavor,
                            id.charAt(0),
                            Integer.valueOf(id.substring(1)),
                            Integer.valueOf(att),
                            Integer.valueOf(cost)));
                if(type.equalsIgnoreCase("guy"))
                    cards.add(new Creature(ImageIO.read(CardLoader.class.getResource("/textures/display/" + id + ".png")),
                            ImageIO.read(CardLoader.class.getResource("/textures/card/" + id + ".png")),
                            name,
                            text,
                            flavor,
                            id.charAt(0),
                            Integer.valueOf(id.substring(1)),
                            subType,
                            Integer.valueOf(att),
                            Integer.valueOf(cost)));
                if(type.equalsIgnoreCase("spell"))
                    cards.add(new Spell(ImageIO.read(CardLoader.class.getResource("/textures/display/" + id + ".png")),
                            ImageIO.read(CardLoader.class.getResource("/textures/card/" + id + ".png")),
                            name,
                            text,
                            flavor,
                            id.charAt(0),
                            Integer.valueOf(id.substring(1)),
                            Integer.valueOf(cost)));
                if(type.equalsIgnoreCase("special"))
                    cards.add(new Spell(ImageIO.read(CardLoader.class.getResource("/textures/display/" + id + ".png")),
                            ImageIO.read(CardLoader.class.getResource("/textures/card/" + id + ".png")),
                            name,
                            text,
                            flavor,
                            id.charAt(0),
                            Integer.valueOf(id.substring(1)),
                            Integer.valueOf(cost)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Deck(cards);
    }


}
