package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Parallel {

	@BeforeMethod
	public void before() {
		System.out.println("before method");
	}
	@Test
	public void test1() {
		System.out.println("test one");
	}
	
	@Test
	public void test2() {
		System.out.println("test two");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("after method");
	}
}
