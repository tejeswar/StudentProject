package com.presentationlayer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dataaccesslayer.dto.Student;
import com.servicelayer.StudentServiceInterface;

public class Update1Controller extends AbstractController{
	private StudentServiceInterface model;
	public void setModel(StudentServiceInterface model) {
		this.model = model;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside Update1Controller");
		System.out.println(arg0.getParameter("male"));
		int i=Integer.parseInt(arg0.getParameter("male"));
		System.out.println("roll no is: "+i+"to be updated");
		Student st=null;
		st=model.selectSpecificStudent(i);
		
		return new ModelAndView("update1def", "student", st);
	}

}
