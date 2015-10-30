import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


public class NoFiringTableModel extends AbstractTableModel {
	private String[] colNames;	// defines the number of cols
	private Object[][] data;	// one List for each row
	
	public NoFiringTableModel(String[] headers,Object[][] tabledata) {
		colNames = headers;
		data = tabledata;
	}

	// Returns the number of columns
	public int getColumnCount() {
		return(colNames.length);
	}
	
	// Returns the number of rows
	public int getRowCount() {
		return(data.length);
	}
	
	// Returns the data for each cell, identified by its
	// row, col index.
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public boolean isCellEditable(int row, int col) {
		return true;
	}

	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object[][] data = {{1,2,3},{4,5,6},{7,8,9}};
		String[] labels = {"Alpha","Beta","Gamma"};
		
		TableModel model = new NoFiringTableModel(labels,data);
		
		JTable t = new JTable(model);
		JTable t2 = new JTable(t.getModel());
		
		f.setLayout(new BorderLayout());
		
		JScrollPane sc = new JScrollPane(t);
		f.add(sc);
		
		JScrollPane sc2 = new JScrollPane(t2);
		f.add(sc2,BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}	
}
