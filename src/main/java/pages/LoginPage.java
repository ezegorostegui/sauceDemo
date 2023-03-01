package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("div.error-message-container");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setStandardUsername(){
        driver.findElement(username).sendKeys("standard_user");
    }
    public void setLockedUsername(){
        driver.findElement(username).sendKeys("locked_out_user");
    }
    public void setProblemUsername(){
        driver.findElement(username).sendKeys("problem_user");
    }
    public void setPerformanceUsername(){
        driver.findElement(username).sendKeys("performance_glitch_user");
    }
    public void setPassword(){
        driver.findElement(password).sendKeys("secret_sauce");
    }
    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
    public String errorMessage(){
        return driver.findElement(errorMessage).getText();
    }


    //Methods for data driver
    public void setUsernameDP(String user){
        driver.findElement(username).sendKeys(user);
    }
    public void setPasswordDP(String password){
        driver.findElement(this.password).sendKeys(password);
    }
    public String check(){
        return driver.findElement(By.xpath("//span[@class='title']")).getText();
    }
}
