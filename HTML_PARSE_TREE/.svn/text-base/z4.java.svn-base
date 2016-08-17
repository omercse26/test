import java.awt.*;
import javax.swing.*;

class z4 extends JFrame
	{
	public z4()
		{
		super(" Welcome To WEB DATA EXTRACTION");
		setBounds(150,150,760,380);    
		getContentPane().add(new mk4());
		
		JPanel mk41 = new JPanel();
		JPanel mk411 = new JPanel();
		mk411.setLayout(new GridLayout(2,1,5,5));
		
		final JButton b1 = new JButton(" Click here to Enter ");
		mk411.add(b1);
		mk411.add(new JLabel("                              "));
		
		mk41.add(mk411);
		getContentPane().add(mk41, BorderLayout.SOUTH);
		
		b1.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				 {
               			z5 ob45 = new z5();
				ob45.setVisible(true);
				setVisible(false);
				}
			});
		}
	public static void main(String args[])
		{
		z4 mainFrame = new z4();
		mainFrame.pack();
		mainFrame.setVisible(true);
		}
	}

class mk4 extends JComponent
	{
	private static Font mf1 = new Font("Algerian",Font.BOLD,32);
	
	public void paint(Graphics g)
		{
		Color c1 = new Color(128,0,128);
		g.setFont(mf1);
		g.setColor(c1);
		g.drawString("HTML PARSE TREE CONSTRUCTION IN ",60,140);
		g.drawString("WEB DATA EXTRACTION USING ",100,200);
		g.drawString("PARTIAL TREE ALIGNMENT",125,260);
		
		}
	
	public Dimension getPreferredSize()
		{
		return new Dimension(760,380);
		}
	}