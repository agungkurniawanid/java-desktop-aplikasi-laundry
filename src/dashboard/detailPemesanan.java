package dashboard;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import static dashboard.dashboardKasir.kd_struk_data_transaksi;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import notification.Notification;
import tableCustomize.TableCustom;

public class detailPemesanan extends javax.swing.JFrame {

    public detailPemesanan() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        hero(tabel_detail_transaksi);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        kode_pk = new textfieldButton.TextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        kButton1 = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Kode Paket Dipilih :");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Tambahkan Keterangan :");

        jScrollPane2.setViewportView(jTextPane1);

        kButton1.setText("Ubah Keterangan");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(0, 102, 255));
        kButton1.setkEndColor(new java.awt.Color(0, 102, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(0, 0, 204));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(0, 0, 204));
        kButton1.setkPressedColor(new java.awt.Color(0, 102, 255));
        kButton1.setkSelectedColor(new java.awt.Color(0, 102, 255));
        kButton1.setkStartColor(new java.awt.Color(0, 102, 255));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        tabel_detail_transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_detail_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_detail_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_detail_transaksi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kode_pk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(kButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kode_pk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        String hero = jTextPane1.getText();
        String Kopak = kode_pk.getText();
        if (jTextPane1.getText().isEmpty() && kode_pk.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Kode paket dan Kolom Keterangan belum anda isi!");
            panel.showNotification();
        } else if (kode_pk.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Paket belum dipilih!");
            panel.showNotification();
        } else if (jTextPane1.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Belum memberikan Keterangan!");
            panel.showNotification();
        } else {
            try {
                String sql = "update tbl_detail_order set keterangan='" + hero + "'WHERE kd_paket='" + Kopak + "'";
                Connection con = (Connection) connection.connect.configDB();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                pst.execute();
                Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Berhasil Edit Keterangan!");
                panel.showNotification();
                hero(tabel_detail_transaksi);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data GAGAL di EDIT");
            }
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void tabel_detail_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_detail_transaksiMouseClicked
        // TODO add your handling code here:
        int baris = tabel_detail_transaksi.rowAtPoint(evt.getPoint());
        tabel_detail_transaksi.rowAtPoint(evt.getPoint());
        String hero = tabel_detail_transaksi.getValueAt(baris, 1).toString();
        kode_pk.setText(hero);
    }//GEN-LAST:event_tabel_detail_transaksiMouseClicked

    public void hero(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Struk");
        tbl.addColumn("Kode Paket");
        tbl.addColumn("Nama Paket");
        tbl.addColumn("Harga Satuan");
        tbl.addColumn("Jenis Paket");
        tbl.addColumn("Kuantitas");
        tbl.addColumn("Subtotal");
        tbl.addColumn("Keterangan");
        tabel_detail_transaksi.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tbl_detail_order join paket on paket.kd_paket=tbl_detail_order.kd_paket WHERE kode_order='" + kd_struk_data_transaksi.getText() + "' ");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kode_order"),
                    res.getString("kd_paket"),
                    res.getString("nama_paket"),
                    res.getString("harga"),
                    res.getString("jenis_paket"),
                    res.getString("qty"),
                    res.getString("subtotal"),
                    res.getString("keterangan")
                });
                tabel_detail_transaksi.setModel(tbl);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(detailPemesanan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detailPemesanan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detailPemesanan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detailPemesanan.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detailPemesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private com.k33ptoo.components.KButton kButton1;
    private textfieldButton.TextField kode_pk;
    public static final javax.swing.JTable tabel_detail_transaksi = new javax.swing.JTable();
    // End of variables declaration//GEN-END:variables
}
