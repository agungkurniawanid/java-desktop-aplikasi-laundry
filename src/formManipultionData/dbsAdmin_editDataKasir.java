package formManipultionData;

import com.mysql.jdbc.Statement;
import static formManipultionData.dbsAdmin_editDataKasir_det.alamat_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.id_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.nama_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.notel_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.password_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.username_user_edit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static dashboard.dashboardAdmin.tabelkasir;
import static dashboard.dataKasirAdmin.jTable1;
import javax.swing.JTable;
import notification.Notification;
import static formManipultionData.dbsAdmin_editDataKasir_det.hak_akses_pen;

public class dbsAdmin_editDataKasir extends javax.swing.JFrame {

    public dbsAdmin_editDataKasir() {
        initComponents();
        menampilkanDataPengguna();
        menampilkanDataKasir(jTable1);
        setTitle("Form edit data pengguna");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Edit Data Pengguna");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        id_user_edit1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        id_user_edit1.setEnabled(false);
        id_user_edit1.setLabelText("ID Pengguna");
        id_user_edit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_user_edit1MouseClicked(evt);
            }
        });
        jPanel1.add(id_user_edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 310, -1));

        nama_user_edit1.setLabelText("Nama Pengguna");
        jPanel1.add(nama_user_edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 310, -1));

        alamat_user_edit1.setLabelText("Alamat");
        alamat_user_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat_user_edit1ActionPerformed(evt);
            }
        });
        jPanel1.add(alamat_user_edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 310, -1));

        notel_user_edit1.setLabelText("Nomor");
        notel_user_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notel_user_edit1ActionPerformed(evt);
            }
        });
        jPanel1.add(notel_user_edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 310, -1));

        kButton1.setText("Simpan Data");
        kButton1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
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
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 230, 40));

        kButton2.setText("Detail");
        kButton2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(64, 112, 244));
        kButton2.setkEndColor(new java.awt.Color(64, 112, 244));
        kButton2.setkHoverEndColor(new java.awt.Color(159, 189, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(159, 189, 255));
        kButton2.setkPressedColor(new java.awt.Color(64, 112, 244));
        kButton2.setkSelectedColor(new java.awt.Color(64, 112, 244));
        kButton2.setkStartColor(new java.awt.Color(64, 112, 244));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 70, 40));

        hakAksesPertama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "kasir" }));
        hakAksesPertama.setSelectedIndex(-1);
        hakAksesPertama.setLabeText("Hak Akses");
        hakAksesPertama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hakAksesPertamaActionPerformed(evt);
            }
        });
        jPanel1.add(hakAksesPertama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 310, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Desktop - 13_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 520));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void reset() {
        id_user_edit1.setText("");
        nama_user_edit1.setText("");
        alamat_user_edit1.setText("");
        notel_user_edit1.setText("");
    }
    private void alamat_user_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat_user_edit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_user_edit1ActionPerformed

    private void notel_user_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notel_user_edit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notel_user_edit1ActionPerformed

    public void menampilkanDataPengguna() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Kasir");
        tbl.addColumn("Nama Kasir");
        tbl.addColumn("Alamat");
        tbl.addColumn("Nomor");
        tbl.addColumn("Status");
        tabelkasir.setModel(tbl);
        try {
            String kasir = "kasir";
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from user");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_user"),
                    res.getString("nama"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("akses")
                });
                tabelkasir.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void menampilkanDataKasir(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Pengguna");
        tbl.addColumn("Nama Pengguna");
        tbl.addColumn("Alamat Pengguna");
        tbl.addColumn("Nomor Pengguna");
        tbl.addColumn("Status");
        jTable1.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from user where akses = 'kasir'");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_user"),
                    res.getString("nama"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("akses"),});
                jTable1.setModel(tbl);
            }
            //int b = tabelkasir.getRowCount();
            //jumlah_data_kasir.setText("" + b);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        String ID = id_user_edit1.getText();
        String Nama = nama_user_edit1.getText();
        String Alamat = alamat_user_edit1.getText();
        String noTel = notel_user_edit1.getText();
        String aks = (String) hakAksesPertama.getSelectedItem();
        try {
            Long.parseLong(notel_user_edit1.getText());
            if (notel_user_edit1.getText().length() > 13) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Nomor tidak boleh berjumlah lebih dari 13!");
                panel.showNotification();
            } else if (notel_user_edit1.getText().length() < 11) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Nomor tidak boleh berjumlah kurang dari 11!");
                panel.showNotification();
            } else if (nama_user_edit1.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Nama pengguna belum di isi!");
                panel.showNotification();
            } else if (alamat_user_edit1.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Alamat belum di isi!");
                panel.showNotification();
            } else if (notel_user_edit1.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Alamat belum di isi!");
                panel.showNotification();
            } else if (hakAksesPertama.getSelectedItem().equals("")) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Hak akses belum di pilih!");
                panel.showNotification();
            } else if (nama_user_edit1.getText().length() > 50) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Hanya boleh mengisi 50 karakter tidak boleh lebih!");
                panel.showNotification();
            } else if (nama_user_edit1.getText().length() < 7) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Nama terlalu pendek, harap isi dengan nama lengkap!");
                panel.showNotification();
            } else if (alamat_user_edit1.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Harap masukkan alamat dengan lengkap!");
                panel.showNotification();
            } else {
                try {
                    String sql = "UPDATE user SET id_user='" + ID + "',nama='" + Nama + "',alamat='" + Alamat + "',no_hp='" + noTel + "', akses='" + aks + "'WHERE id_user='" + session.session.getId_kasir_ubah() + "'";
                    Connection con = (Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Berhasil di update!");
                    panel.showNotification();
                    pst.execute();
                    menampilkanDataPengguna();
                    menampilkanDataKasir(jTable1);
                    dispose();
                } catch (Exception e) {
                    Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Gagal di edit!");
                    panel.showNotification();
                }
            }
        } catch (Exception e) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Nomor tidak boleh mengandung huruf!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "select * from user where id_user ='" + id_user_edit1.getText() + "'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                id_user_edit.setText(rs.getString(1));
                nama_user_edit.setText(rs.getString(2));
                username_user_edit.setText(rs.getString(3));
                password_user_edit.setText(rs.getString(4));
                alamat_user_edit.setText(rs.getString(5));
                notel_user_edit.setText(rs.getString(6));
                hak_akses_pen.setSelectedItem(rs.getString(7));
                new dbsAdmin_editDataKasir_det().setVisible(true);
                dispose();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void hakAksesPertamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hakAksesPertamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hakAksesPertamaActionPerformed

    private void id_user_edit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_user_edit1MouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_id_user_edit1MouseClicked

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
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dbsAdmin_editDataKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final textfield.TextField alamat_user_edit1 = new textfield.TextField();
    public static final combobox.Combobox hakAksesPertama = new combobox.Combobox();
    public static final textfield.TextField id_user_edit1 = new textfield.TextField();
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    public static final textfield.TextField nama_user_edit1 = new textfield.TextField();
    public static final textfield.TextField notel_user_edit1 = new textfield.TextField();
    // End of variables declaration//GEN-END:variables
}
