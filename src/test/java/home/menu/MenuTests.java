package home.menu;

import base.BaseTests;
import org.testng.annotations.BeforeTest;
import utils.HoverMenu;
import org.testng.annotations.Test;
import pages.AboutPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuTests extends BaseTests {
    @Test
    public void testAllItemsButton(){
        HoverMenu hoverMenu = goHomePage().selectMenuOptions();

        assertTrue(hoverMenu.isMenuDisplayed(),"Menu isn't display");

        hoverMenu.clickAllItems();
    }
    @Test
    public void testAboutButton(){
        HomePage homePage = goHomePage();
        AboutPage aboutPage = homePage.selectMenuOptions().clickAboutLink();

        assertEquals(aboutPage.getTitle(),
                "Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs");
    }
    @Test
    public void testLogOut(){
        HomePage homePage = goHomePage();
        HoverMenu hoverMenu = homePage.selectMenuOptions();
        hoverMenu.clickLogOut();
    }
    @Test
    public void testResetApp(){
        HomePage homePage = goHomePage();
        homePage.selectMenuOptions().clickResetApp();
    }


    private HomePage goHomePage(){
        loginPage.setStandardUsername();
        loginPage.setPassword();
        return loginPage.clickLoginButton();
    }
}
