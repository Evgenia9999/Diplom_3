package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverFactory {

    public static WebDriver create(String browser) {
        if (browser.equals("chrome")) {
            // Configure ChromeDriver
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\bin\\chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equals("yandex")) {
            // Configure YandexDriver
            System.setProperty("webdriver.chrome.driver", "D:\\YandexDriver\\bin\\yandexdriver.exe");

            // Configure ChromeOptions for Yandex Browser
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\EAvramenko.000\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"); // Update this path


            return new ChromeDriver(options);
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
    }
}