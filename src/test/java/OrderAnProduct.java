import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//        1. Открыть главную страницу automationpractice.com
//        2. В поле поиска ввести “Blouse” и выполнить поиск
//        3. Переключится на режим просмотра ‘List”
//        4. Добавить товар в корзину
//        5. В секции Summary увеличить количество товаров на 1
//        6. Проверить что значения Total для товара , Total products,
//        Total shipping , Total всех товаров , Tax и TOTAL общий отображается корректно
//        7. Удалить товар из корзины
//        8. Проверить что корзина пустая

public class OrderAnProduct {

    @Test
    public void runDriver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\spdguest\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");

        //Going to Search Field
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("Blouse");

//        Choose Blouse
        driver.findElement(By.cssSelector("#search_block_top button")).click();

//        Choose List
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement listMode = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-th-list")));
        listMode.click();


//        Add to cart
        driver.findElement(By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default")).click();

//        Proceed to Checkout
        WebElement proccedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default.button.button-medium")));
        proccedToCheckout.click();

//        driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium")).click();

//        Qty +
        driver.findElement(By.id("cart_quantity_up_2_7_0_0")).click();

//        Assets
//        Assets Total products
//        WebElement totalProducts = driver.findElement(By.xpath("//*[@id=\'total_product\']"));
//        WebElement totalProducts1 = wait.until(ExpectedConditions.refreshed(totalProducts.));
        WebElement totalProducts = driver.findElement(By.xpath("//*[@id=\'total_product\']"));
        String actualTotalResults = totalProducts.getText();
        System.out.println("actualTotalResults: " + actualTotalResults);

        String expectedTotalResults = "$54.00";
        System.out.println("expectedTotalResults:" + expectedTotalResults);
        Assert.assertEquals(actualTotalResults,expectedTotalResults);









//        //        6. Проверить что значения Total для товара , Total products,
////        Total shipping , Total всех товаров , Tax и TOTAL общий отображается корректно

//        WebElement alertBlock = driver.findElement(By.cssSelector(".alert.alert-danger"));
//
//        String expectedResult = "There are 3 errors";
//        String actualResult = alertBlock.getText();
//        System.out.println(actualResult);
//        Assert.assertTrue(actualResult.contains(expectedResult));



    }
}