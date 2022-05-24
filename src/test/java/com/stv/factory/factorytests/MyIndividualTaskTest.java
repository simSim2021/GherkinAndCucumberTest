package com.stv.factory.factorytests;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.BasketPage;
import com.stv.factory.factorypages.YourAccountPage;
import com.stv.factory.factorypages.TermsConditionsPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.MAIN_PAGE_URL;


public class MyIndividualTaskTest extends BasicFactoryTest {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    BasketPage basketPage = new BasketPage();
    YourAccountPage yourAccountPage = new YourAccountPage();
    TermsConditionsPage termsConditionsPage = new TermsConditionsPage();

   @Test (description = "Assert the main page is loaded and account icon is visible")
    public void assertAccountIconIsDisplayed() {
       getDriver().get(MAIN_PAGE_URL);
       boolean actualResult = mainFactoryPage .isAccountLinkDisplayed();
        Assert.assertEquals(actualResult, true, "Account link isn't visible");
    }

    @Test(description = "Open basketPage and check that it is empty", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void basketChecking() {
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnBasketButton();
        //basketPage.checkBasketOpenedAndEmpty();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(new BasketPage().checkBasketOpenedAndEmpty(), true, "Basket page isn't loaded properly");
        basketPage.clickLinkYourAccount();
    }

    @Test(description = "Open YourAccountPage, scroll down and click T&C link", dependsOnMethods = "basketChecking")
    public void fromAccountPageToTermsConditionsPage(){
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //Assert.assertEquals(new YourAccountPage().isRegistrationContainerDisplayed(), true, "YourAccount page isn't loaded properly");
        yourAccountPage.isYourAccountPageScrolledDown();
        yourAccountPage.clickLinkTermsAndConditions();

    }

    @Test(description = "Open T&C Page  and click main page link", dependsOnMethods = "fromAccountPageToTermsConditionsPage")
    public void isTermsConditionsPageLoaded(){
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(new TermsConditionsPage().isPageNameDisplayed(), true, "T&C page isn't loaded properly");
        termsConditionsPage.clickLinkMainPage();
    }

    @Test(description = "Main Page  is loaded", dependsOnMethods = "isTermsConditionsPageLoaded")
    public void isMainPageLoaded(){
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.wiggle.co.uk/");
        try {
            mainFactoryPage.clickOnTrustButton();
        } catch (NoSuchElementException e) {
            return;
        }

    }

}