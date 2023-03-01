package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;
    private By backHomeButton = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage clickBackHomeButton(){
        driver.findElement(backHomeButton).click();
        return new HomePage(driver);
    }
}