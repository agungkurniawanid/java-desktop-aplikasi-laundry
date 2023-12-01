package formManipultionData;

import com.mysql.jdbc.PreparedStatement;
import connection.connect;
import static dashboard.dashboardAdmin.tabel_pengeluaran;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import notification.Notification;

public class pengeluaran_edit extends javax.swing.JFrame {

    public pengeluaran_edit() {
        initComponents();

        jumlahuang_pengeluaran_edit.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(jumlahuang_pengeluaran_edit.getText());
                } catch (NumberFormatException ex) {
                    if (jumlahuang_pengeluaran_edit.getText().isEmpty()) {
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
        jLabel2 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Edit Pengeluaran");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 120, 140, -1));

        kode_pengeluaran_edit.setEnabled(false);
        kode_pengeluaran_edit.setLabelText("Kode Pengeluaran");
        kode_pengeluaran_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kode_pengeluaran_editMouseClicked(evt);
            }
        });
        jPanel1.add(kode_pengeluaran_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 330, -1));

        keterangan_pengeluaran_edit.setLabelText("Keterangan pengeluaran");
        keterangan_pengeluaran_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keterangan_pengeluaran_editActionPerformed(evt);
            }
        });
        jPanel1.add(keterangan_pengeluaran_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 330, -1));

        jumlahuang_pengeluaran_edit.setLabelText("Jumlah uang pengeluaran");
        jPanel1.add(jumlahuang_pengeluaran_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 330, -1));

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
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 330, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formManipultionData/Desktop - 26.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 550));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void harusAngka() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Field hanya boleh berisi angka!");
        panel.showNotification();
    }
    private void keterangan_pengeluaran_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keterangan_pengeluaran_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keterangan_pengeluaran_editActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        if (kode_pengeluaran_edit.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Tanggal masih kosong!");
            panel.showNotification();
        } else if (keterangan_pengeluaran_edit.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Keterangan masih kosong!");
            panel.showNotification();
        } else if (jumlahuang_pengeluaran_edit.getText().isEmpty()) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Total pengeluaran masih kosong!");
            panel.showNotification();
        } else {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            int tutal = Integer.parseInt(jumlahuang_pengeluaran_edit.getText());
            String ket = keterangan_pengeluaran_edit.getText();
            try {
                String sql = "UPDATE pengeluaran SET total='" + tutal + "',keterangan ='" + ket + "'WHERE kd_pengeluaran='" + kode_pengeluaran_edit.getText() + "'";
                Connection con = (Connection) connection.connect.configDB();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Data berhasil diedit!");
                panel.showNotification();
                pst.execute();
                menampilkanPengeluaran(tabel_pengeluaran);
                dispose();
                //jumlpgl();
                //kd_pngl_otomatis();
                //total_pngl();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data GAGAL di EDIT" + e.getMessage());
            }
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kode_pengeluaran_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kode_pengeluaran_editMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_kode_pengeluaran_editMouseClicked

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
            java.util.logging.Logger.getLogger(pengeluaran_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengeluaran_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengeluaran_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengeluaran_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengeluaran_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static final textfield.TextField jumlahuang_pengeluaran_edit = new textfield.TextField();
    private com.k33ptoo.components.KButton kButton1;
    public static final textfield.TextField keterangan_pengeluaran_edit = new textfield.TextField();
    public static final textfield.TextField kode_pengeluaran_edit = new textfield.TextField();
    // End of variables declaration//GEN-END:variables
}
