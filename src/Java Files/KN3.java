
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Dimension;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan Ahearn
 */

public class KN3 extends javax.swing.JInternalFrame {
 
    
    public KN3(Main m){
        //initializing the Problem array with zeroes
      /*Sequence = new ArrayList<>();
       for( int i=0; i<13;i++){
            
            Sequence.add(""+i);
        }    
       
       */
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
        
    
    // Generates an easy question on the screen
        getEQuestion();
        
        
         // Disables the last button for Easy Question
        jButton4.setVisible(false);
        
    }
    
     //  Initial code
    private String correctAnswer;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans5;
    
    
    //Question Skill Heading
    private final String question ="What position is Iggy in?";
    
   
    Random rand = new Random();
    /*private final int medPtr = 3;
    private final int hardPtr = 7;
    private final int easyList = 3;
    private final int medList = 4;
    private final int hardList = 5;
  */
    
     //array to hold values of pictures for the problems, 0-12 (ascends on difficulty)
    private ArrayList<String> Sequence;
    
    //array to hold possible answer
    private ArrayList<String> AnsArray = new ArrayList<String>(4);
    
    
    // Stores the user's choices for integer answers(Assessment class)
    private int[] choices = new int[4];
    
    
    //Reference to main class
    private Main main;
    
    //Variable for storing correct answer
    private int answer;
    
    //Random number for question decision
    private int questionNum;
    
    //ImageIcon for question
    private ImageIcon questionIcon = new ImageIcon();
    private int questionCount = 1;
    
    //Image Icon for correct answer
    private ImageIcon correctImageIcon;
    //Image Icon for incorrect answer
    private ImageIcon incorrectImageIcon;
    //Image Icon for neutral answer
    private ImageIcon neutralImageIcon;
    //TODO   Generate array with image paths
    
    //Boolean to restrit the user to one submission per question
    private boolean answerSubmitted = false;
    
           
   

    
                                          

                                           
                                       
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
    
// This method is called when the form is closed
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {                                         
    
        // Sets the variable to false (which means that this form is closed)
        main.setIsKN3ScreenOpen(false);
        
    }                                        

    // This method is called when the blue right arrow is clicked
    
     //get Easy Question
    
    
    public String getEQuestion(){
        
        ArrayList<String> images = new ArrayList<>();
        
        images.add("/Images/PracticeScreens/KN3/kn3first.png");
        images.add("/Images/PracticeScreens/KN3/kn3second.png");
        images.add("/Images/PracticeScreens/KN3/kn3third.png");
        
        
    questionNum = rand.nextInt(3);
        
        //Answers to the questions
       //String[] correctAnswers = {"first", "second", "third"};
        
        // Sets the icon to the randomly chosen question
       
       AnsArray.removeAll(AnsArray);
        
        AnsArray.add("First");
        AnsArray.add("Second");
        AnsArray.add("Third");
        AnsArray.add("Fourth");
        
        
        
       // shuffleList(images, 0, 2);
        correctAnswer = AnsArray.get(questionNum);
        
        System.out.println("Easy correct answer is now: "+ correctAnswer);
        
        questionIcon = new ImageIcon(getClass().getResource(images.get(questionNum)));
        //removefromsequence();
        
        // Sets the icon for the question
        jLabel1.setIcon(questionIcon);
        
        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoices();
        
     
        
        return correctAnswer;
        
        
    }
    
   
    //Get Medium Question
    public String getMQuestion(){
        
        //gets 4th option for med and hard
        jButton4.setVisible(true);
        
        ArrayList<String> images = new ArrayList<>();
        
        AnsArray.removeAll(AnsArray);
        AnsArray.add("First");
        AnsArray.add("Second");
        AnsArray.add("Third");
        AnsArray.add("Fourth");
        
        
        
        images.add("/Images/PracticeScreens/KN3/kn3Mfirst.png");
        images.add("/Images/PracticeScreens/KN3/kn3Msecond.png");
        images.add("/Images/PracticeScreens/KN3/kn3Mthird.png");
        images.add("/Images/PracticeScreens/KN3/kn3Mfourth.png");

        questionNum = rand.nextInt(4);
        questionIcon = new ImageIcon(getClass().getResource(images.get(questionNum)));

//shuffleList(Sequence, 3, 6);
        
        
       
        
        correctAnswer = AnsArray.get(questionNum);
        
        System.out.println("Medium correct answer is now: "+ correctAnswer);
        
        //removefromsequence();
        
        // Sets the icon for the question
        jLabel1.setIcon(questionIcon);
        
        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoices();
        
        return correctAnswer;
    }
    
    //Get Hard Question
     public String getHQuestion(){
       
         ArrayList<String> images = new ArrayList<>();
         AnsArray.removeAll(AnsArray);
        
        
        AnsArray.add("Second");
        AnsArray.add("Third");
        AnsArray.add("Fourth");
        AnsArray.add("Fifth");
        //shuffleList(Sequence, 7, 11);
        
        
        
        
        images.add("/Images/PracticeScreens/KN3/kn3Hsecond.png");
        images.add("/Images/PracticeScreens/KN3/kn3Hthird.png");
        images.add("/Images/PracticeScreens/KN3/kn3Hfourth.png");
        images.add("/Images/PracticeScreens/KN3/kn3Hfifth.png");
        
        questionNum = rand.nextInt(4);
        correctAnswer = AnsArray.get(questionNum);
       
        System.out.println("Hard correct answer is now: "+ correctAnswer);
        
        System.out.println("correct answer right now is: "+ correctAnswer);
        questionIcon = new ImageIcon(getClass().getResource(images.get(questionNum)));
        // Sets the icon for the question
        jLabel1.setIcon(questionIcon);
        
        // Fills the choices with 1 correct answer and 3 incorrect answers
        fillChoicesH();
        
        return correctAnswer;
    }
    
    public void fillChoices() {
        
        /*
        * For Assessment, int array with four elements is used to compare the possible answers to correct one
        */
        
        choices[0] = 0;
        choices[1] = 1;
        choices[2] = 2;
        choices[3] = 3;
      
        
        // Sets the text of the four JButtons with the choices for answers
        
        jButton1.setText("First");
        jButton2.setText("Second");
        jButton3.setText("Third");
        jButton4.setText("Fourth");

    }
    
     public void fillChoicesH() {
        
         /*
        * For Assessment, int array with four elements is used to compare the possible answers to correct one
        */
        
        choices[0] = 1;
        choices[1] = 2;
        choices[2] = 3;
        choices[3] = 4;
      
        
        // Sets the text of the four JButtons with the choices for answers
        
        
        jButton1.setText("Second");
        jButton2.setText("Third");
        jButton3.setText("Fourth");
        jButton4.setText("Fifth");
    }
    
/*
    * The following five methods are used in the Assessment class
    * for tests and quizzes.
    */
    public ImageIcon getImage()
    {
       return questionIcon; 
    }
    
    public int[] getChoices()
    {
        return choices;
    }

    public ArrayList<String> getAnswerArray()
    {
        return AnsArray;
    }
    
    public int getAnswer()
    {
        return answer;
    }
    
    //converts string answers to ints
     public int answerToInt(String ans)
    {
       if ("First".equals(ans)) 
       {
           return 0;
       }
        if ( "Second".equals(ans))
        {
            return 1;
        }
               if ("Third".equals(ans))
               {
                   return 2;
               }
                if("Fourth".equals(ans))
                {
                    return 3;
                }
                    if("Fifth".equals(ans))
                    {
                        return 4;
                    }
                    else {
                        System.out.println("Invalid entry");
                        return -1;
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

        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ordering: Easy Practice Question");
        setVisible(true);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setText("1/3");

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
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PracticeScreens/AnswerNeutral.jpg"))); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/RightArrow.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 28)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(95, 95, 95)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(jButton5)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(402, 402, 402)
                            .addComponent(jButton5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(438, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(11, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // If the user has not submitted an answer
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (correctAnswer.equals(jButton3.getText())) {
                
                
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

         // If the user has not submitted an answer
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (correctAnswer.equals(jButton1.getText())) {
                
                
                System.out.println(" Action performed: " + jButton1.getText());

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       // If the user has not submitted an answer
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (correctAnswer.equals(jButton2.getText())) {

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

       
        // If the user has not submitted an answer
        if (!answerSubmitted) {

            // If the value assigned to this button is the correct answer
            if (correctAnswer.equals(jButton4.getText())) {

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
            getMQuestion();

            // Title of the form
            title = "Ordering: Medium Practice Question";

        } else if (questionCount == 3) {

            // Resets the ImageIcons of the JButtons on the screen to neutral
            jButton1.setIcon(neutralImageIcon);
            jButton2.setIcon(neutralImageIcon);
            jButton3.setIcon(neutralImageIcon);
            jButton4.setIcon(neutralImageIcon);

            // Generate a hard question
            getHQuestion();

            // Title of the form
            title = "Ordering: Hard Practice Question";

        } else {

            // Display a message
            JOptionPane.showMessageDialog(null, "You are done with the practice questions for Ordering.\nClick ok to continue.", "Practice", JOptionPane.INFORMATION_MESSAGE);

            // Closes this screen
            this.dispose();

            main.setIsKN3ScreenOpen(false);

            // Opens the PreKK module
            main.openPreKK();

        }

        // Sets the question questionCount on the screen
        jLabel2.setText(questionCount+"/3");

        // Sets the title of the form
        this.setTitle(title);
    }//GEN-LAST:event_jButton5ActionPerformed


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


