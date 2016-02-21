import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
* Class Button.
* Describes one button
*/
public class Button extends JToggleButton{
	
	final private int SIZE = 20;                 // size of square
	private int x; 								 // x position
	private int y;                               // y position
	private int borders;						 // border	 
	private Dimension dimension;				 // dimension object
	private Insets margin;                       // inset object
	private boolean focus;                       // boolean focus
	private int numOfMinesAround; 				 // number of mines around
	private boolean isMine;						 // if the button is mine
	private boolean isClicked;					 // if button is clicked
	private String flag;						 // flag
	private boolean isFlagSet;					 // is the flag set	  

	public Button( String str)
	{
		super.setText( str );
	}

	/**
	* Initialize Button from outside
	* Set location in the field, sets size and insets
	*/
	public Button(int x, int y)
	{
		borders = 1;
		focus = false;
		dimension = new Dimension(SIZE,SIZE);
		margin = new Insets(borders,borders,borders,borders);

		this.x = x;
		this.y = y;

		this.isMine = false;
		this.numOfMinesAround = 0;             // initial number of mines around is 0
		this.isClicked = false;                 // initial button is not clicked
		this.flag = "";                        // types of flags
		this.isFlagSet = false; 
		this.setLayout( new FlowLayout() );
		this.setPreferredSize(dimension);
		this.setMargin(margin);
		this.setFocusPainted(focus);
	}// end constructor	

	/** 
	* Accessor method
	* @param void 
	* @return int x position
	*/
	public int getXcoordiantes(){ 
		return this.x;
	}

	/** 
	* Accessor method
	* @param void 
	* @return int y position
	*/
	public int getYcoordinates(){
		return this.y;
	}

	/** 
	* Accessor method
	* @param void 
	* @return true if the button is mine
	*/
	boolean getIsMine(){
		return isMine;
	}

	/** 
	* Mutator method
	* @param bollean 
	* @return void
	*/
	void setIsMine(){
		this.isMine = true;
	}

	/**
	* Accessor method
	* @param void
	* @return number of mines around
	*/
	public int getNumOfMinesAround(){
		return this.numOfMinesAround;
	}

	/** 
	* Mutator method
	* @param void
	* @return void
	*/
	public void setNumOfMinesAround(){
		numOfMinesAround++;
	}

	/** 
	* Accessor method
	* @param void 
	* @return string flag
	*/
	public String getFlag(){
		return flag;
	}	

	/** 
	* Mutator method
	* @param string flag 
	* @return string flag
	*/
	public void setFlag(){
		this.flag = flag;
	}

	/** 
	* Mutator method
	* @param boolean
	* @return string flag
	*/
	public void setIsClicked(boolean t){
		this.isClicked = t;
		this.setEnabled(false);
	}

	/** 
	* Accessor method
	* @param void 
	* @return boolean 
	*/
	public boolean getIsClicked(){
		return this.isClicked;
	}
	
	/**
	* Left Click 
	*/
	public void leftClick()
	{
		if(isClicked){
			setSelected( true );
			return;
		}

		setSelected( true );
		isClicked = true;
		setText("" + numOfMinesAround);
	}

	/**
	* Set red color to recognize bomb
	* Debugging purposes
	*/
	public void setColor(){
		this.setForeground(Color.RED);
	}

	/*
	* Debug
	*/
	public void printButton(){
		System.out.println("(" + getXcoordiantes() + "," + getYcoordinates() + ")" );
	}

};// end class Button