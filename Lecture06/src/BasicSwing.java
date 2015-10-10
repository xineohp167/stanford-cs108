import javax.swing.*;
import java.awt.*;

public class BasicSwing extends JFrame {
	
	public static void main(String[] args) {
		JFrame theFrame = new JFrame("Swing Example");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new FlowLayout());
		
		theFrame.add(new JLabel("Hello World."));
		theFrame.add(new JTextField(15));
		theFrame.add(new JSlider(JSlider.HORIZONTAL,0,100,50));
		theFrame.add(new JButton("ok"));
		
		theFrame.pack();
		theFrame.setVisible(true);
		
	}
}
