package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;


public class YourAccountPage extends FactoryPage{
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @FindBy(xpath = "//a[contains (text(), 'Terms & conditions')]")
    private WebElement linkTermsAndConditions;

    @FindBy(className = "bem-checkout")
    private WebElement registrationContainer;

    public boolean isRegistrationContainerDisplayed(){
        return registrationContainer.isDisplayed();
    }

    public void isYourAccountPageScrolledDown(){
        js.executeScript("arguments[0].scrollIntoView();", linkTermsAndConditions);
    }

    public void clickLinkTermsAndConditions(){
        linkTermsAndConditions.click();
    }

}
