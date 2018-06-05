import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public class autotest {
    public static void main(String[] args) throws InterruptedException {
        facebookNotification();
        gmail();

    }

    public static void facebookNotification(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("******@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("******");
        driver.findElement(By.id("loginbutton")).click();
        System.out.println(driver.findElement(By.id("notificationsCountValue")).getText());

    }

    public static void gmail(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.gmail.com");
        //checking if url is of new then use if code otherwise else code.
        if(driver.getCurrentUrl().contains("https://accounts.google.com/signin/v2/identifier?")){
            driver.findElement(By.id("identifierId")).sendKeys("******@gmail.com");
            driver.findElement(By.id("identifierNext")).click();

            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
            driver.findElement(By.name("password")).sendKeys("******");
            driver.findElement(By.id("passwordNext")).click();
        }
        else{
            driver.findElement(By.name("Email")).sendKeys("******@gmail.com");
            driver.findElement(By.id("next")).click();
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Passwd")));
            driver.findElement(By.name("Passwd")).sendKeys("******");
            driver.findElement(By.name("signIn")).click();
        }


    }
}