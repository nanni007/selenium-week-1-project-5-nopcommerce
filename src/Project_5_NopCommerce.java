import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Project_5_NopCommerce {
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;
    static String browser = "Chrome";

    public static void main(String[] args) throws InterruptedException {
        //using if else method for user to choose the browser
        if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Enter Correct browser name.");
        }
        driver.get(baseUrl);  //opening the Url
        driver.manage().window().maximize();  //maximising the browser window
        Thread.sleep(2000);
        System.out.println("Title of page is: " + driver.getTitle());  //getting the title of the page
        System.out.println( "Current Url of homepage is: " + driver.getCurrentUrl());  //printing the current Url
        System.out.println("Page source is: " + driver.getPageSource());  //printing the page source
        String signinUrl = "https://demo.nopcommerce.com/login?returnUrl=";  // assigning the url
        driver.navigate().to(signinUrl); //navigating to the url
        System.out.println("Current Sign in Url is:" + driver.getCurrentUrl()); //printing the current url
        Thread.sleep(2000);
        driver.navigate().back(); //navigating back to the homepage
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        Thread.sleep(2000);
        driver.navigate().forward(); //navigating to the login page again using forward
        System.out.println("Current page Url is: " + driver.getCurrentUrl()); //printing the current Url
        Thread.sleep(2000);
        driver.navigate().refresh(); //refreshing the page
        WebElement emailField = driver.findElement(By.name("Email"));//entering the email in the email field
        emailField.sendKeys("admin123@gmail.com");
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.name("Password"));//entering the password in the password field
        passwordField.sendKeys("admin123");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.className("login-button"));//clicking the log in button
        loginButton.click();
        Thread.sleep(2000);
        driver.quit(); //closing the browser
    }
}
