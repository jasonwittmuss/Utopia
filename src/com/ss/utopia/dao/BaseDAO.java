package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseDAO<T> {
	
	public static Connection conn = null;
	
	public BaseDAO(Connection conn) {
		BaseDAO.conn = conn;
	}
	
	// Execute an update from the server
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (vals != null) {
			int ct = 1;
			for (Object o : vals) {
				pstmt.setObject(ct, o);
				ct++;
			}
		}
		pstmt.executeUpdate();
	}
	
	// Execute an update from the server with returning key
	public Integer saveWithPK(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		if (vals != null) {
			int ct = 1;
			for (Object o : vals) {
				pstmt.setObject(ct, o);
				ct++;
			}
		}
		pstmt.executeUpdate();	
		
		ResultSet results = pstmt.getGeneratedKeys();
		
		if (results.next()) {
			return results.getInt(1);
		}
		return null;
	}
	
	// Get a list of query responses and return a list of objects
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (vals != null) {
			int ct = 1;
			for (Object o : vals) {
				pstmt.setObject(ct, o);
				ct++;
			}
		}
		
		ResultSet results = pstmt.executeQuery();
		
		return extractData(results);
	}
	
	public abstract List<T> extractData(ResultSet results) throws ClassNotFoundException, SQLException;
}
