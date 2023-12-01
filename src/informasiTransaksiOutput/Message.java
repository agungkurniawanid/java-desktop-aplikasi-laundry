package informasiTransaksiOutput;

import com.mysql.jdbc.PreparedStatement;
import informasiTransaksi.SweetAlert;
import static frame.lupapass.popup_bg_lupapass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import static responsive.lupapass_rs.popupbg_lupapass_rs;

public class Message extends SweetAlert {

    public Message(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        informasiTransaksiPerHariMenuDashboardUtama();
        informasiTransaksiPerMingguMenuDashboardUtama();
        informasiTransaksiPerbulanDashboardUtama();
    }

    public void informasiTransaksiPerHariMenuDashboardUtama() {
        SimpleDateFormat hari = new SimpleDateFormat("yyyy-MM-dd");
        String status = "sudah di ambil";
        Date hariIni = new Date();
        String formatHari = hari.format(hariIni);
        try {
            String sql = "select sum(grand_total) as total_hari_ini, day(tgl_selesai) as har from tbl_order where status_ambil ='" + status + "'group by har having har='" + formatHari + "'";
            Connection con = (Connection) connection.connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String tot = (rs.getString("total_hari_ini"));
            totalTransaksiHariIni.setText(tot);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "" + e.getMessage());
            totalTransaksiHariIni.setText("" + 0);
        }
    }

    public void informasiTransaksiPerMingguMenuDashboardUtama() {
        // mengambil tanggal minggu ini
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = sdf.format(cal.getTime()); // tanggal awal minggu
        cal.add(Calendar.DATE, 6);
        String endDate = sdf.format(cal.getTime()); //tanggal akhir minggu
        String sts = "sudah di ambil";
        // koneksi ke database
        try {
            String sql = "SELECT YEARWEEK(tgl_selesai) AS minggu, SUM(grand_total) AS total_transaksi\n"
                    + "FROM tbl_order\n"
                    + "WHERE tgl_pesan BETWEEN DATE(NOW()) AND DATE_ADD(DATE(NOW()), INTERVAL 1 WEEK) GROUP BY YEARWEEK(tgl_selesai)";
            Connection con = (Connection) connection.connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String tot = (rs.getString("total_transaksi"));
            jumlahTransaksiMinggu.setText(tot);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "" + e.getMessage());
            jumlahTransaksiMinggu.setText("" + 0);
        }
    }

    public void informasiTransaksiPerbulanDashboardUtama() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        try {
            String sql = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connection.connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String total = (rs.getString("total_pemasukan"));
            perbulan.setText(total);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "" + e.getMessage());
            perbulan.setText("" + 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jumlahTransaksiMinggu = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        perbulan = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel14.setText("jLabel14");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INFORMASI TRANSAKSI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 290, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Informasi Transaksi yang dilakukan bulan saat ini, di informasi terdapat mulai hari, minggu dan bulan.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 570, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Total Transaksi Bulan Ini");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 190, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setText("Pemasukan Transaksi pada");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 310, 180, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setText("saat hari ini.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 316, 140, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setText("Rp.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 30, 30));

        totalTransaksiHariIni.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        totalTransaksiHariIni.setText("30000000");
        jPanel1.add(totalTransaksiHariIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 120, 30));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Total Transaksi Hari Ini");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 290, 190, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setText("Pemasukan Transaksi pada");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 190, -1));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel11.setText("Minggu ini.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 110, 30));

        jumlahTransaksiMinggu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jumlahTransaksiMinggu.setText("15000000");
        jPanel1.add(jumlahTransaksiMinggu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 120, 30));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setText("Rp.");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 30, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close (1)_1.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setText("Total Transaksi Minggu Ini");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 190, -1));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel17.setText("Pemasukan Transaksi pada");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 190, -1));

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel18.setText("Bulan ini.");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 110, 30));

        perbulan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        perbulan.setText("15000000");
        jPanel1.add(perbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 120, 30));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setText("Rp.");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/MacBook Air - 1informasittransaksi.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        this.closeAlert();
    }//GEN-LAST:event_jLabel15MouseClicked

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
            java.util.logging.Logger.getLogger(Message.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Message.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Message.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Message.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Message dialog = new Message(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jumlahTransaksiMinggu;
    private javax.swing.JLabel perbulan;
    public static final javax.swing.JLabel totalTransaksiHariIni = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
