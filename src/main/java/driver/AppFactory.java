package driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.testng.SkipException;

import java.lang.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    static AppiumDriver driver;

    public static void launchAndroidApp(UiAutomator2Options options) throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
    }

    public static void launchIOSApp(XCUITestOptions options) throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
    }


    public static void launchApp() throws MalformedURLException {
        System.out.println("entering into launchapp");
        if(AppData.platform.contains("ios")){
            launchIOSApp();
            System.out.println("iOS launched...");
        }else
        if(AppData.platform.contains("android")){
            launchAndroidApp();
            System.out.println("Android launched...");
        }else
            throw new SkipException("Enter valid platform value, android/ios");
    }

    private static void launchIOSApp() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        //browserstackOptions = getBrowserstackOptions();

        if(AppData.isCloud.contains("false")){
            options.setDeviceName("iPhone 15")
                    .setPlatformVersion("17.2")
                    .setBundleId("com.saucelabs.mydemoapp.rn");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        }else { //browserstack
            /*options.setDeviceName("iPhone 15")
                    .setPlatformVersion("17")
                    .setBundleId("com.saucelabs.mydemoapp.rn")
                    .setApp("bs://22aa9fadc1e95af6304472c4e1bdf437e0bd10f3")
                    .setCapability("bstack:options", browserstackOptions);*/
            driver = new IOSDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"), options);
        }

        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    }

    private static void launchAndroidApp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        if(AppData.isCloud.contains("false")){
            options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                    .setPlatformName("Android")
                    .setPlatformVersion("9")
                    .setDeviceName("cpv")
                    .setAppPackage("com.swaglabsmobileapp")
                    .setAppActivity("com.swaglabsmobileapp.MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        }else { //browserstack
            /*options.setDeviceName("Google Pixel 6")
                    .setPlatformVersion("12.0")
                    .setAppPackage("com.saucelabs.mydemoapp.rn")
                    .setAppActivity(".MainActivity");*/
            driver = new AndroidDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"), options);

        }

        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

}