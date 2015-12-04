// SwingThread.java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 Demonstrates using workers and the swing thread,
 and interruption.
*/
class SwingThread extends JFrame {
	private JLabel label;
	private JButton right;
	private JButton wrong;
	private JButton fork;
	private JTextField field;
	private LabelWorker worker;
	private JButton inter;

	public SwingThread() {
		super("Swing Thread");
		
		setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS) );

		// put in a label
		label = new JLabel("hello");
		add(label);

		// Button that adds an "x" when clicked -- fine,
		// runs on the swing thread
		right = new JButton("Add Right x");
		add(right);
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(label.getText() + " x");
			}
		});

		// Bad -- hogs the Swing thread
		// the whole GUI will appear to lock up for 5 seconds -- use worker thread instead
		// Note also that the "All Homework Is Cancelled" NEVER appears on screen
		wrong = new JButton("Add Wrong y");
		add(wrong);
		wrong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = label.getText();
				label.setText("All Homework Is Cancelled!");
				// sleep for 5 seconds -- simulate time consuming operation
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ignored) {}
				label.setText(text + " y");
			}
		});

		// Field appends text to label -- uses worker thread correctly
		field = new JTextField("hi", 20);
		field.setMaximumSize(new Dimension(200, 20));
		add(field);

		worker = null;
		fork = new JButton("Fork Off Adder");
		add(fork);

		// fork button -> set text, then fork off worker
		fork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set text right away -- ok, we're on the swing thread
				label.setText(label.getText() + " ... WAIT FOR IT!");

				// Interrupt previous worker if it exists
				if (worker != null) worker.interrupt();

				// fork off new worker using text from field
				worker = new LabelWorker(field.getText());
				worker.start();
			}
		});

		// Interrupt existing worker
		inter = new JButton("Interrupt");
		add(inter);
		inter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Q: Is there a race condition between this code and
				// the above worker interrupt code?
				if (worker != null) {
					worker.interrupt();
					worker = null;
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

 
	// Takes a word, appends it 10 times to the label,
	// working very slowly. Exits when interrupted
	private class LabelWorker extends Thread {
		String word;

		public LabelWorker(String initWord) {
			word = initWord;
		}

		@Override
		public void run() {
			String text = "";
			for (int i = 0; i < 10; i++) {
				// Sleep for a second, exit on interrupt
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					// Control goes here if we are interrupted while sleeping --
					// exit the run loop.  (Way 1 to notice interruption)
					break;
				}

				// Do some computation, storing in a final temp variable,
				// so it is visible in the Runnable
				text = text + word;
				final String finalText = text;
				
				// Notice if interrupted -- exit
				// (Way 2 to notice interruption)
				if (isInterrupted())
					break;
				
				// NO NO NO, cannot do this
				// label.setText(finalText);

				// Message back to the GUI using invokeLater/Runnable
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						label.setText(finalText);
					}
				});
			}
		}
	}

	public static void main(String[] args) {
		new SwingThread();
	}
}
