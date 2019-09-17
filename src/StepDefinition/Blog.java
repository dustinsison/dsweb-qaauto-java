package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Blog {

	static WebDriver webDriver;
	
	@Given("^user is on \"(.*)\" blog page")
	public void user_is_on_blogpage(String blog) throws Throwable {
		
        // Local location of the ChromeDriver. Update the path to match your machine as needed.
        System.setProperty(
                "webdriver.chrome.driver",
        		"/Users/dustinsison/eclipse-workspace/Software/chromedriver");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();
        
        // Go to the page
		webDriver.navigate().to("https://dustinsison.com/category" + blog);
		
		System.out.println("Opened Chrome browser to specified blog page");
	}
	
	@When("^user clicks first blog title")
	public void user_clicks_first_blog_title() throws Throwable {
		
		// Gives a second for the blog listings to load
		Thread.sleep(1000);
		
	    // Select navigation link to first blog page
	    webDriver.findElement(By.xpath("//header/h2[@class='entry-title'][1]/a")).click();
	        
	    System.out.println("- Clicked first blog title link");
	}
	
	@Then("^user should see \"(.*)\" blog listing page")
	public void user_should_see_blog_listing(String blog) throws Throwable {
		
		// Gives a second for the page to load
		Thread.sleep(1000);
		
        if (testHeader(blog)) {
            System.out.println("- Verified on " + blog + " blog listing page");
        } else {
            System.out.println("- Failed; Not on expected blog listing page");
        }
	}
	
	@Then("^user should see blog entry page")
	public void user_should_see_blog_entry() throws Throwable {
        if (testBlogEntry()) {
            System.out.println("- Verified on blog entry page");
        } else {
            System.out.println("- Failed; Not on blog entry page");
        }
	}
	
	@And("^user clicks on \"(.*)\" blog link")
	public void user_clicks_on_n_blog_link(String blog) throws Throwable {
		
	    // Select listed blog link in navigation menu
	    webDriver.findElement(By.xpath("//ul[@id='primary-menu']/li/a[normalize-space(text())='"+blog+"']")).click();
	        
	    System.out.println("- Clicked " + blog + " blog link");
	}
	
	@And("^blog test browser will close")
	public void user_sees_browser_close() throws Throwable {
        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
        System.out.println("Test completed. Closing browser.");
	}
	
	private static boolean testHeader(String title) {
        // Check whether the h1 equals passed variable
        if (webDriver.findElement(By.tagName("h1")).getText()
                .equals(title)) {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
            return true;
        } else {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
            return false;
        }
	}
	
	private static boolean testBlogEntry() {
        // Check whether the h1 equals passed variable
        if (webDriver.findElement(By.className("entry-title")).getText().isEmpty()) {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
            return false;
        } else {
        	String result = webDriver.findElement(By.tagName("h1")).getText();
        	System.out.println("- Current page: " + result);
            return true;
        }
	}
}