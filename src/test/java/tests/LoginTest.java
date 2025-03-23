package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private PasswordRecoveryPage passwordRecoveryPage;


    @Before
    public void setUp() {
        driver = WebDriverFactory.create("chrome");
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void testLoginFromMainPage() {

        mainPage.clickLoginButton();

        loginPage.enterEmail("ivan@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void testLoginFromPersonalAccountButton() {

        mainPage.clickPersonalAccountButton();

        loginPage.enterEmail("ivan@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка успешного входа
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void testLoginFromRegistrationForm() {

        mainPage.clickLoginButton();
        registrationPage.clickRegisterLink();
        registrationPage.clickLoginLink();

        loginPage.enterEmail("ivan@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка успешного входа
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void testLoginFromPasswordRecoveryForm() {
        // Переход на страницу восстановления пароля
        mainPage.clickLoginButton();
        loginPage.clickRecoverPassword();
        passwordRecoveryPage.clickLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        loginPage.enterEmail("ivan@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка успешного входа
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }




    /*@After
    public void tearDown() {
        driver.quit();
    }*/
}