/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/02/15
 * Purpose: The client requested a math tutoring software for elementary school children.
 * For this phase of the project the client assigned us to script a prototype portion of the user interface.
 * (Not everything). We were told to select the most important part of your project and simply develop one modular to
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/*
* This is the Main class. It is the class that display's the outer JFrame.
* 
* This JFrame includes a banner at the top that display's the username, and number of stars.
* On the right hand side there are five buttons: Login (orange), Logout (gray), Home (blue), 
* Print (printer), and Help (question mark).
* 
* This class is used to place the DesktopPane, which holds many JInternalFrames.
* JInternalFrames include screens such as Login, Register, ForgotPassword, ManageAccounts, 
* and Help, which placed in the desktop pane that is instantiated in this class.
*
*/
public class Main extends JFrame {
    
    // Login class
    private Login login;
    
    // Determines if the Login Screen is open
    private boolean isLoginScreenOpen;
    
    // Determines if the user is logged in
    private boolean isLoggedIn = false;
    
    // Determines if the user is logged in as an adminsitrator
    private boolean isLoggedInAsAdmin = false;
    
    // Register screen class
    private Register register;
    
    // Determines if the register screen is open / closed
    private boolean isRegisterScreenOpen = false;
    
    // Forgot Password screen class
    private ForgotPassword forgotPassword;
    
    // Determines if the forgot password screen is open / closed
    private boolean isForgotPasswordScreenOpen = false;

    // ManageAccounts class
    private ManageAccounts manageAccounts;
    
    // Determines if the Manage Screen is open
    private boolean isManageAccountsScreenOpen = false;    
    
    // GradeSelect class
    private GradeSelect gradeSelect;
    
    // Determines if the Grade Select screen is open
    private boolean isGradeSelectScreenOpen = false;
    
    // HelpScreen class
    private HelpScreen help;
    
    // Determines if the Help Screen is open / closed
    private boolean isHelpScreenOpen = false;    
    
    //PreKKCountingQuiz class
    private PreKK preKK;
    
    //Determines if the PreKKCountingQuiz is open / close
    private boolean isPreKKOpen = false;
    
    //TODO DELETE THIS SOON
    //PreKKCountingQuiz class
    private PreKKCountingQuiz preKKCountingQuiz;
    
    //Determines if the PreKKCountingQuiz is open / close
    private boolean isPreKKCountingQuizOpen = false; 
    
    //KN1 class
    private KN1 kn1;
    
    //Determins if the KN1Screen is Open
    private boolean isKN1ScreenOpen = false;
    
    // KN2 class
    private KN2 kn2;
    
    // Determines if the KN2 Practice Module is open / closed
    private boolean isKN2ScreenOpen = false;
    
    // KN2 class
    private KN3 kn3;
    
    // Determines if the KN3 Practice Module is open / closed
    private boolean isKN3ScreenOpen = false;    
            
    // KN4 class
    private KN4 kn4;
    
    // Determines if the KN4 Practice Module is open / closed
    private boolean isKN4ScreenOpen = false;
 
    // KN5 class
    private KN5 kn5;
    
    // Determines if the KN5 Practice Module is open / closed
    private boolean isKN5ScreenOpen = false;
    
    // KN6 class
    private KN6 kn6;
    
    // Determines if the KN6 Practice Module is open / closed
    private boolean isKN6ScreenOpen = false;
    
    // KN7 class
    private KN7 kn7;
    
    // Determines if the KN7 Practice Module is open / closed
    private boolean isKN7ScreenOpen = false;
 
    // KN8 class
    private KN8 kn8;
    
    // Determines if the KN8 Practice Module is open / closed
    private boolean isKN8ScreenOpen = false;
    
    // Grades1and2 class
    private Grades1and2 grades1and2;
    
    // Determines if the Grades1and2 module is open
    private boolean isGrades1and2ModuleOpen = false;
    
    // Class for the grade 2 standard 4 practice questions module
    private G2N4 g2n4;
    
    // Determines if the G2N4 practice module is open / closed
    private boolean isG2N4ScreenOpen = false;
    
    // Class for the QuizDifficultySelect
    private QuizDifficultySelect quizDifficultySelect;
    
    // Determines  if the quizDifficultySelect screen is open
    private boolean isQuizDifficultySelectOpen = false;
    
      // Class for the Assessment
    private Assessment assessment;
    
    // Determines  if the Assessment screen is open
    private boolean isAssessmentScreenOpen = false;
    
    // Grades3and4 class
    private Grades3and4 grades3and4;
    
    // Determines if the Grades3and4 module is open
    private boolean isGrades3and4ModuleOpen = false;
    
    // G4N12 class
    private G4N12 g4n12;
    
    // Determines if the g4n12 screen is open / closed
    private boolean isG4N12ScreenOpen = false;
    
    // QuizReport class
    private QuizReport quizReport;
    
    // Determines if the QuizReport screen is open / closed
    private boolean isQuizReportScreenOpen = false; 
    /*
    * Creates a new instance of the Main class
    */
    public Main() {
        
        // Initialize the components on the main screen
        initComponents();
        
        // Starts the window in maximized mode
        this.setExtendedState(MAXIMIZED_BOTH);
                
        // Gets the size of the computer screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Sets the size of this JFrame to the size of the computer screen
        this.setSize(screenSize.width, screenSize.height);
        
        // Sets the size of the desktopPane
        desktopPane.setSize(screenSize.width, screenSize.height-250);
        
        // If the computer screen's height equals 768px 
        if (screenSize.height == 768) {
            
            // Set the size to this
            desktopPane.setSize(screenSize.width, screenSize.height-175);
            
        // Else if the size is not 768
        } else if (screenSize.height == 720) {
        
            // Sets the size of the desktop pane to the size of the computer screen
            desktopPane.setSize(screenSize.width, screenSize.height-182);
            
        }
        
        // Opens the login screen
        openLoginScreen();        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        starsLabel = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane() {
            private java.awt.Image image;
            {
                try {
                    java.net.URL url = this.getClass().getClassLoader().getResource("Images/MainScreen/background.jpg");
                    image = javax.imageio.ImageIO.read(url);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0,getSize().width, getSize().height, null);           
            }
        };
        usernameLabel2 = new javax.swing.JLabel();
        helpButton = new javax.swing.JButton();
        printerButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        manageAccountsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GeRMS Math Tutor");
        setExtendedState(4);
        setFocusCycleRoot(false);

        usernameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        usernameLabel.setText("Username:");

        starsLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        starsLabel.setText("Stars:");

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1525, Short.MAX_VALUE)
        );

        usernameLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/helpButton.png"))); // NOI18N
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        printerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/printer.png"))); // NOI18N
        printerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printerButtonActionPerformed(evt);
            }
        });

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/homeButton.png"))); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/logoutButton.png"))); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/loginButton.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        manageAccountsMenuItem.setText("Manage Accounts");
        manageAccountsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(manageAccountsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1237, Short.MAX_VALUE)
                        .addComponent(loginButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(printerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLabel)
                            .addComponent(usernameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(starsLabel))
                    .addComponent(helpButton)
                    .addComponent(printerButton)
                    .addComponent(homeButton)
                    .addComponent(logoutButton)
                    .addComponent(loginButton))
                .addGap(11, 11, 11)
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // This method sets the isLoginScreenOpen variable to true/false
    public void setIsLoginScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isLoginScreenOpen = isOpen;
        
    }

    // This method sets the isLoggedIn variable to true/false
    public void setIsLoggedIn(boolean loggedIn) {
        
        // Sets the variable
        isLoggedIn = loggedIn;
        
    }
   
    // This method sets the isLoggedInAsAdmin variable to true/false   
    public void setIsLoggedInAsAdmin(boolean loggedInAsAdmin) {
        
        // Sets the variable
        isLoggedInAsAdmin = loggedInAsAdmin;
        
    }    
    
    /*
    * This method is called when the user logs in    
    * It sets the text that display's the username of the logged-in user
    */
    public void setUsernameLabel(String user) {
        
        // Sets the text of the label after "Username: " to the username of the user that logged in
        usernameLabel2.setText(user);
        
    }    
    
    // This method sets the isRegisterScreenOpen variable to true/false
    public void setIsRegisterScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isRegisterScreenOpen = isOpen;
        
    }
    
    // This method sets the isForgotPasswordScreenOpen variable to true/false
    public void setIsForgotPasswordScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isForgotPasswordScreenOpen = isOpen;
        
    }
    
    // This method sets the isManageAccountsScreenOpen variable to true/false
    public void setIsManageAccountsScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isManageAccountsScreenOpen = isOpen;
        
    }
    
    // This method sets the isGradeSelectScreenOpen variable to true/false
    public void setIsGradeSelectScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isGradeSelectScreenOpen = isOpen;
        
    }
    
    // This method sets the isHelpScreenOpen variable to true/false
    public void setIsHelpScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isHelpScreenOpen = isOpen;
        
    }  
    
     // This method sets the isHelpScreenOpen variable to true/false
    public void setIsPreKKCountingQuizOpen(boolean isOpen) {
        
        // Sets the variable
        isPreKKCountingQuizOpen = isOpen;
        
    } 
    
    // This method sets the isHelpScreenOpen variable to true/false
    public void setIsPreKKOpen(boolean isOpen) {
        
        // Sets the variable
        isPreKKOpen = isOpen;
        
    } 
    
    // This method sets the isKN1ScreenOpen variable to true/false
    public void setIsKN1ScreenOpen(boolean isOpen){
        
        //Set the variable
        isKN1ScreenOpen = isOpen;
        
    }
    
    // This method sets the isKN2ScreenOpen variable to true/false
    public void setIsKN2ScreenOpen(boolean isOpen){
        
        //Set the variable
        isKN2ScreenOpen = isOpen;
        
    }
    
    // This method sets the isKN3ScreenOpen variable to true/false
    public void setIsKN3ScreenOpen(boolean isOpen){
        
        //Set the variable
        isKN3ScreenOpen = isOpen;
        
    }
    
    // This method sets the isKN4ScreenOpen variable to true/false
    public void setIsKN4ScreenOpen(boolean isOpen){
        
        System.out.println("Screen should be open");
        //Set the variable
        isKN4ScreenOpen = isOpen;
        
    }
    
    // This method sets the isKN5ScreenOpen variable to true/false
    public void setIsKN5ScreenOpen(boolean isOpen){
        
        //Set the variable
        isKN5ScreenOpen = isOpen;
        
    }
    
    // This method sets the isKN6ScreenOpen variable to true/false
    public void setIsKN6ScreenOpen(boolean isOpen){
        
        //Set the variable
        isKN6ScreenOpen = isOpen;
        
    }
    
    // This method sets the isKN7ScreenOpen variable to true/false
    public void setIsKN7ScreenOpen(boolean isOpen){
        
        //Set the variable
        isKN7ScreenOpen = isOpen;
        
    }
    
    // This method sets the isKN8ScreenOpen variable to true/false
    public void setIsKN8ScreenOpen(boolean isOpen){
        
        //Set the variable
        isKN8ScreenOpen = isOpen;
        
    }
    
    // This method sets the isGrades1and2Module variable to true/false
    public void setIsGrades1and2ModuleOpen(boolean isOpen){
        
        //Set the variable
        isGrades1and2ModuleOpen = isOpen;
        
    }
    
    // This method sets the isG2N4ScreenOpen variable to true/false
    public void setIsG2N4ScreenOpen(boolean isOpen){
        
        //Set the variable
        isG2N4ScreenOpen = isOpen;
        
    }
    
    // This method sets the isQuizDifficultySelectOpen variable to true/false
    public void setisQuizDifficultySelectOpen(boolean isOpen) {
        
        // Sets the variable
        isQuizDifficultySelectOpen = isOpen;
        
    }
    
     // This method sets the isAssessmentScreenOpen variable to true/false
    public void setIsAssessmentScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isAssessmentScreenOpen = isOpen;
        
    }
    
    // This method sets the isGrades3and4Module variable to true/false
    public void setIsGrades3and4ModuleOpen(boolean isOpen){
        
        //Set the variable
        isGrades3and4ModuleOpen = isOpen;
        
    }
    
    // This method sets the isG4N12ScreenOpen variable to true/false
    public void setIsG4N12ScreenOpen(boolean isOpen){
        
        //Set the variable
        isG4N12ScreenOpen = isOpen;
        
    }
    
    // This method sets the isQuizReportScreenOpen variable to true/false
    public void setIsQuizReportScreenOpen(boolean isOpen){
        
        //Set the variable
        isQuizReportScreenOpen = isOpen;
        
    }
    
    // This method returns the value of the isKN1ScreenOpen variable
    public boolean getIsKN1ScreenOpen(){
        
        //Returns the boolean value
        return isKN1ScreenOpen;
        
    }
    
    // This method returns the value of the isKN2ScreenOpen variable
    public boolean getIsKN2ScreenOpen(){
        
        //Returns the boolean value
        return isKN2ScreenOpen;
        
    }
    
    // This method returns the value of the isKN3ScreenOpen variable
    public boolean getIsKN3ScreenOpen(){
        
        //Returns the boolean value
        return isKN3ScreenOpen;
        
    }
    
    // This method returns the value of the isKN4ScreenOpen variable
    public boolean getIsKN4ScreenOpen(){
        
        //Returns the boolean value
        return isKN4ScreenOpen;
        
    }
    
    // This method returns the value of the isKN5ScreenOpen variable
    public boolean getIsKN5ScreenOpen(){
        
        //Returns the boolean value
        return isKN5ScreenOpen;
        
    }
    
    // This method returns the value of the isKN6ScreenOpen variable
    public boolean getIsKN6ScreenOpen(){
        
        //Returns the boolean value
        return isKN6ScreenOpen;
        
    }
    
    // This method returns the value of the isKN7ScreenOpen variable
    public boolean getIsKN7ScreenOpen(){
        
        //Returns the boolean value
        return isKN7ScreenOpen;
        
    }
    
    // This method returns the value of the isKN8ScreenOpen variable
    public boolean getIsKN8ScreenOpen(){
        
        //Returns the boolean value
        return isKN8ScreenOpen;
        
    }
    
    // This method gets the boolean value of isGrades1and2Module variable
    public boolean getIsGrades1and2ModuleOpen(){
        
        // Returns the variable
        return isGrades1and2ModuleOpen;
        
    }
    
    // This method returns the value of the isG2N4ScreenOpen variable
    public boolean getIsG2N4ScreenOpen(){
        
        //Returns the boolean value
        return isG2N4ScreenOpen;
        
    }
    
    // This method returns the value of the isG4N12ScreenOpen variable
    public boolean getIsG4N12ScreenOpen(){
        
        //Returns the boolean value
        return isG4N12ScreenOpen;
        
    }
    
    // This method returns the value of the isQuizDifficultySelectOpen variable
    public boolean getIsQuizDifficultySelectOpen() {
        
        // Returns the value of the isQuizDifficultySelectOpen variable
        return isQuizDifficultySelectOpen;
        
    }
    
    // This method returns the boolean value of isRegisterScreenOpen
    public boolean getIsRegisterScreenOpen() {
        
        // Returns the boolean value
        return isRegisterScreenOpen;
        
    }
    
    public Dimension getDesktopPaneDimension() {
        
        // Returns the Dimension of the DesktopPane
        return desktopPane.getSize();
        
    }
    
    // This method returns the boolean value of isForgotPasswordScreenOpen
    public boolean getIsForgotPasswordScreenOpen() {
        
        // Returns the boolean value
        return isForgotPasswordScreenOpen;
        
    }
    
    
       // This method returns the boolean value of isAssessmentScreenOpen
    public boolean getIsAssessmentScreenOpen() {
        
        // Returns the boolean value
        return isAssessmentScreenOpen;
        
    }
    
    // This method gets the boolean value of isGrades3and4Module variable
    public boolean getIsGrades3and4ModuleOpen(){
        
        // Returns the variable
        return isGrades3and4ModuleOpen;
        
    }
    
    // This method gets the boolean value of isQuizReportScreenOpen variable
    public boolean getIsQuizReportScreenOpen(){
        
        // Returns the variable
        return isQuizReportScreenOpen;
        
    }
    
    // This method creates an instance of the Login screen
    public void openLoginScreen() {
        
        // Creates a new instance of the login screen
        login = new Login(this);

        // Adds the login screen to the desktop pane
        desktopPane.add(login);

        // Brings the login screen to the front
        login.toFront();

        // Sets the is login screen open variable to true
        isLoginScreenOpen = true;        
        
    }
    
    // This method creates an instance of the Register screen
    public void openRegisterScreen() {
        
        // Creates a new instance of the register screen
        register = new Register(this);

        // Sets the variable to true
        isRegisterScreenOpen = true;
        
        // Adds the register screen to the main desktop pane from the main screen
        desktopPane.add(register);

        // Brings the register screen to the front
        register.toFront();  
        
    }
    
    public void openForgotPasswordScreen() {
        
        // Creates a new instance of the ForgotPassword screen
        forgotPassword = new ForgotPassword(this);
        
        // Sets the variable
        isForgotPasswordScreenOpen = true;

        // Adds the screen to the desktop pane
        desktopPane.add(forgotPassword);

        // Brings the forgot password screen to the front
        forgotPassword.toFront();        
        
    }
    
    // This method creates an instance of the ManageAccounts screen
    public void openManageAccountsScreen() {
        
        // Creates a new ManageAccounts class
        manageAccounts = new ManageAccounts(this);
        
        // Sets the variable to true;
        isManageAccountsScreenOpen = true;
        
        // Adds the screen to the desktop pane
        desktopPane.add(manageAccounts);
        
        // Brings the screen to the front
        manageAccounts.toFront();
        
    }
    
    // This method creates an instance of the GradeSelect screen
    public void openGradeSelectScreen() {
        
        // Creates a new GradeSelect class
        gradeSelect = new GradeSelect(this);
        
        // Sets the variable to true
        isGradeSelectScreenOpen = true;
        
        // Adds the screen to the desktop pane
        desktopPane.add(gradeSelect);
        
        // Brings the screen to the front
        gradeSelect.toFront();
        
    }    
    
    // Opens the print report screen
    public void openPrintReportScreen() {
        
        // Creates a new Print Report screen class
        JOptionPane.showMessageDialog(null, "This button will open the print reports screen.", "Print Reports", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    // Opens the help screen
    public void openHelpScreen() {
        
        // Creates a new help screen class
        help = new HelpScreen();
        
        // Sets the variable
        isHelpScreenOpen = true;
        
        // Adds the help screen to the desktop pane
        desktopPane.add(help);
        
        // Brings the help screen to the front
        help.toFront();
        
    }
      // Opens the preKK page
    public void openPreKK() {
        
        // Creates a new preKK page
        preKK = new PreKK(this);
        
        // Sets the variable
        isPreKKOpen = true;
        
        // Adds the preKKCounting quiz screen to the desktop pane
        desktopPane.add(preKK);
        
        // Brings the preKKCounting quiz screen to the front
        preKK.toFront();
        
    }
    
    // Opens the Grades1and2 screen
    public void openGrades1and2Module() {
        
        // Checks if the screen is closed
        if (isGrades1and2ModuleOpen == false) {
        
            // Creates a new Grades1and2 page
            grades1and2 = new Grades1and2(this);

            // Sets the variable
            isGrades1and2ModuleOpen = true;

            // Adds the preKKCounting quiz screen to the desktop pane
            desktopPane.add(grades1and2);

            // Brings the preKKCounting quiz screen to the front
            grades1and2.toFront();
            
        }
        
    }
    
      // Opens the Grades3and4 page
    public void openGrades3and4Module() {
        
        // Checks if the screen is closed
        if (isGrades3and4ModuleOpen == false) {
        
            // Creates a new grades1and2 page
            grades3and4 = new Grades3and4(this);

            // Sets the variable
            isGrades3and4ModuleOpen = true;

            // Adds the preKKCounting quiz screen to the desktop pane
            desktopPane.add(grades3and4);

            // Brings the preKKCounting quiz screen to the front
            grades3and4.toFront();
            
        }
        
    }
    
    // Opens the preKKCountingQuiz
    public void openPreKKCountingQuiz() {
        
        // Creates a new preKKCountingQuiz
        preKKCountingQuiz = new PreKKCountingQuiz(this);
        
        // Sets the variable
        isPreKKCountingQuizOpen = true;
        
        // Adds the preKKCounting quiz screen to the desktop pane
        desktopPane.add(preKKCountingQuiz);
        
        // Brings the preKKCounting quiz screen to the front
        preKKCountingQuiz.toFront();
        
    }
    
    // This method creates an instance of the KN1 screen
    public void openKN1Screen() {
        
        // Creates a new KN1
        kn1 = new KN1(this);
        
        // Sets the variable
        isKN1ScreenOpen = true;
        
        // Adds the KN1 screen to the desktop pane
        desktopPane.add(kn1);
        
        // Brings the KN1 screen to the front
        kn1.toFront();       
        
    }
    
    // This method creates an instance of the KN2 screen
    public void openKN2Screen() {
        
        // Creates a new KN1
        kn2 = new KN2(this);
        
        // Sets the variable
        isKN2ScreenOpen = true;
        
        // Adds the KN2 screen to the desktop pane
        desktopPane.add(kn2);
        
        // Brings the KN2 screen to the front
        kn2.toFront();       
        
    }
    
    // This method creates an instance of the KN3 screen
    public void openKN3Screen() {
        
        // Creates a new KN3
        kn3 = new KN3(this);
        
        // Sets the variable
        isKN3ScreenOpen = true;
        
        // Adds the KN3 screen to the desktop pane
        desktopPane.add(kn3);
        
        // Brings the KN3 screen to the front
        kn3.toFront();       
        
    }
    
    // This method creates an instance of the KN4 screen
    public void openKN4Screen() {
        
        
        System.out.println("Open KN4");
        // Creates a new KN4
        kn4 = new KN4(this);
        
        // Sets the variable
        isKN4ScreenOpen = true;
        
        // Adds the KN4 screen to the desktop pane
        desktopPane.add(kn4);
        
        // Brings the KN4 screen to the front
        kn4.toFront();       
        
    }
    
    // This method creates an instance of the KN5 screen
    public void openKN5Screen() {
        
        // Creates a new KN5
        kn5 = new KN5(this);
        
        // Sets the variable
        isKN5ScreenOpen = true;
        
        // Adds the KN5 screen to the desktop pane
        desktopPane.add(kn5);
        
        // Brings the KN5 screen to the front
        kn5.toFront();       
        
    }
    
    // This method creates an instance of the KN6 screen
    public void openKN6Screen() {
        
        // Creates a new KN1
        kn6 = new KN6(this);
        
        // Sets the variable
        isKN6ScreenOpen = true;
        
        // Adds the KN6 screen to the desktop pane
        desktopPane.add(kn6);
        
        // Brings the KN6 screen to the front
        kn6.toFront();       
        
    }
    
    // This method creates an instance of the KN7 screen
    public void openKN7Screen() {
        
        // Creates a new KN7
        kn7 = new KN7(this);
        
        // Sets the variable
        isKN7ScreenOpen = true;
        
        // Adds the KN7 screen to the desktop pane
        desktopPane.add(kn7);
        
        // Brings the KN7 screen to the front
        kn7.toFront();       
        
    }
    
    // This method creates an instance of the KN8 screen
    public void openKN8Screen() {
        
        // Creates a new KN1
        kn8 = new KN8(this);
        
        // Sets the variable
        isKN8ScreenOpen = true;
        
        // Adds the KN8 screen to the desktop pane
        desktopPane.add(kn8);
        
        // Brings the KN8 screen to the front
        kn8.toFront();       
        
    }
    
    // This method creates an instance of the Quiz Difficulty select screen
    public void openQuizDifficultySelect() {
        
        if (isQuizDifficultySelectOpen == false) {
        
            // Creates a new KN1
            quizDifficultySelect = new QuizDifficultySelect(this);

            // Sets the variable
            isQuizDifficultySelectOpen = true;

            // Adds the KN8 screen to the desktop pane
            desktopPane.add(quizDifficultySelect);

            // Brings the KN8 screen to the front
            quizDifficultySelect.toFront(); 
            
        } else {
            
            
        }
        
    }
    
    // This method creates an instance of the G2N4 screen
    public void openG2N4Screen() {
        
        // Creates a new KN1
        g2n4 = new G2N4(this);
        
        // Sets the variable
        isG2N4ScreenOpen = true;
        
        // Adds the KN8 screen to the desktop pane
        desktopPane.add(g2n4);
        
        // Brings the KN8 screen to the front
        g2n4.toFront();       
        
    }
    
       // This method creates an instance of the Assessment1 screen
    public void openAssessmentScreen(int a, int b) {
        
        if(isAssessmentScreenOpen == false)
        {
        // Creates a new Assessment
        assessment = new Assessment(this,a,b);
        
        // Sets the variable
        isAssessmentScreenOpen = true;
        
        // Adds the Assessment screen to the desktop pane
        desktopPane.add(assessment);
        
        // Brings the Assessment screen to the front
        assessment.toFront(); 
        }
        
    }
    
    // This method creates an instance of the G4N12 screen
    public void openG4N12Screen() {
        
        // If the screen is not already open, then open it
        if (isG4N12ScreenOpen == false) {
        
            // Creates a new KN1
            g4n12 = new G4N12(this);

            // Sets the variable
            isG4N12ScreenOpen = true;

            // Adds the KN8 screen to the desktop pane
            desktopPane.add(g4n12);

            // Brings the KN8 screen to the front
            g4n12.toFront();  
            
        }
        
    }
    
    // This method creates an instance of the QuizReport screen
    public void openQuizReportScreen(int[] results) {
        
        // If the screen is not already open, then open it
        if (isQuizReportScreenOpen == false) {
        
            // Creates a new KN1
            quizReport = new QuizReport(this, results);

            // Sets the variable
            isQuizReportScreenOpen = true;

            // Adds the KN8 screen to the desktop pane
            desktopPane.add(quizReport);

            // Brings the KN8 screen to the front
            quizReport.toFront();  
            
        }
        
    }
    
    // This method closes all of the screens that are open upon log out
    public void closeAllScreens() {
        
        // if the grade select screen is open, then close it
        if (isGradeSelectScreenOpen) {
            
            // Closes the grade select screen
            closeGradeSelectScreen();
            
        }
        
    }  
    
    // This method disposes of the GradeSelect screen
    public void closeGradeSelectScreen() {
        
        // Disposes of the grade select screen
        gradeSelect.dispose();
   
        // Set the variable to false
        isGradeSelectScreenOpen = false;
        
    }    
           
    // The action listener for the exit menu item
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
    
        // Exits the program
        System.exit(0);
        
    }//GEN-LAST:event_exitMenuItemActionPerformed

    // This method is called when the orange login button is pressed (at the top)
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
       
        // If the login screen is not open and the user is not logged in
        if (!isLoginScreenOpen && !isLoggedIn) {
            
            // Opens the login screen
            openLoginScreen();
            
        // If the login screen is already open or the user is not logged in
        } else {
            
            // If the login screen is already open, then display a message
            if (isLoginScreenOpen) {
                // Display a message
                JOptionPane.showMessageDialog(null, "Login is already open", "Login", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            
            // If the user is already logged in, then display a message
            if (isLoggedIn) {
               // Display a message
                JOptionPane.showMessageDialog(null, "You are already logged in.", "Login", javax.swing.JOptionPane.INFORMATION_MESSAGE);                
            }
            
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    // This method is called when the gray logout button is clicked (at the top)
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        
        // The logout button action listener (the button is located on the top banner next to the login button) 
        
        // If the person is logged in
        if (isLoggedIn) {
            
            // Sets the isLoggedIn variable to false
            isLoggedIn = false;
            
            // If they were logged in as an admin, they they set it to false now
            if (isLoggedInAsAdmin) {
                isLoggedInAsAdmin = false;
            }
            
            // Closes any screens that the user may have had open except the help screen
            closeAllScreens();
            
            // Opens the login screen
            openLoginScreen();
            
            // Clears the username
            setUsernameLabel("");
            
        // If the user is not logged in then print a message
        } else {
            
            // Prints a message that lets them know that they are not logged in
            JOptionPane.showMessageDialog(null, "You are not logged in!", "Logout", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
        }
        
    }//GEN-LAST:event_logoutButtonActionPerformed

    // This method is called when the manage accounts file menu item is clicked
    private void manageAccountsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsMenuItemActionPerformed
        
        // This method is triggered when the Manage Accounts menu item is clicked under File
        
        // If the person is logged in as an administrator
        if (isLoggedIn && isLoggedInAsAdmin) {
            
            // If the manage accounts screen is alrady open then displa a message
            if (isManageAccountsScreenOpen) {
                
                // Display a message
                JOptionPane.showMessageDialog(null, "Manage Accounts is already open.", "Manage Accounts", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            // Else if the screen is not open then open the screen
            } else {
                
                // Opens the ManageAccounts screen
                 openManageAccountsScreen();  
             
            }
 
                        
        // If the person is not logged in as an administrator            
        } else {
            
            // A message pops up
            JOptionPane.showMessageDialog(null, "You must be logged in as an administrator!", "Manage Accounts", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }//GEN-LAST:event_manageAccountsMenuItemActionPerformed

    // This method is called when the home button is clicked (blue button next to the gray logout button at the top)
    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed

        // If the user is logged in
        if (isLoggedIn) {
            
            // If the home main menu screen is not open, then open it
            if (!isGradeSelectScreenOpen) {
                
                // Creates a new GradeSelect screen
                gradeSelect = new GradeSelect(this);
                
                // Sets the isGradeSelectScreenOpen variable to true
                isGradeSelectScreenOpen = true;
                
                // Adds the screen to the desktop pane
                desktopPane.add(gradeSelect);
                
                // Brings the screen to the front
                gradeSelect.toFront();
            
            // Else if the screen is already open
            } else {
                
                // Display a message
                JOptionPane.showMessageDialog(null, "The main menu is already open.", "Main Menu", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                
            }
            
        // Else if the person is not logged in
        } else {
            
            // Display a message
            JOptionPane.showMessageDialog(null, "You must be logged in to access the main menu.", "Main Menu", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }//GEN-LAST:event_homeButtonActionPerformed

    // This method is triggered when the printer button is clicked (at the top right of the screen)
    private void printerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printerButtonActionPerformed
        
        // If the user is logged in then open the print report screen
        if (isLoggedIn) {

            // Open Print Report screen
            openPrintReportScreen();
            
        // If the user is not logged in then display a message
        } else {
            
            // Display a message
            JOptionPane.showMessageDialog(null, "You must be logged in to print a report.", "Print Reports", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        }
        
    }//GEN-LAST:event_printerButtonActionPerformed

    // This method is triggerd when the help button (at the top banner on the right) is clicked
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        
        // If the help screen is not open
        if (!isHelpScreenOpen) {
            
            // Opens the help screen
            openHelpScreen();
            
        // If the help screen is already open
        } else {
            
            // Display a message
            JOptionPane.showMessageDialog(null, "The help screen is already open.", "Help", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
        }
        
    }//GEN-LAST:event_helpButtonActionPerformed

    public String getUsername(){
        
        return usernameLabel2.getText();
    }
    
    /**
     * @param args the command line arguments
     * This is the main method that sets this JFrame form visible upon starting.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JMenuItem manageAccountsMenuItem;
    private javax.swing.JButton printerButton;
    private javax.swing.JLabel starsLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel2;
    // End of variables declaration//GEN-END:variables
}
