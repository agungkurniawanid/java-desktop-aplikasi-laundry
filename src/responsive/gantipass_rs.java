package responsive;

import alertGantiPassBerhasilOutput.Message;
import com.mysql.jdbc.PreparedStatement;
import static frame.gantipass.buatPassBaru;
import static frame.gantipass.confirmPassBaru;
import static frame.gantipass.labelUsernameGantiPass;
import java.awt.Color;
import javax.swing.JOptionPane;

public class gantipass_rs extends javax.swing.JFrame {

    public gantipass_rs() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        popup_bg_gantipass_rs.setVisible(false);
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
        jLabel9 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popup_bg_gantipass_rs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/popup bg dullscreen.png"))); // NOI18N
        popup_bg_gantipass_rs.setText("jLabel16");
        jPanel1.add(popup_bg_gantipass_rs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

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
        jLabel1.setText("Ganti Password Frame");
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

        jPanel3.setBackground(new java.awt.Color(255, 0, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Buat password baru anda!");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 220, -1, -1));

        buatPassBaru_res.setBackground(new java.awt.Color(237, 245, 244));
        buatPassBaru_res.setForeground(new java.awt.Color(153, 153, 153));
        buatPassBaru_res.setText("Buat Password Baru Anda!");
        buatPassBaru_res.setBorder(null);
        buatPassBaru_res.setMargin(new java.awt.Insets(6, 6, 6, 6));
        buatPassBaru_res.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buatPassBaru_resFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buatPassBaru_resFocusLost(evt);
            }
        });
        jPanel3.add(buatPassBaru_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, 220, 30));

        kButton1.setText("Konfirmasi Password");
        kButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(66, 95, 235));
        kButton1.setkEndColor(new java.awt.Color(66, 95, 235));
        kButton1.setkHoverEndColor(new java.awt.Color(45, 182, 186));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(45, 182, 186));
        kButton1.setkPressedColor(new java.awt.Color(66, 95, 235));
        kButton1.setkSelectedColor(new java.awt.Color(66, 95, 235));
        kButton1.setkStartColor(new java.awt.Color(66, 95, 235));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 430, 240, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setText("Kembali Ke Laman Sebelumnya?");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 510, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("Klik Disini!");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 510, 60, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Password Tidak Boleh Lebih");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, -1, 20));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Konfirmasi Password Salah");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Password Tidak Boleh Kurang");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, -1, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Dari 16 Karakter");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 390, -1, 20));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Dari 8 Karakter");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 390, -1, 20));

        labelUsernameGantiPass_res.setForeground(new java.awt.Color(255, 255, 255));
        labelUsernameGantiPass_res.setText("jLabel15");
        jPanel3.add(labelUsernameGantiPass_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Confirm Password Harus Terisi");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/left-arrow_1.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 30, 30));

        confirmPassBaru_res.setBackground(new java.awt.Color(237, 245, 244));
        confirmPassBaru_res.setForeground(new java.awt.Color(153, 153, 153));
        confirmPassBaru_res.setText("Confirm Password");
        confirmPassBaru_res.setBorder(null);
        confirmPassBaru_res.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmPassBaru_resFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmPassBaru_resFocusLost(evt);
            }
        });
        jPanel3.add(confirmPassBaru_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 330, 240, -1));

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg ganti pass fullscreen_1.png"))); // NOI18N
        jLabel4.setLabelFor(jLabel2);
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 730));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        us2.setForeground(new java.awt.Color(255, 255, 255));
        us2.setText("jTextField1");
        us2.setCaretColor(new java.awt.Color(255, 255, 255));
        us2.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        us2.setEnabled(false);
        us2.setFocusable(false);
        us2.setRequestFocusEnabled(false);
        us2.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(us2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

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
        new frame.gantipass().setVisible(true);
        dispose();
        String hero1 = buatPassBaru_res.getText();
        String hero2 = confirmPassBaru_res.getText();
        buatPassBaru.setText(hero1);
        confirmPassBaru.setText(hero2);
        buatPassBaru.setForeground(Color.black);
        confirmPassBaru.setForeground(Color.black);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        if (buatPassBaru_res.getText().length() < 8) {
            jLabel10.setVisible(false);
            jLabel11.setVisible(false);
            jLabel12.setVisible(true);
            jLabel13.setVisible(false);
            jLabel14.setVisible(true);
            jLabel15.setVisible(false);
        } else if (buatPassBaru_res.getText().equalsIgnoreCase("Buat Password Baru Anda!")
                && confirmPassBaru_res.getText().equalsIgnoreCase("Confirm Password!")) {
            popup_bg_gantipass_rs.setVisible(true);
            jLabel10.setVisible(false);
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            alertGantiPassKosongOutput.Message mes = new alertGantiPassKosongOutput.Message(this, true);
            mes.showAlert();
        } else if (buatPassBaru_res.getText().length() > 16) {
            jLabel10.setVisible(true);
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel13.setVisible(true);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
        } else if (buatPassBaru_res.getText().length() >= 8 && buatPassBaru_res.getText().length() <= 16) {
            if (confirmPassBaru_res.getText().equalsIgnoreCase("Confirm Password!")) {
                jLabel10.setVisible(false);
                jLabel11.setVisible(false);
                jLabel12.setVisible(false);
                jLabel13.setVisible(false);
                jLabel14.setVisible(false);
                jLabel15.setVisible(true);
            } else if (!confirmPassBaru_res.getText().equals(buatPassBaru_res.getText())) {
                jLabel10.setVisible(false);
                jLabel11.setVisible(true);
                jLabel12.setVisible(false);
                jLabel13.setVisible(false);
                jLabel14.setVisible(false);
                jLabel15.setVisible(false);
            } else {
                try {
                    String sql = "update user set password='" + confirmPassBaru_res.getText() + "'where username='" + us2.getText() + "'";
                    java.sql.Connection con = (java.sql.Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    popup_bg_gantipass_rs.setVisible(true);
                    alertGantiPassBerhasilOutput.Message mg = new Message(this, true);
                    mg.showAlert();
                    new responsive.login_rs().setVisible(true);
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void buatPassBaru_resFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buatPassBaru_resFocusGained
        // TODO add your handling code here:
        if (buatPassBaru_res.getText().equals("Buat Password Baru Anda!")) {
            buatPassBaru_res.setText("");
            buatPassBaru_res.setForeground(Color.black);
        }
    }//GEN-LAST:event_buatPassBaru_resFocusGained

    private void buatPassBaru_resFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buatPassBaru_resFocusLost
        // TODO add your handling code here:
        if (buatPassBaru_res.getText().equals("")) {
            buatPassBaru_res.setText("Buat Password Baru Anda!");
            buatPassBaru_res.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_buatPassBaru_resFocusLost

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        new login_rs().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        new responsive.lupapass_rs().setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void confirmPassBaru_resFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPassBaru_resFocusGained
        // TODO add your handling code here:
        if (confirmPassBaru_res.getText().equals("Confirm Password")) {
            confirmPassBaru_res.setText("");
            confirmPassBaru_res.setForeground(Color.black);
        }
    }//GEN-LAST:event_confirmPassBaru_resFocusGained

    private void confirmPassBaru_resFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPassBaru_resFocusLost
        // TODO add your handling code here:
        if (confirmPassBaru_res.getText().equals("")) {
            confirmPassBaru_res.setText("Confirm Password");
            confirmPassBaru_res.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_confirmPassBaru_resFocusLost

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
            java.util.logging.Logger.getLogger(gantipass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gantipass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gantipass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gantipass_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gantipass_rs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JTextField buatPassBaru_res = new javax.swing.JTextField();
    public static final javax.swing.JTextField confirmPassBaru_res = new javax.swing.JTextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.k33ptoo.components.KButton kButton1;
    public static final javax.swing.JLabel labelUsernameGantiPass_res = new javax.swing.JLabel();
    public static final javax.swing.JLabel popup_bg_gantipass_rs = new javax.swing.JLabel();
    public static final javax.swing.JTextField us2 = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
