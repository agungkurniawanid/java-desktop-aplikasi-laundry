package formManipultionData;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import static dashboard.dashboardAdmin.tabel_data_pelanggan;
import static dashboard.dashboardKasir.tabel_data_pelanggan_2;
import static dashboard.dashboardKasir.table_data_pelanggan_kasir;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import notification.Notification;

public class edtiDataPelanggan extends javax.swing.JFrame {

    public edtiDataPelanggan() {
        initComponents();
        menampilkanDataPelanggan();
        field_nomor_telfon_edit.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(field_nomor_telfon_edit.getText());
                } catch (NumberFormatException ex) {
                    if (field_nomor_telfon_edit.getText().isEmpty()) {
                        System.out.println("");
                    } else {
                        harusAngka();
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Edit Data Pelanggan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        field_id_pelanggan_edit.setEnabled(false);
        field_id_pelanggan_edit.setLabelText("ID Pelanggan");
        field_id_pelanggan_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_id_pelanggan_editMouseClicked(evt);
            }
        });
        jPanel1.add(field_id_pelanggan_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 193, 310, -1));

        field_nama_pelanggan_edit.setLabelText("Nama Pelanggan");
        jPanel1.add(field_nama_pelanggan_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 243, 310, -1));

        field_alamat_pelanggan_edit.setLabelText("Alamat Pelanggan");
        jPanel1.add(field_alamat_pelanggan_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 293, 310, -1));

        field_nomor_telfon_edit.setLabelText("Nomor");
        field_nomor_telfon_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nomor_telfon_editActionPerformed(evt);
            }
        });
        jPanel1.add(field_nomor_telfon_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 343, 310, -1));

        kButton1.setText("Simpan Perubahan");
        kButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(64, 112, 244));
        kButton1.setkEndColor(new java.awt.Color(64, 112, 244));
        kButton1.setkHoverEndColor(new java.awt.Color(159, 189, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(159, 189, 255));
        kButton1.setkPressedColor(new java.awt.Color(64, 112, 244));
        kButton1.setkSelectedColor(new java.awt.Color(64, 112, 244));
        kButton1.setkStartColor(new java.awt.Color(64, 112, 244));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 423, 310, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Desktop - 14.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(37, 550));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 580));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void harusAngka() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Field hanya boleh berisi angka!");
        panel.showNotification();
    }

    private void field_nomor_telfon_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nomor_telfon_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nomor_telfon_editActionPerformed

    public void menampilkanDataPelanggan() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Pelanggan");
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Alamat Pelanggan");
        tbl.addColumn("Nomor Telfon");
        tabel_data_pelanggan.setModel(tbl);
        table_data_pelanggan_kasir.setModel(tbl);
        tabel_data_pelanggan_2.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from pelanggan");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_pelanggan"),
                    res.getString("nama_pelanggan"),
                    res.getString("alamat"),
                    res.getString("no_telp"),});
                tabel_data_pelanggan.setModel(tbl);
                tabel_data_pelanggan.setModel(tbl);
                table_data_pelanggan_kasir.setModel(tbl);
                tabel_data_pelanggan_2.setModel(tbl);
            }
            int b = tabel_data_pelanggan.getRowCount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        String ID = field_id_pelanggan_edit.getText();
        String Nama = field_nama_pelanggan_edit.getText();
        String Alamat = field_alamat_pelanggan_edit.getText();
        String No_tel = field_nomor_telfon_edit.getText();

        try {
            Long.parseLong(field_nomor_telfon_edit.getText());
            if ((field_nomor_telfon_edit.getText().length() > 13) || (field_nomor_telfon_edit.getText().length() < 11)) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap masukkan momor dengan benar!");
                panel.showNotification();
            } else {
                try {
                    String sql = "UPDATE pelanggan SET id_pelanggan='" + ID + "',nama_pelanggan='" + Nama
                            + "',alamat='" + Alamat + "',no_telp='" + No_tel + "'WHERE id_pelanggan='" + ID + "'";
                    Connection con = (Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    Notification panel = new Notification(this, Notification.Type.SUCCESS,
                            Notification.Location.TOP_CENTER, "Data berhasil di rubah!");
                    panel.showNotification();
                    pst.execute();
                    menampilkanDataPelanggan();
                    reset_pengisian_data_pelanggan();
                    dispose();
                } catch (Exception e) {
                    Notification panel = new Notification(this, Notification.Type.WARNING,
                            Notification.Location.CENTER, "Gagal disimpan");
                    panel.showNotification();
                }
            }
        } catch (Exception e) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Nomor tidak boleh mengandung huruf!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void field_id_pelanggan_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_id_pelanggan_editMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_field_id_pelanggan_editMouseClicked

    void reset_pengisian_data_pelanggan() {
        field_id_pelanggan_edit.setText("");
        field_nama_pelanggan_edit.setText("");
        field_alamat_pelanggan_edit.setText("");
        field_nomor_telfon_edit.setText("");
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
            java.util.logging.Logger.getLogger(edtiDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edtiDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edtiDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edtiDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edtiDataPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final textfield.TextField field_alamat_pelanggan_edit = new textfield.TextField();
    public static final textfield.TextField field_id_pelanggan_edit = new textfield.TextField();
    public static final textfield.TextField field_nama_pelanggan_edit = new textfield.TextField();
    public static final textfield.TextField field_nomor_telfon_edit = new textfield.TextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton kButton1;
    // End of variables declaration//GEN-END:variables
}
