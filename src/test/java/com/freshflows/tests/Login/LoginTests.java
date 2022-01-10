package com.freshflows.tests.Login;

import com.freshflows.objects.functions;
import com.freshflows.pages.LoginPage;
import com.freshflows.pom.BaseTest;
import com.freshflows.utils.Jacksonutil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("Epic 1")
@Feature("Login")
public class LoginTests extends BaseTest {

    @Story("User Login ")
    @Description("This is to verify if the organization name is captured in the URL ")
    @Test(description = "Login with workmail method")
    public void login() throws InterruptedException, IOException {
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
    public void Verify_login_with_valid_credentials() throws InterruptedException, IOException {
        try {
            functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.setlogin();
            Assert.assertTrue(getDriver().getTitle().equals("Freshflows.io"));
        } catch (Exception e) {
            e.printStackTrace();

        }

    }






















        /*homePage homePage = new homePage(driver);
        homePage.pages("tyyyjkm");
        Thread.sleep(5000);

        MainPage mainPage = homePage.closePlayer();
        mainPage.clickWs();
*/










//        functions func= Jacksonutil.json("datafile.json", functions.class );

  //      functions fn = new functions("ahana", "psdd");
        /*fn.setMail("jkk");
        fn.setPassd("kjknk");*/





}
