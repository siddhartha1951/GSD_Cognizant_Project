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
	@FindBy(xpath = "//input[@id='oneC_searchAutoComplete']")
	WebElement inputSearchText;
	
	
	
	//Actions
	public void searchText() {
		inputSearchText.sendKeys("GSD");
	}
	
	
}
