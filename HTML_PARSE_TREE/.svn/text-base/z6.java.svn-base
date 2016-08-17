import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class z6 extends JFrame
	{
		
	String ufn;
	public z6(String ufnc)  // String ufnc
		{
		super(" PHASE II  ");
		setBounds(150,150,770,480);
		
		JPanel mk61 = new JPanel();
		mk61.setLayout(new BoxLayout(mk61,BoxLayout.X_AXIS));
		
		JPanel mk611 = new JPanel();
		mk611.setBorder(new EmptyBorder(10,10,10,10));

		JPanel mk6111 = new JPanel();
		mk6111.setLayout(new GridLayout(6,1,5,5));

		mk6111.add(new JLabel("DATA DEFINITION MODULE"));
		mk6111.add(new JLabel("      ** Building the Definitions that will be used to Parse the page"));
		mk6111.add(new JLabel("PARSER MODULE "));
		mk6111.add(new JLabel("      ** Dividing the Data into Records & Fields" ));

		mk6111.add(new JLabel("DATA EXTRACTION MODULE "));
		mk6111.add(new JLabel("      ** Creates the output in Table format" ));
		
		mk611.setLayout(new BorderLayout());
		mk611.add(mk6111, BorderLayout.WEST);
		mk61.add(mk611);
		
		JPanel mk612 = new JPanel();
		mk612.setLayout(new BoxLayout(mk612,BoxLayout.Y_AXIS));
		mk612.setBorder(new TitledBorder(new LineBorder(Color.black,2),"  User Options  "));
		

		ButtonGroup bg = new ButtonGroup();
		final JRadioButton r1 = new JRadioButton("Source Code  ");
		final JRadioButton r2 = new JRadioButton("Screened HTML Page  ");
		final JRadioButton r3 = new JRadioButton("Tag Tree  ");
		final JRadioButton r4 = new JRadioButton("Processed Tag Tree  ");
		final JRadioButton r5 = new JRadioButton("Result  ");
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		bg.add(r5);
		
		mk612.add(r1);
		mk612.add(r2);
		mk612.add(r3);
		mk612.add(r4);
		mk612.add(r5);
		
		
		mk61.add(mk612);
		getContentPane().add(mk61,BorderLayout.NORTH);


		JPanel mk62 = new JPanel();
		mk62.setBorder(new TitledBorder(new LineBorder(Color.black,2),"  Result  "));
		final JTextArea res = new JTextArea();
		Dimension ressze = new Dimension(580,190);
		JScrollPane ps = new JScrollPane(res);
		ps.setPreferredSize(ressze);
		mk62.add(ps,BorderLayout.CENTER);
		getContentPane().add(mk62, BorderLayout.CENTER);

		JPanel mk63 = new JPanel();
		JPanel mk631 = new JPanel();
		mk63.setLayout(new GridLayout(1,2,5,5));
		
		final JButton b1 = new JButton(" View Result ");
		mk631.add(b1);
		final JButton b2 = new JButton(" Next ");
		mk631.add(b2);
		mk631.add(new JLabel("           "));
		final JButton b3 = new JButton(" Abt Modules ");
		mk631.add(b3);
		final JButton b4 = new JButton(" Abt User Options ");
		mk631.add(b4);

		mk63.add(mk631);
		getContentPane().add(mk63, BorderLayout.SOUTH);
		
		ufn=ufnc;
		//ufn="899.html";
		
		b1.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				{
				String dprs="";
				if(r1.isSelected())
					{
						try
						{
						byte bb[] = new byte[80000];
						FileInputStream fr1 = new FileInputStream(ufn);
						int tem = fr1.read(bb,0,80000);
						String scd=new String(bb,0,tem,"Default");
     						dprs = scd;
						}
						catch( Exception e)     { }
					}
					
									
				else if(r2.isSelected())
					{
                                               
						try
						{
						zz2 p=new zz2();
						zz2.fr=new FileReader(ufn);
 						FileWriter fw=new FileWriter("mk27_1.txt");
  						zz2.fw2=new FileWriter("mk27_2.txt");
						
  						String res=""; 
  						String tag="";
		
 
  						do
  						{
     						tag=p.gettag();
    						fw.write(zz2.data);
    						res+=zz2.data+"\r\n";
    						fw.write("\r\n");
    						fw.write(p.tag1);
     						res+=p.tag1+"\r";
    						fw.write("\r\n");
   
  						}while(!tag.equals("end of file"));
  						fw.close();
  						zz2.fw2.close();
  						zz2.fr.close();
						dprs=res;
						}
						catch( Exception e)     { }
					}



				else if(r3.isSelected())	
					{
						
						try
						{
						project ob6z3 = new project();
						ob6z3.tagtree();
						byte bb[] = new byte[80000];
						FileInputStream fr1 = new FileInputStream("f.txt");
						int tem = fr1.read(bb,0,80000);
						String scd=new String(bb,0,tem,"Default");
     						dprs = scd;
						}
						catch( Exception e)     { }
						
					}
				else if(r4.isSelected())
					{
						try
						{
						byte bb[] = new byte[80000];
						FileInputStream fr1 = new FileInputStream("h.txt");
						int tem = fr1.read(bb,0,80000);
						String scd=new String(bb,0,tem,"Default");
     						dprs = scd;
						}
						catch( Exception e)     { }
					}
				else if(r5.isSelected())
					{
						try
						{
						byte bb[] = new byte[80000];
						FileInputStream fr1 = new FileInputStream("a.txt");
						int tem = fr1.read(bb,0,80000);
						String scd=new String(bb,0,tem,"Default");
     						dprs = scd;
						}
						catch( Exception e)     { }
					}
				else JOptionPane.showMessageDialog(null,"Select any one of the User option","E r r o r ",2);
               			res.setText(dprs);
				}
			});
		
		b2.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				 {
               			z7 ob67 = new z7();
				ob67.setVisible(true);
				setVisible(false);
				}
			});
		b3.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				 {
               			z8 ob68 = new z8();
				ob68.setVisible(true);
				setVisible(false);
				}
			});
		b4.addActionListener(new java.awt.event.ActionListener()
			 {
            		public void actionPerformed(java.awt.event.ActionEvent evt)
				 {
               			z9 ob69 = new z9();
				ob69.setVisible(true);
				setVisible(false);
				}
			});
		
		setVisible(true);
		}

	public static void main(String args[])
		{
		//new z6();
		}
	}





