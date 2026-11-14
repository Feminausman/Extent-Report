package Base_package;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Swagpage_package.Swagloginpage;

public class SwagBase {
	public static WebDriver driver;
	public Swagloginpage obj;
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeTest
	public void setup()
	{
		reporter=new ExtentSparkReporter("./Reports/myreport1.html");
		reporter.config().setDocumentTitle("Automation report");
		reporter.config().setReportName("functional test");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "abc");
		extent.setSystemInfo("Browser Name", "Chrome");
		
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();	
	}
	
	@BeforeMethod
	public void mthd(Method method)
	{
		obj=new Swagloginpage(driver);
	}
	@AfterMethod
	public void aftmthd(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case failed is "+result.getName());
			test.log(Status.FAIL, "test case failed is "+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass("test passed: "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass("test passed: "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.skip("test skipped: "+result.getName());
		}
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		driver.quit();
	}

}
