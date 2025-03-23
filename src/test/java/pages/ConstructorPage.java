package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage {
    private WebDriver driver;

    public By bunsSection = By.xpath("//div//span[text()='Булки']");
    private By saucesSection = By.xpath("//span[text()='Соусы']");
    private By fillingsSection = By.xpath("//span[text()='Начинки']");
    private By activeBunsSection = By.xpath("//h2[text()='Булки']");
    private By activeSouceSection = By.xpath("//h2[text()='Соусы']");
    private By activeFillingSection = By.xpath("//h2[text()='Начинки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    public void clickSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    public void clickFillingsSection() {
        driver.findElement(fillingsSection).click();
    }

    public String getActiveBunsSectionText() {
        return driver.findElement(activeBunsSection).getText();
    }

    public String getActiveSouceSectionText() {
        return driver.findElement(activeSouceSection).getText();
    }

    public String getActiveFillingSectionText() {
        return driver.findElement(activeFillingSection).getText();
    }
}