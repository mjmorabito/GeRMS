/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/30/15
 * Purpose: In this project, you and your partners will work to write a program to 
 * create a Math Tutor Software System to help elementary school students.
 *
 * This software will help elementary school students to study and practice math skills.
 *
 * The math curriculum information in Massachusetts is in following link: 
 * http://www.doe.mass.edu/frameworks/math/2000/toc.html
 *
 * The client requests following features as minimum:
 *     practice test materials
 *     tutorials
 *     printing the record(test results)
 *     different level tests for each grade
 *     security(log-in, log-out)
 *     Reward
 *
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
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

    // Driver for the MySQL database
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    
    // Connection to the database
    private static final String CONNECTION = "jdbc:mysql://localhost/germs";
    
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
    
    // ChangeAdminPassword class
    private ChangeAdminPassword changeAdminPassword;
    
    // Determines if the ChangeAdminPassword Screen is open
    private boolean isChangeAdminPasswordScreenOpen = false; 
    
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
    
    // Class for the QuizDifficultySelectGrade4
    private QuizDifficultySelectGrade4 quizDifficultySelectGrade4;
    
    // Determines  if the quizDifficultySelectGrade4 screen is open
    private boolean isQuizDifficultySelectGrade4Open = false;
    
      // Class for the Assessment
    private Assessment assessment;
  
    // Determines  if the Assessment screen is open
    private boolean isAssessmentScreenOpen = false;
    
     // Class for the Assessment
    private AssessmentGrade2 assessmentGrade2;
    
    // Determines  if the Assessment screen is open
    private boolean isAssessmentGrade2ScreenOpen = false;
    
     // Class for the QuizDifficultySelectGrade2
    private QuizDifficultySelectGrade2 quizDifficultySelectGrade2;
    
    // Determines  if the quizDifficultySelectGrade2 screen is open
    private boolean isQuizDifficultySelectGrade2Open = false;
  
      // Class for the Assessment
    private AssessmentGrade4 assessmentGrade4;
    
    // Determines  if the Assessment screen is open
    private boolean isAssessmentGrade4ScreenOpen = false;
    
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
    
    // FinalReport class
    private FinalReport finalReport;
    
    // Determines if the Final screen is open / closed
    private boolean isFinalReportScreenOpen = false; 
    
    // Stars array
    private JLabel[] stars = new JLabel[9];
    
    // Print Reports screen
    private PrintReports printReports;
    
    // Determines if the PrintReports screen is open
    private boolean isPrintReportsScreenOpen = false;
    
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
        starLabel1 = new javax.swing.JLabel();
        starLabel2 = new javax.swing.JLabel();
        starLabel3 = new javax.swing.JLabel();
        starLabel4 = new javax.swing.JLabel();
        starLabel5 = new javax.swing.JLabel();
        starLabel6 = new javax.swing.JLabel();
        starLabel7 = new javax.swing.JLabel();
        starLabel8 = new javax.swing.JLabel();
        starLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        manageAccountsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GeRMS Math Tutor");
        setExtendedState(4);
        setFocusCycleRoot(false);

        usernameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        usernameLabel.setText("Username:");

        starsLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
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

        usernameLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N

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

        starLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

        starLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png"))); // NOI18N

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(starsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1102, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(starLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(starLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
    
    // This method sets the isChangeAdminPasswordOpen variable to true/false
    public void setIsChangeAdminPasswordScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isChangeAdminPasswordScreenOpen = isOpen;
        
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
    
    
    
    
      // This method sets the isAssessmentScreenOpen variable to true/false
    public void setIsQuizDifficultySelectGrade4(boolean isOpen) {
        
        // Sets the variable
        isQuizDifficultySelectGrade4Open = isOpen;
        
    }
    
      // This method sets the isAssessmentScreenOpen variable to true/false
    public void setIsAssessmentGrade4ScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isAssessmentGrade4ScreenOpen = isOpen;
        
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
    
   
        // This method sets the isAssessmentScreenOpen variable to true/false
    public void setIsAssessmentGrade2ScreenOpen(boolean isOpen) {
        
        // Sets the variable
        isAssessmentGrade2ScreenOpen = isOpen;
        
    }
    // This method sets the isGrades1and2Module variable to true/false
    public void setIsGrade1and2ModuleOpen(boolean isOpen){
        
        //Set the variable
        isGrades1and2ModuleOpen = isOpen;
        
    }
   
    // This method sets the isQuizReportScreenOpen variable to true/false
    public void setIsQuizReportScreenOpen(boolean isOpen){
        
        //Set the variable
        isQuizReportScreenOpen = isOpen;
        
    }
    
    // This method sets the isFinalReportScreenOpen variable to true/false
    public void setIsFinalReportScreenOpen(boolean isOpen){
        
        //Set the variable
        isFinalReportScreenOpen = isOpen;
        
    }
    
    // This method sets the isPrintReportsScreenOpen variable to true/false
    public void setisPrintReportsScreenOpen(boolean isOpen){
        
        //Set the variable
        isPrintReportsScreenOpen = isOpen;
        
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
    
     // This method returns the boolean value of isRegisterScreenOpen
    public boolean getIsAssessmentGrade4ScreenOpen() {
        
        // Returns the boolean value
        return isAssessmentGrade4ScreenOpen;
        
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
    
    // This method gets the boolean value of isFinalReportScreenOpen variable
    public boolean getIsFinalReportScreenOpen(){
        
        // Returns the variable
        return isFinalReportScreenOpen;
        
    }
    
    // This method gets the boolean value of isPrintReportsScreenOpen variable
    public boolean getIsPrintReportsScreenOpen(){
        
        // Returns the variable
        return isPrintReportsScreenOpen;
        
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
        
        if (!isManageAccountsScreenOpen) {
        
            // Creates a new ManageAccounts class
            manageAccounts = new ManageAccounts(this);

            // Sets the variable to true;
            isManageAccountsScreenOpen = true;

            // Adds the screen to the desktop pane
            desktopPane.add(manageAccounts);

            // Brings the screen to the front
            manageAccounts.toFront();
            
        }
        
    }
    
    // This method creates an instance of the ManageAccounts screen
    public void openChangeAdminPasswordScreen() {
        
        // If the change admin password screen is not open
        
        if (!isChangeAdminPasswordScreenOpen) {
        
            // Creates a new ManageAccounts class
            changeAdminPassword = new ChangeAdminPassword(this);

            // Sets the variable to true;
            isChangeAdminPasswordScreenOpen = true;

            // Adds the screen to the desktop pane
            desktopPane.add(changeAdminPassword);

            // Brings the screen to the front
            changeAdminPassword.toFront();
            
        }
        
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
        
        if (!isPrintReportsScreenOpen) {
        
            // Creates a new PrintReports class
            printReports = new PrintReports(this);

            // Sets the variable to true
            isPrintReportsScreenOpen = true;

            // Adds the screen to the desktop pane
            desktopPane.add(printReports);

            // Brings the screen to the front
            printReports.toFront();
            
        }
        
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
    
     
    // This method creates an instance of the Quiz Difficulty select screen
    public void openQuizDifficultySelectGrade4() {
        
        if (isQuizDifficultySelectGrade4Open == false) {
        
            // Creates a new KN1
            quizDifficultySelectGrade4 = new QuizDifficultySelectGrade4(this);
            
            //FIX THIS

            // Sets the variable
            isQuizDifficultySelectGrade4Open = true;

            // Adds the KN8 screen to the desktop pane
            desktopPane.add(quizDifficultySelectGrade4);

            // Brings the KN8 screen to the front
            quizDifficultySelectGrade4.toFront(); 
            
        } else {
            
            
        }
        
    }
    
    
    // This method creates an instance of the Quiz Difficulty select screen
    public void openQuizDifficultySelectGrade2() {
        
        if (isQuizDifficultySelectGrade2Open == false) {
        
            // Creates a new KN1
            quizDifficultySelectGrade2 = new QuizDifficultySelectGrade2(this);

            // Sets the variable
            isQuizDifficultySelectGrade2Open = true;

            // Adds the KN8 screen to the desktop pane
            desktopPane.add(quizDifficultySelectGrade2);

            // Brings the KN8 screen to the front
            quizDifficultySelectGrade2.toFront(); 
            
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
    
       // This method creates an instance of the Assessment1 screen
    public void openAssessmentScreenGrade2(int a, int b) {
        
        if(isAssessmentGrade2ScreenOpen == false)
        {
        // Creates a new Assessment
        assessmentGrade2 = new AssessmentGrade2(this,a,b);
        
        // Sets the variable
        isAssessmentGrade2ScreenOpen = true;
        
        // Adds the Assessment screen to the desktop pane
        desktopPane.add(assessmentGrade2);
        
        // Brings the Assessment screen to the front
        assessmentGrade2.toFront(); 
        }
    }
    
       // This method creates an instance of the Assessment1 screen
    public void openAssessmentScreenGrade4(int a, int b) {
        
        if(isAssessmentGrade4ScreenOpen == false)
        {
        // Creates a new Assessment
        assessmentGrade4 = new AssessmentGrade4(this,a,b);
        
        // Sets the variable
        isAssessmentGrade4ScreenOpen = true;
        
        // Adds the Assessment screen to the desktop pane
        desktopPane.add(assessmentGrade4);
        
        // Brings the Assessment screen to the front
        assessmentGrade4.toFront(); 
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
    public void openQuizReportScreen(int[] results, int grade, int difficulty, String[] kns) {
        
        // If the screen is not already open, then open it
        if (isQuizReportScreenOpen == false) {
        
            // Creates a new QuizReport
            quizReport = new QuizReport(this, results, grade, difficulty, kns);

            // Sets the variable
            isQuizReportScreenOpen = true;

            // Adds the KN8 screen to the desktop pane
            desktopPane.add(quizReport);

            // Brings the KN8 screen to the front
            quizReport.toFront();  
            
        }
        
    }
    
    // This method creates an instance of the FinalReport screen
    public void openFinalReportScreen(int[] results, String[] standards, int grade) {
        
        // If the screen is not already open, then open it
        if (isFinalReportScreenOpen == false) {
        
            // Creates a new FinalReport
            finalReport = new FinalReport(this, results, standards, grade);

            // Sets the variable
            isFinalReportScreenOpen = true;

            // Adds the screen to the desktop pane
            desktopPane.add(finalReport);

            // Brings the KN8 screen to the front
            finalReport.toFront();  
            
        }
        
    }
    
    // This method closes all of the screens that are open upon log out
    public void closeAllScreens() {
        
        // if the grade select screen is open, then close it
        if (isGradeSelectScreenOpen) {
            
            // Closes the grade select screen
            closeGradeSelectScreen();
            
        }
        
        // If PreKK Screen is open
        if (isPreKKOpen) {
            
            // Close
            closePreKKScreen();
            
        }
        
        // If Grades1and2 Screen is open
        if (isGrades1and2ModuleOpen) {
            
            // Close
            closeGrades1and2Screen();
            
        }
        
        // If Grades3and4 Screen is open
        if (isGrades3and4ModuleOpen) {
            
            // Close
            closeGrades3and4Screen();
            
        }
        
        // If manage accounts screen is open
        if (isManageAccountsScreenOpen) {
            
            // Close
            closeManageAccountsScreen();
            
        }
        
        // If change admin password screen is open
        if (isChangeAdminPasswordScreenOpen) {
            
            // Close
            closeChangeAdminPasswordScreen();
            
        }
        
        // If help screen is open
        if (isHelpScreenOpen) {
            
            // Close
            closeHelpScreen();
            
        }
        
        // If KN1 screen is open
        if (isKN1ScreenOpen) {
            
            // Close
            closeKN1Screen();
            
        }
        
        // If KN2 screen is open
        if (isKN2ScreenOpen) {
            
            // Close
            closeKN2Screen();
            
        }
         
        // If KN3 screen is open
        if (isKN3ScreenOpen) {
            
            // Close
            closeKN3Screen();
            
        }
        
        // If KN4 screen is open
        if (isKN4ScreenOpen) {
            
            // Close
            closeKN4Screen();
            
        }
        
        // If KN5 screen is open
        if (isKN5ScreenOpen) {
            
            // Close
            closeKN5Screen();
            
        }
        
        // If KN6 screen is open
        if (isKN6ScreenOpen) {
            
            // Close
            closeKN6Screen();
            
        }
        
        // If KN7 screen is open
        if (isKN7ScreenOpen) {
            
            // Close
            closeKN7Screen();
            
        }
        
        // If KN8 screen is open
        if (isKN8ScreenOpen) {
            
            // Close
            closeKN8Screen();
            
        }
        
        // If G2N4 screen is open
        if (isG2N4ScreenOpen) {
            
            // Close
            closeG2N4Screen();
            
        }
        
         // If G4N12 screen is open
        if (isG4N12ScreenOpen) {
            
            // Close
            closeG4N12Screen();
            
        }
        
         // If QuizDifficultySelect screen is open
        if (isQuizDifficultySelectOpen) {
            
            // Close
            closeQuizDifficultySelectScreen();
            
        }
        
        // If QuizDifficultySelectGrade2 screen is open
        if (isQuizDifficultySelectGrade2Open) {
            
            // Close
            closeQuizDifficultySelectGrade2Screen();
            
        }
        
         // If QuizDifficultySelectGrade4 screen is open
        if (isQuizDifficultySelectGrade4Open) {
            
            // Close
            closeQuizDifficultySelectGrade4Screen();
            
        }
        
         // If Assessment screen is open
        if (isAssessmentScreenOpen) {
            
            // Close
            closeAssessment();
            
        }
        
         // If Assessment Grade 2 screen is open
        if (isAssessmentGrade2ScreenOpen) {
            
            // Close
            closeAssessmentGrade2();
            
        }
        
         // If Assessment Grade 4 screen is open
        if (isAssessmentGrade4ScreenOpen) {
            
            // Close
            closeAssessmentGrade4();
            
        }
        
         // If PrintReports Screen is open
        if (isPrintReportsScreenOpen) {
            
            // Close
            closePrintReportsScreen();
            
        }
        
         // If QuizReport Screen is open
        if (isQuizReportScreenOpen) {
            
            // Close
            closeQuizReportScreen();
            
        }
        
         // If FinalReport Screen is open
        if (isFinalReportScreenOpen) {
            
            // Close
            closeFinalReportScreen();
            
        }
                       
    }  
    
    // This method disposes of the GradeSelect screen
    public void closeGradeSelectScreen() {
        
        // Disposes of the grade select screen
        gradeSelect.dispose();
   
        // Set the variable to false
        isGradeSelectScreenOpen = false;
        
    }   
    
    // This method disposes of the PreKKScreen
    public void closePreKKScreen() {
        
        // Disposes of the PreKKScreen screen
        preKK.dispose();
   
        // Set the variable to false
        isPreKKOpen = false;      
        
    }
    
    // This method disposes of the Grades1and2 Module
    public void closeGrades1and2Screen() {
        
        // Disposes of the Grades1and2 Module
        grades1and2.dispose();
   
        // Set the variable to false
        isGrades1and2ModuleOpen = false;      
        
    }
    
    // This method disposes of the Grades3and4 Module
    public void closeGrades3and4Screen() {
        
        // Disposes of the Grades3and4 Module
        grades3and4.dispose();
   
        // Set the variable to false
        isGrades3and4ModuleOpen = false;      
        
    }
    
    // This method disposes of the ManageAccounts
    public void closeManageAccountsScreen() {
        
        // Disposes of the ManageAccounts screen
        manageAccounts.dispose();
   
        // Set the variable to false
        isManageAccountsScreenOpen = false;      
        
    }
    
    // This method disposes of the Change Admin Password screen
    public void closeChangeAdminPasswordScreen() {
        
        // Disposes of the ManageAccounts screen
        changeAdminPassword.dispose();
   
        // Set the variable to false
        isChangeAdminPasswordScreenOpen = false;      
        
    }
    
    // This method disposes of the HelpScreen
    public void closeHelpScreen() {
        
        // Disposes of the HelpScreen screen
        help.dispose();
   
        // Set the variable to false
        isHelpScreenOpen = false;      
        
    }
    
    // This method disposes of the KN1
    public void closeKN1Screen() {
        
        // Disposes of the KN1 screen
        kn1.dispose();
   
        // Set the variable to false
        isKN1ScreenOpen = false;      
        
    }
  
    // This method disposes of the KN2
    public void closeKN2Screen() {
        
        // Disposes of the KN1 screen
        kn2.dispose();
   
        // Set the variable to false
        isKN2ScreenOpen = false;      
        
    }

    // This method disposes of the KN3
    public void closeKN3Screen() {
        
        // Disposes of the KN1 screen
        kn3.dispose();
   
        // Set the variable to false
        isKN3ScreenOpen = false;      
        
    }
    
    // This method disposes of the KN4
    public void closeKN4Screen() {
        
        // Disposes of the KN4 screen
        kn4.dispose();
   
        // Set the variable to false
        isKN4ScreenOpen = false;      
        
    }
    
    // This method disposes of the KN5
    public void closeKN5Screen() {
        
        // Disposes of the KN1 screen
        kn5.dispose();
   
        // Set the variable to false
        isKN5ScreenOpen = false;      
        
    }
    
    // This method disposes of the KN6
    public void closeKN6Screen() {
        
        // Disposes of the KN6 screen
        kn6.dispose();
   
        // Set the variable to false
        isKN6ScreenOpen = false;      
        
    }
    
    // This method disposes of the KN7
    public void closeKN7Screen() {
        
        // Disposes of the KN7 screen
        kn7.dispose();
   
        // Set the variable to false
        isKN7ScreenOpen = false;      
        
    }
    
    // This method disposes of the KN8
    public void closeKN8Screen() {
        
        // Disposes of the KN8 screen
        kn8.dispose();
   
        // Set the variable to false
        isKN8ScreenOpen = false;      
        
    }
    
    // This method disposes of the G2N4
    public void closeG2N4Screen() {
        
        // Disposes of the KN8 screen
        g2n4.dispose();
   
        // Set the variable to false
        isG2N4ScreenOpen = false;      
        
    }
    
    // This method disposes of the G4N12
    public void closeG4N12Screen() {
        
        // Disposes of the KN8 screen
        g4n12.dispose();
   
        // Set the variable to false
        isG4N12ScreenOpen = false;      
        
    }
            
    // This method disposes of the QuizDifficultySelectScreen
    public void closeQuizDifficultySelectScreen() {
        
        // Disposes of the QuizDifficultySelectScreen screen
        quizDifficultySelect.dispose();
   
        // Set the variable to false
        isQuizDifficultySelectOpen = false;      
        
    }
    
    // This method disposes of the QuizDifficultySelectGrade2Screen
    public void closeQuizDifficultySelectGrade2Screen() {

        // Disposes of the QuizDifficultySelectGrade2Screen
        quizDifficultySelectGrade2.dispose();

        // Set the variable to false
        isQuizDifficultySelectGrade2Open = false;

    }
    
    // This method disposes of the QuizDifficultySelectGrade4Screen
    public void closeQuizDifficultySelectGrade4Screen() {
        
        // Disposes of the QuizDifficultySelectGrade4Screen
        quizDifficultySelectGrade4.dispose();
   
        // Set the variable to false
        isQuizDifficultySelectGrade4Open = false;      
        
    }
    
    // This method disposes of the Assessment
    public void closeAssessment() {
        
        // Disposes of the Assessment
        assessment.dispose();
   
        // Set the variable to false
        isAssessmentScreenOpen = false;      
        
    }
    
     
    // This method disposes of the AssessmentGrade2
    public void closeAssessmentGrade2() {
        
        // Disposes of the Assessment Grade 2
        assessmentGrade2.dispose();
   
        // Set the variable to false
        isAssessmentGrade2ScreenOpen = false;      
        
    }
    
    
    // This method disposes of the Assessment Grade 4
    public void closeAssessmentGrade4() {
        
        // Disposes of the Assessment Grade 4
        assessmentGrade4.dispose();
   
        // Set the variable to false
        isAssessmentGrade4ScreenOpen = false;      
        
    }
    
    // This method disposes of the PrintReports Screen
    public void closePrintReportsScreen() {
        
        // Disposes of the Assessment Grade 4
        printReports.dispose();
   
        // Set the variable to false
        isPrintReportsScreenOpen = false;      
        
    }
    
    // This method disposes of the QuizReport Screen
    public void closeQuizReportScreen() {
        
        // Disposes of the Assessment Grade 4
        quizReport.dispose();
   
        // Set the variable to false
        isQuizReportScreenOpen = false;      
        
    }
    
    // This method disposes of the FinalReport Screen
    public void closeFinalReportScreen() {
        
        // Disposes of the Assessment Grade 4
        finalReport.dispose();
   
        // Set the variable to false
        isFinalReportScreenOpen = false;      
        
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
            
            checkStars();
            
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
                
                // Closes all the screens that are open
                closeAllScreens();
                
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

    /* This method displays the number of stars the user has earned
    * at the top of the screen. Once logged out, this method is called
    * to clear the stars.
    */
    public void checkStars() {
        
        // Stores the JLabels used to display the stars
        stars[0] = starLabel1;
        stars[1] = starLabel2;
        stars[2] = starLabel3;
        stars[3] = starLabel4;
        stars[4] = starLabel5;
        stars[5] = starLabel6;
        stars[6] = starLabel7;
        stars[7] = starLabel8;
        stars[8] = starLabel9;
        
        // Set the icons to empty stars
        for (int i = 0; i < stars.length; i++) {
            stars[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/EmptyStar.png")));
        }
        
        // Stores the quizzes the user has completed (0 not completed, 1 completed)
        int quizzesCompleted[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        
        // Stores the number of stars the user has earned
        int numberOfStars = 0;
        
        // Selects the quizzes completed from the DB
        try {
            
            // MySQL Driver
            Class.forName(dbClassName);

            // user/pwd to connect to DB
            Properties p = new Properties();
            p.put("user","GermsAdmin");
            p.put("password","g3rm5p0w3ru53r");

            // DB connection
            Connection conn = DriverManager.getConnection(CONNECTION,p);
            
            // get firstname and query the users table to get result
            Statement stmt = conn.createStatement();
            String sql;
            String user = getUsername();
            
            // Get all quizzes from the user
            // Qgrade=1 is for PreK-K. change =2 for grade 1,2 and =3 for 3-4
            sql = "select * from quizzes where QaccUser = '" + user + "' AND QgradeID=1 and Qcorrectanswers>=4;";
            ResultSet rs = stmt.executeQuery(sql);
            
            // Sets the 4th, 5th, and 6th stars
            while (rs.next() == true){
                int difficulty = rs.getInt("Qdifficulty");
                switch (difficulty){
                    case 1:
                        quizzesCompleted[0] = 1;
                        break;
                    case 2:
                        quizzesCompleted[0] = 1;
                        quizzesCompleted[1] = 1;
                        break;
                    case 3:
                        quizzesCompleted[0] = 1;
                        quizzesCompleted[1] = 1;
                        quizzesCompleted[2] = 1;
                        break;
                }
            }
            
            sql = "select * from quizzes where QaccUser = '" + user + "' AND QgradeID=2 and Qcorrectanswers>=4;";
            rs = stmt.executeQuery(sql);
            
            // Sets the 4th, 5th, and 6th stars
            while (rs.next() == true){
                int difficulty = rs.getInt("Qdifficulty");
                switch (difficulty){
                    case 1:
                        quizzesCompleted[3] = 1;
                        break;
                    case 2:
                        quizzesCompleted[3] = 1;
                        quizzesCompleted[4] = 1;
                        break;
                    case 3:
                        quizzesCompleted[3] = 1;
                        quizzesCompleted[4] = 1;
                        quizzesCompleted[5] = 1;
                        break;
                }
            }
            
            sql = "select * from quizzes where QaccUser = '" + user + "' AND QgradeID=3 and Qcorrectanswers>=4;";
            rs = stmt.executeQuery(sql);
            
            // Sets the 4th, 5th, and 6th stars
            while (rs.next() == true){
                int difficulty = rs.getInt("Qdifficulty");
                switch (difficulty){
                    case 1:
                        quizzesCompleted[6] = 1;
                        break;
                    case 2:
                        quizzesCompleted[6] = 1;
                        quizzesCompleted[7] = 1;
                        break;
                    case 3:
                        quizzesCompleted[6] = 1;
                        quizzesCompleted[7] = 1;
                        quizzesCompleted[8] = 1;
                        break;
                }
            }
            
            // close all connection to DB
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e) {
        
        }
        
        // counts the number of stars the user has
        for (int i = 0; i < quizzesCompleted.length; i++) {
            
            numberOfStars += quizzesCompleted[i];
            
        }
        
        // Displays the stars
        for (int i = 0; i < numberOfStars; i++) {
            
            stars[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/FullStar.png")));
            
        }
        
        
    }
    
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
    private javax.swing.JLabel starLabel1;
    private javax.swing.JLabel starLabel2;
    private javax.swing.JLabel starLabel3;
    private javax.swing.JLabel starLabel4;
    private javax.swing.JLabel starLabel5;
    private javax.swing.JLabel starLabel6;
    private javax.swing.JLabel starLabel7;
    private javax.swing.JLabel starLabel8;
    private javax.swing.JLabel starLabel9;
    private javax.swing.JLabel starsLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel2;
    // End of variables declaration//GEN-END:variables
}
