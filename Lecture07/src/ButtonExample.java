import javax.swing.*;
import java.awt.*;

public class ButtonExample {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		JMenu exampleMenu = new JMenu("Example");
		menubar.add(exampleMenu);
		JMenuItem coolMenuItem = new JCheckBoxMenuItem("Cool");
		exampleMenu.add(coolMenuItem);
		
		ButtonModel coolModel = coolMenuItem.getModel();
		
		JCheckBox coolBox = new JCheckBox();
		coolBox.setModel(coolModel);
		
		f.setLayout(new FlowLayout());
		f.setJMenuBar(menubar);
		f.add(new JLabel("Cool:"));
		f.add(coolBox);
		f.pack();
		f.setVisible(true);
	}
}
