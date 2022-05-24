package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends FactoryPage {
    @FindBy(xpath = "//h1[contains(text(),'Your Shopping Basket is currently empty')]")
    private WebElement basket;

    public boolean checkBasketOpenedAndEmpty() {
       return basket.isDisplayed();
    }

    @FindBy(xpath = "//a[@id='accountLink']")
    private WebElement yourAccountLink;

    public void clickLinkYourAccount(){
        yourAccountLink.click();
    }


}