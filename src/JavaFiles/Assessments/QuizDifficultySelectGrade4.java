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
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markmorabito
 */
public class QuizDifficultySelectGrade4 extends javax.swing.JInternalFrame {

    Main main;

    // Variables needed to make connection with DB
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://localhost/germs";

    /**
     * Creates new form QuizDifficultySelectGrade4
     */
    public QuizDifficultySelectGrade4(Main m) {
        main = m;
        initComponents();
        
         // Gets the dimension of the main desktop pane
        Dimension desktopSize = main.getDesktopPaneDimension();
                
        // Gets the size of this JInternalFrame
        Dimension jInternalFrameSize = this.getSize();
        
        // Centers this JInternalFrame in the DesktopPane
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);
        
        checkStars();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        starLabel1 = new javax.swing.JLabel();
        easyButtonClicked = new javax.swing.JButton();
        starLabel2 = new javax.swing.JLabel();
        mediumButtonClicked = new javax.swing.JButton();
        starLabel3 = new javax.swing.JLabel();
        hardButtonClicked = new javax.swing.JButton();
        helpAudioButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Difficulty Select for Grades 3-4");
        setVisible(true);

        starLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/EmptyStar.png"))); // NOI18N

        easyButtonClicked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/Easy.jpg"))); // NOI18N
        easyButtonClicked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyButtonClickedActionPerformed(evt);
            }
        });

        starLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/EmptyStar.png"))); // NOI18N

        mediumButtonClicked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/Medium.jpg"))); // NOI18N
        mediumButtonClicked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumButtonClickedActionPerformed(evt);
            }
        });

        starLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/EmptyStar.png"))); // NOI18N

        hardButtonClicked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/Hard.jpg"))); // NOI18N
        hardButtonClicked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardButtonClickedActionPerformed(evt);
            }
        });

        helpAudioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AudioButton.png"))); // NOI18N
        helpAudioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAudioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(easyButtonClicked)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(starLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mediumButtonClicked)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hardButtonClicked)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(starLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(starLabel3)
                        .addGap(88, 88, 88)
                        .addComponent(helpAudioButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(starLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(starLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(starLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(helpAudioButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(easyButtonClicked)
                    .addComponent(mediumButtonClicked)
                    .addComponent(hardButtonClicked))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void easyButtonClickedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyButtonClickedActionPerformed

        // Easy difficulty quiz
        main.openAssessmentScreenGrade4(6, 1);
        
        // Disposes this screen
        main.closeQuizDifficultySelectGrade4Screen();

    }//GEN-LAST:event_easyButtonClickedActionPerformed

    private void mediumButtonClickedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumButtonClickedActionPerformed

        // Medium difficulty quiz
        main.openAssessmentScreenGrade4(6, 2);
        
        // Disposes this screen
        main.closeQuizDifficultySelectGrade4Screen();
    }//GEN-LAST:event_mediumButtonClickedActionPerformed

    private void hardButtonClickedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardButtonClickedActionPerformed

        // Hard difficulty quiz
        main.openAssessmentScreenGrade4(6, 3);
        
        // Disposes this screen
        main.closeQuizDifficultySelectGrade4Screen();
    }//GEN-LAST:event_hardButtonClickedActionPerformed

    private void helpAudioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButton1ActionPerformed
         /*
        * This is the code to play the audio tutorial .wav file.
        */

        // Creates a File object that is linked the QuizDifficultySelect.wav filepath
        File yourFile = new File("src/Sounds/QuizDifficultySelect.wav");

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
    }//GEN-LAST:event_helpAudioButton1ActionPerformed

    private void checkStars(){
        
        try{
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
            String user = main.getUsername();
            
            // Get all quizzes from the user
            // Qgrade=1 is for PreK-K. change =2 for grade 1,2 and =3 for 3-4
            sql = "select * from quizzes where QaccUser = '" + user + "' AND QgradeID=3 and qcorrectanswers>=4;";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next() == true){
                int difficulty = rs.getInt("Qdifficulty");
                switch (difficulty){
                    case 1:
                        starLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/FullStar.png")));
                        break;
                    case 2:
                        starLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/FullStar.png")));
                        starLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/FullStar.png")));
                        break;
                    case 3:
                        starLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/FullStar.png")));
                        starLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/FullStar.png")));
                        starLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QuizDifficultySelect/FullStar.png")));
                        break;
                }
            }
            // close all connection to DB
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton easyButtonClicked;
    private javax.swing.JButton hardButtonClicked;
    private javax.swing.JButton helpAudioButton1;
    private javax.swing.JButton mediumButtonClicked;
    private javax.swing.JLabel starLabel1;
    private javax.swing.JLabel starLabel2;
    private javax.swing.JLabel starLabel3;
    // End of variables declaration//GEN-END:variables
}
