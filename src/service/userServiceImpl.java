package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DaoUtility;
import dto.userinfo;

public class userServiceImpl implements userService {
	private Connection connection = DaoUtility.getConnectionToPostGres();
	private PreparedStatement prepareStatement; 
	
	@Override
	public userinfo adduser(userinfo user) throws SQLException {
		try {
			PreparedStatement prepareStatement = this.connection
					.prepareStatement("INSERT INTO USERINFO(userName,password) VALUES(?,?)");

			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getPassword());

			if (prepareStatement.executeUpdate() >= 0)
				return user;
		} catch (SQLException e) {
			throw e;
		}
		return null;
	
		

	}

	@Override
	public userinfo validateUser(String username, String password) throws SQLException {
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("SELECT * FROM userinfo WHERE username = ? AND password= ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userinfo foundUser = new userinfo(resultSet.getString(1), resultSet.getString(2));
						
				return foundUser;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw e;
		}
		return null;
	}

	

}
