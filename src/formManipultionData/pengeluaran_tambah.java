package formManipultionData;

import com.mysql.jdbc.PreparedStatement;
import connection.connect;
import static dashboard.dashboardAdmin.tabel_pengeluaran;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import notification.Notification;

public class pengeluaran_tambah extends javax.swing.JFrame {

    public pengeluaran_tambah() {
        initComponents();
        kd_pngl_otomatis();
        tanggl_pengel();

        jumlah_uangpengeluaranf.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(jumlah_uangpengeluaranf.getText());
                } catch (NumberFormatException ex) {
                    if (jumlah_uangpengeluaranf.getText().isEmpty()) {
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

        textField3 = new textfield.TextField();
        jPanel1 = new javax.swing.JPanel();
        kode_pengeluaranf = new textfield.TextField();
        jLabel2 = new javax.swing.JLabel();
        tanggal_pengeluaranf = new textfield.TextField();
        keterangan_pengeluaranf = new textfield.TextField();
        jumlah_uangpengeluaranf = new textfield.TextField();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();

        textField3.setLabelText("User Name");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kode_pengeluaranf.setEnabled(false);
        kode_pengeluaranf.setLabelText("Kode Pengeluaran");
        kode_pengeluaranf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kode_pengeluaranfMouseClicked(evt);
            }
        });
        jPanel1.add(kode_pengeluaranf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 330, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Tambah Pengeluaran");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        tanggal_pengeluaranf.setLabelText("Tanggal Pengeluaran");
        jPanel1.add(tanggal_pengeluaranf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 330, -1));

        keterangan_pengeluaranf.setLabelText("Keterangan Pengeluaran");
        jPanel1.add(keterangan_pengeluaranf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 330, -1));

        jumlah_uangpengeluaranf.setLabelText("Jumlah Uang Pengeluaran");
        jPanel1.add(jumlah_uangpengeluaranf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 330, -1));

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
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 330, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formManipultionData/Desktop - 25.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 550));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void harusAngka() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Field hanya boleh berisi angka!");
        panel.showNotification();
    }

    public void menampilkanPengeluaran(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode pengeluaran");
        tbl.addColumn("Tanggal pengeluaran");
        tbl.addColumn("Total");
        tbl.addColumn("Keterangan");
        tabel_pengeluaran.setModel(tbl);
        try {
            com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from pengeluaran");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kd_pengeluaran"),
                    res.getString("tanggal_pengeluaran"),
                    res.getString("total"),
                    res.getString("keterangan")
                });
                tabel_pengeluaran.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void tanggl_pengel() {
        SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggal = new Date();
        tanggal_pengeluaranf.setText("" + sfDate.format(tanggal));
    }

    public void kd_pngl_otomatis() {
        try {
            String sql = "SELECT * from pengeluaran ORDER BY kd_pengeluaran DESC";
            Connection con = (Connection) connection.connect.configDB();
            com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                String Noplg = res.getString("kd_pengeluaran").substring(2);
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
                kode_pengeluaranf.setText("PK" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                kode_pengeluaranf.setText("PK0001");//sesuaikan dengan variable namenya
            }
            res.close();
        } catch (Exception e) {
            //penanganan masalah
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        if (keterangan_pengeluaranf.getText().isEmpty() && jumlah_uangpengeluaranf.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Anda belum memasukkan keterangan dan total pengeluaran!");
            panel.showNotification();
        } else if (keterangan_pengeluaranf.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Anda belum mengisi keterangan pengeluaran!");
            panel.showNotification();
        } else if (jumlah_uangpengeluaranf.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Anda belum mengisi total pengeluaran!");
            panel.showNotification();
        } else {
            String kd = kode_pengeluaranf.getText();
            int tutal = Integer.parseInt(jumlah_uangpengeluaranf.getText());
            String ket = keterangan_pengeluaranf.getText();
            try {
                String sql2 = "INSERT INTO pengeluaran VALUES('" + kd + "', '" + tanggal_pengeluaranf.getText() + "','" + tutal + "','" + ket + "')";
                Connection con = (Connection) connect.configDB();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql2);
                pst.execute();
                Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Berhasil ditambah!");
                panel.showNotification();
                menampilkanPengeluaran(tabel_pengeluaran);
                //jumlpgl();
                kd_pngl_otomatis();
                dispose();
                //total_pngl();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kode_pengeluaranfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kode_pengeluaranfMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_kode_pengeluaranfMouseClicked

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
            java.util.logging.Logger.getLogger(pengeluaran_tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengeluaran_tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengeluaran_tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengeluaran_tambah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengeluaran_tambah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private textfield.TextField jumlah_uangpengeluaranf;
    private com.k33ptoo.components.KButton kButton1;
    private textfield.TextField keterangan_pengeluaranf;
    private textfield.TextField kode_pengeluaranf;
    private textfield.TextField tanggal_pengeluaranf;
    private textfield.TextField textField3;
    // End of variables declaration//GEN-END:variables
}
