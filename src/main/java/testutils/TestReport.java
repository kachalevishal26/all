package testutils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.TestBase;

public class TestReport extends TestBase {
	static ExtentReports extent;

	public static ExtentReports getReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(".//reports//ExtentReport.html"));
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Luma Test Automation");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Kachale Vishal", "Test Engineer");

		return extent;
	}
}
