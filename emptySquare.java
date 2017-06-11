package chess;

import java.util.ArrayList;

import javax.swing.JButton;

public class emptySquare extends mycharacter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3579114067551353078L;

	public emptySquare(int row, int colum, ArrayList<ArrayList<JButton>> buttons) {
		super(row, colum, buttons);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JButton getUserInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<JButton> moveLocations() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
