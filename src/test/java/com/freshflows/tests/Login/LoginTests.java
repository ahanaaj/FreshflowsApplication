package com.freshflows.tests.Login;

import com.freshflows.objects.functions;
import com.freshflows.pages.LoginPage;
import com.freshflows.pom.BaseTest;
import com.freshflows.utils.Jacksonutil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("Epic 1")
@Feature("Login")
public class LoginTests extends BaseTest {

    @Story("User Login ")
    @Description("This is to verify if the organization name is captured in the URL ")
    @Test(description = "Login with workmail method")
    public void sign_up_using_invalid_email_format() throws InterruptedException, IOException {
        functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.invalidCreds(fn);
            Assert.assertTrue(loginPage.reademailErrorMsg().equals(fn.getShortEmailErrorMsg()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertFalse(loginPage.readpswdErrorMsg().equals(fn.getShortPswdErrorMsg()));

        }
    }

    @Test(description = "Login with workmail method")
    public void sign_up_using_valid_email_format() throws InterruptedException, IOException {
        try {
            functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.setlogin();
            Assert.assertTrue(getDriver().getTitle().equals("Freshflows.io"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Story("User Login ")
    @Description("This is to verify if the organization name is captured in the URL ")
    @Test(description = "Login with workmail method")
    public void Signup_using_already_existing_google_account() throws InterruptedException, IOException {
        try {
            functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.signUP(fn);
            Assert.assertTrue(loginPage.textOutput.equals(fn.getVerificationMailSent()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @Story("User Login ")
    @Description("This is to verify if the organization name is captured in the URL ")
    @Test(description = "Login with workmail method")
    public void Reset_password_by_providing_valid() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(getDriver());
        functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
        try {
            loginPage.forgotpswd(fn);
            Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(), 'Reset Link Sent')]")).isDisplayed());
     }
        catch(Exception e)
        {
            Assert.fail("Reset link title is not seen");
            e.printStackTrace();
        }
        try{
            loginPage.goToMailinator(fn);
            Assert.assertTrue(getDriver().findElement(By.xpath("//a[@title='Confirm Mail']")).isDisplayed());
        }
        catch (Exception e){
            Assert.fail("confirm mail not clicked");
            e.printStackTrace();
}
    }

    @Test(description = "Resend the verification link")
    public void Resend_the_verification_link() throws InterruptedException, IOException {
        functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.signUP(fn);
            loginPage.goToMailinator(fn);
            loginPage.setYourPswd(fn);
            Assert.assertTrue(getDriver().getTitle().equals("freshflows.io"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


}
