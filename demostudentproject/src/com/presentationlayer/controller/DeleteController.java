package com.presentationlayer.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dataaccesslayer.dto.Student;
import com.servicelayer.StudentServiceInterface;


public class DeleteController extends AbstractController{
private StudentServiceInterface model;
public void setModel(StudentServiceInterface model) {
	this.model = model;
}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		List<Student> list=null;
		String view=null;
		 list=model.selectStudent();
		 if(list.size()==0)
			 view="norecorddef";
			else if(list.size()>0)
				view="deletedef";
			else
				view="errordef";
		return new ModelAndView(view,"list",list);
	}

}
