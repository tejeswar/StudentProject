package com.dataaccesslayer.dto;

import java.io.Serializable;

public class Student implements Comparable,Serializable{
private String name;
private int roll;
private long phoneno;
private String emailid;
private String date;

public Student(int roll,String name,long phoneno,String emailid, String date){
this.roll=roll;this.name=name;this.phoneno=phoneno;this.emailid=emailid;
this.date=date;	
	
}
public int compareTo(Object o){
	Student s=(Student)o;
	if(this.roll==s.roll)
		return 0;
	else if(this.roll>s.roll)
		return 1;
	else return -1;
}
public Student(){}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getRoll() {
	return roll;
}
public void setRoll(int roll) {
	this.roll = roll;
}
public long getPhoneno() {
	return phoneno;
}
public void setPhoneno(long phoneno) {
	this.phoneno = phoneno;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
}
