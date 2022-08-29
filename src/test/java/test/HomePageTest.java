package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Parameterization;

public class HomePageTest {
	WebDriver driver;

	@BeforeMethod
	public void browser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver = Browser.openBrowser(); // if we do not pass driver here then it will throw nullpointer Exception.
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String user = Parameterization.getData("Credentials", 0, 1);
		String pass = Parameterization.getData("Credentials", 1, 1);
		String pin = Parameterization.getData("Credentials", 2, 1); // null
		// pointer exception ocurr because of we are fetching numeric value with string
		// method.
		zerodhaLoginPage.enterUserID(user);
		//Thread.sleep(2000);
		zerodhaLoginPage.enterPass(pass);
		//Thread.sleep(2000);
		zerodhaLoginPage.clickOnLogin();
		//Thread.sleep(2000);
		zerodhaLoginPage.enterPin(pin);
	//	Thread.sleep(2000);
		zerodhaLoginPage.clickOnPinButton();
	//	Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void searchStockVerifyStockListAutopopulated()
			throws InterruptedException, EncryptedDocumentException, IOException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.serachStock("TATA", driver);
	//	Thread.sleep(5000); //
		// List<WebElement> list =
		// driver.findElements(By.xpath("//li[@class='search-result-item']")); // int
		// size = list.size(); // System.out.println(size);
		int ref = zerodhaHomePage.getSerachResultNumber();
	//	System.out.println(ref);
		Assert.assertNotNull(ref);//HARD ASSERT
//		Assert.assertTrue(ref>0);//HARD THIS WILL ALSO WORK
//		Assert.assertFalse(ref>0);// Note in true and false assert we apply the condition.
		System.out.println(ref);
	
	}

	@Test(enabled = false)
	public void searchStockClickOnSearchBuy() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.serachStock("TATA", driver);
	//	Thread.sleep(9000);
		zerodhaHomePage.searchSelectStockFromList("TATASTLLP", driver); // we cant
		// add driver first throw error. Thread.sleep(9000);
		zerodhaHomePage.clickOnSearchBuy();
		//Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Dashboard / Kite");
	
	
	}

	@Test(enabled = false)
	public void searchStockClickOnSearchSell() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.serachStock("TATA", driver);
		//Thread.sleep(9000);
		zerodhaHomePage.searchSelectStockFromList("TATAINVEST", driver);
		//Thread.sleep(9000);
		zerodhaHomePage.clickOnSearchSell(driver);
		SoftAssert soft = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		soft.assertEquals(title,"Dashboard / Kite");
	
	}

	@Test(enabled = false)
	public void searchStockClickOnSearchMarketDepth() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.serachStock("TATA", driver);
	//	Thread.sleep(9000);
		zerodhaHomePage.searchSelectStockFromList("TATAINVEST", driver);
	//	Thread.sleep(9000);
		zerodhaHomePage.clickOnSearchMarketDepth();
	//	Thread.sleep(5000);
		SoftAssert soft = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		soft.assertEquals(title,"Dashboard / Kite");
		
	}

	@Test(enabled = false)
	public void searchStockClickOnSearchChart() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.serachStock("TATA", driver);
	//	Thread.sleep(9000);
		zerodhaHomePage.searchSelectStockFromList("TATAINVEST", driver);
	//	Thread.sleep(9000);
		zerodhaHomePage.clickOnSearchChart();
	//	Thread.sleep(5000);
		SoftAssert soft = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		soft.assertEquals(title,"Dashboard / Kite");
	
	}

	@Test(enabled = false)

	public void searchStockClickOnSearchAddToWatchlist() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.serachStock("TATA", driver);
	//	Thread.sleep(9000);
		zerodhaHomePage.searchSelectStockFromList("TATAPOWER", driver);
	//	Thread.sleep(9000);
		zerodhaHomePage.clickOnSearchAddToWatchlist();
	//	Thread.sleep(5000);
		SoftAssert soft = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		soft.assertEquals(title,"Dashboard / Kite");
	
	}

	@Test(enabled = false)

	public void validateWatchlistStockStoringOrNot() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		int count = zerodhaHomePage.getWatchListStocksCount();
		System.out.println(count);
		SoftAssert soft = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		soft.assertEquals(title,"Dashboard / Kite");
	
	}

	@Test(enabled = false)

	public void deleteStockFromWatchlist() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.selectStockFromWatchList("TATAPOWER", driver);
	//	Thread.sleep(5000);
		zerodhaHomePage.clickOnWatchlistDelete();
	//	Thread.sleep(5000);
		SoftAssert soft = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		soft.assertEquals(title,"Dashboard / Kite");
	}
	
	@Test
	
	public void buyShareFromWatchlistWithIntradayQtyPriceLimit() throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.selectStockFromWatchList("TATAPOWER", driver);
		zerodhaHomePage.clickOnWatchlistBuy();
		zerodhaHomePage.clickOnIntraday();
		zerodhaHomePage.clickOnLimit();
		zerodhaHomePage.clickOnQty("20");
		zerodhaHomePage.clickOnPrice("30");
		zerodhaHomePage.clickOnMainBuyOfBuyPage();
	
	}
	
	@AfterMethod
	
	public void Close() {
	
		driver.close();
	
	}

}
