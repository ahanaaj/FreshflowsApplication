package com.freshflows.tests.Workspace;

import com.freshflows.objects.functions;
import com.freshflows.pages.HomePage;
import com.freshflows.pages.LoginPage;
import com.freshflows.pom.BaseTest;
import com.freshflows.utils.Jacksonutil;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WorkspaceTests extends BaseTest {


    @Story("User Login ")
    @Description("This is to verify if the organization name is captured in the URL ")
    @Test(description = "Login with workmail method")
    public void Create_new_workspace_using_plus_icon() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(getDriver());
        functions fn = Jacksonutil.fnJson("datafile.json",functions.class);
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.glogin();
            homePage.workspace(fn);
            Assert.assertTrue(getDriver().findElement(By.xpath("//span[contains(text(), 'Members')]")).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Login with workmail method")
    public void Create_workspace_Idea_to_Launch() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(getDriver());
        functions fn = Jacksonutil.fnJson("datafile.json",functions.class);
        LoginPage loginPage = new LoginPage(getDriver());
        try {
            loginPage.glogin();
            homePage.IdeaToLaunch(fn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
