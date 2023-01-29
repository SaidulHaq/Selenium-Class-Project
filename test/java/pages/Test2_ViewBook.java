package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.SetupDriver;
import utilities.TestCases;

public class Test2_ViewBook extends SetupDriver {

	@Test(priority = 0, description = "Open PrintworksBD URL and Verify Page Title Again")
	public void OpenUrl() throws InterruptedException {
		getDriver().get(printworksbdUrl);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Verifying Home Page Title Again");
		Assert.assertEquals(getDriver().getTitle(), TestCases.HomePageTitle);
	}

	@Test(priority = 1, description = "Hover Story Books, Select Crime Thrillers & Mystery then Verify Page Title")
	public void HoverStoryBooks() throws InterruptedException {
		Actions action = new Actions(getDriver());

		WebElement storybooks = getDriver().findElement(By.xpath("//header/div[3]/div[1]/div[2]/ul[1]/li[3]/a[1]"));
		action.moveToElement(storybooks).perform();
		Thread.sleep(3000);

		WebElement crimeThrillersMystery = getDriver()
				.findElement(By.xpath("//header/div[3]/div[1]/div[2]/ul[1]/li[3]/div[1]/div[1]/ul[1]/li[5]/a[1]"));
		crimeThrillersMystery.click();
		System.out.println("Verifying Book Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.BookPageTitle);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,1500)");
		Thread.sleep(2000);

		// Scroll and Next Page
		getDriver()
				.findElement(By.xpath(
						"//body/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/nav[1]/ul[1]/li[4]/a[1]"))
				.click();
		Thread.sleep(3000);
	}

	@Test(priority = 2, description = "Open Book Details Page and Verify Page Title")
	public void QuickView() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,600)");
		Thread.sleep(2000);

		getDriver().findElement(By.xpath("//h3[contains(text(),'The Black Tiger')]")).click();
		System.out.println("Verifying Book Details Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.BookDetailsPageTitle);
		Thread.sleep(2000);

	}

}
