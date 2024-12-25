package CommonMethods;

import BaseTest.ExtentFactory;
import BaseTest.ExtentSetup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListeners implements ITestListener {

    // Static variable to hold the ExtentReports instance
    static ExtentReports report;

    // Instance variable to represent the current test in the Extent report
    ExtentTest test;

    // This method is executed before each test case starts
    public void onTestStart(ITestResult result) {
        // Creating a new test entry in the Extent report for the current test case
        test = report.createTest(result.getMethod().getMethodName());

        // Set the current test instance in ExtentFactory for logging within the test
        ExtentFactory.getInstance().setExtent(test);
    }

    // This method is executed when a test case passes
    public void onTestSuccess(ITestResult result) {
        // Log the successful test result in the Extent report
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");

        // Add a screenshot to the Extent report for the passed test case
        ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(ActionUtils.takeScreenshot(), "Test case passed screenshot");

        // Remove the current ExtentTest instance from ExtentFactory after the test completes
        ExtentFactory.getInstance().removeExtentObject();
    }

    // This method is executed when a test case fails
    public void onTestFailure(ITestResult result) {
        // Log the failed test result and the exception details in the Extent report
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

        // Add a screenshot to the Extent report for the failed test case
        ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(ActionUtils.takeScreenshot(), "Test case failure screenshot");

        // Remove the current ExtentTest instance from ExtentFactory after the test completes
        ExtentFactory.getInstance().removeExtentObject();
    }

    // This method is executed when a test case is skipped
    public void onTestSkipped(ITestResult result) {
        // Log the skipped test case status in the Extent report
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");

        // Remove the current ExtentTest instance from ExtentFactory after the test completes
        ExtentFactory.getInstance().removeExtentObject();
    }

    // This method is executed if a test fails but is within the success percentage (not used in the current code)
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No action needed in this method for now
    }

    // This method is executed if a test fails due to timeout (not used in the current code)
    public void onTestFailedWithTimeout(ITestResult result) {
        // No action needed in this method for now
    }

    // This method is executed before any tests are run
    public void onStart(ITestContext context) {
        try {
            // Setup and initialize the ExtentReports instance before any tests start
            report = ExtentSetup.setupExtentReport();
        } catch (Exception e) {
            // Print stack trace in case there is an error during report setup
            e.printStackTrace();
        }
    }

    // This method is executed after all tests have finished
    public void onFinish(ITestContext context) {
        // Flush the ExtentReports instance to save all the test results to the report file
        report.flush();
    }
}
