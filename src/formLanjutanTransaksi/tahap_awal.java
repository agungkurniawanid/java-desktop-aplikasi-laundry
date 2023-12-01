package formLanjutanTransaksi;

import com.barcodelib.barcode.Linear;
import com.mysql.jdbc.Statement;
import connection.connect;
import static dashboard.dashboardAdmin.tabel_data_transaksi;
import dashboard.dashboardKasir;
import static dashboard.dashboardKasir.jLabel7;
import static dashboard.dashboardKasir.jumlahPaketDipesan;
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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import notification.Notification;
import raven.glasspanepopup.GlassPanePopup;
import sample.message.Message;
import tableCustomize.TableCustom;
import static dashboard.dashboardKasir.tabel_data_transaksi_kasir;
import static dashboard.laundryBelumSelesai.tb1;
import static dashboard.laundryBelumSelesai.tb2;
import static dashboard.selengkapnyaPaketDipesanKasir.paketKiloan;
import static dashboard.selengkapnyaPaketDipesanKasir.paketSatuan;
import java.io.File;
import java.util.Map;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import session.session;

public class tahap_awal extends javax.swing.JFrame {

    ArrayList<String> idlist = new ArrayList<String>();
    DefaultTableModel modelpj;
    public int thotal;
    public int tot_brg;

    public tahap_awal() {

        initComponents();

        // tabel
        TableCustom.apply(jScrollPane1, TableCustom.TableType.MULTI_LINE);
        tampil_data_barang(tabel_barang_clone);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.MULTI_LINE);
        tampil_data_penjualan(tabel_penjualan_clone);

        //notif
        GlassPanePopup.install(this);
        getContentPane().setBackground(Color.WHITE);

        // untuk transaksi
        field_harga_paket_clone.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input1 = Integer.parseInt(field_harga_paket_clone.getText());
                    int input2 = Integer.parseInt(field_jumlah_barang_clone.getText());
                    int hasil = input1 * input2;
                    field_subtotal_clone.setText("" + hasil);
                } catch (NumberFormatException ex) {
                    //field_subtotal.setText("");
                }
            }
        });
        field_jumlah_barang_clone.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input1 = Integer.parseInt(field_harga_paket_clone.getText());
                    int input2 = Integer.parseInt(field_jumlah_barang_clone.getText());
                    int hasil = input1 * input2;
                    field_subtotal_clone.setText("" + hasil);
                } catch (NumberFormatException ex) {
                    //hasilLabel.setText("");
                }
            }
        });
        field_total_harga_clone.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input2 = Integer.parseInt(field_total_harga_clone.getText());
                    int input1 = Integer.parseInt(field_bayar_clone.getText());
                    int hasil = input1 - input2;
                    int lain = input1 - input2;
                    if (hasil == 0) {
                        field_status_bayar_clone.setText("Lunas");
                        field_sisa_bayar_clone.setText("" + hasil);
                        field_kembalian_clone.setText("" + hasil);
                    } else if (input1 > input2) {
                        field_status_bayar_clone.setText("Lunas");
                        field_sisa_bayar_clone.setText("" + 0);
                        field_kembalian_clone.setText("" + lain);
                    } else if (hasil == input2) {
                        field_status_bayar_clone.setText("Belum bayar");
                        field_sisa_bayar_clone.setText("" + hasil);
                        field_kembalian_clone.setText("0");
                    } else if (hasil < input2) {
                        field_status_bayar_clone.setText("Kurang");
                        field_sisa_bayar_clone.setText("" + hasil);
                        field_kembalian_clone.setText("" + 0);
                    }
                } catch (NumberFormatException ex) {
                    //field_subtotal.setText("");
                }
            }
        });
        field_bayar_clone.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    int input2 = Integer.parseInt(field_total_harga_clone.getText());
                    int input1 = Integer.parseInt(field_bayar_clone.getText());
                    int hasil = input1 - input2;
                    int lain = input1 - input2;
                    if (hasil == 0) {
                        field_status_bayar_clone.setText("Lunas");
                        field_sisa_bayar_clone.setText("" + hasil);
                        field_kembalian_clone.setText("" + hasil);
                    } else if (input1 > input2) {
                        field_status_bayar_clone.setText("Lunas");
                        field_sisa_bayar_clone.setText("" + 0);
                        field_kembalian_clone.setText("" + lain);
                    } else if (hasil == input2) {
                        field_status_bayar_clone.setText("Belum Bayar");
                        field_sisa_bayar_clone.setText("" + hasil);
                        field_kembalian_clone.setText("0");
                    } else if (hasil < input2) {
                        field_status_bayar_clone.setText("Kurang");
                        field_sisa_bayar_clone.setText("" + Math.abs(hasil));
                        field_kembalian_clone.setText("" + 0);
                    }
                } catch (NumberFormatException ex) {
                    //hasilLabel.setText("");
                }
            }
        });

        // method
        menampilkan_data_pelanggan_data_transaksi();
        reset_nambah_krj();
        kodeTransaksiOtomatis();
        resetKeranjang();
        transaksiHariIni();

        // mengunci ukuran
        setMinimumSize(getSize());
        ngitung_jmkl_odrpkt_hrian();
        ngitung_jmkl_odrpkt_satuan();
        laundryBelumSelesai(tb2);
        laundrySelesai(tb1);

        // harus berisi angka
        field_jumlah_barang_clone.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(field_jumlah_barang_clone.getText());
                } catch (NumberFormatException ex) {
                    if (field_jumlah_barang_clone.getText().isEmpty()) {
                        System.out.println("");
                    } else {
                        harusAngka();
                    }
                }
            }
        });
        field_bayar_clone.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyPressed(KeyEvent e) {
                // tidak perlu dilakukan apa-apa
            }

            public void keyReleased(KeyEvent e) {
                try {
                    Long.parseLong(field_bayar_clone.getText());
                } catch (NumberFormatException ex) {
                    if (field_bayar_clone.getText().isEmpty()) {
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
        tahap_awal = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        kButton3 = new com.k33ptoo.components.KButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tahap_kedua = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        kButton7 = new com.k33ptoo.components.KButton();
        kButton8 = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tahap_ketiga = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        cmd6 = new button.Button();
        cmd1 = new button.Button();
        jLabel50 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tgl_sls = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        container.setLayout(new java.awt.CardLayout());

        tahap_awal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel38.setText("ID Pelanggan");

        jLabel39.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel39.setText("ID Pelanggan pada kolom dibawah adalah pelanggan");

        jLabel40.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel40.setText("yang akan melakukan transaksi");

        field_id_pelanggan_clone.setEnabled(false);
        field_id_pelanggan_clone.setLabelText("ID Pelanggan");
        field_id_pelanggan_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_id_pelanggan_cloneMouseClicked(evt);
            }
        });

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconJoptionPane/menu.png"))); // NOI18N
        jLabel47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel44.setText("ID Anda Sebagai Kasir");

        jLabel45.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel45.setText("ID anda akan tampil pada data dan nota transaksi");

        jLabel46.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel46.setText("sehingga admin tahu bahwa anda telah melakukan transaksi");

        field_id_user_clone.setEnabled(false);
        field_id_user_clone.setLabelText("ID Anda ");
        field_id_user_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_id_user_cloneMouseClicked(evt);
            }
        });

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconJoptionPane/menu.png"))); // NOI18N
        jLabel48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
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

        field_kode_nota_clone.setEnabled(false);
        field_kode_nota_clone.setLabelText("Kode Transaksi");
        field_kode_nota_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_kode_nota_cloneMouseClicked(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel43.setText("tampil pada nota dan kunci data transaksi.");

        jLabel42.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel42.setText("Pada Field dibawah adalah kode transaksi yang akan");

        jLabel41.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel41.setText("Kode Transaksi");

        javax.swing.GroupLayout tahap_awalLayout = new javax.swing.GroupLayout(tahap_awal);
        tahap_awal.setLayout(tahap_awalLayout);
        tahap_awalLayout.setHorizontalGroup(
            tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahap_awalLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahap_awalLayout.createSequentialGroup()
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(489, 489, 489))
                    .addGroup(tahap_awalLayout.createSequentialGroup()
                        .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(173, 173, 173))
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(117, 117, 117))
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(field_id_pelanggan_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGap(90, 90, 90)
                        .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(149, 149, 149))
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(52, 52, 52))
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(field_kode_nota_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25, 25, 25))))
                    .addGroup(tahap_awalLayout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(467, 467, 467))
                    .addGroup(tahap_awalLayout.createSequentialGroup()
                        .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(303, 303, 303))
                            .addComponent(field_id_user_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tahap_awalLayout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(362, 362, 362)))
                        .addGap(25, 25, 25)))
                .addGap(166, 166, 166))
        );
        tahap_awalLayout.setVerticalGroup(
            tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahap_awalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahap_awalLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tahap_awalLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(field_id_pelanggan_clone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel47)))
                    .addGroup(tahap_awalLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(field_kode_nota_clone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addGap(0, 0, 0)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tahap_awalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(field_id_user_clone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(38, 38, 38)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        container.add(tahap_awal, "card2");

        tahap_kedua.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel37.setText("Kembali");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel80.setText("Paket yang dipilih :");

        paketDipilih_clone.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        paketDipilih_clone.setForeground(new java.awt.Color(0, 102, 255));
        paketDipilih_clone.setText(". . . .");

        jLabel36.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel36.setText("Pilih / tekan data paket yang dipilh pelanggan lalu isi form dibawah.");

        field_harga_paket_clone.setEnabled(false);
        field_harga_paket_clone.setLabelText("Harga Paket");
        field_harga_paket_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_harga_paket_cloneMouseClicked(evt);
            }
        });

        field_keterangan_clone.setLabelText("Keterangan Barang (Opsional)");
        field_keterangan_clone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_keterangan_cloneActionPerformed(evt);
            }
        });

        field_jumlah_barang_clone.setLabelText("Masukkan Jumlah Kuantitas");
        field_jumlah_barang_clone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_jumlah_barang_cloneActionPerformed(evt);
            }
        });

        field_subtotal_clone.setEnabled(false);
        field_subtotal_clone.setLabelText("Subtotal Harga");
        field_subtotal_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_subtotal_cloneMouseClicked(evt);
            }
        });

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

        tabel_barang_clone.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_barang_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barang_cloneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang_clone);

        javax.swing.GroupLayout tahap_keduaLayout = new javax.swing.GroupLayout(tahap_kedua);
        tahap_kedua.setLayout(tahap_keduaLayout);
        tahap_keduaLayout.setHorizontalGroup(
            tahap_keduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahap_keduaLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addGap(47, 47, 47)
                .addGroup(tahap_keduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(field_harga_paket_clone, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_keterangan_clone, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_jumlah_barang_clone, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_subtotal_clone, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tahap_keduaLayout.createSequentialGroup()
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
            .addGroup(tahap_keduaLayout.createSequentialGroup()
                .addGroup(tahap_keduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahap_keduaLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel37))
                    .addGroup(tahap_keduaLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel80)
                        .addGap(6, 6, 6)
                        .addComponent(paketDipilih_clone, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tahap_keduaLayout.setVerticalGroup(
            tahap_keduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahap_keduaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel37)
                .addGap(33, 33, 33)
                .addGroup(tahap_keduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addComponent(paketDipilih_clone))
                .addGap(14, 14, 14)
                .addGroup(tahap_keduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahap_keduaLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(field_harga_paket_clone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_keterangan_clone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_jumlah_barang_clone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(field_subtotal_clone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(tahap_keduaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );

        container.add(tahap_kedua, "card3");

        tahap_ketiga.setBackground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/illustration/before.png"))); // NOI18N
        jLabel51.setText("Kembali");
        jLabel51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel83.setText("TOTAL HARGA :");

        field_total_harga_clone.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        field_total_harga_clone.setBorder(null);

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

        jLabel50.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel50.setText("Tabel disamping adalah paket");

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText(" cuci yang dipilih oleh pelanggan.");

        norak_clone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        norak_clone.setSelectedIndex(-1);
        norak_clone.setLabeText("Pilih Nomor Rak");

        perkiraanSelesai_clone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 Hari", "2 Hari", "3 Hari", "4 Hari", "5 Hari", "6 Hari", "7 Hari" }));
        perkiraanSelesai_clone.setSelectedIndex(-1);
        perkiraanSelesai_clone.setLabeText("Perkiraan Selesai Laundry");
        perkiraanSelesai_clone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perkiraanSelesai_cloneActionPerformed(evt);
            }
        });

        field_bayar_clone.setLabelText("Masukkan Pembayaran Pelanggan");

        field_status_bayar_clone.setEnabled(false);
        field_status_bayar_clone.setLabelText("Status Bayar");
        field_status_bayar_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_status_bayar_cloneMouseClicked(evt);
            }
        });

        field_sisa_bayar_clone.setEnabled(false);
        field_sisa_bayar_clone.setLabelText("Sisa Harus Dibayar Oleh Client");
        field_sisa_bayar_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_sisa_bayar_cloneMouseClicked(evt);
            }
        });

        field_kembalian_clone.setEnabled(false);
        field_kembalian_clone.setLabelText("Kembalian");
        field_kembalian_clone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_kembalian_cloneMouseClicked(evt);
            }
        });
        field_kembalian_clone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_kembalian_cloneActionPerformed(evt);
            }
        });

        tabel_penjualan_clone.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabel_penjualan_clone);

        tgl_sls.setForeground(new java.awt.Color(255, 255, 255));
        tgl_sls.setBorder(null);
        tgl_sls.setCaretColor(new java.awt.Color(255, 255, 255));
        tgl_sls.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tgl_sls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_slsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tahap_ketigaLayout = new javax.swing.GroupLayout(tahap_ketiga);
        tahap_ketiga.setLayout(tahap_ketigaLayout);
        tahap_ketigaLayout.setHorizontalGroup(
            tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahap_ketigaLayout.createSequentialGroup()
                .addGroup(tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahap_ketigaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel51))
                    .addGroup(tahap_ketigaLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(field_total_harga_clone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tahap_ketigaLayout.createSequentialGroup()
                .addGroup(tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahap_ketigaLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane2)
                        .addGap(28, 28, 28))
                    .addGroup(tahap_ketigaLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(cmd6, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cmd1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(norak_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(perkiraanSelesai_clone, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(field_bayar_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_status_bayar_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_sisa_bayar_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_kembalian_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tgl_sls)
                    .addGroup(tahap_ketigaLayout.createSequentialGroup()
                        .addGroup(tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        tahap_ketigaLayout.setVerticalGroup(
            tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tahap_ketigaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel51)
                .addGap(28, 28, 28)
                .addGroup(tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(field_total_harga_clone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tahap_ketigaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(13, 13, 13)
                        .addGroup(tahap_ketigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(tahap_ketigaLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(norak_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(perkiraanSelesai_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(field_bayar_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(field_status_bayar_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(field_sisa_bayar_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(field_kembalian_clone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tgl_sls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );

        container.add(tahap_ketiga, "card4");

        getContentPane().add(container, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void harusAngka() {
        Notification panel = new Notification(this, Notification.Type.WARNING, Notification.Location.CENTER, "Field hanya boleh berisi angka!");
        panel.showNotification();
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
            String sql = "SELECT SUM(qty) as total_paket_ini from tbl_order join tbl_detail_order on tbl_order.kode_order = tbl_detail_order.kode_order join paket on tbl_detail_order.kd_paket = paket.kd_paket where tbl_order.tgl_selesai = current_date() && paket.jenis_paket = 'kiloan';";
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
                field_kode_nota_clone.setText("TR" + Nol + AN);
            } else {
                //field_kode_nota.setText("TR0001");//sesuaikan dengan variable namenya
                field_kode_nota_clone.setText("TR0001");
            }
            res.close();
        } catch (Exception e) {
            //penanganan masalah
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void menampilkan_data_pelanggan_data_transaksi() {
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
    }

    public void notif() {
        Notification panel = new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Datap pelanggan berhasil ditambahkan!");
        panel.showNotification();
    }

    public void tampil_data_penjualan(JTable table) {
        String[] judul = {"ID", "Nama paket", "Harga", "jumlah", " subtotal", "keterangan"};
        modelpj = new DefaultTableModel(judul, 0);
        tabel_penjualan_clone.setModel(modelpj);
    }
    private void field_id_pelanggan_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_id_pelanggan_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_id_pelanggan_clone.setEditable(false);
    }//GEN-LAST:event_field_id_pelanggan_cloneMouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM pelanggan WHERE id_pelanggan = '" + field_id_pelanggan_clone.getText() + "'";
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

    private void field_id_user_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_id_user_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_id_user_clone.setEnabled(false);
    }//GEN-LAST:event_field_id_user_cloneMouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM user WHERE id_user = '" + field_id_user_clone.getText() + "'";
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

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(tahap_kedua);
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void field_kode_nota_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_kode_nota_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_kode_nota_clone.setEditable(false);
    }//GEN-LAST:event_field_kode_nota_cloneMouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(tahap_awal);
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_jLabel37MouseClicked

    public void buatbarcode() {
        try {
            Linear barcod = new Linear();
            barcod.setType(Linear.CODE128);
            barcod.setData(field_kode_nota_clone.getText());
            barcod.setI(11.0f);
            String fname = field_kode_nota_clone.getText();
            barcod.renderBarcode("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\barcode\\" + fname + ".png");
        } catch (Exception ex) {
            Logger.getLogger(dashboardKasir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void field_harga_paket_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_harga_paket_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_harga_paket_clone.setEditable(false);
    }//GEN-LAST:event_field_harga_paket_cloneMouseClicked

    private void field_keterangan_cloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_keterangan_cloneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_keterangan_cloneActionPerformed

    private void field_subtotal_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_subtotal_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
        field_harga_paket_clone.setEditable(false);
    }//GEN-LAST:event_field_subtotal_cloneMouseClicked

    private boolean Numeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed
        // TODO add your handling code here:
        try {
            if (field_harga_paket_clone.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Field Pemesanan kosong!");
                panel.showNotification();
            } else if (field_jumlah_barang_clone.getText().isEmpty()) {
                Notification panel = new Notification(this, Notification.Type.WARNING,
                        Notification.Location.CENTER, "Field Jumlah Kuantitas Kosong!");
                panel.showNotification();
            } else {
                int jumlah = Integer.parseInt(field_jumlah_barang_clone.getText());
                try {
                    int row = tabel_barang_clone.getSelectedRow();
                    if ((jumlah == 0) && (field_jumlah_barang_clone.getText().equals(""))) {
                        JOptionPane.showMessageDialog(null, "harap masukkan jumlah dengan benar");
                    } else {
                        boolean result = idlist.contains(tabel_barang_clone.getValueAt(row, 0).toString());
                        if (result == false) {
                            idlist.add(tabel_barang_clone.getValueAt(row, 0).toString());
                            String data[] = {tabel_barang_clone.getValueAt(row, 0).toString(),
                                tabel_barang_clone.getValueAt(row, 1).toString(),
                                tabel_barang_clone.getValueAt(row, 2).toString(),
                                field_jumlah_barang_clone.getText(), field_subtotal_clone.getText(), field_keterangan_clone.getText()};
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

    void resetKeranjang() {
        DefaultTableModel model = (DefaultTableModel) tabel_penjualan_clone.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void reset_nambah_krj() {
        field_subtotal_clone.setText("");
        field_keterangan_clone.setText("");
        field_jumlah_barang_clone.setText("");
        field_harga_paket_clone.setText("");
    }

    private void _settotal() {
        int total_pjl = 0;
        int row = tabel_penjualan_clone.getRowCount();
        int tuotal = 0;
        for (int i = 0; i < row; i++) {
            int sb = Integer.parseInt(tabel_penjualan_clone.getValueAt(i, 4).toString()); //22000
            int tot = Integer.parseInt(tabel_penjualan_clone.getValueAt(i, 3).toString());
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
        field_total_harga_clone.setText(String.valueOf(this.thotal));
    }

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
        if (field_total_harga_clone.getText().isEmpty()) {
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
        } else if (field_harga_paket_clone.getText().isEmpty() && field_keterangan_clone.getText().isEmpty()
                && field_jumlah_barang_clone.getText().isEmpty() && field_subtotal_clone.getText().isEmpty()) {
            container.removeAll();
            container.repaint();
            container.revalidate();
            container.add(tahap_ketiga);
            container.repaint();
            container.revalidate();
        } else {
            int jumlah = Integer.parseInt(field_jumlah_barang_clone.getText());
            try {
                int row = tabel_barang_clone.getSelectedRow();
                if ((jumlah == 0) && (field_jumlah_barang_clone.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "harap masukkan jumlah dengan benar");
                } else {
                    boolean result = idlist.contains(tabel_barang_clone.getValueAt(row, 0).toString());
                    if (result == false) {
                        idlist.add(tabel_barang_clone.getValueAt(row, 0).toString());
                        String data[] = {tabel_barang_clone.getValueAt(row, 0).toString(),
                            tabel_barang_clone.getValueAt(row, 1).toString(),
                            tabel_barang_clone.getValueAt(row, 2).toString(), field_jumlah_barang_clone.getText(),
                            field_subtotal_clone.getText(), field_keterangan_clone.getText()};
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
            container.removeAll();
            container.repaint();
            container.revalidate();
            container.add(tahap_ketiga);
            container.repaint();
            container.revalidate();
        }
    }//GEN-LAST:event_kButton8ActionPerformed

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        // TODO add your handling code here:
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(tahap_kedua);
        container.repaint();
        container.revalidate();
    }//GEN-LAST:event_jLabel51MouseClicked

    public void tampil_data_barang(JTable table) {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Kode Paket");
        tbl.addColumn("Nama Paket");
        tbl.addColumn("Jenis Paket");
        tbl.addColumn("Harga Paket");
        tabel_barang_clone.setModel(tbl);

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
                tabel_barang_clone.setModel(tbl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
        }
    }

    public void transaksiHariIni() {
        try {
            String sql = "select sum(grand_total) as total_hari_ini from tbl_order where tgl_pesan = curdate()";
            java.sql.Connection conn = (com.mysql.jdbc.Connection) connection.connect.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            int totalHariIni = rs.getInt("total_hari_ini");
            jLabel7.setText("" + totalHariIni);
        } catch (Exception e) {
        }
    }

    private void cmd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd6ActionPerformed
        // TODO add your handling code here:
        if (perkiraanSelesai_clone.getSelectedItem().equals("1 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            int rows = tabel_penjualan_clone.getRowCount();
            String KD = field_kode_nota_clone.getText();
            int grand_total = Integer.parseInt(field_total_harga_clone.getText());
            int kembalian = Integer.parseInt(field_kembalian_clone.getText());
            int majer = Integer.parseInt(field_bayar_clone.getText());
            int sisa_byr = Integer.parseInt(field_sisa_bayar_clone.getText());
            String idplga = field_id_pelanggan_clone.getText();
            int rak = Integer.parseInt((String) norak_clone.getSelectedItem());
            String skr = "" + sfDate.format(tanggal);
            java.sql.Connection conn = null;
            try {
                Connection con = (Connection) connect.configDB();
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +1);
                Date sls = cal.getTime();
                String tanggal_selesai = "" + sfDate.format(sls);
                String stsAmbil = "belum di ambil";
                String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user_clone.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar_clone.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
                pst1.execute();
                for (int i = 0; i < rows; i++) {
                    String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan_clone.getValueAt(i, 0).toString() + "',"
                            + "'" + tabel_penjualan_clone.getValueAt(i, 3).toString() + "','" + tabel_penjualan_clone.getValueAt(i, 4).toString() + "', "
                            + "'" + tabel_penjualan_clone.getValueAt(i, 5).toString() + "')";
                    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
                    pst2.execute();
                    field_total_harga_clone.setText("");
                    norak_clone.setSelectedItem("");
                    perkiraanSelesai_clone.setSelectedItem("");
                    field_bayar_clone.setText("");
                    field_status_bayar_clone.setText("");
                    field_sisa_bayar_clone.setText("");
                    field_kembalian_clone.setText("");
                    menampilkan_data_pelanggan_data_transaksi();
                    dispose();
                }
                resetKeranjang();
                ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                try {
                    String jdbcDriver = "com.mysql.jdbc.Driver";
                    Class.forName(jdbcDriver);
                    String url = "jdbc:mysql://localhost:3306/app_laundry";
                    String user = "agungkurniawan";
                    String pass = "programmerwebdeveloper";
                    Connection cone = DriverManager.getConnection(url, user, pass);
                    java.sql.Statement stm = cone.createStatement();
                    try {
                        String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                        HashMap hash = new HashMap();
                        //Mengambil parameter dari ireport
                        hash.put("fix", field_kode_nota_clone.getText());
                        JasperReport JRpt = JasperCompileManager.compileReport(report);
                        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, cone);
                        JasperViewer.viewReport(JPrint, false);
                        //JasperPrintManager.printReport(JPrint, false);
                    } catch (Exception rptexcpt) {
                        System.out.println("Report Can't view because : " + rptexcpt);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
            buatbarcode();
            transaksiHariIni();
            ngitung_jmkl_odrpkt_hrian();
            ngitung_jmkl_odrpkt_satuan();
            norak_clone.setSelectedItem("");
            perkiraanSelesai_clone.setSelectedItem("");
            field_status_bayar_clone.setText("");
            field_sisa_bayar_clone.setText("");
            field_kembalian_clone.setText("");
        } else if (perkiraanSelesai_clone.getSelectedItem().equals("2 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            int rows = tabel_penjualan_clone.getRowCount();
            String KD = field_kode_nota_clone.getText();
            int grand_total = Integer.parseInt(field_total_harga_clone.getText());
            int kembalian = Integer.parseInt(field_kembalian_clone.getText());
            int majer = Integer.parseInt(field_bayar_clone.getText());
            int sisa_byr = Integer.parseInt(field_sisa_bayar_clone.getText());
            String idplga = field_id_pelanggan_clone.getText();
            int rak = Integer.parseInt((String) norak_clone.getSelectedItem());
            String skr = "" + sfDate.format(tanggal);
            java.sql.Connection conn = null;
            try {
                Connection con = (Connection) connect.configDB();
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +2);
                Date sls = cal.getTime();
                String tanggal_selesai = "" + sfDate.format(sls);
                String stsAmbil = "belum di ambil";

                String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user_clone.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar_clone.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
                pst1.execute();
                for (int i = 0; i < rows; i++) {
                    String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan_clone.getValueAt(i, 0).toString() + "',"
                            + "'" + tabel_penjualan_clone.getValueAt(i, 3).toString() + "','" + tabel_penjualan_clone.getValueAt(i, 4).toString() + "', "
                            + "'" + tabel_penjualan_clone.getValueAt(i, 5).toString() + "')";
                    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
                    pst2.execute();

                    field_total_harga_clone.setText("");
                    norak_clone.setSelectedItem("");
                    perkiraanSelesai_clone.setSelectedItem("");
                    field_bayar_clone.setText("");
                    field_status_bayar_clone.setText("");
                    field_sisa_bayar_clone.setText("");
                    field_kembalian_clone.setText("");
                    menampilkan_data_pelanggan_data_transaksi();
                    dispose();
                }
                resetKeranjang();
                ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                try {
                    String jdbcDriver = "com.mysql.jdbc.Driver";
                    Class.forName(jdbcDriver);
                    String url = "jdbc:mysql://localhost:3306/app_laundry";
                    String user = "agungkurniawan";
                    String pass = "programmerwebdeveloper";
                    Connection cone = DriverManager.getConnection(url, user, pass);
                    java.sql.Statement stm = cone.createStatement();
                    try {
                        String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                        HashMap hash = new HashMap();
                        //Mengambil parameter dari ireport
                        hash.put("fix", field_kode_nota_clone.getText());
                        JasperReport JRpt = JasperCompileManager.compileReport(report);
                        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, cone);
                        JasperViewer.viewReport(JPrint, false);
                        //JasperPrintManager.printReport(JPrint, false);
                    } catch (Exception rptexcpt) {
                        System.out.println("Report Can't view because : " + rptexcpt);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
            buatbarcode();
            transaksiHariIni();
            ngitung_jmkl_odrpkt_hrian();
            ngitung_jmkl_odrpkt_satuan();
            norak_clone.setSelectedItem("");
            perkiraanSelesai_clone.setSelectedItem("");
            field_status_bayar_clone.setText("");
            field_sisa_bayar_clone.setText("");
            field_kembalian_clone.setText("");
        } else if (perkiraanSelesai_clone.getSelectedItem().equals("3 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            int rows = tabel_penjualan_clone.getRowCount();
            String KD = field_kode_nota_clone.getText();
            int grand_total = Integer.parseInt(field_total_harga_clone.getText());
            int kembalian = Integer.parseInt(field_kembalian_clone.getText());
            int majer = Integer.parseInt(field_bayar_clone.getText());
            int sisa_byr = Integer.parseInt(field_sisa_bayar_clone.getText());
            String idplga = field_id_pelanggan_clone.getText();
            int rak = Integer.parseInt((String) norak_clone.getSelectedItem());
            String skr = "" + sfDate.format(tanggal);
            java.sql.Connection conn = null;
            try {
                Connection con = (Connection) connect.configDB();
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +3);
                Date sls = cal.getTime();
                String tanggal_selesai = "" + sfDate.format(sls);
                String stsAmbil = "belum di ambil";
                String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user_clone.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar_clone.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
                pst1.execute();
                for (int i = 0; i < rows; i++) {
                    String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan_clone.getValueAt(i, 0).toString() + "',"
                            + "'" + tabel_penjualan_clone.getValueAt(i, 3).toString() + "','" + tabel_penjualan_clone.getValueAt(i, 4).toString() + "', "
                            + "'" + tabel_penjualan_clone.getValueAt(i, 5).toString() + "')";
                    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
                    pst2.execute();
                    field_total_harga_clone.setText("");
                    norak_clone.setSelectedItem("");
                    perkiraanSelesai_clone.setSelectedItem("");
                    field_bayar_clone.setText("");
                    field_status_bayar_clone.setText("");
                    field_sisa_bayar_clone.setText("");
                    field_kembalian_clone.setText("");
                    menampilkan_data_pelanggan_data_transaksi();
                    dispose();
                }
                resetKeranjang();
                ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                try {
                    String jdbcDriver = "com.mysql.jdbc.Driver";
                    Class.forName(jdbcDriver);
                    String url = "jdbc:mysql://localhost:3306/app_laundry";
                    String user = "agungkurniawan";
                    String pass = "programmerwebdeveloper";
                    Connection cone = DriverManager.getConnection(url, user, pass);
                    java.sql.Statement stm = cone.createStatement();
                    try {
                        String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                        HashMap hash = new HashMap();
                        //Mengambil parameter dari ireport
                        hash.put("fix", field_kode_nota_clone.getText());
                        JasperReport JRpt = JasperCompileManager.compileReport(report);
                        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, cone);
                        JasperViewer.viewReport(JPrint, false);
                        //JasperPrintManager.printReport(JPrint, false);
                    } catch (Exception rptexcpt) {
                        System.out.println("Report Can't view because : " + rptexcpt);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
            buatbarcode();
            transaksiHariIni();
            ngitung_jmkl_odrpkt_hrian();
            ngitung_jmkl_odrpkt_satuan();
            norak_clone.setSelectedItem("");
            perkiraanSelesai_clone.setSelectedItem("");
            field_status_bayar_clone.setText("");
            field_sisa_bayar_clone.setText("");
            field_kembalian_clone.setText("");
        } else if (perkiraanSelesai_clone.getSelectedItem().equals("4 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            int rows = tabel_penjualan_clone.getRowCount();
            String KD = field_kode_nota_clone.getText();
            int grand_total = Integer.parseInt(field_total_harga_clone.getText());
            int kembalian = Integer.parseInt(field_kembalian_clone.getText());
            int majer = Integer.parseInt(field_bayar_clone.getText());
            int sisa_byr = Integer.parseInt(field_sisa_bayar_clone.getText());
            String idplga = field_id_pelanggan_clone.getText();
            int rak = Integer.parseInt((String) norak_clone.getSelectedItem());
            String skr = "" + sfDate.format(tanggal);
            java.sql.Connection conn = null;
            try {
                Connection con = (Connection) connect.configDB();
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +4);
                Date sls = cal.getTime();
                String tanggal_selesai = "" + sfDate.format(sls);
                String stsAmbil = "belum di ambil";

                String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user_clone.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar_clone.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
                pst1.execute();
                for (int i = 0; i < rows; i++) {
                    String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan_clone.getValueAt(i, 0).toString() + "',"
                            + "'" + tabel_penjualan_clone.getValueAt(i, 3).toString() + "','" + tabel_penjualan_clone.getValueAt(i, 4).toString() + "', "
                            + "'" + tabel_penjualan_clone.getValueAt(i, 5).toString() + "')";
                    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
                    pst2.execute();

                    field_total_harga_clone.setText("");
                    norak_clone.setSelectedItem("");
                    perkiraanSelesai_clone.setSelectedItem("");
                    field_bayar_clone.setText("");
                    field_status_bayar_clone.setText("");
                    field_sisa_bayar_clone.setText("");
                    field_kembalian_clone.setText("");
                    menampilkan_data_pelanggan_data_transaksi();
                    dispose();
                }
                resetKeranjang();
                ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                try {
                    String jdbcDriver = "com.mysql.jdbc.Driver";
                    Class.forName(jdbcDriver);
                    String url = "jdbc:mysql://localhost:3306/app_laundry";
                    String user = "agungkurniawan";
                    String pass = "programmerwebdeveloper";
                    Connection cone = DriverManager.getConnection(url, user, pass);
                    java.sql.Statement stm = cone.createStatement();
                    try {
                        String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                        HashMap hash = new HashMap();
                        //Mengambil parameter dari ireport
                        hash.put("fix", field_kode_nota_clone.getText());
                        JasperReport JRpt = JasperCompileManager.compileReport(report);
                        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, cone);
                        JasperViewer.viewReport(JPrint, false);
                        //JasperPrintManager.printReport(JPrint, false);
                    } catch (Exception rptexcpt) {
                        System.out.println("Report Can't view because : " + rptexcpt);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
            buatbarcode();
            transaksiHariIni();
            ngitung_jmkl_odrpkt_hrian();
            ngitung_jmkl_odrpkt_satuan();
            norak_clone.setSelectedItem("");
            perkiraanSelesai_clone.setSelectedItem("");
            field_status_bayar_clone.setText("");
            field_sisa_bayar_clone.setText("");
            field_kembalian_clone.setText("");
        } else if (perkiraanSelesai_clone.getSelectedItem().equals("5 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            int rows = tabel_penjualan_clone.getRowCount();
            String KD = field_kode_nota_clone.getText();
            int grand_total = Integer.parseInt(field_total_harga_clone.getText());
            int kembalian = Integer.parseInt(field_kembalian_clone.getText());
            int majer = Integer.parseInt(field_bayar_clone.getText());
            int sisa_byr = Integer.parseInt(field_sisa_bayar_clone.getText());
            String idplga = field_id_pelanggan_clone.getText();
            int rak = Integer.parseInt((String) norak_clone.getSelectedItem());
            String skr = "" + sfDate.format(tanggal);
            java.sql.Connection conn = null;
            try {
                Connection con = (Connection) connect.configDB();
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +5);
                Date sls = cal.getTime();
                String tanggal_selesai = "" + sfDate.format(sls);
                String stsAmbil = "belum di ambil";

                String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user_clone.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar_clone.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
                pst1.execute();
                for (int i = 0; i < rows; i++) {
                    String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan_clone.getValueAt(i, 0).toString() + "',"
                            + "'" + tabel_penjualan_clone.getValueAt(i, 3).toString() + "','" + tabel_penjualan_clone.getValueAt(i, 4).toString() + "', "
                            + "'" + tabel_penjualan_clone.getValueAt(i, 5).toString() + "')";
                    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
                    pst2.execute();

                    field_total_harga_clone.setText("");
                    norak_clone.setSelectedItem("");
                    perkiraanSelesai_clone.setSelectedItem("");
                    field_bayar_clone.setText("");
                    field_status_bayar_clone.setText("");
                    field_sisa_bayar_clone.setText("");
                    field_kembalian_clone.setText("");
                    menampilkan_data_pelanggan_data_transaksi();
                    dispose();
                }
                resetKeranjang();
                ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                try {
                    String jdbcDriver = "com.mysql.jdbc.Driver";
                    Class.forName(jdbcDriver);
                    String url = "jdbc:mysql://localhost:3306/app_laundry";
                    String user = "agungkurniawan";
                    String pass = "programmerwebdeveloper";
                    Connection cone = DriverManager.getConnection(url, user, pass);
                    java.sql.Statement stm = cone.createStatement();
                    try {
                        String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                        HashMap hash = new HashMap();
                        //Mengambil parameter dari ireport
                        hash.put("fix", field_kode_nota_clone.getText());
                        JasperReport JRpt = JasperCompileManager.compileReport(report);
                        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, cone);
                        //JasperViewer.viewReport(JPrint, false);
                        JasperPrintManager.printReport(JPrint, false);
                    } catch (Exception rptexcpt) {
                        System.out.println("Report Can't view because : " + rptexcpt);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
            buatbarcode();
            transaksiHariIni();
            ngitung_jmkl_odrpkt_hrian();
            ngitung_jmkl_odrpkt_satuan();
            norak_clone.setSelectedItem("");
            perkiraanSelesai_clone.setSelectedItem("");
            field_status_bayar_clone.setText("");
            field_sisa_bayar_clone.setText("");
            field_kembalian_clone.setText("");
        } else if (perkiraanSelesai_clone.getSelectedItem().equals("6 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            int rows = tabel_penjualan_clone.getRowCount();
            String KD = field_kode_nota_clone.getText();
            int grand_total = Integer.parseInt(field_total_harga_clone.getText());
            int kembalian = Integer.parseInt(field_kembalian_clone.getText());
            int majer = Integer.parseInt(field_bayar_clone.getText());
            int sisa_byr = Integer.parseInt(field_sisa_bayar_clone.getText());
            String idplga = field_id_pelanggan_clone.getText();
            int rak = Integer.parseInt((String) norak_clone.getSelectedItem());
            String skr = "" + sfDate.format(tanggal);
            java.sql.Connection conn = null;
            try {
                Connection con = (Connection) connect.configDB();

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +6);
                Date sls = cal.getTime();
                String tanggal_selesai = "" + sfDate.format(sls);
                String stsAmbil = "belum di ambil";

                String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user_clone.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar_clone.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
                pst1.execute();
                for (int i = 0; i < rows; i++) {
                    String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan_clone.getValueAt(i, 0).toString() + "',"
                            + "'" + tabel_penjualan_clone.getValueAt(i, 3).toString() + "','" + tabel_penjualan_clone.getValueAt(i, 4).toString() + "', "
                            + "'" + tabel_penjualan_clone.getValueAt(i, 5).toString() + "')";
                    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
                    pst2.execute();

                    field_total_harga_clone.setText("");
                    norak_clone.setSelectedItem("");
                    perkiraanSelesai_clone.setSelectedItem("");
                    field_bayar_clone.setText("");
                    field_status_bayar_clone.setText("");
                    field_sisa_bayar_clone.setText("");
                    field_kembalian_clone.setText("");
                    menampilkan_data_pelanggan_data_transaksi();
                    dispose();
                }
                resetKeranjang();
                ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                try {
                    String jdbcDriver = "com.mysql.jdbc.Driver";
                    Class.forName(jdbcDriver);
                    String url = "jdbc:mysql://localhost:3306/app_laundry";
                    String user = "agungkurniawan";
                    String pass = "programmerwebdeveloper";
                    Connection cone = DriverManager.getConnection(url, user, pass);
                    java.sql.Statement stm = cone.createStatement();
                    try {
                        String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                        HashMap hash = new HashMap();
                        //Mengambil parameter dari ireport
                        hash.put("fix", field_kode_nota_clone.getText());
                        JasperReport JRpt = JasperCompileManager.compileReport(report);
                        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, cone);
                        JasperViewer.viewReport(JPrint, false);
                        //JasperPrintManager.printReport(JPrint, false);
                    } catch (Exception rptexcpt) {
                        System.out.println("Report Can't view because : " + rptexcpt);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
            buatbarcode();
            transaksiHariIni();
            ngitung_jmkl_odrpkt_hrian();
            ngitung_jmkl_odrpkt_satuan();
            norak_clone.setSelectedItem("");
            perkiraanSelesai_clone.setSelectedItem("");
            field_status_bayar_clone.setText("");
            field_sisa_bayar_clone.setText("");
            field_kembalian_clone.setText("");
        } else if (perkiraanSelesai_clone.getSelectedItem().equals("7 Hari")) {
            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggal = new Date();
            int rows = tabel_penjualan_clone.getRowCount();
            String KD = field_kode_nota_clone.getText();
            int grand_total = Integer.parseInt(field_total_harga_clone.getText());
            int kembalian = Integer.parseInt(field_kembalian_clone.getText());
            int majer = Integer.parseInt(field_bayar_clone.getText());
            int sisa_byr = Integer.parseInt(field_sisa_bayar_clone.getText());
            String idplga = field_id_pelanggan_clone.getText();
            int rak = Integer.parseInt((String) norak_clone.getSelectedItem());
            String skr = "" + sfDate.format(tanggal);
            java.sql.Connection conn = null;
            try {
                Connection con = (Connection) connect.configDB();
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +7);
                Date sls = cal.getTime();
                String tanggal_selesai = "" + sfDate.format(sls);
                String stsAmbil = "belum di ambil";

                String sql1 = "INSERT INTO tbl_order VALUES('" + KD + "','" + idplga + "','" + field_id_user_clone.getText() + "',now(),'" + tanggal_selesai + "','" + grand_total + "','" + majer + "','" + sisa_byr + "','" + field_status_bayar_clone.getText() + "','" + kembalian + "','" + stsAmbil + "','" + rak + "')";
                PreparedStatement pst1 = (PreparedStatement) con.prepareStatement(sql1);
                pst1.execute();
                for (int i = 0; i < rows; i++) {
                    String sql2 = "INSERT INTO tbl_detail_order VALUES('" + KD + "', '" + tabel_penjualan_clone.getValueAt(i, 0).toString() + "',"
                            + "'" + tabel_penjualan_clone.getValueAt(i, 3).toString() + "','" + tabel_penjualan_clone.getValueAt(i, 4).toString() + "', "
                            + "'" + tabel_penjualan_clone.getValueAt(i, 5).toString() + "')";
                    PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
                    pst2.execute();

                    field_total_harga_clone.setText("");
                    norak_clone.setSelectedItem("");
                    perkiraanSelesai_clone.setSelectedItem("");
                    field_bayar_clone.setText("");
                    field_status_bayar_clone.setText("");
                    field_sisa_bayar_clone.setText("");
                    field_kembalian_clone.setText("");
                    menampilkan_data_pelanggan_data_transaksi();
                    dispose();
                }
                resetKeranjang();
                ImageIcon iconic = new ImageIcon(dashboardKasir.class.getResource("/illustration/checked.png"));
                JOptionPane.showMessageDialog(null, "Transaksi berhasil disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE, iconic);
                try {
                    String jdbcDriver = "com.mysql.jdbc.Driver";
                    Class.forName(jdbcDriver);
                    String url = "jdbc:mysql://localhost:3306/app_laundry";
                    String user = "agungkurniawan";
                    String pass = "programmerwebdeveloper";
                    Connection cone = DriverManager.getConnection(url, user, pass);
                    java.sql.Statement stm = cone.createStatement();
                    try {
                        String report = ("D:\\Agung Project\\Aplikasi Henny Laundry Berbasis Desktop V2\\Aplikasi Henny Laundry V2\\src\\transaksiNota\\fix.jrxml");
                        HashMap hash = new HashMap();
                        //Mengambil parameter dari ireport
                        hash.put("fix", field_kode_nota_clone.getText());
                        JasperReport JRpt = JasperCompileManager.compileReport(report);
                        JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, cone);
                        JasperViewer.viewReport(JPrint, false);
                        //JasperPrintManager.printReport(JPrint, false);
                    } catch (Exception rptexcpt) {
                        System.out.println("Report Can't view because : " + rptexcpt);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "" + e.getMessage());
            }
            buatbarcode();
            transaksiHariIni();
            ngitung_jmkl_odrpkt_hrian();
            ngitung_jmkl_odrpkt_satuan();
            norak_clone.setSelectedItem("");
            perkiraanSelesai_clone.setSelectedItem("");
            field_status_bayar_clone.setText("");
            field_sisa_bayar_clone.setText("");
            field_kembalian_clone.setText("");
        }
    }//GEN-LAST:event_cmd6ActionPerformed

    private void cmd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd1ActionPerformed
        // TODO add your handling code here:
        int row = tabel_penjualan_clone.getSelectedRow();//0
        idlist.remove(row);
        modelpj.removeRow(row);
        _settotal();
        Notification panel = new Notification(this, Notification.Type.SUCCESS,
                Notification.Location.TOP_CENTER, "Paket Pemesanan Berhasil dihapus!");
        panel.showNotification();
    }//GEN-LAST:event_cmd1ActionPerformed

    private void field_kembalian_cloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_kembalian_cloneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_kembalian_cloneActionPerformed

    private void tabel_barang_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barang_cloneMouseClicked
        // TODO add your handling code here:
        int baris = tabel_barang_clone.rowAtPoint(evt.getPoint());
        tabel_barang_clone.rowAtPoint(evt.getPoint());
        tabel_barang_clone.getValueAt(baris, 0).toString();
        String nm = tabel_barang_clone.getValueAt(baris, 1).toString();
        paketDipilih_clone.setText(nm);
        tabel_barang_clone.getValueAt(baris, 2).toString();
        String pr = tabel_barang_clone.getValueAt(baris, 3).toString();
        field_harga_paket_clone.setText(pr);
    }//GEN-LAST:event_tabel_barang_cloneMouseClicked
//    public void tgl_slesai() {
//        if (perkiraanSelesai_clone.getSelectedItem().equals("1 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +1);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("2 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +2);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("3 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +3);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("4 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +4);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("5 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +5);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("6 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +6);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("7 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +7);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        }
//    }
    private void perkiraanSelesai_cloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perkiraanSelesai_cloneActionPerformed

//        if (perkiraanSelesai_clone.getSelectedItem().equals("1 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +1);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("2 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +2);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("3 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +3);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("4 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +4);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("5 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +5);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("6 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +6);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        } else if (perkiraanSelesai_clone.getSelectedItem().equals("7 Hari")) {
//            SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
//            Date tanggal = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.add(Calendar.DATE, +7);
//            Date sls = cal.getTime();
//            String tanggal_selesai = "" + sfDate.format(sls);
//            tgl_sls.setText("" + tanggal_selesai);
//            session.session.setLama_sls(tanggal_selesai);
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_perkiraanSelesai_cloneActionPerformed

    private void tgl_slsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_slsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_slsActionPerformed

    private void field_jumlah_barang_cloneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_jumlah_barang_cloneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_jumlah_barang_cloneActionPerformed

    private void field_status_bayar_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_status_bayar_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_field_status_bayar_cloneMouseClicked

    private void field_sisa_bayar_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_sisa_bayar_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_field_sisa_bayar_cloneMouseClicked

    private void field_kembalian_cloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_kembalian_cloneMouseClicked
        // TODO add your handling code here:
        Notification panel = new Notification(this, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Field yang terisi otimatis tidak bisa dirubah!");
        panel.showNotification();
    }//GEN-LAST:event_field_kembalian_cloneMouseClicked

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
            java.util.logging.Logger.getLogger(tahap_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tahap_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tahap_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tahap_awal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tahap_awal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button cmd1;
    private button.Button cmd6;
    private javax.swing.JPanel container;
    public static final textfield.TextField field_bayar_clone = new textfield.TextField();
    public static final textfield.TextField field_harga_paket_clone = new textfield.TextField();
    public static final textfield.TextField field_id_pelanggan_clone = new textfield.TextField();
    public static final textfield.TextField field_id_user_clone = new textfield.TextField();
    public static final textfield.TextField field_jumlah_barang_clone = new textfield.TextField();
    public static final textfield.TextField field_kembalian_clone = new textfield.TextField();
    public static final textfield.TextField field_keterangan_clone = new textfield.TextField();
    public static final textfield.TextField field_kode_nota_clone = new textfield.TextField();
    public static final textfield.TextField field_sisa_bayar_clone = new textfield.TextField();
    public static final textfield.TextField field_status_bayar_clone = new textfield.TextField();
    public static final textfield.TextField field_subtotal_clone = new textfield.TextField();
    public static final javax.swing.JTextField field_total_harga_clone = new javax.swing.JTextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton7;
    private com.k33ptoo.components.KButton kButton8;
    public static final combobox.Combobox norak_clone = new combobox.Combobox();
    public static final javax.swing.JLabel paketDipilih_clone = new javax.swing.JLabel();
    public static final combobox.Combobox perkiraanSelesai_clone = new combobox.Combobox();
    public static final javax.swing.JTable tabel_barang_clone = new javax.swing.JTable();
    public static final javax.swing.JTable tabel_penjualan_clone = new javax.swing.JTable();
    private javax.swing.JPanel tahap_awal;
    private javax.swing.JPanel tahap_kedua;
    private javax.swing.JPanel tahap_ketiga;
    private javax.swing.JTextField tgl_sls;
    // End of variables declaration//GEN-END:variables
}
