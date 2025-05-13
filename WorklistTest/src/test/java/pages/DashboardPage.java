package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

	//Returns the title of the page.
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getPageHeading() {
		return pageHeading.getText();
	}
	
	public String getTabHeading() {
		return tabHeading.getText();
	}

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

}
