package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import pojo.Browser;

public class Screenshot {

	public static TakesScreenshot ss(WebDriver driver, String name) throws IOException {

		driver = Browser.openBrowser();

		String date = Screenshot.dt();

		TakesScreenshot b = ((TakesScreenshot) driver);

		File a = b.getScreenshotAs(OutputType.FILE);

		File destination = new File("C:\\Users\\Admin\\eclipse-workspace\\Kite_Zerodha\\ScreenShot\\"+name+""+date+".jpg");

		FileHandler.copy(a, destination);

		return b;

	}

	public static String dt() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-yyyy HH-mm");
		Date a = new Date();
		System.out.println(formatter.format(a));
		String b = formatter.format(a);
		return b;
	}

}
