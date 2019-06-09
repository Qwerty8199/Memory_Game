package main_game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class high {

	JFrame jhigh;
	JButton jb;
	JLabel l1;
	JTable jt;
	JButton reset;
	datahand disp;
	JScrollPane sp;
	high(){

		
		jhigh = new JFrame("HIGH SCORE");
		jhigh.setSize(400, 400);
		jhigh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jhigh.setBackground(Color.WHITE);
		jhigh.setLayout(null);
		jhigh.setVisible(true);
		jb = new JButton("BACK");
		
		reset = new JButton("RESET");
		reset.setBounds(100, 300, 80, 50);
		jhigh.add(reset);
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String del = "delete from score";
				PreparedStatement st = null;
				try {
					st = disp.conn.prepareStatement(del);
				} catch (SQLException e2) {

					e2.printStackTrace();
				}
				try {
					st.execute();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				
			}
		});
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("NAME");
		model.addColumn("SCORE");
		model.addColumn("date");
		 JTable table = new JTable(model);
		  table.setBackground(Color.green);
		  
	//	sp = new JScrollPane(table);
	//  table.setPreferredScrollableViewportSize(new Dimension(400,50));
	//	table.setPreferredSize(new Dimension(400,50));
	//	sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
	//	sp.add(table);
		table.setBounds(0,50, 400, 400);
	//	jhigh.add(sp);
		
		jhigh.add(table);
		
		jb.setBounds(0, 0, 80, 30);
		jhigh.add(jb);		
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jhigh.setVisible(false);
				jhigh.dispose();
				
			}
		});
		
		disp = new datahand();
		
		ResultSet rs = null;
		String sql = "select * from score order by high_score desc";
		PreparedStatement st = null;
		try {
			st = disp.conn.prepareStatement(sql);
		} catch (SQLException e2) {

			e2.printStackTrace();
		}
		try {
			rs = st.executeQuery();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		
		model.addRow(new Object[] {"NAME","SCORE","DATE"});
		System.out.println("id\tNAME\tSCORES\tDATE");
		
		try {
			if(!rs.first()) {
				model.addRow(new Object[] {"-","-","-"});
			}
			else {
				model.addRow(new Object[] {rs.getString(2),rs.getInt(3),rs.getDate(4)});
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
			
			try {
				while(rs.next()) {
					model.addRow(new Object[] {rs.getString(2),rs.getInt(3),rs.getDate(4)});
					System.out.println(rs.getString(2)+rs.getInt(3)+rs.getDate(4));
				
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		
		
	}
	
	
}


