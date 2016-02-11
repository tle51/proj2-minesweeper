import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Test Class to test Square
 *
 */
public class Test extends JFrame{

	private Square [][]squares = new Square[10][10];

	//constructor
	public Test()
	{
		super("Testing square");
		setLayout(new FlowLayout()); // set frame layout
		int i, j;
		
		// double loop that crates a minefield made of squares of type Square
		for( i = 0 ; i < 10 ; i++ )
			for( j = 0 ; j < 10 ; j++)
			{
				squares[i][j] = new Square( i, j );
			//	squares[i][j].addMouseListener( this );
				add(squares[i][j]);
			}		
		//TestHandler handler = new TestHandler();
		//square.addActionListener(handler);		
	}

	// private inner class for event handling
	private class TestHandler implements ActionListener
	{
		// process  events
		public void actionPerformed(ActionEvent event)
		{
		//	if (event.getSource() == square)
		//		JOptionPane.showMessageDialog(null, "Lololo");
		}
	}

	public static void main( String[] args )
	{
		
		Test t = new Test();


		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setSize(200,400); // set frame size
		t.setVisible(true); // display frame
		
	} // end main
   
}
