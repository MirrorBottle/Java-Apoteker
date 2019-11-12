/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import java.sql.*;
import javax.swing.JOptionPane;
import apotek.ApotekerIndexFrame;

/**
 *
 * @author BAYU
 */
public class GudangEditFrame extends javax.swing.JFrame {

    private static int id;

    static Connection con;
    static Statement statement;
    static ResultSet result;

    /**
     * Creates new form dashboardFrame
     */
    public GudangEditFrame() {
        initComponents();
    }

    public void setDefaultData() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
            statement = con.createStatement();
            result = statement.executeQuery("SELECT * FROM apoteker WHERE id_apoteker = " + this.getId());
            if (result.next()) {
                name_textbox.setText(result.getString("nama"));
                email_textbox.setText(result.getString("email"));
                phone_textbox.setText(result.getString("no_telp"));
                address_textarea.setText(result.getString("alamat"));
                password_textbox.setText(result.getString("password"));
                gender_comboBox.setSelectedItem(result.getString("jenis_kelamin"));
            } else {
                JOptionPane.showMessageDialog(null, "Data apoteker tidak ada! id = " + this.getId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error : " + e);
        }
    }

    public void setId(String id) {
        this.id = Integer.valueOf(id);
    }

    public int getId() {
        return this.id;
    }

    private void clearAll() {
        name_textbox.setText("");
        email_textbox.setText("");
        phone_textbox.setText("");
        address_textarea.setText("");
        password_textbox.setText("");
    }

    private void clearValidation() {
        name_validate.setText(" ");
        email_validate.setText(" ");
        phone_validate.setText(" ");
        address_validate.setText(" ");
        password_validate.setText(" ");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name_textbox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email_textbox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address_textarea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        phone_textbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gender_comboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        password_textbox = new javax.swing.JPasswordField();
        submit_btn = new javax.swing.JButton();
        email_validate = new javax.swing.JLabel();
        name_validate = new javax.swing.JLabel();
        address_validate = new javax.swing.JLabel();
        phone_validate = new javax.swing.JLabel();
        password_validate = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();

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
        setTitle("Apotek");
        setAlwaysOnTop(true);

        jPanel2.setBackground(new java.awt.Color(170, 172, 173));
        jPanel2.setForeground(new java.awt.Color(139, 139, 139));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton1.setText("Apoteker");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel1.setText("Manajemen Apoteker");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel2.setText("Tambah Data Apoteker");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel3.setText("Nama : ");

        name_textbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel4.setText("Email : ");

        email_textbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel5.setText("Alamat : ");

        address_textarea.setColumns(20);
        address_textarea.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        address_textarea.setRows(5);
        jScrollPane1.setViewportView(address_textarea);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel6.setText("No Telp :");

        phone_textbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel7.setText("Jenis Kelamin : ");

        gender_comboBox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        gender_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan", " " }));
        gender_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_comboBoxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel8.setText("Password : ");

        password_textbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        submit_btn.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        submit_btn.setText("Ubah");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });

        email_validate.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        email_validate.setForeground(new java.awt.Color(243, 36, 36));
        email_validate.setText("    ");

        name_validate.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        name_validate.setForeground(new java.awt.Color(243, 36, 36));
        name_validate.setText("                          ");

        address_validate.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        address_validate.setForeground(new java.awt.Color(243, 36, 36));
        address_validate.setText("   ");

        phone_validate.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        phone_validate.setForeground(new java.awt.Color(243, 36, 36));
        phone_validate.setText("  ");

        password_validate.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        password_validate.setForeground(new java.awt.Color(243, 36, 36));
        password_validate.setText("   ");

        back_btn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        back_btn.setText("Kembali");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(gender_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address_validate)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phone_validate)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_validate)
                            .addComponent(password_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(email_validate)
                                .addComponent(name_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(name_validate)))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(back_btn))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(name_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(name_validate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(email_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(email_validate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(address_validate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone_validate)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(gender_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_validate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submit_btn)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gender_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender_comboBoxActionPerformed

    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed
        // Validation
        if (name_textbox.getText().equals("")) {
            name_validate.setText("Nama wajib diisi!");
        } else if (email_textbox.getText().equals("")) {
            email_validate.setText("Email wajib diisi!");
        } else if (address_textarea.getText().equals("")) {
            address_validate.setText("Alamat wajib diisi!");
        } else if (phone_textbox.getText().equals("")) {
            phone_validate.setText("Nomor telpon wajib diisi!");
        } else if (password_textbox.getText().equals("")) {
            password_validate.setText("Password wajib diisi!");
        } else {
            this.clearValidation();
            String name = name_textbox.getText();
            String email = email_textbox.getText();
            String address = address_textarea.getText();
            String phone = phone_textbox.getText();
            String gender = String.valueOf(gender_comboBox.getSelectedItem());
            String password = password_textbox.getText();
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
                statement = con.createStatement();
                statement.executeUpdate("UPDATE `apoteker` SET `nama` = '" + name + "', `password` = '" + password + "', `jenis_kelamin` = '" + gender + "', `alamat` = '" + address + "', `email` = '" + email + "', `no_telp` = '" + phone + "' WHERE `apoteker`.`id_apoteker` = " + this.getId() + ";");
                JOptionPane.showMessageDialog(null, "Data berhasil  diubah");
                new ApotekerIndexFrame().setVisible(true);
                this.dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connection error" + e);
            }
        }

    }//GEN-LAST:event_submit_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        new ApotekerIndexFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

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
            java.util.logging.Logger.getLogger(GudangEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GudangEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GudangEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GudangEditFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new GudangEditFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address_textarea;
    private javax.swing.JLabel address_validate;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField email_textbox;
    private javax.swing.JLabel email_validate;
    private javax.swing.JComboBox<String> gender_comboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_textbox;
    private javax.swing.JLabel name_validate;
    private javax.swing.JPasswordField password_textbox;
    private javax.swing.JLabel password_validate;
    private javax.swing.JTextField phone_textbox;
    private javax.swing.JLabel phone_validate;
    private javax.swing.JButton submit_btn;
    // End of variables declaration//GEN-END:variables
}
