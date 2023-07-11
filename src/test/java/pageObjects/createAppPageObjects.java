package pageObjects;

import lombok.experimental.Helper;
import utilities.hooks;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class createAppPageObjects {

    WebDriver driver;

    By loginPage = By.xpath("//p[contains(.,'One system, limitless use cases.')]");
    By username = By.cssSelector("input[placeholder='Username']");
    By password = By.cssSelector("input[id='password']");
    By signInButton = By.cssSelector("button[id='kt_login_signin_submit']");
    By homeMenu = By.xpath("//span[contains(.,'Home')]");
    By appEditorMenu = By.xpath("//span[contains(.,'App Editor')]");
    By appEditorPage = By.xpath("//h2[contains(.,'App Editor')]");
    By createNewAppButton = By.xpath("//button[contains(.,'Create new app ')]");
    By createAppForm = By.xpath("//h5[contains(.,'Create App')]");
    By nameField = By.cssSelector("input[name='name']");
    By descriptionField = By.cssSelector("textarea[name='description']");
    By groupField = By.cssSelector("div[class='fs-r-select__value-container css-1hwfws3'][0]"); // gatau bener apa engga nulis indexnya
    By machineLearningServiceField = By.cssSelector("div[class='fs-r-select__value-container css-1hwfws3'][0]");
    By appIcon = By.cssSelector("button[class='round-left-0 dropdown-toggle btn btn-secondary']");
    By quickLaunch = By.cssSelector("button[name='addToQuickLaunch']");
    By createButton = By.cssSelector("button[type='submit']");
    By cancelButton = By.cssSelector("button[class='btn btn-danger btn-sm']");

    public createAppPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToWebsite() {
        driver.get("https://www.example.com");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated (loginPage));
    }

    public void fillUsername() {
        driver.findElement(username).sendKeys("system");
    }

    public void fillPassword() {
        driver.findElement(password).sendKeys("P@ssw0rd123#");
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void isHomeMenuDisplayed() {
        driver.findElement(homeMenu).isDisplayed();
    }

    public void clickAppEditor() {
        driver.findElement(appEditorMenu).click();
    }

    public void isAppEditorPageDisplayed() {
        driver.findElement(appEditorPage).isDisplayed();
    }

    public void clickCreateNewApp() {
        driver.findElement(createNewAppButton).click();
    }

    public void isCreateAppFormDisplayed() {
        driver.findElement(createAppForm).isDisplayed();
    }

    public String emptyNameField() {
        return driver.findElement(nameField).getAttribute("placeholder");
    }

    public void fillNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public String emptyDescriptionField() {
        return driver.findElement(descriptionField).getAttribute("placeholder");
    }

    public void fillDescriptionField(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public String emptyGroupField() {
        return driver.findElement(groupField).getAttribute("placeholder");
    }

    public void fillGroupField(String group) {
        driver.findElement(groupField).sendKeys(group);
        driver.findElement(groupField).sendKeys(Keys.ENTER);
    }

    public String emptyMachineLearningService() {
        return driver.findElement(machineLearningServiceField).getAttribute("placeholder");
    }

    public void fillMachineLearningService(String machineLearningService) {
        driver.findElement(machineLearningServiceField).sendKeys(machineLearningService);
        driver.findElement(machineLearningServiceField).sendKeys(Keys.ENTER);
    }

    public void chooseAppIcon() {
        driver.findElement(appIcon).click();
    }

    public String emptyQuickLaunch() {
        return driver.findElement(quickLaunch).getAttribute("aria-checked");
    }

    public void tickQuickLaunch() {
        driver.findElement(quickLaunch).click();
    }

    public void clickCreateButton() {
        driver.findElement(createButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
}
