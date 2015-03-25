
package phase1a;
/*
* The preK-k level screen
* Gustavo Moraes, Ryan Ahearn, Mark Morabito, Samir Leal
* 1/30/15
*/

// Imports
import javax.swing.*;
import java.awt.event.*;

// PreK-K screen class
public class preKScreen extends JFrame {

	// Panel
	private JPanel panel;
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 150;

	// Labels

	// Buttons
	private JButton mainMenuButton;

	// PreK screen constructor
	public preKScreen() {

		// Sets the title of the JFrame
		super("PreK-K level");

		// Sets the size of the window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Sets the close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Builds the panel
		buildPanel();

		// Adds the panel to the JFrame
		add(panel);

		// Sets the JFrame to the center of the screen
		setLocationRelativeTo(null);

		// Makes the JFrame visible
		setVisible(true);

	}

	// Builds the panel
	public void buildPanel() {

		// Main menu button
		mainMenuButton = new JButton("Main Menu");

		// Adds components to the panel
		panel = new JPanel();
		panel.add(mainMenuButton);
		mainMenuButton.addActionListener(new mainMenuButtonActionListener());



}


// mainMenuButtonActionListener Class definition
	public class mainMenuButtonActionListener implements ActionListener {

		// Button clicked event
		public void actionPerformed(ActionEvent e) {

			// Main menu
			mainScreen m = new mainScreen();

			// Close
			dispose();

		}

	}


}