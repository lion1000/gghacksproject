package guiElements;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionPanelFrame extends JFram implements Act {
	JPanel c = new JPanel();
	Image actImg = new ImageIcon(this.getClass().getResource("/nonCards/actionpanel.png")).getImage();
	JButton buy = new JButton();
	JButton place = new JButton();
	JButton sell = new JButton();
	JButton attack = new JButton();
	public ActionPanelFrame() {
		super("Action Panel");
		this.setSize(330, 337);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buy.setBounds(8, 44, 209, 37);
		c.add(buy);
		
	}
}
