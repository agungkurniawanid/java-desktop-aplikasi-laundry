package allCode;

import static frame.login.password;
import static frame.login.username;
import static groovy.ui.text.FindReplaceUtility.dispose;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static responsive.login_rs.password_res;
import static responsive.login_rs.username_res;

public class coding_login {

    // CODING UNTUK LOGIN FRAME BESAR
    public static void login_responsive() {
        
    }

    // CODING UNTUK LOGIN FRAME KECIL
    public static void login_frame() {
        int use_salah = 0;
        int pass_slh = 0;
        try {
            String sql = "SELECT * FROM user";
            java.sql.Connection con = (Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = con.prepareStatement(sql);// manipulasi database yang menggunakan query – query dinamis
            java.sql.ResultSet rs = pst.executeQuery(sql);//menampung hasil eksekusi dari database
            if (rs.next()) {
                if (rs.getString("username").equals(username.getText())) {
                    if (rs.getString("password").equals(password.getText())) {
                        if (rs.getString("akses") == "kasir") {
                            session.session.setId_kasir(rs.getString("id_user"));
                            JOptionPane.showMessageDialog(null, "berhasil login");
                            dispose();
                            new dashboard.dashboardKasir().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "berhasil login");
                            dispose();
                            new dashboard.dashboardAdmin().setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "maaf password salah");
                        pass_slh++;
                        if (pass_slh == 5) {
                            JOptionPane.showMessageDialog(null, "password salah lima kali harap ke menu lupa password");
                            dispose();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "maaf username tidak tersedia");
                    use_salah++;
                    if (use_salah >= 5) {
                        int milih = JOptionPane.showConfirmDialog(null, "Anda telah melakuka kesalahan username sebanyak" + use_salah + "apakah anda ingin login dengan ktp(rfid) " + JOptionPane.YES_NO_OPTION);
                        if (milih == JOptionPane.YES_OPTION) {
                            dispose();
                            JOptionPane.showMessageDialog(null, "anda login dengan nik");
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
