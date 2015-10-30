import javax.swing.*;
import java.awt.*;

public class SimpleTable {
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object[][] data = {{"Leland",4,true},{"Stanford",5,false},{"Junior",6,true}};
		Object[] labels = {"Able","Baker","Charlie"};
		JTable t = new JTable(data,labels);
		
	// Approach One, use a JScrollPane
		JScrollPane sp = new JScrollPane(t);
			// IMPORTANT create a JScrollPane using the table
		
		// add in the following messiness if you want JScrollPane sized for the table
		// Dimension sz = t.getPreferredSize();
		// Dimension headerSz = t.getTableHeader().getPreferredSize();
		// sp.setPreferredSize(new Dimension(sz.width,sz.height + headerSz.height));

		f.add(sp);
		
	// Approach Two, manually retrieve and place header
//		f.setLayout(new BorderLayout());
//		f.add(t.getTableHeader(),BorderLayout.NORTH);
//		f.add(t,BorderLayout.CENTER);
		
		f.pack();
		f.setVisible(true);
	}
}
