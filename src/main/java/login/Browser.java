package login;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static WebDriver driver;

    @Step
    public void configureChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Step
    public WebDriver getDriver() {
        configureChromeDriver();
        return driver;
    }

    public void quitDriver() {
        try {
            if (this.driver != null)
                this.driver.quit();
        } finally {
            this.driver = null;
        }
    }
}