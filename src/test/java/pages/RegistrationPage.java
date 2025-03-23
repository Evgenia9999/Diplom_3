package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private By nameInput = By.xpath("//input[@name='name']");
    private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath("//input[@name='Пароль']");
    private By registerLink = By.xpath("//a[text()='Зарегистрироваться']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By errorMessage = By.xpath("//p[@class='input__error text_type_main-default']");
    private By loginButton = By.xpath("//a[@class='Auth_link__1fOlj']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void clickLoginLink() {
        driver.findElement(loginButton).click();
    }



}