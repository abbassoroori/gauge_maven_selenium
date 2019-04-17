import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.driver.Driver;
import utils.Gutils;
import com.github.javafaker.Faker;


import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class CustomerSignup {

    Faker faker = new Faker(new Locale("en", "US"));

    @Step("Sign up as <customer> with with fake email and <password> password")
    public void registerCustomerWith(String customer, String password) {
        String locator = System.getenv("homepage_login_link");
        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.xpath(locator)).click();

        locator = System.getenv("homepage_modal_register_email");
        webDriver.findElement(By.xpath(locator)).sendKeys(faker.internet().emailAddress());

        locator = System.getenv("homepage_modal_register_password");
        webDriver.findElement(By.xpath(locator)).sendKeys(password);
        webDriver.manage().timeouts().implicitlyWait(3500, TimeUnit.MILLISECONDS); //horrible
        webDriver.findElement(By.xpath(locator)).sendKeys(Keys.RETURN);
        /*locator = System.getenv("homepage_submit_registration_button");
        webDriver.findElement(By.xpath(locator)).click(); --> not necessary at the moment */


    }

    @Step("Verify that page title is <page>")
    public void checkPageTitle(String page) {
        String actualTitle;
        actualTitle = Gutils.getPageTitle();
        Assert.assertEquals(page, actualTitle);

    }
}