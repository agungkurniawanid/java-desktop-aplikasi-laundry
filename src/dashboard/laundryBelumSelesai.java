package dashboard;

import com.mysql.jdbc.Statement;
import connection.connect;
import static dashboard.dashboardKasir.tabel_data_pelanggan_2;
import static dashboard.dashboardKasir.tabel_data_transaksi_kasir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import raven.glasspanepopup.GlassPanePopup;
import sample.message.Message;
import swing.EventCallBack;
import swing.EventTextField;
import tableCustomize.TableCustom;

public class laundryBelumSelesai extends javax.swing.JFrame {

    public laundryBelumSelesai() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        laundryBelumSelesai(tb2);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        laundrySelesai(tb1);
        search_data_laundry();
        GlassPanePopup.install(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        caricari = new swing.TextFieldAnimation();
        jScrollPane2 = new javax.swing.JScrollPane();
        laundryBox = new combobox.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Laundry Belum Selesai");

        tb2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb2);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Laundry Selesai");

        caricari.setBackground(new java.awt.Color(245, 245, 245));
        caricari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caricariActionPerformed(evt);
            }
        });

        tb1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tb1);

        laundryBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tabel Selesai", "Tabel Belum Selesai" }));
        laundryBox.setSelectedIndex(-1);
        laundryBox.setLabeText("Filter Pencarian Tabel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laundryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caricari, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(caricari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(laundryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void notifSearchPelangganTidakMencarih() {
        Message obj = new Message();
        obj.txt.setText("Anda belum mencari pelanggan, ketikkan nama pelanggan pada kolom pencarian ini!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    public void search_data_laundry() {
        caricari.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                if (caricari.getText().isEmpty()) {
                    notifSearchPelangganTidakMencarih();
                } else if (laundryBox.getSelectedItem().equals("Tabel Selesai")) {
                    try {
                        DefaultTableModel tbl = new DefaultTableModel();
                        tbl.addColumn("Nama Pelanggan");
                        tbl.addColumn("Tgl Pesan");
                        tbl.addColumn("Tgl Selesai");
                        try {
                            String sql = "select * from tbl_order join pelanggan on tbl_order.id_pelanggan = pelanggan.id_pelanggan where pelanggan.nama_pelanggan like '%" + caricari.getText() + "%' && status_ambil = 'sudah di ambil'";
                            Connection con = (Connection) connect.configDB();
                            Statement st = (Statement) con.createStatement();
                            ResultSet rs = st.executeQuery(sql);
                            if (rs.next()) {
                                tbl.addRow(new Object[]{
                                    rs.getString("nama_pelanggan"),
                                    rs.getString("tgl_pesan"),
                                    rs.getString("tgl_selesai"),});
                                tb1.setModel(tbl);
                            } else if (!rs.next()) {
                                notifSearchPelangganTidakMencarih();
                            }
                        } catch (Exception e) {
                        }
                        for (int i = 1; i <= 70; i++) {
                            caricari.setText("");
                            Thread.sleep(10);
                        }
                        call.done();
                    } catch (Exception e) {
                    }
                } else if (laundryBox.getSelectedItem().equals("Tabel Belum Selesai")) {
                    try {
                        DefaultTableModel tbl = new DefaultTableModel();
                        tbl.addColumn("Nama Pelanggan");
                        tbl.addColumn("Tgl Pesan");
                        tbl.addColumn("Tgl Selesai");
                        try {
                            String sql = "select * from tbl_order join pelanggan on tbl_order.id_pelanggan = pelanggan.id_pelanggan where pelanggan.nama_pelanggan like '%" + caricari.getText() + "%' && status_ambil='belum di ambil'";
                            Connection con = (Connection) connect.configDB();
                            Statement st = (Statement) con.createStatement();
                            ResultSet rs = st.executeQuery(sql);
                            if (rs.next()) {
                                tbl.addRow(new Object[]{
                                    rs.getString("nama_pelanggan"),
                                    rs.getString("tgl_pesan"),
                                    rs.getString("tgl_selesai"),});
                                tb2.setModel(tbl);
                            } else if (!rs.next()) {
                                notifSearchPelangganTidakMencarih();
                            }
                        } catch (Exception e) {
                        }
                        for (int i = 1; i <= 70; i++) {
                            caricari.setText("");
                            Thread.sleep(10);
                        }
                        call.done();
                    } catch (Exception e) {
                    }
                }
                for (int i = 1; i <= 70; i++) {
                    caricari.setText("");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(laundryBelumSelesai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                call.done();
            }

            @Override
            public void onCancel() {

            }
        });
    }

    public void laundrySelesai(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Tgl Pesan");
        tbl.addColumn("Tgl Selesai");
        tb1.setModel(tbl);
        try {
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tbl_order join pelanggan on tbl_order.id_pelanggan = pelanggan.id_pelanggan where status_ambil = 'sudah di ambil'");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("nama_pelanggan"),
                    res.getString("tgl_pesan"),
                    res.getString("tgl_selesai"),});
                tb1.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void laundryBelumSelesai(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Tgl Pesan");
        tbl.addColumn("Tgl Selesai");
        tb2.setModel(tbl);
        try {
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tbl_order join pelanggan on tbl_order.id_pelanggan = pelanggan.id_pelanggan where status_ambil = 'belum di ambil'");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("nama_pelanggan"),
                    res.getString("tgl_pesan"),
                    res.getString("tgl_selesai"),});
                tb2.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }
    private void caricariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caricariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caricariActionPerformed

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
            java.util.logging.Logger.getLogger(laundryBelumSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laundryBelumSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laundryBelumSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laundryBelumSelesai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laundryBelumSelesai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.TextFieldAnimation caricari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private combobox.Combobox laundryBox;
    public static final javax.swing.JTable tb1 = new javax.swing.JTable();
    public static final javax.swing.JTable tb2 = new javax.swing.JTable();
    // End of variables declaration//GEN-END:variables
}
