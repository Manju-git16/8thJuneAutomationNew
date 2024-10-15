package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	
	//Variable decleration
      @FindBy(xpath = "//div[text()='Male']") private WebElement gender;
	@FindBy(xpath="//div[@class='logo coverfox']") private WebElement logo;
	//constructor-->Variable initialization
	
      public CoverFoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
      
	//Methods
      
      public void clickOnGenderButton() {
    	  Reporter.log("Clicking on Gender Button ",true);
    	  gender.click();
      }
      
      public boolean logoIsDisplayed() {
    	  Reporter.log("Logo Is Displayed", true);
    	  boolean value = logo.isDisplayed();
    	  return value;
      }
}
