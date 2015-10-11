// LookNFeel.java
/*
 Demonstrates changing the look and feel of a Swing app
 from Stanford CS193J
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;



public class LookNFeel extends JFrame {
	
	public LookNFeel() {
		
		super("LookNFeel");
		JComponent content = (JComponent) getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		
		// Get a list of the lnfs
		UIManager.LookAndFeelInfo[] looks = UIManager
				.getInstalledLookAndFeels();
		
		// Use a hash to map button pointers to lnf class names
		final HashMap map = new HashMap();
		final ActionListener lookListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the lnf name from the hash
				String look = (String) map.get(e.getSource());
				try {
					// set the lnf
					UIManager.setLookAndFeel(look);
					// Need to do this to change an on-screen window
					SwingUtilities.updateComponentTreeUI(LookNFeel.this);
				} catch (Exception ignored) {
				}
			}
		};
		
		// For each look, create a button and put an entry
		// in the hashmap button->lnf-class
		for (int i = 0; i < looks.length; i++) {
			JButton button = new JButton(looks[i].getName());
			button.addActionListener(lookListener);
			content.add(button);
			map.put(button, looks[i].getClassName());
		}
		
		// Put some junk in the window
		content.add(new JCheckBox("Cloaking Device"));
		content.add(new JTextField(10));
		content.add(new JLabel("Speed:"));
		content.add(new JSlider(0, 100, 20));
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// Workaround for OSX bug where the content acts
		// like its minimum size is its preferred size
		// content.setMinimumSize(new Dimension(100, 100));
	}

	public static void main(String[] args) {
		new LookNFeel();
	}
}
