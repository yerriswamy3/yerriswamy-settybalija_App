package com.n26.monefy.automation.runners;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.n26.monefy.automation.utils.ReadProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AppiumBase {

   
    public static AppiumBase instance = new AppiumBase();
    public AppiumDriver driver;
    public ReadProperties props = null;
    
    @BeforeSuite
    public void start() throws MalformedURLException {
    	props = new ReadProperties();
        if (driver != null) {
            return;
        }
        String apkFilename = props.getProp("apk");
        String platformName =props.getProp("platformName");
        String appPackage =props.getProp("appPackage");
        String appActivity =props.getProp("appActivity");
        String appiumUrl =props.getProp("appiumUrl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File apkfile = new File("./src/test/resources/apk/"+apkFilename);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", "NotUsed");
        capabilities.setCapability("app", apkfile.getAbsolutePath());
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        driver = new AndroidDriver(new URL(appiumUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    
}