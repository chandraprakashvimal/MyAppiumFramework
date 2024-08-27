package base;

import driver.AppDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Utility {
    public static String getScreenshot(String imagename) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot) AppDriver.getCurrentDriver();
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshot/"+imagename+".jpg";
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }
}
