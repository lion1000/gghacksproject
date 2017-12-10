package guiElements;

import cards.Card;
import java.awt.*; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class CardHolder extends JComponent {
	private Image border = new ImageIcon(this.getClass().getResource("")).getImage(); //TODO: Add IMAGE
	private Image defaultImage = new ImageIcon(this.getClass().getResource("")).getImage();
	private static final long serialVersionUID = 3639041433130104464L;
	private static final int BORDER_OFFSET = 10;
	private Card card;
	private int width;
	private int height;
	private int positionX;
	private int positionY;
	private Image currentPic;
	private boolean onBoardImage;
	private boolean allowedToBeClicked = false;
	private boolean isSelected =false;
	private MouseClickedEvent<CardHolder> onClickEvent;
	public CardHolder(int positionX, int positionY, int width, int height) {
		this.width = width;
		this.height = height;
		this.positionX = positionX;
		this.positionY = positionY;
		this.setBounds(positionX, positionY, width, height);
		this.currentPic = defaultImage;
		setVisible(true);
		onClickEvent = new MouseClickedEvent<CardHolder>() {

			@Override
			public void clickedMouseEvent(CardHolder c) {
				c.isSelected = !c.isSelected;
				
			}
			
		};
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            super.mouseEntered(e);
	           
	            togglePic();
	        }
	    }); 
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseExited(MouseEvent e) {
	         
	        	super.mouseExited(e);
	           
	            togglePic();
	        }
	    }); 
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            super.mouseClicked(e);
	           if (allowedToBeClicked)
	            mouseClickEvent();
	        }
	    }); 
	}
	public CardHolder(Card card, int positionX, int positionY, int width, int height) {
		this(positionX, positionY, width, height);
		this.card = card;
		this.currentPic = card.boardImage();
		
		onBoardImage = true;
		
	}
	public CardHolder(Card card, int positionX, int positionY, int width, int height, MouseClickedEvent<CardHolder> clickEvent) {
		this(card, positionX, positionY, width, height);
		this.onClickEvent = clickEvent;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isSelected && onBoardImage) {
			g.drawImage(border, positionX, positionY, width+BORDER_OFFSET, height+BORDER_OFFSET, null); //draw border 
		}
		g.drawImage(currentPic, positionX, positionY, width, height, null);
		
		

	}
	private void togglePic() {
		if (card != null) {
		if (onBoardImage)
			this.currentPic = card.hoverImage();
		else
			this.currentPic = card.boardImage();
		onBoardImage = !onBoardImage;
		}
	}
	public Card removeCard() {
		Card c = this.card;
		this.card = null;
		this.currentPic = defaultImage;
		return c;
	}
	public  void setCard(Card c) {
		this.card = c;
		this.currentPic = onBoardImage ? card.boardImage() : card.hoverImage();
		
	}
	private void mouseClickEvent() {
		onClickEvent.clickedMouseEvent(this);
	}
	public void setIsSelected(boolean highlited) {
		this.isSelected = highlited;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setClickAllowance(boolean allowed) {
		this.allowedToBeClicked = true;
	}
	public boolean isAllowedToBeClicked() {
		return allowedToBeClicked;
	}
}
