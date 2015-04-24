

import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;



/**
 *
 * @author Samir
 */
public class Assessment extends javax.swing.JInternalFrame {
 // Stores a reference to the main class
    private Main main;
    
    // Variables needed to make connection with DB
   private static final String dbClassName = "com.mysql.jdbc.Driver";
   private static final String CONNECTION = "jdbc:mysql://localhost/germs";  
    
    // ImageIcon for the question
    private ImageIcon questionIcon = new ImageIcon();
    
   
    //Determines the question difficulty from 1 - 3
    private int difficulty;
    
    // Stores the correct answer to the question
    private int answer;
    
    // Stores the user's choices for answers
    private int[] choices = new int[4];
    
    //Stores user's choices and answer for kn3 and kn6 answers
    private ArrayList<String> AnsArray = new ArrayList<String>(4);
    
    private String correctAnswer;
    
    // Stores the user's choices for answers
    private int[] questions ;
    
    // Stores the count of number of questions asked
    private int questionCount = -1;
    
    private int currentPage = 1;
    // ImageIcon for the neutral answer button
    private ImageIcon neutralImageIcon;
    
    // ImageIcon for the correct answer
    private ImageIcon correctImageIcon;
    
    // ImageIcon for the incorrect answer
    private ImageIcon incorrectImageIcon;
    
    // Boolean to restrict the user one submission per question
    private boolean answerSubmitted = false;
    
    private int numQuestions;
    
    // Makes an object of each KN standard
    private QuizSample q;// For KN1
    
    private kn2Class kn2; // For KN2
    
    private KN3 kn3;
    
    private KN4 kn4;
    
    private KN5 kn5;
    
    private KN6 kn6;
    
    private KN7 kn7;
    
    private kn8Class kn8; // For KN8
    
    // Stores  correct / incorrect (1 or 0) for each question
    private int[] results;
    private String[] kns;
    
    /**
     * Creates new form Assessment
     */
  
    //COMMENTS
    
    public Assessment(Main m, int numQ,int diff) {
        
         // Sets the reference to the main class
        main = m;
        
        difficulty = diff;
        
        numQuestions = numQ;
        
        results = new int[numQuestions];
        kns = new String[numQuestions];
         
        questions = new int[numQuestions];
        // Initializes the components
        initComponents();
        
        jLabel2.setText(currentPage+"/"+numQuestions);
        
        determineQuestionsAndOrder();
        
        generateQuestion();
        
       
        
        // Centers the JInternalFrame on the screen
        centerOnScreen();
        
        // ImageIcons for the neutral, correct, and incorrect buttons
        neutralImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerNeutral.jpg"));
        correctImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerCorrect.jpg"));
        incorrectImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerIncorrect.jpg"));
        
        
        // Disables the first two buttons
        //jButton1.setVisible(false);
        //jButton2.setVisible(false);
        
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
  
    public void determineQuestionsAndOrder()
    {
        Random r = new Random();
        for( int i = 0; i < numQuestions; i++)
        {
            questions[i] = r.nextInt(8) + 1;
            kns[i] = "KN" + questions[i];
        }
        
    }
    
    public void generateQuestion()
    {
        String title = "";
        if(difficulty == 1)
        {
            title = title + "Easy ";
        }
        else if(difficulty == 2)
        {
            title = title + "Medium ";
        }
        else if(difficulty == 3)
        {
            title = title + "Hard ";
        }
        
        if(numQuestions == 6)
        {
            title = title + "Quiz";
        }
        else if (numQuestions == 10)
        {
            title = title + "Test";      
        }
             
        //Sets the title appropriately
        this.setTitle(title);
        jLabel1.setIcon(null);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jLabel1.setText("");
        
        System.out.println("Question count: " + questionCount);
        
        if (questionCount < numQuestions-1) {
            questionCount++;
        }
        System.out.println("After Question count: " +  questionCount);
        
        if(questions[questionCount] == 1)
        {
            //Sets the title
            this.setTitle(title);
            
            q = new QuizSample();
           
            //creates a question based on the difficult
            q.initializeElements(difficulty);
            
            //Set the text of the buttons to the answer choices, one of which is correct
            String answerOne = q.getAns1();
            jButton1.setText(answerOne);
            
            
             String answerTwo = q.getAns2();
            jButton2.setText(answerTwo); 
            
       
            String answerThree = q.getAns3();
            jButton3.setText(answerThree); 
            
            
            String answerFour = q.getAns4();
            jButton4.setText(answerFour);
          
            //Sets the jLabel's text to the number sequence from the QuizSample class
            jLabel1.setText(q.getNumberList());
            
            answer =  q.getCorrectAnswer();
            choices[0] = Integer.parseInt(q.getAns1());
            choices[1] = Integer.parseInt(q.getAns2());
            choices[2] = Integer.parseInt(q.getAns3());
            choices[3] = Integer.parseInt(q.getAns4());
            
            
            System.out.println("XXXThe correct answer is : " +  answer );
            
        }
        else if(questions[questionCount] == 2)
        {
            //Sets the title
            this.setTitle(title);
            
            kn2 = new kn2Class();
            int question = kn2.getQuestion(difficulty);
            
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/KN2/" + question + ".png")));

            //Set the text of the buttons to the answer choices, one of which is correct
            jButton1.setText(kn2.getAns1());
            jButton2.setText(kn2.getAns2());
            jButton3.setText(kn2.getAns3());
            jButton4.setText(kn2.getAns4());
            
            answer =  question;
            choices[0] = Integer.parseInt(kn2.getAns1());
            choices[1] = Integer.parseInt(kn2.getAns2());
            choices[2] = Integer.parseInt(kn2.getAns3());
            choices[3] = Integer.parseInt(kn2.getAns4());
            
            
            jLabel1.setText("");
            
        }
              else if(questions[questionCount] == 3)
        {
           //Sets the title
            this.setTitle(title);
        
            kn3 = new KN3(main);
            //do lots of stuff
            if (difficulty == 1)
            {
                
                 //get question and set JButtons
                correctAnswer = kn3.getEQuestion();
                jButton1.setText("First");
                jButton2.setText("Second");
                jButton3.setText("Third");
                jButton4.setText("Fourth");            
                
                answer = kn3.answerToInt(correctAnswer);
                questionIcon = kn3.getImage();
                choices = kn3.getChoices();
                AnsArray = kn3.getAnswerArray();
                jLabel1.setIcon(questionIcon);
                jLabel1.setText("");
                
            }
            
            if (difficulty == 2)
            {
                //get question and set JButtons
                correctAnswer = kn3.getMQuestion();
                jButton1.setText("First");
                jButton2.setText("Second");
                jButton3.setText("Third");
                jButton4.setText("Fourth");
        
                answer = kn3.answerToInt(correctAnswer);
                questionIcon = kn3.getImage();
                choices = kn3.getChoices();
                AnsArray = kn3.getAnswerArray();
                jLabel1.setIcon(questionIcon); 
                jLabel1.setText("");
                
                
            }
            if (difficulty == 3)
            {
                //get question and set JButtons
                correctAnswer = kn3.getHQuestion();
                jButton1.setText("Second");
                jButton2.setText("Third");
                jButton3.setText("Fourth");
                jButton4.setText("Fifth");
                
                answer = kn3.answerToInt(correctAnswer);
                questionIcon = kn3.getImage();
                choices = kn3.getChoices();
                AnsArray = kn3.getAnswerArray();
                jLabel1.setIcon(questionIcon);  
                jLabel1.setText("");
                
            }
        }
         else if(questions[questionCount] == 4)
        {
            //Sets the title
            this.setTitle(title);
        
            kn4 = new KN4(main);
            //do lots of stuff
            // Sets the text of the four JButtons with the choices for answers
            jButton1.setText("fewer");
            jButton2.setText("the same");
            jButton3.setText("one more than");
            jButton4.setText("more than");
            
            if (difficulty == 1)
            {
                
                kn4.generateEasyQuestion();
                
                questionIcon = kn4.getImage();
                choices = kn4.getChoices();
                jLabel1.setIcon(questionIcon); 
                
                
                answer = kn4.getAnswer();
                jLabel1.setText("");
                
                
            }
            
            if (difficulty == 2)
            {
                
                kn4.generateMediumQuestion();
                
                questionIcon = kn4.getImage();
                choices = kn4.getChoices();
                jLabel1.setIcon(questionIcon);
                
                answer = kn4.getAnswer();
                jLabel1.setText("");
                
            }
            if (difficulty == 3)
            {
                
                kn4.generateHardQuestion();
                
                questionIcon = kn4.getImage();
                choices = kn4.getChoices();
                jLabel1.setIcon(questionIcon);
                
                answer = kn4.getAnswer();
                jLabel1.setText("");
                
            }
        }
         else if(questions[questionCount] == 5)
        {
            //Sets the title
            this.setTitle(title);
            
            // Sets the text of the four JButtons with the choices for answers            
            jButton1.setText("Half");
            jButton2.setText("Whole");
            jButton3.setText("One Quarter");
            jButton4.setText("One Third");
            
            kn5 = new KN5(main);
            //do lots of stuff
            if (difficulty == 1)
            {
                
                kn5.generateEasyQuestion();
                
                questionIcon = kn5.getImage();
                choices = kn5.getChoices();
                jLabel1.setIcon(questionIcon);              
                answer = kn5.getAnswer();
                
                
            }
            
            if (difficulty == 2)
            {
                
                kn5.generateMediumQuestion();
                
                questionIcon = kn5.getImage();
                choices = kn5.getChoices();
                jLabel1.setIcon(questionIcon);
                answer = kn5.getAnswer();
                
                
            }
            if (difficulty == 3)
            {
                
                kn5.generateHardQuestion();
                
                questionIcon = kn5.getImage();
                choices = kn5.getChoices();
                jLabel1.setIcon(questionIcon);
                answer = kn5.getAnswer();
                
            }
        }
         else if(questions[questionCount] == 6)
        {
             
            //Sets the title
            this.setTitle(title);
        
            kn6 = new KN6(main);
            //do lots of stuff
            if (difficulty == 1)
            {
                
                jButton1.setText("Penny");
                jButton2.setText("Nickel");
                jButton3.setText("Dime");
                jButton4.setText("Quarter");
                
                correctAnswer = kn6.getEQuestion();
                answer = kn6.answerToInt(correctAnswer);
                questionIcon = kn6.getImage();
                choices = kn6.getChoices();
                AnsArray = kn6.getAnswerArray();
                jLabel1.setIcon(questionIcon);              
                jLabel1.setText("");  
                
                
            }
            
            if (difficulty == 2)
            {
                jButton1.setText("Penny");
                jButton2.setText("Nickel");
                jButton3.setText("Dime");
                jButton4.setText("Quarter");
                
                 correctAnswer = kn6.getMQuestion();
                 choices = kn6.getChoices();
                answer = kn6.answerToInt(correctAnswer);
                questionIcon = kn6.getImage();
                AnsArray = kn6.getAnswerArray();
                jLabel1.setIcon(questionIcon);   
                jLabel1.setText("");
                
            }
            if (difficulty == 3)
            {
                jButton1.setText("Nickel");
                jButton2.setText("Dime");
                jButton3.setText("Quarter");
                jButton4.setText("Half Dollar");
               correctAnswer = kn6.getHQuestion();
               
                choices = kn6.getChoices();
                answer = kn6.answerToInt(correctAnswer);
                questionIcon = kn6.getImage();
                AnsArray = kn6.getAnswerArray();
                jLabel1.setIcon(questionIcon);  
                jLabel1.setText("");
            }
        }
         else if(questions[questionCount] == 7)
        {
           //Sets the title
            this.setTitle(title);
            
            kn7 = new KN7(main);
           
            //do lots of stuff
            if (difficulty == 1)
            {
                
                kn7.generateEasyQuestion();
                
                questionIcon = kn7.getImage();
                choices = kn7.getChoices();
                jLabel1.setIcon(questionIcon);
                jButton1.setText("" +choices[0]);
                jButton2.setText("" +choices[1]);
                jButton3.setText("" +choices[2]);
                jButton4.setText("" +choices[3]);
                answer = kn7.getAnswer();
                
                
            }
            
            if (difficulty == 2)
            {
                
                kn7.generateMediumQuestion();
                
                questionIcon = kn7.getImage();
                choices = kn7.getChoices();
                jLabel1.setIcon(questionIcon);
                jButton1.setText("" +choices[0]);
                jButton2.setText("" +choices[1]);
                jButton3.setText("" +choices[2]);
                jButton4.setText("" +choices[3]);
                answer = kn7.getAnswer();
                
                
            }
            if (difficulty == 3)
            {
                
                kn7.generateHardQuestion();
                
                questionIcon = kn7.getImage();
                choices = kn7.getChoices();
                jLabel1.setIcon(questionIcon);
                jButton1.setText("" +choices[0]);
                jButton2.setText("" +choices[1]);
                jButton3.setText("" +choices[2]);
                jButton4.setText("" +choices[3]);
                answer = kn7.getAnswer();
                
            }
        }
         else if(questions[questionCount] == 8)
        {
            //Sets the title
            this.setTitle(title);
            
            kn8 = new kn8Class();
            int question8 = kn8.getQuestion(difficulty);
            
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/KN8/" + question8 + ".png")));
        
          

            //Set the text of the buttons to the answer choices, one of which is correct
            jButton1.setText(kn8.getAns1());
            jButton2.setText(kn8.getAns2());
            jButton3.setText(kn8.getAns3());
            jButton4.setText(kn8.getAns4());
            
            answer =  question8;
            choices[0] = Integer.parseInt(kn8.getAns1());
            choices[1] = Integer.parseInt(kn8.getAns2());
            choices[2] = Integer.parseInt(kn8.getAns3());
            choices[3] = Integer.parseInt(kn8.getAns4());
            
            jLabel1.setText("");
        }
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        helpAudioButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        jButton2.setBackground(new java.awt.Color(230, 126, 34));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(230, 126, 34));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 28)); // NOI18N

        jButton4.setBackground(new java.awt.Color(230, 126, 34));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(728, Short.MAX_VALUE)
                        .addComponent(helpAudioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpAudioButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(39, Short.MAX_VALUE))
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
                
                // Correct answer
                results[questionCount] = 1;

            } else {

                // Display the incorrect answer image
                jButton2.setIcon(incorrectImageIcon);
                
                // Incorect answer
                results[questionCount] = 0;
                
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

      
        if (currentPage<numQuestions)
        {
            // Increments the current page
            currentPage++;
            
            // Resets the ImageIcons of the JButtons on the screen to neutral
            jButton1.setIcon(neutralImageIcon);
            jButton2.setIcon(neutralImageIcon);
            jButton3.setIcon(neutralImageIcon);
            jButton4.setIcon(neutralImageIcon);

            // Generate a  question
            generateQuestion();
            
  
        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "You are done with the practice questions for Math with Drawings.\nClick ok to continue.", "Practice", JOptionPane.INFORMATION_MESSAGE);

            // Closes this screen
            this.dispose();

            // Sets the variable to flase
            main.setIsAssessmentScreenOpen(false);

            // If the number of questions == 6 (quiz) then open the quiz report screen
            if (numQuestions == 6) {
             
                savequiz();
                
                // Opens the QuizReport module
                main.openQuizReportScreen(results, 0);
            
            } else if (numQuestions == 10) {
                
                saveFinal();
                
                // Open the final report module
                
            }

        }

        // Sets the question questionCount on the screen
        jLabel2.setText(currentPage+"/"+numQuestions);

        // Sets the title of the form
        this.setTitle(title);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void savequiz(){
        
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
                  
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
                       
            int correct = 0;
            
            for(int i=0; i < results.length; i++){
                correct += results[i];
            }
            
            // Inserts the data into the database
            sql = "INSERT INTO quizzes VALUES('" + user + "',1,"+difficulty+","+correct+","
                    +"'"+kns[0]+"',"+results[0]+",'"+kns[1]+"',"+results[1]+",'"+kns[2]+"',"+results[2]+","
                    +"'"+kns[3]+"',"+results[3]+",'"+kns[4]+"',"+results[4]+",'"+kns[5]+"',"+results[5]+","
                    +"'"+timeStamp+ "')";
            
            //JOptionPane.showMessageDialog(null, sql, "Next", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
            
            stmt.executeUpdate(sql);

            
            // close all connection to DB
            stmt.close();
            conn.close();
        }
        catch (Exception e){ e.printStackTrace();}
        
        
    }
    
    public void saveFinal() {
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
                  
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
                       
            int correct = 0;
            
            for(int i=0; i < results.length; i++){
                correct += results[i];
            }
            
            // Inserts the data into the database
            sql = "INSERT INTO finals VALUES('" + user + "',1,"+correct+","
                    +results[0]+","+results[1]+","+results[2]+","
                    +results[3]+","+results[4]+","+results[5]+","
                    +results[6]+","+results[7]+","+results[8]+","
                    +results[9]+","
                    +"'"+timeStamp+ "')";
            
            //JOptionPane.showMessageDialog(null, sql, "Next", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
            
            stmt.executeUpdate(sql);

            
            // close all connection to DB
            stmt.close();
            conn.close();
        }
        catch (Exception e){ e.printStackTrace();}
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // If the user has not submitted an answer
        if (!answerSubmitted) {
        System.out.println("XXX choices q is" + choices[2]);
            // If the value assigned to this button is the correct answer
            if (choices[2] == answer) {

                // Display the correct answer image
                jButton3.setIcon(correctImageIcon);
                
                // Correct answer
                results[questionCount] = 1;

            } else {

                // Display the incorrect answer image
                jButton3.setIcon(incorrectImageIcon);
                
                // Incorect answer
                results[questionCount] = 0;
                
            }

            // Prevents the user from submitting another answer
            answerSubmitted = true;

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "Click the blue arrow to continue", "Next", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // If the user has not picked an answer to the question
        if (!answerSubmitted) {
        System.out.println("XXX choices q is" + choices[0]);
            // If the value assigned to this button is the correct answer
            if (choices[0] == answer) {

                // Display the correct answer image
                jButton1.setIcon(correctImageIcon);
                
                // Correct answer
                results[questionCount] = 1;

            } else {

                // Display the incorrect answer image
                jButton1.setIcon(incorrectImageIcon);
                
                // Incorect answer
                results[questionCount] = 0;
                
            }

            // Prevents the user from submitting another answer
            answerSubmitted = true;

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "Click the blue arrow to continue", "Next", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // If the user has not submitted an answer
        if (!answerSubmitted) {
            System.out.println("XXX choices q is" + choices[3]);
            // If the value assigned to this button is the correct answer
            if (choices[3] == answer) {
                
                // Display the correct answer image
                jButton4.setIcon(correctImageIcon);
                
                // Correct answer
                results[questionCount] = 1;

            } else {

                // Display the incorrect answer image
                jButton4.setIcon(incorrectImageIcon);
                
                // Incorect answer
                results[questionCount] = 0;
                
            }

            // Prevents the user from submitting another answer
            answerSubmitted = true;

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "Click the blue arrow to continue", "Next", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButton4ActionPerformed

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

    // Called when the form is closed
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
 
        // Sets the variable to false
        main.setIsAssessmentScreenOpen(false);
        
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton helpAudioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
