package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class AppDriver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver1) {
        driver.set(driver1);
    }

    private AppDriver() {

    }
    static AppDriver instance;
    public static AppDriver getInstance(){
        if(instance==null){
            instance = new AppDriver();
        }
        return instance;
    }

    public static WebDriver getCurrentDriver(){
        return getInstance().getDriver();
    }
}