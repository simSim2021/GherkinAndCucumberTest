package com.stv.BDD.steps;


import com.stv.factory.factorypages.BasketPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.TermsConditionsPage;
import com.stv.factory.factorypages.YourAccountPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.MAIN_PAGE_URL;

public class MyIndividualTaskSteps extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    BasketPage basketPage = new BasketPage();
    YourAccountPage yourAccountPage = new YourAccountPage();
    TermsConditionsPage termsConditionsPage = new TermsConditionsPage();

    @Given("^main page is loaded$")
    public void mainPageIsLoaded() {
        getDriver().get(MAIN_PAGE_URL);
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        mainFactoryPage.clickOnTrustButton();
    }

    @When("^click on Basket$")
    public void clickOnBasket() {
        mainFactoryPage.clickOnBasketButton();

    }

    @And("^check Basket is empty$")
    public void checkBasketIsEmpty() {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(new BasketPage().checkBasketOpenedAndEmpty(), true, "Basket page isn't loaded properly");
    }

    @And("^click Your account link$")
    public void clickYourAccountLink() {
        basketPage.clickLinkYourAccount();
    }

    @And("^scroll down to find Terms&Conditions link$")
    public void scrollDownToFindTermsConditionsLink() {
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        yourAccountPage.isYourAccountPageScrolledDown();

    }

    @And("^click Terms&Conditions link$")
    public void clickTermsConditionsLink() {

        yourAccountPage.clickLinkTermsAndConditions();
    }

    @And("^check that page Terms&Conditions is loaded$")
    public void checkThatPageTermsConditionsIsLoaded() {

        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertEquals(new TermsConditionsPage().isPageNameDisplayed(), true, "T&C page isn't loaded properly");
    }

    @And("^click main page link$")
    public void clickMainPageLink() {

        termsConditionsPage.clickLinkMainPage();
    }

    @And("^check that main page is loaded$")
    public void checkThatMainPageIsLoaded() {

        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.wiggle.co.uk/");
    }

    @Then("^check the button Accept cookies and click button Accept cookies if exists$")
    public void checkTheButtonAcceptCookies() {
        try {
            mainFactoryPage.clickOnTrustButton();
        } catch (NoSuchElementException e) {
            return;
        }
    }


}
