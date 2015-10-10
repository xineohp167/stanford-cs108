import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SimpleSetup extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new Converter();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JTextField dollarField = new JTextField(8);
		JTextField poundField = new JTextField(8);
		
		JLabel dollarLabel = new JLabel("Dollars ($)");
		JLabel poundLabel = new JLabel("<html>Pounds (&pound;)</html>");
		
		JButton convertBtn = new JButton("Convert");
		
		frame.add(dollarLabel);
		frame.add(dollarField);
		frame.add(poundLabel);
		frame.add(poundField);
		frame.add(convertBtn);
		
		frame.pack();
		frame.setVisible(true);		
	}
}
