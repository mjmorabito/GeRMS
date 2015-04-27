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
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samir
 */
public class G2N4 extends javax.swing.JInternalFrame {

    
    // Stores a reference to the main class
    private Main main;
   
    
    // ImageIcon for the question
    private ImageIcon questionIcon = new ImageIcon();
    
     // ImageIcon for the question
    private String questionString;

    
    // Random number to decide which question to use
    private int questionNum;
    
    // Stores the correct answer to the question
    private int answer;
    
    // Stores the user's choices for answers
    private int[] choices = new int[4];
    
    // Stores the count of number of questions asked
    private int questionCount = 1;
    
    // ImageIcon for the neutral answer button
    private ImageIcon neutralImageIcon;
    
    // ImageIcon for the correct answer
    private ImageIcon correctImageIcon;
    
    // ImageIcon for the incorrect answer
    private ImageIcon incorrectImageIcon;
    
    // Boolean to restrict the user one submission per question
    private boolean answerSubmitted = false;
    
    // Generates two numbers for comparison puposes
    int num1;
    int num2;
    
    //String for labeltext
    String labelText;
    
    /**
     * Creates new form G2N4
     */
    public G2N4(Main m) {
        
        // Initializes the components
        initComponents();
        
        // Sets the reference to the main class
        main = m;
        // Centers the JInternalFrame on the screen
        centerOnScreen();
        
        // ImageIcons for the neutral, correct, and incorrect buttons
        neutralImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerNeutral.png"));
        correctImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerCorrect.png"));
        incorrectImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerIncorrect.png"));
        
        num1 = 0;
        num2 = 0;
        jButton4.setVisible(false);
        labelText = "";
        answer = 4;
        //NEW I JUST CHANGED
        generateEasyQuestion();
        
    }
    
    // This method centers this form in the middle of the screen
    public void centerOnScreen() {
        
         // Gets the dimension of the main desktop pane
        Dimension desktopSize = main.getDesktopPaneDimension();
                
        // Gets the size of this JInternalFrame
        Dimension jInternalFrameSize = this.getSize();
        
        // Centers this JInternalFrame in the DesktopPane
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);
        
    }

    // This method is called when the form is created, it generates an easy question
    public void generateEasyQuestion() {
        //System.out.println("generate easy question");
        // Randomly picks a number form (1-3)
        questionNum = (int)(Math.random())*3 + 1;
        System.out.println("QuestionNum which determines the answer,randomly, in G2N4 is " + questionNum);
        
        num1 = (int)(Math.random()*(100)) + (int)(Math.random()*(10))+ 1;
        num2 = (int)(Math.random()*(100)) + (int)(Math.random()*(10))+ 1;
        //Have them be the same
        
        
        //Gaurantee that num1 is bigger than num2 and NOT equal
        while(num2 > num1 || num2 ==num1)
            
            //JUST CHANGED
        {
            num2 = (int)(Math.random()*(100)) + (int)(Math.random()*(10))+ 1;
        }
        int difficulyLevel = 1;
        System.out.println("the number is : " + questionNum);
        
        // If the value picked is 1, a fewer than question will be asked
        if (questionNum == 1) {
            
            //Num2 < Num1
            jLabel1.setText(num2 +  " ? " + num1);
            labelText = num2 +  " ? " + num1;        
            
            System.out.println("LESS THAN");
            // Sets the answer
            answer = 1;
            
        // If the value picked is 2, a same as question will be asked
        } else if (questionNum == 2) {
            
            jLabel1.setText(num2 +  " ? " + num2);
             labelText = num2 +  " ? " + num2; 
            System.out.println("EQUAL TO");
            // Sets the answer
            answer = 2;
            
        // If the value picked is 3, a one more than question will be asked
        } else if (questionNum == 3) {
            
            
              //Num1 < Num2
            jLabel1.setText(num1 +  " ? " + num2);
             labelText = num1 +  " ? " + num2; 
            
            System.out.println("GREATER THAN");
            // Sets the answer
            answer = 3;
            
        }
        
            
        
        
        // Sets the icon for the question
       // jLabel1.setIcon(questionIcon);
        
        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoices();
        
    }
    
    // This method generates a medium difficulty question
    public void generateMediumQuestion() {
    System.out.println("generate medium question");
        // Randomly picks a number form (1-3)
        questionNum = (int)(Math.random()*( (3-1) + 1)) + 1;
        
        num1 = (int)(Math.random()*(1000))+(int)(Math.random()*(100)) + (int)(Math.random()*(10))+ 1;
        num2 = (int)(Math.random()*(100)) +(int)(Math.random()*(10))+ 1;
        
        
        //Gaurantee that num1 is bigger than num2
        while(num2 > num1)
        {
            num2 = (int)(Math.random()*(100)) +(int)(Math.random()*(10))+ 1;
        }
        int difficulyLevel = 2;
        System.out.println("the number is : " + questionNum);
        
        // If the value picked is 1, a fewer than question will be asked
        if (questionNum == 1) {
            
            //Num2 < Num1
            jLabel1.setText(num2 +  " ? " + num1);
            labelText = num2 +  " ? " + num1;      
            
            System.out.println("LESS THAN");
            // Sets the answer
            answer = 1;
            
        // If the value picked is 2, a same as question will be asked
        } else if (questionNum == 2) {
            
            jLabel1.setText(num2 +  " ? " + num2);
             labelText = num2 +  " ? " + num2; 
            System.out.println("EQUAL TO");
            // Sets the answer
            answer = 2;
            
        // If the value picked is 3, a one more than question will be asked
        } else if (questionNum == 3) {
            
            
              //Num1 < Num2
            jLabel1.setText(num1 +  " ? " + num2);
             labelText = num1 +  " ? " + num2; 
            
            System.out.println("GREATER THAN");
            // Sets the answer
            answer = 3;
            
        }
        
            
        
        
        // Sets the icon for the question
       // jLabel1.setIcon(questionIcon);
        
        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoices();
    }
    
    // This method generates a hard difficulty question
    public void generateHardQuestion() {
    System.out.println("generate hard question");
        // Randomly picks a number form (1-3)
        questionNum = (int)(Math.random()*( (3-1) + 1)) + 1;
        
        num1 = (int)(Math.random()*(1000))+(int)(Math.random()*(100)) + (int)(Math.random()*(10))+ 1;
        num2 = num1 - ((int)(Math.random()*(10))+ 1);
        
        
        
        int difficulyLevel = 3;
        System.out.println("the number is : " + questionNum);
        
        // If the value picked is 1, a fewer than question will be asked
        if (questionNum == 1) {
            
            //Num2 < Num1
            jLabel1.setText(num2 +  " ? " + num1);
             labelText = num2 +  " ? " + num1; 
                    
            
            System.out.println("LESS THAN");
            // Sets the answer
            answer = 1;
            
        // If the value picked is 2, a same as question will be asked
        } else if (questionNum == 2) {
            
            jLabel1.setText(num2 +  " ? " + num2);
             labelText = num2 +  " ? " + num2; 
            System.out.println("EQUAL TO");
            // Sets the answer
            answer = 2;
            
        // If the value picked is 3, a one more than question will be asked
        } else if (questionNum == 3) {
            
            
              //Num1 < Num2
            jLabel1.setText(num1 +  " ? " + num2);
             labelText = num1 +  " ? " + num2; 
            
            System.out.println("GREATER THAN");
            // Sets the answer
            answer = 3;
            
        }
        
            
        
        
        // Sets the icon for the question
       // jLabel1.setIcon(questionIcon);
        //NEW STUFF MUST CHANGE
        jLabel1.setText(labelText);
        
        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoices();
    
    }
    
    /*
    * This method is called after a question is generated.
    * Four values are assigned to the text of the four JButtons on the screen
    * which are designated for the answers to the question.
    * Each value is unique meaning no duplicate values, and one of the values
    * is the correct answer to the question.
    */
    public void fillChoices() {
        
  
        choices[0] = 1;
        choices[1] = 2;
        choices[2] = 3;
        choices[3] = 4;
        
        
        // Sets the text of the four JButtons with the choices for answers
        jButton1.setText("<");
        jButton2.setText("=");
        jButton3.setText(">");
        jButton4.setText("more than");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        helpAudioButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Comparing Numbers: Easy Practice Question");
        setToolTipText("Comparing Numbers");
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

        jButton4.setBackground(new java.awt.Color(230, 126, 34));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 28)); // NOI18N

        jButton1.setBackground(new java.awt.Color(230, 126, 34));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(230, 126, 34));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/RightArrow.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setText("1/3");

        jButton2.setBackground(new java.awt.Color(230, 126, 34));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helpAudioButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(0, 67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(helpAudioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton5)
                            .addGap(30, 30, 30))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // This method is called when the form closes
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
     
        // Set the variable to false which means this form is not open
        main.setIsG2N4ScreenOpen(false);
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        // If the user has not submitted an answer
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (choices[3] == answer) {
                // Display the correct answer image
                jButton4.setIcon(correctImageIcon);

            } else {
                // Display the incorrect answer image
                jButton4.setIcon(incorrectImageIcon);

            }

            // Prevents the user from submitting another answer
            answerSubmitted = true;

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "Click the blue arrow to continue", "Next", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // If the user has not picked an answer to the question
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (choices[0] == answer) {

                // Display the correct answer image
                jButton1.setIcon(correctImageIcon);

            } else {

                // Display the incorrect answer image
                jButton1.setIcon(incorrectImageIcon);

            }

            // Prevents the user from submitting another answer
            answerSubmitted = true;

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "Click the blue arrow to continue", "Next", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
System.out.println("Choices 2");
        // If the user has not submitted an answer
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (choices[2] == answer) {

                // Display the correct answer image
                jButton3.setIcon(correctImageIcon);

            } else {

                // Display the incorrect answer image
                jButton3.setIcon(incorrectImageIcon);

            }

            // Prevents the user from submitting another answer
            answerSubmitted = true;

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "Click the blue arrow to continue", "Next", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
  // Allows the user to submit an answer
        answerSubmitted = false;

        // Increments the questionCount
        questionCount++;

        // String for the title of this form
        String title = "";

        // If the current question number is the second question
        if (questionCount == 2) {

            // Resets the ImageIcons of the JButtons on the screen to neutral
            jButton1.setIcon(neutralImageIcon);
            jButton2.setIcon(neutralImageIcon);
            jButton3.setIcon(neutralImageIcon);
            jButton4.setIcon(neutralImageIcon);

            // Generate a medium question
            generateMediumQuestion();

            // Title of the form
            title = "Comparing Numbers: Medium Practice Question";

        } else if (questionCount == 3) {

            // Resets the ImageIcons of the JButtons on the screen to neutral
            jButton1.setIcon(neutralImageIcon);
            jButton2.setIcon(neutralImageIcon);
            jButton3.setIcon(neutralImageIcon);
            jButton4.setIcon(neutralImageIcon);

            // Generate a hard question
            generateHardQuestion();

            // Title of the form
            title = "Comparing Numbers: Hard Practice Question";

        } else {
            
            String user = main.getUsername();
            dbClass db = new dbClass();
            db.completepractice(user, "2N4");

            // Display a message
            JOptionPane.showMessageDialog(null, "You are done with the practice questions for Comparing Numbers.\nClick ok to continue.", "Practice", JOptionPane.INFORMATION_MESSAGE);

            // Closes this screen
            this.dispose();

            main.setIsKN4ScreenOpen(false);

            // Opens the Grade 1 and 2 module
            main.openGrades1and2Module();

        }

        // Sets the question questionCount on the screen
        jLabel2.setText(questionCount+"/3");

        // Sets the title of the form
        this.setTitle(title);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         // If the user has not submitted a question
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (choices[1] == answer) {

                // Display the correct answer image
                jButton2.setIcon(correctImageIcon);

            } else {

                // Display the incorrect answer image
                jButton2.setIcon(incorrectImageIcon);

            }

            // Prevents the user from submitting another answer
            answerSubmitted = true;

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "Click the blue arrow to continue", "Next", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void helpAudioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButton1ActionPerformed
         /*
        * This is the code to play the audio tutorial .wav file.
        */

        // Creates a File object that is linked the GeRMSLogin.wav filepath
        File yourFile = new File("src/Sounds/G2N4.wav");

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
    
    /*
    * The following three methods are used in the Assessment class
    * for tests and quizzes to link to the KN4
    */
    public ImageIcon getImage()
    {
       return questionIcon; 
    }

    public int[] getChoices()
    {
        return choices;
    }
    
    public int getAnswer()
    {
        return answer;
    }
    
    public String getLabelText()
    {
        return labelText;
    }
   

    public String getQuestionString() {
        return questionString;
    }

   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton helpAudioButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
