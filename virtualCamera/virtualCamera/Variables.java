package virtualCamera;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Helping class with shared variables.
 *
 */
public class Variables {

	// java - get screen size using the Toolkit class
	// the aim: game automatically adjusts its size to the screen resolution
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int height = (int) (screenSize.getHeight() * 0.75);
	static int width = (int) (height * 0.8);
}
