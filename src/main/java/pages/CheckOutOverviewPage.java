package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverviewPage {
    private WebDriver driver;
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");

    public CheckOutOverviewPage(WebDriver driver) {
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
    public String check(){
        return driver.findElement(By.xpath("//span[@class='title']")).getText();
    }
}
