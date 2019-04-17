import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.Driver;
import utils.Gutils;
import com.github.javafaker.Faker;



import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class CustomerSignup {

    Faker faker = new Faker(new Locale("en", "US"));

    /*WebDriver webDriver = Driver.webDriver;

    WebElement userfield =  webDriver.findElement(By.xpath(System.getenv("loginpage_user")));*/



    @Step("Sign in as <email> with password <password>")

    public void signInAs(String email, String password) {
        WebDriver webDriver = Driver.webDriver;
        WebElement userfield =  webDriver.findElement(By.xpath(System.getenv("loginpage_user")));

        String locator;
        userfield.sendKeys(email);


        locator = System.getenv("loginpage_password");

        webDriver.findElement(By.xpath(locator)).sendKeys(password);

        locator = System. getenv("loginpage_loginbutton");

        webDriver.findElement(By.xpath(locator)).click();



    }

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

    @Step("Accept Login data")
    public void acceptLogindata(){
        String locator = System.getenv("loginpage_accept_button");
        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.xpath(locator)).click();


    }

    @Step("Verify that note module exists")
    public void noteModuleExists(){
        String locator = System.getenv("mynotes_container");
        Gutils.isElementVisible(locator);

    }
}