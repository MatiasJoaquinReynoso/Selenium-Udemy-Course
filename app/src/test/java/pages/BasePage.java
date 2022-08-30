package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;
    // static for build the driver object this will be used once
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\Archivos de Programa\\webdriver\\chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // make a constructor for this class to be used in public
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    // Get an element
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    // Click
    public void clickElement(String locator) {
        Find(locator).click();
    }
    // Complete fields with text
    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);

    }
    // Dropdown by Value
    public void selectFromDropdown(String locator, String valueToSelect) {
        Select dropdown = new Select (Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    // Dropdown by Index
    public void selectFromDropdown(String locator, int valueToSelect) {
        Select dropdown = new Select (Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }
    // Actions

    // Hover-over element
    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }
    // Double Click
    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }
    // Right Click
    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    // iFrame and PopUps
    public void switchToIframe(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String textFromElement(String locator) {
        return Find(locator).getText();
    }

    // Boolean elements
    public boolean elementEnabled(String locator) {
        return Find(locator).isEnabled();
        // Check the button its enabled to be clickable
    }

    public boolean elementIsDisplayed(String locator) {
        return Find(locator).isDisplayed();
        // Check that the element is there
    }

    public boolean elementIsSelected(String locator) {
        return Find(locator).isSelected();
        // Verify that the checkbox is selected or not
    }
}
