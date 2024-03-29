package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Homepage {

	static WebDriver webDriver;
	
	@Given("^user is on homepage")
	public void user_is_on_homepage() throws Throwable {
		
        // Local location of the ChromeDriver. Update the path to match your machine as needed.
        System.setProperty(
                "webdriver.chrome.driver",
        		"/Users/dustinsison/eclipse-workspace/Software/chromedriver");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();
        
        // Go to the page
		webDriver.navigate().to("https://dustinsison.com/");
		
		System.out.println("Opened Chrome browser to homepage");
	}
	
	@Then("^user should see homepage header")
	public void user_should_see_homepage_header() throws Throwable {
        if (testHeader()) {
            System.out.println("- Verified on Home page");
        } else {
            System.out.println("- Failed; Not on Home page");
        }
	}
	
	@And("^user should see expected homepage header content")
	public void user_sees_expected_homepage_header_content() throws Throwable {
		
		// Gives five seconds for the home page header content to load
		Thread.sleep(5000);
		
		 if (webDriver.findElement(By.className("fluid-width-video-wrapper")).isDisplayed()) {
	        	System.out.println("- HD header video is displaying");
	        } else {
	        	System.out.println("- HD header video is not displaying");
	        }
	}
	
	@And("^homepage test browser will close")
	public void user_sees_browser_close() throws Throwable {
        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
        System.out.println("Test completed. Closing browser.");
	}
	
	private static boolean testHeader() {
        // Check whether the h1 equals passed variable
        if (webDriver.findElement(By.tagName("h1")).getText()
                .equals("Welcome")) {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
        	
            return true;
        } else {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
            return false;
        }
	}
}