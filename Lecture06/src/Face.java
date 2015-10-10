// Face.java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

/*
 Demonstrates a component that draws a face and uses
 the setter/repaint style.
*/
public class Face extends JComponent {
	// The "model" data for the face:
	// booleans and ints that control how it looks
	private boolean angry;
	private boolean hat;
	
	// Deltas added/subtracted from default eye/mouth size
	private int eyeDelta;
	private int mouthDelta;
	private int mouthWidthDelta;

	Face(int width, int height) {
		setPreferredSize(new Dimension(width, height));

		angry = false;
		hat = false;
		eyeDelta = 0;
		mouthDelta = 0;
		mouthWidthDelta = 0;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// see how big we are
		int width = getWidth();
		int height = getHeight();

		// Angry -> draw red oval, otherwise plain outline
		if (angry) { 
			g.setColor(Color.RED);
			g.fillOval(0, 0, width, height);
		} else {
			g.drawOval(0, 0, width - 1, height - 1);
		}

		int eyeY = height / 4; // place eyes 1/4 from top
		int mouthY = 2 * height / 3; // place mouth 2/3 from top

		// base eye size on width
		int eyeRadius = width / 10 + eyeDelta;

		// place the eyes at 1/3 and 2/3 from left
		int left = width / 3;
		int right = 2 * width / 3;

		// draw the eyes in green
		g.setColor(Color.GREEN);
		g.fillOval(left - eyeRadius, eyeY - eyeRadius,
				eyeRadius * 2, eyeRadius * 2);
		g.fillOval(right - eyeRadius, eyeY - eyeRadius,
				eyeRadius * 2, eyeRadius * 2);

		// draw the mouth
		int mouthRadius = width / 10 + mouthDelta;
		g.setColor(Color.BLACK);
		g.fillOval(width / 2 - mouthRadius - mouthWidthDelta,  // x
				mouthY - mouthRadius, // y
				(mouthRadius + mouthWidthDelta) * 2,  // width
				mouthRadius * 2);  // height

		// draw the hat last (on top)
		if (hat) {
			g.setColor(Color.BLACK);
			int midX = width / 2;
			int wide = 3*width/4;
			g.fillOval(midX - wide / 2, 0, wide, height / 15);
		}
	}
}
