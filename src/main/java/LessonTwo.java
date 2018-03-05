import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 24.02.2018.
 */
public class LessonTwo {

    private static final String URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String LOGIN = "webinar.test@gmail.com";
    private static final String PASSWORD = "Xcg7299bnSmMuRLp9ITw";
    private static WebDriver driver = initCromeDriver();

    public static void main(String[] args) {
        scriptA();
        scriptB();
    }

    private static WebDriver initCromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);

    }

    private static void waitMethod() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void authorization() {
        driver.get(URL);
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys(LOGIN);
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys(PASSWORD);
        WebElement signIn = driver.findElement(By.name("submitLogin"));
        signIn.click();
    }

    private static void scriptA() {
        authorization();
        waitMethod();
        WebElement pictogramma = driver.findElement(By.className("employee_avatar_small"));
        pictogramma.click();
        WebElement logOut = driver.findElement(By.id("header_logout"));
        logOut.click();
    }

    private static void scriptB() {
        authorization();
        waitMethod();
        By[] listLocators = {By.id("tab-AdminDashboard"), By.id("subtab-AdminParentOrders"),
                By.id("subtab-AdminCatalog"), By.linkText("Служба поддержки"),
                By.linkText("Клиенты"), By.id("subtab-AdminStats"), By.id("subtab-AdminParentModulesSf"),
                By.linkText("Design"), By.id("subtab-AdminParentShipping"),
                By.id("subtab-AdminParentPayment"), By.id("subtab-AdminInternational"),
                By.id("subtab-ShopParameters"), By.id("subtab-AdminAdvancedParameters")};

        for (By listLocator : listLocators) {
            WebElement element = driver.findElement(listLocator);
            element.click();
            String beforeRefresh = driver.findElement(By.tagName("h2")).getText();
            System.out.println("Before refresh: " + beforeRefresh);
            driver.navigate().refresh();
            String afterRefresh = driver.findElement(By.tagName("h2")).getText();

            if (beforeRefresh.equals(afterRefresh)) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
            }
        }
        waitMethod();
        WebElement pictogramma = driver.findElement(By.className("employee_avatar_small"));
        pictogramma.click();
        WebElement logOut = driver.findElement(By.id("header_logout"));
        logOut.click();
        driver.quit();
    }
}

