package com.Mohs10.Functions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import com.Mohs10.Base.Action;
import com.Mohs10.Base.StartBrowser;
import com.Mohs10.OR.JyotsnaPageobjects;

public class CommonFuns {
	public Action aDriver;
	public WebDriver driver;

	public CommonFuns() {
		aDriver = new Action();
		driver = StartBrowser.driver;
	}

	// Login process
	public void logIn(String email, String pwd) throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login Functionality of super Admin Module");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");

		// aDriver.click(JFirstPage.Firstpagem10lnk, "Navigation to mohs10 Link");
		aDriver.type(JyotsnaPageobjects.Superemail, email, "email text box");
		aDriver.type(JyotsnaPageobjects.superpwd, pwd, "password text box");
		aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");
	}

	// Negative login process
	public void invalidLogIn(String email, String pwd) throws Exception {
		StartBrowser.childTest = StartBrowser.parentTest
				.createNode("Negative Testing on Login Functionality of super admin Module");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");
		aDriver.type(JyotsnaPageobjects.Superemail, email, "email text box");
		aDriver.type(JyotsnaPageobjects.superpwd, pwd, "password text box");
		aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");
	}

	public void logout() throws Exception {

		aDriver.click(JyotsnaPageobjects.SuperLogoutdropdown, "Logout link");
		aDriver.click(JyotsnaPageobjects.SuperLogoutbtn, "Logout link");
	}
	
	// Login as super Admin then add admin
	public void AddAdmin(String SAdminname, String SAPass,String adminname, By locationBy,String Adminemail, String Adminpass) throws Throwable {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Add Admin Functionality of SuperAdmin Module");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");

		aDriver.type(JyotsnaPageobjects.Superemail, SAdminname, "email text box");
		aDriver.type(JyotsnaPageobjects.superpwd, SAPass, "password text box");
		aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");
		
		aDriver.click(JyotsnaPageobjects.addadminlnk, "Addadminlnk");
		aDriver.type(JyotsnaPageobjects.nametxtbox, adminname, "AddAdminnametextbox");
		
		aDriver.click(locationBy, "locationbox");
		Select select = new Select(driver.findElement(locationBy));
		select.selectByVisibleText("patia");
		
		aDriver.type(JyotsnaPageobjects.emailbox, Adminemail, "emailbox");
		aDriver.type(JyotsnaPageobjects.passwordbox, Adminpass, "passwordbox");
		
//		WebElement myelement = driver.findElement(By.id("submitButton"));
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
//		aDriver.click(JyotsnaPageobjects.Addadminsubmitbtn, "Addadminsubbtn");
		
		//Wait for the Element to Be Clickable:
		// Create a FluentWait instance
		Wait<WebDriver> wait = new FluentWait<>(driver)
		    .withTimeout(Duration.ofSeconds(10))  // Adjust the timeout as needed
		    .pollingEvery(Duration.ofMillis(500)) // Adjust the polling interval as needed
		    .ignoring(org.openqa.selenium.NoSuchElementException.class);
		
		 // Check if an element is displayed
		WebElement submitButton = driver.findElement(By.id("submitButton"));
	    if (Action.isEnabled(driver, submitButton)) {
	        // Element is enabled, proceed with further actions
	        submitButton.click();
	    } else {
	        // Element is not enabled, handle the case as needed
	        System.out.println("Submit button is not enabled.");
	    }

		// Use FluentWait to wait for the element to be clickable and then click it
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
		element.click();
		
	}

	public void AddLocation(String SAdminname, String SAPass, String location) throws Throwable {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Add Location Functionality of SuperAdmin Module");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");

		aDriver.type(JyotsnaPageobjects.Superemail, SAdminname, "email text box");
		aDriver.type(JyotsnaPageobjects.superpwd, SAPass, "password text box");
		aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");
		aDriver.click(JyotsnaPageobjects.addlocationlnk, "Addlocationlnk");
		aDriver.type(JyotsnaPageobjects.locationtxtbox, location, "locationbox");
		aDriver.click(JyotsnaPageobjects.locationsubmitbtn, "Addlocation submit btn");
		
		 // Store the added location information
        String addedLocation = location;
        
     // Call the deleteLocation function to remove the added location
        deleteLocation(SAdminname, SAPass, addedLocation);
    }
	
	public void deleteLocation(String SAdminname, String SAPass, String addedLocation) throws Throwable {
	    // Log in as the super admin
	    aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");
	    aDriver.type(JyotsnaPageobjects.Superemail, SAdminname, "email text box");
	    aDriver.type(JyotsnaPageobjects.superpwd, SAPass, "password text box");
	    aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");

	    // Navigate to the location management page
	    //aDriver.click(JyotsnaPageobjects.locationManagementLink, "Location Management Link");// update the xpath of added location here

	    // Locate and delete the added location
	    List<WebElement> locationElements = driver.findElements(By.xpath("//table[@id='locationTable']/tbody/tr"));
	    
	    for (WebElement locationElement : locationElements) {
	        String locationName = locationElement.findElement(By.xpath("./td[1]")).getText();

	        if (locationName.equals(addedLocation)) {
	            // Found the location, delete it
	            locationElement.findElement(By.xpath("./td[4]/button")).click(); // Assuming the delete button is in the 4th column
	            Action.handleAlert("accept"); // Confirm the delete action
	            break; // Exit the loop
	        }
	    }
	}


	public void User_Edit_Delete(String SAdminname, String SAPass, String email) throws Throwable {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("user edit and delete Functionality of SuperAdmin Module");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");
		aDriver.type(JyotsnaPageobjects.Superemail, SAdminname, "email text box");
		aDriver.type(JyotsnaPageobjects.superpwd, SAPass, "password text box");
		aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");
		
		aDriver.click(JyotsnaPageobjects.user, "SuperAdminUserlnk");
		aDriver.click(JyotsnaPageobjects.editicon, "edit icon");

	    aDriver.click(JyotsnaPageobjects.useremail, "user email edit option");
        WebElement inputField = driver.findElement(By.id("exampleInputUsername3"));
        inputField.clear();
	    aDriver.type(JyotsnaPageobjects.useremail, email, "email text box");
	    //aDriver.findElement(JyotsnaPageobjects.useremail).sendKeys(Keys.BACK_SPACE);	
	    
	    WebElement myelement = driver.findElement(By.id("submitButton"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", myelement);
		
		aDriver.click(JyotsnaPageobjects.superusersubmitbtn, "submit btn");
		aDriver.click(JyotsnaPageobjects.user, "SuperAdminUserlnk");
		aDriver.click(JyotsnaPageobjects.deleteicon, "delete icon");
		aDriver.click(JyotsnaPageobjects.usrdeletebtn, "delete button");
	}
	
	public void Admin_Adduser(String Adminlog, String Adminpwd, String username, String userlocation, String useremail,String userpassword, By role) throws Throwable { 
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Admin_Adduser Functionality of SuperAdmin Module");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");
		
		aDriver.type(JyotsnaPageobjects.Superemail, Adminlog, "email text box");
		aDriver.type(JyotsnaPageobjects.superpwd, Adminpwd, "password text box");
		aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");
		
		aDriver.click(JyotsnaPageobjects.adduserlink, "add user link");
		
		aDriver.type(JyotsnaPageobjects.adminuser, username , "username");
		aDriver.type(JyotsnaPageobjects.adminlocation, userlocation , "adminlocation");
		aDriver.type(JyotsnaPageobjects.adminemail, useremail , "adminemail");
		aDriver.type(JyotsnaPageobjects.adminpass, userpassword, "adminpass");
		
		aDriver.click(role, "admindroprole");
		Select select = new Select(driver.findElement(role));
		select.selectByValue("ROLE_RECEPTIONIST");
		aDriver.click(JyotsnaPageobjects.adminsubmitbtn, "admin submit button");
		
	}
	
	public void Receptionist_AddPatient(String Recepemail, String Receppass, String ptnFname, String ptnLname, String ptnzip,String ptncity, String ptnaddress, String ptnphone, String ptnemail, By gender, By state) throws Throwable {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Receptionist module add patient Functionality");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");
		
		aDriver.type(JyotsnaPageobjects.Superemail,Recepemail , "Recepemail");
		aDriver.type(JyotsnaPageobjects.superpwd, Receppass, "Receppass");
		aDriver.click(JyotsnaPageobjects.Superloginbtn, "Login button");
		
		aDriver.click(JyotsnaPageobjects.recepaddpatntbtn, "Add patient button");
		aDriver.type(JyotsnaPageobjects.ptnFname, ptnFname , "patient first name");
		aDriver.type(JyotsnaPageobjects.ptnLname, ptnLname , "patient Last name");
		
		aDriver.click(gender, "ptngender");
		Select select = new Select(driver.findElement(gender));
		select.selectByValue("Female");
		
//		aDriver.click(JyotsnaPageobjects.ptndob, "ptndob");
//	    aDriver.waitForElementToBeClickable(calendarDateElement); 
//	    aDriver.click(calendarDateElement); 
		
		//aDriver.type(JyotsnaPageobjects.ptndob, ptndob , "patient dob");
		aDriver.type(JyotsnaPageobjects.ptnzipcode, ptnzip , "patient zip code");
		
		aDriver.click(state, "ptnstate");
		Select select2 = new Select(driver.findElement(state));
		select2.selectByValue("Tripura");
		
		aDriver.type(JyotsnaPageobjects.ptncity, ptncity , "patient city");
		aDriver.type(JyotsnaPageobjects.ptnaddress, ptnaddress , "patient address");
		aDriver.type(JyotsnaPageobjects.ptnphone, ptnphone , "patient phone number ");
		aDriver.type(JyotsnaPageobjects.ptnemail, ptnemail , "patient email id");
	
//		aDriver.click(JyotsnaPageobjects., "");
//		aDriver.click(JyotsnaPageobjects., "");

	}

	
	
	public void Salesforce_app(String username, String Password) throws Throwable {
	    StartBrowser.childTest = StartBrowser.parentTest.createNode("add contacts functionality");
	    aDriver.navigateToApplication("https://customer-flow-1013.my.salesforce.com/");
	    aDriver.type(JyotsnaPageobjects.salesloginid, username, "patient email id");
	    aDriver.type(JyotsnaPageobjects.salesloginpass, Password, "patient email id");
	    aDriver.click(JyotsnaPageobjects.salesloginbtn, "Login button");
	   
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed 
	    wait.until(ExpectedConditions.elementToBeClickable(JyotsnaPageobjects.salesdashboard)).click();

	    
	  //  aDriver.click(JyotsnaPageobjects.salesalldashboard, "All dashboard item ");
	  //  aDriver.click(JyotsnaPageobjects.salesAdoptiondash, "Adoption dashboard");
	    
	   // Actions a=new Actions(driver);
		//  a.sendKeys(Keys.PAGE_DOWN).perform();
		  //a.sendKeys(Keys.PAGE_DOWN).perform();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Verify the website title and logo- index page
	public void VerifyingWebsiteTitle() {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Verifying the Title of the Application");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expTitle = "Login | Jyotsna";

		if (actualTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Verified Title : Test Passed   " + actualTitle);
		} else {
			System.out.println("Title Not Matched : Test Failed" + expTitle);
		}
	}

	// Identify Logo
	public void VerifyingLogo() {
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Verifying the Logo of the Application");
		aDriver.navigateToApplication("http://jyotsnaprod.ap-south-1.elasticbeanstalk.com/");

		boolean logopresent = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img"))
				.isDisplayed();
		Assert.assertTrue(logopresent);
	}

}
