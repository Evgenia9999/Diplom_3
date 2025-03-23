package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public By logoutButton = By.xpath("//button[text()='Выход']");
    public By constructorButton = By.xpath("//p[text()='Конструктор']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}