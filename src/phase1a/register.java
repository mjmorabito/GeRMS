package phase1a;

/*
* The register screen
* Gustavo Moraes, Ryan Ahearn, Mark Morabito, Samir Leal
* 1/30/15
*/

// Imports
import javax.swing.*;
import java.awt.event.*;

// Login class
public class register extends JFrame {

	// Panels
	private JPanel panel;
	private final int WINDOW_WIDTH = 270;
	private final int WINDOW_HEIGHT = 150;

	// Labels
	private JLabel registerLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;

	// Text Fields
	private JTextField usernameField;
	private JTextField passwordField;

	// Buttons
	private JButton registerButton;
	private JButton loginScreenButton;


	// Login constructor
	public register() {

		// Sets the title of the JFrame
		super("Register");

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

		// Login label
		registerLabel = new JLabel("Please enter a username and password.");

		// Username label and text field
		usernameLabel = new JLabel("Username: ");
		usernameField = new JTextField(10);

		// Password label and text field
		passwordLabel = new JLabel("Password: ");
		passwordField = new JTextField(10);

		// Register button
		registerButton = new JButton("Register");

		// Main Menu Button
		loginScreenButton = new JButton("Back");
		loginScreenButton.addActionListener(new buttonActionListener());

		// Adds components to the panel
		panel = new JPanel();
		panel.add(registerLabel);
		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(registerButton);
		panel.add(loginScreenButton);


}

// buttonActionListener Class definition
	public class buttonActionListener implements ActionListener {

		// Button clicked event
		public void actionPerformed(ActionEvent e) {

			// Login screen
			login l = new login();

			// Close
			dispose();

		}

	}


}