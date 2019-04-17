import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.driver.Driver;

import java.util.concurrent.TimeUnit;


public class CustomerSignup {

    @Step("Sign up as <customer> with email <customer@example.com> and <password>")
    public void registerCustomerWith(String customer, String email, String password) {
        String locator = System.getenv("homepage_login_link");
        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.xpath(locator)).click();

        locator = System.getenv("homepage_modal_register_email");
        webDriver.findElement(By.xpath(locator)).sendKeys(email);

        locator = System.getenv("homepage_modal_register_password");
        webDriver.findElement(By.xpath(locator)).sendKeys(password + Keys.RETURN);
        webDriver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
        locator = System.getenv("homepage_submit_registration_button");
        webDriver.findElement(By.xpath(locator)).click();


    }

    @Step("Check if the user is logged in")
    public void checkMyAccount() {
        String locator = System.getenv("homepage_registered_myAccount");
        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.xpath(locator)).isDisplayed();

    }

    @Step("Verify that page title is <page>")
    public void checkPageTitle(String page) {
        String actualTitle;
        actualTitle = Driver.webDriver.getTitle();
        Assert.assertEquals(page, actualTitle);

    }
}