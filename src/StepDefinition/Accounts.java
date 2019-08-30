package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Accounts {
	
	static WebDriver webDriver;
	
	@Given("^user is on login page")
	public void user_is_on_login_page() throws Throwable {
		
        // Local location of the ChromeDriver. Update the path to match your machine as needed.
        System.setProperty(
                "webdriver.chrome.driver",
        		"/Users/dustinsison/eclipse-workspace/Software/chromedriver");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();
        
        // Go to the page
		webDriver.navigate().to("https://dustinsison.com/wp-login.php");
		
		System.out.println("Opened Chrome browser to the login page");
	}
	
	@When("^user clicks to sign-in with credentials")
	public void user_clicks_to_sign_in_with_credentials() throws Throwable {
		
	    // Select to log in using username/password
	    webDriver.findElement(By.xpath("//div/form/div/a")).click();
	        
	    System.out.println("- Clicked username/password login link");
	}
	
	@When("^user inputs \"(.*)\" in username field")
	public void user_inputs_n_in_username_field(String username) throws Throwable {
		
		// Enters username in username field
	    webDriver.findElement(By.id("user_login")).sendKeys(username);
	    
	    System.out.println("- Entered username");
	}
	
	@And("^user inputs \"(.*)\" in password field")
	public void user_inputs_n_in_password_field(String password) throws Throwable {
	
		// Enters password in password field
		webDriver.findElement(By.id("user_pass")).sendKeys(password);
		
		System.out.println("- Entered password");
	}
	
	@And("^user clicks sign-in button")
	public void user_clicks_sign_in_button() throws Throwable {
		
        // Click the Submit button
        webDriver.findElement(By.id("wp-submit")).click();
        
        System.out.println("- Clicked Submit");
	}
	
	@Then("^user should see \"(.*)\" page header")
	public void user_should_see_n_page_header(String header) throws Throwable {
        if (testHeader(header)) {
            System.out.println("Verified on " + header);
        } else {
            System.out.println("Failed; Not on " + header + " page");
        }
	}
	
	@And("^account test browser will close")
	public void user_sees_browser_close() throws Throwable {
        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
	}
	
	@Then("^user should see \"(.*)\" error message")
	public void user_should_see_n_message(String error) throws Throwable {
        if (testError(error)) {
            System.out.println("Verified expected error visible: " + error);
        } else {
            System.out.println("Failed; Expected error not visible: " + error);
        }
	}
	
	private static boolean testHeader(String header) {
        // Check whether the header equals the passed variable
        if (webDriver.findElement(By.tagName("h1")).getText()
                .equals(header)) {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
        	
            return true;
        } else {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
            return false;
        }
	}
	
	private static boolean testError(String error) {
        // Check whether the correct error is displaying
        if (webDriver.findElement(By.tagName("strong")).getText()
                .equals(error)) {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println(result + " error found");
        	
            return true;
        } else {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("Unexpected " + result + " error found");
            return false;
        }
	}
}
