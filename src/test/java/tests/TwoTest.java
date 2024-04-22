package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;

	@Test
	public void testTwo() throws IOException, InterruptedException {
		System.out.println("TwoTest");
		driver = initializeBrowser();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(300);

	}

	@AfterTest
	public void closedriver() {
		driver.close();

	}
}