package formManipultionData;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static dashboard.dashboardAdmin.tabelkasir;
import static dashboard.dataKasirAdmin.jTable1;
import javax.swing.JTable;
import notification.Notification;

public class dbsAdmin_editDataKasir_det extends javax.swing.JFrame {

    public dbsAdmin_editDataKasir_det() {
        initComponents();
        setTitle("Form edit data pengguna");
        menampilkanDataKasir(jTable1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Edit Data Pengguna");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        id_user_edit.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        id_user_edit.setLabelText("ID Pengguna");
        id_user_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_user_editMouseClicked(evt);
            }
        });
        id_user_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_user_editActionPerformed(evt);
            }
        });
        jPanel1.add(id_user_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 310, -1));

        nama_user_edit.setLabelText("Nama Pengguna");
        jPanel1.add(nama_user_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 310, -1));

        username_user_edit.setLabelText("Username");
        jPanel1.add(username_user_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 310, -1));

        password_user_edit.setLabelText("Password");
        password_user_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_user_editActionPerformed(evt);
            }
        });
        jPanel1.add(password_user_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 310, -1));

        alamat_user_edit.setLabelText("Alamat");
        alamat_user_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat_user_editActionPerformed(evt);
            }
        });
        jPanel1.add(alamat_user_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 310, -1));

        notel_user_edit.setLabelText("Nomor");
        notel_user_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notel_user_editActionPerformed(evt);
            }
        });
        jPanel1.add(notel_user_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 310, -1));

        hak_akses_pen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "kasir" }));
        hak_akses_pen.setSelectedIndex(-1);
        hak_akses_pen.setLabeText("Hak Akses");
        hak_akses_pen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hak_akses_penActionPerformed(evt);
            }
        });
        jPanel1.add(hak_akses_pen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 310, -1));

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
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 310, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Desktop - 13_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 520));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void reset() {
        id_user_edit.setText("");
        nama_user_edit.setText("");
        username_user_edit.setText("");
        password_user_edit.setText("");
        alamat_user_edit.setText("");
        notel_user_edit.setText("");
    }

    public void menampilkanDataPengguna() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Pengguna");
        tbl.addColumn("Nama Pengguna");
        tbl.addColumn("Username");
        tbl.addColumn("Password");
        tbl.addColumn("Alamat Pengguna");
        tbl.addColumn("Nomor Pengguna");
        tbl.addColumn("Status");
        tabelkasir.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from user");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_user"),
                    res.getString("nama"),
                    res.getString("username"),
                    res.getString("password"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("akses")});
                tabelkasir.setModel(tbl);
            }
            //int b = tabelkasir.getRowCount();
            //jumlah_data_kasir.setText("" + b);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }
    private void password_user_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_user_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_user_editActionPerformed

    private void alamat_user_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat_user_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_user_editActionPerformed

    private void notel_user_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notel_user_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notel_user_editActionPerformed

    private void hak_akses_penActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hak_akses_penActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hak_akses_penActionPerformed

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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        String ID = id_user_edit.getText();
        String Nama = nama_user_edit.getText();
        String username1 = username_user_edit.getText();
        String Password = password_user_edit.getText();
        String Alamat = alamat_user_edit.getText();
        String noTel = notel_user_edit.getText();
        String aks = (String) hak_akses_pen.getSelectedItem();
        try {
            Long.parseLong(notel_user_edit.getText());
            if (notel_user_edit.getText().length() > 13) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor tidak boleh berjumlah lebih dari 13!");
                panel.showNotification();
            } else if (notel_user_edit.getText().length() < 11) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor tidak boleh berjumlah kurang dari 11!");
                panel.showNotification();
            } else if (nama_user_edit.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama pengguna belum di isi!");
                panel.showNotification();
            } else if (username_user_edit.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Username belum di isi!");
                panel.showNotification();
            } else if (password_user_edit.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Password belum di isi!");
                panel.showNotification();
            } else if (notel_user_edit.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor belum di isi!");
                panel.showNotification();
            } else if (hak_akses_pen.getSelectedItem().equals("")) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Hak akses belum di isi!");
                panel.showNotification();
            } else if (nama_user_edit.getText().length() > 50) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama Hanya boleh mengisi hingga 50 karakter!");
                panel.showNotification();
            } else if (nama_user_edit.getText().length() < 7) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap masukkan namal lengkap, nama terlalu pendek!");
                panel.showNotification();
            } else if (username_user_edit.getText().length() > 15) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Username tidak boleh lebih dari 15 karakter!");
                panel.showNotification();
            } else if (username_user_edit.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Username tidak boleh lebih pendek dari 5 karakter!");
                panel.showNotification();
            } else if (password_user_edit.getText().length() > 15) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Password tidak boleh lebih dari 15 karater!");
                panel.showNotification();
            } else if (password_user_edit.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Password tidak boleh lebih pendek dari 5 karakter");
                panel.showNotification();
            } else {
                try {
                    String sql = "UPDATE user SET id_user='" + ID + "',nama='" + Nama + "',username='" + username1
                            + "',password='" + Password + "',alamat='" + Alamat + "',no_hp='" + noTel + "',akses='" + aks
                            + "'WHERE id_user='" + session.session.getId_kasir_ubah() + "'";
                    Connection con = (Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    Notification panel = new Notification(this, Notification.Type.SUCCESS,
                            Notification.Location.TOP_CENTER, "Berhasil disimpan!");
                    panel.showNotification();
                    pst.execute();
                    menampilkanDataPengguna();
                    menampilkanDataKasir(jTable1);
                    reset();
                    dispose();
                } catch (Exception e) {
                    Notification panel = new Notification(this, Notification.Type.WARNING,
                            Notification.Location.CENTER, "Gagal disimpan!");
                    panel.showNotification();
                }
            }
        } catch (Exception e) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Nomor tidak boleh mengandung huruf!");
            panel.showNotification();
        }

    }//GEN-LAST:event_kButton1ActionPerformed

    private void id_user_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_user_editMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_id_user_editMouseClicked

    private void id_user_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_user_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_user_editActionPerformed

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
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir_det.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir_det.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir_det.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_editDataKasir_det.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dbsAdmin_editDataKasir_det().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final textfield.TextField alamat_user_edit = new textfield.TextField();
    public static final combobox.Combobox hak_akses_pen = new combobox.Combobox();
    public static final textfield.TextField id_user_edit = new textfield.TextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton kButton1;
    public static final textfield.TextField nama_user_edit = new textfield.TextField();
    public static final textfield.TextField notel_user_edit = new textfield.TextField();
    public static final textfield.TextField password_user_edit = new textfield.TextField();
    public static final textfield.TextField username_user_edit = new textfield.TextField();
    // End of variables declaration//GEN-END:variables
}
