package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(xpath = "//a[@id = 'accountLink']")
    private WebElement accountLink;

    @FindBy(xpath = "//button[contains(text(),'Accept All Cookies')]")
    private WebElement trustButton;

    @FindBy(xpath = "//a[@class = 'bem-header__basket--empty']")
    private WebElement basketButton;

    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }

    public void clickOnAccountLink(){
        accountLink.click();
    }

    public void clickOnBasketButton(){

        basketButton.click();
    }

    public void clickOnTrustButton(){
        trustButton.click();
    }


}
