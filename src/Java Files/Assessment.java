

import java.awt.Dimension;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Samir
 */
public class Assessment extends javax.swing.JInternalFrame {
 // Stores a reference to the main class
    private Main main;
    
    // ImageIcon for the question
    private ImageIcon questionIcon = new ImageIcon();
    
   
    //Determines the question difficulty from 1 - 3
    private int difficulty;
    
    // Stores the correct answer to the question
    private int answer;
    
    // Stores the user's choices for answers
    private int[] choices = new int[4];
    
    // Stores the user's choices for answers
    private int[] questions ;
    
    // Stores the count of number of questions asked
    private int questionCount = 0;
    
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
    
    private KN2 kn2;
    
    private KN3 kn3;
    
    private KN4 kn4;
    
    private KN5 kn5;
    
    private KN6 kn6;
    
    private KN7 kn7;
    
    private KN8 kn8;
    /**
     * Creates new form Assessment
     */
  
    //COMMENTS
    
    public Assessment(Main m, int numQ,int diff) {
        
         // Sets the reference to the main class
        main = m;
        
        difficulty = diff;
        
        numQuestions = numQ;
         
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
        
        // Generates an easy question on the screen
        //generateEasyQuestion();
        
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
            questions[i] =   7; //r.nextInt(8) + 1;
        }
        
        //GET RID OF
        for( int i = 0; i < numQuestions; i++)
        {
            System.out.println(questions[i]); 
        }
    }
    
    public void generateQuestion()
    {
        
        System.out.println("Question count: " + questionCount);
        
        if (questionCount < numQuestions-1) {
            questionCount++;
        }
        System.out.println("After Question count: " +  questionCount);
        
        if(questions[questionCount] == 1)
        {
            q = new QuizSample();
            //do lots of stuff
            if (difficulty == 1)
            {
                
                
                
            }
            
            if (difficulty == 2)
            {
                
                
                
            }
            if (difficulty == 3)
            {
                
                
                
            }
        }
        else if(questions[questionCount] == 2)
        {
            q = new QuizSample();
            //do lots of stuff
            if (difficulty == 1)
            {
                
                
                
            }
            
            if (difficulty == 2)
            {
                
                
                
            }
            if (difficulty == 3)
            {
                
                
                
            }
        }
         else if(questions[questionCount] == 3)
        {
            q = new QuizSample();
            //do lots of stuff
            if (difficulty == 1)
            {
                
                
                
            }
            
            if (difficulty == 2)
            {
                
                
                
            }
            if (difficulty == 3)
            {
                
                
                
            }
        }
         else if(questions[questionCount] == 4)
        {
            q = new QuizSample();
            //do lots of stuff
            if (difficulty == 1)
            {
                
                
                
            }
            
            if (difficulty == 2)
            {
                
                
                
            }
            if (difficulty == 3)
            {
                
                
                
            }
        }
         else if(questions[questionCount] == 5)
        {
            q = new QuizSample();
            //do lots of stuff
            if (difficulty == 1)
            {
                
                
                
            }
            
            if (difficulty == 2)
            {
                
                
                
            }
            if (difficulty == 3)
            {
                
                
                
            }
        }
         else if(questions[questionCount] == 6)
        {
            q = new QuizSample();
            //do lots of stuff
            if (difficulty == 1)
            {
                
                
                
            }
            
            if (difficulty == 2)
            {
                
                
                
            }
            if (difficulty == 3)
            {
                
                
                
            }
        }
         else if(questions[questionCount] == 7)
        {
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
            q = new QuizSample();
            //do lots of stuff
            if (difficulty == 1)
            {
                
                
                
            }
            
            if (difficulty == 2)
            {
                
                
                
            }
            if (difficulty == 3)
            {
                
                
                
            }
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        jButton1.setBackground(new java.awt.Color(230, 126, 34));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton5)
                            .addGap(71, 71, 71))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(41, 41, 41)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55))))
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

        

        System.out.println("Current page: " + currentPage + "  Question Num is:" + numQuestions);
        // String for the title of this form
        String title = "";

        if (currentPage<numQuestions)
        {
            // Increments the current page
            currentPage++;
            System.out.println("Current page: " + currentPage);
            
            // Resets the ImageIcons of the JButtons on the screen to neutral
            jButton1.setIcon(neutralImageIcon);
            jButton2.setIcon(neutralImageIcon);
            jButton3.setIcon(neutralImageIcon);
            jButton4.setIcon(neutralImageIcon);

            // Generate a  question
            generateQuestion();
              
            // Title of the form
            if(numQuestions==6)
            {
                title = "Quiz";
            }else
            {
                title = "Final";
                
            }

       

           

           

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "You are done with the practice questions for Math with Drawings.\nClick ok to continue.", "Practice", JOptionPane.INFORMATION_MESSAGE);

            // Closes this screen
            this.dispose();

            main.setIsAssessmentScreenOpen(false);

            // Opens the PreKK module   TODO:  Open the Report instead of Module
            main.openPreKK();

        }

        // Sets the question questionCount on the screen
        jLabel2.setText(currentPage+"/"+numQuestions);

        // Sets the title of the form
        this.setTitle(title);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
