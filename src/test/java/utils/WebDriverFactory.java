package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver create(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\YandexDriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("path/to/yandex/browser");
            return new ChromeDriver(options);
        } else {
            throw new RuntimeException("Unsupported browser");
        }
    }
}