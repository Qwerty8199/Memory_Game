package main_game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class Memory extends JFrame {


 private static final long serialVersionUID = 1L;


 public Board mBoard;
 private JButton mRetryButton;
 private JButton mNewButton;
 private JSplitPane mSplitPane;


 public Memory(String img,int max) {

  super();

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBackground(Color.WHITE);
  mBoard = new Board(img,max);
  add(mBoard, BorderLayout.CENTER);

  mSplitPane = new JSplitPane();
  add(mSplitPane, BorderLayout.SOUTH);

  mNewButton = new JButton("New Game"); 
  mNewButton.setFocusPainted(false);
  mNewButton.addMouseListener(btnMouseListener);
  mSplitPane.setLeftComponent(mNewButton);

  mRetryButton = new JButton("Retry");
  mRetryButton.setFocusPainted(false);
  mRetryButton.addMouseListener(btnMouseListener);
  mSplitPane.setRightComponent(mRetryButton);


  pack();
  setResizable(true);
  setVisible(true);

 }


private MouseListener btnMouseListener = new MouseAdapter() {
  public void mouseClicked(MouseEvent e) {
   if (e.getClickCount() == 1 && e.getComponent() == mRetryButton) {
    mBoard.reInit();
   } else if (e.getClickCount() == 1 && e.getComponent() == mNewButton) {
    dispose();
   }
  }
 };


}
