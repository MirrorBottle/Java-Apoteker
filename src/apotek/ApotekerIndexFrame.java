/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

//Apoteker Frame
import apotek.ApotekerCreateFrame;
import apotek.ApotekerEditFrame;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BAYU
 */
public class ApotekerIndexFrame extends javax.swing.JFrame {

    static Connection con;
    static Statement statement;
    static ResultSet result;

    /**
     * Creates new form dashboardFrame
     */
    public ApotekerIndexFrame() {
        initComponents();
        dataTable();
    }

    public void dataTable() {
        int i = 1;
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("No.");
        table.addColumn("Agen ID");
        table.addColumn("Nama");
        table.addColumn("Alamat");
        table.addColumn("Email");
        table.addColumn("No. Telp");
        table.addColumn("Jenis Kelamin");
        apoteker_data_table.setModel(table);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
            statement = con.createStatement();
            result = statement.executeQuery("SELECT * FROM apoteker");

            while (result.next()) {
                table.addRow(new Object[]{
                    i,
                    result.getString("id_apoteker"),
                    result.getString("nama"),
                    result.getString("alamat"),
                    result.getString("email"),
                    result.getString("no_telp"),
                    result.getString("jenis_kelamin")
                });
                i++;
                apoteker_data_table.setModel(table);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error : " + e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ubah_apoteker_btn = new javax.swing.JButton();
        hapus_apoteker_btn = new javax.swing.JButton();
        tambah_apoteker_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        apoteker_data_table = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(170, 172, 173));
        jPanel2.setForeground(new java.awt.Color(139, 139, 139));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton1.setText("Apoteker");

        jButton2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton2.setText("Apoteker");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel1.setText("Manajemen Apoteker");

        ubah_apoteker_btn.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        ubah_apoteker_btn.setText("Ubah");
        ubah_apoteker_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_apoteker_btnActionPerformed(evt);
            }
        });

        hapus_apoteker_btn.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        hapus_apoteker_btn.setText("Hapus");
        hapus_apoteker_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_apoteker_btnActionPerformed(evt);
            }
        });

        tambah_apoteker_btn.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        tambah_apoteker_btn.setText("Tambah");
        tambah_apoteker_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_apoteker_btnActionPerformed(evt);
            }
        });

        apoteker_data_table.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        apoteker_data_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(apoteker_data_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(tambah_apoteker_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubah_apoteker_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus_apoteker_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ubah_apoteker_btn)
                    .addComponent(hapus_apoteker_btn)
                    .addComponent(tambah_apoteker_btn))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ubah_apoteker_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_apoteker_btnActionPerformed
        // TODO add your handling code here:
        if (apoteker_data_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu!");
        } else {
            ApotekerEditFrame editApoteker = new ApotekerEditFrame();
            editApoteker.setId(String.valueOf(apoteker_data_table.getValueAt(apoteker_data_table.getSelectedRow(), 1)));
            editApoteker.setDefaultData();
            editApoteker.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ubah_apoteker_btnActionPerformed

    private void hapus_apoteker_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_apoteker_btnActionPerformed
        if (apoteker_data_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu!");
        } else {
            int choice = JOptionPane.showConfirmDialog(null, "Data yang dihapus tidak bisa dikembalikan kembali. Yakin?");
            if (choice == 0) {
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
                    statement = con.createStatement();
                    statement.executeUpdate("DELETE FROM `apoteker` WHERE `apoteker`.`id_apoteker` = " + Integer.valueOf(String.valueOf(apoteker_data_table.getValueAt(apoteker_data_table.getSelectedRow(), 1))));
                    JOptionPane.showMessageDialog(null, "Data apoteker telah dihapus");
                    dataTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection error : " + e);
                }

            }
        }

    }//GEN-LAST:event_hapus_apoteker_btnActionPerformed

    private void tambah_apoteker_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_apoteker_btnActionPerformed
        new ApotekerCreateFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tambah_apoteker_btnActionPerformed

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
            java.util.logging.Logger.getLogger(ApotekerIndexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApotekerIndexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApotekerIndexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApotekerIndexFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ApotekerIndexFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable apoteker_data_table;
    private javax.swing.JButton hapus_apoteker_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tambah_apoteker_btn;
    private javax.swing.JButton ubah_apoteker_btn;
    // End of variables declaration//GEN-END:variables
}
