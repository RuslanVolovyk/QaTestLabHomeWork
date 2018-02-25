import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;
import static javax.swing.text.html.CSS.getAttribute;

/**
 * Created by Администратор on 24.02.2018.
 */
public class Main {
    public static void main(String[] args) {
       scriptA();

    }
    private static WebDriver initCromeDriver () {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);

    }
    private static Thread  waitmethod(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void scriptA (){
        WebDriver driver = initCromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("webinar.test@gmail.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement signIn = driver.findElement(By.name("submitLogin"));
        signIn.click();
        waitmethod();
        WebElement pictogramma = driver.findElement(By.className("employee_avatar_small"));
        pictogramma.click();
        WebElement logOut = driver.findElement(By.id("header_logout"));
        logOut.click();
        waitmethod();
        driver.close();
    }

    public static void scriptB (){


    }

}
