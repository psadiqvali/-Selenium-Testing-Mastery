package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;

	@Test

	public void testFour() throws IOException, InterruptedException {

		System.out.println("ThreeTest");
		driver = initializeBrowser();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(300);
	}

	@AfterTest
	public void closingbrowser() {
		driver.close();

	}

}
