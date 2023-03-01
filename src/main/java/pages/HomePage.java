package pages;

import utils.HoverMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private final WebDriver driver;
    private WebElement hoverElement;
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By filter = By.cssSelector("select.product_sort_container");
    private final By cart = By.cssSelector("#shopping_cart_container > a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods for menu
    public HoverMenu selectMenuOptions(){
        hoverElement = driver.findElement(menuButton);
        Actions action = new Actions(driver);
        action.moveToElement(hoverElement).click().perform();
        return new HoverMenu(driver,hoverElement);
    }

    //Methods for filter
    public void selectFromDropdown(String option){
        findDropdownElement().selectByValue(option);
    }
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e ->e.getText()).collect(Collectors.toList());
    }

    //Methods for shopping cart
    public ShoppingCartPage goShoppingCart(){
        selectAndClickLocator(cart);
        return new ShoppingCartPage(driver);
    }

    //Helper methods
    private void selectAndClickLocator(By locator){
        driver.findElement(locator).click();
    }
    private Select findDropdownElement(){
        return new Select(driver.findElement(filter));
    }
}
