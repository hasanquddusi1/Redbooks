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
import models.Book;

public class BookDaoImpl implements BookDao{
	

	@Override
	public Map<Integer, Book> getAll() {
		HashMap<Integer, Book> books = new HashMap<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		try {
			 conn = ConnectionUtil.getConnection();
			
			final String SQL = "select * from books";
			stmt = conn.createStatement();
			
			set = stmt.executeQuery(SQL);
			
			
			while(set.next()) {
				
				/*
				 * clientId might be null which means it will return 0 for clientId 
				 * in the JSON return
				 */
				Book retrievedBook = new Book(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getString(5),
						set.getString(6));
				
				books.put(set.getInt(1), retrievedBook);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				ResourceClosers.closeConnection(conn);
				ResourceClosers.closeStatement(stmt);
				ResourceClosers.closeResultSet(set);
		}
		
		return books;
	}

	@Override
	public Book getOne(int key) {
		
		Book retrievedBook = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			 conn = ConnectionUtil.getConnection();
			
			final String SQL = "select * from books where book_id = ?";
			stmt = conn.prepareStatement(SQL);
			
			stmt.setInt(1, key);
			
			set = stmt.executeQuery();
			
			
			while(set.next()) {
				
				/*
				 * clientId might be null which means it will return 0 for clientId 
				 * in the JSON return
				 */
				retrievedBook = new Book(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getString(5),
						set.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				ResourceClosers.closeConnection(conn);
				ResourceClosers.closeStatement(stmt);
				ResourceClosers.closeResultSet(set);
		}
		
		return retrievedBook;
	}

	@Override
	public Map<Integer, Book> searchByGenre(String genre) {
		HashMap<Integer, Book> books = new HashMap<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		
		try {
			 conn = ConnectionUtil.getConnection();
			
			final String SQL = "select * from books where genre = ?";
			stmt = conn.prepareStatement(SQL);
			
			stmt.setString(1, genre);
			
			set = stmt.executeQuery();
			
			
			while(set.next()) {
				Book retrievedBook = new Book(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getString(5),
						set.getString(6));
				
				books.put(set.getInt(1), retrievedBook);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				ResourceClosers.closeConnection(conn);
				ResourceClosers.closeStatement(stmt);
				ResourceClosers.closeResultSet(set);
		}
		
		return books;
	}

}
