package stepdefs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.JobListingPage;
import pages.LoginPage;

public class DiceAutoApplyStepDef {
	 private static Playwright playwright;
     private static Browser browser;
     private static Page page;
     private LoginPage loginPage;
     private JobListingPage jobListingPage;
  
     private static final String DICE_EMAIL = "<Your email>";
     private static final String DICE_PASS = "<Your password>";
	 private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36";
     
	@Given("the user is logged in to Dice")
	public void the_user_is_logged_in_to_dice() {
		playwright = Playwright.create();
		
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().
        		setHeadless(true));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setUserAgent(USER_AGENT));
        
//        page = browser.newPage();
        page = context.newPage();
        
        page.navigate("https://www.dice.com/dashboard/login?redirectUrl=%2Fhome-feed");
	   
        loginPage = new LoginPage(page);
        loginPage.enterEmail(DICE_EMAIL);
        loginPage.clickNextButton();
        loginPage.enterPassword(DICE_PASS);
        loginPage.clickLoginButton();
        
//        Thread.sleep(30000L); // Wait for login to complete, adjust as necessary)
	}
	

	@When("filter the jobs as below for the {string}")
	public void filter_the_jobs_as_below_for_the(String jobQuery, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		jobListingPage = new JobListingPage(page);
		jobListingPage.navigateToFilterPane(jobQuery);
		
		
	}



	@Then("apply for all the jobs listed in the list")
	public void apply_for_all_the_jobs_listed_in_the_list() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		jobListingPage.applyJobs();
		
	}



}
