package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BeCognizant extends BasePage{

	//Creating Contstructor for BeCognizant
	public BeCognizant(WebDriver driver) {
		super(driver);
	}
	
	
	//Elements 
	
	//beCognizant text element
	@FindBy(xpath = "//span[text()='be.cognizant']") 
	WebElement txtBeCognizant;
	
	//one Cognizant text element 
	@FindBy(xpath = "//div[@title='OneCognizant']")
	WebElement txtOneCognizant;
	
	//Profile element 
	@FindBy(xpath = "//div[@id='SuiteNavWrapper']//div[@id='O365_HeaderRightRegion']")
	WebElement imgProfile;
	
	//Username element
	@FindBy(xpath = "//div[@class='mectrl_dropdownbody expanded']//div[@class = 'mectrl_name mectrl_truncate']")
	WebElement txtuserName;
	
	//Email element
	@FindBy(xpath = "//div[@class='mectrl_dropdownbody expanded']//div[@class = 'mectrl_truncate']")
	WebElement txtuserEmail;
	
	
	//Actions 
	
	// Check if be cognizant text is visible
	public String beCognizantVisibility() {
		try{
			String text = txtBeCognizant.getText();
			return text;
		}
		catch(Exception e) {
			return (e.getMessage());		
			}
		
	}
	
	// Click On Profile Picture
		public void clickOnProfile() {
			imgProfile.click();
		}
		
	// Check if Name is Present 
		public String usernameVisibility() {
			try{
				String text = txtuserName.getText();
				return text;
			}
			catch(Exception e) {
				return (e.getMessage());		
				}
		}
		
	// Check if Email is Present 
		public String emailVisibility() {
			try{
				String text = txtuserEmail.getText();
				return text;
			}
			catch(Exception e) {
				return (e.getMessage());		
				}
		}
		
		
	
	// Check if oneCognizant text is visisble
	public String oneCognizantVisibility() {
		try{
			String text = txtOneCognizant.getText();
			return text;
		}
		catch(Exception e) {
			return (e.getMessage());		
			}
	}
	
	
	// Click on OneCognizant 
	public void clickOneCognizant() {
		txtOneCognizant.click();
		Set<String> winHandleBefore = driver.getWindowHandles();  // Handle browser window switch driver to OneCognizant Page

		for(String winHandle : winHandleBefore){
			String title = driver.switchTo().window(winHandle).getTitle();
			if(title.equals("OneCognizant")) {
				driver.switchTo().window(winHandle);
			}
		}
	}
}
