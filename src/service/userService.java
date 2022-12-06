package service;

import java.sql.SQLException;

import dto.userinfo;


public interface userService {
	
	userinfo adduser(userinfo user)throws SQLException;
	userinfo validateUser(String username, String passsword)throws SQLException;
}
