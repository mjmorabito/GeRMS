/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Samir
 */
public class PreKK extends JInternalFrame {
    
    // The main class
    private Main main;
    
    // Page count
    private int page = 1;
    
    // ImageIcons for the images of the standards
    private ImageIcon standardIcon1 = new ImageIcon();
    private ImageIcon standardIcon2 = new ImageIcon();
 
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

        quizButton = new javax.swing.JButton();
        watchButton1 = new javax.swing.JButton();
        practiceButton1 = new javax.swing.JButton();
        watchButton2 = new javax.swing.JButton();
        practiceButton2 = new javax.swing.JButton();
        standardLabelImage1 = new javax.swing.JLabel();
        standardLabelImage2 = new javax.swing.JLabel();
        rightarrowButton = new javax.swing.JButton();
        leftarrowButton = new javax.swing.JButton();
        finalButton = new javax.swing.JButton();
        pageLabel = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PreK-K");
        setToolTipText("PreK-K");
        setVisible(true);

        quizButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        quizButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Quiz.png"))); // NOI18N
        quizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizButtonActionPerformed(evt);
            }
        });

        watchButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Watch.png"))); // NOI18N
        watchButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));

        practiceButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Practice.png"))); // NOI18N
        practiceButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                practiceButton1ActionPerformed(evt);
            }
        });

        watchButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Watch.png"))); // NOI18N
        watchButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));

        practiceButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Practice.png"))); // NOI18N
        practiceButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                practiceButton2ActionPerformed(evt);
            }
        });

        standardLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Counting.jpg"))); // NOI18N

        standardLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Matching.png"))); // NOI18N

        rightarrowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/RightArrow.png"))); // NOI18N
        rightarrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightarrowButtonActionPerformed(evt);
            }
        });

        leftarrowButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/LeftArrow.png"))); // NOI18N
        leftarrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftarrowButtonActionPerformed(evt);
            }
        });

        finalButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        finalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PreKK/Final.png"))); // NOI18N
        finalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalButtonActionPerformed(evt);
            }
        });

        pageLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        pageLabel.setText("1/4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(quizButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(standardLabelImage2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(watchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(standardLabelImage1)
                                    .addGap(46, 46, 46)
                                    .addComponent(watchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pageLabel)
                        .addGap(60, 60, 60)
                        .addComponent(leftarrowButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightarrowButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(practiceButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(practiceButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finalButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(practiceButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(watchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(standardLabelImage1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(practiceButton2)
                            .addComponent(standardLabelImage2)
                            .addComponent(watchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rightarrowButton)
                            .addComponent(leftarrowButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pageLabel)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quizButton)
                    .addComponent(finalButton))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // This method is triggered when the OK button is clicked
    private void quizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizButtonActionPerformed
        // TODO add your handling code here:
        //For testing purposes, this method will launch the PreKKCountingQuiz   
        // Closes the PreKK screen
        this.dispose();
        main.setIsPreKKOpen(false);

        // Sets PreKKCounting quiz to true
        main.setIsPreKKCountingQuizOpen(true);
        main.openPreKKCountingQuiz();
         
    }//GEN-LAST:event_quizButtonActionPerformed

    private void practiceButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_practiceButton2ActionPerformed
        // TODO add your handling code here:
        
        // If the current page is 1
        if (page == 1) {
            
            // Closes the PreK-K Module
            this.dispose();
            
            // Sets the variable to false
            main.setIsPreKKOpen(false);
            
            // Opens KN2
            main.openKN2Screen();
            
            // Sets kN2 open to true
            main.setIsKN2ScreenOpen(true);
            
        }
        
    }//GEN-LAST:event_practiceButton2ActionPerformed

    private void finalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalButtonActionPerformed
        // TODO add your handling code here:
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
            
        } else if (page == 3) {
          
            // Opens the KN5 module
            main.openKN5Screen();
            
        } else if (page == 4) {
            
            // Opens the KN7 module
            main.openKN7Screen();
            
        }
        
    }//GEN-LAST:event_practiceButton1ActionPerformed

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
