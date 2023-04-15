package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login2")
    public WebElement loginHomePage;
    @FindBy(id = "loginusername")
    public WebElement usernameInput;
    @FindBy(id = "loginpassword")
    public WebElement passwordInput;
    @FindBy(css = "[onclick='logIn()']")
    public WebElement submitBtn;

    public void login(){
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginHomePage.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }

    public void login(String username,String password){
        loginHomePage.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyWithPopUpMessage(String expectedWarningMessage){

        Alert alert= Driver.get().switchTo().alert();
        String actualWarningMessage = alert.getText();
        alert.accept();
        Assert.assertEquals(expectedWarningMessage,actualWarningMessage);
        System.out.println("actualWarningMessage = " + actualWarningMessage);

    }



}
