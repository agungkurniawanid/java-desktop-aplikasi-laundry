package responsive;

import alertUsernameWrongLupaPassOutput.Message;
import com.mysql.jdbc.Connection;
import frame.gantipass;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static frame.gantipass.labelUsernameGantiPass;
import static frame.lupapass.lbro;
import static responsive.gantipass_rs.labelUsernameGantiPass_res;
import static responsive.gantipass_rs.us2;

public class lupapass_rs extends javax.swing.JFrame {
    public lupapass_rs() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        popupbg_lupapass_rs.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popupbg_lupapass_rs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/popup bg dullscreen.png"))); // NOI18N
        jPanel1.add(popupbg_lupapass_rs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Laundry App");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, -1, 28));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close (1)_1.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 20, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximize.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, -1, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLupaPass_res.setBackground(new java.awt.Color(237, 245, 244));
        usernameLupaPass_res.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        usernameLupaPass_res.setForeground(new java.awt.Color(102, 102, 102));
        usernameLupaPass_res.setText("Masukkan Username Anda!");
        usernameLupaPass_res.setBorder(null);
        usernameLupaPass_res.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameLupaPass_resFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameLupaPass_resFocusLost(evt);
            }
        });
        usernameLupaPass_res.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameLupaPass_resActionPerformed(evt);
            }
        });
        jPanel3.add(usernameLupaPass_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 240, 20));

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
        jPanel3.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, 290, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/left-arrow_1.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 44, -1, 30));

        jLabel7.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel7.setText("Lupa Password?");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel10.setText("Untuk melakukan pergantian password,");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel9.setText("masukkan username anda lalu tekan tombol lanjut.");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg lupa pasword fullscreen_1.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 730));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new frame.lupapass().setVisible(true); dispose();
        String hero = usernameLupaPass_res.getText();
        lbro.setText(hero);
        lbro.setForeground(Color.black);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void usernameLupaPass_resFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameLupaPass_resFocusGained
        // TODO add your handling code here:
        if (usernameLupaPass_res.getText().equals("Masukkan Username Anda!")) {
            usernameLupaPass_res.setText("");
            usernameLupaPass_res.setForeground(Color.black);
        }
    }//GEN-LAST:event_usernameLupaPass_resFocusGained

    private void usernameLupaPass_resFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameLupaPass_resFocusLost
        // TODO add your handling code here:
        if (usernameLupaPass_res.getText().equals("")) {
            usernameLupaPass_res.setText("Masukkan Username Anda!");
            usernameLupaPass_res.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_usernameLupaPass_resFocusLost

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
         try {
            String sql = "SELECT * FROM user WHERE username = '" + usernameLupaPass_res.getText() + "'"; //+  HakAkses.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                if (usernameLupaPass_res.getText().equals(rs.getString("username"))) {
                    new gantipass_rs().setVisible(true);
                    dispose();
                    String nama;
                    nama = usernameLupaPass_res.getText();
                    us2.setText(nama);
                }
            } else {
                popupbg_lupapass_rs.setVisible(true);
                alertUsernameWrongLupaPassOutput.Message mess = new Message(this, true);
                mess.showAlert();
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new responsive.login_rs().setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void usernameLupaPass_resActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameLupaPass_resActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM user WHERE id_user = '" + usernameLupaPass_res.getText() + "'"; //+  HakAkses.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                if (usernameLupaPass_res.getText().equals(rs.getString("id_user"))) {
                    new gantipass().setVisible(true);
                    dispose();
                    String nama;
                    nama = lbro.getText();
                    us2.setText(nama);
                }
            } else {
                popupbg_lupapass_rs.setVisible(true);
                alertUsernameWrongLupaPassOutput.Message ms = new Message(this, true);
                ms.showAlert();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_usernameLupaPass_resActionPerformed

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
            java.util.logging.Logger.getLogger(lupapass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lupapass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lupapass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lupapass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lupapass_rs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.k33ptoo.components.KButton kButton1;
    public static final javax.swing.JLabel popupbg_lupapass_rs = new javax.swing.JLabel();
    public static final javax.swing.JTextField usernameLupaPass_res = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
