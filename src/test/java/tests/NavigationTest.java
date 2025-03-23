package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class NavigationTest extends BaseTest {


    public NavigationTest(String browser) {
        super(browser);
    }


    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    public void testNavigateToProfilePage() {
        mainPage.clickPersonalAccountButton();
        // Проверка перехода на страницу профиля
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("Пользователь не был перенаправлен на страницу профиля","https://stellarburgers.nomoreparties.site/login", currentUrl);

    }

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор» и логотип Stellar Burgers")
    public void testNavigationToConstructorAndLogo() {

        mainPage.clickLoginButton();
        loginPage.enterEmail("ivan@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        // Переход на страницу личного кабинета
        mainPage.clickPersonalAccountButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePage.constructorButton));
        // Возврат на главную страницу через кнопку «Конструктор»
        profilePage.clickConstructorButton();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());

        // Переход на страницу личного кабинета
        mainPage.clickPersonalAccountButton();

        // Возврат на главную страницу через логотип
        mainPage.clickLogo();
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void testLogout() {

        mainPage.clickLoginButton();
        loginPage.enterEmail("ivan@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        // Переход в личный кабинет
        mainPage.clickPersonalAccountButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePage.logoutButton));

        // Выход из аккаунта
        profilePage.clickLogoutButton();

        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        // Проверка, что пользователь перенаправлен на страницу входа
        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }


}