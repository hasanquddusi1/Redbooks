package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbconfig.ConnectionUtil;
import dbconfig.ResourceClosers;
import models.Book;
import models.Customer;

public class CustomerDaoImpl implements CustomerDao{
	
	public CustomerDaoImpl() {
		
	}

	@Override
	public boolean verifyCustomerCredentials(String username, String password) {
		boolean verify_customer = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		
		try {
			conn = ConnectionUtil.getConnection();
		
			final String SQL = "select customer_id from customers where customer_username =? and customer_password =?";
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			stmt.setString(2, password);
	
			set = stmt.executeQuery();
			
			if (set.next()) {
				verify_customer= true;
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		ResourceClosers.closeConnection(conn);
		ResourceClosers.closeStatement(stmt);
		ResourceClosers.closeResultSet(set);
		}
		
		return verify_customer;
	}
	

	@Override
	/*
	 * Create a new account for customers
	 */
	public void createAccount(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtil.getConnection();
			final String SQL = "insert into customers values(default, ?,?)";
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, customer.getCustomerUserName());
			stmt.setString(2, customer.getCustomerPassword());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceClosers.closeConnection(conn);
			ResourceClosers.closeStatement(stmt);
		}
	}
	
	
	@Override
	public Customer getOne(int key) {
		
		Customer retrievedCustomer = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			 conn = ConnectionUtil.getConnection();
			
			final String SQL = "select * from customers where customer_id = ?";
			stmt = conn.prepareStatement(SQL);
			
			stmt.setInt(1, key);
			
			set = stmt.executeQuery();
			
			
			while(set.next()) {
				
				/*
				 * clientId might be null which means it will return 0 for clientId 
				 * in the JSON return
				 */
				retrievedCustomer = new Customer(
						set.getInt(1),
						set.getString(2),
						set.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				ResourceClosers.closeConnection(conn);
				ResourceClosers.closeStatement(stmt);
				ResourceClosers.closeResultSet(set);
		}
		
		return retrievedCustomer;
	}
	
	@Override
	public void changePassword(int id, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtil.getConnection();
			final String SQL = "update customers set customer_password = ? where customer_id = ?";
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, password);
			stmt.setInt(2, id);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceClosers.closeConnection(conn);
			ResourceClosers.closeStatement(stmt);
		}
	}
	
	@Override
	public void changeUsername(int id, String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtil.getConnection();
			final String SQL = "update customers set customer_username = ? where customer_id = ?";
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, username);
			stmt.setInt(2, id);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceClosers.closeConnection(conn);
			ResourceClosers.closeStatement(stmt);
		}
	}
	

}


