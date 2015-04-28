/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/02/15
 * Purpose: The client requested a math tutoring software for elementary school children.
 * For this phase of the project the client assigned us to script a prototype portion of the user interface.
 * (Not everything). We were told to select the most important part of your project and simply develop one modular to
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * This is the class for the Print reports screen, which actually allows the user to print
 * their progress using an installed printer on their machine.
 * This screen is a JInternalFrame.
 *
 */
public class PrintReports extends javax.swing.JInternalFrame {

    // Main class
    private Main main;

    // Primary Keys (PIDs and FIDs) from quizzes and finals table
    private ArrayList<Integer> primaryKeys = new ArrayList<Integer>();

    // Grade ID (PreK-K, Grades 1 and 2, Grades 3 and 4)
    private int gradeID;

    // Difficulty (1, 2, or 3)
    private int difficultyID;

    // Standards from the assessment
    private String[] standards;

    // Results from the assessment
    private int[] results;

    // Assessment Type (final / quiz)
    private String assessmentType;

    // Date from the assessment
    private String date;

    /**
     * Creates new form PrintReports
     */
    public PrintReports(Main m) {

        // Initializes the components
        initComponents();

        // Stores a reference to the Main class
        main = m;

        center();

        displayAssessments();

    }

    // This method centers the JInternalFrame on the screen
    public void center() {

        // Gets the dimension of the main desktop pane
        Dimension desktopSize = main.getDesktopPaneDimension();

        // Gets the size of this JInternalFrame
        Dimension jInternalFrameSize = this.getSize();

        // Centers this JInternalFrame in the DesktopPane
        this.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

    }

    // This method selects the quizzes and final assessments from the DB
    // then displays them in the table
    public void displayAssessments() {

        try {
            //Connects to the database
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/germs", "GermsAdmin", "g3rm5p0w3ru53r");

            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM quizzes where QaccUser='" + main.getUsername() + "'";

            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Stores the number of rows in the JTable
            int numberOfRows = 0;

            // Gets the number of rows in the result set so the 
            // JTable on the screen can have that many rows
            if (rs.last()) {
                numberOfRows = rs.getRow();
                model.setRowCount(numberOfRows);
                rs.beforeFirst();
            }

            int row = 0;

            // Loops through all of the result sets
            // and adds the results to the JTable
            while (rs.next()) {

                // Gets the data from the current result set
                primaryKeys.add(rs.getInt("QID"));
                int grade = rs.getInt("QgradeID");
                int difficulty = rs.getInt("Qdifficulty");
                int correctAnswers = rs.getInt("QCorrectanswers");
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                Date date = rs.getDate("QDate");
                String dateString = sdf.format(date);

                // Manipulates the data accordingly
                String g = "";
                String d = "";
                double score = (correctAnswers * 100) / 6;

                if (grade == 1) {
                    g = "PreK-K";
                } else if (grade == 2) {
                    g = "Grades 1 and 2";
                } else if (grade == 3) {
                    g = "Grades 3 and 4";
                }

                if (difficulty == 1) {
                    d = "Easy";
                } else if (difficulty == 2) {
                    d = "Medium";
                } else if (difficulty == 3) {
                    d = "Hard";
                }

                // Quiz/Final column
                jTable1.setValueAt("Quiz", row, 0);

                // Grade column
                jTable1.setValueAt(g, row, 1);

                // Difficulty column
                jTable1.setValueAt(d, row, 2);

                // Score column
                jTable1.setValueAt(score, row, 3);

                // Date column
                jTable1.setValueAt(dateString, row, 4);

                // Increment the row
                row++;

            }

            sql = "SELECT * FROM finals where FaccUser='" + main.getUsername() + "'";

            rs = stmt.executeQuery(sql);

            // Gets the number of rows in the result set so the 
            // JTable on the screen can have that many rows
            if (rs.last()) {
                numberOfRows += rs.getRow();
                model.setRowCount(numberOfRows);
                rs.beforeFirst();
            }

            // Loops through all of the result sets
            // and adds the results to the JTable
            while (rs.next()) {

                // Gets the data from the current result set
                primaryKeys.add(rs.getInt("FID"));
                int grade = rs.getInt("FgradeID");
                int correctAnswers = rs.getInt("Qcorrectanswers");
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
                Date date = rs.getDate("FDate");
                String dateString = sdf.format(date);

                // Manipulates the data accordingly
                String g = "";
                String d = "Hard";
                double score = (correctAnswers * 10);

                // Grade string
                if (grade == 1) {
                    g = "PreK-K";
                } else if (grade == 2) {
                    g = "Grades 1 and 2";
                } else if (grade == 3) {
                    g = "Grades 3 and 4";
                }

                // Quiz/Final column
                jTable1.setValueAt("Final", row, 0);

                // Grade column
                jTable1.setValueAt(g, row, 1);

                // Difficulty column
                jTable1.setValueAt(d, row, 2);

                // Score column
                jTable1.setValueAt(score, row, 3);

                // Date column
                jTable1.setValueAt(dateString, row, 4);

                // Increment the row
                row++;

            }

            // Closes the connection to the database
            stmt.close();
            rs.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        helpAudioButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Print Reports");
        setToolTipText("");
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
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

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setText("Print");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Quiz/Final", "Grade", "Difficulty", "Score", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MainScreen/printer.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(393, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(283, 283, 283)
                .addComponent(helpAudioButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(helpAudioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When the internal frame closes this method sets the variable to false
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

        // Sets the variable to false
        main.setisPrintReportsScreenOpen(false);

    }//GEN-LAST:event_formInternalFrameClosing

    // Called when the printer button is pressed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Gets the currently selected row (-1 if none selected)
        int selectedRow = jTable1.getSelectedRow();

        // If a row is selected 
        if (selectedRow > -1) {

            // Selects the currently selected assessment from the database
            try {

                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/germs", "GermsAdmin", "g3rm5p0w3ru53r");

                Statement stmt = con.createStatement();

                assessmentType = jTable1.getValueAt(selectedRow, 0).toString();

                // Makes a SQL Statement depending on what type of assessment is selected in the JTable
                String sql = "";
                if (assessmentType.equals("Quiz")) {
                    sql = "SELECT * FROM quizzes where QID = '" + primaryKeys.get(selectedRow) + "' AND QaccUser='" + main.getUsername() + "'";
                } else if (assessmentType.equals("Final")) {
                    sql = "SELECT * FROM finals where FID = '" + primaryKeys.get(selectedRow) + "' AND FaccUser='" + main.getUsername() + "'";
                }

                ResultSet rs = stmt.executeQuery(sql);

                // Gets the assessment from the ResultSet
                if (rs.next()) {

                    // If the selected assessment is a quiz
                    if (assessmentType.equals("Quiz")) {

                        // Gets the grade ID from the ResultSet
                        gradeID = rs.getInt("QgradeID");

                        // Gest the difficulty from the ResultSet
                        difficultyID = rs.getInt("Qdifficulty");

                        // Standards array
                        standards = new String[6];

                        for (int i = 0; i < 6; i++) {
                            standards[i] = rs.getString("S" + (i + 1));
                        }

                        // Results array
                        results = new int[6];

                        // Gets the results from the ResultSet
                        for (int i = 0; i < 6; i++) {
                            results[i] = rs.getInt("Q" + (i + 1));
                        }

                        // Gets the date in MM-dd-yyyy format
                        Date d = rs.getDate("Qdate");
                        date = new SimpleDateFormat("MM-dd-yyyy").format(d);

                        // Else if the selected assessment is a final
                    } else if (assessmentType.equals("Final")) {

                        // Gets the gradeID from the resultset
                        gradeID = rs.getInt("FgradeID");

                        // Difficulty is automatically 3 (Hard)
                        difficultyID = 3;

                        // Standards array
                        standards = new String[10];

                        // Gets the standards from the ResultSet
                        for (int i = 0; i < 10; i++) {
                            standards[i] = rs.getString("S" + (i + 1));
                        }

                        // Results array
                        results = new int[10];

                        // Gets the results from the ResultSet
                        for (int i = 0; i < 10; i++) {
                            results[i] = rs.getInt("Q" + (i + 1));
                        }

                        // Gets the date in MM-dd-yyyy format
                        Date d = rs.getDate("Fdate");
                        date = new SimpleDateFormat("MM-dd-yyyy").format(d);

                    }

                }

            } catch (ClassNotFoundException e) {

            } catch (SQLException e) {

            }

            /*
             * Now that the data from the currently selected assessment 
             * has been stored in variables, we are ready to display
             * a print preview, and send a print job.
             */
            // Text area that is used to write the report to
            JTextArea textArea = new JTextArea();

            // Sets the font
            textArea.setFont(new Font("monospaced", Font.PLAIN, 12));

            // Used to store either PreK-K, Grades 1 and 2, or Grades 3 and 4
            String grade = "";

            // Stores the grade in the above String
            switch (gradeID) {
                case 1:
                    grade = "PreK-K";
                    break;

                case 2:
                    grade = "Grades 1 and 2";
                    break;

                case 3:
                    grade = "Grades 3 and 4";
                    break;

                default:
                    grade = "";
                    break;

            }

            // Used to store either Easy, Medium, or Hard
            String difficulty = "";

            // Stores the difficulty in the above String
            switch (difficultyID) {

                case 1:
                    difficulty = "Easy";
                    break;

                case 2:
                    difficulty = "Medium";
                    break;

                case 3:
                    difficulty = "Hard";
                    break;

                default:
                    difficulty = "";
                    break;

            }

            // Used to store either Incorrect/Correct for all questions
            String[] results = new String[this.results.length];

            // Used to store the score on the assessment
            double score = 0;

            // Gets the score and stores incorrect/correct in the above String array
            for (int i = 0; i < this.results.length; i++) {

                // Adds one or zero to the score
                score += this.results[i];

                switch (this.results[i]) {

                    case 0:
                        results[i] = "Incorrect";
                        break;

                    case 1:
                        results[i] = "Correct";
                        break;

                    default:
                        results[i] = "";
                        break;

                }
            }

            // Calculates the score
            if (assessmentType.equals("Quiz")) {

                // Stores the score as a double from 0-100
                score = (score * 100) / 6;

            } else if (assessmentType.equals("Final")) {

                // Stores the score as a double from 0-100
                score = (score * 10);

            }

            // Formats the score
            DecimalFormat df = new DecimalFormat("###");
            String scoreFormatted = df.format(score);

            // Used to store the standards asked on the assessment as a String
            String[] standards = new String[this.standards.length];

            // Stores the standards asked as a String array
            for (int i = 0; i < this.standards.length; i++) {

                switch (this.standards[i]) {

                    case "KN1":
                        standards[i] = "Counting";
                        break;

                    case "KN2":
                        standards[i] = "Matching";
                        break;

                    case "KN3":
                        standards[i] = "Position of an Object";
                        break;

                    case "KN4":
                        standards[i] = "Comparing Groups of Objects";
                        break;

                    case "KN5":
                        standards[i] = "Half and Whole";
                        break;

                    case "KN6":
                        standards[i] = "Identify Coins";
                        break;

                    case "KN7":
                        standards[i] = "Math with Drawings";
                        break;

                    case "KN8":
                        standards[i] = "Estimate";
                        break;

                    case "2N4":
                        standards[i] = "Comparing Numbers";
                        break;

                    case "4N12":
                        standards[i] = "Math with Large Numbers";
                        break;

                    default:
                        standards[i] = "";
                        break;

                }

            }

            // Text that goes above the data from the assessment
            String headings = ""
                    + "Username: " + main.getUsername() + "\n"
                    + "Date: " + date + "\n"
                    + "Grade: " + grade + "\n"
                    + "Assessment Type: " + assessmentType + "\n"
                    + "Difficulty: " + difficulty + "\n"
                    + "Score: " + scoreFormatted + "\n\n";

            // Determine which row has the longest standard name (for spacing purposes)
            int standardLength = 0;
            for (int i = 0; i < standards.length; i++) {
                if (standards[i].length() > standardLength) {
                    // Stores the largest length
                    standardLength = standards[i].length();
                }
            }

            // Used to store the spaces as a String that go after the second column text
            String[] spacesForSecondColumn = new String[standards.length];

            // Instantiates the spacesForSecondColumn array
            for (int i = 0; i < spacesForSecondColumn.length; i++) {
                spacesForSecondColumn[i] = "";
            }

        // Determines the number of spaces needed after the second column for each row
            // Then stores the spaces in an array
            for (int i = 0; i < standards.length; i++) {
                int spacesNeededForSecondColumn = standardLength - standards[i].length();
                for (int j = 0; j < spacesNeededForSecondColumn; j++) {
                    spacesForSecondColumn[i] += " ";
                }
                spacesForSecondColumn[i] += "             ";
            }

            // Number of spaces after the Type column
            int numberOfSpacesAfterSecondColumn = (standardLength - 4) + 8;

            // Column headings for the data table
            String columnHeadings = String.format("Question #         Type%" + numberOfSpacesAfterSecondColumn + "s" + "Correct/Incorrect" + "\n", "");

        // Loops through each element in the results array
            // adding one row of data to the string each time
            String data = "";
            for (int i = 0; i < standards.length; i++) {
                numberOfSpacesAfterSecondColumn = (standardLength - standards[i].length()) + 8;
                if (i < 9) {
                    data += String.format((i + 1) + "                  " + standards[i] + "%" + numberOfSpacesAfterSecondColumn + "s" + results[i] + "\n", "");
                } else {
                    data += String.format((i + 1) + "                 " + standards[i] + "%" + numberOfSpacesAfterSecondColumn + "s" + results[i] + "\n", "");
                }
            }

            // Sets the textArea with the print preview text
            textArea.setText(headings + columnHeadings + data);

            // Makes the textArea not editable
            textArea.setEditable(false);

            // Displays a print preview
            JOptionPane.showMessageDialog(null, textArea, "Print Assessment Preview", JOptionPane.PLAIN_MESSAGE);

            // Attempts to send a print job
            try {
                boolean complete = textArea.print(null, null, true, null, null, true);
                if (complete) {
                    /* show a success message  */

                } else {
                    /*show a message indicating that printing was cancelled */

                }
            } catch (PrinterException pe) {
                /* Printing failed, report to the user */

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select an assessment to print.", "Print Assessment", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void helpAudioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpAudioButtonActionPerformed

        /*
         * This is the code that plays the audio .wav file.
         * This audio .wav file is the audio tutorial
         * to help the user understand this screen.
         */
        // Creates a filepath to the .wav file
        File yourFile = new File("src/sounds/PrintReports 1.wav");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton helpAudioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
