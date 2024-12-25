package Pages;

import BaseTest.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

    WebDriver driver = null;
    public HomePageObjects(WebDriver driver){
        PageFactory.initElements(DriverFactory.getInstance().getDriver() , this);
        this.driver = driver;

    }

}
