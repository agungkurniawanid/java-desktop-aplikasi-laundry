package session;

public class session {

    private static String id_kasir;
    private static String username;
    private static String id_pelanggan;
    private static String id_kasir_ubah;

    public static String getLama_sls() {
        return lama_sls;
    }

    public static void setLama_sls(String lama_sls) {
        session.lama_sls = lama_sls;
    }
    private static String lama_sls;

    public static String getKode_struk() {
        return kode_struk;
    }

    public static void setKode_struk(String kode_struk) {
        session.kode_struk = kode_struk;
    }
private static String kode_struk;
    public static String getNo_frid() {
        return no_frid;
    }

    public static void setNo_frid(String no_frid) {
        session.no_frid = no_frid;
    }
    private static String no_frid;

    public static String getId_kasir() {
        return id_kasir;
    }

    public static void setId_kasir(String id_kasir) {
        session.id_kasir = id_kasir;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        session.username = username;
    }

    public static String getId_pelanggan() {
        return id_pelanggan;
    }

    public static void setId_pelanggan(String id_pelanggan) {
        session.id_pelanggan = id_pelanggan;
    }

    public static String getId_kasir_ubah() {
        return id_kasir_ubah;
    }
    public static void setId_kasir_ubah(String id_kasir_ubah) {
        session.id_kasir_ubah = id_kasir_ubah;
    }

}
