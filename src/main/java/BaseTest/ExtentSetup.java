package BaseTest;

import CommonMethods.PropertiesOperations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentSetup {

    // Static instance of ExtentReports to be used across the class
    static ExtentReports extent;

    // Method to set up and configure the Extent report
    public static ExtentReports setupExtentReport() {

        // Format the current date and time to include in the report filename
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        // Define the path where the report will be saved, including the formatted date for uniqueness
        String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + actualDate + ".html";

        // Initialize the ExtentSparkReporter to create the HTML report at the specified path
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

        // Create an instance of ExtentReports to manage the reporting functionality
        ExtentReports extent = new ExtentReports();

        // Attach the SparkReporter to the ExtentReports instance
        extent.attachReporter(sparkReport);

        // Set the theme for the report (Standard theme in this case)
        sparkReport.config().setTheme(Theme.STANDARD);

        // Set the title of the generated report document
        sparkReport.config().setDocumentTitle("Execution Report");

        // Set the name of the report
        sparkReport.config().setReportName("Execution Report");

        // Add system information to the report, like the environment, browser, OS, and user details
        extent.setSystemInfo("Executed on Environment: ", PropertiesOperations.getPropertyValueByKey("url"));
        extent.setSystemInfo("Executed on Browser: ", PropertiesOperations.getPropertyValueByKey("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));

        // Return the configured ExtentReports instance
        return extent;
    }
}
