package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver.Driver;

import java.util.Iterator;
import java.util.Set;

public class Gutils
    {
        public static boolean isElementVisible(String locator){
            Boolean isVisible;
            isVisible = Driver.webDriver.findElement(By.xpath(locator)).isDisplayed();
            return isVisible;
        }

        public static String elementTextis(String locator){

            return Driver.webDriver.findElement(By.xpath(locator)).getText();
        }

       public static String getPageTitle(){

          return Driver.webDriver.getTitle();
       }

        public static void waitForVisibility(String locator) {
            WebDriverWait wait = new WebDriverWait(Driver.webDriver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        }

        public static void selectValueFromDropDown(String value, String locator) {
            waitForVisibility(locator);
            Select dropdown = new Select(Driver.webDriver.findElement(By.xpath(locator)));
            dropdown.selectByValue(value);
        }

        public static void switchToActiveWindow(){
            Set<String> win = Driver.webDriver.getWindowHandles();
            Iterator<String> it = win.iterator();
            String name = "";
            while (it.hasNext())
                name = it.next();
            Driver.webDriver.switchTo().window(name);
        }

        public static void placeOverAndClick(String locator) {
            WebElement webElement = Driver.webDriver.findElement(By.xpath(locator));
            Actions action = new Actions(Driver.webDriver);
            action.moveToElement(webElement).click().perform();
            action.click(webElement).perform();
        }

        public static void waitUntilTextIsPresentOnElement(String locator, String expectedText) {
            WebDriverWait wait = new WebDriverWait(Driver.webDriver, 15);
            String xpath = locator + "[contains(text(),'" + expectedText + "')]";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        }

    }
