package pages;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@Slf4j
public class BasePage {
    protected static WebDriver webDriver;

    @BeforeAll
    @SneakyThrows
    public static void initializeWebDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        log.info("Opening the page...");
        webDriver.get("https://dzen.ru/");
        Thread.sleep(5000);
    }

    @AfterAll
    public static void quit() {
        webDriver.quit();
    }
}
