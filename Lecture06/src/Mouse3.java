import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse3 extends JFrame {
	
	JTextField xField, yField;
	
	public Mouse3() {
		xField = new JTextField(5);
		yField = new JTextField(5);
		
		add(new JLabel("X:"));
		add(xField);
		add(new JLabel("Y:"));
		add(yField);
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				xField.setText(e.getX() + "");
				yField.setText(e.getY() + "");
			}						
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				System.out.println("(" + e.getX() + "," + e.getY() + ")");
			}						
		});
		
		setLayout(new FlowLayout());
	}
	
	public static void main(String[] args) {
		JFrame frame = new Mouse3();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
