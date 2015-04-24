
import java.awt.Dimension;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samir
 */
public class PrintReports extends javax.swing.JInternalFrame {

    // Main class
    Main main;
    
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
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);
        
    }
    
    // This method selects the quizzes and final assessments from the DB
    // then displays them in the table
    public void displayAssessments() {
        
        try {
            
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
                false, false, true, false, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(351, 351, 351))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When the internal frame closes this method sets the variable to false
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
     
        // Sets the variable to false
        main.setisPrintReportsScreenOpen(false);
        
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
