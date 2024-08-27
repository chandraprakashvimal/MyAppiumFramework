package base;

import driver.AppFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        AppFactory.launchApp();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Utility.getScreenshot(result.getTestName());
        }
    }

    @BeforeSuite
    public void beforeSuite(){
        if(AppData.isCloud.contains("false")){
            base.AppiumServer.start();
        }
    }

    @AfterSuite
    public void serverStop(){
        base.AppiumServer.stop();
    }
}
