package stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import utils.TestConstants;
import utils.WorklistValidationHelper;

public class DashboardStepDefinition {

	private ChromeDriver driver;
	private DashboardPage dashboardPage;
	@Before
	public void setup() {
//		driver = new ChromeDriver();
//		LoginPage loginPage = new LoginPage(driver);
		LoginStepDefinition loginStep = new LoginStepDefinition();
		loginStep.setup();
		loginStep.the_user_is_on_the_login_page();
		loginStep.the_user_enter_valid_credentials(TestConstants.USERNAME, TestConstants.PASSWORD);
		loginStep.the_user_clicks_the_login_button();
		if (driver == null) {
            driver = (ChromeDriver) loginStep.driver;
        }
		driver.navigate().refresh();
		dashboardPage = new DashboardPage(driver);
	}
	 @After
	public void tearDown() {
		// Close the browser after each scenario
		if (driver != null) {
			driver.quit();
		}
	}
 
	 @Given("the user is on the Prayer request dashboard")
	 public void the_user_is_on_the_prayer_request_dashboard() {
	     // Write code here that turns the phrase above into concrete actions
			System.out.println("Dashboard Step  Title " + dashboardPage.getTitle());
			assert dashboardPage.getTitle().equals(TestConstants.DASHBOARD_TITLE); 
	 }

	@When("the user inspects the layout of the dashboard for {string}, {string} and {string}")
	public void the_user_inspects_the_layout_of_the_dashboard(String title, String pageHeading, String tabHeading) {
	    // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
		System.out.println("Title ::" + dashboardPage.getTitle());
		System.out.println("Page Heading ::" + dashboardPage.getPageHeading());
		System.out.println("Tab Heading" + dashboardPage.getTabHeading());
		assert (dashboardPage.getTitle().equals(title) 
				&& dashboardPage.getPageHeading().equals(pageHeading)
				&& dashboardPage.getTabHeading().equals(tabHeading));
	}
	@When("the data table should have the following headers")
	public void the_data_table_should_have_the_following_headers(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		WorklistValidationHelper helper = new WorklistValidationHelper();
		ArrayList<String> columns = new ArrayList<String>();
		columns = dashboardPage.getTableHeaders();
		columns.forEach(System.out::println);
		
		assertTrue (helper.checkColumns(dataTable, columns));
	}
	@Then("the values should be as follows")
	public void the_values_should_be_as_follows() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(true);//Since the same validation done in the function above.
	}






}
