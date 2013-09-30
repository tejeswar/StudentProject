package com.servicelayer;

import java.util.List;

import com.dataaccesslayer.dao.StudentDaoInterface;
import com.dataaccesslayer.dto.Student;
import com.servicelayer.userdefinedexception.DuplicateRecordException;

public class StudentServiceImpl implements StudentServiceInterface{
	StudentDaoInterface daoInterface;
public void setDaoInterface(StudentDaoInterface daoInterface) {
		this.daoInterface = daoInterface;
	}
public	int insertStudent(Student st)throws DuplicateRecordException{
	int i=0;
	i = daoInterface.insertStudent(st);
	return i;
}
	public List<Student> selectStudent(){
		List<Student> students = null;
		students = daoInterface.selectStudent();
		return students;
	}
	public Student selectSpecificStudent(int i){
		Student st = null;
		st = daoInterface.selectSpecificStudent(i);
		return st;
	}
	public boolean updateStudent(int roll,String name,long phoneno,String email){
		boolean flag = false;
		flag = daoInterface.updateStudent(roll, name, phoneno, email);
		return flag;
	}
	public boolean deleteStudent(int roll){
		boolean flag = false;
		flag = daoInterface.deleteStudent(roll);
		return flag;
	}
}
