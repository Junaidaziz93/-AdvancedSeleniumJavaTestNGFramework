package BaseTest;

import CommonMethods.ActionUtils;
import CommonMethods.PropertiesOperations;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest extends ActionUtils {
    // BrowserFactory instance to launch browsers
    BrowserFactory browserFactory = new BrowserFactory();

    // WebDriver instance to interact with the browser
    public static WebDriver driver;

    // BeforeMethod annotation ensures this method runs before each test
    @BeforeMethod
    public void launchApplication() throws InterruptedException {
        // Get browser and URL properties from config file
        String browser = PropertiesOperations.getPropertyValueByKey("browser");
        String url = PropertiesOperations.getPropertyValueByKey("url");

        // Launch the browser based on the properties
        WebDriver driverInstance = browserFactory.LaunchBrowser(browser);

        // Set the driver instance to be used globally
        DriverFactory.getInstance().setDriver(driverInstance);
        driver = DriverFactory.getInstance().getDriver();

        // Maximize the browser window and set an implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navigate to the URL
        driver.navigate().to(url);

        // Wait for 3 seconds to ensure the page loads properly
        Thread.sleep(3000);
    }

    // AfterMethod annotation ensures this method runs after each test
    @AfterMethod
    public void tearDown(){
        // Close the browser after test execution
        DriverFactory.getInstance().closeBrowser();
    }
}
