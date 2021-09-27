package com.ss.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.User;

public class UserDAO extends BaseDAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	public void addUser(Integer roleId, String givenName, String familyName, String userName, String email, String password, String phone) throws ClassNotFoundException, SQLException {
		save("INSERT INTO user (role_id, given_name, family_name, username, email, password, phone ) VALUES (?,?,?,?,?,?,?)", new Object[] {
			roleId,
			givenName,
			familyName,
			userName,
			email,
			password,
			phone
		});
	}

	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		save("UPDATE user SET password = ? where id = ?", new Object[] {
			user.getPassword()
		  });
	}

	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		save("DELETE from user where id = ?", new Object[] { 
			user.getUserId()
		});
	}

	public List<User> readUsers() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user", null);
	}
	
	public List<User> readUsersByUserId(Integer userId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user WHERE id = ?", new Object[] { 
			userId 
		});
	}
	public List<User> readUsersByRoleId(Integer userId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user WHERE role_id = ?", new Object[] { 
			userId 
		});
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		while (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt("id"));
			user.getUserRoleId().setUserRoleId(rs.getInt("user_role"));
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			users.add(user);
		}
		return users;
	}
}