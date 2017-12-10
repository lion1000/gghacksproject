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
                String name = split[0];
                String type = split[1];
                String subType = split[2];
                String id = split[3];
                String text = split[4];
                String flavor = split[5];
                cards.add(new Card(ImageIO.read(CardLoader.class.getResource("/textures/display/" + id + ".png"))))
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
