import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener, ActionListener{

	private Panel panel;
	private int fieldsLeft;
	public  int minesLeft;
	
	/**
	* Initialize Frame 		
	*/
	public Frame()
	{ 
	
		setLayout(new BorderLayout());
		this.setTitle("Minesweeper");
		super.setSize(270,270);
			
		panel = new Panel();
		panel.makeMines();
		panel.setNumOfMinesAround();	
		setMouseListener();
		add(panel,BorderLayout.CENTER);	
		minesLeft = 5;

	} // end constructor

	public void setMouseListener(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				Button b = panel.getButton(i,j);
				b.addMouseListener(this);
			}
		}
	}

	//overrides abstract class methods
	public void mousePressed(MouseEvent e)
	{
		
	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

	public void actionPerformed( ActionEvent e )
	{

	}

	/**
	 * Event handler
	 */
	public void mouseClicked(MouseEvent e)
	{
		Button b = (Button)e.getSource();

			if(b.getIsMine()){
				b.setSelected( false );
				b.setColor();		
			}

			if(!b.getIsClicked()){

				if( b.getNumOfMinesAround() == 0 )
					panel.discoverNoMine(b);
			}
			b.leftClick();
	}

	/**
	* Main method to test the frame
    */
	public static void main( String args[] )
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		Frame frame = new Frame();
	
		frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		frame.setVisible( true );
		frame.setResizable( false );
	}



} // end class Painter




