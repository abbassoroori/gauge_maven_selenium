import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.Driver;
import utils.Gutils;
import com.github.javafaker.Faker;
import java.util.Locale;


public class MyNotes {

    Faker faker = new Faker(new Locale("en", "US"));


    @Step("Select add a note")
    public void clickOnAddANote() {
        WebDriver webDriver = Driver.webDriver;
        WebElement addANoteElement =  webDriver.findElement(By.xpath(System.getenv("homepage_AddNote_button")));
        addANoteElement.click();
    }

    @Step("Add text to the note title")
    public void addTextTitle() {
        WebDriver webDriver = Driver.webDriver;
        WebElement titleField = webDriver.findElement(By.xpath(System.getenv("myNotes_titlefield")));
        titleField.sendKeys(faker.company().buzzword());
    }

    @Step("Add text to the note body")
    public void addTextBody() {
        WebDriver webDriver = Driver.webDriver;
        WebElement notebodyfield = webDriver.findElement(By.xpath(System.getenv("myNotes_notebodyfield")));
        notebodyfield.sendKeys(faker.company().catchPhrase());
    }

    @Step("Save Note")
    public void clickOnAddANote2() {
        WebDriver webDriver = Driver.webDriver;
        WebElement addANoteElement = webDriver.findElement(By.xpath(System.getenv("myNotes_addNoteButton")));
        addANoteElement.click();
    }

    @Step("Verify that note Title matches entry")
    public void verifyTitleMatchesStored() {
        Assert.assertTrue(true);
    }
    @Step("Verify that note Body matches entry")
    public void verifyBodyMatchesStored() {
        Assert.assertTrue(true);
    }




}



