package com.dataaccesslayer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dataaccesslayer.dto.Student;
import com.dataaccesslayer.utility.DBConnectionFactory;
import com.servicelayer.userdefinedexception.DuplicateRecordException;
//import com.utility.FactoryClass;

public class StudentDaoImpl implements StudentDaoInterface{
	
public int insertStudent(Student st) throws DuplicateRecordException{
	int i=0;
	Connection con=DBConnectionFactory.getConnection();
	System.out.println("connection is:"+con);
	String name=st.getName();
	String emailid=st.getEmailid();
	long phoneno=st.getPhoneno();
	int roll=st.getRoll();
    String date=st.getDate();
    try{
	PreparedStatement statement=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");
   System.out.println("statement is:"+statement);
	statement.setString(2,name);
    statement.setInt(1, roll);
   statement.setLong(3, phoneno);
   statement.setString(4, emailid);
   statement.setString(5, date);
   i=statement.executeUpdate();
    }catch(Exception e){
   e.printStackTrace();
   System.out.println("DuplicateRecordException is going to be thrown");
   throw new DuplicateRecordException();
    	
    }
    finally{
    	System.out.println("factory is closed");
    	DBConnectionFactory.close();
    }
   System.out.println(" insertStudent(Student st)====value of i:"+i);
   return i;
    
}
public List<Student> selectStudent(){
	/*List<Student> list=new ArrayList<Student>();
	Student s1 = new Student(1, "akhu", 7795732473l, "akhu4@gmail.com", "22-9-2013");
	Student s2 = new Student(2, "rama", 9975732473l, "rama5@gmail.com", "12-10-2013");
	list.add(s1);
	list.add(s2);*/
	ResultSet resultSet=null;
	Connection con=DBConnectionFactory.getConnection();
	PreparedStatement statement=null;
	try {
		statement = con.prepareStatement("SELECT * FROM STUDENT");
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		System.out.println("statement could not executed");
	}
	
	try {
		resultSet = statement.executeQuery();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("resultset could not created");
	}
	Student st=null;
    List<Student> list=new ArrayList<Student>();
    try {
		while(resultSet.next()){
			st=new Student();
			int id=resultSet.getInt(1);
			String name=resultSet.getString(2);
			long l=resultSet.getLong(3);
			String email=resultSet.getString(4);
			String date=resultSet.getString(5);
			date=date.substring(0, 10);
			st.setRoll(id);
			st.setName(name);
			st.setPhoneno(l);
			st.setEmailid(email);
			st.setDate(date);
			System.out.println("name in student object is:"+st.getName());
			System.out.println("roll no in student object is:"+st.getRoll());
			System.out.println("phone no in student object is:"+st.getPhoneno());
			System.out.println("emailid in student object is:"+st.getEmailid());
			System.out.println("date of join in student object is:"+st.getDate());
			list.add(st);
			System.out.println("id is:"+id);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Exception in selectStudent()");
	}
	 finally{
	    	DBConnectionFactory.close();
	    }
	return list;
}
public Student selectSpecificStudent(int i){
	ResultSet resultSet=null;
	Connection con=DBConnectionFactory.getConnection();
	PreparedStatement statement=null;
	System.out.println("inside selectSpecificStudent(int i)");
	try {
		statement = con.prepareStatement("SELECT * FROM STUDENT WHERE ROLL="+i);
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		System.out.println("statement could not executed");
	}
	
	try {
		resultSet = statement.executeQuery();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		System.out.println("resultset could not created");
	}
	Student st=null;
   // List<Student> list=new ArrayList<Student>();
    try {
		while(resultSet.next()){
			st=new Student();
			int id=resultSet.getInt(1);
			String name=resultSet.getString(2);
			long l=resultSet.getLong(3);
			String email=resultSet.getString(4);
			String date=resultSet.getString(5);
			date=date.substring(0, 8);
			
			st.setRoll(id);
			st.setName(name);
			st.setPhoneno(l);
			st.setEmailid(email);
			st.setDate(date);
			
			System.out.println("id is:"+id);
			System.out.println("date is"+date);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Exception in selectStudent()");
	}
	 finally{
		 DBConnectionFactory.close();
	    }
	return st;
	
}
public boolean updateStudent(int roll,String name,long phoneno,String email){
	int i=0;
	boolean flag=false;
	String sql="UPDATE STUDENT SET NAME='"+name+"',PHONENO="+phoneno+",EMAILID='"+email+"' WHERE ROLL="+roll;
	System.out.println("sql statemetn is:"+sql);
	Connection con=DBConnectionFactory.getConnection();
	System.out.println("conenction kis:"+con);
	PreparedStatement statement=null;
	try {
		statement = con.prepareStatement(sql);
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		System.out.println("statement could not executed");
	}
	try {
		i=statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally{
		 DBConnectionFactory.close();
	    }
	if(i>0)
	{flag=true;}
	return flag;

}
public boolean deleteStudent(int roll){
	int i=0;
	boolean flag=false;
	String sql="DELETE FROM STUDENT WHERE ROLL="+roll;
	System.out.println("delete sql is:"+sql);
	Connection con=DBConnectionFactory.getConnection();
	PreparedStatement statement=null;
	try {
		statement = con.prepareStatement(sql);
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
		System.out.println("statement could not executed");
	}
	try {
		i=statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally{
		 DBConnectionFactory.close();
	    }
	if(i>0)
	{flag=true;}
	return flag;
	
}
}
