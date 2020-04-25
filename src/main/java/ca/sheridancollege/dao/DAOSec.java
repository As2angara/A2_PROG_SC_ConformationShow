package ca.sheridancollege.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.bean.User;

public class DAOSec {
	
	public User findUserAccount(String userName) {
		User user=null;
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/dogshow", "root", "root");
            
			String q = 
					"SELECT * FROM sec_user where user_name='"+userName+"'";
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);

            while(rs.next()) {
            	user = new User(rs.getLong(1), rs.getString(2), rs.getString(3));
            }
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return user;
	}

	public static ArrayList<String>  getRoleNames(Long userID) {
		ArrayList<String> roles = new ArrayList<String>();
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/dogshow", "root", "root");
            
			String q = 
					"SELECT user_role.id, user_role.user_id, user_role.role_id, sec_role.role_id, sec_role.role_name FROM user_role, SEC_ROLE where sec_role.role_id=user_role.role_id and user_id=" + userID;
            
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            
            while(rs.next()) {
            	roles.add(rs.getString(5));
            }
            
            
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return roles;
	}
	
	public void addUser(User user) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = null;
	        
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "root");
	    		
				String pst = "insert into sec_user (user_name, encrypted_pass) values (?, ?)";
				
				PreparedStatement ps = conn.prepareStatement(pst);
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getEncryptedPassword());
				
				ps.executeUpdate();
				conn.close();
		 } catch (Exception e) {
	            System.out.println("Connection Failed");
	            System.out.println(e);
	        }
	}
	
	public long getRoleID(String role) {
		long id = 0;
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection
            		("jdbc:mysql://localhost/dogshow", "root", "root");
            
			String q = "Select role_id from sec_role where role_name = 'ROLE_" + role + "';";
					
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(q);
            
            while(rs.next()) {
            	id = rs.getLong(1);
            }
            
            
            
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return id;
	}
	
	public void addRole (Long userID, Long roleID) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dogshow", "root", "root");
    		
			String pst = "insert into user_role (user_id, role_id) values (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(pst);
			ps.setLong(1, userID);
			ps.setLong(2, roleID);
			
			ps.executeUpdate();
			conn.close();
	    } catch (Exception e) {
            System.out.println("Connection Failed");
            System.out.println(e);
        }
	}

}
