package frame;

import alertUsernameWrongLupaPassOutput.Message;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import javax.swing.JOptionPane;
import static frame.gantipass.labelUsernameGantiPass;
import static frame.gantipass.us1;
import static responsive.lupapass_rs.usernameLupaPass_res;

public class lupapass extends javax.swing.JFrame {
    public lupapass() {
        initComponents();
        popup_bg_lupapass.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popup_bg_lupapass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/popup bg.png"))); // NOI18N
        popup_bg_lupapass.setText("jLabel11");
        jPanel1.add(popup_bg_lupapass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 610));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Laundry App");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, -1, 28));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close (1)_1.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1174, 0, 20, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximize.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, -1, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, -1, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setText("Lupa Password?");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel9.setText("masukkan username anda lalu tekan tombol lanjut.");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        lbro.setBackground(new java.awt.Color(237, 245, 244));
        lbro.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lbro.setForeground(new java.awt.Color(102, 102, 102));
        lbro.setText("Masukkan Username Anda!");
        lbro.setBorder(null);
        lbro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbroFocusLost(evt);
            }
        });
        lbro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbroActionPerformed(evt);
            }
        });
        jPanel2.add(lbro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 270, 20));

        kButton1.setText("Lanjut Ganti Password");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(66, 95, 235));
        kButton1.setkBorderRadius(35);
        kButton1.setkEndColor(new java.awt.Color(66, 95, 235));
        kButton1.setkHoverEndColor(new java.awt.Color(111, 207, 151));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(111, 207, 151));
        kButton1.setkPressedColor(new java.awt.Color(66, 95, 235));
        kButton1.setkSelectedColor(new java.awt.Color(66, 95, 235));
        kButton1.setkStartColor(new java.awt.Color(66, 95, 235));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 300, 40));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel10.setText("Untuk melakukan pergantian password,");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/left-arrow_1.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg lupa password (3).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 570));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        new responsive.lupapass_rs().setVisible(true);
        dispose();
        String hero = lbro.getText();
        usernameLupaPass_res.setText(hero);
        usernameLupaPass_res.setForeground(Color.black);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM user WHERE username = '" + lbro.getText() + "'"; //+  HakAkses.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                if (lbro.getText().equals(rs.getString("username"))) {
                    new gantipass().setVisible(true);
                    dispose();
                    String nama;
                    nama = lbro.getText();
                    us1.setText(nama);
                }
            } else {
                popup_bg_lupapass.setVisible(true);
                alertUsernameWrongLupaPassOutput.Message ms = new Message(this, true);
                ms.showAlert();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void lbroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbroFocusLost
        // TODO add your handling code here:
        if (lbro.getText().equals("")) {
            lbro.setText("Masukkan Username Anda!");
            lbro.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_lbroFocusLost

    private void lbroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbroFocusGained
        // TODO add your handling code here:
        if (lbro.getText().equals("Masukkan Username Anda!")) {
            lbro.setText("");
            lbro.setForeground(Color.black);
        }
    }//GEN-LAST:event_lbroFocusGained

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new frame.login().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lbroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbroActionPerformed
        // TODO add your handling code here:
           try {
            String sql = "SELECT * FROM user WHERE id_user = '" + lbro.getText() + "'"; //+  HakAkses.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                if (lbro.getText().equals(rs.getString("id_user"))) {
                    new gantipass().setVisible(true);
                    dispose();
                    String nama;
                    nama = lbro.getText();
                    us1.setText(nama);
                }
            } else {
                popup_bg_lupapass.setVisible(true);
                alertUsernameWrongLupaPassOutput.Message ms = new Message(this, true);
                ms.showAlert();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lbroActionPerformed

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
            java.util.logging.Logger.getLogger(lupapass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lupapass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lupapass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lupapass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lupapass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private com.k33ptoo.components.KButton kButton1;
    public static final javax.swing.JTextField lbro = new javax.swing.JTextField();
    public static final javax.swing.JLabel popup_bg_lupapass = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
