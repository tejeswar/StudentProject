package com.presentationlayer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.servicelayer.StudentServiceInterface;

public class UpdateController2 extends AbstractController{
	private StudentServiceInterface model;
	public void setModel(StudentServiceInterface model) {
		this.model = model;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
int roll=Integer.parseInt(arg0.getParameter("roll"));
		
		String name=arg0.getParameter("name");
		System.out.println("name is:"+name);
		long l=Long.parseLong(arg0.getParameter("phoneno"));
		System.out.println("phone no is:"+l);
		String email = arg0.getParameter("email");
		System.out.println("email is:"+email);
		
		
		boolean b=false;
		b=model.updateStudent(roll, name, l, email);
		if(b==true)
		return new ModelAndView("successdef");
		else
			return new ModelAndView("errordef");
			
	}

}
