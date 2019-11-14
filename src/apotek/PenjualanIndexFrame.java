/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek;

import apotek.PengirimanEditFrame;
import apotek.PengirimanCreateFrame;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author BAYU
 */
public class PenjualanIndexFrame extends javax.swing.JFrame {

    static Date date = new Date();
    static Connection con;
    static Statement statement;
    static ResultSet result;
    //Obat Statement and ResultSet
    static Statement obat_statement;
    static ResultSet data_obat;
    //Agen Statement and ResultSet
    static Statement pembeli_statement;
    static ResultSet data_pembeli;
    //Apoteker Statement and ResultSet
    static Statement apoteker_statement;
    static ResultSet data_apoteker;

    /**
     * Creates new form dashboardFrame
     */
    public PenjualanIndexFrame() {
        initComponents();
        dataTable();

    }

    public void dataTable() {
        int i = 1;
        int total_data = 0;
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("No.");
        table.addColumn("ID Penjualan");
        table.addColumn("Nama Pembeli");
        table.addColumn("Apoteker Penjual");
        table.addColumn("Nama Obat");
        table.addColumn("Total Obat");
        table.addColumn("Total Biaya");
        table.addColumn("Keterangan");
        table.addColumn("Tanggal Pembelian");
        pengiriman_data_table.setModel(table);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
            statement = con.createStatement();
            result = statement.executeQuery("SELECT * FROM penjualan_obat");
            while (result.next()) {
                total_data++;
                //Get data obat with id_obat
                obat_statement = con.createStatement();
                data_obat = obat_statement.executeQuery("SELECT * FROM obat JOIN pengiriman_obat ON obat.id_obat = " + Integer.valueOf(result.getString("id_obat")));

                //Get data agen with id_agen
                pembeli_statement = con.createStatement();
                data_pembeli = pembeli_statement.executeQuery("SELECT * FROM pembeli JOIN pengiriman_obat ON pembeli.id_pembeli = " + Integer.valueOf(result.getString("id_pembeli")));

                //Get data apoteker with id_apoteker
                apoteker_statement = con.createStatement();
                data_apoteker = apoteker_statement.executeQuery("SELECT * FROM apoteker JOIN pengiriman_obat ON apoteker.id_apoteker = " + Integer.valueOf(result.getString("id_apoteker")));

                if (data_obat.next() && data_pembeli.next() && data_apoteker.next()) {
                    table.addRow(new Object[]{
                        i,
                        result.getString("id_penjualan"),
                        data_pembeli.getString("nama"),
                        data_apoteker.getString("nama"),
                        data_obat.getString("nama_obat"),
                        result.getString("total_obat"),
                        "Rp. " + (Integer.valueOf(data_obat.getString("harga")) * Integer.valueOf(result.getString("total_obat"))),
                        result.getString("keterangan"),
                        result.getString("tanggal_pembelian")
                    });
                    i++;
                }
                pengiriman_data_table.setModel(table);
            }
            jumlah_text.setText("Jumlah Data Pengiriman : " + total_data);
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
        gudang_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pengiriman_data_table = new javax.swing.JTable();
        jumlah_text = new javax.swing.JLabel();
        tambah_pengiriman_btn = new javax.swing.JButton();
        ubah_pengiriman_btn = new javax.swing.JButton();
        hapus_pengiriman_btn = new javax.swing.JButton();

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
        jButton2.setText("Obat");

        gudang_btn.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        gudang_btn.setText("Gudang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gudang_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addGap(27, 27, 27)
                .addComponent(gudang_btn)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel1.setText("Manajemen Pengiriman Obat");

        pengiriman_data_table.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        pengiriman_data_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(pengiriman_data_table);

        jumlah_text.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jumlah_text.setText("Jumlah Data : ");

        tambah_pengiriman_btn.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        tambah_pengiriman_btn.setText("Tambah");
        tambah_pengiriman_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_pengiriman_btnActionPerformed(evt);
            }
        });

        ubah_pengiriman_btn.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        ubah_pengiriman_btn.setText("Ubah");
        ubah_pengiriman_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_pengiriman_btnActionPerformed(evt);
            }
        });

        hapus_pengiriman_btn.setFont(new java.awt.Font("Calibri", 0, 30)); // NOI18N
        hapus_pengiriman_btn.setText("Hapus");
        hapus_pengiriman_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_pengiriman_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(tambah_pengiriman_btn)
                        .addGap(12, 12, 12)
                        .addComponent(ubah_pengiriman_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus_pengiriman_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jumlah_text)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tambah_pengiriman_btn)
                    .addComponent(ubah_pengiriman_btn)
                    .addComponent(hapus_pengiriman_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jumlah_text)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_pengiriman_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_pengiriman_btnActionPerformed
        // TODO add your handling code here:
        new PengirimanCreateFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tambah_pengiriman_btnActionPerformed

    private void ubah_pengiriman_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_pengiriman_btnActionPerformed
        // TODO add your handling code here:
        if (pengiriman_data_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu!");
        } else {
            PengirimanEditFrame editPengiriman = new PengirimanEditFrame();
            editPengiriman.setId(String.valueOf(pengiriman_data_table.getValueAt(pengiriman_data_table.getSelectedRow(), 1)));
            editPengiriman.setDefaultData();
            editPengiriman.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ubah_pengiriman_btnActionPerformed

    private void hapus_pengiriman_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_pengiriman_btnActionPerformed
        // TODO add your handling code here:
        if (pengiriman_data_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris terlebih dahulu!");
        } else {
            int choice = JOptionPane.showConfirmDialog(null, "Data yang dihapus tidak bisa dikembalikan kembali ?");
            if (choice == 0) {
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");
                    statement = con.createStatement();
                    statement.executeUpdate("DELETE FROM `pengiriman_obat` WHERE `pengiriman_obat`.`id_pengiriman` = " + Integer.valueOf(String.valueOf(pengiriman_data_table.getValueAt(pengiriman_data_table.getSelectedRow(), 1))));

                    JOptionPane.showMessageDialog(null, "Data pengiriman telah dihapus");
                    dataTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection error : " + e);
                }

            }
        }
    }//GEN-LAST:event_hapus_pengiriman_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PenjualanIndexFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gudang_btn;
    private javax.swing.JButton hapus_pengiriman_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlah_text;
    private javax.swing.JTable pengiriman_data_table;
    private javax.swing.JButton tambah_pengiriman_btn;
    private javax.swing.JButton ubah_pengiriman_btn;
    // End of variables declaration//GEN-END:variables
}
