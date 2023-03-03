package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zip = By.id("postal-code");
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.cssSelector("div.error-message-container.error > h3");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }
    public void enterLastName(String surname){
        driver.findElement(lastName).sendKeys(surname);
    }
    public void enterZip(int postalCode){
        driver.findElement(zip).sendKeys(String.valueOf(postalCode));
    }
    public ShoppingCartPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new ShoppingCartPage(driver);
    }
    public CheckOutOverviewPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new CheckOutOverviewPage(driver);
    }
    public Boolean isFirstNameEmpty(){
        return isFieldEmpty(firstName);
    }
    public Boolean isLastNameEmpty(){
        return isFieldEmpty(lastName);
    }
    public Boolean isZipEmpty(){
        return isFieldEmpty(zip);
    }


    //Helper methods
    private Boolean isFieldEmpty(By locator){
        return driver.findElement(locator).getText().isBlank();
    }
    public String textResult(){
        return driver.findElement(errorMessage).getText();
    }
}
