package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultPage {

	@FindBy(xpath = "//div[contains(text(),'matching Health')]")
	private WebElement resultText;
	@FindBy(className = "plan-card-container")
	private List<WebElement> planList;
	@FindBy(xpath = "//div[text()='All Insurers']")
	private WebElement prefferedBrands;
	@FindBy(xpath="//span[text()='Star Health Insurance']")
    private WebElement star;
	@FindBy(className="apply-btn")
	private WebElement apply;
	public CoverFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getCountFromText() {
		Reporter.log("Getting count from text displayed..", true);
		String resultInString = resultText.getText().substring(0, 2);
		int countFromText = Integer.parseInt(resultInString);
		return countFromText;

	}

	public int getCountFromBanner() {
		Reporter.log("Getting count from Banner..", true);
		int countFromBanner = planList.size();
		return countFromBanner;

	}

	public void clickOnPrefferedBrandButton() {
		Reporter.log("Clicking On PrefferedButton", true);
		prefferedBrands.click();
	}
	
	public void clickOnStrHealthInsurance() {
		Reporter.log("Clicking on Star Health Insurance", true);
        star.click();
	}
	public void clickOnApplyButton() {
		Reporter.log("Clicking on Apply Button", true);
        apply.click();
	}
//	public void validateResult() {
//		 String resultInString=resultText.getText().substring(0, 2);
//		 int resultNumber=Integer.parseInt(resultInString);
//		 int planListNumber=planList.size();
//		 System.out.println("ResultNumberIS :"+resultNumber);
//		 System.out.println("PlanList Number is: "+planListNumber);
//		 
//		 if(resultNumber==planListNumber) {
//			 System.out.println("Number is Matching :TC is Passed");
//		 }else {
//			 System.out.println("Number is not Matching TC is Failed");
//		 }
//	}
}
