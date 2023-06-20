package browserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String browser = "Edge";
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver=new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver=new FirefoxDriver();

        }
        else {
            System.out.println("Its a wrong browser name");
        }
        driver.get(baseUrl);
        //Maximising the window
        driver.manage().window().maximize();
        //Giving implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Getting the title of page
        System.out.println("title of page :" + driver.getTitle());
        //Getting the current URL of page
        System.out.println("Current URL is: " + driver.getCurrentUrl());
        //Getting the source code of file
        System.out.println("The source code of page is: " + driver.getPageSource());
        //Entering the Email in Email field
        WebElement webElement = driver.findElement(By.name("Email"));
        webElement.sendKeys("123@gmail.com");
        //Entering the password in password field
        driver.findElement(By.id("Password")).sendKeys("123#psw");
        //Closing the browser
        driver.close();
    }
}
