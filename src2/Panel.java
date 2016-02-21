import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Panel extends JPanel{

	final private int numOfMines = 10;
    private int fieldsLeft = 10;
	private int rows;
	private int cols;
	
	private Button [][]buttons = new Button[10][10];
 	/**
	* Initialize Panel 		
	*/
	Panel(){

		rows = 10;
		cols = 10;

		setLayout (new GridLayout( rows, cols, 1, 1 ) );

		for(int i = 0 ; i < rows; i++ ){
			for(int j = 0 ; j < cols; j++){
				//make button
				buttons[i][j] = new Button(i, j);				
				//add it to panel
				add(buttons[i][j]);
			}
		}
		
	}// end constructor

	/**
	* Get button
	*/
	Button getButton(int x, int y){
		return buttons[x][y];
	}

	/**
	* Returns random generated number
	* @param min value
	* @param max value. Must be greater than min.
	* @return integer between min and max, inclusive.
	*/
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	/** 
	* Method that makes mines
	* @param void 
	* @return void
	*/
	public void makeMines()
	{	
		
		int x; //random x coordinate
		int y; //random y coordinate

		for(int i = 0; i < numOfMines; i++ ){

			x = randInt(0,rows-1);
			y = randInt(0,cols-1);
			if( !buttons[x][y].getIsMine() && !buttons[x][y].isSelected() )
				buttons[x][y].setIsMine();
			else
				i--; 
		}
			
  	}// end Mines

  	/**
  	* Method that sets for each button the number of mines around
  	* It goes around the 2D array and for each button sets the 
  	* w,s,n,e,ne,nw,se,sw  
	* @param void 
	* @return void
	*/
  	public void setNumOfMinesAround(){

		for(int i = 0; i < rows; i++ ){
			for(int j = 0; j < cols; j++){
				// go in all directions and set number of mines around
				if( buttons[i][j].getIsMine() ){
					// go north
					if( (i - 1 >= 0) && (j >= 0) ){
						buttons[i - 1][j].setNumOfMinesAround();
					}
					// go north east
					if( (i - 1 >= 0) && (j + 1 < cols) ){
						buttons[i - 1][j + 1].setNumOfMinesAround();
					}
					// go east
					if( (j + 1 < cols) && (i >= 0) ){
						buttons[i][j + 1].setNumOfMinesAround();
					}
					// go south east
					if( (i + 1 < rows) && (j + 1 < cols) ){
						buttons[i + 1][j + 1].setNumOfMinesAround();
					}
					// go south
					if(  (j >= 0) && (i + 1 < rows) ){
						buttons[i + 1][j].setNumOfMinesAround();
					}
					// go south west
					if( (i + 1 < rows) && (j - 1 >= 0) ){
						buttons[i + 1][j - 1].setNumOfMinesAround();
					}
					// go west
					if( (i >= 0) && (j - 1 >= 0) ){
						buttons[i][j - 1].setNumOfMinesAround();
					}
					// go north west
					if( (i - 1 >= 0) && (j - 1 >= 0 ) ){
						buttons[i-1][j-1].setNumOfMinesAround();
					}
				}// end if
			}// end inner for
		}// end outer for

 	}// end setNumMinesAround


	/**
	* Goes trough all the buttons that have no mines around them 
	* and clicks them
	*/
	private void checkForMine(int x, int y)
	{
		//if button is not clicked
		if(!buttons[x][y].getIsClicked() )
		{
			buttons[x][y].leftClick();

			if(buttons[x][y].getNumOfMinesAround() == 0)
			{
				checkForMine(x - 1, y - 1);
				checkForMine(x, y - 1);
				checkForMine(x + 1, y - 1);
				checkForMine(x - 1, y);
				checkForMine(x + 1, y);
				checkForMine(x - 1, y + 1);
				checkForMine(x, y + 1);
				checkForMine(x + 1, y + 1);
			}
		}
	}

	/**
	* Shows all adjacent fields that have no mines
	* Wrapper to a recursive method checkForMine
	*/
	public void discoverNoMine(Button  b){
		int x = b.getXcoordiantes();
		int y = b.getYcoordinates();

		checkForMine(y,x);
	}
	
}// end class