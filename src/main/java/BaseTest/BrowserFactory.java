package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    // WebDriver instance to manage the browser
    WebDriver driver = null;

    // Method to launch a browser based on the provided browser name
    public WebDriver LaunchBrowser(String browser){

        // If the browser is Chrome, set up and launch ChromeDriver
        if(browser.equalsIgnoreCase("chrome")){
            // Set up ChromeDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            // Configure Chrome options (incognito mode in this case)
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");

            // Initialize ChromeDriver with the options
            driver = new ChromeDriver(chromeOptions);

        }
        // If the browser is Firefox, set up and launch FirefoxDriver
        else if (browser.equalsIgnoreCase("firefox")) {
            // Set up FirefoxDriver using WebDriverManager
            WebDriverManager.firefoxdriver().setup();

            // Configure Firefox options (private browsing mode in this case)
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("-private");

            // Initialize FirefoxDriver with the options
            driver = new FirefoxDriver(firefoxOptions);
        }
        // Default to Edge browser if neither Chrome nor Firefox is specified
        else {
            // Set up EdgeDriver using WebDriverManager
            WebDriverManager.edgedriver().setup();

            // Configure Edge options (private browsing mode)
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("-private");

            // Initialize EdgeDriver with the options
            driver = new EdgeDriver(edgeOptions);
        }

        // Return the driver instance for the selected browser
        return driver;
    }
}
