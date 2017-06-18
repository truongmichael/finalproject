package chess;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class board2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer time;
	/**
	 * Create the panel.
	 * @param e 
	 * @param d 
	 */
	JButton A;

	private double xsize;

	private double ysize;
	private ArrayList<ArrayList<JButton> > buttons;

	private ArrayList<JButton> rowButtons;
	public board2() throws IOException 
	{
		buttons= new ArrayList<ArrayList<JButton>>();
		rowButtons= new ArrayList<JButton>();
		xsize = getToolkit().getScreenSize().getWidth();
		ysize = getToolkit().getScreenSize().getHeight();
		setBackground(Color.CYAN);
		setBounds(0, 0, (int)xsize, (int)ysize);
		GridBagLayout gridBagLayout = new GridBagLayout();
	
		setLayout(gridBagLayout);
		
		
	
		GridBagConstraints c = new  GridBagConstraints();
		c.fill=GridBagConstraints.HORIZONTAL;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				c.ipady=70;
				c.ipadx=70;
				c.gridx = (int) (xsize/8*i);
				c.gridy = (int) (ysize/8*j);
				c.gridwidth=(int) (xsize/8);
				c.gridheight=(int) (ysize/8);
				
				A = new JButton();
				
				rowButtons.add(A);	
				add(A, c);
			}
			
			buttons.add(rowButtons);
			rowButtons.removeAll(rowButtons);

		}
		
		time = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Update();
			}
		});
		time.start();
	}
	
	public void Update()
	{
		
		
		GridBagConstraints c = new  GridBagConstraints();
		c.fill=GridBagConstraints.HORIZONTAL;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				c.ipady=70;
				c.ipadx=70;
				c.gridx = (int) (xsize/8*j);
				c.gridy = (int) (ysize/8*i);
				c.gridwidth=(int) (xsize/8);
				c.gridheight=(int) (ysize/8);	
			}
		}
		
	}

	

}
