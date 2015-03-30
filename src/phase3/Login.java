/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

import javax.swing.JDesktopPane;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;

/**
 *
 * @author Samir
 */
public class Login extends javax.swing.JInternalFrame {

    private JDesktopPane mainDesktopPane;
    private Main main;

   // variables needed to make connection with DB
   private static final String dbClassName = "com.mysql.jdbc.Driver";
   private static final String CONNECTION = "jdbc:mysql://localhost/germs";    
    
    /**
     * Creates new form Login
     */
    public Login(JDesktopPane desktopPane, Main g) {
        initComponents();
        mainDesktopPane = desktopPane;
        main = g;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        loginButton1 = new javax.swing.JButton();
        forgotPasswordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Images/logo.jpg"))); // NOI18N
        jLabel1.setName("logoLabel"); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        passwordLabel.setText("Password:");

        usernameTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Images/loginRocket.jpg"))); // NOI18N
        loginButton.setIconTextGap(0);
        loginButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        loginButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Images/registerButton.jpg"))); // NOI18N
        loginButton1.setIconTextGap(0);
        loginButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        loginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton1ActionPerformed(evt);
            }
        });

        forgotPasswordLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        forgotPasswordLabel.setForeground(new java.awt.Color(0, 0, 204));
        forgotPasswordLabel.setText("Forgot Password?");
        forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordLabelMouseClicked(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        helpAudioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Image/GradeSelect/AudioButton.png"))); // NOI18N
        helpAudioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAudioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forgotPasswordLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loginButton1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(passwordLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(passwordField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(usernameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(195, 195, 195))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(helpAudioButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(helpAudioButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addComponent(loginButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("logoLabel");

        setBounds(170, 15, 974, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void forgotPasswordLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordLabelMouseClicked
        // TODO add your handling code here:
        ForgotPassword forgotPassword = new ForgotPassword();
        mainDesktopPane.add(forgotPassword);
        forgotPassword.toFront();
    }//GEN-LAST:event_forgotPasswordLabelMouseClicked

    private void loginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton1ActionPerformed
        // TODO add your handling code here:
        Register register = new Register();
        mainDesktopPane.add(register);
        register.toFront();
    }//GEN-LAST:event_loginButton1ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        main.setIsLoginScreenOpen(false);
    }//GEN-LAST:event_formInternalFrameClosed

    private void helpAudioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_helpAudioButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
  
        try {

        Class.forName(dbClassName);
        // user/pwd to connect to DB
        Properties p = new Properties();
        p.put("user","GermsAdmin");
        p.put("password","g3rm5p0w3ru53r");
        
            JOptionPane.showMessageDialog(null, "1", "Password", JOptionPane.INFORMATION_MESSAGE);
        
        // DB connection
        Connection conn = DriverManager.getConnection(CONNECTION,p);
            JOptionPane.showMessageDialog(null, "2", "Password", JOptionPane.INFORMATION_MESSAGE);
        
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
         int id = rs.getInt("accUser");
         String fname = rs.getString("accfirstname");
         String lname = rs.getString("acclastname");
         String pwd = rs.getString("accpassword");

         //check if password matches with whatever the user entered.
         // if yes, show all info on screen
         if(pwd.equals(password))
         {
             GradeSelect gradeSelect = new GradeSelect();
             this.dispose();
         }else{ // if password did not match, show message
            JOptionPane.showMessageDialog(null, "Wrong password", "Password", JOptionPane.INFORMATION_MESSAGE);
         }
      }else{ // if user does not exist, show message
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JButton helpAudioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton loginButton1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
