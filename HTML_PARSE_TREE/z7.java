import java.awt.*;
import javax.swing.*;

class z7 extends JFrame
	{
	public z7()
		{
		super("Thank You");
		setBounds(150,150,770,480);
		getContentPane().add(new mk7());
		}
	public static void main(String args[])
		{
		z7 mainFrame = new z7();
		mainFrame.pack();
		mainFrame.setVisible(true);
		}
	}

class mk7 extends JComponent
	{
	private static Font mf1 = new Font("High Tower Text",Font.BOLD,17); // Garton  Pristina
	private static Font mf2 = new Font("Aduren",Font.BOLD,16);// High Tower Text
	private static Font mf3 = new Font("AgencyFB",Font.BOLD,13);
	private static Font mf4 = new Font("Agency FB",Font.BOLD,30);
	private static Font mf5 = new Font("Pristina",Font.BOLD,20);
	public void paint(Graphics g)
		{
		Color c1 = new Color(80,0,0);
		g.setColor(Color.black);
		g.setFont(mf4);
		g.drawString("HTML PARSE TREE CONSTRUCTION IN WEB DATA EXTRACTION",80,70);
		g.drawString(" USING PARTIAL TREE ALIGNMENT ",200,120);
		
		Color c2 = new Color(223,112,0);
		g.setColor(c2);
		g.setFont(mf3);
		g.drawString("© Copyright 2006, MOP , All Rights Reserved",10,400);

		g.setFont(mf2);
		g.setColor(Color.red);
		g.drawString(" Query's To :: webdataextraction @ gmail.com",335,400);

		g.setFont(mf1);
		g.setColor(Color.blue);
		g.drawString("Designed & Developed By,",475,215);

		g.setFont(mf5);
		Color c3 = new Color(111,3,114);
		g.setColor(c3);
		g.drawString("I.A.Omer Asif # R.Moorthy # G.Purushotaman,",320,245);
		g.drawString("Computer Science and Engineering,",430,270);
		g.drawString("Government College of Engineering,",430,295);
		g.drawString("Salem - Tamilnadu - 636011.",465,320);
		}
	
	public Dimension getPreferredSize()
		{
		return new Dimension(700,450);
		}
	}