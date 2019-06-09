package main_game;

import javax.swing.JButton;

public class Cell extends JButton {


 private static final String TAG = "Cell: ";
 

 private static final long serialVersionUID = 1L;
 

 private static final int MAX_TYPE_RANGE = 26;
 private static final int MIN_TYPE_RANGE = 0;
 private static final int EMPTY_CELL_TYPE = 25;
 

 private boolean mIsSelected = false;
 private boolean mIsMatched = false;
 private int mType = EMPTY_CELL_TYPE;


 /**
  * Creates a cell of the specified type.
  */
 public Cell(int aType) {
  super();
  mType = aType;
 }


 /**
  * This method gets the type of the cell
  * 
  * @return an int value that represents a specific 
  * card, an empty cell place or a card that is currently hidden.
  */
 public int getType() {

  return mType;
 }


 public void setType(int aType) {
  if (aType > MAX_TYPE_RANGE || aType < MIN_TYPE_RANGE){
   error("setType(int) reported \"Invalid type code\"", true);
  }
  mType = aType;
 }


 public boolean sameType(Cell other) {

  if (other == null) {
   error("sameType(Cell) received null", false);
   return false;
  }

  if (this.getType() == other.getType()) {
   return true;
  } else {
   return false;
  }
 }


 public boolean isEmpty() {
  if (this.mType != EMPTY_CELL_TYPE) {
   return false;
  }
  return true;
 }

 
 public void setSelected(boolean selected) {

  mIsSelected = selected;
 }


 public void setMatched(boolean matched) {

  mIsMatched = matched;
 }


 public boolean isSelected() {

  if (mIsSelected == true) {
   return true;
  }

  return false;
 }


 public boolean isMatched() {

  if (mIsMatched == true) {
   return true;
  } else {
   return false;
  }
 }
 

 private static void error( String message, boolean crash ){
  System.err.println( TAG + message );
  if (crash) System.exit(-1);
 }

}
