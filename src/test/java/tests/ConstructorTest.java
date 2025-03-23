package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ConstructorPage;
import utils.WebDriverFactory;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {

    public ConstructorTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void testNavigateToSaucesSection() {
        // Переход к разделу «Соусы»
        constructorPage.clickSaucesSection();

        // Проверка, что раздел «Соусы» активен
        String activeSection = constructorPage.getActiveSouceSectionText();
        assertEquals("Соусы", activeSection);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void testNavigateToFillingsSection() {
        // Переход к разделу «Начинки»
        constructorPage.clickFillingsSection();

        // Проверка, что раздел «Начинки» активен
        String activeSection = constructorPage.getActiveFillingSectionText();
        assertEquals("Начинки", activeSection);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void testNavigateToBunsSection() {
        WebElement bunsSection = driver.findElement(constructorPage.bunsSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bunsSection);

        // Проверка перехода к разделу «Булки»
        String activeSection = constructorPage.getActiveBunsSectionText();
        assertEquals("Булки", activeSection);
    }


}