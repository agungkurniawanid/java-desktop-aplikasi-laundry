package frame;

import alertGantiPassBerhasilOutput.Message;
import static alertGantiPassBerhasilOutput.Message.gantipassbtn;
import com.mysql.jdbc.PreparedStatement;
import static frame.login.username;
import java.awt.Color;
import javax.swing.JOptionPane;
import static responsive.gantipass_rs.buatPassBaru_res;
import static responsive.gantipass_rs.confirmPassBaru_res;

public class gantipass extends javax.swing.JFrame {

    public gantipass() {
        initComponents();
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        popup_bg_gantipass.setVisible(false);
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
        jLabel9 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popup_bg_gantipass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/popup bg.png"))); // NOI18N
        popup_bg_gantipass.setText("jLabel16");
        jPanel1.add(popup_bg_gantipass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 610));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Ganti Password Frame");
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

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel9.setText("Buat password baru anda!");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, -1));

        buatPassBaru.setBackground(new java.awt.Color(237, 245, 244));
        buatPassBaru.setForeground(new java.awt.Color(153, 153, 153));
        buatPassBaru.setText("Buat Password Baru Anda!");
        buatPassBaru.setBorder(null);
        buatPassBaru.setMargin(new java.awt.Insets(6, 6, 6, 6));
        buatPassBaru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buatPassBaruFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buatPassBaruFocusLost(evt);
            }
        });
        jPanel2.add(buatPassBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 230, 220, 20));

        confirmPassBaru.setBackground(new java.awt.Color(237, 245, 244));
        confirmPassBaru.setForeground(new java.awt.Color(153, 153, 153));
        confirmPassBaru.setText("Confirm Password!");
        confirmPassBaru.setBorder(null);
        confirmPassBaru.setMargin(new java.awt.Insets(2, 2, 2, 6));
        confirmPassBaru.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmPassBaruFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmPassBaruFocusLost(evt);
            }
        });
        confirmPassBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassBaruActionPerformed(evt);
            }
        });
        jPanel2.add(confirmPassBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 220, 30));

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
        jPanel2.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 370, 240, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setText("Kembali Ke Laman Sebelumnya?");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Klik Disini!");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 450, 60, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Password Tidak Boleh Lebih");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, -1, 20));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Konfirmasi Password Salah");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("Password Tidak Boleh Kurang");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, -1, -1));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Dari 16 Karakter");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 336, -1, 20));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("Dari 8 Karakter");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 336, -1, 20));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Confirm Password Harus Terisi");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 320, 190, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/left-arrow_1.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 40, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg ganti pass_1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 570));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        us1.setForeground(new java.awt.Color(255, 255, 255));
        us1.setText("jTextField1");
        us1.setBorder(null);
        us1.setCaretColor(new java.awt.Color(255, 255, 255));
        us1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        us1.setEnabled(false);
        us1.setRequestFocusEnabled(false);
        us1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(us1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        labelUsernameGantiPass.setBackground(new java.awt.Color(255, 255, 255));
        labelUsernameGantiPass.setText("jLabel15");
        jPanel1.add(labelUsernameGantiPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

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
        new responsive.gantipass_rs().setVisible(true);
        dispose();
        String hero1 = buatPassBaru.getText();
        String hero2 = confirmPassBaru.getText();
        buatPassBaru_res.setText(hero1);
        confirmPassBaru_res.setText(hero2);
        buatPassBaru_res.setForeground(Color.black);
        confirmPassBaru_res.setForeground(Color.black);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void confirmPassBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassBaruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassBaruActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void buatPassBaruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buatPassBaruFocusGained
        // TODO add your handling code here:
        if (buatPassBaru.getText().equals("Buat Password Baru Anda!")) {
            buatPassBaru.setText("");
            buatPassBaru.setForeground(Color.black);
        }
    }//GEN-LAST:event_buatPassBaruFocusGained

    private void buatPassBaruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buatPassBaruFocusLost
        // TODO add your handling code here:
        if (buatPassBaru.getText().equals("")) {
            buatPassBaru.setText("Buat Password Baru Anda!");
            buatPassBaru.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_buatPassBaruFocusLost

    private void confirmPassBaruFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPassBaruFocusLost
        // TODO add your handling code here:
        if (confirmPassBaru.getText().equals("")) {
            confirmPassBaru.setText("Confirm Password!");
            confirmPassBaru.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_confirmPassBaruFocusLost

    private void confirmPassBaruFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPassBaruFocusGained
        // TODO add your handling code here:
        if (confirmPassBaru.getText().equals("Confirm Password!")) {
            confirmPassBaru.setText("");
            confirmPassBaru.setForeground(Color.black);
        }
    }//GEN-LAST:event_confirmPassBaruFocusGained

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        if (buatPassBaru.getText().length() < 8) {
            jLabel10.setVisible(false);
            jLabel11.setVisible(false);
            jLabel12.setVisible(true);
            jLabel13.setVisible(false);
            jLabel14.setVisible(true);
            jLabel15.setVisible(false);
        } else if (buatPassBaru.getText().equalsIgnoreCase("Buat Password Baru Anda!") && confirmPassBaru.getText().equalsIgnoreCase("Confirm Password!")) {
            popup_bg_gantipass.setVisible(true);
            jLabel10.setVisible(false);
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            alertGantiPassKosongOutput.Message ms = new alertGantiPassKosongOutput.Message(this, true);
            ms.showAlert();
        } else if (buatPassBaru.getText().length() > 16) {
            jLabel10.setVisible(true);
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel13.setVisible(true);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
        } else if (buatPassBaru.getText().length() >= 8 && buatPassBaru.getText().length() <= 16) {
            if (confirmPassBaru.getText().equalsIgnoreCase("Confirm Password!")) {
                jLabel10.setVisible(false);
                jLabel11.setVisible(false);
                jLabel12.setVisible(false);
                jLabel13.setVisible(false);
                jLabel14.setVisible(false);
                jLabel15.setVisible(true);
            } else if (!confirmPassBaru.getText().equals(buatPassBaru.getText())) {
                jLabel10.setVisible(false);
                jLabel11.setVisible(true);
                jLabel12.setVisible(false);
                jLabel13.setVisible(false);
                jLabel14.setVisible(false);
                jLabel15.setVisible(false);
            } else {
                try {
                    String sql = "update user set password='" + confirmPassBaru.getText() + "'where username='" + us1.getText() + "'";
                    java.sql.Connection con = (java.sql.Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    popup_bg_gantipass.setVisible(true);
                    alertGantiPassBerhasilOutput.Message mg = new Message(this, true);
                    mg.showAlert();
                    new frame.login().setVisible(true);
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        new frame.lupapass().setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

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
            java.util.logging.Logger.getLogger(gantipass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gantipass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gantipass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gantipass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gantipass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JTextField buatPassBaru = new javax.swing.JTextField();
    public static final javax.swing.JTextField confirmPassBaru = new javax.swing.JTextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
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
    public static final javax.swing.JLabel labelUsernameGantiPass = new javax.swing.JLabel();
    public static final javax.swing.JLabel popup_bg_gantipass = new javax.swing.JLabel();
    public static final javax.swing.JTextField us1 = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
