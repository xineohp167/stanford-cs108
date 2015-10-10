import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TwoWayConverterAnonymous extends JFrame {
	
	JTextField dollarField;
	JTextField poundField;
	
	public TwoWayConverterAnonymous() {
		dollarField = new JTextField(8);
		poundField = new JTextField(8);
		
		JLabel dollarLabel = new JLabel("Dollars ($)");
		JLabel poundLabel = new JLabel("<html>Pounds (&pound;)</html>");
		
		JButton convertToPoundsBtn = new JButton("Convert to Pounds");
		convertToPoundsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double dollars = Double.valueOf(dollarField.getText());
				poundField.setText(Double.toString(dollars * 0.731421884));
			}
		});

		JButton convertToDollarsBtn = new JButton("Convert to Dollars");
		convertToDollarsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double pounds = Double.valueOf(poundField.getText());
				dollarField.setText(Double.toString(pounds * 1.367));
			}
		});

		add(dollarLabel);
		add(dollarField);
		add(poundLabel);
		add(poundField);
		add(convertToPoundsBtn);
		add(convertToDollarsBtn);
	}
	
	public static void main(String[] args) {
		JFrame frame = new TwoWayConverterAnonymous();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.pack();
		frame.setVisible(true);		
	}
}
