package tests;

import base.BaseTest;
import driver.AppDriver;
import driver.AppFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class MyTest extends BaseTest {
    AppiumDriver driver;

    @Test
    public void testAndroidLogin() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setPlatformName("Android")
                .setPlatformVersion("9")
                .setDeviceName("cpv")
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.MainActivity");

        AppFactory.launchAndroidApp(options);
        driver = (AndroidDriver) AppDriver.getCurrentDriver();
        driver.manage().window().getSize();
    }

    @Test
    public void testIOSLogin() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setPlatformVersion("17.2")
                .setDeviceName("iPhone 15")
                .setBundleId("com.swaglabsmobileapp.MainActivity");

        AppFactory.launchIOSApp(options);
        driver = (IOSDriver) AppDriver.getCurrentDriver();
        driver.manage().window().getSize();
    }

    @Test
    public void fullTest(){
        AppDriver.getCurrentDriver().manage().window().getSize();
    }
}
