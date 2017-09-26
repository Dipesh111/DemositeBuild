package com.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import supportingMethods.ReusableLibrary;
import utility.BaseClass;
import utility.ExcelData;

public class UserLogin extends BaseClass 
{
	@Test
	@Parameters({ "uname", "upass" })
	public void userLoginToApplication(String uname, String upass) throws InterruptedException 
	{   test = extent.startTest("userLoginToApplication");
		ln.login(uname,upass);
		System.out.println(driver.getTitle());
		ln.logOut();
	}

	@Test(priority = 0, enabled = false )
	public void activeLinkCheckup() {
		ReusableLibrary.TotalLinksWorking(driver);
	}
}
