package formManipultionData;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import static dashboard.dashboardAdmin.tabel_data_pelanggan;
import static dashboard.dashboardKasir.jLabel10;
import static dashboard.dashboardKasir.tabel_data_pelanggan_2;
import static dashboard.dashboardKasir.table_data_pelanggan_kasir;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import notification.Notification;
import tableCustomize.TableCustom;

public class tambahDataPelanggan extends javax.swing.JFrame {

    public tambahDataPelanggan() {
        initComponents();
        setTitle("Form tambah data pelanggan");
        menampilkan_data_pelanggan();
        id_otomatis_pelanggan();

        field_nomor_telfon.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(field_nomor_telfon.getText());
                } catch (NumberFormatException ex) {
                    if (field_nomor_telfon.getText().isEmpty()) {
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
        jLabel3.setText("Tambah Data Pelanggan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        field_nomor_telfon.setLabelText("Nomor");
        field_nomor_telfon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nomor_telfonActionPerformed(evt);
            }
        });
        jPanel1.add(field_nomor_telfon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, -1));

        field_id_pelanggan.setEnabled(false);
        field_id_pelanggan.setLabelText("ID Pelanggan");
        field_id_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_id_pelangganMouseClicked(evt);
            }
        });
        jPanel1.add(field_id_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 310, -1));

        field_nama_pelanggan.setLabelText("Nama Pelanggan");
        jPanel1.add(field_nama_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 310, -1));

        field_alamat_pelanggan.setLabelText("Alamat Pelanggan");
        jPanel1.add(field_alamat_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 310, -1));

        kButton1.setText("Simpan");
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
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 310, -1));

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

    void reset_pengisian_data_pelanggan() {
        field_id_pelanggan.setText("");
        field_nama_pelanggan.setText("");
        field_alamat_pelanggan.setText("");
        field_nomor_telfon.setText("");
    }

    public void menampilkan_data_pelanggan() {
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
                table_data_pelanggan_kasir.setModel(tbl);
                tabel_data_pelanggan_2.setModel(tbl);
            }
            int b = tabel_data_pelanggan.getRowCount();
            jLabel10.setText("" + b);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }
    private void field_nomor_telfonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nomor_telfonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nomor_telfonActionPerformed

    void id_otomatis_pelanggan() {
        try {
            String sql = "SELECT * from pelanggan ORDER BY id_pelanggan DESC";
            Connection con = (Connection) connection.connect.configDB();
            Statement st = (Statement) con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                String Noplg = res.getString("id_pelanggan").substring(2);
                String AN = "" + (Integer.parseInt(Noplg) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }
                field_id_pelanggan.setText("PL" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                field_id_pelanggan.setText("PL0001");//sesuaikan dengan variable namenya
            }
            res.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }
    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        String ID = field_id_pelanggan.getText();
        String Nama = field_nama_pelanggan.getText();
        String Alamat = field_alamat_pelanggan.getText();
        String noTel = field_nomor_telfon.getText();
        try {
            if ((field_nomor_telfon.getText().length() > 13) || (field_nomor_telfon.getText().length() < 11)) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor tidak boleh berjumlah lebih dari 13!");
                panel.showNotification();
            } else if (field_nama_pelanggan.getText().length() > 50) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama tidak boleh lebih dari 50 karakter!");
                panel.showNotification();
            } else if (field_nama_pelanggan.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap masukkan nama lengkap!");
                panel.showNotification();
            } else if (field_nama_pelanggan.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama pelanggan belum di isi!");
                panel.showNotification();
            } else if (field_alamat_pelanggan.getText().length() > 250) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Alamat tidak boleh lebih dari 250 karakter!");
                panel.showNotification();
            } else if (field_alamat_pelanggan.getText().length() < 7) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap masukkan alamat lengkap!");
                panel.showNotification();
            } else if (field_alamat_pelanggan.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Alamat pelanggan belum di isi!");
                panel.showNotification();
            } else if (field_nomor_telfon.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor telfon belum di isi!");
                panel.showNotification();
            } else {
                try {
                    String sql = "INSERT INTO pelanggan VALUES('" + ID + "', '" + Nama + "', '" + Alamat + "','" + noTel + "', now())";
                    Connection con = (Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    Notification panel = new Notification(this, Notification.Type.SUCCESS,
                            Notification.Location.TOP_CENTER, "Berhasil disimpan!");
                    panel.showNotification();
                    reset_pengisian_data_pelanggan();
                    menampilkan_data_pelanggan();
                    id_otomatis_pelanggan();
                    dispose();
                } catch (Exception e) {
                    Notification panel = new Notification(this, Notification.Type.WARNING,
                            Notification.Location.CENTER, "Gagal disimpan");
                    panel.showNotification();
                }
            }
        } catch (Exception e) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Masukkan nomor telfon dengan benar!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void field_id_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_id_pelangganMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_field_id_pelangganMouseClicked

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
            java.util.logging.Logger.getLogger(tambahDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambahDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambahDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambahDataPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambahDataPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final textfield.TextField field_alamat_pelanggan = new textfield.TextField();
    public static final textfield.TextField field_id_pelanggan = new textfield.TextField();
    public static final textfield.TextField field_nama_pelanggan = new textfield.TextField();
    public static final textfield.TextField field_nomor_telfon = new textfield.TextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton kButton1;
    // End of variables declaration//GEN-END:variables
}
