package com.demoblaze.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage{

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCart;
}
