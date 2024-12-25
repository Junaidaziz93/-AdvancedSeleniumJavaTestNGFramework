package Testcase;

import BaseTest.BaseTest;
import CommonMethods.DataUtil;
import Pages.LoginPageObjects;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class LoginPageTest extends BaseTest {

    LoginPageObjects loginPage;

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void LoginIntoApplication(HashMap<String, String> hashMap) throws IOException, ParseException, InterruptedException, ParseException {
        // Extract email and password from the HashMap
        String email = hashMap.get("Message"); // Assuming your JSON uses "username" as key
        String password = hashMap.get("Message"); // Assuming your JSON uses "password" as key

        // Call the login method on the login page
        loginPage = new LoginPageObjects(driver);
        loginPage.loginIntoApp(email, password);
    }

}
