import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.UUID;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Sign_in {

//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\spdguest\\WebDriver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }

    @Test
    public void runDriver() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\spdguest\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");

//        Going to Sing In
        driver.findElement(By.cssSelector(".header_user_info a")).click();

//        Work with Email
        final String randomEmail = randomEmail();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement emailAdr = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));
        emailAdr.click();
        emailAdr.sendKeys(randomEmail);

//        Submit Create
        driver.findElement(By.id("SubmitCreate")).click();

//        First Name
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));
        firstName.sendKeys("Dariia");

//        Last Name
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Zaruba");

//        Email
        WebElement emailOnForm = driver.findElement(By.id("email"));
        emailOnForm.sendKeys(randomEmail);

//        Password
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("password");

//        Address
//        Add First Name
        WebElement addFirstName = driver.findElement(By.id("firstname"));
        addFirstName.sendKeys("Dariia");

//        Add Last Name
        WebElement addLastName = driver.findElement(By.id("lastname"));
        addLastName.sendKeys("Zaruba");

//        Address
        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("173 Elizavety Chavdar str");

//        City
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Kyiv");

//        Postal Code
        WebElement postalCode = driver.findElement(By.id("postcode"));
        password.sendKeys("03150");

//        Mobile Phone
        WebElement mobile = driver.findElement(By.id("phone_mobile"));
        mobile.sendKeys("800500500");

//        Alias Address
        WebElement alias = driver.findElement(By.id("alias"));
        alias.sendKeys("Alias Address");

//        Register button
        driver.findElement(By.id("submitAccount")).click();

        WebElement alertBlock = driver.findElement(By.cssSelector(".alert.alert-danger"));

        String expectedResult = "There are 3 errors";
        String actualResult = alertBlock.getText();
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
}



