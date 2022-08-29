package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ZerodhaLoginPage {

	@FindBy(xpath = "//input[@id='userid']")
	private WebElement userid;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pass;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login;
	@FindBy(xpath = "//a[text()='Forgot user ID or password?']")
	private WebElement forgot;
	@FindBy(xpath = "//a[@class='text-light']") // text is not working reason.
	private WebElement signup;
	@FindBy(xpath = "//input[@id='pin']")
	private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickpin;

	public ZerodhaLoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void enterUserID(String enterid) {
		userid.sendKeys(enterid);
	}

	public void enterPass(String enterpass) {
		pass.sendKeys(enterpass);
	}

	public void clickOnLogin() {
		login.click();
	}

	public void clickOnForgot(WebDriver driver) {
		forgot.click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Forgotpassword / Kite");// hard assert.
		
	}

	public void clickOnSignUp(WebDriver driver) {
		signup.click();
		String title = driver.getTitle();
		SoftAssert obj = new SoftAssert();
		obj.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform");
		obj.assertAll();
	}

	public void enterPin(String enterpin) {

		pin.sendKeys(enterpin);
		
	}

	public void clickOnPinButton() {
		clickpin.click();
	}

}
