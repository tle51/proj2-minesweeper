import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Class Square.
 * Describes one square
 */
public class Square extends JToggleButton{
	
	final private int SIZE = 20;                 //size of square
	private int x; 								 // x position
	private int y;                               // y position
	private int borders;						 // border	 
	private Dimension dimension;				 // dimension object
	private Insets margin;                       // inset object
	private boolean focus;                       // boolean focus

	/**
	 * Constructor sets the size, insets and notes the location in the minefield
	 */
	public Square(int x, int y)
	{
		borders = 10;
		focus = false;
		dimension = new Dimension(SIZE,SIZE);
		margin = new Insets(borders,borders,borders,borders);

		this.x = x;
		this.y = y;
		this.setLayout( new FlowLayout() );
		this.setPreferredSize(dimension);
		this.setMargin(margin);
		this.setFocusPainted(focus);
	
	}	

	/* tester*/
	public static void main(String args[])
	{

		//Square square = new Square(10,10);
	}
};// end class Square