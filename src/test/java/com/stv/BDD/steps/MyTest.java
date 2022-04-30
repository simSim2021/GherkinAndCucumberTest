package com.stv.BDD.steps;

import com.stv.factory.factorypages.MyTestFactoryPage;
import com.stv.factory.factorypages.RegistrationPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class MyTest extends BasicFactoryTest {
    MyTestFactoryPage myTestFactoryPage = new MyTestFactoryPage();

    @Given("^the main page is loaded$")
    public void setup() throws Throwable {
        getDriver().get(START_URL);
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();

    }

    @When("^user enter valid email for new customer in filed Email address$")
    public void pressInputField() {
        myTestFactoryPage.clickOnInputField();
    }

    @And("^click Continue button$")
    public void pressContinueButton() {
        myTestFactoryPage.clickOnContinueButton();
    }


    @Then("^page with registration form is loaded and message appears$")
    public void pageWithRegistrationFormIsOpened() {
        getDriver().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        new RegistrationPage().isRegistrationContainerDisplayed();
    }
}
