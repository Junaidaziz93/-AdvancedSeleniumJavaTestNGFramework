package Pages;


import BaseTest.BaseTest;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPageObjects extends BaseTest  {
WebDriver driver;
public LoginPageObjects (WebDriver driver){
    PageFactory.initElements(driver , this);
    this.driver =driver;
}

    @FindBy(name = "username")
    WebElement username;

    // Web element for the Admin title, located by its text
    @FindBy(name = "password")
    WebElement passoword;

    // Web element for the PIM tab, located by its text
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginbtn;


    //login to App
    public void loginIntoApp(String userName, String passWord) throws InterruptedException, IOException, ParseException {


        sendKeys_custom(username,"Usernamefield",userName);
        passoword.sendKeys(passWord);
        Thread.sleep(5000);
    }
}
