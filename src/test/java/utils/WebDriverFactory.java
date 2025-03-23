package utils;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.Collection;


public class WebDriverFactory {

    public static WebDriver create(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "D:\\YandexDriver\\bin\\yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("D:\\YandexDriver\\bin\\yandexdriver.exe");
            return new ChromeDriver(options);
        } else {
            throw new RuntimeException("Unsupported browser");
        }
    }
}