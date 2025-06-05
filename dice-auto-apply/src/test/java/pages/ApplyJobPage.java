
package pages;

import com.microsoft.playwright.Page;

public class ApplyJobPage {

    private final Page page;

    // Constructor
    public ApplyJobPage(Page page) {
        this.page = page;
    }

    // Method to verify if the resume is pre-populated
    public String getResumeText() {
        return page.locator("#resumeField").inputValue(); // Replace with the actual selector
    }

    // Method to click the submit button
    public void clickSubmitButton() {
        page.locator("#submitButton").click(); // Replace with the actual selector
    }
}
