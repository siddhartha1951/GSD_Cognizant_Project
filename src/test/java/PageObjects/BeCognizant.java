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
	@FindBy(xpath = "//span[text()='be.cognizant']") 
	WebElement txtBeCognizant;
	
	@FindBy(xpath = "//div[@title='OneCognizant']")
	WebElement txtOneCognizant;
	
	
	
	//Actions 
	public String beCognizantVisibility() {
		try{
			String text = txtBeCognizant.getText();
			return text;
		}
		catch(Exception e) {
			return (e.getMessage());		
			}
		
	}
	
	public void clickOneCognizant() {
		txtOneCognizant.click();
		Set<String> winHandleBefore = driver.getWindowHandles();

		for(String winHandle : winHandleBefore){
			String title = driver.switchTo().window(winHandle).getTitle();
			if(title.equals("OneCognizant")) {
				driver.switchTo().window(winHandle);
			}
		}
	}
}
