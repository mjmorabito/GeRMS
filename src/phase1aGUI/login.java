package phase1aGUI;

/*
* The login screen
* Gustavo Moraes, Ryan Ahearn, Mark Morabito, Samir Leal
* 1/30/15
*/

// Imports
import javax.swing.*;
import java.awt.event.*;

// Login class
public class login extends JFrame {

	// Panels
	private JPanel panel;
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 150;

	// Labels
	private JLabel loginLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;

	// Text Fields
	private JTextField usernameField;
	private JTextField passwordField;

	// Buttons
	private JButton loginButton;
	private JButton registerButton;
	private JButton resetPassword;


	// Login constructor
	public login() {

		// Sets the title of the JFrame
		super("Login");

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
		loginLabel = new JLabel("Please enter your username and password or register.");

		// Username label and text field
		usernameLabel = new JLabel("Username: ");
		usernameField = new JTextField(10);

		// Password label and text field
		passwordLabel = new JLabel("Password: ");
		passwordField = new JTextField(10);

		// Login button
		loginButton = new JButton("Login");
		loginButton.addActionListener(new loginActionListener());

		// Register button
		registerButton = new JButton("Register");
		registerButton.addActionListener(new loginActionListener());

		// Reset password button
		resetPassword = new JButton("Forgot password");
		resetPassword.addActionListener(new loginActionListener());


		// Adds components to the panel
		panel = new JPanel();
		panel.add(loginLabel);
		panel.add(usernameLabel);
		panel.add(usernameField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(registerButton);
		panel.add(resetPassword);


}


// Login button action listener class
public class loginActionListener implements ActionListener {


		// Button clicked event
		public void actionPerformed(ActionEvent e) {

			// Determines which button was clicked
			if (e.getSource() == loginButton) {
				// Open main screen
				mainScreen m = new mainScreen();
			} else if (e.getSource() == registerButton) {
				// Register screen
				register r = new register();
			} //else if (e.getSource() == resetPassword) {
				// Password screen
			//	forgotPassword f = new forgotPassword();
			//}

			// Close login frame
			dispose();

		}


}
}
