import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;

public class TextExampleFancy {
	
	public static void main(String[] args) {
		JTextField field1 = new JTextField(20);
		JTextField field2 = new JTextField(20);
		
		final JTextField infoField = new JTextField(15);
		
		field2.setDocument(field1.getDocument());
		
		Document doc = field1.getDocument();
		field2.setDocument(doc);
		
		doc.addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				infoField.setText("Changed");
			}

			public void insertUpdate(DocumentEvent e) {
				infoField.setText("Inserted");
			}

			public void removeUpdate(DocumentEvent e) {
				infoField.setText("Removed");
			}
			
		});
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.add(field1);
		f.add(field2);
		f.add(new JLabel("Operation:"));
		f.add(infoField);
		f.pack();
		f.setVisible(true);
	}

}
