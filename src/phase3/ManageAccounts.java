/*
* The Math Tutor Software
* Gustavo Moraes, Ryan Ahearn, Mark Morabito, Samir Leal
* 3/27/15
*/
package phase3;

import java.awt.*;
import javax.swing.*;

/*
 * The administrator's tool to view user's name, username, and password
 */
public class ManageAccounts extends JInternalFrame {
    
    // North, center, and south panels
    private JPanel northPanel, centerPanel, southPanel;
    
    // First name panel
    private JPanel firstNamePanel;
    
    // First name label
    private JLabel firstNameLabel;
    
    // First name text field
    private JTextField firstNameTextField;
    
    // Last name panel
    private JPanel lastNamePanel;
    
    // Last name label
    private JLabel lastNameLabel;
    
    // Last name text field
    private JTextField lastNameTextField;
    
    // Search button panel
    private JPanel searchButtonPanel;
    
    // Search button
    private JButton searchButton;
    
    // Table panel
    private JPanel tablePanel;
    
    // Table for the search results
    private JTable table;
    
    // Scroll pane for the table
    private JScrollPane scrollPane;
    
    // Ok button panel
    private JPanel okButtonPanel;
    
    private JButton okButton;
    
    public ManageAccounts() {
        /*
        * Builds the manage accounts internal frame
        */
        super("Manage Accounts");
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        setClosable(true);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(974, 560);
        setVisible(true);

        setLocation(25, 25);
        
        /*
        Dimension desktopPaneSize = desktopPane.size();
        Dimension loginFrameSize = loginFrame.size();
        int dpWidth = (int)desktopPaneSize.width;
        int lfWidth = (int)loginFrameSize.width;
        int dpHeight = (int)desktopPaneSize.height;
        int lfHeight = (int)loginFrameSize.height;
        loginFrame.setLocation(((dpWidth-lfWidth)/2)-10, ((dpHeight-lfHeight)/2)-30);        
        */
        
        setLayout(new BorderLayout());
        
        // The panel that goes in the north area
        northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3, 1));        
        
        // The panel that goes in the center area
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1));

        // The panel that goes in the south area
        southPanel = new JPanel();
       
        // Builds the name panels
        buildNamePanels();
        
        // Adds the name panels to the north panel
        northPanel.add(firstNamePanel);
        northPanel.add(lastNamePanel);

        // Builds the search button
        buildSearchButton();        
        
        // Adds the search button to the north panel
        northPanel.add(searchButtonPanel);        
        
        // Builds the table
        buildTable();
        
        // Adds the table to the center panel
        centerPanel.add(tablePanel);
        
        // Builds the ok button
        buildOkButton();
        
        // Adds the ok button to the center panel
        centerPanel.add(okButtonPanel);
        
        // Adds the north panel and the center panel to the JInternalFrame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
                
    }
    
    public void buildNamePanels() {
        
        // Panel to put the labels and text fields
        firstNamePanel = new JPanel();
        
        // First name label
        firstNameLabel = new JLabel("First Name: ");
        
        // First name text field
        firstNameTextField = new JTextField(10);
        
        // Panel to put the labels and text fields
        lastNamePanel = new JPanel();

        // Last name label
        lastNameLabel = new JLabel("Last Name: ");
        
        // Last name text field
        lastNameTextField = new JTextField(10);
        
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameTextField);
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameTextField);
        
    }
    
    public void buildSearchButton() {
        
        // Search button panel
        searchButtonPanel = new JPanel();
        
        // Search button
        searchButton = new JButton("Search");
        
        // Adds the search button to the search button panel
        searchButtonPanel.add(searchButton);
    }
    
    public void buildTable() {
        
        // The panel for the table
        tablePanel = new JPanel();
        
        String[] cols = {"First Name", "Last Name", "Username", "Password"};
        Object[][] rows = new Object[100][4];
        table = new JTable(rows, cols);
        scrollPane = new JScrollPane(table);  
        table.setPreferredSize(new Dimension(500, 100));
        scrollPane.setPreferredSize(new Dimension(500, 100));
        
        // Adds the scroll pane to the table panel
        tablePanel.add(scrollPane);
        
    }
    
    public void buildOkButton() {
        okButtonPanel = new JPanel();
        okButton = new JButton("Ok");
        okButtonPanel.add(okButton);        
    }
    
}
