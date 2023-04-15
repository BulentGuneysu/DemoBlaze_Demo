package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderBtn;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "country")
    public WebElement country;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "card")
    public WebElement creditCard;
    @FindBy(id = "month")
    public WebElement month;
    @FindBy(id = "year")
    public WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseBtn;

    public void removeProduct(String product) {
        cartLink.click();
        BrowserUtils.waitFor(3);
        WebElement deleteProduct = Driver.get().findElement(By.xpath("//td[.='" + product + "']/..//td[.='Delete']/a"));
        BrowserUtils.waitForClickablility(deleteProduct, 5).click();
        BrowserUtils.waitFor(2);

    }

    public void fillForm() {
        Faker faker = new Faker();
        BrowserUtils.waitFor(1);
        name.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(1);
        country.sendKeys(faker.country().name());
        BrowserUtils.waitFor(1);
        city.sendKeys(faker.country().capital());
        BrowserUtils.waitFor(1);
        creditCard.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        BrowserUtils.waitFor(1);
        year.sendKeys(String.valueOf(faker.number().numberBetween(2023, 2030)));
        BrowserUtils.waitFor(1);

    }

    int actualAmount;
    @FindBy(css = "[class='lead text-muted ']")
    public WebElement confirmation;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement ok_Btn;

    public void finishPurchase_LogAmount() {
        BrowserUtils.waitFor(2);
        placeOrderBtn.click();
        BrowserUtils.waitFor(2);
        fillForm();
        BrowserUtils.waitFor(2);
        purchaseBtn.click();
        BrowserUtils.waitFor(2);

        String confirmationMessage = confirmation.getText();
        System.out.println("confirmationMessage = " + confirmationMessage);

        String[] confirmationArray = confirmationMessage.split("\n");

        actualAmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
        BrowserUtils.waitFor(2);
        ok_Btn.click();
    }

    public void verifyPurchaseAmount(int expectedAmount) {
        Assert.assertEquals(expectedAmount, actualAmount);
        System.out.println("actualAmount = " + actualAmount);
        System.out.println("expectedAmount = " + expectedAmount);
    }


}
