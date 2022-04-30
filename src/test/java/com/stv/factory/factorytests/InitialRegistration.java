package com.stv.factory.factorytests;
import com.stv.factory.factorypages.MyTestFactoryPage;
import com.stv.factory.factorypages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InitialRegistration extends BasicFactoryTest {
    MyTestFactoryPage myTestFactoryPage = new MyTestFactoryPage();

    @Test(description = "Initialization/first step of a new customer's registration")
    public void emailChecking() {
        myTestFactoryPage.clickOnInputField();
        myTestFactoryPage.clickOnContinueButton();
        Assert.assertEquals(new RegistrationPage().isRegistrationContainerDisplayed(), true, "Registration page isn't loaded properly");
    }
}