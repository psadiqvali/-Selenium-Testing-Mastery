package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class Login extends Base {
	WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;
	LandingPage landingPage;

	@Given("^Open any Browser$")
	public void open_any_browser() throws IOException {
		driver = initializeBrowser();

	}

	@And("^Navigate to Login page$")
	public void navigate_to_login_page() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		Thread.sleep(3000);
	}

	@When("^User  enters username as\"([^\"])\" ar and password as \"([^\"])\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email,
			String password) {
		loginPage = new LoginPage(driver);
		loginPage.emailAddressTextField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);
	}

	@Then("^Verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		
		loginPage.loginButton().click();

	}

	@And("^User clicks on Login buttons")
	public void user_clicks_on_login_button() {
		 accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.editYourAccountInformation().isDisplayed());
	}
	@After 
	public  void closeBroswer() {
		driver.close();
		
	}

}