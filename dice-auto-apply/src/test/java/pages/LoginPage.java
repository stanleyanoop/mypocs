
package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private final Page page;
//    private static final String EMAIL_ID_FLD = "xpath://*[@id=\"react-aria-:Rd7rkqfncq:\"]";
    private static final String EMAIL_ID_FLD = "email";
    private static final String EMAIL_ID_NXT_BTN = "xpath://*[@id=\"react-aria-:R2l7rkqfncq:\"]";
    private static final String PASSWORD_FLD = "xpath=/html/body/div[4]/div/div/div[2]/div/form/div/div/input";
    private static final String PASSWORD_NXT_BTN = "xpath=/html/body/div[4]/div/div/div[2]/div/form/button";
    
    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Methods for the first screen (email ID)
    public void enterEmail(String email) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().
        		setName(EMAIL_ID_FLD)).fill(email);
    }

    public void clickNextButton() {
//        page.locator(EMAIL_ID_NXT_BTN).click(); // Replace with the actual selector
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().
				setName("Continue")).click(); // Adjust the name as
																								// necessary
    }

    // Methods for the second screen (password)
    public void enterPassword(String password) {
        page.locator(PASSWORD_FLD).fill(password); // Replace with the actual selector
    }

    public void clickLoginButton() {
        page.locator(PASSWORD_NXT_BTN).click(); // Replace with the actual selector
    }
}
