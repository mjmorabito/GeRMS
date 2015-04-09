/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/02/15
 * Purpose: The client requested a math tutoring software for elementary school children.
 * For this phase of the project the client assigned us to script a prototype portion of the user interface.
 * (Not everything). We were told to select the most important part of your project and simply develop one modular to
 */
import static java.awt.SystemColor.info;
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
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/*
* This is the GradeSelect class which extends JInternalFrame.
* This is a screen that appears when the user logs in.
* This screen is also accessible by clicking the blue home button at the top of the screen.
* This screen has three buttons: 1) PreK-K Module, 2) 1-2 Module, 3) 3-4 Module.
* There is also an audio button that helps the user with the screen.
*/
public class GradeSelect extends JInternalFrame {
    
    Main main;
    
    /**
     * Creates new form GradeSelect
     */
    public GradeSelect(Main m) {
        
        // Initializes the components
        initComponents();
        
        // Stores the reference to the main class
        main = m;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        helpAudioButton = new javax.swing.JButton();
        gradePreKandKButton = new javax.swing.JButton();
        grade1and2Button = new javax.swing.JButton();
        grade3and4Button = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Main Menu");
        setToolTipText("Main Menu");
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

        helpAudioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AudioButton.png"))); // NOI18N
        helpAudioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpAudioButtonActionPerformed(evt);
            }
        });

        gradePreKandKButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GradeSelectScreen/PreK-KButton.jpg"))); // NOI18N
        gradePreKandKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradePreKandKButtonActionPerformed(evt);
            }
        });

        grade1and2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GradeSelectScreen/1-2Button.jpg"))); // NOI18N
        grade1and2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grade1and2ButtonActionPerformed(evt);
            }
        });

        grade3and4Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GradeSelectScreen/3-4Button.jpg"))); // NOI18N
        grade3and4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grade3and4ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(helpAudioButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gradePreKandKButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grade1and2Button)
                        .addGap(14, 14, 14)
                        .addComponent(grade3and4Button)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(helpAudioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradePreKandKButton)
                    .addComponent(grade1and2Button)
                    .addComponent(grade3and4Button))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        setBounds(170, 15, 974, 560);
    }// </editor-fold>//GEN-END:initComponents
   
    // This method is triggerd when the help audio button is clicked
    private void helpAudioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButtonActionPerformed

        // Code to play the audio GeRMSHelp.wav
        File yourFile = new File("src/Sounds/GeRMSHelp.wav");
        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;

        // A try/catch block to play the audio file
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

    // This method is triggered when the form is closed
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        // Sets the isGradeSelectScreenOpen variable to false
        main.setIsGradeSelectScreenOpen(false);
        
    }//GEN-LAST:event_formInternalFrameClosed

    // This method is triggered when the PreK-K grades button is clicked
    private void gradePreKandKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradePreKandKButtonActionPerformed
    
        // Display a message
        //JOptionPane.showMessageDialog(null, "This button will open the grades PreK-K module.");
          // TODO add your handling code here:
        //For testing purposes, this method will launch the PreKKCountingQuiz   
        // Closes the grade select screen
        this.dispose();
        main.setIsGradeSelectScreenOpen(false);

        // Sets PreKK to true
        main.setIsPreKKOpen(true);
        main.openPreKK();
        
        
    }//GEN-LAST:event_gradePreKandKButtonActionPerformed

    // This method is triggered when the 1-2 grades button is clicked
    private void grade1and2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grade1and2ButtonActionPerformed

        // Display a message
        JOptionPane.showMessageDialog(null, "This button will open the grades 1-2 module.");
        
    }//GEN-LAST:event_grade1and2ButtonActionPerformed

    // This method is triggered when the 3-4 grades button is clicked
    private void grade3and4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grade3and4ButtonActionPerformed

        // Display a message
        JOptionPane.showMessageDialog(null, "This button will open the grades 3-4 module.");
        
    }//GEN-LAST:event_grade3and4ButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton grade1and2Button;
    private javax.swing.JButton grade3and4Button;
    private javax.swing.JButton gradePreKandKButton;
    private javax.swing.JButton helpAudioButton;
    // End of variables declaration//GEN-END:variables
}
