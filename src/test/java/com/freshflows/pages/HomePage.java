package com.freshflows.pages;

import com.freshflows.objects.functions;
import com.freshflows.pom.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
     private final By plusIcon = By.xpath("//div[@class='px-2.5 add-workspace mt-7 flex justify-between items-center parent']//div[2]//*[name()='svg']");
     private final By workspace = By.xpath("//a[contains(text(), 'Workspace')]");
     private final By enterWSName = By.xpath("//div[@class='ml-6 flex flex-col']/input");
     private final By createWorkspace = By.xpath("//span[contains(text(), 'Create Workspace')]");
     private final By newWall = By.xpath("(//div[@class='w-3/5 ml-12']/div)[1]");
     private final By useWall = By.xpath("//div[@class='w-32']//button");
     private final By row = By.xpath("//div[@role='row']");
     private final By workspaces = By.xpath("//span[contains(text(), 'Workspaces')]");
     private final By IdeaToLaunch = By.xpath("//span[contains(text(), 'Idea to Launch')]");
     private final By pdtBacklog = By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div/div/div[1]/div[1]/span");

     @Step
     @Description("Create a nThis method launches the browser and the URLew workspace and a new wall")
    public HomePage workspace(functions fn) throws InterruptedException {
        // getElement(workspaces);
        Thread.sleep(6000);
        driver.findElement(plusIcon).click();
        getElement(enterWSName);
        driver.findElement(enterWSName).sendKeys(fn.getWorkspaceName());
        getElement(createWorkspace);
        driver.findElement(createWorkspace).click();
        getElement(newWall);
        return this;
    }

    @Step
    @Description("Create a nThis method launches the browser and the URLew workspace and a new wall")
    public HomePage IdeaToLaunch(functions fn) throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(plusIcon).click();
        getElement(enterWSName);
        driver.findElement(enterWSName).sendKeys(randomString(x));
        getElement(IdeaToLaunch);
        driver.findElement(IdeaToLaunch).click();
        getElement(createWorkspace);
        driver.findElement(createWorkspace).click();
        getElement(pdtBacklog);
        List<WebElement> toLaunch = null;
        List<WebElement> ideaToLaunch = driver.findElements(By.xpath("(//div[@class='flex w-4/5 mx-auto']//div)[1]/div/div/div/div"));
        System.out.println(ideaToLaunch.get(0).getText());
        for(WebElement ele : ideaToLaunch){
          //toLaunch.add(ele);
         // for (int i =0; i<ideaToLaunch.size(); i++){
          String list = ele.getText();
          System.out.println("list " +list);
         // }
        }

        return this;
    }

    public HomePage createWall()
    {
        getElement(newWall);
        driver.findElement(newWall).click();
        getElement(useWall);
        driver.findElement(useWall).click();
        getElement(row);
        return this;
    }
}
