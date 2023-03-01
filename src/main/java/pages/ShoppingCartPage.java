package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    private WebDriver driver;
    private By home = By.id("continue-shopping");
    private By checkout = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage goHome(){
        driver.findElement(home).click();
        return new HomePage(driver);
    }
    public CheckoutPage goCheckout(){
        driver.findElement(checkout).click();
        return new CheckoutPage(driver);
    }
}
