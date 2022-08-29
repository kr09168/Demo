package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports genrateReport() {
	ExtentSparkReporter ob = new ExtentSparkReporter("ProjectReport.html");
	ExtentReports report = new ExtentReports();
	report.attachReporter(ob);
	report.setSystemInfo("suite", "Regression");
	report.setSystemInfo("Testedby","Mr.kartik");
	return report;
	}
	
	// can we say we use maven for our project.
}
