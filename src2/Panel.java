import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Panel extends JPanel{

	private Square [][]squares = new Square[10][10];
	private JPanel field;

	public Panel()
	{
	   /**
		* 
		*
		*/
		setLayout(new GridLayout(10,10,1,1)); // set frame layout

		Container contPane = getContentPane();
		getContentPane().setLayout( new BorderLayout() );
		getContentPane().add( field, BorderLayout.CENTER );
		int i, j;
		
		// double loop that crates a minefield made of squares of type Square
		for( i = 0 ; i < 10 ; i++ )
			for( j = 0 ; j < 10 ; j++)
			{
				squares[i][j] = new Square( i, j );
			//	squares[i][j].addMouseListener( this );
				add(squares[i][j]);
			}		
	} // end constructor

	public static void main( String[] args )
	{
		// create JFrame
		JFrame application = new JFrame( "Test" );
		application.setSize( (int)(21 * 10) - 11 , (int)(21.5 * 10) + 83 );
		Panel panel = new Panel(); // create paint panel
		application.add(panel);
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		application.setSize( 200, 400 ); // set frame size
		application.setVisible( true ); // display frame
	} //	 end main
} // end class Painter




