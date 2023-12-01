package codingDesainPembukuan;

import com.mysql.jdbc.PreparedStatement;
import connection.connect;
import dashboard.dashboardAdmin;
import static dashboard.dashboardAdmin.filterPembukuanj;
import static dashboard.dashboardAdmin.total_pngln;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static dashboard.dashboardAdmin.laba;
import static dashboard.dashboardAdmin.total_pmsk;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import notification.Notification;
import raven.glasspanepopup.GlassPanePopup;
import sample.message.Message;

public class fungsiPembukuan {

    void notif() {
        Message obj = new Message();
        obj.txt.setText("Data bulan ini masih kosong!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    public void pembukuanJan() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "01";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanFeb() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "02";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanMar() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "03";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanApr() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "04";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanMei() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "05";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanJun() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "06";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanJuli() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "07";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanAgu() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "08";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanSept() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "09";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanOkt() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "10";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanNov() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "11";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }

    public void pembukuanDes() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        monthh = "12";
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            String sts = "sudah di ambil";
            String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                    + "where status_ambil='" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            rs1.next();
            String total = (rs1.getString("total_pemasukan"));
            total_pmsk.setText(total);
            dashboardAdmin db = new dashboardAdmin();
            db.labarg();
        } catch (Exception e) {
            notif();
            total_pngln.setText("" + 0);
            total_pmsk.setText("" + 0);
        }
    }
}
