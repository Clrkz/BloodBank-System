/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author CORE
 */
public class ArchiveUsers extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String wImage = "No";
    String s;
    Object[] cols = null;

    /**
     * Creates new form Main
     */
    public ArchiveUsers() {
        initComponents();
        //lblSelectedRowUserID.setVisible(false);
        ArchiveUsersTable();
        filter();
        jLabel18.setText("Login As: " +getDetails.fName +" " +getDetails.lName );
        lblSelectedRowUserID.setVisible(false);
    }
   
    void filter(){
        if(getDetails.userType.equals("Admin")){
            jButton4.setVisible(true);
        }else{
            jButton4.setVisible(false);
        }
    }
   
    
    public void ArchiveUsersTable() {
        conn = SQLCon.ConnectDB();
        String sql = "select u.userID as 'User ID',concat(u.fName, ' ',u.mName, ' ',u.lName) as Name,ci.contactNo as 'Contact Number',u.userType as 'User Type',u.username as 'Username' from users u\n" +
"inner join user_personal_info pi\n" +
"on u.userID=pi.userID\n" +
"inner join user_contact_info ci\n" +
"on u.userID=ci.userID where u.archiveStatus=1";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSelectedRowUserID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Bank");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ARCHIVE USERS");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 0, 170, 40);

        lblSelectedRowUserID.setText("UserID");
        jPanel1.add(lblSelectedRowUserID);
        lblSelectedRowUserID.setBounds(620, 20, 50, 14);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodbank/image/backbutton.png"))); // NOI18N
        jLabel4.setToolTipText("Back to Main Menu");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 50, 40);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Name");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(454, 0, 250, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 660, 290);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Search:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(40, 10, 70, 30);

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel2.add(txtSearch);
        txtSearch.setBounds(100, 10, 310, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Type", "Admin", "Staff" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(430, 10, 110, 30);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gender", "Male", "Female" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(550, 10, 110, 30);

        jButton4.setBackground(new java.awt.Color(153, 204, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("RESTORE USER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(350, 350, 160, 30);

        jButton5.setBackground(new java.awt.Color(153, 204, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("USER LIST");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(520, 350, 160, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new MainForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
   int row = jTable1.getSelectedRow();
        if (jTable1.isRowSelected(row) == true) {
            int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure You want Restore this User?", "Blood Bank", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (selectedOption == JOptionPane.YES_OPTION) {
                String del = lblSelectedRowUserID.getText();
                String Sql = "update users set archiveStatus=0 where userID='"+del+"'";
                Connection conn = SQLCon.ConnectDB();
                try {
                    pst = conn.prepareStatement(Sql);
                    pst.executeUpdate();
                    ArchiveUsersTable();
                    conn.close();
                    JOptionPane.showMessageDialog(null, "User Successfully Restore.", "Blood Bank", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select User you want to Restore", "Blood Bank", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if ( jComboBox2.getSelectedItem().equals("Gender")) {
            ArchiveUsersTable();
        } else {
            String getUserType = (String) jComboBox2.getSelectedItem();
            conn = SQLCon.ConnectDB();
            try {
                String sql = "select u.userID as 'User ID',concat(u.fName, ' ',u.mName, ' ',u.lName) as Name,ci.contactNo as 'Contact Number',u.userType as 'User Type',u.username as 'Username' from users u\n" +
                "inner join user_personal_info pi\n" +
                "on u.userID=pi.userID\n" +
                "inner join user_contact_info ci\n" +
                "on u.userID=ci.userID\n" +
                "where u.gender='"+getUserType+"' and u.archiveStatus=1";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if ( jComboBox1.getSelectedItem().equals("User Type")) {
            ArchiveUsersTable();
        } else {
            String getUserType = (String) jComboBox1.getSelectedItem();
            conn = SQLCon.ConnectDB();
            try {
                String sql = "select u.userID as 'User ID',concat(u.fName, ' ',u.mName, ' ',u.lName) as Name,ci.contactNo as 'Contact Number',u.userType as 'User Type',u.username as 'Username' from users u\n" +
                "inner join user_personal_info pi\n" +
                "on u.userID=pi.userID\n" +
                "inner join user_contact_info ci\n" +
                "on u.userID=ci.userID\n" +
                "where u.userType='"+getUserType+"' and u.archiveStatus=1 ";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (txtSearch.getText().equals("")) {
            ArchiveUsersTable();
        } else {
            try {
                String getInfo = txtSearch.getText();
                String sql = "select u.userID as 'User ID',concat(u.fName, ' ',u.mName, ' ',u.lName) as Name,ci.contactNo as 'Contact Number',u.userType as 'User Type',u.username as 'Username' from users u\n" +
                "inner join user_personal_info pi\n" +
                "on u.userID=pi.userID\n" +
                "inner join user_contact_info ci\n" +
                "on u.userID=ci.userID\n" +
                "where u.userID LIKE '%" + getInfo + "%' and u.archiveStatus=1\n" +
                "or u.fName LIKE '%" + getInfo + "%' and u.archiveStatus=1\n" +
                "or u.mName LIKE '%" + getInfo + "%' and u.archiveStatus=1\n" +
                "or u.lName LIKE '%" + getInfo + "%' and u.archiveStatus=1";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        lblSelectedRowUserID.setText(null);
        int column = 0;
        int row = jTable1.getSelectedRow();
        String value = jTable1.getModel().getValueAt(row, column).toString();
        lblSelectedRowUserID.setText(value);        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        lblSelectedRowUserID.setText(null);
        int column = 0;
        int row = jTable1.getSelectedRow();
        String value = jTable1.getModel().getValueAt(row, column).toString();
        lblSelectedRowUserID.setText(value);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new Users().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArchiveUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArchiveUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArchiveUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArchiveUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArchiveUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblSelectedRowUserID;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
