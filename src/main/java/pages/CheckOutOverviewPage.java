package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
    private final WebDriver driver;
    @FindBy(id = "cancel")
    private WebElement cancelButton;
    @FindBy(id = "finish")
    private WebElement finishButton;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;

    public CheckOutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public HomePage clickCancelButton(){
        cancelButton.click();
        return new HomePage(driver);
    }
    public CheckoutCompletePage clickFinishButton(){
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
    public String check(){
        return title.getText();
    }
}
