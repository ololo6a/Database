package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Администратор on 31.05.2016.
 */
public class Connect {

    public Connect() {

    }

    public  Connection Connect(Connection conn)
    {

        try {
            Locale.setDefault(Locale.ENGLISH);
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:user2@//localhost:1521/xe", "user2",    "user2");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public  Connection Disconnect(Connection conn)
    {

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
