import javax.swing.*;
import java.awt.*;

public class TextExample {
	
	public static void main(String[] args) {
		JTextField field1 = new JTextField(20);
		JTextField field2 = new JTextField(20);
		
		field2.setDocument(field1.getDocument());
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.add(field1);
		f.add(field2);
		f.pack();
		f.setVisible(true);
	}

}
