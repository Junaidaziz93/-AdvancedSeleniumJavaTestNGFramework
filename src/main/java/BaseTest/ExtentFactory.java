package BaseTest;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    // Private constructor to prevent instantiation from other classes (Singleton pattern)
    private ExtentFactory() {
    }

    // Single instance of ExtentFactory, ensuring only one instance is created (Singleton pattern)
    private static final ExtentFactory extentFactory = new ExtentFactory();

    // Method to provide global access to the single instance of ExtentFactory
    public static ExtentFactory getInstance() {
        return extentFactory; // Return the single instance of ExtentFactory
    }

    // ThreadLocal to maintain individual ExtentTest instances for each thread (useful in parallel test execution)
    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    // Getter method to retrieve the current ExtentTest instance associated with the current thread
    public ExtentTest getExtent() {
        return extent.get();
    }

    // Setter method to assign a new ExtentTest instance to the current thread
    public void setExtent(ExtentTest extentTestObject) {
        extent.set(extentTestObject);
    }

    // Method to remove the ExtentTest instance from the current thread, useful for cleanup
    public void removeExtentObject() {
        extent.remove();
    }
}
