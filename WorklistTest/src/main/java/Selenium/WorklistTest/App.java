package Selenium.WorklistTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://localhost:4200");
        System.out.println(driver.getTitle());
        WebElement login = driver.findElement(By.xpath("/html/body/app-root/app-login-ui/div/div[1]/tr/td[2]/input"));
        login.sendKeys("test");
        WebElement pass = driver.findElement(By.xpath("/html/body/app-root/app-login-ui/div/div[2]/tr/td[2]/input"));
        pass.sendKeys("testPwd");
        
       WebElement signInBtn = driver.findElement(By.xpath("/html/body/app-root/app-login-ui/div/div[3]/button[1]"));
       signInBtn.click();

    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Hello World!" );
        driver.quit();
    }
}
