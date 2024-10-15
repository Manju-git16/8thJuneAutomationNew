package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxUtility.Utility;

public class TC12345_CoverFox_ValidateErrorMsgs extends Base {
	
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPage;
	CoverFoxMemberDetailsPage memberDetailsPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
//String excellPath=System.getProperty("user.dir")+"\\Datasheets\\MyFile.xlsx";

	
	//String excellPath="C:\\EclipseNew\\AutomationJune24\\Datasheets\\MyFile.xlsx";
	String excellPath=System.getProperty("user.dir")+"\\Datasheets\\MyFile.xlsx";
	String sheetName="Sheet2";
	
	public static Logger logger;
	
	@BeforeMethod
	public void enterDetails() throws IOException, InterruptedException {
		
		launchBrowser();
		logger=Logger.getLogger("8thJUne");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Application");
	System.out.println(System.getProperty("user.dir")+"=========");
		homePage=new CoverFoxHomePage(driver);
		healthPage=new CoverFoxHealthPlanPage(driver);
		memberDetailsPage=new CoverFoxMemberDetailsPage(driver);
		addressDetailsPage=new CoverFoxAddressDetailsPage(driver);
		
		logger.info("clicking On Gender Button");
		homePage.clickOnGenderButton();
		Thread.sleep(2000);
		logger.info("clicking On Next Button");
		healthPage.clickOnNextButton();
		Thread.sleep(2000);
		logger.info("Handling Gender Button");
		memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excellPath, sheetName, 0, 0));
		logger.info("clicking On Next Button");
		memberDetailsPage.clickOnNextButton();
		
		Thread.sleep(2000);
		
		
	}
	
  @Test(priority = -1)
  public void validatePincodeErrMsg() throws EncryptedDocumentException, IOException, InterruptedException {
	  logger.warn("Enter Valid Mobile Number");
	  addressDetailsPage.enterMobNum(Utility.readDataFromExcel(excellPath, sheetName, 0, 2));
	  logger.info("Entering Mobile Number");
	  addressDetailsPage.clickOnContinueButton();
	  logger.info("clicking On Continue Button");
	  logger.error("please Check Details Again");
	  Thread.sleep(2000);
		
	  String actualText=addressDetailsPage.getPinErrMsg();
	  String expectedText=Utility.readDataFromExcel(excellPath, sheetName, 0, 3);
	  
	  Assert.assertEquals(actualText, expectedText,"Both are not Equals,TC Failed");
  }
  @Test
  public void validateMobileNumErrMsg() throws EncryptedDocumentException, IOException, InterruptedException {
	  logger.warn("Enter Valid pinCode");
	
	  addressDetailsPage.enterPinCode(Utility.readDataFromExcel(excellPath, sheetName, 0, 1));
	  logger.info("Entering Pincode");
	  addressDetailsPage.clickOnContinueButton();
	  logger.info("clicking On Continue Button");

	  Thread.sleep(2000);
		
	  String actualText=addressDetailsPage.getMobNumErrMsg();
	  String expectedText=Utility.readDataFromExcel(excellPath, sheetName, 0, 4);
	  
	  Assert.assertEquals(actualText, expectedText,"Both are not Equals,TC Failed");
  }
  @AfterMethod
  public void closeApplication() {
	 closeBrowser();
  }
}
