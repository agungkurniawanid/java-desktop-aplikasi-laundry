package frame;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class welcome extends javax.swing.JFrame {

    int clicked;
    int mousepX;
    int mousepY;      

    public welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUtama = new javax.swing.JPanel();
        panelKonten = new javax.swing.JPanel();
        tombolLanjutPage = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelNavigasi = new javax.swing.JPanel();
        labelJudulFrame = new javax.swing.JLabel();
        labelIconClose = new javax.swing.JLabel();
        labelIconMaximize = new javax.swing.JLabel();
        labelIconMen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        panelUtama.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelKonten.setBackground(new java.awt.Color(0, 0, 0));
        panelKonten.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelKonten.add(tombolLanjutPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 170, 40));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setText("Selamat Datang");
        panelKonten.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setText("sistem transaksi yang dilakukan.");
        panelKonten.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel3.setText("Aplikasi Laundry ini memiliki beberapa fitur, seperti Transaksi, Nota, Input Pelanggan, Pembukuan, dan lainya.");
        panelKonten.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setText("Aplikasi Laundry ini dapat memudahkan Admin, Kasir memanagement pemasukan dan pengeluaran dalam sebuah");
        panelKonten.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/logo (1).png"))); // NOI18N
        panelKonten.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 70));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/Decoration Bubble (4).png"))); // NOI18N
        panelKonten.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg welcome (1).png"))); // NOI18N
        panelKonten.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        panelUtama.add(panelKonten, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1200, 570));

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
        panelNavigasi.add(labelIconClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1174, 0, 20, 40));

        labelIconMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/maximize.png"))); // NOI18N
        labelIconMaximize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelIconMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconMaximizeMouseClicked(evt);
            }
        });
        panelNavigasi.add(labelIconMaximize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, -1, 40));

        labelIconMen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N
        labelIconMen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelIconMen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconMenMouseClicked(evt);
            }
        });
        panelNavigasi.add(labelIconMen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, -1, 40));

        panelUtama.add(panelNavigasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        getContentPane().add(panelUtama, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelIconCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_labelIconCloseMouseClicked

    private void tombolLanjutPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLanjutPageActionPerformed
        // TODO add your handling code here:
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tombolLanjutPageActionPerformed

    private void labelIconMenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconMenMouseClicked
        // TODO add your handling code here:
        this.setState(1);
    }//GEN-LAST:event_labelIconMenMouseClicked

    private void labelIconMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconMaximizeMouseClicked
        // TODO add your handling code here:
        responsive.welcome_rs wl = new responsive.welcome_rs();
        wl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_labelIconMaximizeMouseClicked

    private void panelNavigasiMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNavigasiMouseDragged
        // TODO add your handling code here:
        int kordinatX = evt.getXOnScreen();
        int kordinatY    = evt.getYOnScreen();
        this.setLocation(kordinatX-mousepX, kordinatY-mousepY);
    }//GEN-LAST:event_panelNavigasiMouseDragged

    private void panelNavigasiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNavigasiMousePressed
        // TODO add your handling code here:
        mousepX = evt.getX();
        mousepY = evt.getY(); 
    }//GEN-LAST:event_panelNavigasiMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelIconClose;
    private javax.swing.JLabel labelIconMaximize;
    private javax.swing.JLabel labelIconMen;
    private javax.swing.JLabel labelJudulFrame;
    private javax.swing.JPanel panelKonten;
    private javax.swing.JPanel panelNavigasi;
    private javax.swing.JPanel panelUtama;
    private com.k33ptoo.components.KButton tombolLanjutPage;
    // End of variables declaration//GEN-END:variables
}
