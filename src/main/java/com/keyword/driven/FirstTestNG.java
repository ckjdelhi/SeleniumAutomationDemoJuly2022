package com.keyword.driven;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNG {
	
	@BeforeTest
	public void preRun() {
		System.out.println("Before Test");
	}
	@AfterTest
	public void cleanUp() {
		System.out.println("Clean up");
	}
	@Test
	public void test1() {
		System.out.println("Welcome");
	}
	
	
}
