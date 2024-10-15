package coverFoxPOM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import coverFoxUtility.Utility;

public class CoverFoxAddressDetailsPage {

	@FindBy(className = "mp-input-text")
	private WebElement pincodeField;
	@FindBy(id = "want-expert")
	private WebElement mobNumField;
	@FindBy(className = "next-btn")
	private WebElement continueButton;
	@FindBy(xpath="//div[text()=' Please enter a valid pincode ']")
	private WebElement pincodeErrMsg;
	@FindBy(xpath="//div[text()=' Please enter a valid mobile no. ']")
	private WebElement mobnumErrMsg;
	String excelPath="C:\\EclipseNew\\AutomationJune24\\Datasheets\\MyFile.xlsx";
	String sheet="Sheet2";
	// constructor

	public CoverFoxAddressDetailsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
	
	public void enterPinCode(String pincode) throws EncryptedDocumentException, IOException {
		Reporter.log("Entering PinCode", true);
       // pincodeField.sendKeys("411045");
		pincodeField.sendKeys(pincode);
	}

	public void enterMobNum(String mobNo) throws EncryptedDocumentException, IOException {
		Reporter.log("Entering MobileNumber", true);
		//mobNumField.sendKeys("8888888888");
		mobNumField.sendKeys(mobNo);
	}

	public void clickOnContinueButton() {
		 Reporter.log("Clicking on Continue Button  ",true);

		continueButton.click();
	}
	
	public String getPinErrMsg() {
    String actualText=pincodeErrMsg.getText();
		return actualText;
	}

	public String getMobNumErrMsg() {
	    String actualText=mobnumErrMsg.getText();
			return actualText;
		}
}
