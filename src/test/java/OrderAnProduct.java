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
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.get("http://automationpractice.com/index.php?controller=order");
        driver.navigate().refresh();

//        Assets Total for Product
        WebElement totalForProduct = driver.findElement(By.id("total_product_price_2_7_0"));
        String actualTotalForProduct = totalForProduct.getText();
        System.out.println("actualTotalForProduct: " + actualTotalForProduct);

        String expectedTotalForProduct = "$54.00";
        System.out.println("expectedTotalForProduct: " + expectedTotalForProduct);

        Assert.assertEquals(actualTotalForProduct, expectedTotalForProduct);

//        Assets Total products
        WebElement totalProducts = driver.findElement(By.xpath("//*[@id=\'total_product\']"));
        String actualTotalResults = totalProducts.getText();
        System.out.println("actualTotalResults: " + actualTotalResults);

        String expectedTotalResults = "$54.00";
        System.out.println("expectedTotalResults:" + expectedTotalResults);

        Assert.assertEquals(actualTotalResults,expectedTotalResults);

//        Assets Total Shipping
        WebElement totalShipping = driver.findElement(By.id("total_shipping"));
        String actualTotalShipping = totalShipping.getText();
        System.out.println("actualTotalShipping: " + actualTotalShipping);

        String expectedTotalShipping = "$2.00";
        System.out.println("expectedTotalShipping:" + expectedTotalShipping);

        Assert.assertEquals(actualTotalShipping, expectedTotalShipping);

//        Assets Total Price without Tax
        WebElement totalWithoutTax = driver.findElement(By.id("total_price_without_tax"));
        String actualTotalWithoutPrice = totalWithoutTax.getText();
        System.out.println("actualTotalWithoutPrice: " + actualTotalWithoutPrice);

        String expectedTotalWithoutPrice = "$56.00";
        System.out.println("expectedTotalWithoutPrice: " + expectedTotalWithoutPrice);

        Assert.assertEquals(actualTotalWithoutPrice, expectedTotalWithoutPrice);

//        Assets Tax
        WebElement tax = driver.findElement(By.id("total_tax"));
        String actualTax = tax.getText();
        System.out.println("actualTax: " + actualTax);

        String expectedTax = "$0.00";
        System.out.println("expectedTax: " + expectedTax);

        Assert.assertEquals(actualTax, expectedTax);

//        Assets TOTAL
        WebElement total = driver.findElement(By.id("total_price"));
        String actualTotal = total.getText();
        System.out.println("actualTotal: " + actualTotal);

        String expectedTotal = "$56.00";
        System.out.println("expectedTotal: " + expectedTotal);

        Assert.assertEquals(actualTotal, expectedTotal);

//        Remove products
        driver.findElement(By.id("2_7_0_0")).click();

//        Asset for Empty Cart
        WebElement emptyCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/p")));

        String actualEmptyCart = emptyCart.getText();
        System.out.println("actual text on the page: " + actualEmptyCart);

        String expectedEmptyCart = "Your shopping cart is empty.";
        System.out.println("expected text on the page: " + expectedEmptyCart);

        Assert.assertEquals(actualEmptyCart, expectedEmptyCart);






    }
}