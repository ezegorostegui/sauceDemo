package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private final WebDriver driver;
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement zip;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(css = "div.error-message-container.error > h3")
    private WebElement errorMessage;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void enterFirstName(String name){
        firstName.sendKeys(name);
    }
    public void enterLastName(String surname){
        lastName.sendKeys(surname);
    }
    public void enterZip(String postalCode){
        zip.sendKeys(postalCode);
    }
    public ShoppingCartPage clickCancelButton(){
        cancelButton.click();
        return new ShoppingCartPage(driver);
    }
    public CheckOutOverviewPage clickContinueButton(){
        continueButton.click();
        return new CheckOutOverviewPage(driver);
    }
    public String textResult(){
        return errorMessage.getText();
    }
}
