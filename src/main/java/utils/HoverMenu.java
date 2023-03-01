package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AboutPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HoverMenu {
    private WebDriver driver;
    private WebElement menuOption;
    private final By allItemsButton = By.id("inventory_sidebar_link");
    private final By aboutLinkButton = By.id("about_sidebar_link");
    private final By logOutButton = By.id("logout_sidebar_link");
    private final By resetAppButton = By.id("reset_sidebar_link");


    public HoverMenu(WebDriver driver, WebElement hoverElement) {
        this.driver = driver;
        this.menuOption = hoverElement;
    }

    public boolean isMenuDisplayed(){
        return menuOption.isDisplayed();
    }
    public HomePage clickAllItems(){
        menuOption = selectLocator(allItemsButton);
        searchElement(menuOption);
        clickMenuOption(menuOption);
        return new HomePage(driver);
    }
    public AboutPage clickAboutLink(){
        menuOption = selectLocator(aboutLinkButton);
        searchElement(menuOption);
        clickMenuOption(menuOption);
        return new AboutPage(driver);
    }
    public LoginPage clickLogOut(){
        menuOption = selectLocator(logOutButton);
        searchElement(menuOption);
        clickMenuOption(menuOption);
        return new LoginPage(driver);
    }
    public LoginPage clickResetApp(){
        menuOption = selectLocator(resetAppButton);
        searchElement(menuOption);
        clickMenuOption(menuOption);
        return new LoginPage(driver);
    }


    private WebElement selectLocator(By locator){
        return driver.findElement(locator);
    }
    private void clickMenuOption(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }
    private void searchElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));

//        WebElement myElement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(button));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
//        a.moveToElement(webElement).build().perform();
    }
}
