package com.freshflows.pages;

import com.freshflows.objects.functions;
import com.freshflows.utils.ConfigLoader;
//import jdk.internal.jline.internal.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.freshflows.pom.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usermail = By.xpath("//input[@name='email']");
    private final By password = By.xpath("//input[@name='password']");
    private final By submit = By.xpath("//button[@type='submit']");
    private final By newOrg = By.xpath("//span[contains(text(), 'New Organization')]");
    private final By nextbtn = By.xpath("//span[contains(text(), 'Next')]");
    private final By skip = By.xpath("//span[contains(text(),'Skip')]");
    private final By playerCloseIcon = By.xpath("//div[@class='h-9 w-9 flex items-center justify-center rounded-full absolute']");
    private final By orgName = By.xpath("//input[@data-testid='inp_org_name']");
    private final By gLogin = By.xpath("//span[contains(text(), 'Continue with Google')]");
    private final By googleSignInUser = By.xpath("//input[@type='email']");
    private final By chooseOrgTitle = By.xpath("//div[contains(text(), 'Choose an Organization')]");
    private final By existingOrgs = By.xpath("//div[@class='overflow-y-scroll w-full']/div/div[1]");
    private final By chooseAccount = By.xpath("//div[@data-email='ahanaa.j@american-technology.net']");
    private final By forgotpswd = By.xpath("//a[contains(text(), 'Forgot Password?')]");
    private final By workspace = By.xpath("//a[contains(text(), 'Workspace')]");



    public LoginPage enterUsermail(String mail)  {

        driver.findElement(usermail).sendKeys(mail);
        return this;

    }

    public LoginPage enterPassword(String passd){
        driver.findElement(password).sendKeys(passd);
        return this;
    }
    public LoginPage clickSubmit(){
        driver.findElement(submit).click();
        return this;
    }
    public LoginPage clickNewOrg()
    {
        driver.findElement(newOrg).click();
        return this;
        }

    public LoginPage enterOrgName(String org){
        driver.findElement(orgName).sendKeys(org);
        return this;
    }

    public LoginPage googleSignInUser(String gSignInUser){
        driver.findElement(googleSignInUser).sendKeys(gSignInUser);
        return this;
    }

    String url;
    @Step
    @Description("Log into the application")
    @Test
    public LoginPage setlogin(){
          getElement(usermail);
          enterUsermail(ConfigLoader.getInstance().getUsername());
          enterPassword(ConfigLoader.getInstance().getPassword());
          clickSubmit();
          getElement(newOrg);
          clickNewOrg();
          enterOrgName(ConfigLoader.getInstance().getorgName());
          driver.findElement(nextbtn).click();
          getElement(skip);
          driver.findElement(skip).click();
          getElement(playerCloseIcon);
          driver.findElement(playerCloseIcon).click();
          getElement(workspace);
          url = driver.getCurrentUrl();
          System.out.println(url);



      /*
          Assert.assertTrue(driver.getTitle().equals("Freshflows.io"));

          if(url.contains(ConfigLoader.getInstance().getorgName()))
          {
              Assert.assertTrue(url.contains(ConfigLoader.getInstance().getorgName()));
          }
          else {
              Assert.fail("URL does not contain organization name");
          }
  */
        return this;
    }

    @Description("Login in with an existing account")
    @Test
    public LoginPage glogin()
    {
        getElement(gLogin);
        driver.findElement(gLogin).click();
        getElement(nextbtn);
        googleSignInUser(ConfigLoader.getInstance().getUsername());
        driver.findElement(nextbtn).click();
        getElement(nextbtn);
        getElement(password);
        enterPassword(ConfigLoader.getInstance().getPassword());
        driver.findElement(nextbtn).click();
        getElement(chooseOrgTitle);
        driver.findElement(existingOrgs).click();
        getElement(gLogin);
        driver.findElement(gLogin).click();
        getElement(chooseAccount);
        driver.findElement(chooseAccount).click();
        getElement(workspace);
        return this;
    }

   /* public LoginPage forgotPassword(){

        getElement(gLogin);
        driver.findElement(forgotpswd).click();
        return this;
    }
*/



















/*public LoginPage login() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("wait time is loaded");
        driver.findElement(usermail).sendKeys("ahanaa.j@american-technology.net");
        System.out.println("mail is entered");
        Thread.sleep(5000);
        driver.findElement(password).sendKeys("Whitecollar30!");
        Thread.sleep(5000);
        driver.findElement(submit).click();
      //  Assert.assertEquals(getTitle(), "Freshflows.io");
        Thread.sleep(5000);
        return this;
}
*//*
    public LoginPage setfunctions(functions fn){
        return enterUsermail(fn.getMail()).
               enterPassword(fn.getPassd())
                .clickSubmit();
    }*/
}
