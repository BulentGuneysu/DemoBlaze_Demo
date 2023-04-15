package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    AddToCartPage addToCartPage=new AddToCartPage();

    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername;

    public void verifyWelcomeMessage() {
        BrowserUtils.waitForVisibility(welcomeUsername, 5);
        String actualMessage = welcomeUsername.getText();
        String expectedMessage = "Welcome " + ConfigurationReader.get("username");
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public void verifyWelcomeMessage(String expectedMessage) {
        BrowserUtils.waitForVisibility(welcomeUsername, 5);
        String actualMessage = welcomeUsername.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public void addProduct(String category, String product){
        BrowserUtils.waitFor(1);
        WebElement categoryMenu = Driver.get().findElement(By.xpath("//a[.='"+category+"']"));
        BrowserUtils.waitForClickablility(categoryMenu,5).click();
        WebElement productItem = Driver.get().findElement(By.xpath("//a[.='"+product+"']"));
        BrowserUtils.scrollToElement(productItem);
        BrowserUtils.waitForClickablility(productItem,5).click();
        BrowserUtils.waitFor(1);

        BrowserUtils.waitForClickablility(addToCartPage.addToCart,5);
        addToCartPage.addToCart.click();
        BrowserUtils.waitFor(1);
        Alert alert=Driver.get().switchTo().alert();
        alert.accept();
        homeLink.click();

    }

}
