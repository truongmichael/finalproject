package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ChessFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int player1Time;
	private int player2Time;	
	private boolean white;
	private Dimension screenDimension;
	private int screenWidth;
	private int screenHieght;
	private JButton restart;
	private	Timer time = new Timer(1000,new ActionListener() 
	{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			if(white){
			player1Time--;
			bottomDisplay.setText(""+player1Time);
			}
			else 
			{
				player2Time--;
				bottomDisplay.setText(""+player2Time);
			}
			if(player1Time==3590)
			{
				reset();
			}
		}
	});


	private JLabel bottomDisplay;
	private board2 MainPanel;
	private JLabel lblWhitePlayersTurn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChessFrame frame = new ChessFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ChessFrame() throws IOException {
		screenDimension= getToolkit().getScreenSize();
		screenWidth=screenDimension.width;
		screenHieght=screenDimension.height;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenWidth, screenHieght);
		contentPane = new JPanel();
		LineBorder contentPaneBorder = new LineBorder(Color.BLACK, 2);
		contentPane.setBorder(contentPaneBorder);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		// content pane
		
		lblWhitePlayersTurn = new JLabel("White Player's turn");
		lblWhitePlayersTurn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWhitePlayersTurn, BorderLayout.NORTH);
		//Displys whose turn
		
	
		 MainPanel = new board2();
		 MainPanel.setAlignmentX(LEFT_ALIGNMENT);
		
		contentPane.add(MainPanel, BorderLayout.CENTER);
		// where game will be played

		player1Time=3600;
		player2Time=3600;
		white=true;
		// setting up amount and who goes first.
		
		bottomDisplay = new JLabel("White Player's turn");
		bottomDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(bottomDisplay, BorderLayout.SOUTH);
		// the Timer
		time.start();
		
	}
	public void reset()
	{
		time.stop();
		contentPane.removeAll();
		add(lblWhitePlayersTurn, BorderLayout.NORTH);
		add(bottomDisplay,BorderLayout.SOUTH);
		restart= new JButton("Restart");
		restart.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							MainPanel= new board2();
							contentPane.remove(restart);
							contentPane.add(MainPanel);
							time.restart();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						MainPanel.setVisible(true);
					}
				});
		add(restart,BorderLayout.CENTER);
		
		revalidate();
		repaint();
		player1Time=3600;
		player2Time=3600;
		white=true;
		
	}
}
