package responsive;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class welcome_rs extends javax.swing.JFrame {
    int mousepX;
    int mousepY;
    public welcome_rs() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JPanel();
        panelNavigasi = new javax.swing.JPanel();
        labelJudulFrame = new javax.swing.JLabel();
        labelIconClose = new javax.swing.JLabel();
        labelIconMinimize = new javax.swing.JLabel();
        labelIconMen = new javax.swing.JLabel();
        panelKontent = new javax.swing.JPanel();
        tombolLanjutPage = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelBackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 0));
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelUtama.setLayout(null);

        panelNavigasi.setBackground(new java.awt.Color(255, 255, 255));
        panelNavigasi.setPreferredSize(new java.awt.Dimension(100, 40));
        panelNavigasi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelNavigasiMouseDragged(evt);
            }
        });
        panelNavigasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelNavigasiMousePressed(evt);
            }
        });
        panelNavigasi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelJudulFrame.setBackground(new java.awt.Color(255, 255, 255));
        labelJudulFrame.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        labelJudulFrame.setText("Laundry App");
        panelNavigasi.add(labelJudulFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, -1, 28));

        labelIconClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close (1)_1.png"))); // NOI18N
        labelIconClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelIconClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconCloseMouseClicked(evt);
            }
        });
        panelNavigasi.add(labelIconClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 20, 40));

        labelIconMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/squares.png"))); // NOI18N
        labelIconMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelIconMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconMinimizeMouseClicked(evt);
            }
        });
        panelNavigasi.add(labelIconMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, -1, 40));

        labelIconMen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N
        labelIconMen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelIconMen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconMenMouseClicked(evt);
            }
        });
        panelNavigasi.add(labelIconMen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, -1, 40));

        panelUtama.add(panelNavigasi);
        panelNavigasi.setBounds(0, 0, 1370, 40);

        panelKontent.setBackground(new java.awt.Color(0, 51, 51));
        panelKontent.setForeground(new java.awt.Color(51, 51, 51));
        panelKontent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tombolLanjutPage.setText("Masuk");
        tombolLanjutPage.setBorderPainted(false);
        tombolLanjutPage.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tombolLanjutPage.setkBackGroundColor(new java.awt.Color(40, 60, 237));
        tombolLanjutPage.setkEndColor(new java.awt.Color(40, 60, 237));
        tombolLanjutPage.setkHoverEndColor(new java.awt.Color(253, 218, 76));
        tombolLanjutPage.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        tombolLanjutPage.setkHoverStartColor(new java.awt.Color(253, 218, 76));
        tombolLanjutPage.setkPressedColor(new java.awt.Color(40, 60, 237));
        tombolLanjutPage.setkSelectedColor(new java.awt.Color(40, 60, 237));
        tombolLanjutPage.setkStartColor(new java.awt.Color(40, 60, 237));
        tombolLanjutPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolLanjutPageActionPerformed(evt);
            }
        });
        panelKontent.add(tombolLanjutPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, 170, 40));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setText("Selamat Datang");
        panelKontent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setText("Aplikasi Laundry ini memiliki beberapa fitur, seperti Transaksi, Nota, Input Pelanggan, Pembukuan, dan lainya.");
        panelKontent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setText("Aplikasi Laundry ini dapat memudahkan Admin, Kasir memanagement pemasukan dan pengeluaran dalam sebuah");
        panelKontent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setText("sistem transaksi yang dilakukan.");
        panelKontent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/logo (1).png"))); // NOI18N
        panelKontent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 70));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Decoration Bubble (4).png"))); // NOI18N
        panelKontent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, -1, -1));

        labelBackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg welcome full screen.png"))); // NOI18N
        panelKontent.add(labelBackgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelUtama.add(panelKontent);
        panelKontent.setBounds(0, 40, 1370, 730);

        getContentPane().add(panelUtama, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelIconCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_labelIconCloseMouseClicked

    private void labelIconMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconMinimizeMouseClicked
        // TODO add your handling code here:
        frame.welcome wl = new frame.welcome();
        wl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelIconMinimizeMouseClicked

    private void labelIconMenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconMenMouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_labelIconMenMouseClicked

    private void tombolLanjutPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLanjutPageActionPerformed
        // TODO add your handling code here:
        login_rs lg = new login_rs();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tombolLanjutPageActionPerformed

    private void panelNavigasiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNavigasiMousePressed
        // TODO add your handling code here:
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_panelNavigasiMousePressed

    private void panelNavigasiMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNavigasiMouseDragged
        // TODO add your handling code here:
        int kordinatX = evt.getXOnScreen();
        int kordinatY    = evt.getYOnScreen();
        this.setLocation(kordinatX-mousepX, kordinatY-mousepY);
    }//GEN-LAST:event_panelNavigasiMouseDragged

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
            java.util.logging.Logger.getLogger(welcome_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome_rs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome_rs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelBackgroundImage;
    private javax.swing.JLabel labelIconClose;
    private javax.swing.JLabel labelIconMen;
    private javax.swing.JLabel labelIconMinimize;
    private javax.swing.JLabel labelJudulFrame;
    private javax.swing.JPanel panelKontent;
    private javax.swing.JPanel panelNavigasi;
    private javax.swing.JPanel panelUtama;
    private com.k33ptoo.components.KButton tombolLanjutPage;
    // End of variables declaration//GEN-END:variables
}
