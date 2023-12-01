package dashboard;

import com.mysql.jdbc.Statement;
import static dashboard.dashboardKasir.jLabel10;
import static dashboard.dashboardKasir.tabel_data_pelanggan_2;
import static dashboard.dashboardKasir.table_data_pelanggan_kasir;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class selengkapnyaPelangganCardKasir extends javax.swing.JFrame {

    public selengkapnyaPelangganCardKasir() {
        initComponents();
        jumlahPelangganBaru();
        menampilkan_data_pelanggan(tabel_data_pelanggan_2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(389, 229));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Jumlah Semua Pelanggan");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Pelanggan");

        pl.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        pl.setForeground(new java.awt.Color(0, 153, 255));
        pl.setText("100");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel4.setText("Jumlah Pelanggan Baru Hari Ini");

        pl1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        pl1.setForeground(new java.awt.Color(0, 153, 255));
        pl1.setText("100");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Pelanggan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pl)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2))))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pl1)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl1)
                    .addComponent(jLabel6))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 public void jumlahPelangganBaru() {
        try {
            String sql = "select count(*) as total_pelanggan_ini from pelanggan where tanggal_ditambahkan = curdate()";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            int totalHariIni = rs.getInt("total_pelanggan_ini");
            pl1.setText("" + totalHariIni);
        } catch (Exception e) {
            pl1.setText("" + 0);
        }
    }

    public void menampilkan_data_pelanggan(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID");
        tbl.addColumn("Nama");
        tbl.addColumn("Alamat");
        tbl.addColumn("Nomor");
        tabel_data_pelanggan_2.setModel(tbl);
        table_data_pelanggan_kasir.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from pelanggan");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_pelanggan"),
                    res.getString("nama_pelanggan"),
                    res.getString("alamat"),
                    res.getString("no_telp"),});
                tabel_data_pelanggan_2.setModel(tbl);
                table_data_pelanggan_kasir.setModel(tbl);
            }
            int a = table_data_pelanggan_kasir.getRowCount();
            jLabel10.setText("" + a);
            pl.setText("" + a);
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
            java.util.logging.Logger.getLogger(selengkapnyaPelangganCardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selengkapnyaPelangganCardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selengkapnyaPelangganCardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selengkapnyaPelangganCardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selengkapnyaPelangganCardKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public static final javax.swing.JLabel pl = new javax.swing.JLabel();
    public static final javax.swing.JLabel pl1 = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
