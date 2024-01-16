package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GSDPage extends BasePage{

	//Constructor of GSDPage
	public GSDPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements 
	
	//WelCome Message element
	@FindBy(xpath= "//p[@class='Welcome-automated-text']") 
	WebElement wlcmMsgText;
	
	//Browse message text element
	@FindBy(xpath= "//p[@class='LiSA-help-text']") 
	WebElement browseMsgText;
	
	//Default language selected element 
	@FindBy(xpath = "//form[contains(@class,'d-flex ms-auto')]//div[@class='nav-item dropdown languageOptions ']//span[@class='optionLangSelected']") 
	WebElement defaultLangSelected;
	
	//Default country selected element
	@FindBy(xpath = "//form[@class='d-flex ms-auto']//div[@class='nav-item dropdown languageOptions ']//span[@class='optionCountrySelected']") 
	WebElement defaultCountrySelected;
	
	//List of Languages available element
	@FindBy(xpath = "//ul[@class = 'dropdown-menu langList show']//li")
	List<WebElement> availableLanguages;
	
	//List of Countries available element
	@FindBy(xpath = "//ul[@class='dropdown-menu countryList pt-0 show']//li[@role ='presentation']//a")
	List<WebElement> availableCountries;
	
	
	//Services Heading Elements 
	
	//IT Infra Support Ticket Heading Element
	@FindBy(xpath="//div[@class='p-1 flex-fill tiles-heading'][1]//div[@role='heading']")
	WebElement itInfraSuppHeading;
	
	// Human Resource Heading Element
	@FindBy(xpath="//div[@class='p-1 flex-fill tiles-heading'][2]//div[@role='heading']")
	WebElement humanResourceHeading;
	
	//IT Application Support Heading Element
	@FindBy(xpath = "//div[@class='p-1 flex-fill tiles-heading'][3]//div[@role='heading']")
	WebElement itAppSuppHeading;
	
	//Policy and Process Heading Element
	@FindBy(xpath = "//div[@class='p-1 flex-fill tiles-heading'][4]//div[@role='heading']")
	WebElement policyProcessSuppHeading;
	
	
	//Services List Elements 
	
	//IT Infra Support Ticket Items Element
	@FindBy(xpath="//div[@class='p-1 flex-fill tiles-heading'][1]//div[@role='link']")
	List<WebElement> itInfraSuppItems;
	
	//Human Resource Items Element
	@FindBy(xpath="//div[@class='p-1 flex-fill tiles-heading'][2]//div[@role='link']")
	List<WebElement> humanResourceItems;
	
	//IT Application Support Items Element
	@FindBy(xpath="//div[@class='p-1 flex-fill tiles-heading'][3]//div[@role='link']")
	List<WebElement> itAppSuppItems;
	
	//Policy and Process Items Element
	@FindBy(xpath="//div[@class='p-1 flex-fill tiles-heading'][4]//div[@role='link']")
	List<WebElement> policyProcessSuppItems;
	
	
	// Actions
	
	//Returns the WelCome Message
	public String getWelcomeMsg() {
		try {
			String wlcm_exp = wlcmMsgText.getText(); //"Welcome to the all-in-one Live Support!";
			return wlcm_exp;
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	//Returns the Browse Message
	public String getBrowseMsg() {
		try{
			String browse_exp = browseMsgText.getText(); //"Browse queries. Chat with an agent. Submit and track tickets.";
			return browse_exp;
		}catch(Exception e) {
			return (e.getMessage());
		}	
	}
	
	//Returns the Default Language("English") present
	public String getDefaultLanguage() {
		try{
			String lang_exp = defaultLangSelected.getText(); //"English";
			return lang_exp;
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	// Returns the Default Location("India") present
	public String getDefaultCountry() {
		try{
			String country_exp = defaultCountrySelected.getText(); //"India";
			return country_exp;
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	// Returns all the Languages Available in a List
	public List<WebElement> getAVailableLanguages(){
		defaultLangSelected.click();
		
		return availableLanguages;
		
	}
	
	// Clicks on the Country dropdown
	public void clickCountries() {
		defaultCountrySelected.click();
	}
	
	// Returns all the Countries Available in a List
	public List<WebElement> getAvailableCountries(){
		defaultCountrySelected.click();
		
		return availableCountries;
		
	}

	
	// Method for getting details of the tickets present
	
	// Returns the Heading "IT Infra Support" 
	public String getItInfraSuppHeading() {
		try{
			String infraHead = itInfraSuppHeading.getText();
			return infraHead;
		}catch(Exception e) {
			return (e.getMessage());
		}		
	}
	
	//Returns the Heading "Human Resources" 
	public String getHumanResourceHeading() {
		try{
			String humanRsrcHead = humanResourceHeading.getText();
			return humanRsrcHead;
		}catch(Exception e) {
			return (e.getMessage());
		}		
	}
	
	//Returns the Heading "IT Application Support"
	public String getItAppSuppHeading() {
		try{
			String itAppHead = itAppSuppHeading.getText();
			return itAppHead;
		}catch(Exception e) {
			return (e.getMessage());
		}		
	}
	
	//Returns the Heading "Policy and Process Support" 
	public String getPolicyProcessSuppHeading() {
		try{
			String policyHead = policyProcessSuppHeading.getText();
			return policyHead;
		}catch(Exception e) {
			return (e.getMessage());
		}	
	}
	
	//Returns all the Items present in "IT Infra Support" as a List
	public List<WebElement> getItInfraSuppItems() {
			return itInfraSuppItems;
	}
	
	//Returns all the Items present in "Human Resources" as a List
	public List<WebElement> getHumanResourcesItems() {
		return humanResourceItems;
	}
	
	//Returns all the Items present in "IT Application Support" as a List
	public List<WebElement> getItAppSuppItems() {
		return itAppSuppItems;
	}
	
	//Returns all the Items present in "Policy and Process Support" as a List
	public List<WebElement> getPolicyProcessSuppItems() {
		return policyProcessSuppItems;
	}
	
	
	
	
}
