/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import static apotek.GudangIndexFrame.date;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import apotek.ObatIndexFrame;

/**
 *
 * @author BAYU
 */
public class ObatCreateFrame extends javax.swing.JFrame {

    static Connection con;
    static Statement statement;
    static ResultSet result;
    static java.util.Date date = new java.util.Date();

    //Add To Gudang
    static ResultSet gudang_result;

    /**
     * Creates new form dashboardFrame
     */
    public ObatCreateFrame() {
        initComponents();
    }

    private void clearAll() {
        name_textbox.setText("");
        merk_textbox.setText("");
        dosis_spinner.setValue(0);
        composition_textarea.setText("");
        harga_spinner.setValue(0);
    }

    private void clearValidation() {
        name_invalid_text.setText(" ");
        merk_invalid_text.setText(" ");
        compotition_invalid_text.setText(" ");
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name_textbox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        merk_textbox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        composition_textarea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        satuan_comboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        submit_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        dosis_comboBox = new javax.swing.JComboBox<>();
        name_invalid_text = new javax.swing.JLabel();
        compotition_invalid_text = new javax.swing.JLabel();
        dosis_spinner = new javax.swing.JSpinner();
        merk_invalid_text = new javax.swing.JLabel();
        add_to_gudang_checkbox = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        harga_spinner = new javax.swing.JSpinner();

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
        jButton2.setText("Agen");

        jButton3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton3.setText("Obat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton4.setText("Pembeli");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton5.setText("Pengiriman");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton6.setText("Penjualan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jButton7.setText("Gudang");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel1.setText("Manajemen Obat");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel2.setText("Tambah Data Obat");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel3.setText("Nama : ");

        name_textbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel4.setText("Komposisi : ");

        merk_textbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel5.setText("Merk : ");

        composition_textarea.setColumns(20);
        composition_textarea.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        composition_textarea.setRows(5);
        jScrollPane1.setViewportView(composition_textarea);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel6.setText("Dosis :");

        satuan_comboBox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        satuan_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tablet", "Keping", "Ampul", "Botol", "Pen", "Vial", "Tube", "Supp" }));
        satuan_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satuan_comboBoxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel8.setText("Satuan : ");

        submit_btn.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        submit_btn.setText("Tambah");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });

        back_btn.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        back_btn.setText("Kembali");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel9.setText("X");

        dosis_comboBox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        dosis_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sehari", "Dua Hari", "Tiga Hari", "Empat Hari", "Seminggu", "Sebulan", "Dua Bulan", "Enam Bulan", "Setahun", " " }));
        dosis_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosis_comboBoxActionPerformed(evt);
            }
        });

        name_invalid_text.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        name_invalid_text.setForeground(new java.awt.Color(243, 36, 36));
        name_invalid_text.setText("                                    ");

        compotition_invalid_text.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        compotition_invalid_text.setForeground(new java.awt.Color(243, 36, 36));
        compotition_invalid_text.setText("                                           ");

        dosis_spinner.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        merk_invalid_text.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        merk_invalid_text.setForeground(new java.awt.Color(243, 36, 36));
        merk_invalid_text.setText("                                  ");

        add_to_gudang_checkbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        add_to_gudang_checkbox.setSelected(true);
        add_to_gudang_checkbox.setText("Sekalian Menambahkan Data Ke Gudang");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel10.setText("Harga Per Satuan : ");

        harga_spinner.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 552, Short.MAX_VALUE)
                            .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name_invalid_text)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name_textbox, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                                    .addComponent(merk_textbox, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(satuan_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(dosis_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dosis_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addComponent(compotition_invalid_text)
                                .addComponent(merk_invalid_text))
                            .addGap(11, 11, 11)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(harga_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(submit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_to_gudang_checkbox))
                .addContainerGap(201, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name_invalid_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(compotition_invalid_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(merk_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(merk_invalid_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dosis_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(dosis_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(satuan_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(harga_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(add_to_gudang_checkbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submit_btn)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void satuan_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satuan_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_satuan_comboBoxActionPerformed

    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed
        // Validation
        if (name_textbox.getText().equals("")) {
            name_invalid_text.setText("Nama wajib diisi!");
        } else if (merk_textbox.getText().equals("")) {
            merk_invalid_text.setText("Merk wajib diisi!");
        } else if (composition_textarea.getText().equals("")) {
            compotition_invalid_text.setText("Komposisi wajib diisi!");
        } else {
            this.clearValidation();
            String nama_obat = name_textbox.getText();
            String merk_obat = merk_textbox.getText();
            String komposisi_obat = composition_textarea.getText();
            String dosis_obat = String.valueOf(dosis_spinner.getValue()) + " x " + String.valueOf(dosis_comboBox.getSelectedItem());
            String satuan_obat = String.valueOf(satuan_comboBox.getSelectedItem());
            int harga = Integer.valueOf(String.valueOf(harga_spinner.getValue()));
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
                statement = con.createStatement();
                result = statement.executeQuery("SELECT * FROM obat WHERE nama_obat = '" + nama_obat + "'");
                if (result.next()) {
                    name_textbox.setText("");
                    name_invalid_text.setText("Obat Sudah Terdaftar!");
                } else {
                    statement.executeUpdate("INSERT INTO `obat` (`id_obat`, `nama_obat`, `komposisi_obat`, `merk_obat`, `dosis_obat`, `satuan`, `harga`) VALUES (NULL, '" + nama_obat + "', '" + komposisi_obat + "', '" + merk_obat + "', '" + dosis_obat + "', '" + satuan_obat + "', '" + harga + "');");
                    if (add_to_gudang_checkbox.isSelected()) {
                        String today_date = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
                        try {
                            gudang_result = statement.executeQuery("SELECT * FROM obat WHERE nama_obat = '" + nama_obat + "'");
                            if (gudang_result.next()) {
                                statement.executeUpdate("INSERT INTO `gudang` (`id_penyimpanan`, `id_obat`, `stock`, `penambahan_terakhir`, `pengambilan_terakhir`) VALUES (NULL, '" + gudang_result.getString("id_obat") + "', '0', '" + today_date + "', '" + today_date + "');");
                                clearAll();
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Connection error" + e);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Tambah data obat berhasil");
                    clearAll();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connection error" + e);
            }
        }

    }//GEN-LAST:event_submit_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        new ObatIndexFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void dosis_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosis_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dosis_comboBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ObatCreateFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox add_to_gudang_checkbox;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextArea composition_textarea;
    private javax.swing.JLabel compotition_invalid_text;
    private javax.swing.JComboBox<String> dosis_comboBox;
    private javax.swing.JSpinner dosis_spinner;
    private javax.swing.JSpinner harga_spinner;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel merk_invalid_text;
    private javax.swing.JTextField merk_textbox;
    private javax.swing.JLabel name_invalid_text;
    private javax.swing.JTextField name_textbox;
    private javax.swing.JComboBox<String> satuan_comboBox;
    private javax.swing.JButton submit_btn;
    // End of variables declaration//GEN-END:variables
}
