package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.BeCognizant;
import testBase.BaseClass;
import utilityFiles.Screenshots;

public class TC001_BeCognizant extends BaseClass{

	
	//Test 1: Check if Be.Cognizant is visible or not
	@Test(priority = 1)        
	public void beCognizantTextValidation(){
		BeCognizant bCog = new BeCognizant(driver);     //Instance of BeCognizant.java
		String text = bCog.beCognizantVisibility();
		Assert.assertEquals(text,p.getProperty("beCognizantText"));		 //Validation
		
		logger.info("--//beCognizant Validation Done//--");
	}
	
	
	// Test 2: Profile Validation 
	@Test(priority = 2)     
	public void profileValidation() throws IOException, InterruptedException {
		BeCognizant bCog = new BeCognizant(driver);
		
		Screenshots ss = new Screenshots();
		bCog.clickOnProfile();
		Thread.sleep(3000);
		
		ss.ScreenShot("BeCognizantProfile.png");     // Screenshot 1: if the Profile is displayed
		
		String userName = bCog.usernameVisibility();
		Assert.assertEquals(userName, p.getProperty("name"));   // Check if Name is correct
		String userEmail = bCog.emailVisibility();
		Assert.assertEquals(userEmail, p.getProperty("email"));	// Check if Email is correct
		
		
	}
	
	// Test 3: Check if OneCognizant is present 
	@Test(priority = 3)
	public void oneCognizantTextValidation() {
		BeCognizant bCog = new BeCognizant(driver);
		boolean textOneCognizant = bCog.oneCognizantVisibility().equalsIgnoreCase(p.getProperty("oneCognizantText"));
		Assert.assertEquals(textOneCognizant,true);        // Validation
	}
	
	//Test 4: Navigate to OneCognizant 
	@Test(priority = 4)
	public void navigateOneCognizant() throws IOException, InterruptedException {
		BeCognizant bCog = new BeCognizant(driver);
		bCog.clickOneCognizant();
		
		Screenshots ss = new Screenshots();
		Thread.sleep(5000);
		ss.ScreenShot("OneCognizant.png");     // Screenshot 2: of OneCognizant Page
	}

}
