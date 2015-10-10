import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class TwoWayConverterMultiway extends JFrame implements ActionListener {
	
	JTextField dollarField;
	JTextField poundField;
	
	JButton convertToPoundsBtn;
	JButton convertToDollarsBtn;
	
	public TwoWayConverterMultiway() {
		JMenuBar menuBar = new JMenuBar();
		JMenu convertMenu = new JMenu("Convert");
		JMenuItem toPoundsItem = new JMenuItem("To Pounds");
		toPoundsItem.addActionListener(this);
		JMenuItem toDollarsItem = new JMenuItem("To Dollars");
		toDollarsItem.addActionListener(this);
		
		convertMenu.add(toPoundsItem);
		convertMenu.add(toDollarsItem);
		
		menuBar.add(convertMenu);
		
		setJMenuBar(menuBar);
		
		dollarField = new JTextField(8);
		poundField = new JTextField(8);
		
		JLabel dollarLabel = new JLabel("Dollars ($)");
		JLabel poundLabel = new JLabel("<html>Pounds (&pound;)</html>");
		
		convertToPoundsBtn = new JButton("Convert to Pounds");
		convertToPoundsBtn.setActionCommand("To Pounds");
		convertToPoundsBtn.addActionListener(this);
		
		convertToDollarsBtn = new JButton("Convert to Dollars");
		convertToDollarsBtn.setActionCommand("To Dollars");
		convertToDollarsBtn.addActionListener(this);
		
		add(dollarLabel);
		add(dollarField);
		add(poundLabel);
		add(poundField);
		add(convertToPoundsBtn);
		add(convertToDollarsBtn);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("To Pounds")) {
			Double dollars = Double.valueOf(dollarField.getText());
			poundField.setText(Double.toString(dollars * 0.7314));
		} else {
			Double pounds = Double.valueOf(poundField.getText());
			dollarField.setText(Double.toString(pounds * 1.367));
		}		
	}	

	public static void main(String[] args) {
		JFrame frame = new TwoWayConverterMultiway();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.pack();
		frame.setVisible(true);
	}
}
