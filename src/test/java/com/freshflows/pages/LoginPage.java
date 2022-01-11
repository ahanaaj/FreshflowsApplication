package com.freshflows.pages;

import com.freshflows.objects.functions;
import com.freshflows.utils.ConfigLoader;
//import jdk.internal.jline.internal.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import com.freshflows.pom.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
    private final By mailErrorMsg = By.xpath("//span[contains(text(), 'must be a valid email')]");
    private final By pswdErrorMsg  = By.xpath("//span[contains(text(), 'length must be at least 8 characters long')]");
    private final By signUp = By.xpath("//a[contains(text(), 'Sign Up')]");
    private final By verificationMailMessage = By.xpath("//div[@class='flex flex-col items-center']//div[1]");
    private final By signUpBtn = By.xpath("//span[contains(text(), 'Sign Up')]");
    private final By mailinator = By.xpath("(//a[@title='Mailinator-Millions of Inboxes. All yours.'])[1]");
    private final By mailinatormail = By.xpath("(//input[@type='text'])[1]");
    private final By mailinatorGO = By.xpath("//button[contains(text(), 'GO')]");
    private final By mailinatorFrom = By.xpath("//td[contains(text(), 'From')]");


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

    /*public LoginPage enterOrgName(String org){
        driver.findElement(orgName).sendKeys(org);
        return this;
    }*/

    public LoginPage googleSignInUser(String gSignInUser){
        driver.findElement(googleSignInUser).sendKeys(gSignInUser);
        return this;
    }

    public LoginPage reademailErrorMsg()  {
        driver.findElement(mailErrorMsg).getText();
        return this;
    }

    public LoginPage readpswdErrorMsg()  {

        driver.findElement(pswdErrorMsg).getText();
        return this;

    }

    String url;
    @Step
    @Description("Log into the application")
    @Test
    public LoginPage setlogin() throws InterruptedException {
          getElement(usermail);
          enterUsermail(ConfigLoader.getInstance().getUsername());
          enterPassword(ConfigLoader.getInstance().getPassword());
          clickSubmit();
          getElement(newOrg);
          clickNewOrg();
          getElement(orgName);
          driver.findElement(orgName).sendKeys(ConfigLoader.getInstance().getorgName());
          getElement(nextbtn);
          driver.findElement(nextbtn).click();
          getElement(skip);
          driver.findElement(skip).click();
          getElement(playerCloseIcon);
          driver.findElement(playerCloseIcon).click();
          getElement(workspace);
          url = driver.getCurrentUrl();
          System.out.println(url);
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

    String errorMail;
    @Description("Verify log in error messages")
    @Test
    public LoginPage invalidCreds(functions fn){
    //wait and enter email
    getElement(usermail);
    enterUsermail(fn.getShortEmail());
    //enter password
    enterPassword(fn.getShortPassword());
    //click submit
    clickSubmit();
    getElement(mailErrorMsg);
    errorMail = driver.findElement(mailErrorMsg).getText();
    System.out.println("print error message" +errorMail);
    return this;
}

public LoginPage invalidPassword(functions fn){
    getElement(usermail);
    enterUsermail(fn.getShortEmail());
    enterPassword(fn.getLongPassword());
    clickSubmit();
    return this;
}


    public String textOutput;
    public LoginPage signUP(functions fn) throws InterruptedException {
        getElement(signUp);
        driver.findElement(signUp).click();
        //enter work mail
        getElement(gLogin);
        driver.findElement(usermail).sendKeys(fn.getVerificationMail());
        driver.findElement(signUpBtn).click();
        Thread.sleep(3000);
        System.out.println("before fail");
        Thread.sleep(3000);
        List<WebElement> trList = driver.findElements(By.xpath("//*[@id=\"root\"]/div[1]/div[3]/div/div/div/div"));
        for(int i=0;i<trList.size();i++)
        {
            if(trList.get(i).getText().contains("verification mail has been sent"))
                {
            WebElement te = driver.findElement(By.xpath("(//*[@id=\"root\"]/div[1]/div[3]/div/div/div/div)[\" + i + \"]"));
            textOutput = te.getText();
            System.out.println("verification mail message:::" + te.getText());
            System.out.println(textOutput);
            break;
            }
        }
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(ConfigLoader.getInstance().getgmail());
        getElement(mailinator);
        driver.findElement(mailinatormail).sendKeys(ConfigLoader.getInstance().getmailinatorID());
        driver.findElement(mailinatorGO).click();
        getElement(mailinatorFrom);

        return this;
}
}
