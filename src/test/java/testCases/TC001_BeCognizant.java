package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.BeCognizant;
import pageObjects.OneCognizant;
import testBase.BaseClass;

public class TC001_BeCognizant extends BaseClass{

	
	
	@Test(priority = 1)        // Check if Be.Cognizant is visible or not
	public void beCognizantValidation() throws InterruptedException{
		BeCognizant bCog = new BeCognizant(driver);     //Instance of BeCognizant.java
		String text = bCog.beCognizantVisibility();
		Assert.assertEquals(text,"be.cognizant");
		bCog.clickOneCognizant();
		Thread.sleep(5000);
	}
	
//	@Test(priority = 2)
//	public void oneCognizantValidation() throws InterruptedException{
//		OneCognizant oneCog = new OneCognizant(driver);     //Instance of BeCognizant.java
//		oneCog.searchText();
//		Thread.sleep(3000);
//		
//	}

}
