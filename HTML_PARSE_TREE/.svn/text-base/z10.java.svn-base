import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.lang.String.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class z10 extends JFrame
	{
	
	public z10()
		{
		super("LOCAL DATABASE FILE LIST");
		setBounds(150,150,770,480);
		
		JPanel mk101 = new JPanel();
		mk101.setLayout(new BoxLayout(mk101,BoxLayout.Y_AXIS));
		
		JPanel mk1011 = new JPanel();
		mk1011.setBorder(new EmptyBorder(5,5,5,5));

		JPanel mk10111 = new JPanel();
		mk10111.setLayout(new GridLayout(10,4,5,5));

		try
					{
					byte[] buffer=new byte[1024];
					FileReader fin2=new FileReader("flst.mop");
			                BufferedReader br=new BufferedReader(fin2);
					String s="";
			                while((s=br.readLine())!=null)
						{
						JLabel fn = new JLabel(s);
						mk10111.add(fn);
						}
					fin2.close();
					}
				catch( Exception e)     { }

		
							
		mk1011.setLayout(new BorderLayout());
		mk1011.add(mk10111, BorderLayout.WEST);
		mk101.add(mk1011);
		
		getContentPane().add(mk101,BorderLayout.CENTER);


		
		JPanel mk102 = new JPanel();
		JPanel mk1021 = new JPanel();
		mk102.setLayout(new GridLayout(1,2,5,5));
		
		final JButton b1 = new JButton(" Back to PHASE I ");
		mk1021.add(b1);
		
		mk102.add(mk1021);
		getContentPane().add(mk102, BorderLayout.SOUTH);
		
		b1.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				 {
               			z5 ob105 = new z5();
				ob105.setVisible(true);
				setVisible(false);
				}
			});
				
		
		setVisible(true);
		}

	public static void main(String args[])
		{
		new z10();
		}
	}





