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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
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

/**
 *
 * The Assessment class allows for a quiz, or a test, on easy, medium, or hard
 * difficulty to be administered for grades 3 - 4
 */
public class AssessmentGrade4 extends javax.swing.JInternalFrame {
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
    
    // Makes an object of each GN4 standard
    private G4N12 q;
    
    // Stores  correct / incorrect (1 or 0) for each question
    private int[] results;
    
    // Stores the standards asked on the assessments in order
    private String[] kns;
    
    /**
     * Creates new form AssessmentGrade4
     */
    /**
     * Creates new form AssessmentGrade4
     */
    public AssessmentGrade4(Main m, int numQ,int diff) {
         // Sets the reference to the main class
        main = m;
        
        difficulty = diff;
        
        numQuestions = numQ;
        
        results = new int[numQuestions];
         
        questions = new int[numQuestions];
        
        kns = new String[numQuestions];
        
        // Initializes the components
        initComponents();
        
        //Sets the progress label
        jLabel2.setText(currentPage+"/"+numQuestions);
        
        determineQuestionsAndOrder();
       
        generateQuestion();
        
       
        
        // Centers the JInternalFrame on the screen
        centerOnScreen();
        
        // ImageIcons for the neutral, correct, and incorrect buttons
        neutralImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerNeutral.png"));
        correctImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerCorrect.png"));
        incorrectImageIcon = new ImageIcon(getClass().getResource("Images/PracticeScreens/AnswerIncorrect.png"));
        
        
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
  
    
   //Determines the questions and the order
    public void determineQuestionsAndOrder()
    {
        for( int i = 0; i < numQuestions; i++)
        {
           
            kns[i] = "4N"+12;
        }
       
    }
    
    public void generateQuestion()
    {
        //String for title of this asssessment based on level and number 
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
        
        //Sets the title based on question number and difficulty level
        this.setTitle(title);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        
        
        if (questionCount < numQuestions-1) {
            questionCount++;
        }
        
            q = new G4N12(main);
     
            if (difficulty == 1)
            {
                
                q.generateEasyQuestion();
                
                //questionIcon = q.getImage();
                choices = q.getChoices();
                jLabel1.setText(q.getQuestionString());
                
                jButton1.setText("" +choices[0]);
                jButton2.setText("" +choices[1]);
                jButton3.setText("" +choices[2]);
                jButton4.setText("" +choices[3]);
                answer = q.getAnswer();
                
                
            }
            
            if (difficulty == 2)
            {
                
                q.generateMediumQuestion();
                
                jLabel1.setText(q.getQuestionString());
                choices = q.getChoices();
                jLabel1.setIcon(questionIcon);
                jButton1.setText("" +choices[0]);
                jButton2.setText("" +choices[1]);
                jButton3.setText("" +choices[2]);
                jButton4.setText("" +choices[3]);
                answer = q.getAnswer();
                
                
            }
            if (difficulty == 3)
            {
                
                q.generateHardQuestion();
                
                jLabel1.setText(q.getQuestionString());
                choices = q.getChoices();
                jLabel1.setIcon(questionIcon);
                jButton1.setText("" +choices[0]);
                jButton2.setText("" +choices[1]);
                jButton3.setText("" +choices[2]);
                jButton4.setText("" +choices[3]);
                answer = q.getAnswer();
                
            }
            
        this.setTitle(title);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        helpAudioButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Assessment for Grades 3 and 4");
        setVisible(true);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setText("1/3");

        jButton1.setBackground(new java.awt.Color(230, 126, 34));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 126, 34));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/RightArrow.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        jButton3.setBackground(new java.awt.Color(230, 126, 34));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 28)); // NOI18N

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
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(69, 69, 69)
                                .addComponent(jButton3))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(helpAudioButton1)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(helpAudioButton1)))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // If the user has not picked an answer to the question
        if (!answerSubmitted) {
            
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

        // String for the title of this form
        String title = "";

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

            // Title of the form
            if(numQuestions==6)
            {
                title = "Quiz";
            }else
            {
                title = "Final";

            }

        } else {

            if (numQuestions == 6) {

                // Display a message
                JOptionPane.showMessageDialog(null, "You are done with the quiz.\nClick ok to continue.", "Quiz", JOptionPane.INFORMATION_MESSAGE);

            } else if (numQuestions == 10) {
                
                // Display a message
                JOptionPane.showMessageDialog(null, "You are done with the final.\nClick ok to continue.", "Final", JOptionPane.INFORMATION_MESSAGE);

            }
            // Closes this screen
            this.dispose();

            // Sets the variable to flase
            main.setIsAssessmentGrade4ScreenOpen(false);

            // If the number of questions == 6 (quiz) then open the quiz report screen
            if (numQuestions == 6) {

                // Save the quiz
                savequiz();
                
                // Opens the QuizReport module
                main.openQuizReportScreen(results, 2, difficulty, kns);

                // Displays the stars at the top of the screen
                main.checkStars();
                
            } else if (numQuestions == 10) {
                
                // Save the final
                saveFinal();
                
                // Open the final report module
                main.openFinalReportScreen(results, kns, 2);
                
            }

        }

        // Sets the question questionCount on the screen
        jLabel2.setText(currentPage+"/"+numQuestions);

        // Sets the title of the form
        this.setTitle(title);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // If the user has not submitted an answer
        if (!answerSubmitted) {
           
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // If the user has not submitted an answer
        if (!answerSubmitted) {
           
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

    private void helpAudioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButton1ActionPerformed
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
    }//GEN-LAST:event_helpAudioButton1ActionPerformed

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
            sql = "INSERT INTO quizzes VALUES(null,'" + user + "',3,"+difficulty+","+correct+","
                    +"'"+kns[0]+"',"+results[0]+",'"+kns[1]+"',"+results[1]+",'"+kns[2]+"',"+results[2]+","
                    +"'"+kns[3]+"',"+results[3]+",'"+kns[4]+"',"+results[4]+",'"+kns[5]+"',"+results[5]+","
                    +"'"+timeStamp+ "')";

            //Updates the database
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
            sql = "INSERT INTO finals VALUES(null,'" + user + "',3,"+correct+","
                    +"'"+kns[0]+"',"+results[0]+","+"'"+kns[1]+"',"
                    +results[1]+","+"'"+kns[2]+"',"+results[2]+","
                    +"'"+kns[3]+"',"+results[3]+","+"'"+kns[4]+"',"
                    +results[4]+","+"'"+kns[5]+"',"+results[5]+","
                    +"'"+kns[6]+"',"+results[6]+","+"'"+kns[7]+"',"
                    +results[7]+","+"'"+kns[8]+"',"+results[8]+","
                    +"'"+kns[9]+"',"+results[9]+","
                    +"'"+timeStamp+ "')";
            
            //Updates the database
            stmt.executeUpdate(sql);

            
            // close all connection to DB
            stmt.close();
            conn.close();
        }
        catch (Exception e){ e.printStackTrace();}
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
