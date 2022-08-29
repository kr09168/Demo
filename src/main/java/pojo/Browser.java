package pojo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static WebDriver openBrowser() {
		
		
		
		ChromeOptions ob = new ChromeOptions();
		ob.addArguments("disable-notifications");
		WebDriverManager.chromedriver().setup();//add WebDriverManager » 5.2.3 dependancy.
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Kite_Zerodha\\src\\main\\resources\\chromedriver.exe");// key :-"webdriver.chrome.driver" Value
		// :-"D:\\chromedriver.exe".
		WebDriver driver = new ChromeDriver(ob);// (upcasting) responsible to open the browser.

		driver.get("https://kite.zerodha.com/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		return driver;
	}
}
