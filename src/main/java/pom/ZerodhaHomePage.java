package pom;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ZerodhaHomePage {

	@FindBy(xpath = "//input[@icon='search']")
	private WebElement serach;
	@FindBy(xpath = "//button[@class='button-blue']")
	private WebElement buy;
	@FindBy(xpath = "//button[@class='button-orange']")
	private WebElement sell;
	@FindBy(xpath = "//span[@class='icon icon-align-center']")
	private WebElement marketdepth;
	@FindBy(xpath = "//span[@class='icon icon-trending-up']")
	private WebElement chart;
	@FindBy(xpath = "//BUTTON[@class='button-green']")
	private WebElement add;
	@FindBy(xpath = "//li[@class='search-result-item']")
	private List<WebElement> listofstocks;

	// watchlist elements
	@FindBy(xpath = "//span[@class='symbol']")
	private List<WebElement> listofwatchlist;

	@FindBy(xpath = "//span[@class='icon icon-trash']")
	private WebElement delete;
	
	@FindBy(xpath = "//button[@class='button-blue buy']")
	private WebElement wbuy;
	
	@FindBy(xpath = "//button[@class='button-orange sell']")
	private WebElement wsell;
	
	@FindBy(xpath = "//label[text()='Intraday ']")
	private WebElement wintraday;
	
	@FindBy(xpath = "(//input[@type='number'])[1]")
	private WebElement wqty;
	
	@FindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement wprice;
	
	@FindBy(xpath = "//label[text()='Limit']")
	private WebElement wlimit;
	

	@FindBy(xpath = "//button[@class='submit']")
	private WebElement mainbuy;
	
	
	
	

	public ZerodhaHomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public void serachStock(String data, WebDriver driver) {
		WebDriverWait ob = new WebDriverWait(driver, 2000);// explicite wait
		ob.until(ExpectedConditions.visibilityOf(serach));
		serach.sendKeys(data);
		boolean filed = serach.isDisplayed();	
		Assert.assertEquals(filed,true);
		
	}

	public int getSerachResultNumber() {
		int size = listofstocks.size();
		return size;
	}

	public void searchSelectStockFromList(String RequiredStock, WebDriver driver) throws InterruptedException {
		try {
			for (int i = 0; i < listofstocks.size(); i++) {

				WebElement element = listofstocks.get(i);
				String text = element.getText();

				if (text.contains(RequiredStock)) {
					Actions ob = new Actions(driver);
					ob.moveToElement(element);
					ob.perform();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Element is already added in watchlist delete it from whatchlist first.");
		}

	}

	public void clickOnSearchBuy() {
		buy.click();
		boolean button = buy.isDisplayed();	
		Assert.assertEquals(button,true);
		
//		boolean button = buy.isDisplayed();
//		SoftAssert ob = new SoftAssert();
//		ob.assertEquals(button,true);
//		ob.assertAll();
//		
	}

	public void clickOnSearchSell(WebDriver driver) {
		sell.click();	
		boolean button = sell.isDisplayed();	
		Assert.assertEquals(button,true);
		
	}

	public void clickOnSearchMarketDepth() {
		marketdepth.click();
		boolean button = marketdepth.isDisplayed();	
		Assert.assertEquals(button,true);
		
	}

	public void clickOnSearchChart() {
		chart.click();
		boolean button = chart.isDisplayed();	
		Assert.assertEquals(button,true);
		
	}

	public void clickOnSearchAddToWatchlist() {
		add.click();
		boolean button = add.isDisplayed();	
		Assert.assertEquals(button,true);
		
	}

	public int getWatchListStocksCount() {
		
		int size = listofwatchlist.size();
		return size;
	}
	
	
	
	public void selectStockFromWatchList(String RequiredStock, WebDriver driver) throws InterruptedException {
		try {
			for (int i = 0; i < listofwatchlist.size(); i++) {

				WebElement element = listofwatchlist.get(i);
				String text = element.getText();

				if (text.contains(RequiredStock)) {
					Actions ob = new Actions(driver);
					ob.moveToElement(element);
					ob.perform();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Element is not found because not added in watchlist add first.");
		}

	}
	public void clickOnWatchlistDelete() {
		delete.click();
		boolean button = delete.isDisplayed();	
		Assert.assertEquals(button,true);
		
	}
//methods for main buy page
	public void clickOnWatchlistBuy() {
		wbuy.click();
	}
	public void clickOnWatchlistSell() {
		wsell.click();
	}
	public void clickOnIntraday() {
		wintraday.click();
	}
	public void clickOnQty(String qty) throws InterruptedException {
		wqty.clear();
		Thread.sleep(2000);
		wqty.sendKeys(qty);
	}
	public void clickOnPrice(String price) throws InterruptedException {
		wprice.clear();
		Thread.sleep(2000);
		wprice.sendKeys(price);
	}
	public void clickOnLimit() {
		wlimit.click();
		boolean limit = wlimit.isDisplayed();
		Assert.assertTrue(limit);
		
	}
	public void clickOnMainBuyOfBuyPage() {
		boolean limit = mainbuy.isDisplayed();
		Assert.assertTrue(limit);
		mainbuy.click();
	}
}