package com.freshflows.tests;

import com.freshflows.objects.functions;
import com.freshflows.pages.HomePage;
import com.freshflows.pages.LoginPage;
import com.freshflows.pom.BaseTest;
import com.freshflows.utils.Jacksonutil;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("Epic 1")
@Feature("backlog")
public class TestCase02 extends BaseTest {

    @Story("Create a new wall ")
    @Description("This is to verify if a new call in a new workspace is created")
    @Test(description = "Logging in with google account with an existing organization account and create a new wall")
    public void loginWithGoogleAccount() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(getDriver());
        functions fn = Jacksonutil.fnJson("datafile.json",functions.class);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.glogin();
        homePage.workspace(fn);























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
}
