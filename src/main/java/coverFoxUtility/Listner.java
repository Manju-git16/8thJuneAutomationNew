package coverFoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBase.Base;

public class Listner extends Base implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		try {
			Utility.takesScreenshot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("ScreenShot Taken", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utility.takesScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("ScreenShot Taken for Failed TC", true);
	}

}
