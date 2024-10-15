package coverFoxPOM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import coverFoxUtility.Utility;

public class CoverFoxMemberDetailsPage {
	
	//variable
	@FindBy(id="Age-You") private WebElement ageDropDown;
	@FindBy(className ="next-btn") private WebElement nextButton;
	String excelPath="C:\\EclipseNew\\AutomationJune24\\Datasheets\\MyFile.xlsx";
	String sheet="Sheet2";
	//constructor
	
	public CoverFoxMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void handleAgeDropDown(String age) throws EncryptedDocumentException, IOException {
		Reporter.log("Handling Age DropDown..", true);
		Select s=new Select(ageDropDown);
		//s.selectByValue("22y");
		s.selectByValue(age+"y");
	}
	public void clickOnNextButton() {
		 Reporter.log("Clicking on Next Button MemberDetails_Page ",true);
		nextButton.click();
	}

}
