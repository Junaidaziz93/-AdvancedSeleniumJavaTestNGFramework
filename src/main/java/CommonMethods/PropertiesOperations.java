package CommonMethods;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesOperations {
    // Static Properties object to hold key-value pairs from the properties file
    static Properties prop = new Properties();

    /**
     * This method is used to fetch the value associated with a given key from the properties file.
     * It reads the properties file from the given path and retrieves the value corresponding to the key.
     *
     * @param key The key whose value needs to be fetched from the properties file.
     * @return The value corresponding to the given key from the properties file.
     */
    public static String getPropertyValueByKey(String key) {
        // Define the file path of the properties file
        String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        FileInputStream fis;

        try {
            // Load the properties file from the specified path
            fis = new FileInputStream(propFilePath);
            prop.load(fis);  // Load the properties into the 'prop' object
        } catch (Exception e) {
            // Print the stack trace if there is an issue with loading the properties file
            e.printStackTrace();
        }

        // Retrieve the value associated with the provided key from the properties file
        String value = prop.get(key).toString();

        // Check if the retrieved value is empty or null
        if (StringUtils.isEmpty(value)) {
            try {
                // Throw an exception if the key has no associated value in the properties file
                throw new Exception("Value is not specified for key: " + key + " in properties file.");
            } catch (Exception e) {
                // Catch the exception but do nothing (you could log it or handle it differently if needed)
            }
        }

        // Return the value retrieved from the properties file
        return value;
    }
}
