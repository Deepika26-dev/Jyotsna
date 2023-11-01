package com.Mohs10.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;

public class Super_AddLocation extends StartBrowser {
	@Test
	public void AddAdminTest() throws Throwable {
		String excelfile = "C:\\Users\\Dell\\eclipse-workspace\\Jyotsna-Mohs10\\TestData\\JyotsnaTsdata.xlsx";
		String excelsheet = "AddLocation";

		CommonFuns hm1 = new CommonFuns();
		String Email = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
		String Pwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);
		String Location = XLUtils.getStringCellData(excelfile, excelsheet, 1, 2);

		hm1.AddLocation(Email, Pwd, Location);
		Thread.sleep(5000);
		
		// Add an assertion to verify if the action was successful
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/superadmin/Success";
		Assert.assertEquals(currentUrl, expectedUrl, "URLs matched, Test Case Passed");

		// Call the deleteLocation function to remove the added location
       hm1.deleteLocation(Email, Pwd, Location);
       
       hm1.logout();

	}
}
