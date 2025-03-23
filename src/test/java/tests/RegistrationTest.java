package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UsersApi;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest{


    public RegistrationTest(String browser) {
        super(browser);
    }



    @Test
    @DisplayName("Проверка успешной регистрации")
    public void testSuccessfulRegistration() {
        mainPage.clickLoginButton();
        registrationPage.clickRegisterLink();

        registrationPage.enterName(UsersApi.name);
        registrationPage.enterEmail(UsersApi.email);
        registrationPage.enterPassword(UsersApi.password);
        registrationPage.clickRegisterButton();

        // Проверка успешной регистрации
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));

        String currentUrl = driver.getCurrentUrl();
        assertEquals("Пользователь не был перенаправлен на страницу входа после регистрации","https://stellarburgers.nomoreparties.site/login", currentUrl);

        userApi.deleteUser();

    }


    @Test
    @DisplayName("Проверка ошибки при регистрации с паролем короче 6 символов")
    public void testShortPasswordError() {

        mainPage.clickLoginButton();
        registrationPage.clickRegisterLink();
        registrationPage.enterName("Иван Иванов");
        registrationPage.enterEmail("ivan9878222@example.com");
        registrationPage.enterPassword("12345"); // Пароль короче 6 символов
        registrationPage.clickRegisterButton();

        // Проверка сообщения об ошибке
        String expectedErrorMessage = "Некорректный пароль";
        String actualErrorMessage = registrationPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}