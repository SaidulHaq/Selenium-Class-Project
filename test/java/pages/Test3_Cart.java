package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utilities.SetupDriver;
import utilities.TestCases;

public class Test3_Cart extends SetupDriver {

	@Test(priority = 0, description = "Open Book Details Page URL and Verify Page Title")
	public void OpenUrl() throws InterruptedException {
		getDriver().get(bookpageUrl);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Verifying Book Details Page Title Again");
		Assert.assertEquals(getDriver().getTitle(), TestCases.BookDetailsPageTitle);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,150)");
		Thread.sleep(2000);
	}

	@Test(priority = 1, description = "Open Cart and Verify Page Title")
	public void ViewCart() throws InterruptedException {
		getDriver().findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
		Thread.sleep(3000);

		// Cart icon
		getDriver().findElement(By.xpath("//header/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]")).click();
		Thread.sleep(3000);

		getDriver().findElement(By.xpath("//a[contains(text(),'VIEW CART')]")).click();
		System.out.println("Verifying Cart Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.CartPageTitle);
		Thread.sleep(3000);

		getDriver().findElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 2, description = "Billing Form Fill up and Verify Page Title")
	public void BillingDetails() throws InterruptedException {
		System.out.println("Verifying Checkout Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.CheckoutPageTitle);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,460)");
		Thread.sleep(2000);

		getDriver().findElement(By.name("billing_first_name")).sendKeys("Test");
		Thread.sleep(3000);

		getDriver().findElement(By.name("billing_last_name")).sendKeys("Admin");
		Thread.sleep(3000);

		getDriver().findElement(By.name("billing_address_1")).sendKeys("Petaling Jaya");
		Thread.sleep(3000);

		getDriver().findElement(By.name("billing_postcode")).sendKeys("0000");
		Thread.sleep(3000);

		getDriver().findElement(By.name("billing_phone")).sendKeys("0123456789");
		Thread.sleep(3000);

		getDriver().findElement(By.name("billing_email")).sendKeys("testadmin@gmail.com");
		Thread.sleep(3000);

		getDriver().findElement(By.name("order_comments")).sendKeys("Urgent Test Delivery...");
		Thread.sleep(3000);

		getDriver().findElement(By.name("woocommerce_checkout_place_order")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3, description = "Clear Cart, Go Back to Home Page and Verify Page Title")
	public void ClearCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(2000);

		// Cart icon
		getDriver().findElement(By.xpath("//header/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]")).click();
		Thread.sleep(3000);

		getDriver().findElement(By.className("remove")).click();
		Thread.sleep(3000);

		getDriver().findElement(By.xpath("//header/div[3]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
		System.out.println("Verifying Home Page Title");
		Assert.assertEquals(getDriver().getTitle(), TestCases.HomePageTitle);
		Thread.sleep(3000);

	}

}
