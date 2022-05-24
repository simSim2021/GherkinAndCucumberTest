package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class TermsConditionsPage extends FactoryPage {

    @FindBy(xpath = "//h3[@id='checkout-lightbox-title']")
    private WebElement pageName;

    public boolean isPageNameDisplayed(){
        return pageName.isDisplayed();
    }


    @FindBy(xpath = "//a[@href='//www.wiggle.co.uk']")
    private WebElement linkMainPage;

    public void clickLinkMainPage()  {
        linkMainPage.click();

    }

}
