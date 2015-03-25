
package phase1a;

// Imports
import javax.swing.*;
import java.awt.event.*;

// 3-4 grade screen class
public class fourthGradeScreen extends JFrame {

	// Panel
	private JPanel panel;
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 150;

	// Labels

	// Buttons
	private JButton mainMenuButton;

	// PreK screen constructor
	public fourthGradeScreen() {

		// Sets the title of the JFrame
		super("3-4 level");

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