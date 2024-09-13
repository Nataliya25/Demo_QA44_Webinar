package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends ApplicationManager {


    @Test
    public void test(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnForms();
    }

}