package stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utils.TestConstants;

public class LoginStepDefinition {
	WebDriver driver;// = new ChromeDriver();
    LoginPage loginPage;// = new LoginPage(driver);
    DashboardPage dashboardPage;
    @Before
	public void setup() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}
	
    @After
	public void tearDown() {
		// Close the browser after each scenario
		if (driver != null) {
			driver.quit();
		}
	}
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
        try {
			driver.get(TestConstants.LOGIN_PAGE); // Replace with the actual URL
			System.out.println("Title ==>" + loginPage.getTitle());
			assert loginPage.getTitle().equals(TestConstants.LOGIN_TITLE); // Replace with the actual title of the login page
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assert false;
		}
	}

	@When("the user enter valid credentials {string} and {string}")
	public void the_user_enter_valid_credentials(String userName, String passWord) {
	    // Write code here that turns the phrase above into concrete actions

		loginPage.enterUsername(userName);
        loginPage.enterPassword(passWord);
     }

	@When("the user click the login button")
	public void the_user_clicks_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginButton();
        sleep(2000L);
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().refresh();
		dashboardPage = new DashboardPage(driver);
		System.out.println("Title of the landing page" + driver.getTitle());
		assert dashboardPage.getTitle().equals(TestConstants.DASHBOARD_TITLE); // Replace with the actual title of the login page
	}

	@When("the user enter invalid credentials {string} and {string}")
	public void the_user_enter_invalid_credentials(String userName, String passWord) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername(userName);
        loginPage.enterPassword(passWord);
	}

	@Then("the user should see an error message")
	public void the_user_should_see_an_error_message() {
	    // Write code here that turns the phrase above into concrete actions
        String errorMessage = loginPage.getErrorMessage();
        System.out.println("Error message: " + errorMessage);
        assertTrue(errorMessage.equals(TestConstants.ERROR_MESSAGE)); // Replace with the actual error message
	}
	
	private void sleep (Long millis) {
        try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
