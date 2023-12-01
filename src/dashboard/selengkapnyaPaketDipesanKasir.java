package dashboard;

import static dashboard.dashboardKasir.jumlahPaketDipesan;

public class selengkapnyaPaketDipesanKasir extends javax.swing.JFrame {

    public selengkapnyaPaketDipesanKasir() {
        initComponents();
        ngitung_jmkl_odrpkt_hrian();
        ngitung_jmkl_odrpkt_satuan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Qty");

        paketSatuan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        paketSatuan.setForeground(new java.awt.Color(0, 153, 255));
        paketSatuan.setText("100");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel4.setText("Paket Satuan Hari Ini");

        paketKiloan.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        paketKiloan.setForeground(new java.awt.Color(0, 153, 255));
        paketKiloan.setText("100");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Qty");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Paket Kiloan Hari Ini");

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
                                .addComponent(paketKiloan)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2))))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(paketSatuan)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel6)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paketKiloan)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paketSatuan)
                    .addComponent(jLabel6))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 public void ngitung_jmkl_odrpkt_hrian() {
        try {
            String sql = "SELECT SUM(qty) as total_paket_ini from tbl_detail_order JOIN tbl_order on tbl_order.kode_order = tbl_detail_order.kode_order join paket on tbl_detail_order.kd_paket = paket.kd_paket where tbl_order.tgl_pesan = current_date() && paket.jenis_paket = 'kiloan'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            int totalHariIni = rs.getInt("total_paket_ini");
            jumlahPaketDipesan.setText("" + totalHariIni);
            paketKiloan.setText("" + totalHariIni);
        } catch (Exception e) {
            jumlahPaketDipesan.setText("" + 0);
            paketKiloan.setText("" + 0);
        }
    }

    public void ngitung_jmkl_odrpkt_satuan() {
        try {
            String sql = "SELECT SUM(qty) as total_paket_ini from tbl_detail_order JOIN tbl_order on tbl_order.kode_order = tbl_detail_order.kode_order join paket on tbl_detail_order.kd_paket = paket.kd_paket where tbl_order.tgl_pesan = current_date() && paket.jenis_paket = 'satuan'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            int totalHariIni = rs.getInt("total_paket_ini");
            paketSatuan.setText("" + totalHariIni);
        } catch (Exception e) {
            paketSatuan.setText("" + 0);
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
            java.util.logging.Logger.getLogger(selengkapnyaPaketDipesanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selengkapnyaPaketDipesanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selengkapnyaPaketDipesanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selengkapnyaPaketDipesanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selengkapnyaPaketDipesanKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public static final javax.swing.JLabel paketKiloan = new javax.swing.JLabel();
    public static final javax.swing.JLabel paketSatuan = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
