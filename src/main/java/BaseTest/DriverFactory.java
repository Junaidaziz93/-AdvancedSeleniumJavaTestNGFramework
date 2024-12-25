package BaseTest;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

/**
 * DriverFactory class
 *
 * This class implements the Singleton design pattern to ensure that only one instance of DriverFactory exists,
 * and it provides a global point of access to that instance. It also utilizes ThreadLocal to manage
 * WebDriver instances in a thread-safe manner, making it ideal for running tests in parallel without
 * browser session conflicts. The factory pattern is implied, where WebDriver instances are managed,
 * though not fully implemented here.
 */
public class DriverFactory {

    // Private constructor to prevent instantiation from other classes (Singleton pattern)
    private DriverFactory() {
    }

    // Create a single instance of DriverFactory (Singleton)
    private static final DriverFactory instance = new DriverFactory();

    // Method to provide global access to the single instance of DriverFactory
    public static DriverFactory getInstance() {
        return instance; // Return the single instance
    }

    // ThreadLocal variable to manage WebDriver instances per thread
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Method to retrieve the WebDriver instance for the current thread
    public WebDriver getDriver() {
        return driver.get(); // Get the WebDriver for the current thread
    }

    // Method to set a WebDriver instance for the current thread
    public void setDriver(WebDriver driverParam) {
        driver.set(driverParam); // Assign the WebDriver instance to the current thread
    }

    // Method to close the browser and clean up the WebDriver for the current thread
    public SearchContext closeBrowser() {
        driver.get().close(); // Close the browser associated with the current thread
        driver.remove(); // Remove the WebDriver instance from the ThreadLocal to clean up resources
        return null;
    }
}
