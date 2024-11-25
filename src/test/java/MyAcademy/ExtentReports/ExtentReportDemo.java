package MyAcademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extent=new ExtentReports();
	
	@BeforeTest
	public void config() {
		// ExtentReports, ExtentSparkReporter
		// user.dir este directorul fisierului, si creeaza un fisier reports care are fisierul index html
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation reports");
		reporter.config().setDocumentTitle("Test Results");
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Madalina");
	}

	@Test
	public void initialDemo() {
		ExtentTest test= extent.createTest("Initial demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Result do not match");
		extent.flush();
	}
}
