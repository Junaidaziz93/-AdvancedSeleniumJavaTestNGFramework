package CommonMethods;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetryAnalyzer implements IRetryAnalyzer {
    // Variable to keep track of the retry attempts
    int counter = 1;

    // Maximum number of retry attempts allowed for a failed test
    int reTryMax = 4;

    /**
     * This method is called by TestNG when a test fails. It checks if the test can be retried.
     * The test will be retried up to the specified maximum number of retries (`reTryMax`).
     *
     * @param iTestResult The result of the test execution.
     * @return `true` if the test should be retried, `false` otherwise.
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        // If the current retry attempt is less than the maximum retry limit
        if (counter < reTryMax) {
            counter++;  // Increment the counter for each retry attempt
            return true; // Indicate that the test should be retried
        }
        // If the number of retries exceeds or equals the maximum, do not retry
        return false;
    }
}
