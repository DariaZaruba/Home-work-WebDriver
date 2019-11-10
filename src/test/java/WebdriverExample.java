import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverExample {
    @Test
    public void runDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\spdguest\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
//        driver.close();
    }

}
