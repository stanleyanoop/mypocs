
package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JobListingPage {

	private static final String SEARCH_BOX = 
			"xpath=/html/body/div[3]/div/div[2]/form/div/div[1]/div/input"; // Replace with the actual selector
//	private static final String FILTER_LINK = "xpath=/html/body/div[4]/div/div[2]/div[1]/div[2]/div[1]";
	private static final String FILTER_LINK = "xpath=/html/body/div[4]/div/div[2]/div[1]/div[2]/div[1]/button/span";//Older xpath
	private static final String TODAY_RADIO = 
			"xpath=/html/body/div[4]/div/div[2]/div[2]/div[2]/div/section/div/div[2]/div/form/div/div/label[1]";
//	private static final String TODAY_RADIO = 
//			"xpath=/html/body/div[4]/div/div[1]/div[2]/div[2]/div/section/div/div[2]/div/form/div/div/label[3]";
	private static final String CONTRACT_CHECKBOX = 
			"xpath=/html/body/div[4]/div/div[2]/div[2]/div[2]/div/section/div/div[4]/div/form/label[3]";
	private static final String THIRD_PARTY_CHECKBOX = 
			"xpath=/html/body/div[4]/div/div[2]/div[2]/div[2]/div/section/div/div[4]/div/form/label[4]";
	private static final String RECRUITER_CHECKBOX = 
			"xpath=/html/body/div[4]/div/div[2]/div[2]/div[2]/div/section/div/div[6]/div/form/label[2]";
	private static final String JOB_LISTING_CONTAINER = "xpath=/html/body/div[4]/div/div[3]/div";
	private static final String EASY_APPLY_BUTTON = 
			"xpath=/html/body/div[3]/div/main/div[2]/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[2]/apply-button-wc//apply-button/div/button";
    private static final String FILE_OPENER =
    		"xpath=/html/body/div[9]/div/div[1]/div[1]/div/div[2]/div/div";
	private final Page page;
	private String jobQuery = "";
	private String filePath = "resources/Covering Letter.pdf";

    // Constructor
    public JobListingPage(Page page) {
        this.page = page;
//        this.page.setDefaultTimeout(5000); // Set a default timeout of 60 seconds
    }

	public void navigateToFilterPane(String jobQuery) {
		this.jobQuery  = jobQuery;
		Locator searchBox = page.locator(SEARCH_BOX);
		searchBox.fill(jobQuery); // Example search term, adjust as necessary
		page.keyboard().press("Enter");
		page.locator(FILTER_LINK).click();
//		Locator filter = page.locator(FILTER_LINK);
//		filter.filter(new Locator.FilterOptions().setHasText("All filters"))
//			.filter(new Locator.FilterOptions().setHas(page.getByRole(AriaRole.BUTTON)));
//		filter.filter(new Locator.FilterOptions().setHas(
//				page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("All filters")))).click();
		page.locator(TODAY_RADIO).click();
		page.locator(CONTRACT_CHECKBOX).click();
		page.locator(THIRD_PARTY_CHECKBOX).click();
		page.locator(RECRUITER_CHECKBOX).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply filters")).click(); // Adjust the name as
																								// necessary
		// necessary
	}
    // Methods for interacting with the filter pane
    public void applyJobs() {
    	Locator parentDiv = page.locator(JOB_LISTING_CONTAINER);
    	Locator jobListings = parentDiv.getByRole(AriaRole.LINK);
    	System.out.println("number of job listings ->" + jobListings.count());
		for (Locator jobListing : jobListings.all()) {
			System.out.println("Job Listing: " + jobListing.textContent());
			if (jobListing.textContent() != null && jobListing.textContent().equals("Easy Apply")) {
				System.out.println("Applying for job: " + jobListing.textContent());
				applyJob(jobListing);
			} else {
				System.out.println("Skipping empty job listing locator which is not easy apply button.");
				continue;
			}
		}
    }

    private void applyJob(Locator jobListing) {
		// TODO Auto-generated method stub
		BrowserContext context = page.context();
		Page newPage = context.waitForPage(() -> {
			jobListing.click();
		});
		newPage.setDefaultTimeout(5000); // Set a default timeout of 5 seconds
		System.out.println("old page title -> " + page.title());
		System.out.println("new page title -> " + newPage.title());
		try {
			newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Easy Apply")).click(); // Adjust the name as
//			if (jobQuery != null && jobQuery.toLowerCase().contains("java")) {
//				Page popup = context.waitForPage(() -> {
//					newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Replace")).click(); // Adjust
//																													// the
//																													// name
//																													// as
//				});
//				popup.locator(FILE_OPENER).click();
//				Thread.sleep(30000L);
//
//				
//				// Adjust the name as
//
//			}
			// For file upload popup
//			Page popup = context.waitForPage(() -> {
//				newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload Cover Letter")).click(); // Adjust the name as
//			});//newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upload Cover Letter")).click(); // Adjust the name as
//			Thread.sleep(10000L);
//			popup.locator("input[type='file']").setInputFiles(Paths.get(filePath)); // Adjust the file path as necessary);
//			Thread.sleep(10000L);
			newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click(); // Adjust the name as
			newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click(); // Adjust the name as
            System.out.println("Job applied successfully!");		
    		newPage.close();
			Thread.sleep(3000L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("FAIL (Proceeding with next submission) :::> Submission Failed for job : " + newPage.title());
			System.out.println("DETAILS :::> Error applying for job: " + jobListing.textContent());
			
			e.printStackTrace();
    		
			newPage.close();
//			System.exit(0);
		}
	}

	// Method to get the list of job listings
    public List<String> getJobListings() {
        return page.locator(".jobListing").allTextContents(); // Replace with the actual selector
    }
}
