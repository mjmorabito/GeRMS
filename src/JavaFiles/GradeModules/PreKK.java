/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/02/15
 * Purpose: The client requested a math tutoring software for elementary school children.
 */
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 * This is the PreKK class which stores all of the PreK-K information including videos, practice, and assessment
 * 
 */

public class PreKK extends JInternalFrame {
    
    // The main class
    private Main main;
    
    // Page count
    private int page = 1;
    
    // ImageIcons for the images of the standards
    private ImageIcon standardIcon1 = new ImageIcon();
    private ImageIcon standardIcon2 = new ImageIcon();
    
    // variables needed to make connection with DB
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://localhost/germs"; 
 
    /**
     * Creates new form PreKK
     */
    public PreKK(Main m) {
        // Initializes the components
        initComponents();
        
        // Stores the reference to the main class
        main = m;
        
        // Gets the dimension of the main desktop pane
        Dimension desktopSize = main.getDesktopPaneDimension();
                
        // Gets the size of this JInternalFrame
        Dimension jInternalFrameSize = this.getSize();
        
        // Centers this JInternalFrame in the DesktopPane
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        standardLabelImage1 = new javax.swing.JLabel();
        watchButton1 = new javax.swing.JButton();
        standardLabelImage2 = new javax.swing.JLabel();
        pageLabel = new javax.swing.JLabel();
        watchButton2 = new javax.swing.JButton();
        leftarrowButton = new javax.swing.JButton();
        quizButton = new javax.swing.JButton();
        helpAudioButton1 = new javax.swing.JButton();
        finalButton = new javax.swing.JButton();
        rightarrowButton = new javax.swing.JButton();
        practiceButton2 = new javax.swing.JButton();
        practiceButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PreK-K");
        setToolTipText("PreK-K");
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

        standardLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Counting.jpg"))); // NOI18N

        watchButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Watch.png"))); // NOI18N
        watchButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        watchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchButton1ActionPerformed(evt);
            }
        });

        standardLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Matching.png"))); // NOI18N

        pageLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        pageLabel.setText("1/4");

        watchButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Watch.png"))); // NOI18N
        watchButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));
        watchButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchButton2ActionPerformed(evt);
            }
        });

        leftarrowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/LeftArrow.png"))); // NOI18N
        leftarrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftarrowButtonActionPerformed(evt);
            }
        });

        quizButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        quizButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Quiz.png"))); // NOI18N
        quizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizButtonActionPerformed(evt);
            }
        });

        helpAudioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AudioButton.png"))); // NOI18N
        helpAudioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAudioButton1ActionPerformed(evt);
            }
        });

        finalButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        finalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Final.png"))); // NOI18N
        finalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalButtonActionPerformed(evt);
            }
        });

        rightarrowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/RightArrow.png"))); // NOI18N
        rightarrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightarrowButtonActionPerformed(evt);
            }
        });

        practiceButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Practice.png"))); // NOI18N
        practiceButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                practiceButton2ActionPerformed(evt);
            }
        });

        practiceButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Practice.png"))); // NOI18N
        practiceButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                practiceButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(pageLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(leftarrowButton)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rightarrowButton)
                            .addComponent(finalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(standardLabelImage1)
                            .addComponent(standardLabelImage2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(watchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(watchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(practiceButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(practiceButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpAudioButton1)
                        .addGap(50, 50, 50))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(practiceButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(standardLabelImage1)
                            .addComponent(helpAudioButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(watchButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(standardLabelImage2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(watchButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(practiceButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightarrowButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(leftarrowButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pageLabel)
                        .addGap(33, 33, 33))
                    .addComponent(quizButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(finalButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // This method is triggered when the OK button is clicked
    private void quizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizButtonActionPerformed
        
        String message = "Please complete practices ";
        boolean missingStandard = false;
        String user = main.getUsername();
        dbClass db = new dbClass();
        int[] standards = new int[7];
        String[] standardstext = new String[] {"Counting, ","Matching, ","Position, ","Comparing, ","Half and Whole, ","Coins, ","Math with Drawings, ","Estimate, "};
        
        standards = db.allpracticescompletedPREKK(user);
        
        for(int i = 0;i<standards.length; i++){
            if (standards[i] == 0){
                message = message.concat(standardstext[i]);
                missingStandard = true;
            }
        }
        message = message.concat("before taking a quiz!");
        
        if (missingStandard){
            JOptionPane.showMessageDialog(null, message, "Complete Standard", JOptionPane.INFORMATION_MESSAGE);
        }else{
            //For testing purposes, this method will launch the PreKKCountingQuiz   
            // Closes the PreKK screen
            this.dispose();
            main.setIsPreKKOpen(false);

            // Opens Difficulty Select
            main.openQuizDifficultySelect();
        }
    }//GEN-LAST:event_quizButtonActionPerformed

    private void practiceButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_practiceButton2ActionPerformed
        // TODO add your handling code here:
        
        // If the current page is 1
        if (page == 1) {
            
            // Sets the variable to false
            main.setIsPreKKOpen(false);
            
            // Opens KN2
            main.openKN2Screen();

            // Sets kN4 open to true
            main.setIsKN2ScreenOpen(true);
            
            // Closes the PreK-K Module
            this.dispose();
 
            
        }
        // If the current page is 2
        if (page == 2) {
            
            // Sets the variable to false
            main.setIsPreKKOpen(false);
            
            // Opens KN4
            main.openKN4Screen();
            
            // Sets kN4 open to true
            main.setIsKN4ScreenOpen(true);
            
            // Closes the PreK-K Module
            this.dispose();

        }
        // if the current page is 3
        if (page == 3) {
            
            // Sets the variable to false
            main.setIsPreKKOpen(false);
            
            // Opens KN6
            main.openKN6Screen();
            
            // Sets kN6 open to true
            main.setIsKN6ScreenOpen(true);
            
            // Closes the PreK-K Module
            this.dispose();
        // If the current page is 4
        }
        if (page == 4) {
            
            // Sets the variable to false
            main.setIsPreKKOpen(false);
            
            // Opens KN4
            main.openKN8Screen();

            // Sets kN4 open to true
            main.setIsKN8ScreenOpen(true);
            
            // Closes the PreK-K Module
            this.dispose();
            
        }
        
    }//GEN-LAST:event_practiceButton2ActionPerformed

    // This method is called when the Final button is clicked
    private void finalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalButtonActionPerformed
      
        
        String user = main.getUsername();
        dbClass db = new dbClass();
        boolean completed = db.completedhardquiz(user, 1);
        
        if(!completed){
            // Display a message
            JOptionPane.showMessageDialog(null, "Please complete a hard quiz before taking a final test!", "Complete hard!", JOptionPane.INFORMATION_MESSAGE);
            
        }else{
            // Opens the Assessment
            main.openAssessmentScreen(10, 3);
        
            // Closes this scren
            main.closePreKKScreen();    
        }
            
        
        
    }//GEN-LAST:event_finalButtonActionPerformed

    private void rightarrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightarrowButtonActionPerformed
        // TODO add your handling code here:
        
        // If the current page is less than 4
        if (page < 4) {
            
            // Increments the current page number
            page++;
            
            // Changes the images on the page
            changePage();
            
        // Else if the current page is 4    
        } else {
            
            // Display a message
            JOptionPane.showMessageDialog(null, "You're on the last page.", "Last Page", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
        // Sets the pageLabel text
        pageLabel.setText(page+"/4");
        
    }//GEN-LAST:event_rightarrowButtonActionPerformed

    private void leftarrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftarrowButtonActionPerformed
        // TODO add your handling code here:
        
        // If the current page is less than 4
        if (page > 1) {
            
            // Increments the current page number
            page--;
            
            // Changes the images displayed on the page
            changePage();
            
        // Else if the current page is 1    
        } else {
            
            // Display a message
            JOptionPane.showMessageDialog(null, "You're on the first page.", "First Page", JOptionPane.INFORMATION_MESSAGE);
        
        }
        
        // Sets the pageLabel text
        pageLabel.setText(page+"/4");
        
    }//GEN-LAST:event_leftarrowButtonActionPerformed

    private void practiceButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_practiceButton1ActionPerformed
        // TODO add your handling code here:

        // Closes the PreK-K module
        this.dispose();

        // Sets the variable to closed
        main.setIsPreKKOpen(false);
        
        // If the current page is 1
        if (page == 1) {
            
            // Opens the KN1 module
            main.openKN1Screen();
            
        } else if (page == 2) {
          
            // Opens the KN5 module
            main.openKN3Screen();
            
        } else if (page == 3) {
          
            // Opens the KN5 module
            main.openKN5Screen();
            
        
        } else if (page == 4) {
            
            // Opens the KN7 module
            main.openKN7Screen();
            
        }
       
        
    }//GEN-LAST:event_practiceButton1ActionPerformed

    private void watchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchButton1ActionPerformed
       
       String videoName = "";
       
        // If the current page is 1
        if (page == 1) {
            //Play the KN1 video tutorial
            videoName = "KN1";
            
        } else if (page == 2) {
          
            //Play the KN3 video tutorial
           videoName = "KN3";
            
        } else if (page == 3) {
          
            //Play the KN5 video tutorial
            videoName = "KN5";
            
        
        } else if (page == 4) {
            videoName = "KN7";
            //Play the KN7 video tutorial
           
        }
        
            try {
                
                //Creates a file, initialized to null
                File f = null;
            try {
                //Gets the class and resource path of the mp4 video
                f = new File(getClass().getResource("/Videos/" + videoName + " Final.mp4").toURI());
            } catch (URISyntaxException ex) {
                Logger.getLogger(PreKK.class.getName()).log(Level.SEVERE, null, ex);
            }
               //Opens and plays the video with the corresponding video application
                Desktop.getDesktop().open(f);
                
            } catch (IOException ex) {
                Logger.getLogger(PreKK.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
    }//GEN-LAST:event_watchButton1ActionPerformed

    private void watchButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchButton2ActionPerformed
        String videoName = "";
       
        // If the current page is 1
        if (page == 1) {
            //Play the KN2 video tutorial
            videoName = "KN2";
            
        } else if (page == 2) {
          
            //Play the KN4 video tutorial
           videoName = "KN4";
            
        } else if (page == 3) {
          
            //Play the KN6 video tutorial
            videoName = "KN6";
            
        
        } else if (page == 4) {
            videoName = "KN8";
            //Play the KN8 video tutorial
           
        }
        
        
        
        
            try {
                
                //Creates a file, initialized to null
                File f = null;
            try {
                //Gets the class and resource path of the mp4 video
                f = new File(getClass().getResource("/Videos/" + videoName + " Final.mp4").toURI());
            } catch (URISyntaxException ex) {
                Logger.getLogger(PreKK.class.getName()).log(Level.SEVERE, null, ex);
            }
               //Opens and plays the video with the corresponding video application
                Desktop.getDesktop().open(f);
                
            } catch (IOException ex) {
                Logger.getLogger(PreKK.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        
        
    }//GEN-LAST:event_watchButton2ActionPerformed

    private void helpAudioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButton1ActionPerformed
/*
        * This is the code to play the audio tutorial .wav file.
        */
        
        // Creates a File object that is linked the GeRMSLogin.wav filepath
        File yourFile = new File("src/Sounds/PreKKModule.wav");

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

    // This is called when the screen is closed
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
  
        main.setIsPreKKOpen(false);
        
    }//GEN-LAST:event_formInternalFrameClosed

    private void changePage() {
        
            // If the current page is now 1
            if (page == 1) {

               // Sets the path for the ImageIcons
               standardIcon1 = new ImageIcon(getClass().getResource("/Images/PreKK/Counting.jpg"));
               standardIcon2 = new ImageIcon(getClass().getResource("/Images/PreKK/Matching.png"));
            
            // Else If the current page is now 2
            } else if (page == 2) {
            
               // Sets the path for the ImageIcons
               standardIcon1 = new ImageIcon(getClass().getResource("/Images/PreKK/IdentifyPosition.png"));
               standardIcon2 = new ImageIcon(getClass().getResource("/Images/PreKK/Comparing.png"));
                
            // Else if the current page is now 3
            } else if (page == 3) {

               // Sets the path for the ImageIcons
               standardIcon1 = new ImageIcon(getClass().getResource("/Images/PreKK/HalfandWhole.jpg"));
               standardIcon2 = new ImageIcon(getClass().getResource("/Images/PreKK/Coins.jpg"));                
                
            // Else if the current page is now 4
            } else if (page == 4) {
                
               // Sets the path for the ImageIcons
               standardIcon1 = new ImageIcon(getClass().getResource("/Images/PreKK/ObjectsMath.jpg"));
               standardIcon2 = new ImageIcon(getClass().getResource("/Images/PreKK/Estimate.jpg"));
                
            }
            
            // Changes the images displayed
            standardLabelImage1.setIcon(standardIcon1);
            standardLabelImage2.setIcon(standardIcon2);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finalButton;
    private javax.swing.JButton helpAudioButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leftarrowButton;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JButton practiceButton1;
    private javax.swing.JButton practiceButton2;
    private javax.swing.JButton quizButton;
    private javax.swing.JButton rightarrowButton;
    private javax.swing.JLabel standardLabelImage1;
    private javax.swing.JLabel standardLabelImage2;
    private javax.swing.JButton watchButton1;
    private javax.swing.JButton watchButton2;
    // End of variables declaration//GEN-END:variables
}
