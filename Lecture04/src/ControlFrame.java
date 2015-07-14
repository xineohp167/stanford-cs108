/*
 ControlFrame.java
 Demonstrates basic use of JCheckBox and JSlider
 */
import javax.swing.*;

import java.awt.*;

public class ControlFrame extends JFrame {
	// keep ivars pointing to on-screen objects that
	// we want to access later
	private JPanel panel;
	private JCheckBox checkbox;
	private JLabel label;
	private JSlider slider;


	// Set up the frame -- create and install some controls in the frame
	public ControlFrame(String title) {
		super(title);	// superclass ctor takes frame title

		// Get content pane -- contents of the window
		JComponent content = (JComponent) getContentPane();

		// Set to use the "flow" layout
		// (controls the arrangement of the components in the content)
		content.setLayout(new FlowLayout());

		// ****
		// Set up controls in the frame
		// ****

		// Create a vertical box component
		JComponent box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		content.add(box);


		// make a little panel to group a couple things
		panel = new JPanel();

		// install the panel
		box.add(panel);

		// put a label in the panel
		panel.add(new JLabel("Left Label"));

		// put a checkbox in the panel
		checkbox = new JCheckBox("Panic Mode");
		panel.add(checkbox);

		box.add(Box.createVerticalStrut(20)); // 20 pixels vertical space

		// put some things in the box
		box.add(new JLabel("Speed:"));

		// slider has min, max, and current int values
		slider = new JSlider(0, 100, 50); // min, max, current
		box.add(slider);

		box.add(Box.createVerticalStrut(20));
		box.add(new JLabel("Bottom Label"));

		// later, access the control's state with:
		// (boolean) checkbox.isSelected()
		// (int) slider.getValue()

		// ****
		// Done installing controls
		// ****

		// Standard three lines to put frame on screen
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);   // make it show up on screen
	}

	public static void main(String[] args) {
		// Set GUI Look And Feel Boilerplate.
		// Do this incantation at the start of main() to tell Swing
		// to use the GUI LookAndFeel of the native platform. It's ok
		// to ignore the exception.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) { }

		new ControlFrame("Control Frame");
	}
}
