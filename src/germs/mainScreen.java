package germs;

/*
* The main screen
* Gustavo Moraes, Ryan Ahearn, Mark Morabito, Samir Leal
* 1/30/15
*/

// Imports
import javax.swing.*;
import java.awt.event.*;

// Main screen class
public class mainScreen extends JFrame {

	// Panel
	private JPanel panel;
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 150;

	// Labels
	private JLabel selectLabel;

	// Buttons
	private JButton preK;
	private JButton secondGrade;
	private JButton fourthGrade;
	private JButton logout;

	// Main screen constructor
	public mainScreen() {

		// Sets the title of the JFrame
		super("Select level");

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

	public void buildPanel() {

		// Select level label
		selectLabel = new JLabel("Select your grade level");

		// PreK button
		preK = new JButton("PreK-K");
		preK.addActionListener(new levelActionListener());

		// First and Second grade button
		secondGrade = new JButton("1-2");
		secondGrade.addActionListener(new levelActionListener());

		// Third and Fourth grade button
		fourthGrade = new JButton("3-4");
		fourthGrade.addActionListener(new levelActionListener());

		// Logout button
		logout = new JButton("Logout");
		logout.addActionListener(new levelActionListener());

		// Adds components to the panel
		panel = new JPanel();
		panel.add(selectLabel);
		panel.add(preK);
		panel.add(secondGrade);
		panel.add(fourthGrade);
		panel.add(logout);


}


// Level select action listener

public class levelActionListener implements ActionListener {

		// Button clicked event
		public void actionPerformed(ActionEvent e) {

			// Determines which button was clicked then performs specific operations
			if (e.getSource() == preK) {

				// Open the preK screen
				preKScreen p = new preKScreen();

				// Close main screen
				dispose();


			} else if (e.getSource() == secondGrade) {

				// Open the preK screen
				secondGradeScreen s = new secondGradeScreen();

				// Close main screen
				dispose();

			} else if (e.getSource() == fourthGrade) {

				// Open the preK screen
				fourthGradeScreen f = new fourthGradeScreen();

				// Close main screen
				dispose();

			} else if (e.getSource() == logout) {

				// Goes to the login screen
				login l = new login();

				// Close main screen
				dispose();

			}

		}


}
}