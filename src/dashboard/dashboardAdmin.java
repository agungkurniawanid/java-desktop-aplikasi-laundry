package dashboard;

import codingImageDashboardAdmin.image1;
import codingImageDashboardAdmin.imageLogo;
import codingImageDashboardAdmin.image3;
import codingImageDashboardAdmin.image4;
import codingImageDashboardAdmin.image5;
import codingImageDashboardAdmin.image6;
import codingImageDashboardAdmin.image7;
import codingImageDashboardAdmin.image8;
import codingImageDashboardAdmin.image9;
import codingImageDashboardAdmin.image10;
import codingImageDashboardAdmin.borderRadiusTextFIield;
import codingImageDashboardAdmin.colorBackgroundJTable;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import connection.connect;
import java.awt.Color;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import deleteDataKasir.message.MessageDialog;
import static formManipultionData.dbsAdmin_editDataKasir.alamat_user_edit1;
import static formManipultionData.dbsAdmin_editDataKasir.hakAksesPertama;
import static formManipultionData.dbsAdmin_editDataKasir.id_user_edit1;
import static formManipultionData.dbsAdmin_editDataKasir.nama_user_edit1;
import static formManipultionData.dbsAdmin_editDataKasir.notel_user_edit1;
import static formManipultionData.dbsAdmin_editDataKasir_det.alamat_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.id_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.nama_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.notel_user_edit;
import static formManipultionData.editPaket.harga_edit;
import static formManipultionData.editPaket.jComboBox1_edit;
import static formManipultionData.editPaket.kd_paket_edit;
import static formManipultionData.editPaket.nama_paket_edit;
import static formManipultionData.edtiDataPelanggan.field_alamat_pelanggan_edit;
import static formManipultionData.edtiDataPelanggan.field_id_pelanggan_edit;
import static formManipultionData.edtiDataPelanggan.field_nama_pelanggan_edit;
import static formManipultionData.edtiDataPelanggan.field_nomor_telfon_edit;
import static formManipultionData.pengeluaran_edit.jumlahuang_pengeluaran_edit;
import static formManipultionData.pengeluaran_edit.keterangan_pengeluaran_edit;
import formManipultionData.pengeluaran_tambah;
import static formManipultionData.tambahPaket.kd_paket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import notification.Notification;
import swing.EventCallBack;
import swing.EventTextField;
import tableCustomize.TableCustom;
import static formManipultionData.pengeluaran_edit.kode_pengeluaran_edit;
import codingDesainPembukuan.gambarContainerCard1;
import codingDesainPembukuan.codingContainerCard2;
import codingDesainPembukuan.codingContainerCard3;
import codingDesainPembukuan.codingContainerCardPanjanf;
import codingDesainPembukuan.codingGambarBulanDipilih;
import codingDesainPembukuan.codingGambarPendapatan;
import codingDesainPembukuan.fungsiPembukuan;
import static formManipultionData.dbsAdmin_editDataKasir_det.password_user_edit;
import static formManipultionData.dbsAdmin_editDataKasir_det.username_user_edit;
import java.util.Date;
import raven.glasspanepopup.GlassPanePopup;
import sample.message.Message;
import static formManipultionData.dbsAdmin_editDataKasir_det.hak_akses_pen;

public class dashboardAdmin extends javax.swing.JFrame {

    static String selected_detail_transaksi;
    static String selected_data_kasir;
    static String KDpngl;
    static String select_pengeluaran;
    static String select_riwayat;
    static String selected_pelanggan_id;
    static String selec_paket;
    static String selected_pengeluaran;

    public dashboardAdmin() {
        getContentPane().setBackground(new Color(255, 255, 255));
        setTitle("Laundry App");
        initComponents();

        // PEMANGGILAN METHOD
        buatkodpaket();
        cariDataKasir();
        cariDataPelanggan();
        labarg();
        total_pmsk();
        total_pngl();

        // Table Custom
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        menampilkanDataPengguna(tabelkasir);
        TableCustom.apply(jScrollPane6, TableCustom.TableType.MULTI_LINE);
        menampilkanDataPelanggan(tabel_data_pelanggan);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        menampilkanDataTransaksiAdmin(tabel_data_transaksi);
        TableCustom.apply(jScrollPane3, TableCustom.TableType.MULTI_LINE);
        menampilkanDataRiwayaTransaksi(tabel_riwayat_transaksi);
        TableCustom.apply(jScrollPane4, TableCustom.TableType.MULTI_LINE);
        menampilkanPengeluaran(tabel_pengeluaran);
        TableCustom.apply(jScrollPane7, TableCustom.TableType.MULTI_LINE);
        menampilkanDataPaket(tabel_paket);

        // Nonaktifkan Button
        kButton3.setEnabled(false);
        kButton4.setEnabled(false);
        kButton5.setEnabled(false);
        kButton6.setEnabled(false);
        kButton10.setEnabled(false);
        kButton7.setEnabled(false);

        // search custom
        getContentPane().setBackground(new Color(0, 0, 255));
        GlassPanePopup.install(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        container = new javax.swing.JPanel();
        wrapperMenu = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        menuDashboard = new javax.swing.JPanel();
        dashboardLabel = new javax.swing.JLabel();
        menuDataKasir = new javax.swing.JPanel();
        dataKasirLabel = new javax.swing.JLabel();
        menuDataPelanggan = new javax.swing.JPanel();
        dataPelangganLabel = new javax.swing.JLabel();
        menuDataTransaksi = new javax.swing.JPanel();
        dataTransaksiLabel = new javax.swing.JLabel();
        menuHistoryTransaksi = new javax.swing.JPanel();
        historyTransaksiLabel = new javax.swing.JLabel();
        menuDataPengeluaran = new javax.swing.JPanel();
        dataPengeluaranLabel = new javax.swing.JLabel();
        menuDataPembukuan = new javax.swing.JPanel();
        dataPembukuanLabel = new javax.swing.JLabel();
        menuDataPaket = new javax.swing.JPanel();
        datapPaketLabel = new javax.swing.JLabel();
        wrapperContent = new javax.swing.JPanel();
        tempatJudulUserLogin = new javax.swing.JPanel();
        judulDb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        containerContent = new javax.swing.JPanel();
        tampilanDashboard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel3 = new image4();
        jPanel4 = new image5();
        jLabel101 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel8 = new image4();
        jPanel10 = new image6();
        jLabel95 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel9 = new image4();
        jPanel11 = new image7();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel12 = new image8();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        jPanel13 = new image9();
        InformasiTransaksi = new image1();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new  image3();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel6 = new  image3();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        tampilanDataKasir = new javax.swing.JPanel();
        kButton3 = new com.k33ptoo.components.KButton();
        FilterDataKasirComboBox = new combobox.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt1 = new swing.TextFieldAnimation();
        tampilanDataPelanggan = new javax.swing.JPanel();
        filterComboBoxPelanggan = new combobox.Combobox();
        kButton4 = new com.k33ptoo.components.KButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        field_cari_data_pelanggan = new swing.TextFieldAnimation();
        tampilanDataTransaksi = new javax.swing.JPanel();
        filterAksiDataTransaksiAdmin = new combobox.Combobox();
        kButton5 = new com.k33ptoo.components.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        tgl_awal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        tgl_akhir = new com.toedter.calendar.JDateChooser();
        kButton8 = new com.k33ptoo.components.KButton();
        tampilanHistoryTransaksi = new javax.swing.JPanel();
        filterAksIRiwayatTransaksi = new combobox.Combobox();
        kButton6 = new com.k33ptoo.components.KButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tgl_awal_ht = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tgl_akhir_ht = new com.toedter.calendar.JDateChooser();
        kButton9 = new com.k33ptoo.components.KButton();
        tampilanDataPengeluaran = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        filterPengeluaran = new combobox.Combobox();
        kButton10 = new com.k33ptoo.components.KButton();
        cariDataPengeluaranm = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        kButton11 = new com.k33ptoo.components.KButton();
        tampilanPembukuan = new javax.swing.JPanel();
        jPanel14 = new codingDesainPembukuan.gambarCard();
        jPanel16 = new codingDesainPembukuan.gambarContainerCard1();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new codingDesainPembukuan.gambarCard();
        jPanel17 = new codingDesainPembukuan.codingContainerCard2();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel15 = new codingDesainPembukuan.gambarCard();
        jPanel18 = new codingDesainPembukuan.codingContainerCard3();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel19 = new codingDesainPembukuan.codingContainerCardPanjanf();
        jPanel21 = new codingGambarPendapatan();
        jLabel14 = new javax.swing.JLabel();
        jPanel20 = new codingDesainPembukuan.codingContainerCardPanjanf();
        jPanel22 = new codingGambarBulanDipilih();
        jLabel12 = new javax.swing.JLabel();
        tampilanDataPaket = new javax.swing.JPanel();
        filterAksiPaket = new combobox.Combobox();
        kButton7 = new com.k33ptoo.components.KButton();
        jScrollPane7 = new javax.swing.JScrollPane();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setPreferredSize(new java.awt.Dimension(1200, 600));

        wrapperMenu.setBackground(new java.awt.Color(255, 255, 255));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/logo (1).png"))); // NOI18N

        menu.setBackground(new java.awt.Color(255, 255, 255));

        menuDashboard.setBackground(new java.awt.Color(255, 255, 255));
        menuDashboard.setPreferredSize(new java.awt.Dimension(100, 36));

        dashboardLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        dashboardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard_icon_menu.png"))); // NOI18N
        dashboardLabel.setText("Dashboard");
        dashboardLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboardLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDashboardLayout = new javax.swing.GroupLayout(menuDashboard);
        menuDashboard.setLayout(menuDashboardLayout);
        menuDashboardLayout.setHorizontalGroup(
            menuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(menuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDashboardLayout.createSequentialGroup()
                    .addGap(0, 14, Short.MAX_VALUE)
                    .addComponent(dashboardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        menuDashboardLayout.setVerticalGroup(
            menuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(menuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dashboardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        menuDataKasir.setBackground(new java.awt.Color(255, 255, 255));
        menuDataKasir.setPreferredSize(new java.awt.Dimension(100, 36));

        dataKasirLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        dataKasirLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user_1_1.png"))); // NOI18N
        dataKasirLabel.setText("Data Pengguna");
        dataKasirLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dataKasirLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataKasirLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataKasirLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDataKasirLayout = new javax.swing.GroupLayout(menuDataKasir);
        menuDataKasir.setLayout(menuDataKasirLayout);
        menuDataKasirLayout.setHorizontalGroup(
            menuDataKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDataKasirLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(dataKasirLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuDataKasirLayout.setVerticalGroup(
            menuDataKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataKasirLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuDataPelanggan.setBackground(new java.awt.Color(255, 255, 255));
        menuDataPelanggan.setPreferredSize(new java.awt.Dimension(0, 36));

        dataPelangganLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        dataPelangganLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        dataPelangganLabel.setText("Data Pelanggan");
        dataPelangganLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dataPelangganLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataPelangganLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataPelangganLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDataPelangganLayout = new javax.swing.GroupLayout(menuDataPelanggan);
        menuDataPelanggan.setLayout(menuDataPelangganLayout);
        menuDataPelangganLayout.setHorizontalGroup(
            menuDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDataPelangganLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dataPelangganLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuDataPelangganLayout.setVerticalGroup(
            menuDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPelangganLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuDataTransaksi.setBackground(new java.awt.Color(255, 255, 255));

        dataTransaksiLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        dataTransaksiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/monitor (1).png"))); // NOI18N
        dataTransaksiLabel.setText("Data Transaksi");
        dataTransaksiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dataTransaksiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTransaksiLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataTransaksiLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDataTransaksiLayout = new javax.swing.GroupLayout(menuDataTransaksi);
        menuDataTransaksi.setLayout(menuDataTransaksiLayout);
        menuDataTransaksiLayout.setHorizontalGroup(
            menuDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDataTransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dataTransaksiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuDataTransaksiLayout.setVerticalGroup(
            menuDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataTransaksiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuHistoryTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        menuHistoryTransaksi.setPreferredSize(new java.awt.Dimension(0, 36));

        historyTransaksiLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        historyTransaksiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/data_pelanggan.png"))); // NOI18N
        historyTransaksiLabel.setText("History Transaksi");
        historyTransaksiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyTransaksiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyTransaksiLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                historyTransaksiLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuHistoryTransaksiLayout = new javax.swing.GroupLayout(menuHistoryTransaksi);
        menuHistoryTransaksi.setLayout(menuHistoryTransaksiLayout);
        menuHistoryTransaksiLayout.setHorizontalGroup(
            menuHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuHistoryTransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(historyTransaksiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuHistoryTransaksiLayout.setVerticalGroup(
            menuHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(historyTransaksiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuDataPengeluaran.setBackground(new java.awt.Color(255, 255, 255));
        menuDataPengeluaran.setPreferredSize(new java.awt.Dimension(0, 36));

        dataPengeluaranLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        dataPengeluaranLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money-bag_1.png"))); // NOI18N
        dataPengeluaranLabel.setText("Data Pengeluaran");
        dataPengeluaranLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dataPengeluaranLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataPengeluaranLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataPengeluaranLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDataPengeluaranLayout = new javax.swing.GroupLayout(menuDataPengeluaran);
        menuDataPengeluaran.setLayout(menuDataPengeluaranLayout);
        menuDataPengeluaranLayout.setHorizontalGroup(
            menuDataPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDataPengeluaranLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dataPengeluaranLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuDataPengeluaranLayout.setVerticalGroup(
            menuDataPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPengeluaranLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuDataPembukuan.setBackground(new java.awt.Color(255, 255, 255));
        menuDataPembukuan.setPreferredSize(new java.awt.Dimension(0, 36));

        dataPembukuanLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        dataPembukuanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notes_1.png"))); // NOI18N
        dataPembukuanLabel.setText("Pembukuan");
        dataPembukuanLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dataPembukuanLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataPembukuanLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataPembukuanLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDataPembukuanLayout = new javax.swing.GroupLayout(menuDataPembukuan);
        menuDataPembukuan.setLayout(menuDataPembukuanLayout);
        menuDataPembukuanLayout.setHorizontalGroup(
            menuDataPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDataPembukuanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dataPembukuanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuDataPembukuanLayout.setVerticalGroup(
            menuDataPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPembukuanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuDataPaket.setBackground(new java.awt.Color(255, 255, 255));
        menuDataPaket.setPreferredSize(new java.awt.Dimension(0, 36));

        datapPaketLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        datapPaketLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logistics-delivery.png"))); // NOI18N
        datapPaketLabel.setText("Data Paket");
        datapPaketLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datapPaketLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datapPaketLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                datapPaketLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDataPaketLayout = new javax.swing.GroupLayout(menuDataPaket);
        menuDataPaket.setLayout(menuDataPaketLayout);
        menuDataPaketLayout.setHorizontalGroup(
            menuDataPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDataPaketLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(datapPaketLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuDataPaketLayout.setVerticalGroup(
            menuDataPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(datapPaketLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDataKasir, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDataPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDataTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuHistoryTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDataPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDataPembukuan, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDataPaket, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(menuDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDataKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDataTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuHistoryTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDataPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDataPembukuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDataPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout wrapperMenuLayout = new javax.swing.GroupLayout(wrapperMenu);
        wrapperMenu.setLayout(wrapperMenuLayout);
        wrapperMenuLayout.setHorizontalGroup(
            wrapperMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wrapperMenuLayout.setVerticalGroup(
            wrapperMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperMenuLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        wrapperContent.setBackground(new java.awt.Color(255, 255, 255));

        tempatJudulUserLogin.setBackground(new java.awt.Color(255, 255, 255));

        judulDb.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        judulDb.setText("Dashboard");

        jPanel1.setBackground(new java.awt.Color(245, 251, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/man_1.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(131, 193, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Admin Laundry");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        namaLoginAdmin.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        namaLoginAdmin.setText("Agung Kurniawan");
        namaLoginAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        namaLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                namaLoginAdminMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings (1).png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaLoginAdmin)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(namaLoginAdmin))))
                .addGap(18, 18, 18))
        );

        namaLoginAdminField.setForeground(new java.awt.Color(255, 255, 255));
        namaLoginAdminField.setBorder(null);
        namaLoginAdminField.setCaretColor(new java.awt.Color(255, 255, 255));
        namaLoginAdminField.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tempatJudulUserLoginLayout = new javax.swing.GroupLayout(tempatJudulUserLogin);
        tempatJudulUserLogin.setLayout(tempatJudulUserLoginLayout);
        tempatJudulUserLoginLayout.setHorizontalGroup(
            tempatJudulUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempatJudulUserLoginLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(judulDb)
                .addGap(67, 67, 67)
                .addComponent(namaLoginAdminField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tempatJudulUserLoginLayout.setVerticalGroup(
            tempatJudulUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempatJudulUserLoginLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tempatJudulUserLoginLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(tempatJudulUserLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tempatJudulUserLoginLayout.createSequentialGroup()
                        .addComponent(namaLoginAdminField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tempatJudulUserLoginLayout.createSequentialGroup()
                        .addComponent(judulDb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))))
        );

        containerContent.setBackground(new java.awt.Color(255, 255, 255));
        containerContent.setLayout(new java.awt.CardLayout());

        tampilanDashboard.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(245, 251, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(436, 100));

        jLabel92.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel92.setText("Data Catatan");

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 80));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jPanel4.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel101.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel101.setText("History Transaksi");
        jLabel101.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel101MouseClicked(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(153, 153, 153));
        jLabel96.setText("Catatan");

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/right-arrow (1).png"))); // NOI18N
        jLabel98.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel98MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101)
                    .addComponent(jLabel96))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(jLabel98)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel101)
                            .addGap(1, 1, 1)
                            .addComponent(jLabel96))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 0));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 80));

        jPanel10.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel95.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel95.setText("Data Kasir");
        jLabel95.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel95MouseClicked(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(153, 153, 153));
        jLabel102.setText("Data");

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/right-arrow (1).png"))); // NOI18N
        jLabel99.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel99MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel99)
                .addGap(33, 33, 33))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel95)
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel102))
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(51, 204, 0));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 80));

        jPanel11.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel104.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel104.setText("Data Pelanggan");
        jLabel104.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel104MouseClicked(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(153, 153, 153));
        jLabel105.setText("Data");

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/right-arrow (1).png"))); // NOI18N
        jLabel97.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel97MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel104)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel97)
                .addGap(32, 32, 32))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel105))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel87.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel87.setText("Data Paket");
        jLabel87.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel88.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel88.setText("Laundry");
        jLabel88.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        kButton2.setText("Kunjungi");
        kButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        kButton2.setkEndColor(new java.awt.Color(51, 51, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkPressedColor(new java.awt.Color(51, 51, 255));
        kButton2.setkSelectedColor(new java.awt.Color(51, 51, 255));
        kButton2.setkStartColor(new java.awt.Color(51, 51, 255));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88)
                    .addComponent(jLabel87)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel92)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel92)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel23.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Transaksi");

        jLabel24.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Informasi");

        jLabel21.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Informasi Transaksi berisi sebuah");

        jLabel22.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("data untuk melihat pemasukan");

        jLabel25.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("dari transaksi yang dilakukan mulai");

        jLabel20.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("perbulan, perminggu dan hari.");

        kButton1.setText("Lihat Informasi");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        kButton1.setkAllowTab(true);
        kButton1.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        kButton1.setkBorderRadius(20);
        kButton1.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton1.setkForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverEndColor(new java.awt.Color(160, 215, 231));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(160, 215, 231));
        kButton1.setkPressedColor(new java.awt.Color(255, 255, 255));
        kButton1.setkSelectedColor(new java.awt.Color(255, 255, 255));
        kButton1.setkStartColor(new java.awt.Color(255, 255, 255));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InformasiTransaksiLayout = new javax.swing.GroupLayout(InformasiTransaksi);
        InformasiTransaksi.setLayout(InformasiTransaksiLayout);
        InformasiTransaksiLayout.setHorizontalGroup(
            InformasiTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformasiTransaksiLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(InformasiTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(jLabel20)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InformasiTransaksiLayout.setVerticalGroup(
            InformasiTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformasiTransaksiLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(InformasiTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addGroup(InformasiTransaksiLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel23)))
                .addGap(17, 17, 17)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel26.setText("Jumlah Data Diketahui Saat Ini :");

        jPanel5.setPreferredSize(new java.awt.Dimension(138, 138));

        jLabel73.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel73.setText("Pengeluaran");
        jLabel73.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel74.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel74.setText("Bulan Ini");
        jLabel74.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel79.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(153, 153, 153));
        jLabel79.setText("Data Pengeluaran");

        jLabel77.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(47, 60, 237));
        jLabel77.setText("10000000000+");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu (1).png"))); // NOI18N
        jLabel84.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel84MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(58, 58, 58))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(98, 98, 98))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel84)))))
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        jPanel6.setPreferredSize(new java.awt.Dimension(138, 138));

        jLabel80.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel80.setText("Pemasukan");
        jLabel80.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel81.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel81.setText("Bulan Ini");
        jLabel81.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel83.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(153, 153, 153));
        jLabel83.setText("pembayaran client");

        jLabel85.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(47, 60, 237));
        jLabel85.setText("Rp. 5000000+");
        jLabel85.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu (1).png"))); // NOI18N
        jLabel72.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel72MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50)
                .addComponent(jLabel72)
                .addGap(34, 34, 34))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout tampilanDashboardLayout = new javax.swing.GroupLayout(tampilanDashboard);
        tampilanDashboard.setLayout(tampilanDashboardLayout);
        tampilanDashboardLayout.setHorizontalGroup(
            tampilanDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanDashboardLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(tampilanDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanDashboardLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanDashboardLayout.createSequentialGroup()
                        .addGroup(tampilanDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InformasiTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(tampilanDashboardLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
                        .addGap(49, 49, 49)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tampilanDashboardLayout.setVerticalGroup(
            tampilanDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addGroup(tampilanDashboardLayout.createSequentialGroup()
                .addComponent(InformasiTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addGap(2, 2, 2)
                .addGroup(tampilanDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addContainerGap())
        );

        containerContent.add(tampilanDashboard, "card2");

        tampilanDataKasir.setBackground(new java.awt.Color(255, 255, 255));

        kButton3.setText("Lakukan Aksi");
        kButton3.setBorderPainted(false);
        kButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton3.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton3.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton3.setkHoverEndColor(new java.awt.Color(255, 65, 85));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 65, 85));
        kButton3.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton3.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton3.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        FilterDataKasirComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tambah data pengguna", "Edit data pengguna", "Hapus data pengguna", "Refresh Tabel" }));
        FilterDataKasirComboBox.setSelectedIndex(-1);
        FilterDataKasirComboBox.setLabeText("Pilh Filter Aksi");
        FilterDataKasirComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterDataKasirComboBoxActionPerformed(evt);
            }
        });

        tabelkasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelkasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkasir);

        txt1.setBackground(new java.awt.Color(245, 245, 245));
        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tampilanDataKasirLayout = new javax.swing.GroupLayout(tampilanDataKasir);
        tampilanDataKasir.setLayout(tampilanDataKasirLayout);
        tampilanDataKasirLayout.setHorizontalGroup(
            tampilanDataKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataKasirLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(tampilanDataKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(tampilanDataKasirLayout.createSequentialGroup()
                        .addComponent(FilterDataKasirComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        tampilanDataKasirLayout.setVerticalGroup(
            tampilanDataKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataKasirLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(tampilanDataKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterDataKasirComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        containerContent.add(tampilanDataKasir, "card3");

        tampilanDataPelanggan.setBackground(new java.awt.Color(255, 255, 255));
        tampilanDataPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tampilanDataPelangganMouseClicked(evt);
            }
        });

        filterComboBoxPelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tambah data pelanggan", "Edit data pelanggan", "Hapus data pelanggan", "Refresh Tabel" }));
        filterComboBoxPelanggan.setSelectedIndex(-1);
        filterComboBoxPelanggan.setLabeText("Pilih Aksi");
        filterComboBoxPelanggan.setPreferredSize(new java.awt.Dimension(184, 50));
        filterComboBoxPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterComboBoxPelangganActionPerformed(evt);
            }
        });

        kButton4.setText("Lakukan Aksi");
        kButton4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton4.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton4.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton4.setkHoverEndColor(new java.awt.Color(255, 65, 85));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(255, 65, 85));
        kButton4.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton4.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton4.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        tabel_data_pelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_data_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_data_pelangganMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabel_data_pelanggan);

        field_cari_data_pelanggan.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout tampilanDataPelangganLayout = new javax.swing.GroupLayout(tampilanDataPelanggan);
        tampilanDataPelanggan.setLayout(tampilanDataPelangganLayout);
        tampilanDataPelangganLayout.setHorizontalGroup(
            tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanDataPelangganLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(tampilanDataPelangganLayout.createSequentialGroup()
                        .addComponent(filterComboBoxPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addGap(395, 395, 395)
                        .addComponent(field_cari_data_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        tampilanDataPelangganLayout.setVerticalGroup(
            tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataPelangganLayout.createSequentialGroup()
                .addGroup(tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanDataPelangganLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(filterComboBoxPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tampilanDataPelangganLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_cari_data_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(kButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        containerContent.add(tampilanDataPelanggan, "card4");

        tampilanDataTransaksi.setBackground(new java.awt.Color(255, 255, 255));

        filterAksiDataTransaksiAdmin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Detail transaksi", "Refresh data" }));
        filterAksiDataTransaksiAdmin.setSelectedIndex(-1);
        filterAksiDataTransaksiAdmin.setLabeText("Pilih Aksi");
        filterAksiDataTransaksiAdmin.setPreferredSize(new java.awt.Dimension(184, 50));
        filterAksiDataTransaksiAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterAksiDataTransaksiAdminActionPerformed(evt);
            }
        });

        kButton5.setText("Lakukan Aksi");
        kButton5.setBorderPainted(false);
        kButton5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton5.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton5.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton5.setkHoverEndColor(new java.awt.Color(255, 65, 85));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(255, 65, 85));
        kButton5.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton5.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton5.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        tabel_data_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_data_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_data_transaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_data_transaksi);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Tanggal awal :");

        tgl_awal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Tanggal akhir :");

        tgl_akhir.setBackground(new java.awt.Color(255, 255, 255));

        kButton8.setText("Cari");
        kButton8.setBorderPainted(false);
        kButton8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton8.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton8.setkBorderRadius(20);
        kButton8.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton8.setkHoverEndColor(new java.awt.Color(51, 0, 204));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(51, 0, 204));
        kButton8.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton8.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton8.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tampilanDataTransaksiLayout = new javax.swing.GroupLayout(tampilanDataTransaksi);
        tampilanDataTransaksi.setLayout(tampilanDataTransaksiLayout);
        tampilanDataTransaksiLayout.setHorizontalGroup(
            tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanDataTransaksiLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(tampilanDataTransaksiLayout.createSequentialGroup()
                        .addComponent(filterAksiDataTransaksiAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addGap(229, 229, 229)
                        .addGroup(tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_awal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(tgl_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        tampilanDataTransaksiLayout.setVerticalGroup(
            tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataTransaksiLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanDataTransaksiLayout.createSequentialGroup()
                        .addGroup(tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tgl_awal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tgl_akhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(kButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanDataTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterAksiDataTransaksiAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        containerContent.add(tampilanDataTransaksi, "card5");

        tampilanHistoryTransaksi.setBackground(new java.awt.Color(255, 255, 255));

        filterAksIRiwayatTransaksi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hapus data", "Hapus semua data", "Refresh data" }));
        filterAksIRiwayatTransaksi.setSelectedIndex(-1);
        filterAksIRiwayatTransaksi.setLabeText("Pilih Aksi");
        filterAksIRiwayatTransaksi.setPreferredSize(new java.awt.Dimension(184, 50));
        filterAksIRiwayatTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterAksIRiwayatTransaksiActionPerformed(evt);
            }
        });

        kButton6.setText("Lakukan Aksi");
        kButton6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton6.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton6.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton6.setkHoverEndColor(new java.awt.Color(255, 65, 85));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(255, 65, 85));
        kButton6.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton6.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton6.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        tabel_riwayat_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_riwayat_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_riwayat_transaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_riwayat_transaksi);

        tgl_awal_ht.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal awal :");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal akhir :");

        tgl_akhir_ht.setBackground(new java.awt.Color(255, 255, 255));

        kButton9.setText("Cari");
        kButton9.setBorderPainted(false);
        kButton9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton9.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton9.setkBorderRadius(20);
        kButton9.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton9.setkHoverEndColor(new java.awt.Color(51, 0, 204));
        kButton9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(51, 0, 204));
        kButton9.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton9.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton9.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tampilanHistoryTransaksiLayout = new javax.swing.GroupLayout(tampilanHistoryTransaksi);
        tampilanHistoryTransaksi.setLayout(tampilanHistoryTransaksiLayout);
        tampilanHistoryTransaksiLayout.setHorizontalGroup(
            tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanHistoryTransaksiLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(tampilanHistoryTransaksiLayout.createSequentialGroup()
                        .addComponent(filterAksIRiwayatTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addGap(174, 174, 174)
                        .addGroup(tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_awal_ht, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(tampilanHistoryTransaksiLayout.createSequentialGroup()
                                .addComponent(tgl_akhir_ht, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
        );
        tampilanHistoryTransaksiLayout.setVerticalGroup(
            tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanHistoryTransaksiLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanHistoryTransaksiLayout.createSequentialGroup()
                        .addGroup(tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tgl_awal_ht, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tgl_akhir_ht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tampilanHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(filterAksIRiwayatTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        containerContent.add(tampilanHistoryTransaksi, "card6");

        tampilanDataPengeluaran.setBackground(new java.awt.Color(255, 255, 255));

        tabel_pengeluaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_pengeluaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pengeluaranMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabel_pengeluaran);

        filterPengeluaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tambah pengeluaran", "Edit pengeluaran", "Hapus pengeluaran", "Refresh tabel" }));
        filterPengeluaran.setSelectedIndex(-1);
        filterPengeluaran.setLabeText("Pilih Aksi");
        filterPengeluaran.setPreferredSize(new java.awt.Dimension(184, 50));
        filterPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterPengeluaranActionPerformed(evt);
            }
        });

        kButton10.setText("Lakukan Aksi");
        kButton10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton10.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton10.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton10.setkHoverEndColor(new java.awt.Color(255, 65, 85));
        kButton10.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton10.setkHoverStartColor(new java.awt.Color(255, 65, 85));
        kButton10.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton10.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton10.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });

        cariDataPengeluaranm.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Cari berdasarkan tanggal :");

        kButton11.setText("Cari");
        kButton11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton11.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton11.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton11.setkHoverEndColor(new java.awt.Color(255, 65, 85));
        kButton11.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton11.setkHoverStartColor(new java.awt.Color(255, 65, 85));
        kButton11.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton11.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton11.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tampilanDataPengeluaranLayout = new javax.swing.GroupLayout(tampilanDataPengeluaran);
        tampilanDataPengeluaran.setLayout(tampilanDataPengeluaranLayout);
        tampilanDataPengeluaranLayout.setHorizontalGroup(
            tampilanDataPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataPengeluaranLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(tampilanDataPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(tampilanDataPengeluaranLayout.createSequentialGroup()
                        .addComponent(filterPengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addGap(353, 353, 353)
                        .addGroup(tampilanDataPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cariDataPengeluaranm, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        tampilanDataPengeluaranLayout.setVerticalGroup(
            tampilanDataPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataPengeluaranLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(tampilanDataPengeluaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filterPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tampilanDataPengeluaranLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariDataPengeluaranm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        containerContent.add(tampilanDataPengeluaran, "card7");

        tampilanPembukuan.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 0, 204));
        jPanel14.setPreferredSize(new java.awt.Dimension(300, 350));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel16.setText("Total Pemasukan");

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel17.setText("Hasil perhitungan keuangan selama");

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel18.setText("satu bulan, berdasarkan bulan dipilih.");

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel19.setText("Rp.");

        total_pmsk.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        total_pmsk.setText("150000");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, 0)
                        .addComponent(total_pmsk))
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(0, 0, 0)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(total_pmsk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 350));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel28.setText("Total Pengeluaran");

        jLabel29.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel29.setText("Hasil total semua pengeluaran selama");

        jLabel30.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel30.setText("sebulan berdasarkan bulan dipilih.");

        jLabel31.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel31.setText("Rp.");

        total_pngln.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        total_pngln.setText("150000");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_pngln))
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(0, 0, 0)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(total_pngln))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 102, 0));
        jPanel15.setPreferredSize(new java.awt.Dimension(300, 350));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel33.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel33.setText("Total Kerugian");

        rugii.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        rugii.setText("150000");

        jLabel34.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel34.setText("Hasil total semua kerugian selama");

        jLabel36.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel36.setText("Rp.");

        jLabel35.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel35.setText("sebulan berdasarkan bulan dipilih.");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rugii))
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addGap(0, 0, 0)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(rugii))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel10.setText("INFORMASI PEMBUKUAN");

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Perbulan & Laba,Rugi");

        filterPembukuanj.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        filterPembukuanj.setSelectedIndex(-1);
        filterPembukuanj.setLabeText("Filter Pembukuan");
        filterPembukuanj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterPembukuanjActionPerformed(evt);
            }
        });
        filterPembukuanj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterPembukuanjKeyReleased(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(204, 51, 0));

        jPanel21.setBackground(new java.awt.Color(255, 255, 0));
        jPanel21.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setText("Hasil Keuntungan :");

        laba.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        laba.setText("150000");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(laba))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(laba))
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(255, 51, 51));

        jPanel22.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel12.setText("Bulan dipilih :");

        bulanDipilih.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        bulanDipilih.setText("Januari");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(bulanDipilih))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulanDipilih))
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout tampilanPembukuanLayout = new javax.swing.GroupLayout(tampilanPembukuan);
        tampilanPembukuan.setLayout(tampilanPembukuanLayout);
        tampilanPembukuanLayout.setHorizontalGroup(
            tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanPembukuanLayout.createSequentialGroup()
                .addGroup(tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanPembukuanLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(tampilanPembukuanLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(filterPembukuanj, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(41, 41, 41)))
                .addGroup(tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        tampilanPembukuanLayout.setVerticalGroup(
            tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanPembukuanLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanPembukuanLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filterPembukuanj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tampilanPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        containerContent.add(tampilanPembukuan, "card8");

        tampilanDataPaket.setBackground(new java.awt.Color(255, 255, 255));

        filterAksiPaket.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tambah data paket", "Hapus data paket", "Edit data paket", "Refresh Tabel" }));
        filterAksiPaket.setSelectedIndex(-1);
        filterAksiPaket.setLabeText("Pilih Aksi");
        filterAksiPaket.setPreferredSize(new java.awt.Dimension(184, 50));
        filterAksiPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterAksiPaketActionPerformed(evt);
            }
        });

        kButton7.setText("Lakukan Aksi");
        kButton7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton7.setkBackGroundColor(new java.awt.Color(113, 144, 245));
        kButton7.setkEndColor(new java.awt.Color(113, 144, 245));
        kButton7.setkHoverEndColor(new java.awt.Color(255, 65, 85));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(255, 65, 85));
        kButton7.setkPressedColor(new java.awt.Color(113, 144, 245));
        kButton7.setkSelectedColor(new java.awt.Color(113, 144, 245));
        kButton7.setkStartColor(new java.awt.Color(113, 144, 245));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        tabel_paket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_paket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_paketMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabel_paket);

        javax.swing.GroupLayout tampilanDataPaketLayout = new javax.swing.GroupLayout(tampilanDataPaket);
        tampilanDataPaket.setLayout(tampilanDataPaketLayout);
        tampilanDataPaketLayout.setHorizontalGroup(
            tampilanDataPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataPaketLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(tampilanDataPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanDataPaketLayout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(tampilanDataPaketLayout.createSequentialGroup()
                        .addComponent(filterAksiPaket, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addGap(620, 620, 620))))
        );
        tampilanDataPaketLayout.setVerticalGroup(
            tampilanDataPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataPaketLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(tampilanDataPaketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterAksiPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tampilanDataPaketLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        containerContent.add(tampilanDataPaket, "card9");

        javax.swing.GroupLayout wrapperContentLayout = new javax.swing.GroupLayout(wrapperContent);
        wrapperContent.setLayout(wrapperContentLayout);
        wrapperContentLayout.setHorizontalGroup(
            wrapperContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tempatJudulUserLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(containerContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wrapperContentLayout.setVerticalGroup(
            wrapperContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperContentLayout.createSequentialGroup()
                .addComponent(tempatJudulUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(containerContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(wrapperMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(wrapperContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapperMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wrapperContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void closeApp() {
        new dashboardAdmin().dispose();
    }

    public void labarg() {
        try {
            int peng = Integer.parseInt(total_pngln.getText());
            int pemsk = Integer.parseInt(total_pmsk.getText());
            int rugi = peng - pemsk;
            int labaa = pemsk - peng;
            if (pemsk > peng) {
                laba.setText("" + labaa);
                rugii.setText("" + 0);
            } else if (peng > pemsk) {
                laba.setText("" + 0);
                rugii.setText("" + rugi);
            } else if (peng == pemsk) {
                laba.setText("" + 0);
                rugii.setText("" + 0);
            }
        } catch (Exception e) {
        }
    }

    public void total_pngl() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        try {
            String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pngl"));
            total_pngln.setText(tot);
            jLabel77.setText(tot);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
    }

    public void menampilkanPengeluaran(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode pengeluaran");
        tbl.addColumn("Tanggal pengeluaran");
        tbl.addColumn("Total");
        tbl.addColumn("Keterangan");
        tabel_pengeluaran.setModel(tbl);
        try {
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from pengeluaran");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kd_pengeluaran"),
                    res.getString("tanggal_pengeluaran"),
                    res.getString("total"),
                    res.getString("keterangan")
                });

                tabel_pengeluaran.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    void cariDataTranskaksi() {
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String awal = String.valueOf(fm.format(tgl_awal.getDate()));
        String sampai = String.valueOf(fm.format(tgl_akhir.getDate()));
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode struk");
        tbl.addColumn("Nama pelanggan");
        tbl.addColumn("Id kasir");
        tbl.addColumn("Nama kasir");
        tbl.addColumn("Tanggal pesan");
        tbl.addColumn("Tanggal selesai");
        tbl.addColumn("Grand total");
        tbl.addColumn("Bayar");
        tbl.addColumn("Kurang bayar");
        tbl.addColumn("Status bayar");
        tbl.addColumn("Kembalian");
        tbl.addColumn("Status ambil");
        try {
            String sql = "select * from tbl_order join pelanggan on pelanggan.id_pelanggan=tbl_order.id_pelanggan join user on user.id_user=tbl_order.id_user "
                    + "WHERE tbl_order.tgl_pesan BETWEEN '" + awal + "' AND '" + sampai + "'";
            Connection con = (Connection) connection.connect.configDB();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getString("kode_order"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("id_user"),
                    rs.getString("nama"),
                    rs.getString("tgl_pesan"),
                    rs.getString("tgl_selesai"),
                    rs.getString("grand_total"),
                    rs.getString("bayar"),
                    rs.getString("kurang_bayar"),
                    rs.getString("status_bayar"),
                    rs.getString("kembalian"),
                    rs.getString("status_ambil")
                });
                tabel_data_transaksi.setModel(tbl);
            }
            if (tbl.getRowCount() == 0) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Data tidak ditemukan!");
                panel.showNotification();
            }
        } catch (Exception e) {
        }
    }

    void infoDataPelangganTidakDitemukan() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Data pelanggan tidak ditemukan! silahkan daftarkan baru!");
        panel.showNotification();
    }

    void infoBelumMencariDataPelanggan() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Anda belum mencari data pelanggan!");
        panel.showNotification();
    }

    void cariDataPelanggan() {
        field_cari_data_pelanggan.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                if (field_cari_data_pelanggan.getText().isEmpty()) {
                    infoBelumMencariDataPelanggan();
                }
                try {
                    DefaultTableModel tbl = new DefaultTableModel();
                    tbl.addColumn("ID Pelanggan");
                    tbl.addColumn("Nama Pelanggan");
                    tbl.addColumn("Alamat Pelanggan");
                    tbl.addColumn("Nomor telfon");
                    tbl.setRowCount(0);
                    try {
                        String sql = "SELECT * FROM pelanggan WHERE nama_pelanggan like'%" + field_cari_data_pelanggan.getText() + "%' || id_pelanggan like'%" + field_cari_data_pelanggan.getText() + "%' || alamat like'%" + field_cari_data_pelanggan.getText() + "%'";
                        Connection con = (Connection) connection.connect.configDB();
                        Statement st = (Statement) con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                            tbl.addRow(new Object[]{
                                rs.getString("id_pelanggan"),
                                rs.getString("nama_pelanggan"),
                                rs.getString("alamat"),
                                rs.getString("no_telp"),});
                            tabel_data_pelanggan.setModel(tbl);
                        }
                        if (tbl.getRowCount() == 0) {
                            infoDataPelangganTidakDitemukan();
                        }
                    } catch (Exception e) {
                    }
                    for (int i = 1; i <= 70; i++) {
                        field_cari_data_pelanggan.setText("");
                        Thread.sleep(10);
                    }
                    call.done();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }

    void infoSearchDataKasirTidakAda() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Data pengguna tidak ditemukan! silahkan daftarkan baru!");
        panel.showNotification();
        menampilkanDataPengguna(tabelkasir);
    }

    void infoSearchDataKasir() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Anda belum mencari pelanggan!");
        panel.showNotification();
    }

    public void cariDataKasir() {
        txt1.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                if (txt1.getText().isEmpty()) {
                    infoSearchDataKasir();
                }
                try {
                    DefaultTableModel tbl = new DefaultTableModel();
                    tbl.addColumn("ID Pengguna");
                    tbl.addColumn("Nama Pengguna");
                    tbl.addColumn("Alamat Pengguna");
                    tbl.addColumn("Nomor Pengguna");
                    tbl.addColumn("Status");
                    tbl.setRowCount(0);
                    try {
                        try {
                            String sql = "SELECT * FROM user WHERE id_user like'%" + txt1.getText() + "%'OR alamat like'%" + txt1.getText() + "%' OR nama like'%" + txt1.getText() + "%'";
                            Connection con = (Connection) connection.connect.configDB();
                            Statement st = (Statement) con.createStatement();
                            ResultSet rs = st.executeQuery(sql);
                            while (rs.next()) {
                                tbl.addRow(new Object[]{
                                    rs.getString("id_user"),
                                    rs.getString("nama"),
                                    rs.getString("alamat"),
                                    rs.getString("no_hp"),
                                    rs.getString("akses")
                                });
                                tabelkasir.setModel(tbl);
                            }
                            if (tbl.getRowCount() == 0) {
                                infoSearchDataKasirTidakAda();
                            }
                        } catch (Exception e) {
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data Kosong || Tidak Ada Data yang Sesuai");
                    }
                    for (int i = 1; i <= 70; i++) {
                        txt1.setText("");
                        Thread.sleep(10);
                    }
                    call.done();
                } catch (Exception e) {
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }

    void resetPaket() {
        nama_paket_edit.setText("");
        harga_edit.setText("0");
    }

    public void buatkodpaket() {
        try {

            String sql = "SELECT * from paket ORDER BY kd_paket DESC";
            Connection con = (Connection) connection.connect.configDB();
            Statement st = (Statement) con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                String Noplg = res.getString("kd_paket").substring(2);
                String AN = "" + (Integer.parseInt(Noplg) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }
                kd_paket.setText("PK" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                kd_paket.setText("PK0001");//sesuaikan dengan variable namenya
            }
            res.close();
//            con.close();
        } catch (Exception e) {
            //penanganan masalah
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void menampilkanDataPaket(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode paket");
        tbl.addColumn("Nama paket");
        tbl.addColumn("jenis paket");
        tbl.addColumn("harga");
        tabel_paket.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from paket");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kd_paket"),
                    res.getString("nama_paket"),
                    res.getString("jenis_paket"),
                    res.getString("harga"),});
                tabel_paket.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void menampilkanDataRiwayaTransaksi(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id history");
        tbl.addColumn("Kode struk");
        tbl.addColumn("Id kasir pertama");
        tbl.addColumn("Jumlah bayar awal");
        tbl.addColumn("Kurang bayar awal");
        tbl.addColumn("Status bayar awal");
        tbl.addColumn("Kembalian awal");
        tbl.addColumn("Waktu perubahan");
        tabel_riwayat_transaksi.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from history_transaksi");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_hist"),
                    res.getString("kode_order"),
                    res.getString("id_user_awl"),
                    res.getString("bayar_awl"),
                    res.getString("kurang_byr_awl"),
                    res.getString("status_byr_awl"),
                    res.getString("kembalian_awl"),
                    res.getString("waktu"),});
                tabel_riwayat_transaksi.setModel(tbl);
            }
            //int b = tabelhistory.getRowCount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void total_pmsk() {
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        SimpleDateFormat tahunn = new SimpleDateFormat("yyyy");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        try {
            String sts = "sudah di ambil";
            String sql = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order"
                    + " where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
            Connection con = (Connection) connect.configDB();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();
            String tot = (rs.getString("total_pemasukan"));
            total_pmsk.setText(tot);
            jLabel85.setText(tot);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "maaf untuk sekarang data dengan status sudah di ambil masih belum ada" + e.getMessage());
        }
    }

    public void menampilkanDataTransaksiAdmin(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Struk");
        tbl.addColumn("ID Pelanggan");
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("ID Kasir");
        tbl.addColumn("Nama Kasir");
        tbl.addColumn("Tanggal Pesan");
        tbl.addColumn("Tanggal Selesai");
        tbl.addColumn("Grand Total");
        tbl.addColumn("Bayar");
        tbl.addColumn("Kurang Bayar");
        tbl.addColumn("Status Bayar");
        tbl.addColumn("Kembalian");
        tbl.addColumn("Status Ambil");
        tabel_data_transaksi.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();

//           Statement statement=(Statement)coneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from tbl_order join pelanggan on pelanggan.id_pelanggan=tbl_order.id_pelanggan join user on user.id_user=tbl_order.id_user");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kode_order"),
                    res.getString("id_pelanggan"),
                    res.getString("nama_pelanggan"),
                    res.getString("id_user"),
                    res.getString("nama"),
                    res.getString("tgl_pesan"),
                    res.getString("tgl_selesai"),
                    res.getString("grand_total"),
                    res.getString("bayar"),
                    res.getString("kurang_bayar"),
                    res.getString("status_bayar"),
                    res.getString("kembalian"),
                    res.getString("status_ambil"),});
                tabel_data_transaksi.setModel(tbl);
            }
//            int b = table_data_transaksi2.getRowCount();
//            jumlah_data_paket_dsb.setText("" + b);
//            total_pmsk();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void menampilkanDataPelanggan(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Pelanggan");
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Alamat Pelanggan");
        tbl.addColumn("Nomor Telfon");
        tabel_data_pelanggan.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from pelanggan");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_pelanggan"),
                    res.getString("nama_pelanggan"),
                    res.getString("alamat"),
                    res.getString("no_telp"),});
                tabel_data_pelanggan.setModel(tbl);
            }
            int b = tabel_data_pelanggan.getRowCount();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void menampilkanDataPengguna(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Pengguna");
        tbl.addColumn("Nama Pengguna");
        tbl.addColumn("Username");
        tbl.addColumn("Password");
        tbl.addColumn("Alamat Pengguna");
        tbl.addColumn("Nomor Pengguna");
        tbl.addColumn("Status");
        tabelkasir.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from user");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_user"),
                    res.getString("nama"),
                    res.getString("username"),
                    res.getString("password"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("akses")});
                tabelkasir.setModel(tbl);
            }
            //int b = tabelkasir.getRowCount();
            //jumlah_data_kasir.setText("" + b);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        new dashboard.infomasiTransaksiAdmin().setVisible(true);
    }//GEN-LAST:event_kButton1ActionPerformed

    private void dashboardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Dashboard");
        jPanel1.setBackground(new Color(245, 251, 255));
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDashboard);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_dashboardLabelMouseClicked

    private void dashboardLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDashboard);
    }//GEN-LAST:event_dashboardLabelMousePressed

    private void dataKasirLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataKasirLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Kasir");
        jPanel1.setBackground(Color.WHITE);
        resetColor(menuDashboard);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataKasir);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_dataKasirLabelMouseClicked

    private void dataKasirLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataKasirLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDataKasir);
    }//GEN-LAST:event_dataKasirLabelMousePressed

    private void dataPelangganLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPelangganLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Pelanggan");
        jPanel1.setBackground(Color.WHITE);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataPelanggan);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_dataPelangganLabelMouseClicked

    private void dataPelangganLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPelangganLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDataPelanggan);
    }//GEN-LAST:event_dataPelangganLabelMousePressed

    private void dataTransaksiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTransaksiLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Transaksi");
        jPanel1.setBackground(Color.WHITE);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataTransaksi);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_dataTransaksiLabelMouseClicked

    private void dataTransaksiLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTransaksiLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDataTransaksi);
    }//GEN-LAST:event_dataTransaksiLabelMousePressed

    private void historyTransaksiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTransaksiLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Riwayat Transaksi");
        jPanel1.setBackground(Color.WHITE);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanHistoryTransaksi);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_historyTransaksiLabelMouseClicked

    private void historyTransaksiLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTransaksiLabelMousePressed
        // TODO add your handling code here:
        setColor(menuHistoryTransaksi);
    }//GEN-LAST:event_historyTransaksiLabelMousePressed

    private void dataPengeluaranLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPengeluaranLabelMouseClicked
        // TODO add your handling code here:
        jPanel1.setBackground(Color.WHITE);
        judulDb.setText("Data Pengeluaran");
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataPengeluaran);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_dataPengeluaranLabelMouseClicked

    private void dataPengeluaranLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPengeluaranLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDataPengeluaran);
    }//GEN-LAST:event_dataPengeluaranLabelMousePressed

    private void dataPembukuanLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPembukuanLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Pembukuan");
        jPanel1.setBackground(Color.WHITE);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanPembukuan);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_dataPembukuanLabelMouseClicked

    private void dataPembukuanLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPembukuanLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDataPembukuan);
    }//GEN-LAST:event_dataPembukuanLabelMousePressed

    private void datapPaketLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datapPaketLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Paket");
        jPanel1.setBackground(Color.WHITE);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataPaket);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_datapPaketLabelMouseClicked

    private void datapPaketLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datapPaketLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDataPaket);
    }//GEN-LAST:event_datapPaketLabelMousePressed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        if (FilterDataKasirComboBox.getSelectedItem().equals("Tambah data pengguna")) {
            new formManipultionData.dbsAdmin_tambahDataKasir().setVisible(true);
        } else if (FilterDataKasirComboBox.getSelectedItem()
                .equals("Edit data pengguna")) {
            if (selected_data_kasir != null) {
                new formManipultionData.dbsAdmin_editDataKasir_det().setVisible(true);
                selected_data_kasir = null;
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Pilh atau tekan data pada tabel dahulu!");
                panel.showNotification();
            }
        } else if (FilterDataKasirComboBox.getSelectedItem().equals("Hapus data pengguna")) {
            if (selected_data_kasir != null) {
                MessageDialog obj = new MessageDialog(this);
                obj.showMessage("Apakah ingin melanjutkan hapus data?",
                        "Data yang terhapus tidak dapat kembali lagi, anda harus inputkan ulang data jika ingin data kembali.");
                if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                    System.out.println("User click ok");
                    try {
                        String sql = "DELETE FROM user WHERE id_user='" + selected_data_kasir + "'";
                        Connection con = (Connection) connection.connect.configDB();
                        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                        Notification panel = new Notification(this,
                                Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Berhasil dihapus!");
                        panel.showNotification();
                        pst.execute();
                        menampilkanDataPengguna(tabelkasir);
                        selected_data_kasir = null;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus");
                    }
                } else {
                    System.out.println("User click cancel");
                }
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap pilih atau tekan data pada tabel dahulu lalu lakukan penghapusan!");
                panel.showNotification();
            }
        } else if (FilterDataKasirComboBox.getSelectedItem().equals("Refresh Tabel")) {
            menampilkanDataPengguna(tabelkasir);
        }
    }//GEN-LAST:event_kButton3ActionPerformed

    private void FilterDataKasirComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterDataKasirComboBoxActionPerformed
        // TODO add your handling code here:
        if (FilterDataKasirComboBox.getSelectedItem().equals("Tambah data pengguna") || FilterDataKasirComboBox.getSelectedItem().equals("Edit data pengguna") || FilterDataKasirComboBox.getSelectedItem().equals("Hapus data pengguna") || FilterDataKasirComboBox.getSelectedItem().equals("Refresh Tabel")) {
            kButton3.setEnabled(true);
        }
    }//GEN-LAST:event_FilterDataKasirComboBoxActionPerformed

    private void tampilanDataPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilanDataPelangganMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tampilanDataPelangganMouseClicked

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
        if (filterComboBoxPelanggan.getSelectedItem().equals("Tambah data pelanggan")) {
            new formManipultionData.tambahDataPelanggan().setVisible(true);
        } else if (filterComboBoxPelanggan.getSelectedItem().equals("Edit data pelanggan")) {
            if (selected_pelanggan_id != null) {
                new formManipultionData.edtiDataPelanggan().setVisible(true);
                selected_pelanggan_id = null;
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Pilih dahulu data pelanggan pada tabel lalu lakukan aksi!");
                panel.showNotification();
            }
        } else if (filterComboBoxPelanggan.getSelectedItem().equals("Hapus data pelanggan")) {
            if (selected_pelanggan_id != null) {
                MessageDialog obj = new MessageDialog(this);
                obj.showMessage("Apakah ingin melanjutkan hapus data?",
                        "Data yang terhapus tidak dapat kembali lagi, anda haru inputkan ulang data jika ingin data kembali.");
                if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                    try {
                        String sql = "DELETE FROM pelanggan WHERE id_pelanggan='" + selected_pelanggan_id + "'";
                        Connection con = (Connection) connection.connect.configDB();
                        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                        Notification panel = new Notification(this, Notification.Type.SUCCESS,
                                Notification.Location.TOP_CENTER, "Data berhasil dihapus!");
                        panel.showNotification();
                        pst.execute();
                        menampilkanDataPelanggan(tabel_data_pelanggan);
                        selected_pelanggan_id = null;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus" + " " + e.getMessage());
                    }
                }
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap pilih dahulu data pada tabel lalu lakukan aksi!");
                panel.showNotification();
            }
        } else if (filterComboBoxPelanggan.getSelectedItem().equals("Refresh Tabel")) {
            menampilkanDataPelanggan(tabel_data_pelanggan);
        }
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
        String detail = (String) filterAksiDataTransaksiAdmin.getSelectedItem();
        if (detail.equals("Detail transaksi")) {
            if (selected_detail_transaksi != null) {
                new formDetailTransaksiAdmin().setVisible(true);
                selected_detail_transaksi = null;
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap klik data pada tabel dahulu!");
                panel.showNotification();
            }
        } else if (detail.equals("Refresh data")) {
            menampilkanDataTransaksiAdmin(tabel_data_transaksi);
        }
    }//GEN-LAST:event_kButton5ActionPerformed

    int clicked;
    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
        if (filterAksIRiwayatTransaksi.getSelectedItem().equals("Hapus data")) {
            if (select_riwayat != null) {
                MessageDialog obj = new MessageDialog(this);
                obj.showMessage("Apakah ingin melanjutkan hapus data?",
                        "Data yang terhapus tidak dapat kembali lagi, anda haru inputkan ulang data jika ingin data kembali.");
                if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                    try {
                        String sql = "DELETE FROM history_transaksi WHERE id_hist='" + select_riwayat + "'";
                        Connection con = (Connection) connection.connect.configDB();
                        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                        Notification panel = new Notification(this, Notification.Type.SUCCESS,
                                Notification.Location.TOP_CENTER, "Berhasil dihapus!");
                        panel.showNotification();
                        pst.execute();
                        menampilkanDataRiwayaTransaksi(tabel_riwayat_transaksi);
                        //tampil_pembukuan();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus");
                    }
                }
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Pilih data atau klik pada tabel dahulu!");
                panel.showNotification();
            }
        } else if (filterAksIRiwayatTransaksi.getSelectedItem().equals("Refresh data")) {
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("Id history");
            tbl.addColumn("Kode struk");
            tbl.addColumn("Id kasir pertama");
            tbl.addColumn("Jumlah bayar awal");
            tbl.addColumn("Kurang bayar awal");
            tbl.addColumn("Status bayar awal");
            tbl.addColumn("Kembalian awal");
            tbl.addColumn("Waktu perubahan");
            tabel_riwayat_transaksi.setModel(tbl);
            try {
                Statement statement = (Statement) connection.connect.configDB().createStatement();
                ResultSet res = statement.executeQuery("select * from history_transaksi");
                while (res.next()) {
                    tbl.addRow(new Object[]{
                        res.getString("id_hist"),
                        res.getString("kode_order"),
                        res.getString("id_user_awl"),
                        res.getString("bayar_awl"),
                        res.getString("kurang_byr_awl"),
                        res.getString("status_byr_awl"),
                        res.getString("kembalian_awl"),
                        res.getString("waktu"),});
                    tabel_riwayat_transaksi.setModel(tbl);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
            }
        } else if (filterAksIRiwayatTransaksi.getSelectedItem().equals("Hapus semua data")) {
            MessageDialog obj = new MessageDialog(this);
            obj.showMessage("Apakah ingin melanjutkan hapus data?", "Data yang terhapus tidak dapat kembali lagi, anda haru inputkan ulang data jika ingin data kembali.");
            if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                try {
                    String sql = "DELETE FROM history_transaksi";
                    Connection con = (Connection) connection.connect.configDB();
                    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                    Notification panel = new Notification(this, Notification.Type.SUCCESS,
                            Notification.Location.TOP_CENTER, "Berhasil dihapus!");
                    panel.showNotification();
                    pst.execute();
                    menampilkanDataRiwayaTransaksi(tabel_riwayat_transaksi);
                    //tampil_pembukuan();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data gagal di Hapus");
                }
            }
        }
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        if (filterAksiPaket.getSelectedItem().equals("Tambah data paket")) {
            new formManipultionData.tambahPaket().setVisible(true);
        } else if (filterAksiPaket.getSelectedItem().equals("Edit data paket")) {
            if (selec_paket != null) {
                new formManipultionData.editPaket().setVisible(true);
                selec_paket = null;
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Pilih data pada tabel dahulu!");
                panel.showNotification();
            }
        } else if (filterAksiPaket.getSelectedItem().equals("Hapus data paket")) {
            if (selec_paket != null) {
                MessageDialog obj = new MessageDialog(this);
                obj.showMessage("Apakah ingin melanjutkan hapus data?", "Data yang terhapus tidak dapat kembali lagi, anda haru inputkan ulang data jika ingin data kembali.");
                if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                    try {
                        String sql = "DELETE FROM paket WHERE kd_paket='" + selec_paket + "'";
                        Connection con = (Connection) connection.connect.configDB();
                        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                        Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Berhasil dihapus!");
                        panel.showNotification();
                        pst.execute();
                        menampilkanDataPaket(tabel_paket);
                        buatkodpaket();
                        resetPaket();
                        selec_paket = null;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus" + e.getMessage());
                    }
                }
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Pilih atau tekan data pada tabel!");
                panel.showNotification();
            }
        } else if (filterAksiPaket.getSelectedItem().equals("Refresh Tabel")) {
            menampilkanDataPaket(tabel_paket);
        }
    }//GEN-LAST:event_kButton7ActionPerformed

    private void tabelkasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkasirMouseClicked
        // TODO add your handling code here:
        int baris = tabelkasir.rowAtPoint(evt.getPoint());
        String tid = tabelkasir.getValueAt(baris, 0).toString();
        id_user_edit.setText(tid);
        session.session.setId_kasir_ubah(tid);
        id_user_edit1.setText(tid);
        this.selected_data_kasir = tid;
        String tnama = tabelkasir.getValueAt(baris, 1).toString();
        nama_user_edit.setText(tnama);
        nama_user_edit1.setText(tnama);
        String tusern = tabelkasir.getValueAt(baris, 2).toString();
        username_user_edit.setText(tusern);

        String tpass = tabelkasir.getValueAt(baris, 3).toString();
        password_user_edit.setText(tpass);

        String talamat = tabelkasir.getValueAt(baris, 4).toString();
        alamat_user_edit.setText(talamat);
        alamat_user_edit1.setText(talamat);
        String tno = tabelkasir.getValueAt(baris, 5).toString();
        notel_user_edit.setText(tno);
        notel_user_edit1.setText(tno);
        aksesss();
    }//GEN-LAST:event_tabelkasirMouseClicked
    public void aksesss() {
        try {
            String sql = "SELECT akses from user where id_user='" + session.session.getId_kasir_ubah() + "'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                hak_akses_pen.setSelectedItem(rs.getString("akses"));
            }
        } catch (Exception e) {
        }
    }
    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

    private void filterComboBoxPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterComboBoxPelangganActionPerformed
        // TODO add your handling code here:
        if (filterComboBoxPelanggan.getSelectedItem().equals("Tambah data pelanggan") || filterComboBoxPelanggan.getSelectedItem().equals("Edit data pelanggan") || filterComboBoxPelanggan.getSelectedItem().equals("Hapus data pelanggan") || filterComboBoxPelanggan.getSelectedItem().equals("Refresh Tabel")) {
            kButton4.setEnabled(true);
        }
    }//GEN-LAST:event_filterComboBoxPelangganActionPerformed

    private void tabel_data_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_data_pelangganMouseClicked
        // TODO add your handling code here:
        int baris = tabel_data_pelanggan.rowAtPoint(evt.getPoint());
        String tid = tabel_data_pelanggan.getValueAt(baris, 0).toString();
        field_id_pelanggan_edit.setText(tid);
        this.selected_pelanggan_id = tid;
        String tnama = tabel_data_pelanggan.getValueAt(baris, 1).toString();
        field_nama_pelanggan_edit.setText(tnama);
        String talamat = tabel_data_pelanggan.getValueAt(baris, 2).toString();
        field_alamat_pelanggan_edit.setText(talamat);
        String tno = tabel_data_pelanggan.getValueAt(baris, 3).toString();
        field_nomor_telfon_edit.setText(tno);
    }//GEN-LAST:event_tabel_data_pelangganMouseClicked

    private void filterAksiDataTransaksiAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterAksiDataTransaksiAdminActionPerformed
        // TODO add your handling code here:
        if (filterAksiDataTransaksiAdmin.getSelectedItem().equals("Detail transaksi") || filterAksiDataTransaksiAdmin.getSelectedItem().equals("Hapus semua riwayat") || filterAksiDataTransaksiAdmin.getSelectedItem().equals("Refresh data")) {
            kButton5.setEnabled(true);
        }
    }//GEN-LAST:event_filterAksiDataTransaksiAdminActionPerformed

    private void tabel_data_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_data_transaksiMouseClicked
        // TODO add your handling code here:
        int baris = tabel_data_transaksi.rowAtPoint(evt.getPoint());
        String tid = tabel_data_transaksi.getValueAt(baris, 0).toString();
        this.selected_detail_transaksi = tid;
    }//GEN-LAST:event_tabel_data_transaksiMouseClicked

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
        if (tgl_awal.getDate() != null && tgl_akhir.getDate() != null) {
            cariDataTranskaksi();
        } else if (tgl_awal.getDate() == null && tgl_akhir.getDate() != null) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Masukkan tanggal pada tanggal awal!");
            panel.showNotification();
        } else if (tgl_awal.getDate() != null && tgl_akhir.getDate() == null) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Masukkan tanggal pada tanggal akhirl!");
            panel.showNotification();
        } else {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Pilih rentang tanggal dahulu untuk mencari!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton8ActionPerformed

    private void tabel_riwayat_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_riwayat_transaksiMouseClicked
        // TODO add your handling code here:
        int baris = tabel_riwayat_transaksi.rowAtPoint(evt.getPoint());
        String tkd = tabel_riwayat_transaksi.getValueAt(baris, 0).toString();
        select_riwayat = tkd;
    }//GEN-LAST:event_tabel_riwayat_transaksiMouseClicked

    void history() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id history");
        tbl.addColumn("Kode struk");
        tbl.addColumn("Id kasir pertama");
        tbl.addColumn("Jumlah bayar awal");
        tbl.addColumn("Kurang bayar awal");
        tbl.addColumn("Status bayar awal");
        tbl.addColumn("Kembalian awal");
        tbl.addColumn("Waktu perubahan");
        tabel_riwayat_transaksi.setModel(tbl);
        try {
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from history_transaksi");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_hist"),
                    res.getString("kode_order"),
                    res.getString("id_user_awl"),
                    res.getString("bayar_awl"),
                    res.getString("kurang_byr_awl"),
                    res.getString("status_byr_awl"),
                    res.getString("kembalian_awl"),
                    res.getString("waktu"),});
                tabel_riwayat_transaksi.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void cariHistory() {
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String awal = String.valueOf(fm.format(tgl_awal_ht.getDate()));
        String sampai = String.valueOf(fm.format(tgl_akhir_ht.getDate()));
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Id history");
        tbl.addColumn("Kode struk");
        tbl.addColumn("Id kasir pertama");
        tbl.addColumn("Jumlah bayar awal");
        tbl.addColumn("Kurang bayar awal");
        tbl.addColumn("Status bayar awal");
        tbl.addColumn("Kembalian awal");
        tbl.addColumn("Waktu perubahan");
        tabel_riwayat_transaksi.setModel(tbl);
        try {
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from history_transaksi where waktu BETWEEN '" + awal + "' AND '" + sampai + "'");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_hist"),
                    res.getString("kode_order"),
                    res.getString("id_user_awl"),
                    res.getString("bayar_awl"),
                    res.getString("kurang_byr_awl"),
                    res.getString("status_byr_awl"),
                    res.getString("kembalian_awl"),
                    res.getString("waktu"),});
                tabel_riwayat_transaksi.setModel(tbl);
            }
            if (tbl.getRowCount() == 0) {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Data tidak ditemukan!");
                panel.showNotification();
                history();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }
    private void kButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton9ActionPerformed
        // TODO add your handling code here:
        if (tgl_awal_ht.getDate() != null && tgl_akhir_ht.getDate() != null) {
            cariHistory();
        } else if (tgl_awal_ht.getDate() == null && tgl_akhir_ht.getDate() != null) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Masukkan tanggal pada tanggal awal!");
            panel.showNotification();
        } else if (tgl_awal_ht.getDate() != null && tgl_akhir_ht.getDate() == null) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Masukkan tanggal pada tanggal akhirl!");
            panel.showNotification();
        } else {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Pilih rentang tanggal dahulu untuk mencari!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton9ActionPerformed

    private void filterAksIRiwayatTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterAksIRiwayatTransaksiActionPerformed
        // TODO add your handling code here:
        if (filterAksIRiwayatTransaksi.getSelectedItem().equals("Hapus data") || filterAksIRiwayatTransaksi.getSelectedItem().equals("Hapus semua data") || filterAksIRiwayatTransaksi.getSelectedItem().equals("Refresh data")) {
            kButton6.setEnabled(true);
        }
    }//GEN-LAST:event_filterAksIRiwayatTransaksiActionPerformed

    private void tabel_pengeluaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pengeluaranMouseClicked
        // TODO add your handling code here:
        int baris = tabel_pengeluaran.rowAtPoint(evt.getPoint());
        String tkd = tabel_pengeluaran.getValueAt(baris, 0).toString();
        String tanggal = tabel_pengeluaran.getValueAt(baris, 1).toString();
        String total = tabel_pengeluaran.getValueAt(baris, 2).toString();
        String keterangan = tabel_pengeluaran.getValueAt(baris, 3).toString();
        selected_pengeluaran = tkd;
        kode_pengeluaran_edit.setText(tkd);
        keterangan_pengeluaran_edit.setText(keterangan);
        jumlahuang_pengeluaran_edit.setText(total);
    }//GEN-LAST:event_tabel_pengeluaranMouseClicked

    private void filterPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterPengeluaranActionPerformed
        // TODO add your handling code here:
        if (filterPengeluaran.getSelectedItem().equals("Tambah pengeluaran") || filterPengeluaran.getSelectedItem().equals("Hapus pengeluaran") || filterPengeluaran.getSelectedItem().equals("Edit pengeluaran") || filterPengeluaran.getSelectedItem().equals("Refresh tabel")) {
            kButton10.setEnabled(true);
        }
    }//GEN-LAST:event_filterPengeluaranActionPerformed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
        // TODO add your handling code here:
        if (filterPengeluaran.getSelectedItem().equals("Tambah pengeluaran")) {
            formManipultionData.pengeluaran_tambah tambah = new pengeluaran_tambah();
            tambah.setVisible(true);
        } else if (filterPengeluaran.getSelectedItem().equals("Edit pengeluaran")) {
            if (selected_pengeluaran != null) {
                new formManipultionData.pengeluaran_edit().setVisible(true);
                selected_pengeluaran = null;
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap pilih data pada tabel dahulu!");
                panel.showNotification();
            }
        } else if (filterPengeluaran.getSelectedItem().equals("Hapus pengeluaran")) {
            if (selected_pengeluaran != null) {
                MessageDialog obj = new MessageDialog(this);
                obj.showMessage("Apakah ingin melanjutkan hapus data?",
                        "Data yang terhapus tidak dapat kembali lagi, anda haru inputkan ulang data jika ingin data kembali.");
                if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                    try {
                        String sql = "DELETE FROM pengeluaran WHERE kd_pengeluaran='" + selected_pengeluaran + "'";
                        Connection con = (Connection) connect.configDB();
                        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
                        Notification panel = new Notification(this, Notification.Type.SUCCESS,
                                Notification.Location.TOP_CENTER, "Berhasil dihapus!");
                        panel.showNotification();
                        pst.execute();
                        menampilkanPengeluaran(tabel_pengeluaran);
                        selected_pengeluaran = null;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di Hapus");
                    }
                }
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Harap pilih data pada tabel dahulu!");
                panel.showNotification();
            }
        } else if (filterPengeluaran.getSelectedItem().equals("Refresh tabel")) {
            menampilkanPengeluaran(tabel_pengeluaran);
        }
    }//GEN-LAST:event_kButton10ActionPerformed

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed
        // TODO add your handling code here:
        if (cariDataPengeluaranm.getDate() != null) {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String awal = String.valueOf(fm.format(cariDataPengeluaranm.getDate()));
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("kode pengeluaran");
            tbl.addColumn("tanggal pengeluaran");
            tbl.addColumn("biaya listrik");
            tbl.addColumn("biaya air");
            tbl.addColumn("biaya pewangi");
            tbl.addColumn("total");
            try {
                String sql = "SELECT * FROM pengeluaran WHERE tanggal_pengeluaran like'%" + awal + "%'";
                Connection con = (Connection) connect.configDB();
                Statement st = (Statement) con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    tbl.addRow(new Object[]{
                        rs.getString("kd_pengeluaran"),
                        rs.getString("tanggal_pengeluaran"),
                        rs.getString("biaya_listrik"),
                        rs.getString("biaya_air"),
                        rs.getString("biaya_pewangi"),
                        rs.getString("total")
                    });
                    tabel_pengeluaran.setModel(tbl);
                }
                if (tbl.getRowCount() == 0) {
                    Notification panel = new Notification(this, Notification.Type.WARNING,
                            Notification.Location.CENTER, "Data tidak ditemukan!");
                    panel.showNotification();
                }
            } catch (Exception e) {
            }
            cariDataPengeluaranm.setCalendar(null);
        } else {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Harap filter tanggal yang ingin dicari!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton11ActionPerformed

    private void tabel_paketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_paketMouseClicked
        // TODO add your handling code here:
        int baris = tabel_paket.rowAtPoint(evt.getPoint());
        String tkd = tabel_paket.getValueAt(baris, 0).toString();
        kd_paket_edit.setText(tkd);
        this.selec_paket = tkd;
        String tnama = tabel_paket.getValueAt(baris, 1).toString();
        nama_paket_edit.setText(tnama);
        String tcmb = tabel_paket.getValueAt(baris, 2).toString();
        jComboBox1_edit.setSelectedItem(tcmb);
        String tno = tabel_paket.getValueAt(baris, 3).toString();
        harga_edit.setText(tno);
    }//GEN-LAST:event_tabel_paketMouseClicked

    private void filterAksiPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterAksiPaketActionPerformed
        // TODO add your handling code here:
        if (filterAksiPaket.getSelectedItem().equals("Tambah data paket") || filterAksiPaket.getSelectedItem().equals("Hapus data paket") || filterAksiPaket.getSelectedItem().equals("Edit data paket") || filterAksiPaket.getSelectedItem().equals("Refresh Tabel")) {
            kButton7.setEnabled(true);
        }
    }//GEN-LAST:event_filterAksiPaketActionPerformed

    void notifPembukuan() {
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
    private void filterPembukuanjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterPembukuanjActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat bulan = new SimpleDateFormat("MMMM");
        Date bulanini = new Date();
        String monthh = month.format(bulanini);
        if (filterPembukuanj.getSelectedItem().equals("Januari")) {
            monthh = "01";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
            }
            bulanDipilih.setText("Januari");
        } else if (filterPembukuanj.getSelectedItem().equals("Februari")) {
            monthh = "02";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
            }
            bulanDipilih.setText("Februari");
        } else if (filterPembukuanj.getSelectedItem().equals("Maret")) {
            monthh = "03";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("Maret");
        } else if (filterPembukuanj.getSelectedItem().equals("April")) {
            monthh = "04";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("April");
        } else if (filterPembukuanj.getSelectedItem().equals("Mei")) {
            monthh = "05";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("Mei");
        } else if (filterPembukuanj.getSelectedItem().equals("Juni")) {
            monthh = "06";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("Juni");
        } else if (filterPembukuanj.getSelectedItem().equals("Juli")) {
            monthh = "07";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("Juli");
        } else if (filterPembukuanj.getSelectedItem().equals("Agustus")) {
            monthh = "08";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("Agustus");
        } else if (filterPembukuanj.getSelectedItem().equals("September")) {
            monthh = "09";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("September");
        } else if (filterPembukuanj.getSelectedItem().equals("Oktober")) {
            monthh = "10";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("Oktober");
        } else if (filterPembukuanj.getSelectedItem().equals("November")) {
            monthh = "11";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("November");
        } else {
            monthh = "12";
            try {
                String sql = "select SUM(total) AS total_pngl,month(tanggal_pengeluaran) bulan FROM pengeluaran group by bulan having bulan='" + monthh + "'";
                String sts = "sudah di ambil";
                String sql1 = "select SUM(grand_total) AS total_pemasukan,month(tgl_selesai) bulan FROM tbl_order "
                        + "where status_ambil = '" + sts + "'group by bulan having bulan='" + monthh + "'";
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
                labarg();
            } catch (Exception e) {
                notifPembukuan();
                total_pngln.setText("" + 0);
                total_pmsk.setText("" + 0);
                laba.setText("0");
                rugii.setText("0");
            }
            bulanDipilih.setText("Desember");
        }
    }//GEN-LAST:event_filterPembukuanjActionPerformed

    private void filterPembukuanjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterPembukuanjKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_filterPembukuanjKeyReleased

    private void jLabel84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel84MouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Pembukuan");
        jPanel1.setBackground(Color.WHITE);
        setColor(menuDataPembukuan);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanPembukuan);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_jLabel84MouseClicked

    private void jLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Pembukuan");
        jPanel1.setBackground(Color.WHITE);
        setColor(menuDataPembukuan);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanPembukuan);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_jLabel72MouseClicked

    private void jLabel101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseClicked
        // TODO add your handling code here:
        judulDb.setText("Riwayat Transaksi");
        jPanel1.setBackground(Color.WHITE);
        setColor(menuHistoryTransaksi);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanHistoryTransaksi);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_jLabel101MouseClicked

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        // TODO add your handling code here:
        judulDb.setText("Riwayat Transaksi");
        jPanel1.setBackground(Color.WHITE);
        setColor(menuHistoryTransaksi);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanHistoryTransaksi);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_jLabel98MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Pelanggan");
        jPanel1.setBackground(Color.WHITE);
        setColor(menuDataPelanggan);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataPelanggan);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_jLabel104MouseClicked

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Pelanggan");
        jPanel1.setBackground(Color.WHITE);
        setColor(menuDataPelanggan);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        resetColor(menuDataPaket);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataPelanggan);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_jLabel97MouseClicked

    private void jLabel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseClicked
        // TODO add your handling code here:
        new dashboard.dataKasirAdmin().setVisible(true);
    }//GEN-LAST:event_jLabel95MouseClicked

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        // TODO add your handling code here:
        new dashboard.dataKasirAdmin().setVisible(true);
    }//GEN-LAST:event_jLabel99MouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        judulDb.setText("Data Paket");
        jPanel1.setBackground(Color.WHITE);
        setColor(menuDataPaket);
        resetColor(menuDashboard);
        resetColor(menuDataKasir);
        resetColor(menuDataPelanggan);
        resetColor(menuDataTransaksi);
        resetColor(menuHistoryTransaksi);
        resetColor(menuDataPengeluaran);
        resetColor(menuDataPembukuan);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataPaket);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        new profileSetting.admin().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void namaLoginAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namaLoginAdminMouseClicked
        // TODO add your handling code here:
        new profileSetting.admin().setVisible(true);
    }//GEN-LAST:event_namaLoginAdminMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        new profileSetting.admin().setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    void colorLogout(JPanel e) {
        e.setBackground(Color.red);
    }

    public void setColor(JPanel p) { // HOVER MENU
        p.setBackground(new Color(113, 144, 245));
    }

    public void resetColor(JPanel pl) { //HOVER MENU
        pl.setBackground(new Color(255, 255, 255));
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
            java.util.logging.Logger.getLogger(dashboardAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private combobox.Combobox FilterDataKasirComboBox;
    private javax.swing.JPanel InformasiTransaksi;
    public static final javax.swing.JLabel bulanDipilih = new javax.swing.JLabel();
    private com.toedter.calendar.JDateChooser cariDataPengeluaranm;
    private javax.swing.JPanel container;
    private javax.swing.JPanel containerContent;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JLabel dataKasirLabel;
    private javax.swing.JLabel dataPelangganLabel;
    private javax.swing.JLabel dataPembukuanLabel;
    private javax.swing.JLabel dataPengeluaranLabel;
    private javax.swing.JLabel dataTransaksiLabel;
    private javax.swing.JLabel datapPaketLabel;
    private swing.TextFieldAnimation field_cari_data_pelanggan;
    private combobox.Combobox filterAksIRiwayatTransaksi;
    private combobox.Combobox filterAksiDataTransaksiAdmin;
    private combobox.Combobox filterAksiPaket;
    private combobox.Combobox filterComboBoxPelanggan;
    public static final combobox.Combobox filterPembukuanj = new combobox.Combobox();
    private combobox.Combobox filterPengeluaran;
    private javax.swing.JLabel historyTransaksiLabel;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel judulDb;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton10;
    private com.k33ptoo.components.KButton kButton11;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KButton kButton8;
    private com.k33ptoo.components.KButton kButton9;
    public static final javax.swing.JLabel laba = new javax.swing.JLabel();
    private javax.swing.JLabel logo;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuDashboard;
    private javax.swing.JPanel menuDataKasir;
    private javax.swing.JPanel menuDataPaket;
    private javax.swing.JPanel menuDataPelanggan;
    private javax.swing.JPanel menuDataPembukuan;
    private javax.swing.JPanel menuDataPengeluaran;
    private javax.swing.JPanel menuDataTransaksi;
    private javax.swing.JPanel menuHistoryTransaksi;
    public static final javax.swing.JLabel namaLoginAdmin = new javax.swing.JLabel();
    public static final javax.swing.JTextField namaLoginAdminField = new javax.swing.JTextField();
    public static final javax.swing.JLabel rugii = new javax.swing.JLabel();
    public static final javax.swing.JTable tabel_data_pelanggan = new javax.swing.JTable();
    public static final javax.swing.JTable tabel_data_transaksi = new javax.swing.JTable();
    public static final javax.swing.JTable tabel_paket = new javax.swing.JTable();
    public static final javax.swing.JTable tabel_pengeluaran = new javax.swing.JTable();
    public static final javax.swing.JTable tabel_riwayat_transaksi = new javax.swing.JTable();
    public static final javax.swing.JTable tabelkasir = new javax.swing.JTable();
    private javax.swing.JPanel tampilanDashboard;
    private javax.swing.JPanel tampilanDataKasir;
    private javax.swing.JPanel tampilanDataPaket;
    private javax.swing.JPanel tampilanDataPelanggan;
    private javax.swing.JPanel tampilanDataPengeluaran;
    private javax.swing.JPanel tampilanDataTransaksi;
    private javax.swing.JPanel tampilanHistoryTransaksi;
    private javax.swing.JPanel tampilanPembukuan;
    private javax.swing.JPanel tempatJudulUserLogin;
    private com.toedter.calendar.JDateChooser tgl_akhir;
    private com.toedter.calendar.JDateChooser tgl_akhir_ht;
    private com.toedter.calendar.JDateChooser tgl_awal;
    private com.toedter.calendar.JDateChooser tgl_awal_ht;
    public static final javax.swing.JLabel total_pmsk = new javax.swing.JLabel();
    public static final javax.swing.JLabel total_pngln = new javax.swing.JLabel();
    private swing.TextFieldAnimation txt1;
    private javax.swing.JPanel wrapperContent;
    private javax.swing.JPanel wrapperMenu;
    // End of variables declaration//GEN-END:variables
}
