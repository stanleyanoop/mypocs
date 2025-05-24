package stepdefs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import utils.testdata.PrayerRequestData;

public class DashboardStepDefinition {

	protected ChromeDriver driver;
	private DashboardPage dashboardPage;
	private WorklistValidationHelper helper = new WorklistValidationHelper();
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

	@When("the user checks the Prayer Request List table")
	public void the_user_checks_the_prayer_request_list_table() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(true);//Since the validation done in the next step .
	}
	@Then("the user should see the below data")
	public void the_user_should_see_the_below_data(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
//		List<Map<String, String>> refData = new ArrayList<Map<String, String>>();
		final List<Map<String, String>> refData = dataTable.asMaps(String.class, String.class);
		System.out.println("table rows on page : " + dashboardPage.getPrayerRequestCount());
		System.out.println("Iterating the keys and values" + refData.size());
		refData.forEach(data -> System.out.println(data));
		boolean assertFlag = refData.stream().allMatch(data -> {
			boolean flag = dashboardPage.getPrayerRequestTableData().stream().anyMatch(uiData -> {
				if (uiData.getId().equals((String)data.get("ID"))) {
					WorklistValidationHelper helper = new WorklistValidationHelper();
					return helper.validateRequestRow(data, uiData);
						
				}
				return false;
			});
			return flag;
		});
		System.out.println("Assertion Flag - " + assertFlag);
		assertTrue (assertFlag);
	}


	@When("the user clicks on {string} column")
	public void the_user_clicks_on_column(String header) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Header to click >>" + header);
		dashboardPage.clickTableHeader(header);
//		helper.sleep(10000L);
	}
	@Then("the data table is sorted based on the {string} column")
	public void the_data_table_is_sorted_based_on_the_column(String header) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			List<PrayerRequestData> data = new ArrayList<PrayerRequestData>();
			data = dashboardPage.getPrayerRequestTableData();
			assertTrue(helper.checkSortedData(data, header));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
//		assertTrue(false);
	}










}
