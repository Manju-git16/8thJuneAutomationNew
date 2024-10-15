package coverFoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxHomePage;

public class TC_123_CoverFOX_ValidateLOgo extends Base {

	CoverFoxHomePage homePage;
	@BeforeClass
	public void openApplication() throws IOException {
		launchBrowser();
	}
	
	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage=new CoverFoxHomePage(driver);
		
}
	
	
	
	@Test
  public void f() {
		
		boolean logoValue = homePage.logoIsDisplayed();
		Assert.assertTrue(logoValue);
		Reporter.log("Tc is Passed", true);
  }
}
