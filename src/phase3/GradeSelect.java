/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

import static java.awt.SystemColor.info;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author markmorabito
 */
public class GradeSelect extends javax.swing.JInternalFrame {

    /**
     * Creates new form GradeSelect
     */
    public GradeSelect() {
        initComponents();
        //myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goGradePreKKButton = new javax.swing.JButton();
        goGradesOneAndTwoButton = new javax.swing.JButton();
        goGradeThreeAndFourButton = new javax.swing.JButton();
        helpAudioButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("GradeSelect");
        setToolTipText("GradeSelect");
        setVisible(true);

        goGradePreKKButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Image/GradeSelect/PreK-KButton.jpg"))); // NOI18N
        goGradePreKKButton.setText("preK-K");
        goGradePreKKButton.setToolTipText("");
        goGradePreKKButton.setPreferredSize(new java.awt.Dimension(100, 30));
        goGradePreKKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goGradePreKKButtonActionPerformed(evt);
            }
        });

        goGradesOneAndTwoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Image/GradeSelect/1-2Button.jpg"))); // NOI18N
        goGradesOneAndTwoButton.setText("1-2");
        goGradesOneAndTwoButton.setPreferredSize(new java.awt.Dimension(100, 30));
        goGradesOneAndTwoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goGradesOneAndTwoButtonActionPerformed(evt);
            }
        });

        goGradeThreeAndFourButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Image/GradeSelect/3-4Button.jpg"))); // NOI18N
        goGradeThreeAndFourButton.setText("3-4");
        goGradeThreeAndFourButton.setPreferredSize(new java.awt.Dimension(100, 30));
        goGradeThreeAndFourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goGradeThreeAndFourButtonActionPerformed(evt);
            }
        });

        helpAudioButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phase3/Image/GradeSelect/AudioButton.png"))); // NOI18N
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
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(goGradePreKKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(goGradesOneAndTwoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(goGradeThreeAndFourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(helpAudioButton)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {goGradePreKKButton, goGradeThreeAndFourButton, goGradesOneAndTwoButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helpAudioButton)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goGradePreKKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goGradesOneAndTwoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goGradeThreeAndFourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {goGradePreKKButton, goGradeThreeAndFourButton, goGradesOneAndTwoButton});

        setBounds(170, 15, 974, 560);
    }// </editor-fold>//GEN-END:initComponents
   
    /**
    private void myInitComponents()
    {
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("GradeSelect");
        setToolTipText("GradeSelect");
        setVisible(true);
    }*/
    private void helpAudioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButtonActionPerformed
        // TODO add your handling code here:
        //This does NOT work
        File soundFile = new File("Sample.wav");
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(GradeSelect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GradeSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
        //AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        //SourceDataLine = (SourceDataLine)AudioSystem.getLine(info);
        auline.start();
        
    }//GEN-LAST:event_helpAudioButtonActionPerformed

    private void goGradePreKKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goGradePreKKButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goGradePreKKButtonActionPerformed

    private void goGradesOneAndTwoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goGradesOneAndTwoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goGradesOneAndTwoButtonActionPerformed

    private void goGradeThreeAndFourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goGradeThreeAndFourButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goGradeThreeAndFourButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goGradePreKKButton;
    private javax.swing.JButton goGradeThreeAndFourButton;
    private javax.swing.JButton goGradesOneAndTwoButton;
    private javax.swing.JButton helpAudioButton;
    // End of variables declaration//GEN-END:variables
}

