package com.presentationlayer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dataaccesslayer.dto.Student;
import com.servicelayer.StudentServiceInterface;


public class SelectController extends AbstractController{
	private StudentServiceInterface model;
		public void setModel(StudentServiceInterface model) {
		this.model = model;
	}
		@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String outputPage=null;
		System.out.println("inside selctcontroller");
		// TODO Auto-generated method stub
		List<Student> list=null;
		list=model.selectStudent();
		
		if(list.size()==0)
			outputPage="norecorddef";
		else if(list.size()>0)
			outputPage="selectdef";
		else
			outputPage="errordef";
		return new ModelAndView(outputPage,"list",list);
	}

}
