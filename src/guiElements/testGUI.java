package guiElements;

import java.awt.Image;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import cards.*;
import gameBasics.*;

public class testGUI {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("test");
		Player player1 = new Player();
		Player player2 = new Player();
		Client c = new Client();
		Image testI = new ImageIcon(c.getClass().getResource("trump.png")).getImage();
		Card a = new SpecialCard(testI, testI, "test", 'P', 3);
		Card b = new SpecialCard(testI, testI, "test2", 'E', 4);
		Deck test = new Deck(a,b);
		Deck test2 = new Deck(a,b);
		PlayerGUI gui = new PlayerGUI(new Board(player1, player2, test, test2), c, true);
		frame.add(gui);
		frame.setSize(1980, 1020);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		

	}
}
