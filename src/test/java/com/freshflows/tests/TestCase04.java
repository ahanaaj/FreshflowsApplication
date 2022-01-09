package com.freshflows.tests;

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
public class TestCase04 extends BaseTest {

    @Story("User Login ")
    @Description("This is to verify if the organization name is captured in the URL ")
    @Test
    public void errorLogin() throws InterruptedException, IOException {
        functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.invalidCreds(fn);
        System.out.println(loginPage.reademailErrorMsg());
        Assert.assertTrue(loginPage.reademailErrorMsg().equals(fn.getShortEmailErrorMsg()));
        Assert.assertTrue(loginPage.readpswdErrorMsg().equals(fn.getShortPswdErrorMsg()));
    }
    /*@Test
    public void errorMsgLogin() throws InterruptedException, IOException {
        functions fn = Jacksonutil.fnJson("datafile.json", functions.class);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.invalidPassword(fn);
        Assert.assertTrue(loginPage.reademailErrorMsg().equals(fn.getShortEmailErrorMsg()));
        Assert.assertFalse(loginPage.reademailErrorMsg().equals(fn.getShortPswdErrorMsg()));

    }
*/
























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

