
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markmorabito
 */
public class AssessmentGrade2 extends javax.swing.JInternalFrame {
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
    private G2N4 q;
    
    // Stores  correct / incorrect (1 or 0) for each question
    private int[] results;
    
    // Stores the standards that appear on the assessment
    private String[] kns;
    
    /**
     * Creates new form AssessmentGrade4
     */
    /**
     * Creates new form AssessmentGrade4
     */
    public AssessmentGrade2(Main m, int numQ, int diff) {
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
  
    
    //choose randomly mod 3 // TODO
    public void determineQuestionsAndOrder()
    {
        for( int i = 0; i < numQuestions; i++)
        {
           
            kns[i] =  "2N"+4;
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
        
            q = new G2N4(main);
            //do lots of stuff
            
            if (difficulty == 1)
            {
                
                q.generateEasyQuestion();
                
              
                choices = q.getChoices();
                System.out.println("Qstring is" + q.getLabelText());
                jLabel1.setText(q.getLabelText());
                
                jButton1.setText("<");
                jButton2.setText("=");
                jButton3.setText(">");
                jButton4.setVisible(false);
               
                 System.out.println("THe answer is " + q.getAnswer());
                answer = q.getAnswer();
                
                
            }
            
            if (difficulty == 2)
            {
                
                q.generateMediumQuestion();
                
                //jLabel1.setText(q.getQuestionString());
                //JUST COMMENTED OUT
                 System.out.println("Qstring is" + q.getLabelText());
                jLabel1.setText(q.getLabelText());
                choices = q.getChoices();
                jLabel1.setIcon(questionIcon);
                jButton1.setText("<");
                jButton2.setText("=");
                jButton3.setText(">");
                jButton4.setVisible(false);
                System.out.println("THe answer is " + q.getAnswer());
                answer = q.getAnswer();
                
                
            }
            if (difficulty == 3)
            {
                
                q.generateHardQuestion();
                
               // jLabel1.setText(q.getQuestionString());
                //JUST COMMENTED OUT
                 System.out.println("Qstring is" + q.getLabelText());
                jLabel1.setText(q.getLabelText());
                choices = q.getChoices();
                jLabel1.setIcon(questionIcon);
                jButton1.setText("<");
                jButton2.setText("=");
                jButton3.setText(">");
                jButton4.setVisible(false);
                 System.out.println("THe answer is " + q.getAnswer());
                answer = q.getAnswer();
                
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

        helpAudioButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        helpAudioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AudioButton.png"))); // NOI18N
        helpAudioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAudioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 28)); // NOI18N

        jButton2.setBackground(new java.awt.Color(230, 126, 34));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setText("1/3");

        jButton3.setBackground(new java.awt.Color(230, 126, 34));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
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
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(helpAudioButton1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
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
                    .addContainerGap(54, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(helpAudioButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(305, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(192, 192, 192)
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
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // If the user has not submitted a question
        if (!answerSubmitted) {
            // System.out.println("XXX choices 1 is" + choices[1]);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // If the user has not picked an answer to the question
        if (!answerSubmitted) {
            //System.out.println("XXX choices q is" + choices[0]);
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // If the user has not submitted an answer
        if (!answerSubmitted) {
            //System.out.println("XXX choices q is" + choices[2]);
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        // Allows the user to submit an answer
        answerSubmitted = false;

        System.out.println("Current page: " + currentPage + "  Question Num is:" + numQuestions);
        
        

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

            
        //Sets the title appropriately
        this.setTitle(title);

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "You are done with the practice questions for Math with Drawings.\nClick ok to continue.", "Practice", JOptionPane.INFORMATION_MESSAGE);

            // Closes this screen
            this.dispose();

            // Sets the variable to flase
            main.setIsAssessmentGrade2ScreenOpen(false);

            // If the number of questions == 6 (quiz) then open the quiz report screen
            if (numQuestions == 6) {

                // Saves the quiz
                savequiz();
                
                // Opens the QuizReport module
                main.openQuizReportScreen(results, 1, difficulty, kns);

                // Displays the stars at the top of the screen
                main.checkStars();
                
            } else if (numQuestions == 10) {
                
                // Saves the final
                saveFinal();
                
                // Open the final report module
                main.openFinalReportScreen(results, kns, 1);
                
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
            // System.out.println("XXX choices q is" + choices[3]);
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
            sql = "INSERT INTO quizzes VALUES(null,'" + user + "',2,"+difficulty+","+correct+","
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
            sql = "INSERT INTO finals VALUES(null,'" + user + "',2,"+correct+","
                    +"'"+kns[0]+"',"+results[0]+","+"'"+kns[1]+"',"
                    +results[1]+","+"'"+kns[2]+"',"+results[2]+","
                    +"'"+kns[3]+"',"+results[3]+","+"'"+kns[4]+"',"
                    +results[4]+","+"'"+kns[5]+"',"+results[5]+","
                    +"'"+kns[6]+"',"+results[6]+","+"'"+kns[7]+"',"
                    +results[7]+","+"'"+kns[8]+"',"+results[8]+","
                    +"'"+kns[9]+"',"+results[9]+","
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
