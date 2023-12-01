package frame;

import alertLoginFail5xOutput.Message;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static responsive.login_rs.password_res;
import static responsive.login_rs.username_res;
import static alertUsernameIsNullOutput.Message.username_alert;
import dashboard.dashboardAdmin;
import static dashboard.dashboardAdmin.namaLoginAdmin;
import static dashboard.dashboardAdmin.namaLoginAdminField;
import static dashboard.dashboardKasir.namaLoginKasir;
import static dashboard.dashboardKasir.profileKS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.DocumentEvent;
import notification.Notification;
import raven.glasspanepopup.GlassPanePopup;
import responsive.login_rs;
import static responsive.login_rs.password_res;
import static responsive.login_rs.popup_bg_rs;
import static responsive.login_rs.username_res;
import session.session;

public class login extends javax.swing.JFrame {

    public String user;
    int limitLogin;
    String idkaryawan;
    int use_salah;
    int pass_slh;

    public login() {

        initComponents();
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);
        popup_bg.setVisible(false);

        GlassPanePopup.install(this);
        getContentPane().setBackground(Color.WHITE);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popup_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/popup bg.png"))); // NOI18N
        jPanel1.add(popup_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 610));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
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

        jPanel3.setBackground(new java.awt.Color(255, 51, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("Lakukan LogIn untuk mengakses");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel9.setText("Dashboard!");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("atau");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, -1, -1));

        kButton1.setBackground(new java.awt.Color(66, 95, 235));
        kButton1.setText("Kembali Laman Sebelumya!");
        kButton1.setBorderPainted(false);
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
        jPanel3.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/henny-logo-transformed.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 190, 80));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setText("LogIn");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 50, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 230, -1, -1));

        username.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        username.setForeground(new java.awt.Color(153, 153, 153));
        username.setText("Masukkan Username !");
        username.setBorder(null);
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameKeyReleased(evt);
            }
        });
        jPanel3.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 200, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/padlock.png"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(796, 286, 20, 20));

        kButton2.setText("LogIn");
        kButton2.setBorderPainted(false);
        kButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(66, 95, 235));
        kButton2.setkEndColor(new java.awt.Color(66, 95, 235));
        kButton2.setkHoverEndColor(new java.awt.Color(45, 182, 186));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(45, 182, 186));
        kButton2.setkPressedColor(new java.awt.Color(66, 95, 235));
        kButton2.setkSelectedColor(new java.awt.Color(66, 95, 235));
        kButton2.setkStartColor(new java.awt.Color(66, 95, 235));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, 250, 30));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setText("Lupa Password?");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, -1, -1));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(66, 95, 235));
        jLabel14.setText("Klik disini!");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/henny-logo-transformed.png"))); // NOI18N
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 190, 80));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Harap Centang \"Lanjut LogIn ini\".");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 190, -1));

        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setText("Masukkan Password !");
        password.setBorder(null);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 282, 200, 30));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Username atau Password salah !");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 190, -1));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Klik Disini !");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 446, -1, -1));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Username Tidak Boleh Kosong");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 190, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg login.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 570));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

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
        responsive.login_rs wl = new responsive.login_rs();
        wl.setVisible(true);
        this.dispose();
        String hero1, hero2;
        hero1 = username.getText();
        hero2 = password.getText();
        username_res.setText(hero1);
        password_res.setText(hero2);
        username_res.setForeground(Color.black);
        password_res.setForeground(Color.black);

    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        welcome wl = new welcome();
        wl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        String usernamee = username.getText();
        try {
            String sql = "SELECT * FROM user WHERE username = '" + usernamee
                    + "' AND password='" + password.getText() + "'"; //+  HakAkses.getSelectedItem()+"'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                if (rs.getString("akses").equals("admin")) {
                    popup_bg.setVisible(true);
                    alertLoginSuccessOutput.Message mms = new alertLoginSuccessOutput.Message(this, true);
                    mms.showAlert();
                    session.setId_kasir(rs.getString("id_user"));
                    session.setUsername(rs.getString("username"));
                    new dashboard.dashboardAdmin().setVisible(true);
                    namaLoginAdmin.setText(rs.getString(2));
                    namaLoginAdminField.setText(rs.getString(2));
                    this.dispose();
                } else if (rs.getString("akses").equals("kasir")) {
                    popup_bg.setVisible(true);
                    alertLoginSuccessOutput.Message mms = new alertLoginSuccessOutput.Message(this, true);
                    mms.showAlert();
                    session.setId_kasir(rs.getString("id_user"));
                    session.setUsername(rs.getString("username"));
                    new dashboard.dashboardKasir().setVisible(true);
                    namaLoginKasir.setText(rs.getString(2));
                    profileKS.setText(rs.getString(2));
                    this.dispose();
                } else if (rs.getString("akses").equals("admin")
                        || rs.getString("akses").equals("kasir")) {
                    jLabel15.setVisible(true);
                    jLabel16.setVisible(false);
                }
            } else {
                jLabel16.setVisible(true);
                jLabel15.setVisible(false);
            }
            if (username.getText().equals("Masukkan Username !") && password.getText().equals("Masukkan Password !")) {
                popup_bg.setVisible(true);
                jLabel16.setVisible(false);
                alertUsernamePasswordNullOutput.Message mes = new alertUsernamePasswordNullOutput.Message(this, true);
                mes.showAlert();
            } else if (username.getText().equals("Masukkan Username !")) {
                jLabel16.setVisible(false);
                popup_bg.setVisible(true);
                alertUsernameIsNullOutput.Message ms = new alertUsernameIsNullOutput.Message(this, true);
                ms.showAlert();
            } else if (password.getText().equals("Masukkan Password !")) {
                jLabel16.setVisible(false);
                popup_bg.setVisible(true);
                alertPasswordIsNullOutput.Message ms = new alertPasswordIsNullOutput.Message(this, true);
                ms.showAlert();
            }
            limitLogin += 1;
            if (limitLogin == 5) {
                popup_bg.setVisible(true);
                alertLoginFail5xOutput.Message me = new Message(this, true);
                me.showAlert();
                jLabel14.setVisible(false);
                jLabel18.setVisible(true);
                limitLogin -= 5;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
//        try {
//            String sql = "SELECT * FROM user";
//            java.sql.Connection con = (com.mysql.jdbc.Connection) connection.connect.configDB();
//            java.sql.PreparedStatement pst = con.prepareStatement(sql);// manipulasi database yang menggunakan query – query dinamis
//            java.sql.ResultSet rs = pst.executeQuery(sql);//menampung hasil eksekusi dari database
//            if (rs.next()) {
//                if (rs.getString("username").equals(username.getText())) {
//                    if (rs.getString("password").equals(password.getText())) {
//                        if (rs.getString("akses") == "kasir") {
//                            session.setId_kasir(rs.getString("id_user"));
//                            popup_bg_rs.setVisible(true);
//                            alertLoginSuccessOutput.Message mms = new alertLoginSuccessOutput.Message(this, true);
//                            mms.showAlert();
//                            dispose();
//                            new dashboard.dashboardKasir().setVisible(true);
//                        } else {
//                            popup_bg_rs.setVisible(true);
//                            alertLoginSuccessOutput.Message mms = new alertLoginSuccessOutput.Message(this, true);
//                            mms.showAlert();
//                            dispose();
//                            new dashboard.dashboardAdmin().setVisible(true);
//                        }
//                    } else {
//                        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Maaf password salah!");
//                        panel.showNotification();
//                        pass_slh++;
//                        if (pass_slh == 5) {
//                            popup_bg_rs.setVisible(true);
//                            alertLoginFail5xOutput.Message me = new Message(this, true);
//                            me.showAlert();
//                            jLabel18.setVisible(true);
//                            jLabel14.setVisible(false);
//                            pass_slh -= 5;
//                            //dispose();
//                        }
//                    }
//                } else {
//                    Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Maaf username salah!");
//                    panel.showNotification();
//                    use_salah++;
//                    if (use_salah == 5) {
//                        sample.message.Message obj = new sample.message.Message();
//                        obj.txt.setText("Anda salah telah salah memasukkan username sebanyak 5 kali! silahkan login menggunakan RFID!, kolom password akan dinonaktifkan jika anda menekan ok, tekan centang aktifkan kolom password untuk kembali login manual!");
//                        obj.eventOK(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent ae) {
//                                password.setEnabled(false);
//                                jCheckBox1.setEnabled(true);
//                                username.setText("");
//                                GlassPanePopup.closePopupLast();
//                            }
//                        });
//                        GlassPanePopup.showPopup(obj);
//                        use_salah -= 5;
//                    }
//
//                }
//            }
//            if (username.getText().equals("Masukkan Username !") && password.getText().equals("Masukkan Password !")) {
//                jLabel16.setVisible(false);
//                popup_bg_rs.setVisible(true);
//                alertUsernamePasswordNullOutput.Message ms = new alertUsernamePasswordNullOutput.Message(this, true);
//                ms.showAlert();
//            } else if (username.getText().equals("Masukkan Username !")) {
//                jLabel16.setVisible(false);
//                popup_bg_rs.setVisible(true);
//                alertUsernameIsNullOutput.Message mes = new alertUsernameIsNullOutput.Message(this, true);
//                mes.showAlert();
//            } else if (password.getText().equals("Masukkan Password !")) {
//                jLabel16.setVisible(false);
//                popup_bg_rs.setVisible(true);
//                alertPasswordIsNullOutput.Message meg = new alertPasswordIsNullOutput.Message(this, true);
//                meg.showAlert();
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        new frame.lupapass().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        // TODO add your handling code here:
        if (username.getText().equals("Masukkan Username !")) {
            username.setText("");
            username.setForeground(Color.black);
        }
    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // TODO add your handling code here:
        if (username.getText().equals("")) {
            username.setText("Masukkan Username !");
            username.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_usernameFocusLost

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        if (password.getText().equals("Masukkan Password !")) {
            password.setText("");
            password.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().equals("")) {
            password.setText("Masukkan Password !");
            password.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_passwordFocusLost

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        new responsive.lupapass_rs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyReleased
        // TODO add your handling code here
    }//GEN-LAST:event_usernameKeyReleased

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
        try {
            String sql1 = "SELECT * FROM user where id_user='" + username.getText() + "'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql1);
            java.sql.ResultSet rs = pst.executeQuery(sql1);
            if (rs.next()) {
                if (rs.getString("id_user").equals(username.getText()) == (rs.getString("akses").equals("admin"))) {
                    session.setUsername(rs.getString("username"));
                    session.setId_kasir(rs.getString("id_user"));
                    popup_bg.setVisible(true);
                    alertLoginSuccessOutput.Message mms = new alertLoginSuccessOutput.Message(this, true);
                    mms.showAlert();
                    new dashboard.dashboardAdmin().setVisible(true);
                    this.dispose();
                }
                if (rs.getString("id_user").equals(username.getText()) == (rs.getString("akses").equals("kasir"))) {
                    session.setUsername(rs.getString("username"));
                    session.setId_kasir(rs.getString("id_user"));
                    popup_bg.setVisible(true);
                    alertLoginSuccessOutput.Message mms = new alertLoginSuccessOutput.Message(this, true);
                    mms.showAlert();
                    new dashboard.dashboardKasir().setVisible(true);
                    this.dispose();
                }
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Data tidak valid!");
                panel.showNotification();
                username.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_usernameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    public static final javax.swing.JPasswordField password = new javax.swing.JPasswordField();
    public static final javax.swing.JLabel popup_bg = new javax.swing.JLabel();
    public static final javax.swing.JTextField username = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
