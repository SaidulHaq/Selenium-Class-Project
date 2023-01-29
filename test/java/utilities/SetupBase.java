//allure generate ./allure-results --clean
//allure open ./allure-report
//mvn test -Dtestfile=testng.xml

package utilities;

import static utilities.SetupDriver.getDriver;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Allure;

public class SetupBase {
	public String printworksbdUrl = "https://www.printworksbd.com/";
	public String bookpageUrl = "https://www.printworksbd.com/product/the-black-tiger/";
	
	public void takeScreenShot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
	}
	
}
