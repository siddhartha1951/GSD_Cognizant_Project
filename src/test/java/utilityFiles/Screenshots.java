package utilityFiles;

import java.io.File;
import java.io.IOException;
import testBase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshots extends BaseClass{
	public static void screenshot(String scName) throws IOException{
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File trg = new File("C:\\Users\\2303462\\eclipse-workspace\\Human Resource Management\\Screenshots\\ss1.png");
    	FileUtils.copyFile(src,trg);
    }
}
