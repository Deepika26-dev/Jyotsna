package com.Mohs10.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JyotsnaPageobjects {
	public static WebDriver driver;
	// login pageobjects
	public static By Firstpagem10lnk = By.xpath("//b[normalize-space()='MOHS10 Technologies']");
	public static By Superemail = By.xpath("//input[@id='email']");
	public static By superpwd = By.xpath("//input[@id='password']");
	public static By Superloginbtn = By.xpath("//input[@value='LOGIN']");
	public static By SuperLogoutdropdown = By.xpath("//a[@id='profileDropdown']");
	public static By SuperLogoutbtn = By.xpath("//a[@class='dropdown-item']");
	
	//Add Admin - Super admin Module
	public static By addadminlnk = By.xpath("//span[normalize-space()='Add Admin']");
	public static By nametxtbox = By.xpath("//input[@id='exampleInputUsername1']");
	public static By locationbox = By.xpath("//select[@id='locationSelect']");
	public static By emailbox = By.xpath("//input[@id='exampleInputUsername3']");
	public static By passwordbox = By.xpath("//input[@id='exampleInputPassword1']");
	public static By Addadminsubmitbtn = By.id("submitButton");
	
	//Add Location - Super Admin Module
	public static By addlocationlnk = By.xpath("//span[normalize-space()='Add Location']");
	public static By locationtxtbox = By.id("Location");
	public static By locationsubmitbtn = By.xpath("//button[@type='submit']");

	//User - Edit and Delete
	public static By user = By.xpath("//a[@href='/superadmin/User']");
	public static By editicon  = By.className("edit-icon");
	public static By useremail = By.xpath("//input[@id='exampleInputUsername3']");
	public static By userlocation = By.xpath("//select[@id='locationSelect']"); 
	public static By superusersubmitbtn = By.id("submitButton");
	public static By deleteicon = By.className("delete-icon");
	public static By usrdeletebtn = By.xpath("//button[normalize-space()='Delete']");
	
	//Add user - Admin Module
	public static By adduserlink = By.xpath("//a[@href='/admin/AddUsers']");
	public static By adminuser = By.xpath("//input[@id='exampleInputUsername1']");
	public static By adminlocation = By.xpath("//input[@id='location']");
	public static By adminemail = By.xpath("//input[@id='exampleInputUsername3']");
	public static By adminpass = By.xpath("//input[@id='exampleInputPassword1']");
	public static By admindroprole = By.xpath("//select[@id='RoleSelect']");
	public static By adminsubmitbtn = By.xpath("//button[@id='submitButton']");
	
	//add patient - Receptionist Module
	public static By recepsearchpatient = By.xpath("//input[@id='searchInput']");
	public static By recepaddpatntbtn = By.linkText("+Add Patient");
	public static By ptnFname = By.id("first_name");
	public static By ptnLname = By.id("last_name");
	public static By ptngender = By.name("gender");
	public static By ptndob = By.id("dob");
	public static By ptnzipcode = By.name("zip_code");
	public static By ptnstate = By.id("stateSelect");
	public static By ptncity = By.id("location");
	public static By ptnaddress = By.name("address");
	public static By ptnphone = By.name("phone_number");
	public static By ptnemail = By.name("email");
	public static By ptnsubmitbtn = By.id("submitButton");
	
	
	public static By salesloginid  = By.xpath("//input[@id='username']");
	public static By salesloginpass = By.xpath("//input[@id='password']");
	public static By salesloginbtn = By.xpath("//input[@id='Login']");
	public static By salesdashboard  = By.xpath("//span[normalize-space()='Dashboards']");
	
	public static By salesalldashboard = By.xpath("//a[@title='All Dashboards']");
	public static By salesAdoptiondash = By.xpath("//a[@title='Adoption Dashboard']");
	
//	public static By  = By.xpath("//a[@title='Adoption Dashboard']");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	public static By  = By.xpath("");
//	
	
//	public static By  = By.xpath("");
	

	
	
	

}
