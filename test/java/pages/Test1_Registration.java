package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.TestCases;
import utilities.SetupDriver;

public class Test1_Registration extends SetupDriver {

	@Test(priority = 0, description = "Open PrintworksBD URL and Verify Page Title")
	public void OpenUrl() throws InterruptedException {
		getDriver().get(printworksbdUrl);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Verifying Home Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.HomePageTitle);
	}

	@Test(priority = 1, description = "Do Signup and Verify Page Title")
	public void Signup() throws InterruptedException {
		// Click on My Account Button
		getDriver().findElement(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")).click();
		System.out.println("Verifying Signup Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.SignupPageTitle);
		Thread.sleep(2000);

		getDriver().findElement(By.xpath("//a[contains(text(),'Create an Account')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,200)");
		Thread.sleep(3000);

		getDriver().findElement(By.name("email")).sendKeys("testadmin@gmail.com");
		Thread.sleep(2000);

		getDriver().findElement(By.name("password")).sendKeys("testadmin12345");
		Thread.sleep(2000);

		getDriver().findElement(By.name("register")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2, description = "Do Login and Verify Page Title")
	public void Login() throws InterruptedException {
		// Click on Login Button
		getDriver().findElement(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[5]/a[1]")).click();
		System.out.println("Verifying Login Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.LoginPageTitle);
		Thread.sleep(2000);

		getDriver().findElement(By.name("username")).sendKeys("testadmin@gmail.com");
		Thread.sleep(2000);

		getDriver().findElement(By.name("password")).sendKeys("testadmin12345");
		Thread.sleep(2000);

		getDriver().findElement(By.name("login")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3, description = "Do Logout and Verify Page Title")
	public void Logout() throws InterruptedException {
		System.out.println("Verifying Logout Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.LogoutPageTitle);
		//Assert.assertEquals(getDriver().getTitle(), TestCases.UserNameText);
		getDriver().findElement(By.xpath(
				"//body/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]"))
				.click();
		Thread.sleep(3000);

	}

}
