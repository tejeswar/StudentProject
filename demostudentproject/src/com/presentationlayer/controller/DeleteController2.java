package com.presentationlayer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.servicelayer.StudentServiceInterface;

public class DeleteController2 extends AbstractController{
	private StudentServiceInterface model;
	public void setModel(StudentServiceInterface model) {
		this.model = model;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		String[] a=arg0.getParameterValues("x");
		int count=0;
		for(int i=0;i<a.length;i++){
			model.deleteStudent(Integer.parseInt(a[i]));
			count++;
		}
		if(count==a.length)
		return new ModelAndView("successdef") ;
		return new ModelAndView("errordef") ;
	}

}
