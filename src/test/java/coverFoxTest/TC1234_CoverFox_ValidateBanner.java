package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultPage;
import coverFoxUtility.Utility;

public class TC1234_CoverFox_ValidateBanner extends Base{
       
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxMemberDetailsPage memberDetailsPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxResultPage resultPage;
	
	
	//open Browser//open an application
	//gender,click on next,age,mobilenumber,pincode
	
	String excelPath=System.getProperty("user.dir")+"\\Datasheets\\MyFile.xlsx";
	
	String sheet="Sheet2";
	public static Logger logger;
	@BeforeClass
	public void openApplication() throws IOException {
		launchBrowser();
		logger=Logger.getLogger("8thJuneCoverFox");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Browser");
	}
	
	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage=new CoverFoxHomePage(driver);
		healthPlanPage=new CoverFoxHealthPlanPage(driver);
		memberDetailsPage=new CoverFoxMemberDetailsPage(driver);
		addressDetailsPage=new CoverFoxAddressDetailsPage(driver);
		resultPage=new CoverFoxResultPage(driver);
		homePage.clickOnGenderButton();
		logger.info("Clicking on Gender Button");
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		logger.info("Clicking on Next Button");
		Thread.sleep(1000);
		Reporter.log("add xcel file path by Archana", true);
		memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excelPath,sheet, 0, 0));
		logger.info("Handling Age DropDown");
		memberDetailsPage.clickOnNextButton();
		logger.info("Clicking on Next Button");
		Thread.sleep(1000);
		addressDetailsPage.enterMobNum(Utility.readDataFromExcel(excelPath, sheet, 0, 2));
		logger.info("Entering Mobile Number");
		addressDetailsPage.enterPinCode(Utility.readDataFromExcel(excelPath, sheet, 0, 1));
		logger.info("Entering pincode");
		addressDetailsPage.clickOnContinueButton();
		logger.info("Clicking on continue Button");
		Thread.sleep(3000);
		
	}
	@Test
  public void validatePolicyCount() {
		int countFromText=resultPage.getCountFromText() ;
		int countFromBanner=resultPage.getCountFromBanner();
		logger.info("Validating Results");
	  Assert.assertEquals(countFromText, countFromBanner,"both are not equals,TC Failed");
	 // Assert.fail();
  }
	@AfterMethod
	public void closeApplication() {
		logger.info("Closing Browser");
	closeBrowser();	
	}
	//close Browser/application
}
