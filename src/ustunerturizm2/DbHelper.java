package ustunerturizm2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author iserhand
 */
public class DbHelper {

    private final String dbName = "selcuk";
    private final String dbPass = "Selcuk123";
    private final String dbUrl = "jdbc:mysql://192.168.1.255:3306/musteri?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbName, dbPass);
    }

    public void showErrorMessage(SQLException e) {
        System.out.println("Error" + e.getMessage());
        System.out.println("Error code:" + e.getErrorCode());
    }
}
