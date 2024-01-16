package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneCognizant extends BeCognizant{
	
	// Creating constructor of OneCognizant
	public OneCognizant(WebDriver driver) {
		super(driver);	
	}
	
	//Elements
	
	// Search Input Area element(For Chrome Browser )
	@FindBy(xpath = "//input[@id='oneC_searchAutoComplete']")
	WebElement inputSearchText;
	
	// GSD-Live Support Button element after searching GSD
	@FindBy(xpath = "//div[@class = 'appsResultText']")
	WebElement btnGsd;
	
	// Search Input Area element (For Edge Browser)
	@FindBy(xpath="//input[@id='oneCSearchTop']")
	WebElement edgesearchbar;
	
	// Search Icon Element (For Edge Browser)
	@FindBy(xpath="//ul[@class='searchBasedTopBar']/li")
	WebElement magnifier;

	
	//Actions
	
	// Click on the Search Icon and Searching for GSD(For Edge Browser)
	public void clickandsearchmagnifier(String key) {
		magnifier.click();
		edgesearchbar.sendKeys(key);
	}
	
	// Giving input "GSD" in the search Text Area
	public void searchText(String key) {
		inputSearchText.sendKeys(key);
	}
	
	// Click on the Live Support - GSD Button
	public void clickOnGsd() {
		btnGsd.click();
		driver.switchTo().frame("appFrame");
	}
	
	
}
