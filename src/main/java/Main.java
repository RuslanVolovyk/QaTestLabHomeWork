import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Администратор on 24.02.2018.
 */
public class Main {

    public static final String URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    public static final String LOGIN = "webinar.test@gmail.com";
    public static final String PASSWORD = "Xcg7299bnSmMuRLp9ITw";

    public static void main(String[] args) {
        scriptA();
       // scriptB();
    }

    private static WebDriver initCromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);

    }

    private static Thread waitMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void scriptA() {
        WebDriver driver = initCromeDriver();
        driver.get(URL);
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys(LOGIN);
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys(PASSWORD);
        WebElement signIn = driver.findElement(By.name("submitLogin"));
        signIn.click();
        waitMethod();
        WebElement pictogramma = driver.findElement(By.className("employee_avatar_small"));
        pictogramma.click();
        WebElement logOut = driver.findElement(By.id("header_logout"));
        logOut.click();
        driver.close();
    }

    private static void scriptB() {
        WebDriver driver = initCromeDriver();
        driver.get(URL);
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys(LOGIN);
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys(PASSWORD);
        WebElement signIn = driver.findElement(By.name("submitLogin"));
        signIn.click();
        waitMethod();

//        List<WebElement> listElements = driver.findElements(By.className("maintab has_submenu"));
//        System.out.println(listElements);
//        Если я правильно все написал, в данном случае должен вернутся спиок элементов. Где я ошибся?

        By[] listLocators = {By.id("tab-AdminDashboard"), By.id("subtab-AdminParentOrders"), By.id("subtab-AdminCatalog"),
                By.linkText("Служба поддержки"), By.linkText("Клиенты"),
                By.id("subtab-AdminStats"), By.id("subtab-AdminParentModulesSf"), By.linkText("Design"),
                By.id("subtab-AdminParentShipping"), By.id("subtab-AdminParentPayment"), By.id("subtab-AdminInternational"),
                By.id("subtab-ShopParameters"), By.id("subtab-AdminAdvancedParameters")};

        for (int i = 0; i < listLocators.length; i++) {
            WebElement element = driver.findElement(listLocators[i]);
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

