package detailDataJtextField;
public class PelangganTR extends javax.swing.JFrame {
    public PelangganTR() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nama_pelanggan_detail_form = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Pelanggan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 60, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconJoptionPane/driver-license.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 50));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("ID Pelanggan");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconJoptionPane/pin.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 50));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setText("Alamat Pelanggan");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconJoptionPane/phone-call.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, 50));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel12.setText("Nomor Telfon");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, 20));

        id_detail_pelanggan_form.setText("jLabel1");
        jPanel1.add(id_detail_pelanggan_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 160, -1));

        alamat_pelanggan_form.setText("jLabel1");
        jPanel1.add(alamat_pelanggan_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 150, -1));

        nomor_telfon_pelanggan_form.setText("jLabel1");
        jPanel1.add(nomor_telfon_pelanggan_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 160, -1));

        nama_pelanggan_form.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        nama_pelanggan_form.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nama_pelanggan_form.setText("Agung Kurniawan");
        jPanel1.add(nama_pelanggan_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 350, -1));

        nama_pelanggan_detail_form.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageDashboard/Desktop - 21 (2).png"))); // NOI18N
        jPanel1.add(nama_pelanggan_detail_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 550));

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PelangganTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PelangganTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PelangganTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PelangganTR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PelangganTR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel alamat_pelanggan_form = new javax.swing.JLabel();
    public static final javax.swing.JLabel id_detail_pelanggan_form = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nama_pelanggan_detail_form;
    public static final javax.swing.JLabel nama_pelanggan_form = new javax.swing.JLabel();
    public static final javax.swing.JLabel nomor_telfon_pelanggan_form = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
