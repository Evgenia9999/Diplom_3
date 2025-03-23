package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.UsersApi;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {


    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void testLoginFromMainPage() {

        mainPage.clickLoginButton();

        userApi.createUser();
        loginPage.enterEmail(UsersApi.email);
        loginPage.enterPassword(UsersApi.password);

        loginPage.clickLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());

        userApi.deleteUser();
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void testLoginFromPersonalAccountButton() {

        mainPage.clickPersonalAccountButton();
        userApi.createUser();
        loginPage.enterEmail(UsersApi.email);
        loginPage.enterPassword(UsersApi.password);
        loginPage.clickLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка успешного входа
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());

        userApi.deleteUser();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void testLoginFromRegistrationForm() {

        mainPage.clickLoginButton();
        registrationPage.clickRegisterLink();
        registrationPage.clickLoginLink();

        userApi.createUser();
        loginPage.enterEmail(UsersApi.email);
        loginPage.enterPassword(UsersApi.password);

        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка успешного входа
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());

        userApi.deleteUser();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void testLoginFromPasswordRecoveryForm() {
        // Переход на страницу восстановления пароля
        mainPage.clickLoginButton();
        loginPage.clickRecoverPassword();
        passwordRecoveryPage.clickLoginButton();

        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        userApi.createUser();
        loginPage.enterEmail(UsersApi.email);
        loginPage.enterPassword(UsersApi.password);

        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

        // Проверка успешного входа
        assertEquals("https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());

        userApi.deleteUser();
    }

}