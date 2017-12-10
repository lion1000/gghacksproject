package guiElements;

import java.util.Arrays;

import javax.swing.JFrame;

import cards.*;
import gameBasics.*;

public class testGUI {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("test");
		Player player1 = new Player();
		Player player2 = new Player();
		Client c = new Client();
		Card a = new SpecialCard("test", 'P', 3);
		Card b = new SpecialCard("test2", 'E', 4);
		Deck test = new Deck(a,b);
		Deck test2 = new Deck(a,b);
		PlayerGUI gui = new PlayerGUI(new Board(player1, player2, test, test2), c, true);
		frame.add(gui);
		
		

	}
}
