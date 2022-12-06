package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoUtility;
import dto.teacher;

public class TeacherServiceImpl implements TeacherService {

	private Connection connection = DaoUtility.getConnectionToPostGres();
	private PreparedStatement prepareStatement;

	@Override
	public teacher createTeacher(teacher teacher) throws SQLException {
		try {
			PreparedStatement prepareStatement = this.connection
					.prepareStatement("INSERT INTO Teacher(id,name,salary) VALUES(?,?,?)");

			prepareStatement.setInt(1, teacher.getId());
			prepareStatement.setString(2, teacher.getName());
			prepareStatement.setDouble(3, teacher.getSalary());
			if (prepareStatement.executeUpdate() >= 0)
				return teacher;
		} catch (SQLException e) {
			throw e;
		}
		return null;
	}

	

	

	@Override
	public List<teacher> getAllTeacher() throws SQLException {
		List<teacher> tecList = null;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from TEACHER");
			ResultSet executeQuery = prepareStatement.executeQuery();
			tecList = new ArrayList<>();
			while (executeQuery.next()) {
				teacher newTec = new teacher(executeQuery.getInt(1), executeQuery.getString(2),
						executeQuery.getDouble(3));
				tecList.add(newTec);
			}
			return tecList;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	@Override
	public teacher getTeacherById(Integer getTeacherByID) throws SQLException {
		try {
			PreparedStatement prepareStatement = this.connection.prepareStatement("SELECT * FROM Teacher WHERE id = ?");
			prepareStatement.setInt(1, getTeacherByID);
			ResultSet eQ = prepareStatement.executeQuery();
			if(eQ.next()) {
				teacher teacher = new teacher(eQ.getInt(1),eQ.getString(2),eQ.getDouble(3));
			    return teacher;
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	@Override
	public teacher UpdateTeacher(teacher updateteacher) throws SQLException {
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TEACHER SET name = ? , salary = ? WHERE id = ?");
        	preparedStatement.setString(1, updateteacher.getName());
        	preparedStatement.setDouble(2, updateteacher.getSalary());
        	preparedStatement.setInt(3, updateteacher.getId());
        	if(preparedStatement.executeUpdate()>=0) {
        		return updateteacher;
        	}
        } catch (SQLException e) {
		   throw e;
		}
		return null;
	}

	@Override
	public Boolean deleteTeacherByID(Integer deleteTeacher) throws SQLException {
		try {
		PreparedStatement	prepareStatement = connection.prepareStatement("DELETE FROM TEACHER WHERE id = ?");
		prepareStatement.setInt(1, deleteTeacher);
		if(prepareStatement.executeUpdate()>0) {
			return true;
		}
		} catch (SQLException e) {
			throw e;
		}
		return false;
	}

}
