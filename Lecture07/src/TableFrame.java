// TableFrame.java
/*
 Demonstrate a couple tables using one table model.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class TableFrame extends JFrame {
	private BasicTableModel model;

	private JTable table;
	private JTable table2;
	
	JButton columnButton;
	JButton rowButton;
	JButton deleteButton;
	JButton loadButton;
	JButton saveButton;
	JComponent content;
		
	public TableFrame(String title, File file) {
		super(title);
		
		// Create a table model
		model = new BasicTableModel();
		
		// Create a table using that model
		table = new JTable(model);
		
		// there are many options for col resize strategy
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// JTable.AUTO_RESIZE_OFF
		
		// Create a scroll pane in the center, and put
		// the table in it
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(300,200));
		add(scrollpane, BorderLayout.CENTER);
		
		// Create a second table using the same model, and put in the south
		table2 = new JTable(model);
		scrollpane = new JScrollPane(table2);
		scrollpane.setPreferredSize(new Dimension(300,200));
		add(scrollpane, BorderLayout.SOUTH);
		
		if (file!=null) model.loadFile(file);
		
		// Create a bunch of controls in a box
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel, BorderLayout.EAST);

		rowButton = new JButton("Add Row");
		panel.add(rowButton);
		rowButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = model.addRow();
					table.clearSelection();
					table.addRowSelectionInterval(i, i);
				}
			}
		);
		
		
		columnButton = new JButton("Add Column");
		panel.add(columnButton);
		columnButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String result = JOptionPane.showInputDialog("What name for the new column?");
					if (result != null) {
						model.addColumn(result);
					}
				}
			}
		);
		
		deleteButton = new JButton("Delete Row");
		panel.add(deleteButton);
		deleteButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					if (row!=-1) model.deleteRow(row);
				}
			}
		);		
		
		loadButton = new JButton("Load File");
		panel.add(loadButton);
		loadButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					// This sets the file chooser to use the current directory --
					// surely there should be an easier way to do this!
					try {
						chooser.setCurrentDirectory(new File(".").getCanonicalFile());
					} catch (IOException ignored) { }
					int status = chooser.showOpenDialog(TableFrame.this);
					if (status == JFileChooser.APPROVE_OPTION) {
						model.loadFile(chooser.getSelectedFile());
					}
				}
			}
		);
		
		saveButton = new JButton("Save File");
		panel.add(saveButton);
		saveButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					int status = chooser.showSaveDialog(TableFrame.this);
					if (status == JFileChooser.APPROVE_OPTION) {
						model.saveToFile(chooser.getSelectedFile());
					}
				}
			}
		);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	
	static public void main(String[] args) 
	{
		new TableFrame("TableFrame", new File("test.txt"));
	}
}


/*

		
		
		//searchPanel = new Box(BoxLayout.Y_AXIS);
		
		searchPanel = Box.createVerticalBox();
		container.add(searchPanel, BorderLayout.SOUTH);
		
		searchToggle = new JCheckBox("Filter View");
		searchPanel.add(searchToggle);
		
		
		
		searchToggle.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setSearch(searchScroll == null);
				}
			}
		);
		*/
	/*
	private void setSearch(boolean enable) {
		if (enable) {
			searchText.setEnabled(true);
			searchTable = new JTable(new FilteredDBModel(db, searchText));
			searchTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			searchScroll = new JScrollPane(searchTable);
			searchScroll.setPreferredSize(new Dimension(300,100));
			
			searchPanel.add(searchScroll);
		}
		else {
			searchText.setEnabled(false);
			searchPanel.remove(searchScroll);
			searchScroll = null;
		}
		container.revalidate();
		//pack();
	}
	*/		

