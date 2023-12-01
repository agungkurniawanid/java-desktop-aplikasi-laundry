package formManipultionData;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static dashboard.dashboardAdmin.tabelkasir;
import static dashboard.dataKasirAdmin.jTable1;
import javax.swing.JTable;
import notification.Notification;

public class dbsAdmin_tambahDataKasir extends javax.swing.JFrame {

    public dbsAdmin_tambahDataKasir() {
        initComponents();
        setTitle("Form tambah data pengguna");
        menampilkanDataPengguna();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setText("Tambah Data Pengguna");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        notel_user.setLabelText("Nomor");
        notel_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notel_userActionPerformed(evt);
            }
        });
        jPanel1.add(notel_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 310, -1));

        id_user.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        id_user.setEnabled(false);
        id_user.setLabelText("ID Pengguna");
        id_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_userMouseClicked(evt);
            }
        });
        jPanel1.add(id_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 310, -1));

        username_user.setLabelText("Username");
        jPanel1.add(username_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 310, -1));

        nama_user.setLabelText("Nama Pengguna");
        jPanel1.add(nama_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 310, -1));

        password_user.setLabelText("Password");
        password_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_userActionPerformed(evt);
            }
        });
        jPanel1.add(password_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 310, -1));

        alamat_user.setLabelText("Alamat");
        alamat_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat_userActionPerformed(evt);
            }
        });
        jPanel1.add(alamat_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 310, -1));

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

        hakAkses_user.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "kasir" }));
        hakAkses_user.setSelectedIndex(-1);
        hakAkses_user.setLabeText("Pilih Hak Akses");
        hakAkses_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hakAkses_userActionPerformed(evt);
            }
        });
        jPanel1.add(hakAkses_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 310, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Desktop - 13_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void reset() {
        id_user.setText("");
        nama_user.setText("");
        alamat_user.setText("");
        notel_user.setText("");
        username_user.setText("");
        password_user.setText("");
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
    private void notel_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notel_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notel_userActionPerformed

    private void password_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_userActionPerformed

    private void alamat_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_userActionPerformed

    private void hakAkses_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hakAkses_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hakAkses_userActionPerformed

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
        String ID = id_user.getText();
        String Nama = nama_user.getText();
        String username1 = username_user.getText();
        String Password = password_user.getText();
        String Alamat = alamat_user.getText();
        String noTel = notel_user.getText();
        String aks = (String) hakAkses_user.getSelectedItem();
        try {
            Long.parseLong(notel_user.getText());
            if (notel_user.getText().length() > 13) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor tidak boleh berjumlah lebih dari 13!");
                panel.showNotification();
            } else if (notel_user.getText().length() < 11) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor tidak bleh berjumlah kurang dari 11!");
                panel.showNotification();
            } else if (nama_user.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama pengguna belum di isi!");
                panel.showNotification();
            } else if (username_user.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Username belum di isi!");
                panel.showNotification();
            } else if (password_user.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Password belum di isi!");
                panel.showNotification();
            } else if (alamat_user.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Alamat belum di isi!");
                panel.showNotification();
            } else if (notel_user.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor belum di isi!");
                panel.showNotification();
            } else if (hakAkses_user.getSelectedItem().equals("")) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Hak akses belum di isi!");
                panel.showNotification();
            } else if (nama_user.getText().length() > 50) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Hanya boleh mengisi 50 karakter tidak boleh lebih!");
                panel.showNotification();
            } else if (nama_user.getText().length() < 7) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap masukkan nama lengkap! nama terlalu pendek!");
                panel.showNotification();
            } else if (username_user.getText().length() > 15) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Username tidak boleh lebih dari 15 karakter!");
                panel.showNotification();
            } else if (username_user.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Username tidak boleh lebih pendek dari 5 karakter!");
                panel.showNotification();
            } else if (password_user.getText().length() > 15) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Password tidak boleh lebih dari 15 karakter!");
                panel.showNotification();
            } else if (password_user.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Password tidak boleh lebih pendek dari 5 karakter!");
                panel.showNotification();
            } else if (alamat_user.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap masukkan alamat dengan lengkap!");
                panel.showNotification();
            } else {
                try {
                    String sql = "INSERT INTO user VALUES('" + ID + "', '" + Nama + "','" + username1 + "','" + Password +
                            "', '" + Alamat + "','" + noTel + "','" + aks + "')";
                    Connection con = (Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    Notification panel = new Notification(this, Notification.Type.SUCCESS, 
                            Notification.Location.TOP_CENTER, "Berhasil disimpan!");
                    panel.showNotification();
                    reset();
                    menampilkanDataPengguna();
                    menampilkanDataKasir(jTable1);
                    dispose();
                } catch (Exception e) {
                    Notification panel = new Notification(this, Notification.Type.WARNING,
                            Notification.Location.CENTER, "Gagal ditambahkan!");
                    panel.showNotification();
                }
            }
        } catch (Exception e) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Nomor tidak boleh mengandung huruf!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void id_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_userMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_id_userMouseClicked

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
            java.util.logging.Logger.getLogger(dbsAdmin_tambahDataKasir.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_tambahDataKasir.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_tambahDataKasir.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dbsAdmin_tambahDataKasir.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dbsAdmin_tambahDataKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final textfield.TextField alamat_user = new textfield.TextField();
    public static final combobox.Combobox hakAkses_user = new combobox.Combobox();
    public static final textfield.TextField id_user = new textfield.TextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton kButton1;
    public static final textfield.TextField nama_user = new textfield.TextField();
    public static final textfield.TextField notel_user = new textfield.TextField();
    public static final textfield.TextField password_user = new textfield.TextField();
    public static final textfield.TextField username_user = new textfield.TextField();
    // End of variables declaration//GEN-END:variables
}
