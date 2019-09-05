# dsweb-qaautomation
Automated tests for dustinsison.com

### Update Log:
[Aug 30, 2019] - Added Footer step definitions, additional comments, and test steps to test homepage video.

[Aug 28, 2019] - Added Blog, Projects, and Navigation Menu step definitions.

[Aug 27, 2019] - Added Account and Homepage step definitions.

[Aug 23, 2019] - Added cucumber files.

[Aug 22, 2019] - Initial commit. Added login test for basic subscriber account.

### Description:
This repository contains automated tests written in Java, to test the WordPress site, dustinsison.com.

### Setup:
To run these tests, you'll need the following:

- ChromeDriver*: https://chromedriver.chromium.org/downloads
- Java Environment* (I suggest Eclipse): https://www.eclipse.org/downloads/eclipse-packages/?show_instructions=TRUE
- Selenium WebDriver (Java): http://www.seleniumhq.org/download/
- Cucumber-Java: https://mvnrepository.com/artifact/info.cukes/cucumber-java/1.2.5

 *Download the version appropriate to your operating system, the steps will remain the same across Windows/OSX
 
### Installation Steps:
##### (Steps assume you are using Eclipse IDE)
1. Download all software/dependencies listed in the Setup section (relative to your operating system).
2. Download this GitHub Repository to your local device.
3. Import the project into your IDE.
4. Add Selenium / Cucumber .jar files to the project's libraries (Right-click project folder in Package Explorer > Properties > Java Build Path > Add External JARs)
5. Edit the "System.setProperty" file path to point to the location of ChromeDriver on your local device on each .java file under src/StepDefinition/
6. Run the entire test under src/TestRunner/Runner.java or run individual feature tests under /Features

### Available Tests:

- Account pages (Subscriber-level account)
- Blog pages
- Footer
- Homepage
- Navigation Menu
- Project pages

### Coming Soon:

Trello Board available here: https://trello.com/b/buBWl99d/dustinsisoncom-qa-automation

### Credits:
Dustin Sison

Article used for initial set up:
https://www.smashingmagazine.com/2018/04/feature-testing-selenium-webdriver/
