package com.freshflows.pom;

import com.freshflows.utils.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class BaseTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
this.driver.set(driver);
    }
     public WebDriver getDriver(){
        return this.driver.get();
     }

     @Description("This method launches the browser and the URL")
    @Parameters("browser")
    @BeforeMethod()
    public void startDriver(String browser)
    {
        if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
        //    logger.info("Chrome is launched");
        }
        else if(browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            setDriver(new FirefoxDriver());
         //   logger.info("Firefox is launched");
        }
        else if(browser.equals("ie")) {
            WebDriverManager.iedriver().setup();
            setDriver(new InternetExplorerDriver()) ;
        //    logger.info("IE is launched");
        }

        getDriver().manage().window().maximize();
        getDriver().get(ConfigLoader.getInstance().getBaseUrl());

    }
    @Description ("This method captures screenshot on failure and quits the driver")
    @AfterMethod()
    public void quitdriver(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            File destFile = new File("scr" +File.separator + result.getTestClass().getRealClass().getSimpleName()
                    +result.getMethod().getMethodName() + ".png");
            takeScreenAshot(destFile);
        }
        getDriver().quit();
    }


    private void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }

    private void takeScreenAshot(File destFile){
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver());
        try{
            ImageIO.write(screenshot.getImage(), "PNG", destFile);
        }
        catch (IOException e)
        {
                e.printStackTrace();
        }
    }
}
