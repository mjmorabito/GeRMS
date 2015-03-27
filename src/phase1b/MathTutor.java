package phase1b;

/*
* The Math Tutor Software
* Gustavo Moraes, Ryan Ahearn, Mark Morabito, Samir Leal
* 2/27/15
*/

import javax.swing.*;
import java.awt.*;
import java.beans.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class MathTutor extends JFrame {

    // Menu Bar
    private JMenuBar menuBar;
    
    // File Menu
    private JMenu fileMenu;
    
    // Exit Menu Item
    private JMenuItem exitMenuItem;
    
    // Panel for the banner at the top
    private JPanel bannerPanel;
 
    // A label that displays the string "Username: "
    private JLabel usernameLabel;
    
    // A label that displays the string "Stars: "
    private JLabel starsLabel;
    
     // Panel for the buttons at the top right
    private JPanel bannerButtonsPanel;   
    
    // Buttons at the right of the banner
    private JButton loginButton;
    private JButton logoutButton;
    private JButton homeButton;
    private JButton printerButton;
    private JButton helpButton;

    // Desktop Pane
    private JDesktopPane desktopPane;
    
    // Login Internal Frame
    private JInternalFrame loginFrame;

    public static void main(String[] args) {
        new MathTutor();
    }

    public MathTutor() {

        /*
        * Constructor
        */
        super("GeRMS Math Tutor");
        setSize(1366, 728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        buildMenuBar();
        buildTopPanel();
        buildDesktopPane();
        buildLoginFrame();

    }
    
    public void buildMenuBar() {
        /*
        * The menu bar
        */
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);        
    }
    

    public void buildTopPanel() {
        /* 
        * The top panel for the username, stars, and buttons
        */
        bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.setPreferredSize(new Dimension(1366, 85));
        //userInfoPanel.setSize(1366, 65);
        
        bannerButtonsPanel = new JPanel();
        
        
        usernameLabel = new JLabel("Username: ");
        starsLabel = new JLabel("Stars: ");
        
        // Gets the URL for each button at the top right of the screen
        URL loginButtonURL = this.getClass().getClassLoader().getResource("phase1b/Images/loginButton.png");
        URL logoutButtonURL = this.getClass().getClassLoader().getResource("phase1b/Images/logoutButton.png");
        URL homeButtonURL = this.getClass().getClassLoader().getResource("phase1b/Images/homeButton.png");
        URL printerButtonURL = this.getClass().getClassLoader().getResource("phase1b/Images/printer.png");
        URL helpButtonURL = this.getClass().getClassLoader().getResource("phase1b/Images/helpButton.png");
       
        try {
            
            // Reads the URL of each button as an Image
            Image loginButtonImage = ImageIO.read(loginButtonURL);
            Image logoutButtonImage = ImageIO.read(logoutButtonURL);
            Image homeButtonImage = ImageIO.read(homeButtonURL);
            Image printerButtonImage = ImageIO.read(printerButtonURL);
            Image helpButtonImage = ImageIO.read(helpButtonURL);
            
            // Creates an ImageIcon for each button
            ImageIcon loginButtonIcon = new ImageIcon(loginButtonImage);
            ImageIcon logoutButtonIcon = new ImageIcon(logoutButtonImage);
            ImageIcon homeButtonIcon = new ImageIcon(homeButtonImage);
            ImageIcon printerButtonIcon = new ImageIcon(printerButtonImage);
            ImageIcon helpButtonIcon = new ImageIcon(helpButtonImage);
            
            // Sets the label's icon for each button
            loginButton = new JButton(loginButtonIcon);
            logoutButton = new JButton(logoutButtonIcon);
            homeButton = new JButton(homeButtonIcon);
            printerButton = new JButton(printerButtonIcon);
            helpButton = new JButton(helpButtonIcon);
            
            // Adds the buttons to the bannerButtonsPanel
            bannerButtonsPanel.add(loginButton);
            bannerButtonsPanel.add(logoutButton);
            bannerButtonsPanel.add(homeButton);
            bannerButtonsPanel.add(printerButton);
            bannerButtonsPanel.add(helpButton);
            
        } catch (Exception e) {
            // Catches ImageIO.read() exceptions then prints it to the output
            System.out.println(e);
        }
        
        bannerPanel.add(usernameLabel, BorderLayout.WEST);
        //userInfoPanel.add(starsLabel);
        bannerPanel.add(bannerButtonsPanel, BorderLayout.EAST);     
        add(bannerPanel, BorderLayout.NORTH);        
    }
    
    public void buildDesktopPane() {
        desktopPane = new JDesktopPane();
        desktopPane.setSize(1366, 643);
        add(desktopPane, BorderLayout.CENTER);        
    }

    public void buildLoginFrame() {

        /*
        * Builds the login internal frame
        */
        loginFrame = new JInternalFrame("Login");
        loginFrame.setMaximizable(true);
        loginFrame.setIconifiable(true);
        loginFrame.setResizable(true);
        loginFrame.setClosable(true);
        loginFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(974, 560);
        loginFrame.setVisible(true);
        loginFrame.setLayout(new BorderLayout());

        Dimension desktopPaneSize = desktopPane.size();
        Dimension loginFrameSize = loginFrame.size();
        int dpWidth = (int)desktopPaneSize.width;
        int lfWidth = (int)loginFrameSize.width;
        int dpHeight = (int)desktopPaneSize.height;
        int lfHeight = (int)loginFrameSize.height;

        loginFrame.setLocation(((dpWidth-lfWidth)/2)-10, ((dpHeight-lfHeight)/2)-30);

        /*
        * Builds the logo panel
        */
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(546, 215));
        JLabel logoLabel = new JLabel();
        URL imageURL = this.getClass().getClassLoader().getResource("phase1b/Images/logo.jpg");
        try {
            Image logoImage = ImageIO.read(imageURL);
            ImageIcon logoIcon = new ImageIcon(logoImage);
            logoLabel.setIcon(logoIcon);
            logoPanel.add(logoLabel);
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
        * Builds the login panel
        */
        JPanel loginPanel = new JPanel(new BorderLayout());
        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        JTextField usernameTextField = new JTextField(10);
        usernameTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 42));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);
        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Password:  ");
        passwordLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        JTextField passwordTextField = new JTextField(10);
        passwordTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 42));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);
        loginPanel.add(usernamePanel, BorderLayout.NORTH);
        loginPanel.add(passwordPanel, BorderLayout.CENTER);

        /*
        * Builds the buttons panel
        */
        JPanel buttonsPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        buttonsPanel.add(loginButton);
        buttonsPanel.add(registerButton);

        /*
        * Adds the logo panel, login panel, and buttons panel to the login internal frame
        */
        loginFrame.add(logoPanel, BorderLayout.NORTH);
        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.add(buttonsPanel, BorderLayout.SOUTH);

        // Adds the login internal frame to the desktop pane
        desktopPane.add(loginFrame);

        /* This is to auto maximize 
        try {
                 loginFrame.setMaximum(true);
        } catch (PropertyVetoException e) {
                // Vetoed by internalFrame
                // ... possibly add some handling for this case
        }
        */

    }
}