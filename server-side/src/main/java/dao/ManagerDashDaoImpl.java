package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import dbconfig.ConnectionUtil;
import dbconfig.ResourceClosers;
import models.Customer;
import models.Manager;

public class ManagerDashDaoImpl implements ManagerDashDao{

	
	public ManagerDashDaoImpl() {
		}
	
	@Override
	/*
	 * Get all customers list to show on manager dashboard
	 */
	public Map<Integer, Customer> getCustomerList() {
		HashMap<Integer, Customer> customersList = new HashMap<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		try {
			 conn = ConnectionUtil.getConnection();
				final String SQL = "select customer_id, customer_username, customer_password from customers";
				stmt =  conn.createStatement();
				set = stmt.executeQuery(SQL);
		while(set.next()) {
					 Customer retrievedCustomerList = new Customer(
							 set.getInt(1),
							 set.getString(2),
							 set.getString(3)	
							 );
					 customersList.put(set.getInt(1), retrievedCustomerList);		 	
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	
		ResourceClosers.closeConnection(conn);
		ResourceClosers.closeStatement(stmt);
		ResourceClosers.closeResultSet(set);
		}
		
		return customersList;
	}

	@Override
	/*
	 * Delete a customer on manager dashboard
	 */
	public void deleteCustomer(Integer key) {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtil.getConnection();
			final String SQL = "delete from customers where customer_id = ?";
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, key);
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ResourceClosers.closeConnection(conn);
			ResourceClosers.closeStatement(stmt);
		}

	}

	@Override
	public Manager getOne(int key) {
		Manager retrievedManager = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			 conn = ConnectionUtil.getConnection();
			
			final String SQL = "select * from admins where admin_id = ?";
			stmt = conn.prepareStatement(SQL);
			
			stmt.setInt(1, key);
			
			set = stmt.executeQuery();
			
			
			while(set.next()) {
				retrievedManager = new Manager(
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
		
		return retrievedManager;
	}

	@Override
	public void changePassword(int id, String str) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtil.getConnection();
			final String SQL = "update admins set admin_password = ? where admin_id = ?";
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, str);
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
	public void changeUsername(int id, String str) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtil.getConnection();
			final String SQL = "update admins set admin_username = ? where admin_id = ?";
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, str);
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
