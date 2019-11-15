/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import apotek.PengirimanIndexFrame;

/**
 *
 * @author BAYU
 */
public class PenjualanEditFrame extends javax.swing.JFrame {

    static Connection con;
    static Statement statement;
    static ResultSet result;
    static java.util.Date date = new java.util.Date();

    private static int id;

    //Add To Gudang
    static ResultSet gudang_result;

    //Obat Statement and ResultSet
    static Statement obat_statement;
    static ResultSet data_obat;
    //Agen Statement and ResultSet
    static Statement pembeli_statement;
    static ResultSet data_pembeli;
    //Apoteker Statement and ResultSet
    static Statement apoteker_statement;
    static ResultSet data_apoteker;

    //Original total_obat
    private static int original_total_obat;

    /**
     * Creates new form dashboardFrame
     */
    public PenjualanEditFrame() {
        initComponents();
        setDefaultData();
    }

    public void setId(String id) {
        this.id = Integer.valueOf(id);
    }

    public int getId() {
        return this.id;
    }

    protected void setDefaultData() {
        try {
            DefaultListModel<String> obat_model = new DefaultListModel<>();
            DefaultListModel<String> pembeli_model = new DefaultListModel<>();
            DefaultListModel<String> apoteker_model = new DefaultListModel<>();
            con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
            // Fetch All Obat Data From Table obat
            obat_statement = con.createStatement();
            data_obat = obat_statement.executeQuery("SELECT * FROM obat ORDER BY obat.nama_obat ASC");
            // Fetch All Agen Data From Table agen
            pembeli_statement = con.createStatement();
            data_pembeli = pembeli_statement.executeQuery("SELECT * FROM pembeli ORDER BY pembeli.nama ASC");
            // Fetch All Apoteker Data From Table apoteker
            apoteker_statement = con.createStatement();
            data_apoteker = apoteker_statement.executeQuery("SELECT * FROM apoteker ORDER BY `apoteker`.`nama` ASC");

            //Setting data from database with id that send from index
            statement = con.createStatement();
            result = statement.executeQuery("SELECT * FROM penjualan_obat WHERE id_penjualan = " + this.id);
            if (result.next()) {
                while (data_obat.next()) {
                    if (Integer.valueOf(result.getString("id_obat")) == Integer.valueOf(data_obat.getString("id_obat"))) {
                        default_obat_text.setText(result.getString("id_obat") + " - " + data_obat.getString("nama_obat"));
                    }
                    obat_model.addElement(data_obat.getString("id_obat") + " - " + data_obat.getString("nama_obat"));
                }
                while (data_pembeli.next()) {
                    if (Integer.valueOf(result.getString("id_pembeli")) == Integer.valueOf(data_pembeli.getString("id_pembeli"))) {
                        default_pembeli_text.setText(result.getString("id_pembeli") + " - " + data_pembeli.getString("nama"));
                    }
                    pembeli_model.addElement(data_pembeli.getString("id_pembeli") + " - " + data_pembeli.getString("nama"));
                }
                while (data_apoteker.next()) {
                    if (Integer.valueOf(result.getString("id_apoteker")) == Integer.valueOf(data_apoteker.getString("id_apoteker"))) {
                        default_apoteker_text.setText(result.getString("id_apoteker") + " - " + data_apoteker.getString("nama"));
                    }
                    apoteker_model.addElement(data_apoteker.getString("id_apoteker") + " - " + data_apoteker.getString("nama"));
                }

                //Adding to List
                obat_list.setModel(obat_model);
                pembeli_list.setModel(pembeli_model);
                apoteker_list.setModel(apoteker_model);

                //Setting data from result
                total_obat_spinner.setValue(Integer.valueOf(result.getString("total_obat")));
                this.original_total_obat = Integer.valueOf(result.getString("total_obat"));
                tanggal_pembelian_textbox.setText(result.getString("tanggal_pembelian"));
                keterangan_textarea.setText(result.getString("keterangan"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error : " + e);
        }
    }

    private void clearValidation() {
        obat_invalid_text.setText(" ");
        agen_invalid_text.setText(" ");
        apoteker_invalid_text.setText(" ");
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
        submit_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        agen_invalid_text = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        apoteker_list = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        pembeli_list = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        obat_list = new javax.swing.JList<>();
        total_obat_spinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        tanggal_pembelian_textbox = new javax.swing.JTextField();
        ubah_tanggal_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        apoteker_invalid_text = new javax.swing.JLabel();
        obat_invalid_text = new javax.swing.JLabel();
        default_pembeli_text = new javax.swing.JLabel();
        default_apoteker_text = new javax.swing.JLabel();
        default_obat_text = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        keterangan_textarea = new javax.swing.JTextArea();

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
        jLabel1.setText("Manajemen Penjualan Obat");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        jLabel2.setText("Ubah Data Penjualan");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel3.setText("Total Obat : ");

        submit_btn.setFont(new java.awt.Font("Calibri", 0, 28)); // NOI18N
        submit_btn.setText("Ubah");
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

        agen_invalid_text.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        agen_invalid_text.setForeground(new java.awt.Color(243, 36, 36));
        agen_invalid_text.setText("                                           ");

        apoteker_list.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        apoteker_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(apoteker_list);

        pembeli_list.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        pembeli_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(pembeli_list);

        obat_list.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        obat_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(obat_list);

        total_obat_spinner.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel4.setText("Tanggal Pengiriman : ");

        tanggal_pembelian_textbox.setEditable(false);
        tanggal_pembelian_textbox.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        tanggal_pembelian_textbox.setText("2019-11-13");

        ubah_tanggal_btn.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ubah_tanggal_btn.setText("Ubah Tanggal");
        ubah_tanggal_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_tanggal_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setText("Pembeli Sebelumnya : ");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel6.setText("Apoteker Penerima : ");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel7.setText("Obat Yang Dibeli :");

        apoteker_invalid_text.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        apoteker_invalid_text.setForeground(new java.awt.Color(243, 36, 36));
        apoteker_invalid_text.setText("                                           ");

        obat_invalid_text.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        obat_invalid_text.setForeground(new java.awt.Color(243, 36, 36));
        obat_invalid_text.setText("                                           ");

        default_pembeli_text.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        default_pembeli_text.setText("Pengirim Sebelumnya : ");

        default_apoteker_text.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        default_apoteker_text.setText("Pengirim Sebelumnya : ");

        default_obat_text.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        default_obat_text.setText("Pengirim Sebelumnya : ");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 22)); // NOI18N
        jLabel8.setText("Keterangan : ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        keterangan_textarea.setColumns(20);
        keterangan_textarea.setRows(5);
        jScrollPane5.setViewportView(keterangan_textarea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 582, Short.MAX_VALUE)
                            .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addComponent(agen_invalid_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(default_pembeli_text))
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(jLabel6)
                                    .addComponent(apoteker_invalid_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(default_apoteker_text))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(obat_invalid_text, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(default_obat_text)
                                        .addComponent(jLabel7)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addComponent(submit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tanggal_pembelian_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ubah_tanggal_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(total_obat_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(default_pembeli_text)
                            .addComponent(default_apoteker_text)))
                    .addComponent(default_obat_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agen_invalid_text)
                    .addComponent(apoteker_invalid_text)
                    .addComponent(obat_invalid_text))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(total_obat_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tanggal_pembelian_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubah_tanggal_btn))
                .addGap(49, 49, 49)
                .addComponent(submit_btn)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed

        String id_apoteker;
        String id_pembeli;
        String id_obat;
        String keterangan = keterangan_textarea.getText();
        int total_obat = Integer.valueOf(String.valueOf(total_obat_spinner.getValue()));
        String tanggal_pembelian = tanggal_pembelian_textbox.getText();
        // Validation  
        if (apoteker_list.getSelectedValue() == null) {
            id_apoteker = default_apoteker_text.getText().split(" - ", 2)[0];
        } else {
            id_apoteker = apoteker_list.getSelectedValue().split(" - ", 2)[0];
        }
        if (pembeli_list.getSelectedValue() == null) {
            id_pembeli = default_pembeli_text.getText().split(" - ", 2)[0];
        } else {
            id_pembeli = pembeli_list.getSelectedValue().split(" - ", 2)[0];
        }
        if (obat_list.getSelectedValue() == null) {
            id_obat = default_obat_text.getText().split(" - ", 2)[0];
        } else {
            id_obat = obat_list.getSelectedValue().split(" - ", 2)[0];
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
            statement = con.createStatement();
            statement.executeUpdate("UPDATE `penjualan_obat` SET `id_pembeli` = '" + id_pembeli + "', `id_apoteker` = '" + id_apoteker + "', `id_obat` = '" + id_obat + "', `total_obat` = '" + total_obat + "', `keterangan` = '" + keterangan + "', `tanggal_pembelian` = '" + tanggal_pembelian + "' WHERE `penjualan_obat`.`id_penjualan` = " + this.id + ";");
            try {
                gudang_result = statement.executeQuery("SELECT * FROM gudang WHERE id_obat = '" + id_obat + "';");
                if (gudang_result.next()) {
                    int difference;
                    int updated_stock;
                    if (original_total_obat > total_obat) {
                        difference = original_total_obat - total_obat;
                        updated_stock = Integer.valueOf(gudang_result.getString("stock")) + difference;
                    } else if (original_total_obat < total_obat) {
                        difference = total_obat - original_total_obat;
                        updated_stock = Integer.valueOf(gudang_result.getString("stock")) - difference;
                    } else {
                        updated_stock = Integer.valueOf(gudang_result.getString("stock"));
                    }
                    statement.executeUpdate("UPDATE `gudang` SET `stock` = '" + updated_stock + "' WHERE `gudang`.`id_penyimpanan` = " + Integer.valueOf(gudang_result.getString("id_penyimpanan")) + ";");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connection error" + e);
            }
            JOptionPane.showMessageDialog(null, "Data penjualan berhasil diubah");
            new PengirimanIndexFrame().setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection error" + e);
        }

    }//GEN-LAST:event_submit_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        new ObatIndexFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void ubah_tanggal_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_tanggal_btnActionPerformed
        // TODO add your handling code here:
        tanggal_pembelian_textbox.setEditable(true);
    }//GEN-LAST:event_ubah_tanggal_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PenjualanEditFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agen_invalid_text;
    private javax.swing.JLabel apoteker_invalid_text;
    private javax.swing.JList<String> apoteker_list;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel default_apoteker_text;
    private javax.swing.JLabel default_obat_text;
    private javax.swing.JLabel default_pembeli_text;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea keterangan_textarea;
    private javax.swing.JLabel obat_invalid_text;
    private javax.swing.JList<String> obat_list;
    private javax.swing.JList<String> pembeli_list;
    private javax.swing.JButton submit_btn;
    private javax.swing.JTextField tanggal_pembelian_textbox;
    private javax.swing.JSpinner total_obat_spinner;
    private javax.swing.JButton ubah_tanggal_btn;
    // End of variables declaration//GEN-END:variables
}
