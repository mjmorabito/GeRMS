
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
 * @author MarkMorabito
 */
public class G4N12 extends javax.swing.JInternalFrame {

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

    // Stores an array of operations (addition = 1, subtraction = 2, multiplication = 3)
    private int[] operationsArray = new int[10];

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

    // Numbers to be added, subtracted, or multiplied
    private int num1 = 0;
    private int num2 = 0;

    /**
     * Creates new form G4N12
     */
    public G4N12(Main m) {

        // Initializes the components
        initComponents();

        // Sets the reference to the main class
        main = m;
        // Centers the JInternalFrame on the screen
        centerOnScreen();

        // ImageIcons for the neutral, correct, and incorrect buttons
        neutralImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerNeutral.jpg"));
        correctImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerCorrect.jpg"));
        incorrectImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerIncorrect.jpg"));

        for (int i = 0; i < 10; i++) {
            operationsArray[i] = i % 3 + 1;
        }

        generateEasyQuestion();

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

    // This method is called when the form is created, it generates an easy question
    public void generateEasyQuestion() {

        System.out.println("generate easy question");

        // Randomly picks a number form (1-3)
        // 1 represents addition, 2 subtraction and 3 multiplication
        questionNum = (int) (Math.random() * ((3 - 1) + 1)) + 1;
        int difficulyLevel = 1;
        System.out.println("the number is : " + questionNum);
        int temp = 0;
        if (questionNum == 1 || questionNum == 2) {
            //Generates two three digit numbers for addition or subtract
            num1 = ((int) (Math.random() * (10)) + 1) * 100 + ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);
            num2 = ((int) (Math.random() * (10)) + 1) * 100 + ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);
        } else if (questionNum == 3) {
            //Generates two one digit numbers for multiplication
            num1 = ((int) (Math.random() * (10)) + 1);
            num2 = ((int) (Math.random() * (10)) + 1);
        }

        //Swaps num1 and num2 so that there are no negative numbers for subtraction
        if (num2 > num1) {
            temp = num2;
            num2 = num1;
            num1 = temp;

        }
        String operand = "";
        String s = "";
        if (questionNum == 1) {
            operand = "+";
            answer = num1 + num2;

            s = "<html> " + num1 + "<br>+" + num2 + "</html>";
        }
        if (questionNum == 2) {
            operand = "-";
            answer = num1 - num2;

            s = "<html> " + num1 + "<br>-" + num2 + "</html>";
        }
        if (questionNum == 3) {
            operand = "x";
            answer = num1 * num2;

            s = "<html> " + num1 + "<br>x" + num2 + "</html>";
        }
        questionString = s;
        // Sets the icon for the question using HTML
        jLabel1.setText(s);

        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoices();

    }

    // This method is called when the form is created, it generates an medium question
    public void generateMediumQuestion() {

        System.out.println("generate medium question");

        // Randomly picks a number form (1-3)
        // 1 represents addition, 2 subtraction and 3 multiplication
        questionNum = (int) (Math.random() * ((3 - 1) + 1)) + 1;
        int difficulyLevel = 2;
        System.out.println("the number is : " + questionNum);
        int temp = 0;
        if (questionNum == 1 || questionNum == 2) {
            //Generates two three digit numbers for addition or subtract
            num1 = ((int) (Math.random() * (10)) + 1) * 1000 + ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);
            num2 = ((int) (Math.random() * (10)) + 1) * 1000 + ((int) (Math.random() * (10)) + 1) * 100 + ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);

            //Swaps num1 and num2 so that there are no negative numbers for subtraction
            if (num2 > num1) {
                temp = num2;
                num2 = num1;
                num1 = temp;

            }
        } else if (questionNum == 3) {
            //Generates two one digit numbers for multiplication
            num1 = ((int) (Math.random() * (10)) + 10);
            num2 = ((int) (Math.random() * (10)) + 10);
        }
        String operand = "";
        String s = "";
        if (questionNum == 1) {
            operand = "+";
            answer = num1 + num2;

            s = "<html> " + num1 + "<br>+" + num2 + "</html>";
        }
        if (questionNum == 2) {
            operand = "-";
            answer = num1 - num2;

            s = "<html> " + num1 + "<br>-" + num2 + "</html>";
        }
        if (questionNum == 3) {
            operand = "x";
            answer = num1 * num2;

            s = "<html> " + num1 + "<br>x" + num2 + "</html>";
        }

        questionString = s;
        // Sets the icon for the question using HTML
        jLabel1.setText(s);

        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoices();
    }

    // This method is called when the form is created, it generates an medium question
    public void generateHardQuestion() {

        System.out.println("generate medium question");

        // Randomly picks a number form (1-3)
        // 1 represents addition, 2 subtraction and 3 multiplication
        //questionNum = (int) (Math.random() * ((3 - 1) + 1)) + 1;
        int difficulyLevel = 3;
        System.out.println("the number is : " + questionNum);

        if (questionNum == 1 || questionNum == 2) {
            //Generates two three digit numbers for addition or subtract
            num1 = ((int) (Math.random() * (10)) + 1) * 10000 + ((int) (Math.random() * (10)) + 1) * 1000 + ((int) (Math.random() * (10)) + 1) * 100 + ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);
            num2 = ((int) (Math.random() * (10)) + 1) * 10000 + ((int) (Math.random() * (10)) + 1) * 1000 + ((int) (Math.random() * (10)) + 1) * 100 + ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);
        } else if (questionNum == 3) {

            //Generates two one digit numbers for multiplication no matter what questionNum is
            num1 = ((int) (Math.random() * (10)) + 1) * 100 + ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);
            num2 = ((int) (Math.random() * (10)) + 1) * 10 + ((int) (Math.random() * (10)) + 1);

            String operand = "";

            String s = "";
            if (questionNum == 1) {
                operand = "+";
                answer = num1 + num2;

                s = "<html> " + num1 + "<br>+" + num2 + "</html>";
            }
            if (questionNum == 2) {
                operand = "-";
                answer = num1 - num2;

                s = "<html> " + num1 + "<br>-" + num2 + "</html>";
            }
            if (questionNum == 3) {

                operand = "x";
                answer = num1 * num2;

                s = "<html> " + num1 + "<br>x" + num2 + "</html>";
            }

            questionString = s;
            // Sets the icon for the question using HTML
            jLabel1.setText(s);

            // Fills the choices with 1 correct answer and 3 incorrect answers
            fillChoices();
        }
    }

    public void fillChoices() {

        /*
         * An int array with four elements is used to store the possible answers
         */
        // Resets the array to -1
        for (int i = 0; i < choices.length; i++) {
            choices[i] = -1;
        }

        // Randomly picks an index from 0-3 to put the correct answer in the array
        int indexOfAnswer = (int) (Math.random() * ((3 - 0) + 1)) + 0;

        // Puts the correct answer in the selected index
        choices[indexOfAnswer] = answer;

        // This integer is used to store the value of the randomly chosen incorrect answer
        int choice = 0;

        // Loops through the 4 possible choices
        for (int i = 0; i < choices.length; i++) {

            // If one of the 4 possible choices have not been assigned a value yet
            if (choices[i] == -1) {

                // Code to assign a random value between 0-10 to this choice
                // Determines if the value has already been assigned
                boolean choiceExists = true;

                // Loops until a value that has not already been assigned is chosen
                while (choiceExists) {

                    // Randomly picks a number between answer +/-2
                    choice = (int) (Math.random() * (4)) + answer - 2;

                    // Sets the variable to does not exist
                    choiceExists = false;

                    // Loops through the selected values
                    for (int c = 0; c < choices.length; c++) {

                        // If a match is found in the array
                        if (choices[c] == choice) {

                            // Then that means the chosen value is a duplicate
                            choiceExists = true;

                        }

                    }

                }

                // Stores the value of the choice in this array
                choices[i] = choice;

            }

        }

        // Sets the text of the four JButtons with the choices for answers
        jButton1.setText("" + choices[0]);
        jButton2.setText("" + choices[1]);
        jButton3.setText("" + choices[2]);
        jButton4.setText("" + choices[3]);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        helpAudioButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Math: Easy Practice Question");
        setToolTipText("Math");
        setVisible(true);

        jButton2.setBackground(new java.awt.Color(230, 126, 34));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setText("1/3");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/RightArrow.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(230, 126, 34));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(230, 126, 34));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 28)); // NOI18N

        jButton1.setBackground(new java.awt.Color(230, 126, 34));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(helpAudioButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpAudioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
            title = "Math with Drawings: Medium Practice Question";

        } else if (questionCount == 3) {

            // Resets the ImageIcons of the JButtons on the screen to neutral
            jButton1.setIcon(neutralImageIcon);
            jButton2.setIcon(neutralImageIcon);
            jButton3.setIcon(neutralImageIcon);
            jButton4.setIcon(neutralImageIcon);

            // Generate a hard question
            generateHardQuestion();

            // Title of the form
            title = "Math with Drawings: Hard Practice Question";

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "You are done with the practice questions for Math with Drawings.\nClick ok to continue.", "Practice", JOptionPane.INFORMATION_MESSAGE);

            // Closes this screen
            this.dispose();

            main.setIsG4N12ScreenOpen(false);

            // Opens the PreKK module
            main.openGrades3and4Module();

        }

        // Sets the question questionCount on the screen
        jLabel2.setText(questionCount + "/3");

        // Sets the title of the form
        this.setTitle(title);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // If the user has not submitted a question     
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // If the user has not submitted a question     
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

        // If the user has not submitted a question     
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

    private void helpAudioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButton1ActionPerformed
        /* This is the code to play the audio tutorial .wav file.
        */
        
        // Creates a File object that is linked the GeRMSLogin.wav filepath
        File yourFile = new File("src/Sounds/G4N12.wav");

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
     * The following three methods are used in the AssessmentGrade4 class
     * for tests and quizzes.
     */
    public ImageIcon getImage() {
        return questionIcon;
    }

    public String getQuestionString() {
        return questionString;
    }

    public int[] getChoices() {
        return choices;
    }

    public int getAnswer() {
        return answer;
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
