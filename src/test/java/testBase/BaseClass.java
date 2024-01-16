package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.GSDPage;
import utilityFiles.ExcelUtils;

public class BaseClass {

	public static WebDriver driver;
	public Properties p;
	public int choice;
	public Logger logger;
	Scanner sc;
	@BeforeClass
	public void setup() throws IOException
	{
				//loading properties file
				FileReader file = new FileReader(".//src//test//resources//config.properties");
				p = new Properties();
				p.load(file);
			
				//Logger
				logger = LogManager.getLogger(this.getClass());
				
			    sc = new Scanner(System.in);
			    
			    //choosing browser
				System.out.println("Press 1 : Chrome ");
				System.out.println("Press 2 : Edge ");
				System.out.println("Press 3 : Exit ");
				choice = sc.nextInt();
				//Switch Case to Choose the browser
				switch(choice) {
				case 1: 
					driver = new ChromeDriver();     //  Launch Chrome
					break;
				case 2:
					driver = new EdgeDriver();		 // Launch Edge 
					break;
				case 3:
					System.out.println("Program Closed");
					System.exit(0);
					break;
				default:
					System.out.println("Please Select the correct choice");
					System.exit(0);
				}
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().window().maximize();
				driver.get(p.getProperty("appURL"));
				
	}
	
	//Quit the browser
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	// Random input taking
	public int randomNumber(int size) {
		Random random = new Random();
		int randomNumber1 = random.nextInt(size);
		return randomNumber1;
	}

	// Getting all the data present in GSD Tickets
	
	
	//IT Infra Support Details
	public void verifyITInfraSupport(String countrySheet) throws IOException {
		GSDPage gsdP = new GSDPage(driver);					 
		
		String infraHead = gsdP.getItInfraSuppHeading();     // IT Infra Support Heading
		
		Assert.assertEquals(infraHead, "IT Infra Support");	 // Heading verification
		System.out.println("==========================================");
		
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
		excel.setCellData(xlFile, countrySheet, 0, 0, infraHead);      // Heading name wrting to testexcel.xlsx
		
		List<WebElement>  itInfraItems = gsdP.getItInfraSuppItems();	// List of items in the section
		
		System.out.println("##"+infraHead+"##");
		
		// Items printing on console and writing to the testexcel.xlsx
		for(int ii =0; ii< itInfraItems.size(); ii++) {
			
			String ticket = itInfraItems.get(ii).getText();      // Ticket name 
			System.out.println(ticket);
			excel.setCellData(xlFile, countrySheet, ii+1, 0, ticket);
			
			System.out.println("<--->");
			
			String toolTip = itInfraItems.get(ii).getAttribute("data-bs-original-title"); //Tooltip of the ticketname
			System.out.println(toolTip);
			excel.setCellData(xlFile, countrySheet, ii+1, 1, toolTip);
		}
		System.out.println();
	}
	
	
	//Human Resources Details
	public void verifyHumanResources(String countrySheet) throws IOException {
		GSDPage gsdP = new GSDPage(driver);						
		
		String humanRsrcHead = gsdP.getHumanResourceHeading();  //Human Resources Heading
		
		Assert.assertEquals(humanRsrcHead, "Human Resources");   //Heading verification
		System.out.println("==========================================");
		
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
		excel.setCellData(xlFile, countrySheet, 0, 2, humanRsrcHead);     // Heading Name writing to testexcel.xlsx
		
		List<WebElement>  humanRsrcItems = gsdP.getHumanResourcesItems();  // List of items in the section
		
		System.out.println("##"+humanRsrcHead+"##");
		
		// Items printing on console and writing to the testexcel.xlsx
		for(int hr =0; hr< humanRsrcItems.size(); hr++) {
			
			String ticket = humanRsrcItems.get(hr).getText();       //Ticket name
			System.out.println(ticket);
			excel.setCellData(xlFile, countrySheet, hr+1, 2, ticket);
			
			System.out.println("<--->");
			
			String toolTip = humanRsrcItems.get(hr).getAttribute("data-bs-original-title");  //Tooltip of the ticket
			System.out.println(toolTip);
			excel.setCellData(xlFile, countrySheet, hr+1, 3, toolTip);
		}
		System.out.println();
	}
	
	//IT Application Support Details
	public void verifyITApplicationSupport(String countrySheet) throws IOException {
		GSDPage gsdP = new GSDPage(driver);
		
		String appHead = gsdP.getItAppSuppHeading();       //IT Application Support Heading
		
		Assert.assertEquals(appHead, "IT Application Support");  //Heading Verification
		System.out.println("==========================================");
		
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
		excel.setCellData(xlFile, countrySheet, 0, 4, appHead);      // Heading Name writing to testexcel.xlsx
		
		List<WebElement> itAppItems = gsdP.getItAppSuppItems();		 // List of items in the section
		
		System.out.println("##"+appHead+"##");
		
		// Items printing on console and writing to the testexcel.xlsx
		for(int iA =0; iA< itAppItems.size(); iA++) {
			
			String ticket = itAppItems.get(iA).getText();          //Ticket name
			System.out.println(ticket);
			excel.setCellData(xlFile, countrySheet, iA+1, 4, ticket);
			
			System.out.println("<--->");
			
			String toolTip = itAppItems.get(iA).getAttribute("data-bs-original-title");    //Tooltip of the ticket
			System.out.println(toolTip);
			excel.setCellData(xlFile, countrySheet, iA+1, 5, toolTip);
		}
		System.out.println();
	}
	
	//Policy & Process Support Details
	public void verifyPolicyProcessSupport(String countrySheet) throws IOException {
		GSDPage gsdP = new GSDPage(driver);
		
		String policyHead = gsdP.getPolicyProcessSuppHeading();     	//Policy & Process Support Heading
		
		Assert.assertEquals(policyHead, "Policy & Process Support");    	//Heading Verification
		System.out.println("==========================================");
		
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testexcel.xlsx";
		excel.setCellData(xlFile, countrySheet, 0, 6, policyHead);			//Heading Name writing to testexcel.xlsx
		
		List<WebElement> policyProcessItems = gsdP.getItAppSuppItems();		// List of items in the section
		
		System.out.println("##"+policyHead+"##");
		
		// Items printing on console and writing to the testexcel.xlsx
		for(int pP =0; pP< policyProcessItems.size(); pP++) {
			
			String ticket = policyProcessItems.get(pP).getText();          //Ticket name
			System.out.println(ticket);
			excel.setCellData(xlFile, countrySheet, pP+1, 6, ticket);
			
			System.out.println("<--->");
			
			String toolTip = policyProcessItems.get(pP).getAttribute("data-bs-original-title");   //Tooltip of the ticket
			System.out.println(toolTip);
			excel.setCellData(xlFile, countrySheet, pP+1, 7, toolTip);
		}
		System.out.println();
	}
	

}
