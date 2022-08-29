package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.ZerodhaLoginPage;
import utility.Parameterization;
import utility.Reports;
import utility.WebDriverStaticVariable;

@Listeners(utility.Listeners.class)
public class LoginPageTest extends WebDriverStaticVariable {
//	WebDriver driver;
	ExtentReports report; // without declearing global we cant use it in anoyher test.
	ExtentTest test;

	// for extent reports using the before test.
	@BeforeTest
	public void addReports() {
		report = Reports.genrateReport();
	}

	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
		driver = Browser.openBrowser();
		Thread.sleep(2000);
	}

	@Test
	public void zerodhaLoginPage() throws EncryptedDocumentException, IOException, InterruptedException {
		test = report.createTest("zerodhaLoginPage");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String user = Parameterization.getData("Credentials", 0, 1);
		String pass = Parameterization.getData("Credentials", 1, 1);
		String pin = Parameterization.getData("Credentials", 2, 1); // null
		// pointer exception ocurr because of we are fetching numeric value with string
		// method.
		zerodhaLoginPage.enterUserID(user);
	//	Thread.sleep(2000);
		zerodhaLoginPage.enterPass(pass);
	//	Thread.sleep(2000);
		zerodhaLoginPage.clickOnLogin();
	//	Thread.sleep(2000);
		zerodhaLoginPage.enterPin(pin);
	//	Thread.sleep(2000);
		zerodhaLoginPage.clickOnPinButton();
	//	Thread.sleep(5000);
		Assert.assertTrue(false); // we put this for checking response of lisner for faild test.

	}

	@Test(enabled = false)
	public void validatezerodhaForgotlinkonhomepage() {

		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgot(driver);

	}

	@Test(enabled = false)
	public void validatezerodhaSignuplinkonhomepage() {

		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignUp(driver);

	}

	@AfterMethod
	public void postTest(ITestResult result) {

		// putting listernres for achiving the extenet reports.
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		} else {
			test.log(Status.SKIP, result.getName());
		}

	}

	@AfterTest
	public void flushReport() {

		report.flush();
	}

}
