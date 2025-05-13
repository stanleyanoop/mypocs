package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    // Locators for the login page elements
    @FindBy(xpath = "/html/body/app-root/app-login-ui/div/div[1]/tr/td[2]/input") // Replace with the actual ID or locator
    private WebElement usernameField;

    @FindBy(xpath = "/html/body/app-root/app-login-ui/div/div[2]/tr/td[2]/input") // Replace with the actual ID or locator
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/app-root/app-login-ui/div/div[3]/button[1]") // Replace with the actual ID or locator
    private WebElement loginButton;

    @FindBy(id = "error") // Replace with the actual ID or locator
    private WebElement errorMessage;
    
    @FindBy(tagName = "title") // Replace with the actual ID or locator")
    private WebElement title;
    
    // Constructor to initialize the elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to enter username
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        loginButton.click();
    }

    // Method to get the error message text
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
    //Method 
	public String getTitle() {
		return driver.getTitle();
	}
}
