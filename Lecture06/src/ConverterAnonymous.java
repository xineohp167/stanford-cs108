import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

// here an anonymous class is used to act as the Action Listener

public class ConverterAnonymous extends JFrame {
	
	JTextField dollarField;
	JTextField poundField;
	
	public ConverterAnonymous() {
		dollarField = new JTextField(8);
		poundField = new JTextField(8);
		
		JLabel dollarLabel = new JLabel("Dollars ($)");
		JLabel poundLabel = new JLabel("<html>Pounds (&pound;)</html>");
		
		JButton convertBtn = new JButton("Convert");
		convertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double dollars = Double.valueOf(dollarField.getText());
				poundField.setText(Double.toString(dollars * 0.731421884));
			}
		});
		
		add(dollarLabel);
		add(dollarField);
		add(poundLabel);
		add(poundField);
		add(convertBtn);
	}

	public static void main(String[] args) {
		JFrame frame = new ConverterAnonymous();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.pack();
		frame.setVisible(true);		
	}
}
