package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.GSDPage;
import utilityFiles.ExcelUtils;
import utilityFiles.Screenshots;

@Listeners(utilityFiles.ExtentReportManager.class)
public class TC003_GSDPage extends TC002_OneCognizant{

	// Test 7: Verify if the WelCome Message and browse Message is available
	@Test(priority = 7)
	public void verifyMessage(){
		GSDPage gsdP = new GSDPage(driver);
		String welcomeText = gsdP.getWelcomeMsg();
		String browseText = gsdP.getBrowseMsg();
		
		Assert.assertEquals(welcomeText, p.getProperty("WelComeMessage"));
		Assert.assertEquals(browseText, p.getProperty("BrowseMessage"));
	}
	
	// Test 8: Verify if the Default Lnaguage is present ("English")
	@Test(priority = 8)
	public void verifyDefaultLanguage() {
		GSDPage gsdP = new GSDPage(driver);
		String lang = gsdP.getDefaultLanguage();
		Assert.assertEquals(lang, p.getProperty("defaultLanguage"));
	}
	
	// Test 8: Verify if the Default Country is present ("India")
	@Test(priority = 9)
	public void verifyDefaultCountry() {
		GSDPage gsdP = new GSDPage(driver);
		String country = gsdP.getDefaultCountry();
		Assert.assertEquals(country, p.getProperty("defaultCountry"));
	}
	
	//Test 9: Get all available Languages and print on console and write into testexcel.xslx
	@Test(priority = 10)
	public void verifyAvailableLanguages() throws IOException{
		GSDPage gsdP = new GSDPage(driver);
		
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
		
		List<WebElement> lang = gsdP.getAVailableLanguages();  // Getting all languages in a list
		System.out.println("-------AVAILABLE LANGUAGES------");
		
		Screenshots ss = new Screenshots();
		ss.ScreenShot("Languages.png");						//Getting the screenshot of Languages
		
		for(int l = 0 ; l< lang.size();l++) {
			System.out.println(lang.get(l).getText());    // Print all lnaguages on console
			excel.setCellData(xlFile, "Lnaguages", l+1, 0, lang.get(l).getText());     // Write all languages in testexcel.xlsx
		}
	}
	
	
	// Test 11: Get all Countries available and print on the console and write into testexcel.xlsx
	@Test(priority = 11)
	public void verifyAvailableCountries() throws IOException, InterruptedException{
		GSDPage gsdP = new GSDPage(driver);
		
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
		
		List<WebElement> countr = gsdP.getAvailableCountries();        // Get all countries in a List
		System.out.println("-------AVAILABLE COUNTRIES------");
		
		Screenshots ss = new Screenshots();
		Thread.sleep(2000);
		ss.ScreenShot("Countries.png");         // Getting the screenshot of Countries 
		
		int size = countr.size(); 
		System.out.println("Total countries available = " + size);    // Printing the total No. of countries available
		
		for(int c = 0; c<size; c++) {
			System.out.println(countr.get(c).getText());				// Print all countries name on console
			excel.setCellData(xlFile, "Countries", c+1, 0, countr.get(c).getText());		//write all countries name in testexcel.xlsx
		}
	}


	//Test 12: Getting all ticket details for the dafault country("India")
	@Test(priority=12)
	public void defaultCountryTickets() throws IOException {
		GSDPage gsdP =  new GSDPage(driver);
		
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
		
		String defaultCountry = gsdP.getDefaultCountry();
		String sheetName = defaultCountry+"Tickets";       // Name of the sheet in excel
		
		//Call methods for getting ticket details
		verifyITInfraSupport(sheetName);
		verifyHumanResources(sheetName);
		verifyITApplicationSupport(sheetName);
		verifyPolicyProcessSupport(sheetName);
		
		//Writing Name of country
		excel.setCellData(xlFile, sheetName, 10, 0, defaultCountry);
		excel.fillGreenColor(xlFile, sheetName, 10, 0);
	}

	//Test 13: Picking 2 random countries and getting all the ticket details
	@Test(priority = 13)
	public void randomCountry() throws InterruptedException, IOException {
		GSDPage gsdP = new GSDPage(driver);
		Screenshots ss = new Screenshots();
		
		List<WebElement> country = gsdP.getAvailableCountries();
		gsdP.clickCountries();
		
		int size = country.size();
		System.out.println(size);
		
		gsdP.clickCountries();
		
		int count=0;
		for(int i=0;i<size;i++) {
			int choosenNo = randomNumber(size);    //getting a random number within the range = size = no. of countries
			System.out.println(choosenNo);			// Print the choosen random number
			if(choosenNo!=0) {
				count++;
				gsdP.clickCountries();
				
				String coun = country.get(choosenNo).getText();      // Get the name of the country
				country.get(choosenNo).click();						// Click on the choosen country
				
				System.out.println("Random Country "+count+": "+coun);   // Print the country name
				System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-");
				
				String sheetName = "Country"+count;					// Getting the sheetname for Countries in testexcel.xlsx
				
				//Call methods for getting ticket details
				verifyITInfraSupport(sheetName);
				verifyHumanResources(sheetName);
				verifyITApplicationSupport(sheetName);
				verifyPolicyProcessSupport(sheetName);
				
				ExcelUtils excel = new ExcelUtils();
				String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
				
				//Writing the country name in Excel
				excel.setCellData(xlFile, sheetName, 10, 0, coun);
				excel.fillGreenColor(xlFile, sheetName, 10, 0);
				
				Thread.sleep(5000);
				ss.ScreenShot(coun+".png");   // Getting the screenshot for countries displayed as country_name.png 
				
			}
			// Breaking the loop if 2 countries are selected 
			if(count==2) {
				break;
			}
		}
		
	}
	
}
