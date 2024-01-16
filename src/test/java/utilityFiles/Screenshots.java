package utilityFiles;

import java.io.File;
import java.io.IOException;
import testBase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class Screenshots extends BaseClass{
	//Whole Page Screenshot
	public void ScreenShot(String path) throws IOException {
		String p = System.getProperty("user.dir")+"\\screenshots\\";
		p+=path;
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(p);
		FileUtils.copyFile(src, trg);
	}
	//Element wise Screenshot
	public void ScreenShotElementwise(String path, WebElement e) throws IOException {
		String p = System.getProperty("user.dir")+"\\screenshots\\";
		p+=path;
		File src = e.getScreenshotAs(OutputType.FILE);
		File trg = new File(p);
		FileUtils.copyFile(src, trg);
	}
}
