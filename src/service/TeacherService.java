package service;

import java.sql.SQLException;
import java.util.List;

import dto.teacher;

public interface TeacherService {
   teacher createTeacher(teacher teacher)throws SQLException;
   
   teacher UpdateTeacher(teacher updateteacher)throws SQLException;
   
   teacher getTeacherById(Integer getTeacherByID)throws SQLException;
   
   List<teacher> getAllTeacher()throws SQLException;
   
   Boolean deleteTeacherByID(Integer deleteTeacher)throws SQLException;
}
