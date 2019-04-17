import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.Driver;

import java.security.Key;


public class CustomerSignup {

    @Step("Sign up as <customer> with email <customer@example.com> and <password>")
    public void registerCustomerWith(String customer, String email, String password) {
        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.xpath("(//span[contains(.,'Login')])[1]")).click();

        webDriver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        webDriver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(password + Keys.RETURN);


    }

    @Step("Check if the user is logged in")
    public void checkMyAccount(){

        WebDriver webDriver = Driver.webDriver;
        webDriver.findElement(By.xpath("(//span[contains(.,'My account')])[1]")).isDisplayed();

    }


}