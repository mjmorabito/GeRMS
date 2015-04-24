/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/08/15
 * Purpose: The client requested a math tutoring software for elementary school children.
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * This is the KN1 class which extends JInternalFrame.
 * This is class contains the counting quiz practice which uses
 * the logic from the QuizSample class to generate sequences of numbers with
 * a missing entry denoted by a question mark based on the 
 * KN1 Pre-K and K standard for counting numbers up to 20.
 */
public class KN1 extends javax.swing.JInternalFrame {

    //Creates an instance of the Main class
    private Main main;

    //Creates a new Quiz Sample (which holds the logic for KN1)
    QuizSample q = new QuizSample();

    // Stores the user's choices for answers
    private int[] choices = new int[4];

    // Initializes the counterDifficulty to 1, Ranges from 1 - 3
    private int counterDifficulty = 1;

    // ImageIcon for the correct answer
    private ImageIcon correctImageIcon;

    // ImageIcon for the incorrect answer
    private ImageIcon incorrectImageIcon;

    // Stores the count of number of questions asked
    private int questionCount = 1;

    /**
     * Creates new form of KN1, the Counting Quiz
     */
    public KN1(Main m) {

        // Initializes the components
        initComponents();

        // Sets the buttons for the easy question
        setButtons();

        // Stores the reference to the main class
        main = m;

        //centers the standard
        centerOnScreen();

        // ImageIcons for the correct, and incorrect buttons
        correctImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerCorrect.jpg"));
        incorrectImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerIncorrect.jpg"));

    }

    // This method centers this form in the middle of the screen
    public void centerOnScreen() {

        // Gets the dimension of the main desktop pane
        Dimension desktopSize = main.getDesktopPaneDimension();

        // Gets the size of this JInternalFrame
        Dimension jInternalFrameSize = this.getSize();

        // Centers this JInternalFrame in the DesktopPane
        this.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

    }

    /**
     * This method sets all of the buttons by using the Quiz Sample class object
     * to initialize all of the buttons and the sequence that the user will see.
     */
    private void setButtons() {

        //Only set this questions 1-3
        if (counterDifficulty < 4) {

            //Creates the elements of the Quiz Sample class: 4 answer choices and a sequence of numbers
            q.initializeElements(counterDifficulty);

            //Set the text of the buttons to the answer choices, one of which is correct
            String answerOne = q.getAns1();
            jButton1.setText(answerOne);

            String answerTwo = q.getAns2();
            jButton2.setText(answerTwo);

            String answerThree = q.getAns3();
            jButton3.setText(answerThree);

            String answerFour = q.getAns4();
            jButton4.setText(answerFour);

            //Clears the icon from the buttons
            jButton1.setIcon(null);
            jButton2.setIcon(null);
            jButton3.setIcon(null);
            jButton4.setIcon(null);

            //Sets the jLabel's text to the number sequence from the QuizSample class
            jLabel1.setText(q.getNumberList());

            //Increments the counter difficulty
            counterDifficulty++;
            
        } else //exit the program
        {
            // Closes this screen
            this.dispose();

            // States that the Screen is now closed
            main.setIsKN1ScreenOpen(false);

            // Opens the PreKK module
            main.openPreKK();
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rightArrow = new javax.swing.JButton();
        counterLabel = new javax.swing.JLabel();
        helpAudioButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Counting: Easy Practice Question");
        setToolTipText("KN1");
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jButton1.setBackground(new java.awt.Color(230, 126, 34));

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        jButton1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 126, 34));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(230, 126, 34));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("D");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(230, 126, 34));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("C");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 28)); // NOI18N
        jLabel1.setText("Question");

        rightArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/RightArrow.png"))); // NOI18N
        rightArrow.setToolTipText("");
        rightArrow.setBorderPainted(false);
        rightArrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightArrowActionPerformed(evt);
            }
        });

        counterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        counterLabel.setText("1/3");

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
                .addGap(203, 203, 203)
                .addComponent(counterLabel)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(helpAudioButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(helpAudioButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(counterLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(rightArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Determines the contents of the button that was pressed
        String answer = ((JButton) evt.getSource()).getText();

        //Determines the correct answer based on the quiz
        String correct = q.getCorrectAnswer() + "";

        //Determines if the answer was correct
        if (answer.equals(correct)) {

            //Adds correct to the answer choice that was chosen
            ((JButton) evt.getSource()).setIcon(correctImageIcon);

        } else {

            //Adds the incrrect sign to the answer choice chosen
            ((JButton) evt.getSource()).setIcon(incorrectImageIcon);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Determines the contents of the button that was pressed
        String answer = ((JButton) evt.getSource()).getText();

        //Determines the correct answer based on the quiz
        String correct = q.getCorrectAnswer() + "";

        //Determines if the answer was correct
        if (answer.equals(correct)) {

            //Adds correct image to the answer choice that was chosen
           ((JButton) evt.getSource()).setIcon(correctImageIcon);

        } else {

           //Adds the incorrect image to the answer choice that was chosen                
            ((JButton) evt.getSource()).setIcon(incorrectImageIcon);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         //Determines the contents of the button that was pressed
        String answer = ((JButton) evt.getSource()).getText();

        //Determines the correct answer based on the quiz
        String correct = q.getCorrectAnswer() + "";

        //Determines if the answer was correct
        if (answer.equals(correct)) {
    
            //Adds correct image to the answer choice that was chosen
            ((JButton) evt.getSource()).setIcon(correctImageIcon);

        } else {
            
            //Adds the incorrect image to the answer choice that was chosen
            ((JButton) evt.getSource()).setIcon(incorrectImageIcon);

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Determines the contents of the button that was pressed
        String answer = ((JButton) evt.getSource()).getText();

        //Determines the correct answer based on the quiz
        String correct = q.getCorrectAnswer() + "";

        //Determines if the answer was correct
        if (answer.equals(correct)) {
            
            //Adds correct to the answer choice that was chosen
            ((JButton) evt.getSource()).setIcon(correctImageIcon);

        } else {
            //set the button to show the incorrect answer
            ((JButton) evt.getSource()).setIcon(incorrectImageIcon);

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        
        main.setIsKN1ScreenOpen(false);
    }//GEN-LAST:event_formInternalFrameClosed

    private void rightArrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightArrowActionPerformed

        // Increments the questionCount
        questionCount++;

        // Sets the String for the title of this form
        String title = "";
        System.out.println("Right arrow was pressed");

        if (questionCount == 2) {
            
            //Sets the counter label to 2/3
            counterLabel.setText(counterDifficulty + "/3");
            
            if (counterDifficulty == 2) {
                title = "Counting: Medium Practice Question";
                setButtons();
                this.setTitle(title);
            }
        } else if (questionCount == 3) {
            
            //Sets the counter label to 3/3
            if (counterDifficulty == 3) {
                title = "Counting: Hard Practice Question";
                setButtons();
                this.setTitle(title);
            }
        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "You are done with the practice questions for Counting.\nClick ok to continue.", "Practice", JOptionPane.INFORMATION_MESSAGE);

            // Closes this screen
            this.dispose();

            // Tells main that the screen is now closed
            main.setIsKN1ScreenOpen(false);

            // Opens the PreKK module
            main.openPreKK();

        }


    }//GEN-LAST:event_rightArrowActionPerformed

    private void helpAudioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButton1ActionPerformed
        /*
         * This is the code to play the audio tutorial .wav file.
         */

        // Creates a File object that is linked the GeRMSLogin.wav filepath
        File yourFile = new File("src/Sounds/KN1.wav");

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterLabel;
    private javax.swing.JButton helpAudioButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton rightArrow;
    // End of variables declaration//GEN-END:variables
}
