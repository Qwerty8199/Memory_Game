package main_game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class opt implements ItemListener  {
	

	String[] icon = {"lego/","animes/","pokemon/"};
	JFrame jopt;
	JComboBox cbox;
	String[] maxcards = {"24","20","16","12"};
	JButton[] opticon;
	String setimage ;
	int setmax;
	JTextField imgpath;
	
	
	opt(){
	jopt = new JFrame("OPTIONS");
	jopt.setSize(600, 600);
	jopt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jopt.setBackground(Color.WHITE);
	jopt.setLayout(null);
	jopt.setVisible(true);
	setmax = 24;
	setimage = "/images/lego/";
	
	JLabel head = new JLabel("OPTIONS");
	head.setBounds(300, 10, 200, 30);
	jopt.add(head);
	
	JLabel maxhead = new JLabel("SELECT THE MAXIMUM NO OF CARDS");
	maxhead.setBounds(10, 50, 400, 30);
	jopt.add(maxhead);
	
	cbox = new JComboBox(maxcards);
	cbox.setBounds(30, 100, 70, 50);
	cbox.addItemListener(this);
	jopt.add(cbox);	
	
	imgpath = new JTextField();
	imgpath.setBounds(150, 450, 250, 50);
	jopt.add(imgpath);
	
	opticon = new JButton[3];
	
	
	for(int i=0; i<3; i++) {
		
		ImageIcon anImage;
		opticon[i] = new JButton();
		opticon[i].setBounds(i*150 ,200, 170, 170);
		
		System.out.println(icon[i]);
		
		URL file = getClass().getResource(
				"/images/"+icon[i]+"img-26.jpg"
			      );

			    if (file == null) {
			     System.err.println(
			       "setImages() reported error \"File not found\".");
			     System.exit(-1);
			    }

			    anImage = new ImageIcon(file);
			    opticon[i].setIcon(anImage);
			    jopt.add(opticon[i]);
	
	}
	
	opticon[0].addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setimage = "/images/lego/";
			imgpath.setText("YOU HAVE SELECTED LEGO");
		}
	});
	
	opticon[1].addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setimage = "/images/animes/";
			imgpath.setText("YOU HAVE SELECTED ANMIES");
		}
	});
	
	opticon[2].addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setimage = "/images/pokemon/";
			imgpath.setText("YOU HAVE SELECTED POKEMON");
		}
	});
	
	JButton setic = new JButton("SET");
	setic.setBounds(200, 500, 80,40);
	jopt.add(setic);
	
	setic.addActionListener(new ActionListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(setimage+"1"+setmax);
			jopt.setVisible(false);
			
			//menu menu = new menu(setimage,setmax);
			jopt.dispose();
			
		}
	});
	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		setmax = Integer.parseInt((String)cbox.getSelectedItem());
				System.out.println("2"+setmax);
	}

	
	public String getimage() {
		
		return setimage;
	}
	
	public int getmax() {
		System.out.println("setmax "+setmax);
		return setmax;
	}


}
