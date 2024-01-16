package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.OneCognizant;
import utilityFiles.Screenshots;

public class TC002_OneCognizant extends TC001_BeCognizant {

	//Test 5: Search "GSD" in the textArea
	@Test(priority = 5)
	public void searchGsd() throws InterruptedException, IOException{
		OneCognizant oneCog = new OneCognizant(driver);     //Instance of BeCognizant.java
		Screenshots ss = new Screenshots();
		
		// Condition if Edge searech button need to be clicked first then search "GSD"
		if(choice==2) {
			oneCog.clickandsearchmagnifier(p.getProperty("searchText"));
		}
		else {
			oneCog.searchText(p.getProperty("searchText"));
		}
		
		Thread.sleep(3000);
		ss.ScreenShot("SearchResult.png");    // Screenshot 3: Getting the search Result screenshot
		
	}
	
	//Test 6: Clicking on the GSD Button
	@Test(priority = 6)
	public void clickOnGSD() throws InterruptedException, IOException{
		OneCognizant oneCog = new OneCognizant(driver);
		Screenshots ss = new Screenshots();
		oneCog.clickOnGsd();
		Thread.sleep(5000);
		ss.ScreenShot("GSDIndia.png");        // Screenshot 4: GSD India page screenshot
		
	}
}
