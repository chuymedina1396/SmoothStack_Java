package com.ss.utopia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.models.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole> {

	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	public void addUserRole(String userRole) throws ClassNotFoundException, SQLException {
		save("INSERT INTO user_role (name) VALUES (?)", new Object[] {
				userRole
			});
	}

	public void updateUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("UPDATE user_role set name where id = ?", new Object[] { 
			
		});
	}

	public void deleteUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("delete from user_role where id = ?", new Object[] { userRole.getUserRoleId() });
	}

	public List<UserRole> readUserRoles() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM userRole", null);
	}
	
	public List<UserRole> readUserRolesById(Integer userRoleId) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM user_role WHERE id = ?", new Object[] { 
			userRoleId 
		});
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> userRoles = new ArrayList<>();
		while (rs.next()) {
			UserRole userRole = new UserRole();
			userRole.setUserRoleId(rs.getInt("id"));
			userRole.setName(rs.getString("name"));
			userRoles.add(userRole);
		}
		return userRoles;
	}
}