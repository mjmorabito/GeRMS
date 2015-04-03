/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/02/15
 * Purpose: The client requested a math tutoring software for elementary school children.
 * For this phase of the project the client assigned us to script a prototype portion of the user interface.
 * (Not everything). We were told to select the most important part of your project and simply develop one modular to
 */
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.JDesktopPane;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/*
* This is the class for the login screen JInternalFrame
* This screen allows the user to enter a username and password then click login.
* This screen allows the user to click the register button to register as a new user.
* There is an audio button on this screen that plays an audio tutorial to help the user.
*/
public class Login extends JInternalFrame {

    // The main class
    private Main main;
    
    // The desktop pane from the main class
    private JDesktopPane mainDesktopPane;
    
    // variables needed to make connection with DB
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://localhost/germs"; 
   
    /**
     * Creates new form LoginScreen
     */
    public Login(Main g, JDesktopPane desktopPane) {
        
        // Initializes the components on the Login Screen
        initComponents();
        
        // Sets the reference to the DesktopPane from the main screen
        mainDesktopPane = desktopPane;
        
        // Sets the reference to the Main class
        main = g;
        
        // Gets the dimension of the main desktop pane
        Dimension desktopSize = mainDesktopPane.getSize();
                
        // Gets the size of this JInternalFrame
        Dimension jInternalFrameSize = this.getSize();
        
        // Centers this JInternalFrame in the DesktopPane
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);        
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordField = new javax.swing.JPasswordField();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        forgotPasswordLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        helpAudioButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Login");
        setToolTipText("Login");
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        passwordField.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        usernameTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N

        passwordLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        passwordLabel.setText("Password:");

        usernameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        usernameLabel.setText("Username:");

        forgotPasswordLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        forgotPasswordLabel.setForeground(new java.awt.Color(0, 0, 204));
        forgotPasswordLabel.setText("Forgot Password?");
        forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordLabelMouseClicked(evt);
            }
        });

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginScreen/loginRocket.jpg"))); // NOI18N
        loginButton.setIconTextGap(0);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginScreen/registerButton.jpg"))); // NOI18N
        registerButton.setIconTextGap(0);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginScreen/logo.jpg"))); // NOI18N

        helpAudioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AudioButton.png"))); // NOI18N
        helpAudioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAudioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(helpAudioButton))
                    .addComponent(forgotPasswordLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginButton)
                        .addGap(18, 18, 18)
                        .addComponent(registerButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel)
                            .addComponent(usernameLabel))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(helpAudioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addComponent(registerButton))
                .addContainerGap())
        );

        setBounds(0, 0, 750, 536);
    }// </editor-fold>//GEN-END:initComponents

    // This method is triggered when the "Forgot Password?" text is clicked    
    private void forgotPasswordLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordLabelMouseClicked

        // If the forgot password scren is already open then display a message
        if (main.getIsForgotPasswordScreenOpen()) {
            
            // Display a message
            JOptionPane.showMessageDialog(null, "The forgot password screen is already open.", "Forgot Password", JOptionPane.INFORMATION_MESSAGE);
            
        // Else if the forgot password screen is not open then open the screen
        } else {
         
            // Opens the forgot password screen
            main.openForgotPasswordScreen();            
            
        }

    }//GEN-LAST:event_forgotPasswordLabelMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        /*
        * This method is triggered when the rocket ship (login button) is clicked
        * First we confirm that the username exists.
        * If the usernane exists then we check if the password matches the password in the database
        * If the password matches then we close the login screen and then open the GradeSelect screen.
        */
        
        // Try/catch for the ClassNotFoundException and SQLException
        try {

            // MySQL Driver
            Class.forName(dbClassName);

            // user/pwd to connect to DB
            Properties p = new Properties();
            p.put("user","GermsAdmin");
            p.put("password","g3rm5p0w3ru53r");

            // DB connection
            Connection conn = DriverManager.getConnection(CONNECTION,p);

            // Get username and password
            String user = usernameTextField.getText();
            char[] pass = passwordField.getPassword();
            String password = "";
            for (int i = 0; i < pass.length; i++) {
                password += pass[i];
            }

            // get firstname and query the users table to get result
            Statement stmt = conn.createStatement();
            String sql;
            sql = "select * from accounts where accUser = '" + user + "'";
            ResultSet rs = stmt.executeQuery(sql);

            //if user exists, all fields associate to that user from table
            if (rs.next() == true){

                String id = rs.getString("accUser");
                String fname = rs.getString("accfirstname");
                String lname = rs.getString("acclastname");
                String pwd = rs.getString("accpassword");

                //check if password matches with whatever the user entered.
                // if yes, show all info on screen
                if(pwd.equals(password)) {
                    
                    // Closes the login screen
                    this.dispose();
                    main.setIsLoginScreenOpen(false);
                    
                    // Sets LoggedIn to true
                    main.setIsLoggedIn(true);
                    
                    // Displays the username of the person that logged in
                    main.setUsernameLabel(user);

                    // If the person that logged in was an administrator
                    if (user.equals("admin")) {
                        
                        // Set the LoggedInAsAdmin variable to true
                        main.setIsLoggedInAsAdmin(true);
                        
                        // Opens the ManageAccounts Screen
                        main.openManageAccountsScreen();                        
                        
                    } else {
                        
                        // Opens the GradeSelect Screen
                        main.openGradeSelectScreen();                          
                        
                    }

                } else { // if password did not match, show message
                    JOptionPane.showMessageDialog(null, "Wrong password", "Password", JOptionPane.INFORMATION_MESSAGE);
                }
            } else { // if user does not exist, show message
                JOptionPane.showMessageDialog(null, "Wrong username", "Username", JOptionPane.INFORMATION_MESSAGE);
            }
            // close all connection to DB
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }

    }//GEN-LAST:event_loginButtonActionPerformed

    // This method is triggered when the register button is clicked (the yellow door)    
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
   
        // If the register screen is already open then display a message
        if (main.getIsRegisterScreenOpen()) {
            
            // Show message
            JOptionPane.showMessageDialog(null, "Register screen is already open.", "Register", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            
            // Opens the register screen
            main.openRegisterScreen();            
        
        }
        
    }//GEN-LAST:event_registerButtonActionPerformed

    // This method is triggered when the help audio button is clicked
    private void helpAudioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButtonActionPerformed

        /*
        * This is the code to play the audio tutorial .wav file.
        */
        
        // Creates a File object that is linked the GeRMSLogin.wav filepath
        File yourFile = new File("src/Sounds/GeRMSLogin.wav");

        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;

        // A try/catch block to play the .wav file
        try {
            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_helpAudioButtonActionPerformed

    // When this JInternalFrame is closed then this method is called
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        
        // Sets the variable that determines if the login screen is open to false on the main class
        main.setIsLoginScreenOpen(false);        
        
    }//GEN-LAST:event_formInternalFrameClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JButton helpAudioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

}