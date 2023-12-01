package dashboard;

import com.barcodelib.barcode.Linear;
import notification.Notification;
import codingDashboardKasir.imageKomponenDBUtama;
import codingDashboardKasir.componenUangHariIni;
import codingDashboardKasir.componentJumlahClient;
import codingDashboardKasir.componentClientBaru;
import codingDashboardKasir.componenTransaksiDashboard;
import codingDashboardKasir.componentDashboardBesar;
import codingDashboardKasir.componentImageProfileAdmin;
import codingDashboardKasir.imageProfileAdmin;
import com.mysql.jdbc.Statement;
import connection.connect;
import static dashboard.dashboardAdmin.selected_pelanggan_id;
import static dashboard.dashboardAdmin.tabel_data_pelanggan;
import static dashboard.detailPemesanan.tabel_detail_transaksi;
import static detailDataJtextField.PelangganTR.alamat_pelanggan_form;
import static detailDataJtextField.PelangganTR.id_detail_pelanggan_form;
import static detailDataJtextField.PelangganTR.nama_pelanggan_form;
import static detailDataJtextField.PelangganTR.nomor_telfon_pelanggan_form;
import static detailDataJtextField.UserTR.alamat_kasir_form;
import static detailDataJtextField.UserTR.hakakses_detail_form;
import static detailDataJtextField.UserTR.id_detail_kasir_form;
import static detailDataJtextField.UserTR.nama_kasir_form;
import static detailDataJtextField.UserTR.nomor_telfon_kasir_form;
import static detailDataJtextField.UserTR.password_detail_form;
import static detailDataJtextField.UserTR.username_kasir_detail_form;
import static formLanjutanTransaksi.tahap_awal.field_id_pelanggan_clone;
import static formLanjutanTransaksi.tahap_awal.field_id_user_clone;
import static formLanjutanTransaksi.tahap_awal.field_kode_nota_clone;
import static formManipultionData.edtiDataPelanggan.field_alamat_pelanggan_edit;
import static formManipultionData.edtiDataPelanggan.field_id_pelanggan_edit;
import static formManipultionData.edtiDataPelanggan.field_nama_pelanggan_edit;
import static formManipultionData.edtiDataPelanggan.field_nomor_telfon_edit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import raven.glasspanepopup.GlassPanePopup;
import responsive.login_rs;
import sample.message.Message;
import sample.message.Test;
import swing.EventCallBack;
import swing.EventTextField;
import session.session;
import tableCustomize.TableCustom;
import codingDesainLaporanTransaksi.codingDesain1;
import codingDesainLaporanTransaksi.codingDesain2;
import codingDesainLaporanTransaksi.codingDesain3;
import static dashboard.laundryBelumSelesai.tb1;
import static dashboard.laundryBelumSelesai.tb2;
import static dashboard.selengkapnyaPaketDipesanKasir.paketKiloan;
import static dashboard.selengkapnyaPaketDipesanKasir.paketSatuan;
import static dashboard.selengkapnyaPelangganCardKasir.pl;
import static dashboard.selengkapnyaPelangganCardKasir.pl1;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JasperPrintManager;

public class dashboardKasir extends javax.swing.JFrame {

    static String selected_pelanggan_id;
    static String selectedkdtrs;
    static String helloworld;
    DefaultTableModel modelpj;
    DefaultTableModel modelDataPelanggan;
    public int thotal;
    public int tot_brg;
    ArrayList<String> idlist = new ArrayList<String>();

    public dashboardKasir() {

        initComponents();
        // mengunci ukuran agar tidak bisa dikecilkan
        setMinimumSize(getSize());

        // TABLE EDIT CUSTOM
        getContentPane().setBackground(Color.WHITE);
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane5, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane6, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane4, TableCustom.TableType.MULTI_LINE);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        menampilkan_data_pelanggan(tabel_data_pelanggan_2);
        tampil_data_penjualan(tabel_penjualan);
        tampil_data_barang(tabel_barang);
        menampilkan_data_pelanggan(table_data_pelanggan_kasir);
        menampilkan_data_pelanggan_data_transaksi(tabel_data_transaksi_kasir);

        setTitle("DASHBOARD KASIR");
        GlassPanePopup.install(this);
        getContentPane().setBackground(Color.WHITE);

        // form data pelanggan
        //menampilkan_data_pelanggan();
        id_otomatis_pelanggan();
        search_data_pelanggan();
        search_data_pelanggan2();

        // form transaksi
        id_kasir_tr();
        kodeTransaksiOtomatis();
        reset_nambah_krj();
        resetKeranjang();
        a();

        // Data Transaksi
        search_data_transaksi();

        field_harga_paket.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input1 = Integer.parseInt(field_harga_paket.getText());
                    int input2 = Integer.parseInt(field_jumlah_barang.getText());
                    int hasil = input1 * input2;
                    field_subtotal.setText("" + hasil);
                } catch (NumberFormatException ex) {
                    //field_subtotal.setText("");
                }
            }
        });
        field_jumlah_barang.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input1 = Integer.parseInt(field_harga_paket.getText());
                    int input2 = Integer.parseInt(field_jumlah_barang.getText());
                    int hasil = input1 * input2;
                    field_subtotal.setText("" + hasil);
                } catch (NumberFormatException ex) {
                    //hasilLabel.setText("");
                }
            }
        });

        field_total_harga.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input2 = Integer.parseInt(field_total_harga.getText());
                    int input1 = Integer.parseInt(field_bayar.getText());
                    int hasil = input1 - input2;
                    int lain = input1 - input2;
                    if (hasil == 0) {
                        field_status_bayar.setText("Lunas");
                        field_sisa_bayar.setText("" + hasil);
                        field_kembalian.setText("" + hasil);
                    } else if (input1 > input2) {
                        field_status_bayar.setText("Lunas");
                        field_sisa_bayar.setText("" + 0);
                        field_kembalian.setText("" + lain);
                    } else if (hasil == input2) {
                        field_status_bayar.setText("Belum bayar");
                        field_sisa_bayar.setText("" + hasil);
                        field_kembalian.setText("0");
                    } else if (hasil < input2) {
                        field_status_bayar.setText("Kurang");
                        field_sisa_bayar.setText("" + hasil);
                        field_kembalian.setText("" + 0);
                    }
                } catch (NumberFormatException ex) {
                    //field_subtotal.setText("");
                }
            }
        });
        field_bayar.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input2 = Integer.parseInt(field_total_harga.getText());
                    int input1 = Integer.parseInt(field_bayar.getText());
                    int hasil = input1 - input2;
                    int lain = input1 - input2;
                    if (hasil == 0) {
                        field_status_bayar.setText("Lunas");
                        field_sisa_bayar.setText("" + hasil);
                        field_kembalian.setText("" + hasil);
                    } else if (input1 > input2) {
                        field_status_bayar.setText("Lunas");
                        field_sisa_bayar.setText("" + 0);
                        field_kembalian.setText("" + lain);
                    } else if (hasil == input2) {
                        field_status_bayar.setText("Belum Bayar");
                        field_sisa_bayar.setText("" + hasil);
                        field_kembalian.setText("0");
                    } else if (hasil < input2) {
                        field_status_bayar.setText("Kurang");
                        field_sisa_bayar.setText("" + Math.abs(hasil));
                        field_kembalian.setText("" + 0);
                    }
                } catch (NumberFormatException ex) {
                    //hasilLabel.setText("");
                }
            }
        });

        // Data Transaksi
        pembayaran_dt.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input2 = Integer.parseInt(pembayaran_dt.getText());
                    int input1 = Integer.parseInt(sisa_bayar_dt.getText());
                    int hasil = input1 - input2;
                    int lain = input2 - input1;
                    if (hasil == 0) {
                        status_bayar_dt.setText("Lunas");
                        sisa_bayar_dt.setText("" + hasil);
                        kembalian_pembayaran_dt.setText("" + hasil);
                        status_bayar_dt.setForeground(Color.GREEN);
                    } else if (input2 > input1) {
                        status_bayar_dt.setText("Lunas");
                        sisa_bayar_dt.setText("" + 0);
                        kembalian_pembayaran_dt.setText("" + lain);
                        status_bayar_dt.setForeground(Color.GREEN);

                    } else if (hasil == input2) {
                        status_bayar_dt.setText("Belum Bayar");
                        sisa_bayar_dt.setText("" + hasil);
                        kembalian_pembayaran_dt.setText("0");
                        status_bayar_dt.setForeground(Color.RED);
                    } else if (hasil < input2) {
                        status_bayar_dt.setText("Kurang");
                        sisa_bayar_dt.setText("" + Math.abs(hasil));
                        kembalian_pembayaran_dt.setText("" + 0);
                        status_bayar_dt.setForeground(Color.RED);
                    }
                } catch (NumberFormatException ex) {
                    //hasilLabel.setText("");
                }
            }
        });
        sisa_bayar_dt.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input2 = Integer.parseInt(pembayaran_dt.getText());
                    int input1 = Integer.parseInt(sisa_bayar_dt.getText());
                    int hasil = input1 - input2;
                    int lain = input2 - input1;
                    if (hasil == 0) {
                        status_bayar_dt.setText("Lunas");
                        sisa_bayar_dt.setText("" + hasil);
                        kembalian_pembayaran_dt.setText("" + hasil);
                        status_bayar_dt.setForeground(Color.GREEN);
                    } else if (input2 > input1) {
                        status_bayar_dt.setText("Lunas");
                        sisa_bayar_dt.setText("" + 0);
                        kembalian_pembayaran_dt.setText("" + lain);
                        status_bayar_dt.setForeground(Color.GREEN);
                    } else if (hasil == input2) {
                        status_bayar_dt.setText("Belum Bayar");
                        sisa_bayar_dt.setText("" + hasil);
                        kembalian_pembayaran_dt.setText("0");
                        status_bayar_dt.setForeground(Color.RED);
                    } else if (hasil < input2) {
                        status_bayar_dt.setText("Kurang");
                        sisa_bayar_dt.setText("" + Math.abs(hasil));
                        kembalian_pembayaran_dt.setText("" + 0);
                        status_bayar_dt.setForeground(Color.RED);
                    }
                } catch (NumberFormatException ex) {
                    //hasilLabel.setText("");
                }
            }
        });
        // Tanggal Otomatis
        tanggalOtomatis();

        // method untuk dashboard
        transaksiHariini();
        jumlahPelangganBaru();
        ngitung_jmkl_odrpkt_hrian();
        ngitung_jmkl_odrpkt_satuan();
        total_paket_skrg();
        laundryBelumSelesai(tb2);
        laundrySelesai(tb1);

        //tombl
        //kButton6.setEnabled(false);
        // harus angka
        field_notel_tr.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(field_notel_tr.getText());
                } catch (NumberFormatException ex) {
                    if (field_notel_tr.getText().isEmpty()) {
                        System.out.println("");
                    } else {
                        harusAngka();
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        wrapperMenu = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        menuDashboard = new javax.swing.JPanel();
        dashboardLabel = new javax.swing.JLabel();
        menuTransaksi = new javax.swing.JPanel();
        menuTransaksiLabel = new javax.swing.JLabel();
        menuDatatransaksi = new javax.swing.JPanel();
        datatransaksiLabel = new javax.swing.JLabel();
        menuDataPelanggan = new javax.swing.JPanel();
        dataPelangganLabel = new javax.swing.JLabel();
        menuHistoryTransaksi = new javax.swing.JPanel();
        wrapperKontent = new javax.swing.JPanel();
        tempatJuduldanUser = new javax.swing.JPanel();
        judulDb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tanggalOtomatis = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        containerContent = new javax.swing.JPanel();
        tampilanDashboardUtama = new javax.swing.JPanel();
        jPanel1 = new imageKomponenDBUtama();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new componenUangHariIni();
        jPanel2 = new imageKomponenDBUtama();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new componentJumlahClient();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new imageKomponenDBUtama();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new componentClientBaru();
        jLabel16 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jPanel7 = new componentDashboardBesar();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        kButton1 = new com.k33ptoo.components.KButton();
        jPanel8 = new componentImageProfileAdmin();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        jLabel27 = new javax.swing.JLabel();
        tampilanTransaksi = new javax.swing.JPanel();
        containerTransaksi = new javax.swing.JPanel();
        tampilanAwalTransaksi = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        kButton4 = new com.k33ptoo.components.KButton();
        field_cari_data_pelanggan = new swing.TextFieldAnimation();
        jLabel33 = new javax.swing.JLabel();
        cmd3 = new button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputPelanggan = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        field_id_pelanggan_tr = new textfield.TextField();
        kButton5 = new com.k33ptoo.components.KButton();
        field_alamat_pelanggan_tr = new textfield.TextField();
        field_notel_tr = new textfield.TextField();
        field_nama_pelanggan_tr = new textfield.TextField();
        jLabel35 = new javax.swing.JLabel();
        lanjutTransaksi1 = new javax.swing.JPanel();
        field_kode_nota = new textfield.TextField();
        field_id_user = new textfield.TextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        kButton3 = new com.k33ptoo.components.KButton();
        lanjutTransaksi2 = new javax.swing.JPanel();
        field_harga_paket = new textfield.TextField();
        jLabel36 = new javax.swing.JLabel();
        field_keterangan = new textfield.TextField();
        field_subtotal = new textfield.TextField();
        jLabel37 = new javax.swing.JLabel();
        field_jumlah_barang = new textfield.TextField();
        jLabel80 = new javax.swing.JLabel();
        paketDipilih = new javax.swing.JLabel();
        kButton7 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lanjutTransaksi3 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        field_bayar = new textfield.TextField();
        field_status_bayar = new textfield.TextField();
        field_sisa_bayar = new textfield.TextField();
        jLabel51 = new javax.swing.JLabel();
        field_kembalian = new textfield.TextField();
        jLabel83 = new javax.swing.JLabel();
        field_total_harga = new javax.swing.JTextField();
        norak = new combobox.Combobox();
        perkiraanSelesai = new combobox.Combobox();
        cmd6 = new button.Button();
        cmd1 = new button.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_penjualan = new javax.swing.JTable();
        tgl_sls = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tampilanDataTransaksi = new javax.swing.JPanel();
        containerDataTransaksi = new javax.swing.JPanel();
        tahapPertama = new javax.swing.JPanel();
        kButton11 = new com.k33ptoo.components.KButton();
        field_cari_data_transaksi = new swing.TextFieldAnimation();
        field_lanjut_pengembalian = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jLabel107 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tahapKedua = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        id_pelanggan_dt = new textfield.TextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        id_kasir_dt = new textfield.TextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        tanggal_pesan_dt = new textfield.TextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        tanggal_selesai_dt = new textfield.TextField();
        status_ambil_dt = new combobox.Combobox();
        kButton12 = new com.k33ptoo.components.KButton();
        jLabel66 = new javax.swing.JLabel();
        tahapKetiga = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        total_harga_dt = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        sisa_bayar_dt = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        status_bayar_dt = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        pembayaran_dt = new textfield.TextField();
        kembalian_pembayaran_dt = new textfield.TextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jumlah_bayar_dt = new textfield.TextField();
        kembalian_dt = new textfield.TextField();
        jLabel79 = new javax.swing.JLabel();
        kButton13 = new com.k33ptoo.components.KButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        nomorak = new javax.swing.JTextField();
        tampilanDataPelanggan = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        comboboxDataPelanggan = new combobox.Combobox();
        kButton6 = new com.k33ptoo.components.KButton();
        field_cari_data_pelanggan2 = new swing.TextFieldAnimation();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        wrapperMenu.setBackground(new java.awt.Color(255, 255, 255));
        wrapperMenu.setForeground(new java.awt.Color(0, 51, 255));
        wrapperMenu.setPreferredSize(new java.awt.Dimension(192, 610));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/logo-JaqWPywCz-transformed (1).png"))); // NOI18N

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

        menuTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        menuTransaksi.setPreferredSize(new java.awt.Dimension(100, 36));

        menuTransaksiLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        menuTransaksiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money-exchange_1.png"))); // NOI18N
        menuTransaksiLabel.setText("Transaksi");
        menuTransaksiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuTransaksiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTransaksiLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuTransaksiLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuTransaksiLayout = new javax.swing.GroupLayout(menuTransaksi);
        menuTransaksi.setLayout(menuTransaksiLayout);
        menuTransaksiLayout.setHorizontalGroup(
            menuTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTransaksiLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(menuTransaksiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuTransaksiLayout.setVerticalGroup(
            menuTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuTransaksiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuDatatransaksi.setBackground(new java.awt.Color(255, 255, 255));
        menuDatatransaksi.setPreferredSize(new java.awt.Dimension(0, 36));

        datatransaksiLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        datatransaksiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/monitor (1).png"))); // NOI18N
        datatransaksiLabel.setText("Pengambilan Cucian");
        datatransaksiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datatransaksiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatransaksiLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                datatransaksiLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menuDatatransaksiLayout = new javax.swing.GroupLayout(menuDatatransaksi);
        menuDatatransaksi.setLayout(menuDatatransaksiLayout);
        menuDatatransaksiLayout.setHorizontalGroup(
            menuDatatransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuDatatransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(datatransaksiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuDatatransaksiLayout.setVerticalGroup(
            menuDatatransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(datatransaksiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        menuDataPelanggan.setBackground(new java.awt.Color(255, 255, 255));

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

        menuHistoryTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        menuHistoryTransaksi.setPreferredSize(new java.awt.Dimension(0, 36));

        javax.swing.GroupLayout menuHistoryTransaksiLayout = new javax.swing.GroupLayout(menuHistoryTransaksi);
        menuHistoryTransaksi.setLayout(menuHistoryTransaksiLayout);
        menuHistoryTransaksiLayout.setHorizontalGroup(
            menuHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        menuHistoryTransaksiLayout.setVerticalGroup(
            menuHistoryTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDatatransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(menuDataPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuHistoryTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(menuDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDatatransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuHistoryTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout wrapperMenuLayout = new javax.swing.GroupLayout(wrapperMenu);
        wrapperMenu.setLayout(wrapperMenuLayout);
        wrapperMenuLayout.setHorizontalGroup(
            wrapperMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(wrapperMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wrapperMenuLayout.setVerticalGroup(
            wrapperMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperMenuLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(wrapperMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(wrapperMenuLayout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(110, Short.MAX_VALUE)))
        );

        wrapperKontent.setBackground(new java.awt.Color(255, 255, 255));

        tempatJuduldanUser.setBackground(new java.awt.Color(255, 255, 255));

        judulDb.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        judulDb.setText("Dashboard");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings (1).png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        namaLoginKasir.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        namaLoginKasir.setText("Agung Kurniawan");
        namaLoginKasir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        namaLoginKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                namaLoginKasirMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/man_1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(131, 193, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(131, 193, 255));
        jLabel3.setText("Kasir Laundry");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tanggalOtomatis.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tanggalOtomatis.setForeground(new java.awt.Color(1, 76, 167));
        tanggalOtomatis.setText("04 May 2023");
        tanggalOtomatis.setBorder(null);
        tanggalOtomatis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalOtomatisActionPerformed(evt);
            }
        });

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/calendar.png"))); // NOI18N

        jLabel82.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(200, 208, 218));
        jLabel82.setText("Tanggal");

        profileKS.setForeground(new java.awt.Color(255, 255, 255));
        profileKS.setBorder(null);
        profileKS.setCaretColor(new java.awt.Color(255, 255, 255));
        profileKS.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tempatJuduldanUserLayout = new javax.swing.GroupLayout(tempatJuduldanUser);
        tempatJuduldanUser.setLayout(tempatJuduldanUserLayout);
        tempatJuduldanUserLayout.setHorizontalGroup(
            tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tempatJuduldanUserLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(judulDb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profileKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalOtomatis, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaLoginKasir)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(25, 25, 25))
        );
        tempatJuduldanUserLayout.setVerticalGroup(
            tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tempatJuduldanUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel81)
                    .addGroup(tempatJuduldanUserLayout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addGap(0, 0, 0)
                        .addComponent(tanggalOtomatis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
            .addGroup(tempatJuduldanUserLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tempatJuduldanUserLayout.createSequentialGroup()
                        .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(judulDb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profileKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(tempatJuduldanUserLayout.createSequentialGroup()
                        .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(tempatJuduldanUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(namaLoginKasir))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        containerContent.setBackground(new java.awt.Color(102, 204, 0));
        containerContent.setLayout(new java.awt.CardLayout());

        tampilanDashboardUtama.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel5.setText("Hasil Uang Hari Ini");

        jLabel7.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel7.setText("150000");

        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel6.setText("Rp.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );

        jPanel2.setBackground(new java.awt.Color(51, 0, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(316, 184));

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel8.setText("Jumlah Pelanggan");

        jLabel9.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel9.setText("Pelanggan");

        jLabel10.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel10.setText("360");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(51, 51, 255));
        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Selengkapnya >>>");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addGap(47, 47, 47))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jLabel11.setText("Paket Dipesan");

        jLabel13.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel13.setText("+");

        jumlahPaketDipesan.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jumlahPaketDipesan.setText("300");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel16.setBackground(new java.awt.Color(51, 51, 255));
        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 255));
        jLabel16.setText("Selengkapnya >>>");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel108.setText("Kiloan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jumlahPaketDipesan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel108)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jumlahPaketDipesan)
                            .addComponent(jLabel108))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addGap(48, 48, 48))
        );

        jPanel7.setBackground(new java.awt.Color(255, 0, 204));

        jLabel17.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Transaksi mudah pada pelanggan");

        jLabel18.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel18.setText("Transaksi Pelanggan");

        jLabel19.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel19.setText("Pelaksanaan transaksi menjadi lebih mudah,");

        jLabel20.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel20.setText("beserta penjelasan kinerja dari fitur transaksi, ");

        jLabel21.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel21.setText("klik tombol dibawah untuk melakukan transaksi");

        jLabel22.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel22.setText("dengan pelanggan baru atau sudah terdaftar.");

        kButton1.setText("Transaksi Sekarang");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(102, 153, 255));
        kButton1.setkBorderRadius(20);
        kButton1.setkEndColor(new java.awt.Color(102, 153, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(0, 0, 255));
        kButton1.setkPressedColor(new java.awt.Color(102, 153, 255));
        kButton1.setkSelectedColor(new java.awt.Color(102, 153, 255));
        kButton1.setkStartColor(new java.awt.Color(102, 153, 255));
        kButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kButton1MouseClicked(evt);
            }
        });
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(jLabel21)
                .addGap(0, 0, 0)
                .addComponent(jLabel22)
                .addGap(27, 27, 27)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 0));

        jLabel23.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel23.setText("Laundry Belum Selesai");

        jLabel24.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel24.setText("Anda bisa melihat laundry yang");

        jLabel25.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel25.setText("masih belum selesai dan laundry");

        kButton2.setText("Lihat");
        kButton2.setBorderPainted(false);
        kButton2.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        kButton2.setkBackGroundColor(new java.awt.Color(102, 153, 255));
        kButton2.setkEndColor(new java.awt.Color(102, 153, 255));
        kButton2.setkHoverEndColor(new java.awt.Color(51, 51, 255));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(51, 51, 255));
        kButton2.setkPressedColor(new java.awt.Color(102, 153, 255));
        kButton2.setkSelectedColor(new java.awt.Color(102, 153, 255));
        kButton2.setkStartColor(new java.awt.Color(102, 153, 255));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel27.setText("sudah selesai.");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(59, 59, 59))
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                        .addGap(46, 46, 46))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(67, 67, 67)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout tampilanDashboardUtamaLayout = new javax.swing.GroupLayout(tampilanDashboardUtama);
        tampilanDashboardUtama.setLayout(tampilanDashboardUtamaLayout);
        tampilanDashboardUtamaLayout.setHorizontalGroup(
            tampilanDashboardUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDashboardUtamaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tampilanDashboardUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tampilanDashboardUtamaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tampilanDashboardUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        tampilanDashboardUtamaLayout.setVerticalGroup(
            tampilanDashboardUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanDashboardUtamaLayout.createSequentialGroup()
                .addGroup(tampilanDashboardUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tampilanDashboardUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        containerContent.add(tampilanDashboardUtama, "card2");

        tampilanTransaksi.setBackground(new java.awt.Color(255, 255, 255));

        containerTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        containerTransaksi.setPreferredSize(new java.awt.Dimension(503, 100));
        containerTransaksi.setLayout(new java.awt.CardLayout());

        tampilanAwalTransaksi.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel29.setText("Cari data pelanggan untuk transaksi, jika ada tekan");

        jLabel30.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel30.setText("data table lalu tekan tombol lanjut transaksi");

        jLabel31.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel31.setText("Input data pelanggan baru dan berlanjut ke transaksi");

        jLabel32.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel32.setText("jika data belum terdaftar.");

        kButton4.setText("Klik Disini");
        kButton4.setBorderPainted(false);
        kButton4.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        kButton4.setkAllowTab(true);
        kButton4.setkBackGroundColor(new java.awt.Color(227, 8, 143));
        kButton4.setkEndColor(new java.awt.Color(227, 8, 143));
        kButton4.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(0, 0, 255));
        kButton4.setkPressedColor(new java.awt.Color(102, 153, 255));
        kButton4.setkSelectedColor(new java.awt.Color(102, 153, 255));
        kButton4.setkStartColor(new java.awt.Color(102, 153, 255));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        kButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kButton4KeyPressed(evt);
            }
        });

        field_cari_data_pelanggan.setBackground(new java.awt.Color(245, 245, 245));
        field_cari_data_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_cari_data_pelangganActionPerformed(evt);
            }
        });

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/client.png"))); // NOI18N

        cmd3.setBackground(new java.awt.Color(0, 102, 255));
        cmd3.setForeground(new java.awt.Color(245, 245, 245));
        cmd3.setText("Lanjutkan Transaksi");
        cmd3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cmd3.setRippleColor(new java.awt.Color(255, 255, 255));
        cmd3.setShadowColor(new java.awt.Color(30, 180, 114));
        cmd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd3ActionPerformed(evt);
            }
        });

        tabel_data_pelanggan_2.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_data_pelanggan_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_data_pelanggan_2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_data_pelanggan_2);

        javax.swing.GroupLayout tampilanAwalTransaksiLayout = new javax.swing.GroupLayout(tampilanAwalTransaksi);
        tampilanAwalTransaksi.setLayout(tampilanAwalTransaksiLayout);
        tampilanAwalTransaksiLayout.setHorizontalGroup(
            tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanAwalTransaksiLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(field_cari_data_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmd3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(tampilanAwalTransaksiLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(150, 150, 150)
                .addGroup(tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanAwalTransaksiLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanAwalTransaksiLayout.createSequentialGroup()
                        .addGroup(tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanAwalTransaksiLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(80, 80, 80))
                            .addComponent(kButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107))))
        );
        tampilanAwalTransaksiLayout.setVerticalGroup(
            tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanAwalTransaksiLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(field_cari_data_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tampilanAwalTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilanAwalTransaksiLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(cmd3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        containerTransaksi.add(tampilanAwalTransaksi, "card2");

        inputPelanggan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel34.setText("Masukkan data pelanggan di bawah :");

        field_id_pelanggan_tr.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        field_id_pelanggan_tr.setEnabled(false);
        field_id_pelanggan_tr.setLabelText("ID Pelanggan");
        field_id_pelanggan_tr.setPreferredSize(new java.awt.Dimension(375, 46));
        field_id_pelanggan_tr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_id_pelanggan_trMouseClicked(evt);
            }
        });

        kButton5.setText("Simpan dan Lanjut");
        kButton5.setBorderPainted(false);
        kButton5.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        kButton5.setkBackGroundColor(new java.awt.Color(0, 0, 255));
        kButton5.setkBorderRadius(20);
        kButton5.setkEndColor(new java.awt.Color(0, 0, 255));
        kButton5.setkHoverEndColor(new java.awt.Color(102, 153, 255));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(102, 153, 255));
        kButton5.setkPressedColor(new java.awt.Color(0, 0, 255));
        kButton5.setkSelectedColor(new java.awt.Color(0, 0, 255));
        kButton5.setkStartColor(new java.awt.Color(0, 0, 255));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        field_alamat_pelanggan_tr.setLabelText("Alamat Pelanggan");

        field_notel_tr.setLabelText("Nomor Pelanggan");

        field_nama_pelanggan_tr.setLabelText("Nama Pelanggan");

        jLabel35.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel35.setText("Kembali");
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inputPelangganLayout = new javax.swing.GroupLayout(inputPelanggan);
        inputPelanggan.setLayout(inputPelangganLayout);
        inputPelangganLayout.setHorizontalGroup(
            inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPelangganLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPelangganLayout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(650, 650, 650))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPelangganLayout.createSequentialGroup()
                        .addGroup(inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(inputPelangganLayout.createSequentialGroup()
                                .addGroup(inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(field_nama_pelanggan_tr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(field_id_pelanggan_tr, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(128, 128, 128)
                                .addGroup(inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(field_alamat_pelanggan_tr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(field_notel_tr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(125, 125, 125))))
            .addGroup(inputPelangganLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel35)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        inputPelangganLayout.setVerticalGroup(
            inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPelangganLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel35)
                .addGap(46, 46, 46)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addGroup(inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_id_pelanggan_tr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_alamat_pelanggan_tr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(inputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_notel_tr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_nama_pelanggan_tr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        containerTransaksi.add(inputPelanggan, "card3");

        lanjutTransaksi1.setBackground(new java.awt.Color(255, 255, 255));

        field_id_pelanggan.setEnabled(false);
        field_id_pelanggan.setLabelText("ID Pelanggan");
        field_id_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_id_pelangganMouseClicked(evt);
            }
        });

        field_kode_nota.setEnabled(false);
        field_kode_nota.setLabelText("Kode Transaksi");
        field_kode_nota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_kode_notaMouseClicked(evt);
            }
        });

        field_id_user.setEnabled(false);
        field_id_user.setLabelText("ID Anda ");
        field_id_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_id_userMouseClicked(evt);
            }
        });
        field_id_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_id_userActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel38.setText("ID Pelanggan");

        jLabel39.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel39.setText("ID Pelanggan pada kolom dibawah adalah pelanggan");

        jLabel40.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel40.setText("yang akan melakukan transaksi");

        jLabel41.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel41.setText("Kode Transaksi");

        jLabel42.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel42.setText("Pada Field dibawah adalah kode transaksi yang akan");

        jLabel43.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel43.setText("tampil pada nota dan kunci data transaksi.");

        jLabel44.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel44.setText("ID Anda Sebagai Kasir");

        jLabel45.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel45.setText("ID anda akan tampil pada data dan nota transaksi");

        jLabel46.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel46.setText("sehingga admin tahu bahwa anda telah melakukan transaksi");

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconJoptionPane/menu.png"))); // NOI18N
        jLabel47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconJoptionPane/menu.png"))); // NOI18N
        jLabel48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel49.setText("Kembali");
        jLabel49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });

        kButton3.setText("Lanjutkan");
        kButton3.setBorderPainted(false);
        kButton3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton3.setkBackGroundColor(new java.awt.Color(227, 8, 143));
        kButton3.setkEndColor(new java.awt.Color(227, 8, 143));
        kButton3.setkHoverEndColor(new java.awt.Color(227, 20, 143));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(0, 150, 255));
        kButton3.setkPressedColor(new java.awt.Color(0, 102, 255));
        kButton3.setkSelectedColor(new java.awt.Color(0, 102, 255));
        kButton3.setkStartColor(new java.awt.Color(0, 102, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lanjutTransaksi1Layout = new javax.swing.GroupLayout(lanjutTransaksi1);
        lanjutTransaksi1.setLayout(lanjutTransaksi1Layout);
        lanjutTransaksi1Layout.setHorizontalGroup(
            lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel49)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                        .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(173, 173, 173))
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(117, 117, 117))
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(field_id_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGap(90, 90, 90)
                        .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(149, 149, 149))
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(52, 52, 52))
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(field_kode_nota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25)))
                        .addGap(166, 166, 166))
                    .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(633, 633, 633))
                    .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                        .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(303, 303, 303))
                            .addComponent(field_id_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(362, 362, 362)))
                        .addGap(191, 191, 191))))
        );
        lanjutTransaksi1Layout.setVerticalGroup(
            lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(field_id_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel47)))
                    .addGroup(lanjutTransaksi1Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(field_kode_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addGap(0, 0, 0)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lanjutTransaksi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(field_id_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(38, 38, 38)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        containerTransaksi.add(lanjutTransaksi1, "card5");

        lanjutTransaksi2.setBackground(new java.awt.Color(255, 255, 255));

        field_harga_paket.setEnabled(false);
        field_harga_paket.setLabelText("Harga Paket");
        field_harga_paket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_harga_paketMouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel36.setText("Pilih / tekan data paket yang dipilh pelanggan lalu isi form dibawah.");

        field_keterangan.setLabelText("Keterangan Barang (Opsional)");
        field_keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_keteranganActionPerformed(evt);
            }
        });

        field_subtotal.setEnabled(false);
        field_subtotal.setLabelText("Subtotal Harga");
        field_subtotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_subtotalMouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel37.setText("Kembali");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        field_jumlah_barang.setLabelText("Masukkan Jumlah Kuantitas");

        jLabel80.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel80.setText("Paket yang dipilih :");

        paketDipilih.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        paketDipilih.setForeground(new java.awt.Color(0, 102, 255));
        paketDipilih.setText(". . . .");

        kButton7.setText("Simpan di Keranjang");
        kButton7.setBorderPainted(false);
        kButton7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton7.setkBackGroundColor(new java.awt.Color(227, 8, 143));
        kButton7.setkEndColor(new java.awt.Color(227, 8, 143));
        kButton7.setkHoverEndColor(new java.awt.Color(227, 8, 155));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(0, 150, 255));
        kButton7.setkPressedColor(new java.awt.Color(0, 102, 255));
        kButton7.setkSelectedColor(new java.awt.Color(0, 102, 255));
        kButton7.setkStartColor(new java.awt.Color(0, 102, 255));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        kButton8.setText("Lanjutkan");
        kButton8.setBorderPainted(false);
        kButton8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton8.setkBackGroundColor(new java.awt.Color(3, 201, 136));
        kButton8.setkEndColor(new java.awt.Color(3, 201, 136));
        kButton8.setkHoverEndColor(new java.awt.Color(3, 201, 150));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(3, 201, 150));
        kButton8.setkPressedColor(new java.awt.Color(3, 201, 136));
        kButton8.setkSelectedColor(new java.awt.Color(3, 201, 136));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabel_barang);

        javax.swing.GroupLayout lanjutTransaksi2Layout = new javax.swing.GroupLayout(lanjutTransaksi2);
        lanjutTransaksi2.setLayout(lanjutTransaksi2Layout);
        lanjutTransaksi2Layout.setHorizontalGroup(
            lanjutTransaksi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lanjutTransaksi2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(lanjutTransaksi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi2Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paketDipilih, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(lanjutTransaksi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi2Layout.createSequentialGroup()
                        .addComponent(kButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                    .addComponent(field_harga_paket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_keterangan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_jumlah_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(lanjutTransaksi2Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(49, 49, 49))
            .addGroup(lanjutTransaksi2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lanjutTransaksi2Layout.setVerticalGroup(
            lanjutTransaksi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lanjutTransaksi2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel37)
                .addGap(33, 33, 33)
                .addGroup(lanjutTransaksi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel80)
                    .addComponent(paketDipilih))
                .addGap(18, 18, 18)
                .addGroup(lanjutTransaksi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi2Layout.createSequentialGroup()
                        .addComponent(field_harga_paket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_jumlah_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(lanjutTransaksi2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );

        containerTransaksi.add(lanjutTransaksi2, "card4");

        lanjutTransaksi3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel50.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel50.setText("Tabel disamping adalah paket cuci yang dipilih oleh pelanggan.");

        field_bayar.setLabelText("Masukkan Pembayaran Pelanggan");

        field_status_bayar.setEnabled(false);
        field_status_bayar.setLabelText("Status Bayar");

        field_sisa_bayar.setEnabled(false);
        field_sisa_bayar.setLabelText("Sisa Harus Dibayar Oleh Client");

        jLabel51.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel51.setText("Kembali");
        jLabel51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });

        field_kembalian.setEnabled(false);
        field_kembalian.setLabelText("Kembalian");
        field_kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_kembalianActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel83.setText("TOTAL HARGA :");

        field_total_harga.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        field_total_harga.setBorder(null);

        norak.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        norak.setSelectedIndex(-1);
        norak.setLabeText("Pilih Nomor Rak");

        perkiraanSelesai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 Hari", "2 Hari", "3 Hari", "4 Hari", "5 Hari", "6 Hari", "7 Hari" }));
        perkiraanSelesai.setSelectedIndex(-1);
        perkiraanSelesai.setLabeText("Perkiraan Selesai Laundry");
        perkiraanSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perkiraanSelesaiActionPerformed(evt);
            }
        });

        cmd6.setBackground(new java.awt.Color(29, 162, 253));
        cmd6.setForeground(new java.awt.Color(245, 245, 245));
        cmd6.setText("Simpan Transaksi");
        cmd6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cmd6.setRippleColor(new java.awt.Color(255, 255, 255));
        cmd6.setShadowColor(new java.awt.Color(29, 162, 253));
        cmd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd6ActionPerformed(evt);
            }
        });

        cmd1.setBackground(new java.awt.Color(253, 83, 83));
        cmd1.setForeground(new java.awt.Color(245, 245, 245));
        cmd1.setText("Hapus Paket");
        cmd1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cmd1.setRippleColor(new java.awt.Color(255, 255, 255));
        cmd1.setShadowColor(new java.awt.Color(253, 83, 83));
        cmd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd1ActionPerformed(evt);
            }
        });

        tabel_penjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabel_penjualan);

        tgl_sls.setEnabled(false);
        tgl_sls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_slsActionPerformed(evt);
            }
        });

        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout lanjutTransaksi3Layout = new javax.swing.GroupLayout(lanjutTransaksi3);
        lanjutTransaksi3.setLayout(lanjutTransaksi3Layout);
        lanjutTransaksi3Layout.setHorizontalGroup(
            lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                                .addComponent(jLabel83)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                                .addComponent(cmd6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmd1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))))
                .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(norak, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perkiraanSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(field_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_status_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_sisa_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tgl_sls, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(141, 141, 141))
        );
        lanjutTransaksi3Layout.setVerticalGroup(
            lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addGap(22, 22, 22)
                .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel83)
                    .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(field_total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi3Layout.createSequentialGroup()
                        .addComponent(norak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(perkiraanSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(field_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(field_status_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(field_sisa_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(field_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lanjutTransaksi3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tgl_sls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addGap(23, 23, 23))
        );

        containerTransaksi.add(lanjutTransaksi3, "card6");

        javax.swing.GroupLayout tampilanTransaksiLayout = new javax.swing.GroupLayout(tampilanTransaksi);
        tampilanTransaksi.setLayout(tampilanTransaksiLayout);
        tampilanTransaksiLayout.setHorizontalGroup(
            tampilanTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );
        tampilanTransaksiLayout.setVerticalGroup(
            tampilanTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        containerContent.add(tampilanTransaksi, "card3");

        tampilanDataTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        tampilanDataTransaksi.setLayout(new java.awt.CardLayout());

        containerDataTransaksi.setLayout(new java.awt.CardLayout());

        tahapPertama.setBackground(new java.awt.Color(255, 255, 255));

        kButton11.setText("Lakukan Pengembalian");
        kButton11.setBorderPainted(false);
        kButton11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton11.setkBackGroundColor(new java.awt.Color(227, 8, 143));
        kButton11.setkEndColor(new java.awt.Color(227, 8, 143));
        kButton11.setkHoverEndColor(new java.awt.Color(102, 204, 0));
        kButton11.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton11.setkHoverStartColor(new java.awt.Color(102, 204, 0));
        kButton11.setkIndicatorColor(new java.awt.Color(0, 255, 0));
        kButton11.setkPressedColor(new java.awt.Color(0, 102, 255));
        kButton11.setkSelectedColor(new java.awt.Color(0, 102, 255));
        kButton11.setkStartColor(new java.awt.Color(0, 102, 255));
        kButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton11ActionPerformed(evt);
            }
        });

        field_cari_data_transaksi.setBackground(new java.awt.Color(245, 245, 245));
        field_cari_data_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_cari_data_transaksiActionPerformed(evt);
            }
        });

        field_lanjut_pengembalian.setForeground(new java.awt.Color(255, 255, 255));
        field_lanjut_pengembalian.setText("jTextField1");
        field_lanjut_pengembalian.setBorder(null);

        tabel_data_transaksi_kasir.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_data_transaksi_kasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_data_transaksi_kasirMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabel_data_transaksi_kasir);

        jLabel107.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 153, 255));
        jLabel107.setText("Cetak Ulang Nota Pelanggan >>>");
        jLabel107.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel107MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jLabel12.setText("Refresh");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tahapPertamaLayout = new javax.swing.GroupLayout(tahapPertama);
        tahapPertama.setLayout(tahapPertamaLayout);
        tahapPertamaLayout.setHorizontalGroup(
            tahapPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahapPertamaLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(tahapPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahapPertamaLayout.createSequentialGroup()
                        .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(19, 19, 19)
                        .addComponent(field_lanjut_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel107))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                    .addComponent(field_cari_data_transaksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113))
        );
        tahapPertamaLayout.setVerticalGroup(
            tahapPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahapPertamaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(field_cari_data_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(tahapPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahapPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(field_lanjut_pengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(jLabel107))
                .addGap(88, 88, 88))
        );

        containerDataTransaksi.add(tahapPertama, "card2");

        tahapKedua.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setText("Kode Struk");

        jLabel52.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel52.setText("NO. transaksi yang dilakukan");

        kd_struk_data_transaksi.setEnabled(false);
        kd_struk_data_transaksi.setLabelText("Kode Transaksi");
        kd_struk_data_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kd_struk_data_transaksiMouseClicked(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel53.setText("ID Pelanggan");

        jLabel54.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel54.setText("Nomor ID pelanggan yang melakukan");

        jLabel55.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel55.setText("transaksi dan pengambilan");

        id_pelanggan_dt.setEnabled(false);
        id_pelanggan_dt.setLabelText("ID Pelanggan");
        id_pelanggan_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_pelanggan_dtMouseClicked(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel56.setText("ID Kasir");

        jLabel57.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel57.setText("Nomor ID anda sebagai kasir yang");

        jLabel58.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel58.setText("melakukan transaksi pengembalian");

        id_kasir_dt.setEnabled(false);
        id_kasir_dt.setLabelText("ID Kasir");
        id_kasir_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                id_kasir_dtMouseClicked(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel59.setText("Tanggal Pesan");

        jLabel60.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel60.setText("Tanggal laundry pelanggan");

        tanggal_pesan_dt.setEnabled(false);
        tanggal_pesan_dt.setLabelText("Tanggal Pesan");
        tanggal_pesan_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tanggal_pesan_dtMouseClicked(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel61.setText("Tanggal selesai");

        jLabel62.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel62.setText("Tanggal selesai laundry");

        jLabel63.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel63.setText("Status Ambil");

        jLabel64.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel64.setText("Rubah status ambil pada pelanggan");

        jLabel65.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel65.setText("dibawah ini menjadi sudah diambil!");

        tanggal_selesai_dt.setEnabled(false);
        tanggal_selesai_dt.setLabelText("Tanggal Selesai");
        tanggal_selesai_dt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tanggal_selesai_dtMouseClicked(evt);
            }
        });
        tanggal_selesai_dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggal_selesai_dtActionPerformed(evt);
            }
        });

        status_ambil_dt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "belum di ambil", "sudah di ambil" }));
        status_ambil_dt.setSelectedIndex(-1);
        status_ambil_dt.setLabeText("Status Ambil");

        kButton12.setText("Lanjutkan");
        kButton12.setBorderPainted(false);
        kButton12.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        kButton12.setkBackGroundColor(new java.awt.Color(102, 153, 255));
        kButton12.setkEndColor(new java.awt.Color(102, 153, 255));
        kButton12.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        kButton12.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton12.setkHoverStartColor(new java.awt.Color(0, 0, 255));
        kButton12.setkPressedColor(new java.awt.Color(102, 153, 255));
        kButton12.setkSelectedColor(new java.awt.Color(102, 153, 255));
        kButton12.setkStartColor(new java.awt.Color(102, 153, 255));
        kButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton12ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel66.setText("Kembali");
        jLabel66.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel66MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tahapKeduaLayout = new javax.swing.GroupLayout(tahapKedua);
        tahapKedua.setLayout(tahapKeduaLayout);
        tahapKeduaLayout.setHorizontalGroup(
            tahapKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tahapKeduaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(tahapKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(jLabel54)
                    .addComponent(jLabel53)
                    .addComponent(jLabel52)
                    .addComponent(jLabel2)
                    .addComponent(kd_struk_data_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(id_pelanggan_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(tahapKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(status_ambil_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_kasir_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57)
                    .addComponent(jLabel56)
                    .addComponent(jLabel65)
                    .addComponent(jLabel64))
                .addGap(60, 60, 60)
                .addGroup(tahapKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(jLabel59)
                    .addComponent(jLabel62)
                    .addComponent(jLabel61)
                    .addComponent(tanggal_selesai_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal_pesan_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
            .addGroup(tahapKeduaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel66)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tahapKeduaLayout.setVerticalGroup(
            tahapKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahapKeduaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addGap(18, 18, 18)
                .addGroup(tahapKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tahapKeduaLayout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(id_kasir_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tahapKeduaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52)
                        .addGap(21, 21, 21)
                        .addComponent(kd_struk_data_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tahapKeduaLayout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel60)
                        .addGap(21, 21, 21)
                        .addComponent(tanggal_pesan_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70)
                .addGroup(tahapKeduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tahapKeduaLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel64)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel65)
                        .addGap(18, 18, 18)
                        .addComponent(status_ambil_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tahapKeduaLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel54)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18)
                        .addComponent(id_pelanggan_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tahapKeduaLayout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tanggal_selesai_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        containerDataTransaksi.add(tahapKedua, "card3");

        tahapKetiga.setBackground(new java.awt.Color(255, 255, 255));

        jLabel67.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel67.setText("Kembali");
        jLabel67.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel70.setText("Total Harga :");

        total_harga_dt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        total_harga_dt.setText("50000");
        total_harga_dt.setBorder(null);

        jLabel69.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel69.setText("Sisa Harus dibayar :");

        sisa_bayar_dt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        sisa_bayar_dt.setText("50000");
        sisa_bayar_dt.setBorder(null);

        jLabel72.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel72.setText("Pengisian Pembayaran");

        jLabel68.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel68.setText("Isi pembayaran jika pelanggan sebelumnya memiliki");

        jLabel71.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel71.setText("status belum lunas, lanjutkan jika form terisi atau");

        jLabel73.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel73.setText("pelanggan memiliki status sudah lunas.");

        jLabel74.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel74.setText("Status Pelanggan :");

        status_bayar_dt.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        status_bayar_dt.setForeground(new java.awt.Color(255, 0, 51));
        status_bayar_dt.setText("Belum Lunas!");
        status_bayar_dt.setBorder(null);

        jLabel75.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel75.setText("Form Pembayaran :");

        pembayaran_dt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        pembayaran_dt.setLabelText("Masukkan Jumlah Bayar");

        kembalian_pembayaran_dt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        kembalian_pembayaran_dt.setLabelText("Kembalian");

        jLabel76.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel76.setText("Pembayaran Sebelumnya");

        jLabel77.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel77.setText("Jumlah pembayaran dari pelanggan saat pemesanan");

        jLabel78.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel78.setText("paket laundry seperti pada form yang tertera :");

        jumlah_bayar_dt.setEnabled(false);
        jumlah_bayar_dt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jumlah_bayar_dt.setLabelText("Jumlah Pembayaran");

        kembalian_dt.setEnabled(false);
        kembalian_dt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        kembalian_dt.setLabelText("Kembalian");

        jLabel79.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel79.setText("Pembayaran Pelanggan Sebelumnya :");

        kButton13.setText("Simpan");
        kButton13.setBorderPainted(false);
        kButton13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton13.setkBackGroundColor(new java.awt.Color(102, 153, 255));
        kButton13.setkEndColor(new java.awt.Color(102, 153, 255));
        kButton13.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        kButton13.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton13.setkHoverStartColor(new java.awt.Color(0, 0, 255));
        kButton13.setkPressedColor(new java.awt.Color(102, 153, 255));
        kButton13.setkSelectedColor(new java.awt.Color(102, 153, 255));
        kButton13.setkStartColor(new java.awt.Color(102, 153, 255));
        kButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton13ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel26.setText("Detail Pemesanan");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clipboard.png"))); // NOI18N
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel84.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(204, 204, 204));
        jLabel84.setText("Klik Disini!");
        jLabel84.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/right-arrow (1).png"))); // NOI18N
        jLabel85.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel86.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel86.setText("Nomor Rak :");

        nomorak.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        nomorak.setBorder(null);

        javax.swing.GroupLayout tahapKetigaLayout = new javax.swing.GroupLayout(tahapKetiga);
        tahapKetiga.setLayout(tahapKetigaLayout);
        tahapKetigaLayout.setHorizontalGroup(
            tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahapKetigaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel67)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tahapKetigaLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomorak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                        .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(tahapKetigaLayout.createSequentialGroup()
                                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                                        .addComponent(jLabel74)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(status_bayar_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(kembalian_pembayaran_dt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tahapKetigaLayout.createSequentialGroup()
                                            .addComponent(jLabel69)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sisa_bayar_dt))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tahapKetigaLayout.createSequentialGroup()
                                            .addComponent(jLabel70)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(total_harga_dt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(pembayaran_dt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel78)
                                    .addComponent(jLabel79)
                                    .addComponent(kembalian_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jumlah_bayar_dt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel84)
                                            .addGroup(tahapKetigaLayout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel85)))))))
                        .addGap(148, 148, 148))))
        );
        tahapKetigaLayout.setVerticalGroup(
            tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahapKetigaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addGap(5, 5, 5)
                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(nomorak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                        .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tahapKetigaLayout.createSequentialGroup()
                                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(total_harga_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel70))
                                .addGap(0, 0, 0)
                                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel69)
                                    .addComponent(sisa_bayar_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel28))
                        .addGap(0, 0, 0)
                        .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(status_bayar_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                        .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel85))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel84)))
                .addGap(41, 41, 41)
                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel71)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel73))
                    .addGroup(tahapKetigaLayout.createSequentialGroup()
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel78)
                        .addGap(15, 15, 15)))
                .addGap(18, 18, 18)
                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel79))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pembayaran_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlah_bayar_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tahapKetigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembalian_pembayaran_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kembalian_dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        containerDataTransaksi.add(tahapKetiga, "card4");

        tampilanDataTransaksi.add(containerDataTransaksi, "card2");

        containerContent.add(tampilanDataTransaksi, "card4");

        tampilanDataPelanggan.setBackground(new java.awt.Color(255, 255, 255));
        tampilanDataPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        table_data_pelanggan_kasir.setModel(new javax.swing.table.DefaultTableModel(
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
        table_data_pelanggan_kasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_data_pelanggan_kasirMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_data_pelanggan_kasir);

        comboboxDataPelanggan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tambah data pelanggan", "Edit data pelanggan", "Hapus data pelanggan", "Refresh Tabel" }));
        comboboxDataPelanggan.setSelectedIndex(-1);
        comboboxDataPelanggan.setLabeText("Pilih Aksi");
        comboboxDataPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxDataPelangganActionPerformed(evt);
            }
        });

        kButton6.setText("Lakukan Aksi");
        kButton6.setBorderPainted(false);
        kButton6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kButton6.setkBackGroundColor(new java.awt.Color(227, 8, 143));
        kButton6.setkEndColor(new java.awt.Color(227, 8, 143));
        kButton6.setkHoverEndColor(new java.awt.Color(0, 0, 255));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(0, 0, 255));
        kButton6.setkIndicatorColor(new java.awt.Color(0, 0, 255));
        kButton6.setkPressedColor(new java.awt.Color(102, 153, 255));
        kButton6.setkSelectedColor(new java.awt.Color(102, 153, 255));
        kButton6.setkStartColor(new java.awt.Color(102, 153, 255));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        field_cari_data_pelanggan2.setBackground(new java.awt.Color(245, 245, 245));
        field_cari_data_pelanggan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_cari_data_pelanggan2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tampilanDataPelangganLayout = new javax.swing.GroupLayout(tampilanDataPelanggan);
        tampilanDataPelanggan.setLayout(tampilanDataPelangganLayout);
        tampilanDataPelangganLayout.setHorizontalGroup(
            tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilanDataPelangganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                    .addGroup(tampilanDataPelangganLayout.createSequentialGroup()
                        .addComponent(comboboxDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(field_cari_data_pelanggan2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tampilanDataPelangganLayout.setVerticalGroup(
            tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilanDataPelangganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tampilanDataPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboboxDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_cari_data_pelanggan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5)
                .addGap(8, 8, 8))
        );

        containerContent.add(tampilanDataPelanggan, "card5");

        javax.swing.GroupLayout wrapperKontentLayout = new javax.swing.GroupLayout(wrapperKontent);
        wrapperKontent.setLayout(wrapperKontentLayout);
        wrapperKontentLayout.setHorizontalGroup(
            wrapperKontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tempatJuduldanUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(containerContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wrapperKontentLayout.setVerticalGroup(
            wrapperKontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperKontentLayout.createSequentialGroup()
                .addComponent(tempatJuduldanUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(wrapperKontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wrapperMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
            .addComponent(wrapperKontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(container, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void harusAngka() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Field hanya boleh berisi angka!");
        panel.showNotification();
    }

    public static void total_paket_skrg() {
        try {
            String sql = "SELECT SUM(qty) as total_paket_ini from tbl_detail_order JOIN tbl_order on tbl_order.kode_order = tbl_detail_order.kode_order join paket on tbl_detail_order.kd_paket = paket.kd_paket where tbl_order.tgl_pesan = current_date() && paket.jenis_paket = 'kiloan'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            int totalHariIni = rs.getInt("total_paket_ini");
            jumlahPaketDipesan.setText("" + totalHariIni);

        } catch (Exception e) {
            jumlahPaketDipesan.setText("" + 0);
            paketKiloan.setText("" + 0);
        }

    }

    public void laundrySelesai(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Tgl Pesan");
        tbl.addColumn("Tgl Selesai");
        tb1.setModel(tbl);
        try {
            String belum = "belum di ambil";
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tbl_order join pelanggan on tbl_order.id_pelanggan = pelanggan.id_pelanggan where status_ambil = 'sudah di ambil'");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("nama_pelanggan"),
                    res.getString("tgl_pesan"),
                    res.getString("tgl_selesai"),});
                tb1.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void laundryBelumSelesai(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Tgl Pesan");
        tbl.addColumn("Tgl Selesai");
        tb2.setModel(tbl);
        try {
            String belum = "belum di ambil";
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tbl_order join pelanggan on tbl_order.id_pelanggan = pelanggan.id_pelanggan where status_ambil = 'belum di ambil'");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("nama_pelanggan"),
                    res.getString("tgl_pesan"),
                    res.getString("tgl_selesai"),});
                tb2.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void ngitung_jmkl_odrpkt_satuan() {
        try {
            String sql = "SELECT SUM(qty) as total_paket_ini from tbl_order join tbl_detail_order on tbl_order.kode_order = tbl_detail_order.kode_order join paket on tbl_detail_order.kd_paket = paket.kd_paket where tbl_order.tgl_selesai = current_date() && paket.jenis_paket = 'satuan';";
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

    public void ngitung_jmkl_odrpkt_hrian() {
        try {
            String sql = "SELECT sum(qty) as total_paket_ini from tbl_order join tbl_detail_order on tbl_order.kode_order = tbl_detail_order.kode_order join paket on tbl_detail_order.kd_paket = paket.kd_paket where tbl_order.tgl_selesai = current_date() && paket.jenis_paket = 'kiloan';";
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

    public void transaksiHariini() {
        try {
            String sql = "select sum(grand_total) as total_hari_ini from tbl_order where tgl_pesan = curdate()";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            int totalHariIni = rs.getInt("total_hari_ini");
            jLabel7.setText("" + totalHariIni);
        } catch (Exception e) {
            jLabel7.setText("" + 0);
        }
    }

    private void notifpelanggankurang() {
        Message obj = new Message();
        obj.txt.setText("Status Pelanggan belum lunas, isi pembayaran pelanggan dahulu lalu anda bisa merubah keterangan barang pada fitur detail pemesanan!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    private void notifPelangganLuna() {
        Message obj = new Message();
        obj.txt.setText("Status Pelanggan sudah lunas, anda bisa langsung simpan transaksi atau merubah dulu keterangan barang pada detail pemesanan!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    private void notifSearchDataTransaksiTidakmencari() {
        Message obj = new Message();
        obj.txt.setText("Anda belum mencari data transaksi!, ketikkan data yang ingin anda cari di kolom pencarian ini!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String status = "belum di ambil";
                DefaultTableModel tbl = new DefaultTableModel();
                tbl.addColumn("Kode Transaksi");
                tbl.addColumn("ID");
                tbl.addColumn("Nama Pelanggan");
                tbl.addColumn("Status ambil");
                tabel_data_transaksi_kasir.setModel(tbl);
                try {
                    String sudah = "belum di ambil";
                    Statement statement = (Statement) connect.configDB().createStatement();
                    ResultSet res = statement.executeQuery("SELECT pelanggan.nama_pelanggan, pelanggan.id_pelanggan, `tbl_order`.status_ambil\n"
                            + ", tbl_order.kode_order FROM pelanggan\n"
                            + "JOIN `tbl_order` ON pelanggan.id_pelanggan = `tbl_order`.id_pelanggan where tbl_order.status_ambil = '" + sudah + "'");
                    while (res.next()) {
                        tbl.addRow(new Object[]{
                            res.getString("kode_order"),
                            res.getString("id_pelanggan"),
                            res.getString("nama_pelanggan"),
                            res.getString("status_ambil"),});
                        tabel_data_transaksi_kasir.setModel(tbl);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
                }
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    private void notifSearchPelangganTidakMencari() {
        Message obj = new Message();
        obj.txt.setText("Anda belum mencari pelanggan, ketikkan nama pelanggan pada kolom pencarian ini!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel tbl = new DefaultTableModel();
                tbl.addColumn("ID");
                tbl.addColumn("Nama");
                tbl.addColumn("Alamat");
                tbl.addColumn("Nomor");
                tabel_data_pelanggan_2.setModel(tbl);
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
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
                }
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    private void notifSearchPelangganTidakMencari2() {
        Message obj = new Message();
        obj.txt.setText("Anda belum mencari pelanggan, ketikkan nama pelanggan pada kolom pencarian ini!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel tbl = new DefaultTableModel();
                tbl.addColumn("ID");
                tbl.addColumn("Nama");
                tbl.addColumn("Alamat");
                tbl.addColumn("Nomor");
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
                        table_data_pelanggan_kasir.setModel(tbl);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
                }
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }

    private void notifInfoSearchPelanggan() {
        Message obj = new Message();
        obj.txt.setText("Pelanggan tidak ditemukan, daftarkan pelanggan baru? tekan ok untuk mendaftarkan pelanggan baru!");
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                containerTransaksi.removeAll();
                containerTransaksi.repaint();
                containerTransaksi.revalidate();
                containerTransaksi.add(inputPelanggan);
                containerTransaksi.repaint();
                containerTransaksi.revalidate();
                GlassPanePopup.closePopupLast();

            }
        });
        GlassPanePopup.showPopup(obj);
    }

    private void notifInforSearchDataTransaksi() {
        Message obj = new Message();
        obj.txt.setText("Pelanggan tidak ditemukan atau belum melakukan transaksi, pergi ke fitur transaksi? tekan ok untuk pergi");
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                judulDb.setText("Transaksi");
                setColor(menuTransaksi);
                resetColor(menuDashboard);
                resetColor(menuDataPelanggan);
                resetColor(menuDatatransaksi);
                //resetColor(menuHistoryTransaksi);
                containerContent.removeAll();
                containerContent.repaint();
                containerContent.revalidate();
                containerContent.add(tampilanTransaksi);
                containerContent.repaint();
                containerContent.revalidate();
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
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

    public void tanggalOtomatis() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy");
        String tanggalFormatted = sdf1.format(cal.getTime());
        tanggalOtomatis.setText(tanggalFormatted);
        tanggalOtomatis.setEditable(false);
    }

    public void search_data_transaksi() {
        field_cari_data_transaksi.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                if (field_cari_data_transaksi.getText().isEmpty()) {
                    notifSearchDataTransaksiTidakmencari();
                }
                try {
                    DefaultTableModel tbl = new DefaultTableModel();
                    tbl.addColumn("Kode Transaksi");
                    tbl.addColumn("ID Pelanggan");
                    tbl.addColumn("Nama Pelanggan");
                    tbl.addColumn("No rak");
                    tbl.addColumn("Status Pengambilan");
                    try {
                        String sudah = "belum di ambil";
                        String sql = "select * from tbl_order join pelanggan on pelanggan.id_pelanggan=tbl_order.id_pelanggan where pelanggan.nama_pelanggan like '%" + field_cari_data_transaksi.getText() + "%' || tbl_order.kode_order like '%" + field_cari_data_transaksi.getText() + "%'";
                        Connection con = (Connection) connect.configDB();
                        Statement st = (Statement) con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
                            tbl.addRow(new Object[]{
                                rs.getString("kode_order"),
                                rs.getString("id_pelanggan"),
                                rs.getString("nama_pelanggan"),
                                rs.getString("no_rak"),
                                rs.getString("status_ambil"),});
                            tabel_data_transaksi_kasir.setModel(tbl);
                        } else if (!rs.next()) {
                            notifInforSearchDataTransaksi();
                        }
                    } catch (Exception e) {
                    }
                    for (int i = 1; i <= 70; i++) {
                        field_cari_data_transaksi.setText("");
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

    public void menampilkan_data_pelanggan_data_transaksi(JTable table) {
        String status = "belum di ambil";
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Transaksi");
        tbl.addColumn("ID");
        tbl.addColumn("Nama Pelanggan");
        tbl.addColumn("Status ambil");
        tabel_data_transaksi_kasir.setModel(tbl);
        try {
            String belum = "belum di ambil";
            Statement statement = (Statement) connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("SELECT pelanggan.nama_pelanggan, pelanggan.id_pelanggan, `tbl_order`.status_ambil\n"
                    + ", tbl_order.kode_order FROM pelanggan\n"
                    + "JOIN `tbl_order` ON pelanggan.id_pelanggan = `tbl_order`.id_pelanggan where tbl_order.status_ambil = '" + belum + "'");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kode_order"),
                    res.getString("id_pelanggan"),
                    res.getString("nama_pelanggan"),
                    res.getString("status_ambil"),});
                tabel_data_transaksi_kasir.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void tampil_data_penjualan(JTable table) {
        String[] judul = {"ID", "Nama paket", "Harga", "jumlah", " subtotal", "keterangan"};
        modelpj = new DefaultTableModel(judul, 0);
        tabel_penjualan.setModel(modelpj);
    }

    private void _settotal() {
        int total_pjl = 0;
        int row = tabel_penjualan.getRowCount();
        int tuotal = 0;
        for (int i = 0; i < row; i++) {
            int sb = Integer.parseInt(tabel_penjualan.getValueAt(i, 4).toString()); //22000
            int tot = Integer.parseInt(tabel_penjualan.getValueAt(i, 3).toString());
            tuotal = tuotal + (sb);
            total_pjl = total_pjl + tot;
            //subtotal = 15000 + (23*11)
            //subtotal = 15000 + 253
            //subtotal = 15253
            //subtotal = 15253 + (22000*11)
            //subtotal = 15253 + 242000
            //subtotal = 257253
        }
        this.tot_brg = total_pjl;
        this.thotal = tuotal;
        field_total_harga.setText(String.valueOf(this.thotal));
    }

    void resetKeranjang() {
        DefaultTableModel model = (DefaultTableModel) tabel_penjualan.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void reset_nambah_krj() {
        field_subtotal.setText("");
        field_keterangan.setText("");
        field_jumlah_barang.setText("");
        field_harga_paket.setText("");

    }

    public void tampil_data_barang(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Paket");
        tbl.addColumn("Nama Paket");
        tbl.addColumn("Jenis Paket");
        tbl.addColumn("Harga Paket");
        tabel_barang.setModel(tbl);
        try {
            Statement statement = (Statement) connect.configDB().createStatement();

//           Statement statement=(Statement)coneksi.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from paket");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kd_paket"),
                    res.getString("nama_paket"),
                    res.getString("jenis_paket"),
                    res.getString("harga")
                });
                tabel_barang.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void kodeTransaksiOtomatis() {
        try {
            String sql = "SELECT * from tbl_order ORDER BY kode_order DESC";
            Connection con = (Connection) connect.configDB();
            Statement st = (Statement) con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                String NoJual = res.getString("kode_order").substring(2);
                String AN = "" + (Integer.parseInt(NoJual) + 1);
//                String AN = "" + (Integer.parseInt(txt_idsupplier.getText()) + 1);
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
                //field_kode_nota.setText("TR" + Nol + AN);//sesuaikan dengan variable namenya
                field_kode_nota.setText("TR" + Nol + AN);
            } else {
                //field_kode_nota.setText("TR0001");//sesuaikan dengan variable namenya
                field_kode_nota.setText("TR0001");
            }
            res.close();
        } catch (Exception e) {
            //penanganan masalah
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    void username_login_pojok() {
        namaLoginKasir.setText(session.getUsername());
    }

    void id_kasir_tr() {
        if (session.getId_kasir() != null) {
            String id = session.getId_kasir();
            field_id_user.setText(id);
            field_id_user_clone.setText(id);
            id_kasir_dt.setText(id);
        } else if (session.getId_kasir() != null) {
            field_id_user.setText(session.getId_kasir());
            field_id_user_clone.setText(session.getId_kasir());
            id_kasir_dt.setText(session.getId_kasir());
        }
    }

    public void search_data_pelanggan() {
        field_cari_data_pelanggan.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                if (field_cari_data_pelanggan.getText().isEmpty()) {
                    notifSearchPelangganTidakMencari();
                }
                try {
                    DefaultTableModel tbl = new DefaultTableModel();
                    tbl.addColumn("ID");
                    tbl.addColumn("Nama");
                    tbl.addColumn("Alamat");
                    tbl.addColumn("Nomor");
                    try {
                        String sql = "SELECT * FROM pelanggan WHERE nama_pelanggan like'%" + field_cari_data_pelanggan.getText()
                                + "%' || id_pelanggan like'%" + field_cari_data_pelanggan.getText() + "%' || alamat like'%"
                                + field_cari_data_pelanggan.getText() + "%'";
                        Connection con = (Connection) connect.configDB();
                        Statement st = (Statement) con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        if (rs.next()) {
                            tbl.addRow(new Object[]{
                                rs.getString("id_pelanggan"),
                                rs.getString("nama_pelanggan"),
                                rs.getString("alamat"),
                                rs.getString("no_telp"),});
                            tabel_data_pelanggan_2.setModel(tbl);
                        } else if (!rs.next()) {
                            //ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/emergency.png"));
                            //JOptionPane.showMessageDialog(null, "Data pelanggan tidak ditemukan, silahkan lakukan redaftar untuk pelanggan baru", "PERINGATAN DATA PELANGGAN TIDAK DITEMUKAN!!", JOptionPane.INFORMATION_MESSAGE, iconic);
                            notifInfoSearchPelanggan();
                        }
                    } catch (Exception e) {
                    }
                    for (int i = 1; i <= 70; i++) {
                        field_cari_data_pelanggan.setText("");
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

    public void search_data_pelanggan2() {
        field_cari_data_pelanggan2.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                if (field_cari_data_pelanggan2.getText().isEmpty()) {
                    notifSearchPelangganTidakMencari2();
                }
                try {
                    DefaultTableModel tbl = new DefaultTableModel();
                    tbl.addColumn("ID");
                    tbl.addColumn("Nama");
                    tbl.addColumn("Alamat");
                    tbl.addColumn("Nomor");
                    try {
                        String sql = "SELECT * FROM pelanggan WHERE nama_pelanggan like'%" + field_cari_data_pelanggan2.getText() + "%' || id_pelanggan like'%" + field_cari_data_pelanggan2.getText() + "%' || alamat like'%" + field_cari_data_pelanggan2.getText() + "%'";
                        Connection con = (Connection) connect.configDB();
                        Statement st = (Statement) con.createStatement();
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                            tbl.addRow(new Object[]{
                                rs.getString("id_pelanggan"),
                                rs.getString("nama_pelanggan"),
                                rs.getString("alamat"),
                                rs.getString("no_telp"),});
                            table_data_pelanggan_kasir.setModel(tbl);
                        }
                        if (tbl.getRowCount() == 0) {
                            //ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/emergency.png"));
                            //JOptionPane.showMessageDialog(null, "Data pelanggan tidak ditemukan, silahkan lakukan redaftar untuk pelanggan baru", "PERINGATAN DATA PELANGGAN TIDAK DITEMUKAN!!", JOptionPane.INFORMATION_MESSAGE, iconic);
                            notifInfoSearchPelanggan();
                        }
                    } catch (Exception e) {
                    }
                    for (int i = 1; i <= 70; i++) {
                        field_cari_data_pelanggan2.setText("");
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

    void id_otomatis_pelanggan() {
        try {
            String sql = "SELECT * from pelanggan ORDER BY id_pelanggan DESC";
            Connection con = (Connection) connect.configDB();
            Statement st = (Statement) con.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                String Noplg = res.getString("id_pelanggan").substring(2);
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
                field_id_pelanggan_tr.setText("PL" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                field_id_pelanggan_tr.setText("PL0001");//sesuaikan dengan variable namenya
            }
            res.close();
        } catch (Exception e) {
            //penanganan masalah
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void setColor(JPanel p) { // HOVER MENU
        p.setBackground(new Color(113, 144, 245));
    }

    public void resetColor(JPanel pl) { //HOVER MENU
        pl.setBackground(new Color(255, 255, 255));
    }
    private void dashboardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Dashboard");
        resetColor(menuTransaksi);
        resetColor(menuDataPelanggan);
        resetColor(menuDatatransaksi);
        //resetColor(menuHistoryTransaksi);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDashboardUtama);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_dashboardLabelMouseClicked

    private void dashboardLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDashboard);
    }//GEN-LAST:event_dashboardLabelMousePressed

    private void menuTransaksiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTransaksiLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Transaksi");
        resetColor(menuDashboard);
        resetColor(menuDataPelanggan);
        resetColor(menuDatatransaksi);
        //resetColor(menuHistoryTransaksi);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanTransaksi);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_menuTransaksiLabelMouseClicked

    private void menuTransaksiLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTransaksiLabelMousePressed
        // TODO add your handling code here:
        setColor(menuTransaksi);
    }//GEN-LAST:event_menuTransaksiLabelMousePressed

    private void datatransaksiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatransaksiLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Pengambilan Cucian");
        resetColor(menuDashboard);
        resetColor(menuDataPelanggan);
        resetColor(menuTransaksi);
        //resetColor(menuHistoryTransaksi);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanDataTransaksi);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_datatransaksiLabelMouseClicked

    private void datatransaksiLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatransaksiLabelMousePressed
        // TODO add your handling code here:
        setColor(menuDatatransaksi);
    }//GEN-LAST:event_datatransaksiLabelMousePressed

    private void dataPelangganLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPelangganLabelMouseClicked
        // TODO add your handling code here:
        judulDb.setText("Data Pelanggan");
        resetColor(menuDashboard);
        resetColor(menuDatatransaksi);
        resetColor(menuTransaksi);
        //resetColor(menuHistoryTransaksi);
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

    private void field_cari_data_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_cari_data_pelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_cari_data_pelangganActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
        containerTransaksi.removeAll();
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
        containerTransaksi.add(inputPelanggan);
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
    }//GEN-LAST:event_kButton4ActionPerformed

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:
        containerTransaksi.removeAll();
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
        containerTransaksi.add(tampilanAwalTransaksi);
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
        containerTransaksi.removeAll();
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
        containerTransaksi.add(lanjutTransaksi1);
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = '" + field_id_pelanggan.getText() + "'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                new detailDataJtextField.PelangganTR().setVisible(true);
                nama_pelanggan_form.setText(rs.getString(2));
                id_detail_pelanggan_form.setText(rs.getString(1));
                alamat_pelanggan_form.setText(rs.getString(3));
                nomor_telfon_pelanggan_form.setText(rs.getString(4));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM user WHERE id_user = '" + field_id_user.getText() + "'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                new detailDataJtextField.UserTR().setVisible(true);
                nama_kasir_form.setText(rs.getString(2));
                id_detail_kasir_form.setText(rs.getString(1));
                alamat_kasir_form.setText(rs.getString(5));
                nomor_telfon_kasir_form.setText(rs.getString(6));
                username_kasir_detail_form.setText(rs.getString(3));
                password_detail_form.setText(rs.getString(4));
                hakakses_detail_form.setText(rs.getString(7));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        // TODO add your handling code here:
        Message obj = new Message();
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Click OK");
                containerTransaksi.removeAll();
                containerTransaksi.repaint();
                containerTransaksi.revalidate();
                containerTransaksi.add(tampilanAwalTransaksi);
                containerTransaksi.repaint();
                containerTransaksi.revalidate();
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
        containerTransaksi.removeAll();
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
        containerTransaksi.add(lanjutTransaksi2);
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
    }//GEN-LAST:event_jLabel51MouseClicked

    private void field_kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_kembalianActionPerformed

    private void field_cari_data_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_cari_data_transaksiActionPerformed
        // TODO add your handling code her
        try {
            String sql = "select * from tbl_order join pelanggan on pelanggan.id_pelanggan=tbl_order.id_pelanggan join user on user.id_user=tbl_order.id_user where tbl_order.kode_order ='" + field_cari_data_transaksi.getText() + "'";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                containerDataTransaksi.removeAll();
                containerDataTransaksi.repaint();
                containerDataTransaksi.revalidate();
                containerDataTransaksi.add(tahapKedua);
                containerDataTransaksi.repaint();
                containerDataTransaksi.revalidate();
                kd_struk_data_transaksi.setText(rs.getString(1));
                id_pelanggan_dt.setText(rs.getString(2));
                status_ambil_dt.setSelectedItem(rs.getString(11));
                tanggal_pesan_dt.setText(rs.getString(4));
                tanggal_selesai_dt.setText(rs.getString(5));
                total_harga_dt.setText(rs.getString(6));
                sisa_bayar_dt.setText(rs.getString(8));
                status_bayar_dt.setText(rs.getString(9));
                jumlah_bayar_dt.setText(rs.getString(7));
                kembalian_dt.setText(rs.getString(10));
                nomorak.setText(rs.getString(12));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah");
        }
    }//GEN-LAST:event_field_cari_data_transaksiActionPerformed

    private void tanggal_selesai_dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggal_selesai_dtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggal_selesai_dtActionPerformed

    private void jLabel66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel66MouseClicked
        // TODO add your handling code here:
        containerDataTransaksi.removeAll();
        containerDataTransaksi.repaint();
        containerDataTransaksi.revalidate();
        containerDataTransaksi.add(tahapPertama);
        containerDataTransaksi.repaint();
        containerDataTransaksi.revalidate();
    }//GEN-LAST:event_jLabel66MouseClicked

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed
        // TODO add your handling code here:
        if (session.getKode_struk() != null) {
            try {
                String sql = "select * from tbl_order join pelanggan on pelanggan.id_pelanggan=tbl_order.id_pelanggan join user on user.id_user=tbl_order.id_user where tbl_order.kode_order ='" + session.getKode_struk() + "'";
                java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                java.sql.ResultSet rs = pst.executeQuery(sql);
                if (rs.next()) {
                    containerDataTransaksi.removeAll();
                    containerDataTransaksi.repaint();
                    containerDataTransaksi.revalidate();
                    containerDataTransaksi.add(tahapKedua);
                    containerDataTransaksi.repaint();
                    containerDataTransaksi.revalidate();
                    kd_struk_data_transaksi.setText(rs.getString(1));
                    id_pelanggan_dt.setText(rs.getString(2));
                    status_ambil_dt.setSelectedItem(rs.getString(11));
                    tanggal_pesan_dt.setText(rs.getString(4));
                    tanggal_selesai_dt.setText(rs.getString(5));
                    total_harga_dt.setText(rs.getString(6));
                    sisa_bayar_dt.setText(rs.getString(8));
                    status_bayar_dt.setText(rs.getString(9));
                    jumlah_bayar_dt.setText(rs.getString(7));
                    kembalian_dt.setText(rs.getString(10));
                    nomorak.setText(rs.getString(12));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "salah");
            }
        } else {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Pilih data pada tabel terlebih dahulu! lalu lanjutkan.");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton11ActionPerformed

    private void kButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton12ActionPerformed
        // TODO add your handling code here:
        containerDataTransaksi.removeAll();
        containerDataTransaksi.repaint();
        containerDataTransaksi.revalidate();
        containerDataTransaksi.add(tahapKetiga);
        containerDataTransaksi.repaint();
        containerDataTransaksi.revalidate();
        if (status_bayar_dt.getText().equals("Kurang")) {
            status_bayar_dt.setForeground(Color.red);
            notifpelanggankurang();
        } else if (status_bayar_dt.getText().equals("Lunas")) {
            status_bayar_dt.setForeground(Color.green);
            pembayaran_dt.setEnabled(false);
            kembalian_pembayaran_dt.setEnabled(false);
            pembayaran_dt.setText("Lunas Tidak usah mengisi form pembayaran!");
            kembalian_pembayaran_dt.setText("Lunas Tidak usah mengisi form pembayaran!");
            notifPelangganLuna();
        } else if (status_bayar_dt.getText().equals("Belum Bayar")) {
            status_bayar_dt.setForeground(Color.blue);
            notifpelanggankurang();
        }
    }//GEN-LAST:event_kButton12ActionPerformed

    private void kd_struk_data_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kd_struk_data_transaksiMouseClicked
        // TODO add your handling code here:
        if (kd_struk_data_transaksi != null) {
            JOptionPane.showMessageDialog(null, "form sudah terisi otomatis");
            kd_struk_data_transaksi.setEnabled(false);
        }
    }//GEN-LAST:event_kd_struk_data_transaksiMouseClicked

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
        // TODO add your handling code here:
        containerDataTransaksi.removeAll();
        containerDataTransaksi.repaint();
        containerDataTransaksi.revalidate();
        containerDataTransaksi.add(tahapKedua);
        containerDataTransaksi.repaint();
        containerDataTransaksi.revalidate();
    }//GEN-LAST:event_jLabel67MouseClicked

    private void kButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton13ActionPerformed
        // TODO add your handling code here:
        if (pembayaran_dt.getText().equals("Lunas Tidak usah mengisi form pembayaran!")
                && kembalian_pembayaran_dt.getText().equals("Lunas Tidak usah mengisi form pembayaran!")
                && status_bayar_dt.getText().equals("Lunas")) {
            java.sql.Connection conn = null;
            String KD = kd_struk_data_transaksi.getText();
            int kembaliann = Integer.parseInt(kembalian_dt.getText());
            int majer = Integer.parseInt(jumlah_bayar_dt.getText());
            int sisa_byr = Integer.parseInt(sisa_bayar_dt.getText());
            String status_byr = status_bayar_dt.getText();
            String status_ambil = (String) status_ambil_dt.getSelectedItem();
            String id_kasir = id_kasir_dt.getText();
            int norak = Integer.parseInt(nomorak.getText());
            try {
                String sql = "UPDATE tbl_order SET id_user='" + id_kasir + "',bayar='" + majer + "',kurang_bayar='"
                        + sisa_byr + "',status_bayar='" + status_byr + "',kembalian='" + kembaliann + "',status_ambil='"
                        + status_ambil + "', no_rak='" + norak + "' WHERE kode_order='" + KD + "'";
                Connection con = (Connection) connection.connect.configDB();
                com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil di EDIT");
                pst.execute();
                menampilkan_data_pelanggan_data_transaksi(tabel_data_transaksi_kasir);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            try {
                String jdbcDriver = "com.mysql.jdbc.Driver";
                Class.forName(jdbcDriver);
                String url = "jdbc:mysql://localhost:3306/app_laundry";
                String user = "agungkurniawan";
                String pass = "programmerwebdeveloper";
                conn = DriverManager.getConnection(url, user, pass);
                java.sql.Statement stm = conn.createStatement();
                try {
                    String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                    HashMap hash = new HashMap();
                    //Mengambil parameter dari ireport
                    hash.put("fix", kd_struk_data_transaksi.getText());
                    JasperReport JRpt = JasperCompileManager.compileReport(report);
                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, conn);
                    //JasperViewer.viewReport(JPrint, false);
                    JasperPrintManager.printReport(JPrint, false);
                } catch (Exception rptexcpt) {
                    System.out.println("Report Can't view because : " + rptexcpt);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            containerDataTransaksi.removeAll();
            containerDataTransaksi.repaint();
            containerDataTransaksi.revalidate();
            containerDataTransaksi.add(tahapPertama);
            containerDataTransaksi.repaint();
            containerDataTransaksi.revalidate();
            transaksiHariini();
            menampilkan_data_pelanggan_data_transaksi(tabel_data_transaksi_kasir);
        } else if (pembayaran_dt.getText() != null && kembalian_pembayaran_dt.getText() != null
                && status_bayar_dt.getText().equals("Lunas")) {
            java.sql.Connection conn = null;
            String KD = kd_struk_data_transaksi.getText();
            int kembaliann = Integer.parseInt(kembalian_pembayaran_dt.getText());
            int majer = Integer.parseInt(pembayaran_dt.getText());
            int sisa_byr = Integer.parseInt(sisa_bayar_dt.getText());
            String status_byr = status_bayar_dt.getText();
            String status_ambil = (String) status_ambil_dt.getSelectedItem();
            String id_kasir = id_kasir_dt.getText();
            int norak = Integer.parseInt(nomorak.getText());
            try {
                String sql = "UPDATE tbl_order SET id_user='" + id_kasir + "',bayar='" + majer + "',kurang_bayar='"
                        + sisa_byr + "',status_bayar='" + status_byr + "',kembalian='" + kembaliann + "',status_ambil='"
                        + status_ambil + "', no_rak='" + norak + "' WHERE kode_order='" + KD + "'";
                Connection con = (Connection) connection.connect.configDB();
                com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil di EDIT");
                pst.execute();
                menampilkan_data_pelanggan_data_transaksi(tabel_data_transaksi_kasir);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            try {
                String jdbcDriver = "com.mysql.jdbc.Driver";
                Class.forName(jdbcDriver);
                String url = "jdbc:mysql://localhost:3306/app_laundry";
                String user = "agungkurniawan";
                String pass = "programmerwebdeveloper";
                conn = DriverManager.getConnection(url, user, pass);
                java.sql.Statement stm = conn.createStatement();
                try {
                    String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                    HashMap hash = new HashMap();
                    //Mengambil parameter dari ireport
                    hash.put("fix", kd_struk_data_transaksi.getText());
                    JasperReport JRpt = JasperCompileManager.compileReport(report);
                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, conn);
                    //JasperViewer.viewReport(JPrint, false);
                    JasperPrintManager.printReport(JPrint, false);
                } catch (Exception rptexcpt) {
                    System.out.println("Report Can't view because : " + rptexcpt);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            containerDataTransaksi.removeAll();
            containerDataTransaksi.repaint();
            containerDataTransaksi.revalidate();
            containerDataTransaksi.add(tahapPertama);
            containerDataTransaksi.repaint();
            containerDataTransaksi.revalidate();
            transaksiHariini();
            menampilkan_data_pelanggan_data_transaksi(tabel_data_transaksi_kasir);
        } else if (pembayaran_dt.getText().isEmpty() && kembalian_pembayaran_dt.getText().isEmpty() && status_bayar_dt.getText().equals("Kurang") || status_bayar_dt.getText().equals("Belum Bayar")) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Anda belum mamasukkan pembayaran pelanggan!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton13ActionPerformed

    private void cmd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd3ActionPerformed
        // TODO add your handling code here:
        if (session.getId_pelanggan() != null) {
            new formLanjutanTransaksi.tahap_awal().setVisible(true);
//            containerTransaksi.removeAll();
//            containerTransaksi.repaint();
//            containerTransaksi.revalidate();
//            containerTransaksi.add(lanjutTransaksi1);
//            containerTransaksi.repaint();
//            containerTransaksi.revalidate();
        } else {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Pilih data pada tabel dahulu!");
            panel.showNotification();
        }
    }//GEN-LAST:event_cmd3ActionPerformed

    private void field_id_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_id_pelangganMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_id_pelanggan.setEditable(false);
    }//GEN-LAST:event_field_id_pelangganMouseClicked

    private void field_id_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_id_userMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_id_user.setEnabled(false);
    }//GEN-LAST:event_field_id_userMouseClicked

    private void field_kode_notaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_kode_notaMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_kode_nota.setEditable(false);
    }//GEN-LAST:event_field_kode_notaMouseClicked

    private void tanggalOtomatisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalOtomatisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalOtomatisActionPerformed

    private void field_harga_paketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_harga_paketMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_harga_paket.setEditable(false);
    }//GEN-LAST:event_field_harga_paketMouseClicked

    private void kButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kButton4KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_kButton4KeyPressed

    private void field_keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_keteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_keteranganActionPerformed

    private void field_subtotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_subtotalMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_harga_paket.setEditable(false);
    }//GEN-LAST:event_field_subtotalMouseClicked
    void a() {
        DefaultTableModel model = (DefaultTableModel) tabel_penjualan.getModel();
        model.setRowCount(0);
    }
    private void cmd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd6ActionPerformed
        // TODO add your handling code here:
//        SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//        Date tanggal = new Date();
//        int rows = tabel_penjualan.getRowCount();
//        String KD = field_kode_nota.getText();
//        int grand_total = Integer.parseInt(field_total_harga.getText());
//        int kembalian = Integer.parseInt(field_kembalian.getText());
//        int majer = Integer.parseInt(field_bayar.getText());
//        int sisa_byr = Integer.parseInt(field_sisa_bayar.getText());
//        String idplga = field_id_pelanggan.getText();
//        int rak = Integer.parseInt((String) norak.getSelectedItem());
//        String skr = "" + sfDate.format(tanggal);
//        java.sql.Connection conn = null;
//        try {
//            Connection con = (Connection) connect.configDB();
//            Calendar cal = Calendar.getInstance();
//            String stsAmbil = "belum di ambil";
//            String tanggal_selesai = tgl_sls.getText();
//            String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
//            PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
//            pst1.execute();
//            for (int i = 0; i < rows; i++) {
//                String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan.getValueAt(i, 0).toString() + "',"
//                        + "'" + tabel_penjualan.getValueAt(i, 3).toString() + "','" + tabel_penjualan.getValueAt(i, 4).toString() + "', "
//                        + "'" + tabel_penjualan.getValueAt(i, 5).toString() + "')";
//                PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
//                pst2.execute();
//                containerTransaksi.removeAll();
//                containerTransaksi.repaint();
//                containerTransaksi.revalidate();
//                containerTransaksi.add(tampilanAwalTransaksi);
//                containerTransaksi.repaint();
//                containerTransaksi.revalidate();
//                field_total_harga.setText("");
//                norak.setSelectedItem("");
//                perkiraanSelesai.setSelectedItem("");
//                field_bayar.setText("");
//                field_status_bayar.setText("");
//                field_sisa_bayar.setText("");
//                field_kembalian.setText("");
//                menampilkan_data_pelanggan_data_transaksi(tabel_data_transaksi_kasir);
//            }
//            resetKeranjang();
//
//            ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
//            JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
//            try {
//                String jdbcDriver = "com.mysql.jdbc.Driver";
//                Class.forName(jdbcDriver);
//                String url = "jdbc:mysql://localhost:3306/app_laundry";
//                String user = "agungkurniawan";
//                String pass = "programmerwebdeveloper";
//                conn = DriverManager.getConnection(url, user, pass);
//                java.sql.Statement stm = conn.createStatement();
//                try {
//                    String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\cetak_struk.jrxml");
//                    HashMap hash = new HashMap();
//                    //Mengambil parameter dari ireport
//                    hash.put("nota", field_kode_nota.getText());
//                    JasperReport JRpt = JasperCompileManager.compileReport(report);
//                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, conn);
//                    JasperViewer.viewReport(JPrint, false);
//                } catch (Exception rptexcpt) {
//                    System.out.println("Report Can't view because : " + rptexcpt);
//                }
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "" + e.getMessage());
//        }
//        transaksiHariini();
//        kodeTransaksiOtomatis();
    }//GEN-LAST:event_cmd6ActionPerformed

    private void cmd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd1ActionPerformed
        // TODO add your handling code here:
        int row = tabel_penjualan.getSelectedRow();//0
        idlist.remove(row);
        modelpj.removeRow(row);
        _settotal();
        Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Paket Pemesanan Berhasil dihapus!");
        panel.showNotification();
    }//GEN-LAST:event_cmd1ActionPerformed
//    public void hapuskrj() {
//        
//        idlist.removeAll(idlist);
//        modelpj.removeRow(20);
//        _settotal();
//    }

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        // TODO add your handling code here:
        String ID = field_id_pelanggan_tr.getText();
        String Nama = field_nama_pelanggan_tr.getText();
        String Alamat = field_alamat_pelanggan_tr.getText();
        String noTel = field_notel_tr.getText();
        try {
            Long.parseLong(field_notel_tr.getText());
            if (field_nama_pelanggan_tr.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama pelanggan belum anda isi!");
                panel.showNotification();
            } else if (field_nama_pelanggan_tr.getText().length() > 100) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama terlalu panjang!");
                panel.showNotification();
            } else if (field_nama_pelanggan_tr.getText().length() < 5) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nama pelanggan terlalu pendek, harap isi dengan nama lengkap!");
                panel.showNotification();
            } else if (field_alamat_pelanggan_tr.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Alamat belum anda isi!");
                panel.showNotification();
            } else if (field_alamat_pelanggan_tr.getText().length() > 100) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Alamat terlalu panjang!");
                panel.showNotification();
            } else if (field_alamat_pelanggan_tr.getText().length() < 7) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Alamat terlalu singkat!");
                panel.showNotification();
            } else if (field_notel_tr.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor telfon belum di isi!");
                panel.showNotification();
            } else if (field_notel_tr.getText().length() < 11) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor telfon tidak lengkap");
                panel.showNotification();
            } else if (field_notel_tr.getText().length() > 13) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Nomor telfon terlalu banyak");
                panel.showNotification();
            } else if (field_nama_pelanggan_tr.getText().isEmpty() && field_alamat_pelanggan_tr.getText().isEmpty()
                    && field_notel_tr.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Form belum di isi!");
                panel.showNotification();
            } else {
                try {
                    String sql = "INSERT INTO pelanggan VALUES('" + ID + "', '" + Nama + "', '" + Alamat + "','" + noTel + "',now())";
                    Connection con = (Connection) connect.configDB();
                    com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                    pst.execute();
                    field_nama_pelanggan_tr.setText("");
                    field_alamat_pelanggan_tr.setText("");
                    field_notel_tr.setText("");
                    menampilkan_data_pelanggan(tabel_data_pelanggan_2);
                    id_otomatis_pelanggan();
                    field_id_pelanggan_clone.setText(ID);
                    GlassPanePopup.closePopupLast();
                    formLanjutanTransaksi.tahap_awal lj = new formLanjutanTransaksi.tahap_awal();
                    lj.setVisible(true);
                    lj.notif();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Masukkan nomor telfon dengan benar!");
            panel.showNotification();
        }
    }//GEN-LAST:event_kButton5ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
        new detailPemesanan().setVisible(true);
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Struk");
        tbl.addColumn("Kode Paket");
        tbl.addColumn("Nama Paket");
        tbl.addColumn("Harga Satuan");
        tbl.addColumn("Jenis Paket");
        tbl.addColumn("Kuantitas");
        tbl.addColumn("Subtotal");
        tbl.addColumn("Keterangan");
        tabel_detail_transaksi.setModel(tbl);
        try {
            Statement statement = (Statement) connection.connect.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tbl_detail_order join paket on paket.kd_paket=tbl_detail_order.kd_paket WHERE kode_order='" + kd_struk_data_transaksi.getText() + "' ");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("kode_order"),
                    res.getString("kd_paket"),
                    res.getString("nama_paket"),
                    res.getString("harga"),
                    res.getString("jenis_paket"),
                    res.getString("qty"),
                    res.getString("subtotal"),
                    res.getString("keterangan")
                });
                tabel_detail_transaksi.setModel(tbl);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }//GEN-LAST:event_jLabel26MouseClicked

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        containerTransaksi.removeAll();
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
        containerTransaksi.add(lanjutTransaksi2);
        containerTransaksi.repaint();
        containerTransaksi.revalidate();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        try {
            if (field_harga_paket.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Field Pemesanan kosong!");
                panel.showNotification();
            } else if (field_jumlah_barang.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Field Jumlah Kuantitas Kosong!");
                panel.showNotification();
            } else {
                int jumlah = Integer.parseInt(field_jumlah_barang.getText());
                try {
                    int row = tabel_barang.getSelectedRow();
                    if ((jumlah == 0) && (field_jumlah_barang.getText().equals(""))) {
                        JOptionPane.showMessageDialog(null, "harap masukkan jumlah dengan benar");
                    } else {
                        boolean result = idlist.contains(tabel_barang.getValueAt(row, 0).toString());
                        if (result == false) {
                            idlist.add(tabel_barang.getValueAt(row, 0).toString());
                            String data[] = {tabel_barang.getValueAt(row, 0).toString(),
                                tabel_barang.getValueAt(row, 1).toString(),
                                tabel_barang.getValueAt(row, 2).toString(),
                                field_jumlah_barang.getText(), field_subtotal.getText(), field_keterangan.getText()};
                            modelpj.addRow(data);
                            reset_nambah_krj();
                            _settotal();
                            Notification panel = new Notification(this, Notification.Type.SUCCESS,
                                    Notification.Location.TOP_CENTER, "Paket Laundry Pemesanan disimpan di table keranjang");
                            panel.showNotification();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data barang sudah terinput");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "harap masukkan jumlah dengan benar");
                }
            }
        } catch (Exception kembalian) {
        }

    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
        if (field_total_harga.getText().isEmpty()) {
            Message obj = new Message();
            obj.txt.setText("Anda Belum Memasukkan paket yang dipesan oleh pelanggan!");
            obj.cmdCancel.setVisible(false);
            obj.eventOK(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("Click OK");
                    GlassPanePopup.closePopupLast();
                }
            });
            GlassPanePopup.showPopup(obj);
        } else if (field_harga_paket.getText().isEmpty() && field_keterangan.getText().isEmpty()
                && field_jumlah_barang.getText().isEmpty() && field_subtotal.getText().isEmpty()) {
            containerTransaksi.removeAll();
            containerTransaksi.repaint();
            containerTransaksi.revalidate();
            containerTransaksi.add(lanjutTransaksi3);
            containerTransaksi.repaint();
            containerTransaksi.revalidate();
        } else {
            int jumlah = Integer.parseInt(field_jumlah_barang.getText());
            try {
                int row = tabel_barang.getSelectedRow();
                if ((jumlah == 0) && (field_jumlah_barang.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "harap masukkan jumlah dengan benar");
                } else {
                    boolean result = idlist.contains(tabel_barang.getValueAt(row, 0).toString());
                    if (result == false) {
                        idlist.add(tabel_barang.getValueAt(row, 0).toString());
                        String data[] = {tabel_barang.getValueAt(row, 0).toString(),
                            tabel_barang.getValueAt(row, 1).toString(),
                            tabel_barang.getValueAt(row, 2).toString(), field_jumlah_barang.getText(),
                            field_subtotal.getText(), field_keterangan.getText()};
                        modelpj.addRow(data);
                        reset_nambah_krj();
                        _settotal();
                        //ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                        //JOptionPane.showMessageDialog(null, "Berhasil disimpan di table keranjang", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                        Notification panel = new Notification(this, Notification.Type.SUCCESS,
                                Notification.Location.TOP_CENTER, "Paket Laundry Pemesanan disimpan di table keranjang");
                        panel.showNotification();
                    } else {
                        JOptionPane.showMessageDialog(null, "Data barang sudah terinput");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "harap masukkan jumlah dengan benar");
            }
            containerTransaksi.removeAll();
            containerTransaksi.repaint();
            containerTransaksi.revalidate();
            containerTransaksi.add(lanjutTransaksi3);
            containerTransaksi.repaint();
            containerTransaksi.revalidate();
        }
    }//GEN-LAST:event_kButton8ActionPerformed

    private void tabel_data_pelanggan_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_data_pelanggan_2MouseClicked
        // TODO add your handling code here:
        int baris = tabel_data_pelanggan_2.rowAtPoint(evt.getPoint());
        //session.setId_pelanggan(tabel_data_pelanggan_2.getValueAt(baris, 0).toString());
        //field_id_pelanggan_clone.setText(session.getId_pelanggan());
        String id = tabel_data_pelanggan_2.getValueAt(baris, 0).toString();
        session.setId_pelanggan(id);
        field_id_pelanggan_clone.setText(id);
        //this.selected_pelanggan_id = id;
    }//GEN-LAST:event_tabel_data_pelanggan_2MouseClicked

    private void field_cari_data_pelanggan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_cari_data_pelanggan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_cari_data_pelanggan2ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
        // TODO add your handling code here:
        if (comboboxDataPelanggan.getSelectedItem().equals("Tambah data pelanggan"))
            new formManipultionData.tambahDataPelanggan().setVisible(true);
        else if (comboboxDataPelanggan.getSelectedItem().equals("Edit data pelanggan"))
            if (session.getId_pelanggan() != null) {
                new formManipultionData.edtiDataPelanggan().setVisible(true);
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Harap pilih data pelanggan dulu!");
                panel.showNotification();
            }
        else if (comboboxDataPelanggan.getSelectedItem().equals("Hapus data pelanggan")) {
            if (session.getId_pelanggan() != null) {
                Message obj = new Message();
                obj.txt.setText("Ingin menghapus data pelanggan? tekan ok untuk melanjutkan dan tekan cancel untuk membatalkan!");
                obj.eventOK(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            String sql = "DELETE FROM pelanggan WHERE id_pelanggan='" + session.getId_pelanggan() + "'";
                            Connection con = (Connection) connection.connect.configDB();
                            com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(sql);
                            pst.execute();
                            notifBerhasilHapusDataPelanggan();
                            menampilkan_data_pelanggan(tabel_data_pelanggan_2);
                            menampilkan_data_pelanggan(table_data_pelanggan_kasir);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Data gagal di Hapus" + " " + e.getMessage());
                        }
                        GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(obj);
            } else {
                Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Pilih data pelanggan dahulu!");
                panel.showNotification();
            }
        } else if (comboboxDataPelanggan.getSelectedItem().equals("Refresh Tabel")) {
            menampilkan_data_pelanggan(table_data_pelanggan_kasir);
        }
    }//GEN-LAST:event_kButton6ActionPerformed

    public void notifBerhasilHapusDataPelanggan() {
        Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Data berhasil dihapus!");
        panel.showNotification();
    }
    private void table_data_pelanggan_kasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_data_pelanggan_kasirMouseClicked
        // TODO add your handling code here:
        int baris = table_data_pelanggan_kasir.rowAtPoint(evt.getPoint());
        String tid = table_data_pelanggan_kasir.getValueAt(baris, 0).toString();
        field_id_pelanggan_edit.setText(tid);
        session.setId_pelanggan(tid);
        String tnama = table_data_pelanggan_kasir.getValueAt(baris, 1).toString();
        field_nama_pelanggan_edit.setText(tnama);
        String talamat = table_data_pelanggan_kasir.getValueAt(baris, 2).toString();
        field_alamat_pelanggan_edit.setText(talamat);
        String tno = table_data_pelanggan_kasir.getValueAt(baris, 3).toString();
        field_nomor_telfon_edit.setText(tno);
    }//GEN-LAST:event_table_data_pelanggan_kasirMouseClicked

    private void tabel_data_transaksi_kasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_data_transaksi_kasirMouseClicked
        // TODO add your handling code here:
        int baris = tabel_data_transaksi_kasir.rowAtPoint(evt.getPoint());
        tabel_data_transaksi_kasir.rowAtPoint(evt.getPoint());
        String nm = tabel_data_transaksi_kasir.getValueAt(baris, 0).toString();
        session.setKode_struk(nm);
        field_lanjut_pengembalian.setText(session.getKode_struk());
    }//GEN-LAST:event_tabel_data_transaksi_kasirMouseClicked

    private void namaLoginKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namaLoginKasirMouseClicked
        // TODO add your handling code here:
        new profileSetting.kasir().setVisible(true);
    }//GEN-LAST:event_namaLoginKasirMouseClicked

    private void jLabel107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel107MouseClicked
        // TODO add your handling code here:
        if (session.getKode_struk() == null) {
            Notification panel = new Notification(this, Notification.Type.WARNING,
                    Notification.Location.CENTER, "Harap pilih data di tabel yang hendak di cetak");
            panel.showNotification();
        } else {
            try {
                String jdbcDriver = "com.mysql.jdbc.Driver";
                Class.forName(jdbcDriver);
                String url = "jdbc:mysql://localhost:3306/app_laundry";
                String user = "agungkurniawan";
                String pass = "programmerwebdeveloper";
                Connection conn = DriverManager.getConnection(url, user, pass);
                java.sql.Statement stm = conn.createStatement();
                try {
                    String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                    HashMap hash = new HashMap();
                    //Mengambil parameter dari ireport
                    hash.put("fix", session.getKode_struk());
                    JasperReport JRpt = JasperCompileManager.compileReport(report);
                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, conn);
                    //JasperViewer.viewReport(JPrint, false);
                    JasperPrintManager.printReport(JPrint, false);
                } catch (Exception rptexcpt) {
                    System.out.println("Report Can't view because : " + rptexcpt);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_jLabel107MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        new selengkapnyaPelangganCardKasir().setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        new selengkapnyaPaketDipesanKasir().setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
        judulDb.setText("Transaksi");
        resetColor(menuDashboard);
        resetColor(menuDataPelanggan);
        setColor(menuTransaksi);
        //resetColor(menuHistoryTransaksi);
        containerContent.removeAll();
        containerContent.repaint();
        containerContent.revalidate();
        containerContent.add(tampilanTransaksi);
        containerContent.repaint();
        containerContent.revalidate();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
        new laundryBelumSelesai().setVisible(true);
    }//GEN-LAST:event_kButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new profileSetting.kasir().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void comboboxDataPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxDataPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxDataPelangganActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new profileSetting.kasir().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void field_id_pelanggan_trMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_id_pelanggan_trMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Field sudah permanen, tidak bisa diubah!");
        panel.showNotification();
    }//GEN-LAST:event_field_id_pelanggan_trMouseClicked

    private void id_pelanggan_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_pelanggan_dtMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_id_pelanggan_dtMouseClicked

    private void id_kasir_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_id_kasir_dtMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_id_kasir_dtMouseClicked

    private void tanggal_pesan_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tanggal_pesan_dtMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_tanggal_pesan_dtMouseClicked

    private void tanggal_selesai_dtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tanggal_selesai_dtMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_tanggal_selesai_dtMouseClicked

    private void kButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kButton1MouseClicked
        // TODO add your handling code here:
        Message obj = new Message();
        obj.txt.setText("Saat ingin transaksi anda bisa memilih 2 opsi yaitu jika cari pelanggan dahulu pada tabel jika pelanggan tidak ada maka daftarkan sebagai pelanggan baru!");
        obj.cmdCancel.setVisible(false);
        obj.eventOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                judulDb.setText("Transaksi");
                setColor(menuTransaksi);
                resetColor(menuDashboard);
                resetColor(menuDataPelanggan);
                resetColor(menuDatatransaksi);
                //resetColor(menuHistoryTransaksi);
                containerContent.removeAll();
                containerContent.repaint();
                containerContent.revalidate();
                containerContent.add(tampilanTransaksi);
                containerContent.repaint();
                containerContent.revalidate();
                GlassPanePopup.closePopupLast();
            }
        });
        GlassPanePopup.showPopup(obj);
    }//GEN-LAST:event_kButton1MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        menampilkan_data_pelanggan_data_transaksi(tabel_data_transaksi_kasir);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        // TODO add your handling code here:
        int baris = tabel_barang.rowAtPoint(evt.getPoint());
        tabel_barang.rowAtPoint(evt.getPoint());
        tabel_barang.getValueAt(baris, 0).toString();
        String nm = tabel_barang.getValueAt(baris, 1).toString();
        paketDipilih.setText(nm);
        tabel_barang.getValueAt(baris, 2).toString();
        String pr = tabel_barang.getValueAt(baris, 3).toString();
        field_harga_paket.setText(pr);
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void field_id_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_id_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_id_userActionPerformed

    private void tgl_slsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_slsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_slsActionPerformed

    private void perkiraanSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perkiraanSelesaiActionPerformed
        // TODO add your handling code here:
        if (perkiraanSelesai.getSelectedItem().equals("1 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +1);
            Date sls = cal.getTime();
            String tanggal_selesai = "" + sfDate.format(sls);
            tgl_sls.setText("" + tanggal_selesai);
        } else if (perkiraanSelesai.getSelectedItem().equals("2 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +2);
            Date sls = cal.getTime();
            String tanggal_selesai = "" + sfDate.format(sls);
            tgl_sls.setText("" + tanggal_selesai);
            session.setLama_sls(tanggal_selesai);
        } else if (perkiraanSelesai.getSelectedItem().equals("3 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +3);
            Date sls = cal.getTime();
            String tanggal_selesai = "" + sfDate.format(sls);
            tgl_sls.setText("" + tanggal_selesai);
            session.setLama_sls(tanggal_selesai);
        } else if (perkiraanSelesai.getSelectedItem().equals("4 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +4);
            Date sls = cal.getTime();
            String tanggal_selesai = "" + sfDate.format(sls);
            tgl_sls.setText("" + tanggal_selesai);
            session.setLama_sls(tanggal_selesai);
        } else if (perkiraanSelesai.getSelectedItem().equals("5 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +5);
            Date sls = cal.getTime();
            String tanggal_selesai = "" + sfDate.format(sls);
            tgl_sls.setText("" + tanggal_selesai);
            session.setLama_sls(tanggal_selesai);
        } else if (perkiraanSelesai.getSelectedItem().equals("6 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +6);
            Date sls = cal.getTime();
            String tanggal_selesai = "" + sfDate.format(sls);
            tgl_sls.setText("" + tanggal_selesai);
            session.setLama_sls(tanggal_selesai);
        } else if (perkiraanSelesai.getSelectedItem().equals("7 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +7);
            Date sls = cal.getTime();
            String tanggal_selesai = "" + sfDate.format(sls);
            tgl_sls.setText("" + tanggal_selesai);
            session.setLama_sls(tanggal_selesai);
        }
    }//GEN-LAST:event_perkiraanSelesaiActionPerformed

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
            java.util.logging.Logger.getLogger(dashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button cmd1;
    private button.Button cmd3;
    private button.Button cmd6;
    private combobox.Combobox comboboxDataPelanggan;
    private javax.swing.JPanel container;
    private javax.swing.JPanel containerContent;
    private javax.swing.JPanel containerDataTransaksi;
    private javax.swing.JPanel containerTransaksi;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JLabel dataPelangganLabel;
    private javax.swing.JLabel datatransaksiLabel;
    private textfield.TextField field_alamat_pelanggan_tr;
    private textfield.TextField field_bayar;
    private swing.TextFieldAnimation field_cari_data_pelanggan;
    private swing.TextFieldAnimation field_cari_data_pelanggan2;
    private swing.TextFieldAnimation field_cari_data_transaksi;
    private textfield.TextField field_harga_paket;
    public static final textfield.TextField field_id_pelanggan = new textfield.TextField();
    private textfield.TextField field_id_pelanggan_tr;
    private textfield.TextField field_id_user;
    private textfield.TextField field_jumlah_barang;
    private textfield.TextField field_kembalian;
    private textfield.TextField field_keterangan;
    private textfield.TextField field_kode_nota;
    private javax.swing.JTextField field_lanjut_pengembalian;
    private textfield.TextField field_nama_pelanggan_tr;
    private textfield.TextField field_notel_tr;
    private textfield.TextField field_sisa_bayar;
    private textfield.TextField field_status_bayar;
    private textfield.TextField field_subtotal;
    private javax.swing.JTextField field_total_harga;
    private textfield.TextField id_kasir_dt;
    private textfield.TextField id_pelanggan_dt;
    private javax.swing.JPanel inputPelanggan;
    private javax.swing.JLabel jLabel1;
    public static final javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    public static final javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel judulDb;
    public static final javax.swing.JLabel jumlahPaketDipesan = new javax.swing.JLabel();
    private textfield.TextField jumlah_bayar_dt;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton11;
    private com.k33ptoo.components.KButton kButton12;
    private com.k33ptoo.components.KButton kButton13;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KButton kButton6;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KButton kButton8;
    public static final textfield.TextField kd_struk_data_transaksi = new textfield.TextField();
    private textfield.TextField kembalian_dt;
    private textfield.TextField kembalian_pembayaran_dt;
    private javax.swing.JPanel lanjutTransaksi1;
    private javax.swing.JPanel lanjutTransaksi2;
    private javax.swing.JPanel lanjutTransaksi3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel menuDashboard;
    private javax.swing.JPanel menuDataPelanggan;
    private javax.swing.JPanel menuDatatransaksi;
    private javax.swing.JPanel menuHistoryTransaksi;
    private javax.swing.JPanel menuTransaksi;
    private javax.swing.JLabel menuTransaksiLabel;
    public static final javax.swing.JLabel namaLoginKasir = new javax.swing.JLabel();
    private javax.swing.JTextField nomorak;
    private combobox.Combobox norak;
    private javax.swing.JLabel paketDipilih;
    private textfield.TextField pembayaran_dt;
    private combobox.Combobox perkiraanSelesai;
    public static final javax.swing.JTextField profileKS = new javax.swing.JTextField();
    private javax.swing.JTextField sisa_bayar_dt;
    private combobox.Combobox status_ambil_dt;
    private javax.swing.JTextField status_bayar_dt;
    public static final javax.swing.JTable tabel_barang = new javax.swing.JTable();
    public static final javax.swing.JTable tabel_data_pelanggan_2 = new javax.swing.JTable();
    public static final javax.swing.JTable tabel_data_transaksi_kasir = new javax.swing.JTable();
    private javax.swing.JTable tabel_penjualan;
    public static final javax.swing.JTable table_data_pelanggan_kasir = new javax.swing.JTable();
    private javax.swing.JPanel tahapKedua;
    private javax.swing.JPanel tahapKetiga;
    private javax.swing.JPanel tahapPertama;
    private javax.swing.JPanel tampilanAwalTransaksi;
    private javax.swing.JPanel tampilanDashboardUtama;
    private javax.swing.JPanel tampilanDataPelanggan;
    private javax.swing.JPanel tampilanDataTransaksi;
    private javax.swing.JPanel tampilanTransaksi;
    private javax.swing.JTextField tanggalOtomatis;
    private textfield.TextField tanggal_pesan_dt;
    private textfield.TextField tanggal_selesai_dt;
    private javax.swing.JPanel tempatJuduldanUser;
    private javax.swing.JTextField tgl_sls;
    private javax.swing.JTextField total_harga_dt;
    private javax.swing.JPanel wrapperKontent;
    private javax.swing.JPanel wrapperMenu;
    // End of variables declaration//GEN-END:variables
}
