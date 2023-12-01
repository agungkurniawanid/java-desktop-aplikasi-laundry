package formManipultionData;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import static dashboard.dashboardAdmin.tabel_paket;
import static formManipultionData.tambahPaket.harga;
import static formManipultionData.tambahPaket.kd_paket;
import static formManipultionData.tambahPaket.nama_paket;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import notification.Notification;

public class editPaket extends javax.swing.JFrame {

    public editPaket() {
        initComponents();
        menampilkanDataPaket();
        buatkodpaket();

        harga_edit.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(harga_edit.getText());
                } catch (NumberFormatException ex) {
                    if (harga_edit.getText().isEmpty()) {
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
        jLabel3.setText("Edit Data Paket");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        kd_paket_edit.setEnabled(false);
        kd_paket_edit.setLabelText("Kode Paket");
        kd_paket_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kd_paket_editMouseClicked(evt);
            }
        });
        jPanel1.add(kd_paket_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 310, -1));

        nama_paket_edit.setLabelText("Nama Paket");
        jPanel1.add(nama_paket_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 310, -1));

        jComboBox1_edit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kiloan", "Satuan" }));
        jComboBox1_edit.setSelectedIndex(-1);
        jComboBox1_edit.setLabeText("Combo Custom");
        jPanel1.add(jComboBox1_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 310, -1));

        harga_edit.setLabelText("Harga Paket");
        harga_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_editActionPerformed(evt);
            }
        });
        jPanel1.add(harga_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, -1));

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
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 310, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Desktop - 15 (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 580));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void harusAngka() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Field hanya boleh berisi angka!");
        panel.showNotification();
    }

    private void harga_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_editActionPerformed

    public void menampilkanDataPaket() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("kode paket");
        tbl.addColumn("NAMA paket");
        tbl.addColumn("jenis paket");
        tbl.addColumn("harga");
        tabel_paket.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();

//           Statement statement=(Statement)coneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from paket");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kd_paket"),
                    res.getString("nama_paket"),
                    res.getString("jenis_paket"),
                    res.getString("harga"),});
                tabel_paket.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    void resetPaket() {
        nama_paket_edit.setText("");
        harga_edit.setText("0");
    }

    public void buatkodpaket() {
        try {

            String sql = "SELECT * from paket ORDER BY kd_paket DESC";
            Connection con = (Connection) connection.connect.configDB();
            Statement st = (Statement) con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                String Noplg = res.getString("kd_paket").substring(2);
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
                kd_paket.setText("PK" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                kd_paket.setText("PK0001");//sesuaikan dengan variable namenya
            }
            res.close();
//            con.close();
        } catch (Exception e) {
            //penanganan masalah
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }
    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String kd = kd_paket_edit.getText();
            String Nama = nama_paket_edit.getText();
            String kdj = (String) jComboBox1_edit.getSelectedItem();
            String sql = "UPDATE paket SET kd_paket='" + kd + "',nama_paket='" + Nama + "',jenis_paket='" + kdj +
                    "',harga='" + Integer.parseInt(harga_edit.getText()) + "' WHERE kd_paket='" + kd + "'";
            Connection con = (Connection) connection.connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            Notification panel = new Notification(this, Notification.Type.SUCCESS,
                    Notification.Location.TOP_CENTER, "Berhasil di edit!");
            panel.showNotification();
            pst.execute();
            menampilkanDataPaket();
            resetPaket();
            buatkodpaket();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data GAGAL di EDIT" + e.getMessage());
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kd_paket_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kd_paket_editMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_kd_paket_editMouseClicked

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
            java.util.logging.Logger.getLogger(editPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editPaket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final textfield.TextField harga_edit = new textfield.TextField();
    public static final combobox.Combobox jComboBox1_edit = new combobox.Combobox();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.k33ptoo.components.KButton kButton1;
    public static final textfield.TextField kd_paket_edit = new textfield.TextField();
    public static final textfield.TextField nama_paket_edit = new textfield.TextField();
    // End of variables declaration//GEN-END:variables
}
