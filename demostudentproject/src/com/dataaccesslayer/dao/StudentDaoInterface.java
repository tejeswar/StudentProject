package com.dataaccesslayer.dao;

import java.util.List;

import  com.dataaccesslayer.dto.Student;
import com.servicelayer.userdefinedexception.DuplicateRecordException;

public interface StudentDaoInterface {
	int insertStudent(Student st)throws DuplicateRecordException;
	public List<Student> selectStudent();
	public Student selectSpecificStudent(int i);
	boolean updateStudent(int roll,String name,long phoneno,String email);
	boolean deleteStudent(int roll);
}
