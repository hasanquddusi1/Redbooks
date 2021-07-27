package dbconfig;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceClosers {
	
	/*
	 * This is a utility class that we can use to handle the exceptions that occur
	 * when we attempt to close JDBC resources. This will make our DAOs a little
	 * cleaner.
	 */
	
	public static void closeConnection(Connection conn) {
		if (conn == null) return;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void closeStatement(Statement stmt) {
		if (stmt == null) return;
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet set) {
		if (set == null) return;
		try {
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
