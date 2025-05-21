package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestConstants;
import utils.testdata.PrayerRequestData;


public class DashboardPage {
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(tagName = "title") // Replace with the actual ID or locator
	private WebElement title;
	
	@FindBy(tagName = "h2")
	private WebElement pageHeading;

	@FindBy(tagName = "h3")
	private WebElement tabHeading;
	
	@FindBy(xpath = "/html/body/app-root/app-home-ui/div/div/table/thead/tr/th[1]/div/div[1]")
	private WebElement id;

	@FindBy(xpath = "/html/body/app-root/app-home-ui/div/div/table/thead/tr/th[2]/div/div[1]")
	private WebElement prayingFor;

	@FindBy(xpath = "/html/body/app-root/app-home-ui/div/div/table/thead/tr/th[3]/div/div[1]")
	private WebElement request;

	@FindBy(xpath = "/html/body/app-root/app-home-ui/div/div/table/thead/tr/th[4]/div/div[1]")
	private WebElement dateReported;

	@FindBy(xpath = "/html/body/app-root/app-home-ui/div/div/table/thead/tr/th[5]/div/div[1]")
	private WebElement dateAnswered;

	@FindBy(xpath = "/html/body/app-root/app-home-ui/div/div/table/thead/tr/th[6]/div/div[1]")
	private WebElement status;
	
	@FindBy(xpath = "/html/body/app-root/app-home-ui/div/div/table/tbody")
	private WebElement prayerRequestTable;

	/**
	 * Returns the title of the page.
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}
	/**
	 * This method returns the page heading
	 * @return
	 */
	public String getPageHeading() {
		return pageHeading.getText();
	}
	
	/**
	 * This method returns the table heading
	 * @return
	 */
	public String getTabHeading() {
		return tabHeading.getText();
	}

	/**
	 * This method returns the prayer request table headers in a List
	 * @return
	 */
	public ArrayList<String> getTableHeaders() {
		// TODO Auto-generated method stub
		java.util.ArrayList<String> headers = new ArrayList<String>();
		headers.add(id.getText());
		headers.add(prayingFor.getText());
		headers.add(request.getText());
		headers.add(dateReported.getText());
		headers.add(dateAnswered.getText());
		headers.add(status.getText());
		return headers;
	}
	
	/**
	 * This method returns the number of prayer requests listed on the page
	 * @return
	 */
	public int getPrayerRequestCount() {
		List rows = prayerRequestTable.findElements(By.tagName("tr"));
		return rows == null ? 0 : rows.size();
	}

	/**
	 * This method returns the rendered prayer requests in a list 
	 * @return
	 */
	public List<PrayerRequestData> getPrayerRequestTableData(){
		List<PrayerRequestData> requests = new ArrayList<PrayerRequestData>();
		for (int i = 1; i <= getPrayerRequestCount(); i++) {
			String cellXpath = 
					"/html/body/app-root/app-home-ui/div/div/table/tbody/tr[" + i + "]";
			requests.add(getPrayerRequestData(cellXpath));
		}
		return requests;
	}

	public void clickTableHeader(String header) {
		switch (header) {
		case TestConstants.TAB_HEAD_ID:
			id.click();
			break;
		case TestConstants.TAB_HEAD_WHO:
			prayingFor.click();
			break;
		case TestConstants.TAB_HEAD_REQUEST:
			request.click();
			break;
		case TestConstants.TAB_HEAD_DATE_REPORTED:
			dateReported.click();
			break;
		case TestConstants.TAB_HEAD_DATE_ANSWERED:
			dateAnswered.click();
			break;
		case TestConstants.TAB_HEAD_STATUS:
			status.click();
			break;
		default:
			System.out.println("Invalid header: " + header);
		}
	}
	/**
	 * This method extracts the prayer request data from the UI and sets 
	 * it onto a java object
	 * @param cellXpath
	 * @return
	 */
	private PrayerRequestData getPrayerRequestData(String cellXpath) {
		// TODO Auto-generated method stub
		PrayerRequestData rowData = new PrayerRequestData();
//		WebElement row = driver.findElement(By.xpath(cellXpath));
		rowData.setId(driver.findElement(By.xpath(cellXpath + "/td[" + 1 + "]")).getText());
		rowData.setForWho(driver.findElement(By.xpath(cellXpath + "/td[" + 2 + "]")).getText());
		rowData.setRequest(driver.findElement(By.xpath(cellXpath + "/td[" + 3 + "]")).getText());
		rowData.setRequestDate(driver.findElement(By.xpath(cellXpath + "/td[" + 4 + "]")).getText());
		rowData.setAnsweredDate(driver.findElement(By.xpath(cellXpath + "/td[" + 5 + "]")).getText());
		rowData.setStatus(driver.findElement(By.xpath(cellXpath + "/td[" + 6 + "]")).getText());
		return rowData;
	}
	
}
