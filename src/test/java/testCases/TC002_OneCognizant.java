package testCases;

import org.testng.annotations.Test;

import pageObjects.OneCognizant;

public class TC002_OneCognizant extends TC001_BeCognizant {

	@Test(priority = 2)
	public void oneCognizantValidation() throws InterruptedException{
		OneCognizant oneCog = new OneCognizant(driver);     //Instance of BeCognizant.java
		oneCog.searchText();
		Thread.sleep(3000);
	}
}
