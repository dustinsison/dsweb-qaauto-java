import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    static WebDriver webDriver;
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {
        // Local location of the ChromeDriver. Update the path to match your machine as needed.
        System.setProperty(
                "webdriver.chrome.driver",
        		"/Users/dustinsison/eclipse-workspace/Software/chromedriver");
        
        // Logging start of test
        System.out.println("Starting dustinsison Login Test for Subscriber-level QA Account...");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        // Maximize the browser window
        webDriver.manage().window().maximize();

        if (testDSSitelogin()) {
            System.out.println("dustinsison.com Login Test: Passed");
        } else {
            System.out.println("dustinsison.com Login Test: Failed");

        }

        // Close the browser and WebDriver
        webDriver.close();
        webDriver.quit();
    }

    private static boolean testDSSitelogin() {
        try {
            // Open the dustinsison.com login page
            webDriver.navigate().to("https://dustinsison.com/wp-login.php");
            
            System.out.println("- Opened website");
            
            // Select to log in using username/password
            webDriver.findElement(By.cssSelector("#jetpack-sso-wrap .jetpack-sso-toggle.wpcom")).click();
            
            System.out.println("- Clicked username/password login link");

            // Type the QA username
            webDriver.findElement(By.id("user_login")).sendKeys("qa_user");
            
            System.out.println("- Entered username");

            // Type the QA password
            webDriver.findElement(By.id("user_pass")).sendKeys("l85FE0CZ$R#biQpR)SI&N6$5");
            
            System.out.println("- Entered password");

            // Click the Submit button
            webDriver.findElement(By.id("wp-submit")).click();
            
            System.out.println("- Clicked Submit");

            // Check whether the h1 equals “Profile”
            if (webDriver.findElement(By.tagName("h1")).getText()
                    .equals("Profile")) {
            	String result = webDriver.findElement(By.tagName("h1")).getText();
            	System.out.println("- Current page: " + result);
            	
                return true;
            } else {
            	String result = webDriver.findElement(By.tagName("h1")).getText();
            	System.out.println("- Current page: " + result);
                return false;
            }

        // Any errors results in return false
        } catch (final Exception e) {
            System.out.println(e.getClass().toString());
            return false;
        }
    }
}