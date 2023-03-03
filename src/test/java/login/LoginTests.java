package login;

import base.BaseTests;
import base.dataProvider.LoginData;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test(dataProviderClass = LoginData.class , dataProvider = "login_provider2")
    public void testLogIn(String user, String password, String message){
        loginPage.setUsernameDP(user);
        loginPage.setPasswordDP(password);
        HomePage homePage = loginPage.clickLoginButton();

        if(message.isBlank()){
            assertEquals(homePage.check(),"Products");
        } else if (message.contains("Password is required")) {
            assertEquals(message,"Epic sadface: Password is required");
        } else {
            assertEquals(message,"Epic sadface: Username and password do not match any user in this service");
        }
    }
    @Test
    public void testStandardUser(){
        loginPage.setStandardUsername();
        loginPage.setPassword();
        HomePage homepage = loginPage.clickLoginButton();
//        assertEquals();
    }
    @Test
    public void testLockedUser(){
        loginPage.setLockedUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();

        assertTrue(loginPage.errorMessage().contains("user has been locked out"),
                "Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    public void testProblemUser(){
        loginPage.setProblemUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
    }
    @Test
    public void testPerformanceUser(){
        loginPage.setPerformanceUsername();
        loginPage.setPassword();
        HomePage homePage = loginPage.clickLoginButton();
    }
}
