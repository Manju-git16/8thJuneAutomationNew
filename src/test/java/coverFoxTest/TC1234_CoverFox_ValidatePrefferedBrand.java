package coverFoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailsPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFoxResultPage;
import coverFoxUtility.Utility;

public class TC1234_CoverFox_ValidatePrefferedBrand extends Base{
 
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverFoxMemberDetailsPage memberDetailsPage;
	CoverFoxAddressDetailsPage addressDetailsPage;
	CoverFoxResultPage resultPage;
	
	String excelPath="C:\\EclipseNew\\AutomationJune24\\Datasheets\\MyFile.xlsx";
	String sheet="Sheet2";
	@BeforeClass
	public void openApplication() throws IOException {
		launchBrowser();
	}
	
	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage=new CoverFoxHomePage(driver);
		healthPlanPage=new CoverFoxHealthPlanPage(driver);
		memberDetailsPage=new CoverFoxMemberDetailsPage(driver);
		addressDetailsPage=new CoverFoxAddressDetailsPage(driver);
		resultPage=new CoverFoxResultPage(driver);
		homePage.clickOnGenderButton();
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);
		memberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excelPath,sheet, 0, 0));
		memberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);
		addressDetailsPage.enterMobNum(Utility.readDataFromExcel(excelPath, sheet, 0, 2));
		addressDetailsPage.enterPinCode(Utility.readDataFromExcel(excelPath, sheet, 0, 1));
		addressDetailsPage.clickOnContinueButton();
		Thread.sleep(3000);
		resultPage.clickOnPrefferedBrandButton();
		resultPage.clickOnStrHealthInsurance();
		resultPage.clickOnApplyButton();
		
	}
	@Test
  public void f() {
  }
}
