package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuyPage {
    private WebDriver driver;
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");

    public BuyPage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new HomePage(driver);
    }
    public CheckoutCompletePage clickFinishButton(){
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }
}
