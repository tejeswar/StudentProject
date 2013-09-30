package com.unittests;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dataaccesslayer.dao.StudentDaoImpl;
import com.dataaccesslayer.dto.Student;

public class MyTestCase extends TestCase{
    private StudentDaoImpl sdi;
	@Before
	public void setUp() throws Exception {
		sdi = new StudentDaoImpl();
		System.out.println("MyTestCase:setUp()");
	}

	@After
	public void tearDown() throws Exception {
		sdi = null;
		System.out.println("MyTestCase:tearDown()");
	}
	@Test
	public void testValidSelectStudent(){
		List<Student> listExpected=new ArrayList<Student>();
		Student s1 = new Student(2, "ram", 8877665544l, "rama5@gmail.com", "2013-12-15");
		Student s2 = new Student(19, "papu", 9745327148l, "papu@gmail.com", "2007-10-17");
		listExpected.add(s1);
		listExpected.add(s2);
		List<Student> actualList = sdi.selectStudent();
		assertEquals(listExpected.get(0).getRoll(),actualList.get(0).getRoll());
	}

}
