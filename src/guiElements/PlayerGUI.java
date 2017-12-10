package guiElements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import gameBasics.Board;
import gameBasics.CardSet;
import gameBasics.Player;

public class PlayerGUI extends JPanel implements ActionListener {
	Board board; //will gain information from this in order to pain the gui
	//In all of the below, me is the player, you is the opponent
	
	//Spaces that people place creatures etc on:
	private static final int NORMAL_SPACE_WIDTH = 100;
	private static final int NORMAL_SPACE_HEIGHT = 100;
	private static final int SPECIAL_CARD_SPACE_WIDTH = 50;
	
	private static final int START_X_COL_ME = 50;//should represent position of uppest most right column
	private static final int START_X_COL_YOU = START_X_COL_ME + (NORMAL_SPACE_WIDTH*Player.NUM_ROWS) + SPECIAL_CARD_SPACE_WIDTH;
	private static final int START_Y_COL = 50;
	private static final int DOWN_COLUMN = 100; //amount to space next column below by (in y direction)
	
	
	
	CardHolderSet[] myCols;
	CardHolderSet[] yourCols;
	CardHolderSet myHand;
	CardHolderSet yourHand;
	Player myPlayer;
	Player yourPlayer;
	boolean isPlayerOne;
	Client client;
	public PlayerGUI(Board board, Client client, boolean isPlayerOne) {
		this.board = board;
		this.client = client;
		this.isPlayerOne = isPlayerOne;
		if (isPlayerOne) 
			myPlayer = board.getPlayer1();
		else
			myPlayer = board.getPlayer2();
		myCols = new CardHolderSet[myPlayer.getColumns().length];
		yourCols = new CardHolderSet[yourPlayer.getColumns().length];
		if (myCols.length != yourCols.length) {
			throw new Error("SOMTHING WENT WRONG");
		}
		int totalOff = 0;
		for (int i =0 ;i < myCols.length; i++) {
			myCols[i] = new CardHolderSet(myPlayer.getColumn(i), START_X_COL_ME, START_Y_COL + totalOff, NORMAL_SPACE_WIDTH, NORMAL_SPACE_HEIGHT, NORMAL_SPACE_WIDTH, true);
			totalOff += DOWN_COLUMN;
		}
		totalOff = 0;
		for (int i =0 ;i < yourCols.length; i++) {
			myCols[i] = new CardHolderSet(myPlayer.getColumn(i), START_X_COL_YOU, START_Y_COL + totalOff, NORMAL_SPACE_WIDTH, NORMAL_SPACE_HEIGHT, NORMAL_SPACE_WIDTH, true, true);
			totalOff += DOWN_COLUMN;
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
