package connection;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    private static java.sql.Connection koneksikan;
    public static java.sql.Connection configDB()throws SQLException{
        try {
            String url = "jdbc:mysql://localhost:3306/app_laundry";
            String user ="agungkurniawan";
            String pass = "programmerwebdeveloper";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksikan = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
        return koneksikan;
    }

    static Object GetConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Connection connect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
