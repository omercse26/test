import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.lang.*;
import java.lang.String.*;
import java.io.*;
import java.lang.Byte.*;

public class z5 extends JFrame
	{
	static JFrame F1;
	public z5()
		{
		super(" PHASE - I  ");
		setBounds(150,150,770,480);
		
		JPanel mk51 = new JPanel();
		mk51.setLayout(new BoxLayout(mk51,BoxLayout.X_AXIS));
		
		JPanel mk511 = new JPanel();
		mk511.setLayout(new BoxLayout(mk511,BoxLayout.Y_AXIS));

		mk511.add(new JLabel("                                       "));
		mk511.add(new JLabel("                            Module I"));
		mk511.add(new JLabel("                                       "));
		mk511.add(new JLabel("                                         Search Module"));
		mk511.add(new JLabel("                                                      ** User wants to Enter the Local HTML File / Page Name "));
		mk511.add(new JLabel("                                       "));
		mk511.add(new JLabel("                                       "));
		mk511.add(new JLabel("                                       "));
		mk511.add(new JLabel("                                       "));
		mk511.add(new JLabel("                                       "));
				
		mk51.add(mk511);
		getContentPane().add(mk51,BorderLayout.NORTH);

		JPanel mk52 = new JPanel();
		JPanel mk521 = new JPanel();
		mk521.setBorder(new LineBorder(Color.black,2));
		
		mk521.add(new JLabel("   Enter the Name of Local HTML File / Page        "));
		final JTextField ip = new JTextField(20);
		JButton go = new JButton("GO");
		mk521.add(ip);
		mk521.add(new JLabel("               "));
		mk521.add(go);
		mk521.add(new JLabel("                 "));
		
		mk52.add(mk521);
		getContentPane().add(mk52, BorderLayout.CENTER);


		JPanel mk53 = new JPanel();
		mk53.setLayout(new BoxLayout(mk53,BoxLayout.X_AXIS));
		
		JPanel mk531 = new JPanel();
		mk531.setBorder(new EmptyBorder(10,10,10,10));
		mk53.add(mk531);

		JPanel mk532 = new JPanel();
		mk532.setLayout(new BoxLayout(mk532,BoxLayout.Y_AXIS));
				
		mk532.add(new JLabel("PHASE - I "));
		mk532.add(new JLabel("**  Module 1                   "));
		mk532.add(new JLabel(" PHASE - II "));
		mk532.add(new JLabel(" **  Module 2 & 3               "));
		JButton ldbfl = new JButton("Local DB File List");
		mk532.add(ldbfl);
		mk532.add(new JLabel("                                                   "));
		
		
		mk53.add(mk532);
		getContentPane().add(mk53, BorderLayout.SOUTH);
		
						
		go.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				 {
				String ufn = ip.getText();
				int f=0;
				try
					{
					byte[] buffer=new byte[1024];
					FileReader fin2=new FileReader("flst.mop");
			                BufferedReader br=new BufferedReader(fin2);
					String s="";
			                while((s=br.readLine())!=null)
				                {
						if(s.equals(ufn)) 
							{
							f=1;
							break;
							}
						}
					fin2.close();
					}
				catch( Exception e)     { }
				
				if ( (ip.getText()).equals(""))
					{
					JOptionPane.showMessageDialog(null,"Please Enter File Name"," E r r o r ",1);
					}
				
				else if (f==0)
					{
					JOptionPane.showMessageDialog(null,"Sorry, Your File is not availabel in the Local Database.\nPlease enter a valid File name\nFor List of files in the Local dataBase press the Local DB File List  Button"," E r r o r ",1);
					ip.setText("");
					}


               			else	
					{
					z6 ob56 = new z6(ufn);
					ob56.setVisible(true);
					setVisible(false);	
					}
				}
			});

		ldbfl.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				 {
					z10 ob510 = new z10();
					ob510.setVisible(true);
					setVisible(false);
				}
			});
						
		WindowListener wndCloser = new WindowAdapter()
			{
			public void windowClosing(WindowEvent e)
				{
				System.exit(1);
				}
			};
		addWindowListener(wndCloser);
		setVisible(true);
		
		}

	public static void main(String args[])
		{
		new z5();
		
		}
	}





