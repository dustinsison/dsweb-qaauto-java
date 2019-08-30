package StepDefinition;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigationMenu {
	
	static WebDriver webDriver;
	
	@Given("^user is on any page")
	public void user_is_on_any_page() throws Throwable {
		
        // Local location of the ChromeDriver. Update the path to match your machine as needed.
        System.setProperty(
                "webdriver.chrome.driver",
        		"/Users/dustinsison/eclipse-workspace/Software/chromedriver");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();
        
        // Selects a random page to go to
		String pages[] = new String[] {"","about-me","lavadrop","category/personal-log","category/projects-log"};
		
		Random rand = new Random();
		
		int randomIndex = rand.nextInt(pages.length);
        
        // Go to the page
		webDriver.navigate().to("https://dustinsison.com/" + pages[randomIndex]);
		
		System.out.println("Opened Chrome browser to dustinsison.com/" + pages[randomIndex]);
	}
	
	@When("^user clicks \"(.*)\" navigation link")
	public void user_clicks_nav_link(String nav) throws Throwable {
		
		// Gives a second for the navigation menu to load
		Thread.sleep(1000);
		
	    // Select listed navigation link
	    webDriver.findElement(By.xpath("//ul[@id='primary-menu']/li/a[normalize-space(text())='"+nav+"']")).click();
	        
	    System.out.println("- Clicked " + nav + " navigation link");
	}
	
	@Then("^user should see \"(.*)\" header")
	public void user_should_see_page_header(String header) throws Throwable {
        if (testHeader(header)) {
            System.out.println("Verified on " + header);
        } else {
            System.out.println("Failed; Not on " + header + " page");
        }
	}
	
	@When("^user hovers over \"(.*)\" navigation link")
	public void user_hovers_over_n_navigation_link(String subnav) throws Throwable {
		
		// Moves mouse over navigation link to open submenu
		
			// Instantiate Action Class
			Actions actions = new Actions(webDriver);
			
			// Finds navigation link to hover over
			WebElement menuSub = webDriver.findElement(By.id("menu-item-75"));
			
			// Hovers over selected navigation link
			actions.moveToElement(menuSub).perform();
			
			// Gives a second for the submenu to load
			Thread.sleep(1000);
		
	}
	
	@When("^user clicks \"(.*)\" subnavigation link")
	public void user_clicks_subnav_link(String subnav) throws Throwable {
	    // Select listed navigation link
	    webDriver.findElement(By.id("menu-item-28")).click();
	}
	
	@And("^navigation menu test browser will close")
	public void user_sees_browser_close() throws Throwable {
        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
	}
	
	private static boolean testHeader(String header) {
        // Check whether the h1 equals passed variable
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
}
