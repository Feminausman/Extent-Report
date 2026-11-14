package Swagtest_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

import Base_package.SwagBase;

public class Swaglogintest extends SwagBase {
	
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		test=extent.createTest("Loginverification");
		obj.login("standard_user","secret_sauce");
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void validation()
	{
		test=extent.createTest("Loginvalidation");
		String expurl="https://www.saucedemo.com/inventory.html";
		String acturl=obj.urlmthd();
		Assert.assertEquals(expurl, acturl);
	}
	
	@Test(priority = 3)
	public void titleverification()
	{
		test=extent.createTest("Titleverification");
		String exp="Swag Labs";
		String actual=obj.title();
		System.out.println(actual);
		Assert.assertEquals(exp, actual);
	}
	

}
