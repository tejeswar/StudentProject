package com.presentationlayer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dataaccesslayer.dto.Student;
import com.servicelayer.userdefinedexception.DuplicateRecordException;
//import StudentInformation;
//import StudentInterface;
import com.servicelayer.StudentServiceInterface;

public class GreetingController extends AbstractController {
//private String successView;
private StudentServiceInterface model;
//private String errorView;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1){
		// TODO Auto-generated method stub
		int roll=Integer.parseInt(arg0.getParameter("roll"));
		String name=arg0.getParameter("name");
		long l=Long.parseLong(arg0.getParameter("phoneno"));
		String email = arg0.getParameter("email");
		String day=arg0.getParameter("day");
		String month=arg0.getParameter("month");
		String year=arg0.getParameter("year");
		//String date=day+"-"+month+"-"+year;
		String date=year+"-"+month+"-"+day;
		System.out.println("date is:"+date);
		Student s=new Student();
		s.setRoll(roll);s.setName(name);s.setPhoneno(l);
		s.setEmailid(email);s.setDate(date);
		System.out.println("model is:"+model);
		int i=0;
		String outputPage=null;
		try {
	i=	model.insertStudent(s);
		} catch (DuplicateRecordException e) {
			outputPage="duplicaterecdef";
			System.out.println("DuplicateRecordException HANDLED");
						e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("general Exception is handled ");
				e.printStackTrace();
		}
	System.out.println("i="+i);
	if(i>0)
		
		outputPage="successdef";
		return new ModelAndView(outputPage);
	}
public void setModel(StudentServiceInterface model) {
	this.model = model;
}
/*public void setSuccessView(String successView) {
	this.successView = successView;
}
public void setErrorView(String errorView) {
	this.errorView = errorView;
}*/

}
