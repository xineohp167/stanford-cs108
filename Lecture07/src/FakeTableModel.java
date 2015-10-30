// FakeTableModel.java

import java.awt.Dimension;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


/*
 FakeTableModel
 A little example of a TableModel that appears to be a 100 x 100
 table of strings like "r2 c3". Except one location,
 which is the string "Surprise!".
 In reality, there is no 2-d data, we just make it up
 in getValueAt().
 Anything that can respond to the TableModel messages appears
 to be a table model.
 Neat example of interfaces in use for modularity.
*/
class FakeTableModel extends AbstractTableModel {
   public static final int SIZE = 100;
   private int surprise;
   
	public FakeTableModel(int surprise) {
		this.surprise = surprise;
	}

	// Basic Model overrides
	public String getColumnName(int col) {
		return("Column " + col);
	}
	public int getColumnCount() { return(SIZE); }
	public int getRowCount() { return(SIZE); }
	
	// Returns a string like "r3c4" for each cell
	public Object getValueAt(int row, int col) {
		return("r" + row + " c" + col);
	}
	
	// Can mess with the data for example if  
	// rwo==col==surprise cell which is "Surprise!"
//	public Object getValueAt(int row, int col) {
//		if (row==surprise && col==surprise) return "Surprise!";
//	    else return("r" + row + " c" + col);
//	}
	
	// False is actually the default, so the following is not necessary...
	//public boolean isCellEditable(int row, int col) { return false; }
	
	static public void main(String[] args) 
	{
		JFrame frame = new JFrame("Fake Table");
		
		// Create a table model
		TableModel model = new FakeTableModel(5);
		
		// Create a table using that model
		JTable table = new JTable(model);
		
		// there are many options for col resize strategy
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// Create a scroll pane in the center, and put
		// the table in it
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(400,400));
		frame.add(scrollpane, BorderLayout.CENTER);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

