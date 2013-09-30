package com.unittests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.unittests");
		//$JUnit-BEGIN$
		suite.addTestSuite(MyTestCase.class);
		//$JUnit-END$
		return suite;
	}
}
