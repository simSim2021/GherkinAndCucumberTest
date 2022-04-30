package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.stv.framework.core.lib.EmailSent.EMAIL;

public class MyTestFactoryPage extends FactoryPage{

    @FindBy(id = "DualRegisterEmailModel_Email")
    private WebElement dualRegisterEmailModelEmail;

    @FindBy(id = "qa-dual-register")
    private WebElement qaDualRegister;

    public void clickOnInputField(){ dualRegisterEmailModelEmail.sendKeys(EMAIL); };

    public void clickOnContinueButton(){ qaDualRegister.click(); }

}
