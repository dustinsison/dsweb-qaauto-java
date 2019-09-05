package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Projects {

	static WebDriver webDriver;
	
	@Given("^user is on \"(.*)\" project page")
	public void user_is_on_n_project_page(String project) throws Throwable {
		
        // Local location of the ChromeDriver. Update the path to match your machine as needed.
        System.setProperty(
                "webdriver.chrome.driver",
        		"/Users/dustinsison/eclipse-workspace/Software/chromedriver");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();
        
        // Go to the page
		webDriver.navigate().to("https://dustinsison.com/" + project);
		
		System.out.println("Opened Chrome browser to specified project page");
	}
	
	@Then("^user should see \"(.*)\" project page header")
	public void user_should_see_n_project_page_header(String project) throws Throwable {
        if (testHeader(project)) {
            System.out.println("Verified on " + project);
        } else {
            System.out.println("Failed; Not on " + project + " page");
        }
	}
	
	@And("^project page test browser will close")
	public void user_sees_browser_close() throws Throwable {
        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
	}
	
	private static boolean testHeader(String project) {
        // Check whether the h1 equals passed variable
        if (webDriver.findElement(By.tagName("h1")).getText()
                .equals(project)) {
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