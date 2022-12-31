package utilities;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.netty.handler.codec.http.HttpContentEncoder.Result;


public class ExtendReportUtility implements ITestListener{
	
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("ddMMyyyy_hhmmss");
		
		String strDate=formatter.format(date);
		File reportPath=new File(System.getProperty("user.dir")+"//ExtendReport");
		
		if (!reportPath.exists()) {
			reportPath.mkdir();
		}
		
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReport//" +"ExtentReport_" + strDate + ".html");
		reports=new ExtentReports();
		reports.attachReporter(sparkReporter);
		reports.setSystemInfo("PC Name", "Subina");
		reports.setSystemInfo("OS", "Windows 10 Pro");
		sparkReporter.config().setDocumentTitle("Extend Report Sample");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestStart(ITestResult result) {

	}

	
	
   public void onTestSuccess(ITestResult result ) {
	   test=reports.createTest(result.getName());
	   test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed TestCase is : "+result.getName(), ExtentColor.GREEN));
   }  
   
   public void onTestFailure(ITestResult result ) {
	   test=reports.createTest(result.getName());
	   test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed TestCase is : "+result.getName(), ExtentColor.RED));
   }  
   
   public void onTestSkip(ITestResult result ) {
	   test=reports.createTest(result.getName());
	   test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped TestCase is : "+result.getName(), ExtentColor.YELLOW));
   }  
   
   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

   
   public void onStart(ITestContext context) {
	   configureReport();
   }
   
   public void onFinish(ITestContext context) {
	   reports.flush(); //erase previous data on a relevant report & create a new report
   }
}
