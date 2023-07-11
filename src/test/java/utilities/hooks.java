package utilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class hooks {

    public static WebDriver driver;

    @Before
    public void BeforeScenario() {



        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Chrome/114.0.5735.199");
        options.addArguments("--no-proxy-server");

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webDriver/chromedriver.exe");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @BeforeStep
    public void BeforeStep() throws InterruptedException {
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterStep
    public void AfterStep() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @After
    public void AfterScenario() {
        driver.close();
        driver.quit();
    }
}