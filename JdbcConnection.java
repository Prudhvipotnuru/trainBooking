package dbUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

	public static Connection con = null;

	public static Connection getConnection() {
		if (con == null) {
			try {
				FileInputStream fis = new FileInputStream("D:/TEST1/money/src/dbUtilities/db.properties");
				Properties p = new Properties();
				p.load(fis);
				Class.forName(p.getProperty("DRIVER"));
				con = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("UNAME"), p.getProperty("PWD"));
			} catch (IOException | SQLException | ClassNotFoundException f) {
				System.out.println(f);
			}
		}
		return con;
	}

}
