package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;


public class BaseTest extends WebDriverFactory {

    public WebDriver driver;
    public MainPage mainPage;
    public RegistrationPage registrationPage;
    public WebDriverWait wait;
    public ProfilePage profilePage;
    public LoginPage loginPage;
    public PasswordRecoveryPage passwordRecoveryPage;
    public ConstructorPage constructorPage;
    public String browser;
    public UsersApi userApi;




    public BaseTest (String browser) {
        this.browser = browser;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"chrome"},
                {"yandex"}
        });
    }

    @Before
    public void setUp() {
        driver = WebDriverFactory.create(browser);
        driver.get("https://stellarburgers.nomoreparties.site/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        constructorPage = new ConstructorPage(driver);
        userApi = new UsersApi();

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
