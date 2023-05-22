package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static final String USERNAME = "root";
	public static final String PASSWORD = "**********";
	public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bussolat";
	
	public static Connection createConnectionToMySql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = createConnectionToMySql();
		
		if(conn != null) {
			System.out.println("==== Sistema Conectado ====");
			
		}
	}
}
