import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;


public class SimpleTableModel extends AbstractTableModel {
	
	private String[] colNames;	// defines the number of cols
	private Object[][] data;	// one List for each row
	
	public SimpleTableModel(String[] headers,Object[][] tabledata) {
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
	
	// This one is actually not needed for a minimal TableModel
	// based on AbstractTableModel, but without it, your columns
	// will be labeled A, B, C, D
//	public String getColumnName(int col) {
//		return colNames[col];
//	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object[][] data = {{"Leland",4,true},{"Stanford",5,false},{"Junior",6,true}};
		String[] labels = {"Able","Baker","Charlie"};
		
		TableModel model = new SimpleTableModel(labels,data);
		JTable t = new JTable(model);
		
		JScrollPane sp = new JScrollPane(t);
		f.add(sp);
				
		f.pack();
		f.setVisible(true);
	}

}
