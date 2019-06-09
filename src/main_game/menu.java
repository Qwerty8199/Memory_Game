package main_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menu   {
	
	int max ;
	String img;
	


	JFrame jmenu;
	
	menu(){
		img = "/images/pokemon/";
		max = 12;
		initi();
	}
	
	menu(String img,int max){
		img = this.img;
		max = this.max;
		initi();
	}
	
	private void initi(){
		jmenu = new JFrame("Menu");
		jmenu.setSize(600,400);
		jmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jmenu.setBackground(Color.WHITE);
		jmenu.setLayout(new GridLayout(6,1));
		jmenu.setVisible(true);
		
		  
		JButton str = new JButton("START");
		JButton ins = new JButton("INSTRUCTIONS");
		JButton opt = new JButton("OPTIONS");
		JButton high = new JButton("HIGH SCORES");
		JButton exit = new JButton("EXIT");
		
		jmenu.add(str);
		jmenu.add(ins);
		jmenu.add(opt);
		jmenu.add(high);
		jmenu.add(exit);
			
		
		
		str.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new Memory(img,max);
				 
				
			}
		});
		
		ins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame jins;
				JTextArea jlins;
				JButton jlbut;
				
				String inst = "INSTRUCTION\n1.Click on the cards to select it.\n2.If the selected cards are identical u score.\n3.Else keep trying.\n";
				
				  jmenu.setVisible(false);
				
				  jins = new JFrame("INSTRUCTIONS");
				  jins.setSize(600, 600);
				  jins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  jins.setBackground(Color.WHITE);
				  jins.setLayout(null);
				  jins.setVisible(true);
				  
				  jlins = new JTextArea();
				  jlins.setText(inst);
				  
				  jlbut = new JButton("BACK");
				  jlbut.setBounds(0, 0, 80, 30);
				  
				  jlins.setBounds(0,50,550,550);
				  
				  
				  jins.add(jlins);
				  jins.add(jlbut);
				  
				  jlbut.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

							jins.setVisible(false);
							jmenu.setVisible(true);
						}
				  	});	  
				  
			}
		});
		
		high.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jmenu.setVisible(false);
				high hig = new high();
				
				 Thread t = new Thread( new Runnable() {
						
						@Override
						public void run() {
							
							while(hig.jhigh.isVisible()) {
							System.out.println(" ");
							}
							jmenu.setVisible(true);
							
						}
					});
					t.start();		
			}
		});
		
		
		opt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jmenu.setVisible(false);
				int i=0;
				opt opt =  new opt();
				
				  Thread t = new Thread( new Runnable() {
					
					@Override
					public void run() {
						
						while(opt.jopt.isVisible()) {
						System.out.println("");
						}
						jmenu.setVisible(true);
						img = opt.getimage();
						max = opt.getmax();
						
					}
				});
				t.start();
				
				
			}
		});
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jmenu.dispose();
			}
		});		
	}	
}
