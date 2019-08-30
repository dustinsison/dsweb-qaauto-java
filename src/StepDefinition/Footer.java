package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Footer {
	
	static WebDriver webDriver;

	@Given("^user is on the homepage")
	public void user_is_on_the_homepage() throws Throwable {
		
        // Local location of the ChromeDriver. Update the path to match your machine as needed.
        System.setProperty(
                "webdriver.chrome.driver",
        		"/Users/dustinsison/eclipse-workspace/Software/chromedriver");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();
        
        // Go to the home page
		webDriver.navigate().to("https://dustinsison.com/");
		
		System.out.println("Opened Chrome browser to homepage");
	}
	
	@When("^user clicks \"(.*)\" footer link")
	public void user_clicks_footer_link(String nav) throws Throwable {
		
	    // Select listed footer link
	    webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li/a[normalize-space(text())='"+nav+"']")).click();
	        
	    System.out.println("- Clicked " + nav + " navigation link");
	}
	
	@Then("^user should see \"(.*)\" profile")
	public void user_should_see_n_profile_page(String profile) throws Throwable {
		if (profile.equals("Twitter")) {
			
			// Define Expected title and get actual page title
			String expectedTitle = "Dustin Sison (@XMasterPrime) | Twitter";
			String actualTitle = webDriver.getTitle();
			
			
			// Verifies if the displayed page is the right Twitter profile
			if (expectedTitle.equals(actualTitle)) {
				System.out.println("- Twitter profile page verified");
			} else {
				System.out.println("- Twitter profile page not verified; please manually check this link");
				System.out.println("-- " + actualTitle);
			}
			
		} else if (profile.equals("GitHub")){
			
			// Define Expected title and get actual page title
			String expectedTitle = "dustinsison (Dustin Sison) · GitHub";
			String actualTitle = webDriver.getTitle();
			
			// Verifies if the displayed page is the right GitHub profile
			if (expectedTitle.equals(actualTitle)) {
				System.out.println("- GitHub profile page verified");
			} else {
				System.out.println("- GitHub profile page not verified; please manually check this link");
				System.out.println("-- " + actualTitle);
			}
			
		} else if (profile.equals("LinkedIn")){
			
			// Gives a second for the LinkedIn page to load
			Thread.sleep(1000);
			
			// Define Expected title and get actual page title
			String expectedTitle = "Dustin Sison - Automation Engineer - Moovweb | LinkedIn";
			String actualTitle = webDriver.getTitle();
			
			// Verifies if the displayed page is the right LinkedIn profile
			if (expectedTitle.equals(actualTitle)) {
			System.out.println("- LinkedIn profile page verified");
			} else if (actualTitle.equals("LinkedIn: Log In or Sign Up ")){
				System.out.println("- LinkedIn has detected that the browser is being automated, "
						+ "and is requiring you to sign-in to view this profile. Please manually check this link");
			} else {
				System.out.println("- LinkedIn profile page not verified; please manually check this link");
				System.out.println("-- " + actualTitle);
			}
			
		} else {
			System.out.println("- Unexpected profile page requested; unable to verify");
		}
	}
	
	@Then("^user sees expected footer content")
	public void user_sees_footer_content() throws Throwable {
		if (testFooter()) {
			System.out.println("- Footer displaying expected content");
		} else {
			System.out.println("- Footer not displaying expected content");
		}
	}
	
	@And("^browser goes back")
	public void browser_back() throws Throwable {
        // The browser goes back one page
        webDriver.navigate().back();
        
        System.out.println("- Going back to dustinsison.com");
	}
	
	@And("^footer test browser will close")
	public void user_sees_browser_close() throws Throwable {
        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
	}
	
	@When("^user sees expected Email footer link")
	public void user_sees_expected_email_link() throws Throwable {
		
		// Pulls the Email link in the footer
		String mailto = (webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[4]/a")).getAttribute("href"));
		
		// Verifies that the email link is in the expected "mailto" format
		if (mailto.equals("mailto:dsison34@gmail.com")) {
			System.out.println("- Seeing expected email link: " + mailto);
		} else {
			System.out.println("- Error - Unexpected link: " + mailto);
		}
	}
		
	private static boolean testFooter() {
        // Check whether the footer is displaying the expected links
        if (webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[1]/a")).getText().equals("Twitter") 
        	& (webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[2]/a")).getText().equals("GitHub"))
        	& (webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[3]/a")).getText().equals("LinkedIn"))
        	& (webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[4]/a")).getText().equals("Email"))
        		) {
        	String result1 = webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[1]/a")).getText();
        	String result2 = webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[2]/a")).getText();
        	String result3 = webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[3]/a")).getText();
        	String result4 = webDriver.findElement(By.xpath("//ul[@id='footer-menu']/li[4]/a")).getText();
        	System.out.println("- Footer links visible: " + result1 + ", " + result2 + ", " + result3 + ", " + result4);
            return true;
        } else {
        	System.out.println("- Footer content not matching defined expected test results. Please verify the footer manually");
            return false;
        }
	}
}
