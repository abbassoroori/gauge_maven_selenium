package utils;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import utils.driver.Driver;

public class gutils {

    @Step("Verify that page title is <page>")
    public void checkPageTitle(String page) {
        String actualTitle;
        actualTitle = Driver.webDriver.getTitle();
        Assert.assertEquals(page, actualTitle);
    }



}
